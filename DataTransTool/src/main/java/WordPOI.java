
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

public class WordPOI {

	// 返回Docx中需要替换的特殊字符，没有重复项
	// 推荐传入正则表达式参数"\\$\\{[^{}]+\\}"
	public ArrayList<String> getReplaceElementsInWord(String filePath, String regex) {
		String[] p = filePath.split("\\.");
		if (p.length > 0) {// 判断文件有无扩展名
			// 比较文件扩展名
			if (p[p.length - 1].equalsIgnoreCase("doc")) {
				ArrayList<String> al = new ArrayList<>();
				File file = new File(filePath);
				HWPFDocument document = null;
				try {
					InputStream is = new FileInputStream(file);
					document = new HWPFDocument(is);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Range range = document.getRange();
				String rangeText = range.text();
				CharSequence cs = rangeText.subSequence(0, rangeText.length());
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(cs);
				int startPosition = 0;
				while (matcher.find(startPosition)) {
					if (!al.contains(matcher.group())) {
						al.add(matcher.group());
					}
					startPosition = matcher.end();
				}
				return al;
			} else if (p[p.length - 1].equalsIgnoreCase("docx")) {
				ArrayList<String> al = new ArrayList<>();
				XWPFDocument document = null;
				try {
					document = new XWPFDocument(POIXMLDocument.openPackage(filePath));
				} catch (IOException e) {
					e.printStackTrace();
				}
				// 遍历段落
				Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
				while (itPara.hasNext()) {
					XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
					String paragraphString = paragraph.getText();
					CharSequence cs = paragraphString.subSequence(0, paragraphString.length());
					Pattern pattern = Pattern.compile(regex);
					Matcher matcher = pattern.matcher(cs);
					int startPosition = 0;
					while (matcher.find(startPosition)) {
						if (!al.contains(matcher.group())) {
							al.add(matcher.group());
						}
						startPosition = matcher.end();
					}
				}
				// 遍历表
				Iterator<XWPFTable> itTable = document.getTablesIterator();
				while (itTable.hasNext()) {
					XWPFTable table = (XWPFTable) itTable.next();
					int rcount = table.getNumberOfRows();
					for (int i = 0; i < rcount; i++) {
						XWPFTableRow row = table.getRow(i);
						List<XWPFTableCell> cells = row.getTableCells();
						for (XWPFTableCell cell : cells) {
							String cellText = "";
							cellText = cell.getText();
							CharSequence cs = cellText.subSequence(0, cellText.length());
							Pattern pattern = Pattern.compile(regex);
							Matcher matcher = pattern.matcher(cs);
							int startPosition = 0;
							while (matcher.find(startPosition)) {
								if (!al.contains(matcher.group())) {
									al.add(matcher.group());
								}
								startPosition = matcher.end();
							}
						}
					}
				}
				return al;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/* 何问起 hovertree.com */
	// 替换word中需要替换的特殊字符
	public static boolean replaceAndGenerateWord(String srcPath, String destPath, Map<String, String> map) {
		String[] sp = srcPath.split("\\.");
		String[] dp = destPath.split("\\.");
		if ((sp.length > 0) && (dp.length > 0)) {// 判断文件有无扩展名
			// 比较文件扩展名
			if (sp[sp.length - 1].equalsIgnoreCase("docx")) {
				try {
					XWPFParagraph para;
					XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(srcPath));
					// 替换段落中的指定文字
					Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
					while (itPara.hasNext()) {
						para = itPara.next();
						if (WordPOI.matcher(para.getParagraphText()).find()) {
							WordPOI.replaceInPara(para, map);
						}
					}

					// 替换表格中的指定文字
					Iterator<XWPFTable> itTable = document.getTablesIterator();
					List<XWPFParagraph> paras;
					while (itTable.hasNext()) {
						XWPFTable table = (XWPFTable) itTable.next();
						int rcount = table.getNumberOfRows();
						for (int i = 0; i < rcount; i++) {
							XWPFTableRow row = table.getRow(i);
							List<XWPFTableCell> cells = row.getTableCells();
							for (XWPFTableCell cell : cells) {
								paras = cell.getParagraphs();
								for (XWPFParagraph para2 : paras) {
									WordPOI.replaceInPara(para2, map);
								}
							}
						}
					}
					FileOutputStream outStream = null;
					File file = new File(destPath);
					if(!file.getParentFile().exists()&&!file.getParentFile().mkdirs()) {
						throw new Exception("文件不存在，且创建文件失败.");
					}
					outStream = new FileOutputStream(destPath);
					document.write(outStream);
					outStream.close();
					return true;
				} catch (Exception e) {
					e.printStackTrace();
					return false;
				}

			} else
			// doc只能生成doc，如果生成docx会出错
			if ((sp[sp.length - 1].equalsIgnoreCase("doc")) && (dp[dp.length - 1].equalsIgnoreCase("doc"))) {
				HWPFDocument document = null;
				try {
					document = new HWPFDocument(new FileInputStream(srcPath));
					Range range = document.getRange();
					for (Map.Entry<String, String> entry : map.entrySet()) {
						System.out.println(entry.getKey() + "---" + entry.getValue());
						range.replaceText(entry.getKey(), entry.getValue());
					}
					FileOutputStream outStream = null;
					outStream = new FileOutputStream(destPath);
					document.write(outStream);
					outStream.close();
					return true;
				} catch (FileNotFoundException e) {
					e.printStackTrace();
					return false;
				} catch (IOException e) {
					e.printStackTrace();
					return false;
				}
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * 替换段落里面的变量
	 * 
	 * @param para
	 *            要替换的段落
	 * @param params
	 *            参数
	 */
	private static void replaceInPara(XWPFParagraph para, Map<String, String> params) {
		List<XWPFRun> runs;
		Matcher matcher;

		String runText = "";
		if (WordPOI.matcher(para.getParagraphText()).find()) {

			runs = para.getRuns();
			if (runs.size() > 1) {

				int j = runs.size();

				for (int i = 1; i < j; i++) {

					XWPFRun run = runs.get(1);

					String i1 = run.toString();

					runText += i1;

					para.removeRun(1);
				}

			}
			matcher = WordPOI.matcher(runText);

			if (matcher.find()) {
				while ((matcher = WordPOI.matcher(runText)).find()) {
					runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
				}
				// 直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
				// 所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
				
				 XWPFRun target=  para.getRuns().get(0);
				 target.setText(runText);
				
			}
		}
	}

	/**
	 * 替换表格里面的变量
	 * 
	 * @param doc
	 *            要替换的文档
	 * @param params
	 *            参数
	 */
	private static void replaceInTable(XWPFDocument doc, Map<String, String> params) {
		Iterator<XWPFTable> iterator = doc.getTablesIterator();
		XWPFTable table;
		List<XWPFTableRow> rows;
		List<XWPFTableCell> cells;
		List<XWPFParagraph> paras;
		while (iterator.hasNext()) {
			table = iterator.next();
			rows = table.getRows();
			for (XWPFTableRow row : rows) {
				cells = row.getTableCells();
				for (XWPFTableCell cell : cells) {
					paras = cell.getParagraphs();
					for (XWPFParagraph para : paras) {
						WordPOI.replaceInPara(para, params);
					}
				}
			}
		}
	}

	/**
	 * 正则匹配字符串
	 * 
	 * @param str
	 * @return
	 */
	private static Matcher matcher(String str) {
		Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String filepathString = "E:\\syx\\temp\\1-借款合同（借款企业vs代偿方）-V1.0（20181129）.docx";
		String destpathString = "E:\\syx\\target\\1-借款合同（借款企业vs代偿方）.docx";
		Map<String, String> map = new HashMap<String, String>();
		map.put("$NAME", "王五王五啊柯乐义的辣味回答侯何问起网");
		System.out.println(replaceAndGenerateWord(filepathString, destpathString, map));
	}
}