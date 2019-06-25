import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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

/**
 *  帮许威导数据
 * @author cuiyi
 *
 */
public class DataTransAppXY { 
	// private final static Logger log =
	// LoggerFactory.getLogger(DataTransApp.class);
	/**
	 * 帮许威导数据
	 * @param file
	 * @return
	 */
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
		File file = new File("D:\\工商简项1123.xls");
		List<List<String>> list = loadData(file);

		String titleName[] = new String[] { "公司名称", "CONDATE", "COUNTRY", "SUBCONAM", "SHANAME", "INVSUMFUNDEDRATIO",
				"CONFORM", "REGCAPCUR", "SUMCONAM", "INVAMOUNT", "FUNDEDRATIO", // 字段结束
				"ORIREGNO", "ENTSTATUS", "ENTNAMEENG", "REGORGPROVINCE", "OPSCOANDFORM", "INDUSTRYPHYNAME", "ESDATE",
				"REGCAP", "REGORG", "OPFROM", "CBUITEM", "OPTO", "ABUITEM", "REGCAPCUR", "INDUSTRYCOALL",
				"INDUSTRYPHYCODE", "EMPNUM", "REGORGCODE", "CANDATE", "REVDATE", "DOMDISTRICT", "ANCHEDATE",
				"ZSOPSCOPE", "ANCHEYEAR", "CREDITCODE", "FRNAME", "CHANGEDATE", "INDUSTRYPHYALL", "INDUSTRYCOCODE",
				"OPSCOPE", "TEL", "DOM", "ENTTYPE", "RECCAP", "REGNO", "ENTNAME", "INDUSTRYCONAME" };

		int titleSize[] = new int[titleName.length];
		PoiExcelExport.CellType cellType[] = new PoiExcelExport.CellType[titleName.length];
		for (int i = 0; i < titleSize.length; i++) {
			titleSize[i] = 10;
			cellType[i] = PoiExcelExport.CellType.TYPE_STRING;
		}

		List<String[]> dataList = new ArrayList<>();

		for (List<String> dataLinelist : list) {
			int i = 0;
			String[] data = new String[titleName.length];
			LinkedHashMap<String, String> map = new LinkedHashMap<>();
			LinkedHashMap<String, String> map2 = new LinkedHashMap<>();

			if (dataLinelist.get(1) != null && !"".equals(dataLinelist.get(1))) {
				Object object = JsonPath.read(dataLinelist.get(1), "$.ITEM");
				if (object instanceof List<?>) {
					map = ((List<LinkedHashMap>) object).get(0);
				} else {
					map = (LinkedHashMap) object;
				}
			}
			if (dataLinelist.get(11) != null && !"".equals(dataLinelist.get(11))) {
				Object object = JsonPath.read(dataLinelist.get(11), "$.ITEM");
				if (object instanceof List<?>) {
					map2 = ((List<LinkedHashMap>) object).get(0);
				} else {
					map2 = (LinkedHashMap) object;
				}
			}
		
			data = new String[] { dataLinelist.get(0), map.get("CONDATE"), map.get("COUNTRY"), map.get("SUBCONAM"),
					map.get("SHANAME"), map.get("INVSUMFUNDEDRATIO"), map.get("CONFORM"), map.get("REGCAPCUR"),
					map.get("SUMCONAM"), map.get("INVAMOUNT"), map.get("FUNDEDRATIO"), // 字段结束
					map2.get("ORIREGNO"), map2.get("ENTSTATUS"), map2.get("ENTNAMEENG"), map2.get("REGORGPROVINCE"),
					map2.get("OPSCOANDFORM"), map2.get("INDUSTRYPHYNAME"), map2.get("ESDATE"), map2.get("REGCAP"),
					map2.get("REGORG"), map2.get("OPFROM"), map2.get("CBUITEM"), map2.get("OPTO"), map2.get("ABUITEM"),
					map2.get("REGCAPCUR"), map2.get("INDUSTRYCOALL"), map2.get("INDUSTRYPHYCODE"), map2.get("EMPNUM"),
					map2.get("REGORGCODE"), map2.get("CANDATE"), map2.get("REVDATE"), map2.get("DOMDISTRICT"),
					map2.get("ANCHEDATE"), map2.get("ZSOPSCOPE"), map2.get("ANCHEYEAR"), map2.get("CREDITCODE"),
					map2.get("FRNAME"), map2.get("CHANGEDATE"), map2.get("INDUSTRYPHYALL"), map2.get("INDUSTRYCOCODE"),
					map2.get("OPSCOPE"), map2.get("TEL"), map2.get("DOM"), map2.get("ENTTYPE"), map2.get("RECCAP"),
					map2.get("REGNO"), map2.get("ENTNAME"), map2.get("INDUSTRYCONAME") };
			dataList.add(data);
		}

		PoiExcelExport pee = new PoiExcelExport("E:/test.xls", "sheet1");
		pee.wirteExcel(titleName, cellType, titleSize, dataList);
	}

	public static List<Map<String, String>> resoObject(Object Object) {
		List<Map<String, String>> dataMapList = new ArrayList<>();

		List<Object> dataList = new LinkedList<Object>();
		if (Object instanceof List<?>) {
			dataList.addAll((List<Object>) Object);
		} else {
			dataList.add(Object);
		}
		int size = dataList.size();
		for (int i = 0; i < size; i++) {
			// System.out.println(dataList.get(i));
			LinkedHashMap<String, String> map = (LinkedHashMap) dataList.get(i);
			dataMapList.add(map);
			// Set<Entry<String, String>> set = map.entrySet();
			// String suffix = i == 0 ? "" : i + "";
			// for (Iterator iterator = set.iterator(); iterator.hasNext();) {
			// Entry<String, String> entry = (Entry<String, String>) iterator.next();
			// dataMap.put(entry.getKey() + suffix, entry.getValue());
			// }
		}
		return dataMapList;
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
