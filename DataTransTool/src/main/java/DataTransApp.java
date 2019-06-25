import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 通过excel导出贷款数据
 * @author cuiyi
 *
 */
public class DataTransApp {

	// private final static Logger log =
	// LoggerFactory.getLogger(DataTransApp.class);

	private static String inputDir = "E:/00.个人目录/贷款用户/batch1-result/";// 指定程序执行结果保存的文件路径
	private static String outPutDir = "E:/00.个人目录/贷款用户/batch1-result(extrep)/";// 指定程序执行结果保存的文件路径
	private static String logFileDir = "E:/00.个人目录/贷款用户/batch1-result(extrep)/";// 指定程序执行结果保存的文件路径

	public static List<ExcelSheet> loadExcelSheet(File file) {
		ExcelReader poi = new ExcelReader();
		List<ExcelSheet> list = poi.read(file.getAbsolutePath());
		writemsg(" 读取成功 共:" + list.size() + "个表格页");
		return list;
	}

	public static List<String> loadExcelData(File file) {

		List<String> dataList = new ArrayList<String>();
		List<String> sheetDataList = new ArrayList<String>();
		List<ExcelSheet> excelList = loadExcelSheet(file);
		for (ExcelSheet excelSheet : excelList) {
			sheetDataList = new ArrayList<String>();
			StringBuffer sheetmsg = new StringBuffer(String.format("\t正在解析第%s个表格,表格名称：%s,共%s条数据,",
					(excelSheet.getIndex() + 1) + "", excelSheet.getName(), excelSheet.getData().size() + ""));

			List<List<String>> tempSheetDataList = excelSheet.getData();

			for (int i = 0; i < tempSheetDataList.size(); i++) {
				List<String> cellList = tempSheetDataList.get(i);
				StringBuffer sb = new StringBuffer("");
				for (int j = 0; j < cellList.size(); j++) {
					sb.append(" " + cellList.get(j));
				}
				String dataLine = sb.toString().trim();
				if (dataLine.length() > 0) {
					sheetDataList.add(dataLine);
				}
			}
			sheetmsg.append(" 其中非空数据：" + sheetDataList.size() + "条");
			writemsg(sheetmsg.toString());
			dataList.addAll(sheetDataList);
		}

		return dataList;
	}

