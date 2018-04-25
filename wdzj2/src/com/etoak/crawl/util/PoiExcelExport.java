package com.etoak.crawl.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFPalette;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

public class PoiExcelExport {

    // HttpServletResponse response;
    // �ļ���
    private String fileName;
    // �ļ�����·��
    private String fileDir;
    // sheet��
    private String sheetName;
    // ��ͷ����
    private String titleFontType       = "Arial Unicode MS";
    // ��ͷ����ɫ
    private String titleBackColor      = "C1FBEE";
    // ��ͷ�ֺ�
    private short  titleFontSize       = 12;
    // ����Զ�ɸѡ���� �� A:M
    private String address             = "";
    // ��������
    private String contentFontType     = "Arial Unicode MS";
    // �����ֺ�
    private short  contentFontSize     = 12;
    // Float��������С��λ
    private String floatDecimal        = ".00";
    // Double��������С��λ
    private String doubleDecimal       = ".00";
    // �����еĹ�ʽ
    private String colFormula[]        = null;

    DecimalFormat  floatDecimalFormat  = new DecimalFormat(floatDecimal);
    DecimalFormat  doubleDecimalFormat = new DecimalFormat(doubleDecimal);

    public static enum CellType {
                                 TYPE_INT, TYPE_FLOAT, TYPE_DOUBLE, TYPE_BOOLEAN, TYPE_STRING;
    }

    private HSSFWorkbook workbook = null;

    public PoiExcelExport(String fileDir, String sheetName){
        this.fileDir = fileDir;
        this.sheetName = sheetName;
        workbook = new HSSFWorkbook();
    }

    // public PoiExcelExport(String fileName,String sheetName){
    //// this.response = response;
    // this.sheetName = sheetName;
    // workbook = new HSSFWorkbook();
    // }
    /**
     * ���ñ�ͷ����.
     * 
     * @param titleFontType
     */
    public void setTitleFontType(String titleFontType) {
        this.titleFontType = titleFontType;
    }

    /**
     * ���ñ�ͷ����ɫ.
     * 
     * @param titleBackColor ʮ������
     */
    public void setTitleBackColor(String titleBackColor) {
        this.titleBackColor = titleBackColor;
    }

    /**
     * ���ñ�ͷ�����С.
     * 
     * @param titleFontSize
     */
    public void setTitleFontSize(short titleFontSize) {
        this.titleFontSize = titleFontSize;
    }

    /**
     * ���ñ�ͷ�Զ�ɸѡ��λ,��A:AC.
     * 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ������������.
     * 
     * @param contentFontType
     */
    public void setContentFontType(String contentFontType) {
        this.contentFontType = contentFontType;
    }

    /**
     * ���������ֺ�.
     * 
     * @param contentFontSize
     */
    public void setContentFontSize(short contentFontSize) {
        this.contentFontSize = contentFontSize;
    }

    /**
     * ����float��������С��λ Ĭ��.00
     * 
     * @param doubleDecimal �� ".00"
     */
    public void setDoubleDecimal(String doubleDecimal) {
        this.doubleDecimal = doubleDecimal;
    }

    /**
     * ����doubel��������С��λ Ĭ��.00
     * 
     * @param floatDecimalFormat �� ".00
     */
    public void setFloatDecimalFormat(DecimalFormat floatDecimalFormat) {
        this.floatDecimalFormat = floatDecimalFormat;
    }

    /**
     * �����еĹ�ʽ
     * 
     * @param colFormula �洢i-1�еĹ�ʽ �漰�����к�ʹ��@�滻 ��A@+B@
     */
    public void setColFormula(String[] colFormula) {
        this.colFormula = colFormula;
    }

