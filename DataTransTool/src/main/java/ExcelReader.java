import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 * @描述：测试excel读取
 * 
 * 				导入的jar包
 * 
 *               poi-3.8-beta3-20110606.jar
 * 
 *               poi-ooxml-3.8-beta3-20110606.jar
 * 
 *               poi-examples-3.8-beta3-20110606.jar
 * 
 *               poi-excelant-3.8-beta3-20110606.jar
 * 
 *               poi-ooxml-schemas-3.8-beta3-20110606.jar
 * 
 *               poi-scratchpad-3.8-beta3-20110606.jar
 * 
 *               xmlbeans-2.3.0.jar
 * 
 *               dom4j-1.6.1.jar
 * 
 *               jar包官网下载地址：http://poi.apache.org/download.html
 * 
 *               下载poi-bin-3.8-beta3-20110606.zipp
 * 
 */

public class ExcelReader {
//	/** 总行数 */
//	private int totalRows = 0;
//	/** 总列数 */
//	private int totalCells = 0;
	/** 错误信息 */
	private String errorInfo;

	/** 构造方法 */
	public ExcelReader() {
	}

//	public int getTotalRows() {
//		return totalRows;
//	}
//
//	public int getTotalCells() {
//		return totalCells;
//	}

	public String getErrorInfo() {
		return errorInfo;
	}

	public boolean validateExcel(String filePath) {
		/** 检查文件名是否为空或者是否是Excel格式的文件 */
		if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath)|| WDWUtil.isExcelTEMP(filePath))) {
			errorInfo = "文件名不是excel格式";
			return false;
		}
		/** 检查文件是否存在 */
		File file = new File(filePath);
		if (file == null || !file.exists()) {
			errorInfo = "文件不存在";
			return false;
		}
		return true;
	}

	public List<ExcelSheet> read(String filePath) {
		List<ExcelSheet> dataLst = null;
		InputStream is = null;
		try {
			/** 验证文件是否合法 */
			if (!validateExcel(filePath)) {
				System.out.println(errorInfo);
				return null;
			}
			/** 判断文件的类型，是2003还是2007 */
			boolean isExcel2003 = true;
			if (WDWUtil.isExcel2007(filePath)) {
				isExcel2003 = false;
			}
			/** 调用本类提供的根据流读取的方法 */
			File file = new File(filePath);
			is = new FileInputStream(file);
			dataLst = read(is, isExcel2003);
			is.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					is = null;
					e.printStackTrace();
				}
			}
		}
		/** 返回最后读取的结果 */
		return dataLst;
	}

	public List<ExcelSheet> read(InputStream inputStream, boolean isExcel2003) {
		List<ExcelSheet> dataLst = null;
		try {
			/** 根据版本选择创建Workbook的方式 */
			Workbook wb = null;
			if (isExcel2003) {
				wb = new HSSFWorkbook(inputStream);
			} else {
				wb = new XSSFWorkbook(inputStream);
			}
			dataLst = read(wb);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return dataLst;
	}

	private List<ExcelSheet> read(Workbook wb) {
		List<ExcelSheet> list = new ArrayList<>();
		DecimalFormat format = new DecimalFormat("#");

		List<List<String>> dataLst =null;
		int sheetSize = wb.getNumberOfSheets();
		for (int i = 0; i < sheetSize; i++) {
			dataLst = new ArrayList<List<String>>();
			/** 得到第一个shell */
			Sheet sheet = wb.getSheetAt(i);
			ExcelSheet excelSheet= new ExcelSheet();
			excelSheet.setIndex(i);
			excelSheet.setName(sheet.getSheetName());
//			/** 得到Excel的行数 */
//			this.totalRows = sheet.getLastRowNum();
//			/** 得到Excel的列数 */
//			if (this.totalRows >= 1 && sheet.getRow(0) != null) {
//				this.totalCells = sheet.getRow(0).getLastCellNum();
//			}
			int totalRows= sheet.getLastRowNum()+1;
			
			/** 循环Excel的行 */
			for (int r = 0; r < totalRows; r++) {
				Row row = sheet.getRow(r);
				if (row == null) {
					continue;
				}
				int totalCells=row.getLastCellNum()+1;
				List<String> rowLst = new ArrayList<String>();
				/** 循环Excel的列 */
				for (int c = 0; c < totalCells; c++) {
					Cell cell = row.getCell(c);
					String cellValue = "";
					if (null != cell) {
						// 以下是判断数据的类型
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC: // 数字
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								// 如果是date类型则 ，获取该cell的date值
								cellValue = HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
							} else { // 纯数字
								Number number = cell.getNumericCellValue();
								// cellValue = String.valueOf(cell.getNumericCellValue());
								cellValue = format.format(number);

							}
							break;
						case HSSFCell.CELL_TYPE_STRING: // 字符串
							cellValue = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
							cellValue = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_FORMULA: // 公式
							cellValue = cell.getCellFormula() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK: // 空值
							cellValue = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR: // 故障
							cellValue = "非法字符";
							break;
						default:
							cellValue = "未知类型";
							break;
						}
					}
					rowLst.add(cellValue);
				}
				/** 保存第r行的第c列 */
				dataLst.add(rowLst);
			}
			excelSheet.setData(dataLst);
			list.add(excelSheet);
		}
		return list;
	}

	public static void main(String[] args) throws Exception {

	}

//	public static void main1(String[] args) throws Exception {
//		ExcelReader poi = new ExcelReader();
//		// List<List<String>> list = poi.read("d:/aaa.xls");
//		List<List<String>> list = poi.read("E:\\00.个人目录\\贷款用户\\襄州信息传输.xls");
//		if (list != null) {
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print("第" + (i) + "行");
//				List<String> cellList = list.get(i);
//				for (int j = 0; j < cellList.size(); j++) {
//					// System.out.print(" 第" + (j + 1) + "列值：");
//					System.out.print("    " + cellList.get(j));
//				}
//				System.out.println();
//			}
//
//		}
//
//	}

}

class WDWUtil {
	public static boolean isExcel2003(String filePath) {
		return filePath.matches("^.+\\.(?i)(xls)$");
	}

	public static boolean isExcel2007(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlsx)$");
	}
	public static boolean isExcelTEMP(String filePath) {
		return filePath.matches("^.+\\.(?i)(xlt)$");
	}
}