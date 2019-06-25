import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.jayway.jsonpath.JsonPath;

public class DataTransAppSYX {

	// private final static Logger log =
	// LoggerFactory.getLogger(DataTransApp.class);

	public static List<ExcelSheet> loadExcelSheet(File file) {
		ExcelReader poi = new ExcelReader();
		List<ExcelSheet> list = poi.read(file.getAbsolutePath());
		writemsg(" 读取成功 共:" + list.size() + "个表格页");
		return list;
	}

	public static List<List<String>> loadExcelData(File file) {

		List<List<String>> dataList = new ArrayList<List<String>>();
		List<String> sheetDataList = new ArrayList<String>();
		List<ExcelSheet> excelList = loadExcelSheet(file);
		for (ExcelSheet excelSheet : excelList) {
			sheetDataList = new ArrayList<String>();
			StringBuffer sheetmsg = new StringBuffer(String.format("\t正在解析第%s个表格,表格名称：%s,共%s条数据,",
					(excelSheet.getIndex() + 1) + "", excelSheet.getName(), excelSheet.getData().size() + ""));

			List<List<String>> tempSheetDataList = excelSheet.getData();

			dataList.addAll(tempSheetDataList);

		}

		return dataList;
	}

	public static List<List<String>> loadData(File file) {

		writemsg("正在读文件：" + file.getName());
		String fileName = file.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
		List<List<String>> dataList = new ArrayList<List<String>>();
		if (suffix.equals("xls") || suffix.equals("xlsx") || suffix.equals("xlt")) {
			dataList = loadExcelData(file);
		}

		return dataList;
	}

	public static void main(String[] args) throws IOException {
		File file = new File("E:\\syx\\temp\\3.3.xlsx");
		List<List<String>> list = loadData(file);
		String filepath1 = "E:\\syx\\temp\\1-网络借贷中介服务协议（最高额度）-V1.1（20190506） - temp.docx";
		String targetPath="E:\\syx\\target\\0520-3\\";
		String destpath1 = null;//"E:\\syx\\target\\1-借款合同（借款企业vs代偿方）.docx";
//		String filepath2 = "E:\\syx\\temp\\1-借款合同-附件（委托付款函）.docx";
//		String destpath2 = "E:\\syx\\target\\1-借款合同-附件（委托付款函）.docx";
		list.remove(0);
		int i = 0;
		for (List<String> list2 : list) {
			i++;
			Map<String, String> map = new HashMap<String, String>();
			String productId = list2.get(0);
			String productName = list2.get(2);
			String legalPerson = list2.get(3);
			String legalPersonID = list2.get(4);
			String outMoney = list2.get(5);
//			String outMoneyUpper = NumberToCN.number2CNMontrayUnit(new BigDecimal(list2.get(5).trim()));
			String signDate = list2.get(9);
			String start1= list2.get(16).replace(".0", "");
			String start2 = list2.get(17).replace(".0", "");
			String start3 = list2.get(18).replace(".0", "");
			String end1= list2.get(19).replace(".0", "");
			String end2 = list2.get(20).replace(".0", "");
			String end3 = list2.get(21).replace(".0", "");
			// System.out.println(String.format("%s,%s,%s,%s,%s,%s,%s",
			// productId,productName,legalPerson,legalPersonID,outMoney,outMoneyUpper,signDate));
			map.put("PRODUCTID", productId);
			map.put("PRODUCTNAME", productName);
			map.put("LEGALPERSON", legalPerson);
			map.put("LEGALPERSONID", legalPersonID);
			map.put("OUTMONEY", outMoney);
//			map.put("OUTMONEYUPPER", outMoneyUpper);
			map.put("SIGNDATE", signDate);

			map.put("STARTYEAR", start1);
			map.put("STARTMONTH", start2);
			map.put("STARTDATE", start3);

			map.put("ENDYEAR", end1);
			map.put("ENDMONTH", end2);
			map.put("ENDDATE", end3);
			String No = StrKit.padPre(i + "", 3, '0');

			destpath1 = targetPath+"(" + No + ")("+legalPerson+") 授信文件.docx";
//			destpath2 = "E:\\syx\\target\\(" + No + ")借款合同-附件（委托付款函）(" + productName + ").docx";

			WordPOI.replaceAndGenerateWord(filepath1, destpath1, map);
//			WordPOI.replaceAndGenerateWord(filepath2, destpath2, map);
//			break;
		}

	}

	private static OutputStream out = null;

	public static OutputStream getOutputStream() throws IOException {
		if (out == null) {
			File file = new File("汇总信息.txt");
			if (!file.exists())
				file.createNewFile();
			out = new FileOutputStream(file, true);
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

	private static void writemsg(String msg) {
		try {
			log(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
