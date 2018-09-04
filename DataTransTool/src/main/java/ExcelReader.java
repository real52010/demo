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
 * @����������excel��ȡ
 * 
 * 				�����jar��
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
 *               jar���������ص�ַ��http://poi.apache.org/download.html
 * 
 *               ����poi-bin-3.8-beta3-20110606.zipp
 * 
 */

public class ExcelReader {
//	/** ������ */
//	private int totalRows = 0;
//	/** ������ */
//	private int totalCells = 0;
	/** ������Ϣ */
	private String errorInfo;

	/** ���췽�� */
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
		/** ����ļ����Ƿ�Ϊ�ջ����Ƿ���Excel��ʽ���ļ� */
		if (filePath == null || !(WDWUtil.isExcel2003(filePath) || WDWUtil.isExcel2007(filePath)|| WDWUtil.isExcelTEMP(filePath))) {
			errorInfo = "�ļ�������excel��ʽ";
			return false;
		}
		/** ����ļ��Ƿ���� */
		File file = new File(filePath);
		if (file == null || !file.exists()) {
			errorInfo = "�ļ�������";
			return false;
		}
		return true;
	}

	public List<ExcelSheet> read(String filePath) {
		List<ExcelSheet> dataLst = null;
		InputStream is = null;
		try {
			/** ��֤�ļ��Ƿ�Ϸ� */
			if (!validateExcel(filePath)) {
				System.out.println(errorInfo);
				return null;
			}
			/** �ж��ļ������ͣ���2003����2007 */
			boolean isExcel2003 = true;
			if (WDWUtil.isExcel2007(filePath)) {
				isExcel2003 = false;
			}
			/** ���ñ����ṩ�ĸ�������ȡ�ķ��� */
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
		/** ��������ȡ�Ľ�� */
		return dataLst;
	}

	public List<ExcelSheet> read(InputStream inputStream, boolean isExcel2003) {
		List<ExcelSheet> dataLst = null;
		try {
			/** ���ݰ汾ѡ�񴴽�Workbook�ķ�ʽ */
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
			/** �õ���һ��shell */
			Sheet sheet = wb.getSheetAt(i);
			ExcelSheet excelSheet= new ExcelSheet();
			excelSheet.setIndex(i);
			excelSheet.setName(sheet.getSheetName());
//			/** �õ�Excel������ */
//			this.totalRows = sheet.getLastRowNum();
//			/** �õ�Excel������ */
//			if (this.totalRows >= 1 && sheet.getRow(0) != null) {
//				this.totalCells = sheet.getRow(0).getLastCellNum();
//			}
			int totalRows= sheet.getLastRowNum()+1;
			
			/** ѭ��Excel���� */
			for (int r = 0; r < totalRows; r++) {
				Row row = sheet.getRow(r);
				if (row == null) {
					continue;
				}
				int totalCells=row.getLastCellNum()+1;
				List<String> rowLst = new ArrayList<String>();
				/** ѭ��Excel���� */
				for (int c = 0; c < totalCells; c++) {
					Cell cell = row.getCell(c);
					String cellValue = "";
					if (null != cell) {
						// �������ж����ݵ�����
						switch (cell.getCellType()) {
						case HSSFCell.CELL_TYPE_NUMERIC: // ����
							if (HSSFDateUtil.isCellDateFormatted(cell)) {
								// �����date������ ����ȡ��cell��dateֵ
								cellValue = HSSFDateUtil.getJavaDate(cell.getNumericCellValue()).toString();
							} else { // ������
								Number number = cell.getNumericCellValue();
								// cellValue = String.valueOf(cell.getNumericCellValue());
								cellValue = format.format(number);

							}
							break;
						case HSSFCell.CELL_TYPE_STRING: // �ַ���
							cellValue = cell.getStringCellValue();
							break;
						case HSSFCell.CELL_TYPE_BOOLEAN: // Boolean
							cellValue = cell.getBooleanCellValue() + "";
							break;
						case HSSFCell.CELL_TYPE_FORMULA: // ��ʽ
							cellValue = cell.getCellFormula() + "";
							break;
						case HSSFCell.CELL_TYPE_BLANK: // ��ֵ
							cellValue = "";
							break;
						case HSSFCell.CELL_TYPE_ERROR: // ����
							cellValue = "�Ƿ��ַ�";
							break;
						default:
							cellValue = "δ֪����";
							break;
						}
					}
					rowLst.add(cellValue);
				}
				/** �����r�еĵ�c�� */
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
//		List<List<String>> list = poi.read("E:\\00.����Ŀ¼\\�����û�\\������Ϣ����.xls");
//		if (list != null) {
//			for (int i = 0; i < list.size(); i++) {
//				System.out.print("��" + (i) + "��");
//				List<String> cellList = list.get(i);
//				for (int j = 0; j < cellList.size(); j++) {
//					// System.out.print(" ��" + (j + 1) + "��ֵ��");
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