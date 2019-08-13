package com.real.posorder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.fan.learn.freeMarker.FileTools;
import org.fan.learn.freeMarker.FreeMarkerTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.real.utils.DateUtils;
import com.real.utils.SftpClientHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SyncPostCard {

	private static final Logger logger = LoggerFactory.getLogger(SftpClientHelper.class);
	public static String host = "112.95.232.217";// 主机地址
	public static int port = 9022;// 主机端口
	public static String username = "huilian";// 服务器用户名
	public static String password = "4J4k791h";// 服务器密码
	private static Configuration configuration;

	public static void main(String[] args) {
		Date ss = new Date();
		String basedir = "C:\\tl_posorder_cdr";
		//话单开始时间
		String billStartTimeStr = "20190624";
		//话单结束时间
		String billEndTimeStr = "20190811";
		//要下载的商户号
		String tlAccountNo = "821440370130085";
		String tempDir = basedir + "\\Temp(" + DateUtils.formatDate(ss, DateUtils.YYYYMMDDHHMMSS) + ")";
		String scriptFile = basedir + "\\upgrade_pos_card_" + DateUtils.formatDate(ss, DateUtils.YYYYMMDDHHMMSS) + ".sql";
		String backDir = basedir + "\\bills\\";
//		SimpleDateFormat format0 = new SimpleDateFormat("yyyyMMdd");
//		String time = format0.format(ss.getTime());// 这个就是把时间戳经过处理得到期望格式的时间

//		SecureRandom random1 = SecureRandom.getInstance("SHA1PRNG");

//		String randomStr=String.valueOf(random1.nextInt(1000));

		SyncPostCard.downLoadBill(billStartTimeStr, billEndTimeStr, tlAccountNo, tempDir);

		SyncPostCard.bakFiles(tempDir, backDir);

		SyncPostCard.createBill(tempDir, scriptFile);

		FileTools.rm(tempDir);

	}

	public static void downLoadBill(String billStartTimeStr, String billEndTimeStr, String tlAccountNo,
			String saveDir) {
		Date billStartTime = DateUtils.parseDate(billStartTimeStr, DateUtils.YYYYMMDD);
		Date billEndTime = DateUtils.parseDate(billEndTimeStr, DateUtils.YYYYMMDD);
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		c1.setTime(billStartTime);
		c2.setTime(billEndTime);

		while (true) {
//			System.out.println(DateUtils.formatDate(c1.getTime(), DateUtils.YYYYMMDD));
			SftpClientHelper clientUtil = null;
			try {

				clientUtil = new SftpClientHelper(host, port, username, password);
				clientUtil.connect();
				String fileNamePrx = DateUtils.formatDate(c1.getTime(), DateUtils.YYYYMMDD);
				String fileName = fileNamePrx + ".txt";
				String dirName = fileNamePrx.substring(0, 6);
				clientUtil.cd("/" + tlAccountNo + "/");
				String destDir = saveDir + "/" + dirName + "/";

				clientUtil.download(dirName, fileName, destDir);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					if (clientUtil != null) {
						clientUtil.disconnect();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
					throw new RuntimeException("关闭连接出错");
				}
			}

			// 下一个月<结束日期
			if (c1.getTimeInMillis() >= c2.getTimeInMillis()) {
				break;
			}
			c1.set(Calendar.DATE, c1.get(Calendar.DATE) + 1);

		}

	}

	public static void createBill(String billDir, String scriptFile) {

		List<File> list = FileTools.ls(billDir, true);

		FileReader reader = null;
		BufferedReader br = null;
		try {

			// bw.write("商户编码,商户名称,交易日期及时间,交易类型,交易金额,交易卡号,卡类别,终端编码,商户手续费,检索参考号,订单号\r\n");
			String cardPattern = "^[0-9\\*]{12,24}$";
			String feePattern = "^(0|([1-9][0-9]{0,4})|(([0]\\.\\d{1,2}|[1-9][0-9]{0,4}\\.\\d{1,2})))$";
			String referPattern = "^\\d{10,12}$";

			String orderNoPattern = "^\\d{15,40}$";
			for (File file : list) {
				if (file.isFile()) {
					reader = new FileReader(file);
					br = new BufferedReader(reader);

					String line = br.readLine();
					while ((line = br.readLine()) != null) {
						if (!"".equals(line)) {
							String[] cardData = line.split(",");
							if (cardData.length < 11) {
								System.out.println("数据长度不够：" + cardData[2] + ":" + cardData[4]);
								continue;
							}
							String cardNO = cardData[5];
							String transFee = cardData[8];
							String payCode = cardData[9];
							String tlOrderCode = cardData[10];

							if (!Pattern.matches(cardPattern, cardNO)) {
								logger.error("卡号格式不正常." + cardNO);
								continue;
							}
							if (!Pattern.matches(feePattern, transFee)) {
								logger.error("手续费格式不正常." + transFee);
								continue;
							}
							if (!Pattern.matches(referPattern, payCode)) {
								logger.error("参考号格式不正常." + payCode);
							}
							if (!Pattern.matches(orderNoPattern, tlOrderCode)) {
								logger.error("订单号格式不正常." + tlOrderCode);
								continue;
							}
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("cardNO", cardNO);
							map.put("transFee", transFee);
							map.put("payCode", payCode);
							map.put("tlOrderCode", tlOrderCode);
							String resultStr = process("02.upd_pos_card.ftl", map);
							FileTools.write(scriptFile, resultStr+"\r\n");
							System.out.println(resultStr);
						}
					}
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.info("UpdatePosOrderDataTask failed ", e);

		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void bakFiles(String src, String bakdir) {
		List<File> files = FileTools.ls(src, false);
		for (File file : files) {
			File destination = new File(bakdir + file.getName());

			FileTools.cp(file, destination, true, false);
		}
	}


	private static Configuration getConfiguration() throws IOException {
		if (configuration == null) {
			configuration = new Configuration(Configuration.getVersion());
			configuration.setClassForTemplateLoading(FreeMarkerTest.class, "/template/");
		}
		return configuration;
	}

	/**
	 * 瑙ｆ瀽瀛楃涓叉ā鏉�,閫氱敤鏂规硶
	 * 
	 * @param template      瀛楃涓叉ā鏉�
	 * @param model;        鏁版嵁
	 * @param configuration 閰嶇疆
	 * @return 瑙ｆ瀽鍚庡唴瀹�
	 */
	public static String process(String tempPath, Map<String, ?> model) throws IOException, TemplateException {
		if (tempPath == null) {
			return null;
		}
		configuration = getConfiguration();
		StringWriter out = new StringWriter();

		Template template = configuration.getTemplate(tempPath);
		template.process(model, out);
		return out.toString();
	}
}