	public static List<String> loadTxtData(File file) {

		List<String> dataList = new ArrayList<String>();
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = null;
			while ((line = br.readLine()) != null) {
				line = line.trim();
				dataList.add(line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return dataList;
	}

	public static void initDir(String path) {

		File file = new File(path);
		if (!file.exists()) {
			file.mkdirs();
		}

	}

	public static List<String> loadData(File file) {

		writemsg("正在读文件：" + file.getName());
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		List<String> dataList = new ArrayList<String>();
		if (suffix.equals("xls") || suffix.equals("xlsx")|| suffix.equals("xlt")) {
			dataList = loadExcelData(file);
		}
		if (suffix.equals("txt") || suffix.equals("csv")) {
			dataList = loadTxtData(file);
		}
		return dataList;
	}

	public static void main(String[] args) throws IOException {
		initDir(logFileDir);
		initDir(outPutDir);

		Set<String> phoneSet = new HashSet<String>();
		
		List<File> tAllfiles = FileTools.ls("E:\\00.个人目录\\贷款用户\\batch1-result(err)\\", true);
		List<File> tfiles = new ArrayList<File>();

		for (File file : tAllfiles) {
			if (file.isDirectory()) {
				continue;
			}
			tfiles.add(file);
		}
	
		for (File file : tfiles) {
			
			Map<String,Object> evalMap= loadPhoneNumList(file, phoneSet);
			List<String> phoneNumList = (List<String>)evalMap.get("avliableList");
			
			for (String string : phoneNumList) {
				phoneSet.add(string);
			}
		}
		
		System.out.println(phoneSet.size());
		
		
		List<File> Allfiles = FileTools.ls(inputDir, true);
		List<File> files = new ArrayList<File>();

		for (File file : Allfiles) {
			if (file.isDirectory()) {
				continue;
			}
			files.add(file);
		}
	 
		
		int phoneIndex = 0;
		int fileSplitSize = 10000;
		int fileSplit = 0;
		int fileLineStart = 0;
		int fileLineEnd = 0;
		int fileSize = files.size();
		writemsg("共读取到" + fileSize + "个文件"+"\r\n");
		/**
		 * 数据行数
		 */
		int dataSize=0;
		/**
		 * 有效电话数
		 */
		int checkedSize = 0;
		/**
		 * 重复数
		 */
		int repeatSize = 0;
		/**
		 * 可用电话数
		 */
		int avliableSize = 0;
		
		FileWriter fw = null;
		BufferedWriter bw = null;
		String curfileName = null;
		File loanFile = null;
		for (File file : files) {
			Map<String,Object> evalMap= loadPhoneNumList(file, phoneSet);
			List<String> phoneNumList = (List<String>)evalMap.get("avliableList");
			
			dataSize=dataSize+(int)evalMap.get("dataSize");
			checkedSize=checkedSize+(int)evalMap.get("checkedSize");
			repeatSize=repeatSize+(int)evalMap.get("repeatSize");
			avliableSize=avliableSize+(int)evalMap.get("avliableSize");
			
			Map<String, int[]> fileMap = new LinkedHashMap<String, int[]>();
			fileLineStart = fileLineEnd+1;
			for (String phone : phoneNumList) {

				if (phoneIndex % fileSplitSize == 0) {
					if (bw != null) {
						bw.flush();
						bw.close();
						fileMap.put(loanFile.getName(), new int[] { fileLineStart, fileLineEnd });
					}
					fileSplit = phoneIndex / fileSplitSize;
					curfileName = outPutDir + "loan_phone_" + fileSplit + ".txt";
					loanFile = new File(curfileName);
					fw = new FileWriter(loanFile);
					bw = new BufferedWriter(fw);
					fileLineStart = 0;
					fileLineEnd = 0;
				}

				bw.write(phone + "\r\n");

				fileLineEnd++;
				phoneIndex++;
			}
			if(phoneNumList.size()>0) {
				fileMap.put(loanFile.getName(), new int[] { fileLineStart + 1, fileLineEnd });
				for (Iterator iterator = fileMap.keySet().iterator(); iterator.hasNext();) {
					String fileName = (String) iterator.next();
					int[] fileCountSign = fileMap.get(fileName);
					writemsg(String.format("已写至文件%s,第%s行-第%s行.", fileName, (fileCountSign[0]) + "",
							fileCountSign[1] + ""));

				}
			}
			
			
			writemsg("");
		}
		if (bw != null) {
			bw.flush();
			bw.close();

		}
		writemsg(String.format("总文件数：%s,共读取数据行:%s,有效电话数:%s, 重复号码数:%s，可用号码数：%s",fileSize,dataSize,checkedSize,repeatSize,avliableSize));

	}

	private static OutputStream out = null;

	public static OutputStream getOutputStream() throws IOException {
		if (out == null) {
			File file = new File(logFileDir + "/" + "汇总信息.txt");
			if (!file.exists())
				file.createNewFile();
			out = new FileOutputStream(file, false);
		}
		return out;
	}

	public static void log(String info) throws IOException {
		OutputStream out = getOutputStream();
		System.out.println(info);
		info = info + "\r\n";
		out.write(info.getBytes("utf-8"));
		out.flush();
	}

	public static Map<String,Object> loadPhoneNumList(File file, Set<String> phoneSet) {
		String regEx = "[^0-9]";
		String phoneReg = "^1\\d{10}$";
		// String phoneReg =
		// "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";

		Pattern p = Pattern.compile(regEx);
		Pattern p2 = Pattern.compile(phoneReg);
		List<String> dataList = loadData(file);
		/**
		 * 数据行数
		 */
		int dataSize=dataList.size();
		/**
		 * 有效电话数
		 */
		int checkedSize = 0;
		/**
		 * 重复数
		 */
		int repeatSize = 0;
		/**
		 * 可用电话数
		 */
		int avliableSize = 0;
		
		StringBuffer sbmsg = new StringBuffer("共读取非空行数：" + dataSize + "行,");
		List<String> phoneNumList = new ArrayList<String>();
		List<String> avliableList = new ArrayList<String>();
		for (String dataline : dataList) {
			Matcher m = p.matcher(dataline);
			String numberLine = m.replaceAll(",").trim();
			String[] numberargs = numberLine.split(",");
			for (String number : numberargs) {
				if (number == null || number.trim().equals("")) {
					continue;
				}
				number = number.trim();
				Matcher m2 = p2.matcher(number);
				if (m2.matches()) {
					phoneNumList.add(number);
				}
			}
		}
		 checkedSize = phoneNumList.size();
		sbmsg.append("有效电话号码数：" + checkedSize + "个,");
		
		for (String phoneNum : phoneNumList) {

			if (phoneSet.contains(phoneNum)) {
				repeatSize++;
			} else {
				avliableSize++;
				phoneSet.add(phoneNum);
				avliableList.add(phoneNum);
			}

		}
		sbmsg.append("可用电话号码数：" + avliableSize + "个,");
		sbmsg.append("重复电话号码数：" + repeatSize + "个");
		writemsg(sbmsg.toString());
		HashMap<String, Object> map = new HashMap<>();
		
		
		map.put("dataSize", dataSize);
		map.put("checkedSize", checkedSize);
		map.put("repeatSize", repeatSize);
		map.put("avliableSize", avliableSize);
		map.put("avliableList", avliableList);
		return map;
	}

	private static void writemsg(String msg) {
		try {
			log(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