    /**
     * дexcel.
     * 
     * @param titleColumn ��Ӧbean��������
     * @param titleName excelҪ�����ı���
     * @param titleSize �п�
     * @param dataList ����
     */
    public void wirteExcel(String titleColumn[], String titleName[], CellType cellType[], int titleSize[],
                           List<?> dataList) {
        // ���Worksheet�������sheetʱ���ɵ�xls�ļ���ʱ�ᱨ��)
        Sheet sheet = workbook.createSheet(this.sheetName);
        // �½��ļ�
        OutputStream out = null;
        try {
            if (fileDir != null) {
                // ���ļ�·��
                out = new FileOutputStream(fileDir);
            }
            // else{
            // //����ֱ��д���������
            // out = response.getOutputStream();
            // fileName = fileName+".xls";
            // response.setContentType("application/x-msdownload");
            // response.setHeader("Content-Disposition", "attachment; filename="
            // + URLEncoder.encode(fileName, "UTF-8"));
            // }

            // д��excel�ı�ͷ
            Row titleNameRow = workbook.getSheet(sheetName).createRow(0);
            // ������ʽ
            HSSFCellStyle titleStyle = workbook.createCellStyle();
            titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, titleFontType, (short) titleFontSize);
            titleStyle = (HSSFCellStyle) setColor(titleStyle, titleBackColor, (short) 10);

            for (int i = 0; i < titleName.length; i++) {
                sheet.setColumnWidth(i, titleSize[i] * 256); // ���ÿ��
                Cell cell = titleNameRow.createCell(i);
                cell.setCellStyle(titleStyle);
                cell.setCellValue(titleName[i].toString());
            }

            // Ϊ��ͷ����Զ�ɸѡ
            if (!"".equals(address)) {
                CellRangeAddress c = (CellRangeAddress) CellRangeAddress.valueOf(address);
                sheet.setAutoFilter(c);
            }

            // ͨ�������ȡ���ݲ�д�뵽excel��
            if (dataList != null && dataList.size() > 0) {
                // ������ʽ
                HSSFCellStyle dataStyle = workbook.createCellStyle();
                titleStyle = (HSSFCellStyle) setFontAndBorder(titleStyle, contentFontType, (short) contentFontSize);

                if (titleColumn.length > 0) {
                    for (int rowIndex = 1; rowIndex <= dataList.size(); rowIndex++) {
                        Object obj = dataList.get(rowIndex - 1); // ��øö���
                        Class clsss = obj.getClass(); // ��øöԶ����classʵ��
                        Row dataRow = workbook.getSheet(sheetName).createRow(rowIndex);
                        for (int columnIndex = 0; columnIndex < titleColumn.length; columnIndex++) {
                            String title = titleColumn[columnIndex].toString().trim();
                            if (!"".equals(title)) { // �ֶβ�Ϊ��
                                // ʹ����ĸ��д
                                String UTitle = Character.toUpperCase(title.charAt(0))
                                                + title.substring(1, title.length()); // ʹ������ĸ��д;
                                String methodName = "get" + UTitle;

                                // ����Ҫִ�еķ���
                                Method method = clsss.getDeclaredMethod(methodName);

                                // ��ȡ��������
                                String returnType = method.getReturnType().getName();

                                String data = method.invoke(obj) == null ? "" : method.invoke(obj).toString();
                                Cell cell = dataRow.createCell(columnIndex);

                                if (data != null && !"".equals(data)) {

                                    if (cellType != null) {
                                        // System.out.println(columnIndex);
                                        // System.out.println(data);
                                        CellType ctype = cellType[columnIndex];
                                        // cell.setCellType(ctype);

                                        // * @see #CELL_TYPE_NUMERIC
                                        // * @see #CELL_TYPE_STRING
                                        // * @see #CELL_TYPE_FORMULA
                                        // * @see #CELL_TYPE_BLANK
                                        // * @see #CELL_TYPE_BOOLEAN
//                                        System.out.println(ctype);
//                                        System.out.println(data);
                                        if (ctype.equals(CellType.TYPE_INT)) {
                                            cell.setCellValue(Integer.parseInt(data));
                                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                        } else if (ctype.equals(CellType.TYPE_DOUBLE)) {
                                            cell.setCellValue(Double.parseDouble(data));
                                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                        } else if (ctype.equals(CellType.TYPE_FLOAT)) {
                                            cell.setCellValue(Float.parseFloat(data));
                                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                                        } else if (ctype.equals(CellType.TYPE_BOOLEAN)) {
                                            cell.setCellValue(Boolean.parseBoolean(data));
                                            cell.setCellType(Cell.CELL_TYPE_BOOLEAN);
                                        } else if (ctype.equals(CellType.TYPE_STRING)) {
                                            cell.setCellValue(data);
                                            cell.setCellType(Cell.CELL_TYPE_STRING);
                                        }

                                    } else {
                                        if ("int".equals(returnType)) {
                                            cell.setCellValue(Integer.parseInt(data));
                                        } else if ("long".equals(returnType)) {
                                            cell.setCellValue(Long.parseLong(data));
                                        } else if ("float".equals(returnType)) {
                                            cell.setCellValue(floatDecimalFormat.format(Float.parseFloat(data)));
                                        } else if ("double".equals(returnType)) {
                                            cell.setCellValue(doubleDecimalFormat.format(Double.parseDouble(data)));
                                        } else {
                                            cell.setCellValue(data);
                                        }
                                    }

                                }
                                // ��������δ���� ���Ż�
                                // if (cellType != null) {
                                // System.out.println(columnIndex);
                                // System.out.println(data);
                                // cell.setCellType(cellType[columnIndex]);
                                // }
                            } else { // �ֶ�Ϊ�� �������Ƿ��ǹ�ʽ
                                if (colFormula != null) {
                                    String sixBuf = colFormula[columnIndex].replace("@", (rowIndex + 1) + "");
                                    Cell cell = dataRow.createCell(columnIndex);
                                    cell.setCellFormula(sixBuf.toString());
                                }
                            }
                        }
                    }

                }
            }

            workbook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * ��16���Ƶ���ɫ����д����ʽ����������ɫ
     * 
     * @param style ��֤styleͳһ
     * @param color ��ɫ��66FFDD
     * @param index ���� 8-64 ʹ��ʱ�����ظ�
     * @return
     */
    public CellStyle setColor(CellStyle style, String color, short index) {
        if (color != "" && color != null) {
            // תΪRGB��
            int r = Integer.parseInt((color.substring(0, 2)), 16); // תΪ16����
            int g = Integer.parseInt((color.substring(2, 4)), 16);
            int b = Integer.parseInt((color.substring(4, 6)), 16);
            // �Զ���cell��ɫ
            HSSFPalette palette = workbook.getCustomPalette();
            palette.setColorAtIndex((short) index, (byte) r, (byte) g, (byte) b);

            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
            style.setFillForegroundColor(index);
        }
        return style;
    }

    /**
     * �������岢����߿�
     * 
     * @param style ��ʽ
     * @param style ������
     * @param style ��С
     * @return
     */
    public CellStyle setFontAndBorder(CellStyle style, String fontName, short size) {
        HSSFFont font = workbook.createFont();
        font.setFontHeightInPoints(size);
        font.setFontName(fontName);
        // font.setBold(true);
        style.setFont(font);
        style.setBorderBottom(CellStyle.BORDER_THIN); // �±߿�
        style.setBorderLeft(CellStyle.BORDER_THIN);// ��߿�
        style.setBorderTop(CellStyle.BORDER_THIN);// �ϱ߿�
        style.setBorderRight(CellStyle.BORDER_THIN);// �ұ߿�
        return style;
    }

    /**
     * ɾ���ļ�
     * 
     * @param fileDir
     * @return
     */
    public boolean deleteExcel() {
        boolean flag = false;
        File file = new File(this.fileDir);
        // �ж�Ŀ¼���ļ��Ƿ����
        if (!file.exists()) { // �����ڷ��� false
            return flag;
        } else {
            // �ж��Ƿ�Ϊ�ļ�
            if (file.isFile()) { // Ϊ�ļ�ʱ����ɾ���ļ�����
                file.delete();
                flag = true;
            }
        }
        return flag;
    }

    /**
     * ɾ���ļ�
     * 
     * @param fileDir
     * @return
     */
    public boolean deleteExcel(String path) {
        boolean flag = false;
        File file = new File(path);
        // �ж�Ŀ¼���ļ��Ƿ����
        if (!file.exists()) { // �����ڷ��� false
            return flag;
        } else {
            // �ж��Ƿ�Ϊ�ļ�
            if (file.isFile()) { // Ϊ�ļ�ʱ����ɾ���ļ�����
                file.delete();
                flag = true;
            }
        }
        return flag;
    }
}
