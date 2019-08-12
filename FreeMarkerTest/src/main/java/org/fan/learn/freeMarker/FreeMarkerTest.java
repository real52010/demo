package org.fan.learn.freeMarker;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {
	private static Configuration configuration;
	public static void main(String[] args) throws IOException, TemplateException{ 
		System.out.println("######################start");
		StringBuilder varStr=FileTools.read("C:\\git\\gitHub\\demo\\FreeMarkerTest\\src\\main\\java\\var.txt", "utf-8");
		String[] varArg=varStr.toString().split("\r\n");
		Date ss = new Date();
	        System.out.println("一般日期输出：" + ss);
	        System.out.println("时间戳：" + ss.getTime());
	        SimpleDateFormat format0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String time = format0.format(ss.getTime());//这个就是把时间戳经过处理得到期望格式的时间
		for (int i = 0; i < varArg.length; i++) {
			String string = varArg[i];
			
			if(string!=null&&!"".equals(string.trim())) {
				Map<String,Object> map = new HashMap<String,Object>(); 
				map.put("orderCode", string);
				
				map.put("curDate", time);
				
				String resultStr = process("t1.ftl",map); 
				FileTools.write("out.sql", resultStr);
			}
		}
		

		System.out.println("######################end");
		
		
		
		
		
		
		
//		Map<String,Object> map = new HashMap<String,Object>();  // map锛岄渶瑕佸姩鎬佸～鍏呯殑鏁版嵁
//		map.put("name", "寮犱笁");
//		map.put("age", "25");
//		String resultStr = process("t1.ftl",map); // 瑙ｆ瀽瀛楃涓叉ā鏉跨殑鏂规硶锛屽苟杩斿洖澶勭悊鍚庣殑瀛楃涓�
//		System.out.println(resultStr);
	}
	private static Configuration getConfiguration() throws IOException { 
		if (configuration == null) {
			configuration = new Configuration(Configuration.getVersion()); 
			configuration.setClassForTemplateLoading(FreeMarkerTest.class,"/template/");
		}
		return configuration;
	}
	/**
	 * 瑙ｆ瀽瀛楃涓叉ā鏉�,閫氱敤鏂规硶
	 * 
	 * @param template
	 *            瀛楃涓叉ā鏉�
	 * @param model; 
	 *            鏁版嵁
	 * @param configuration
	 *            閰嶇疆
	 * @return 瑙ｆ瀽鍚庡唴瀹�
	 */
	public static String process(String tempPath, Map<String, ?> model) 
			throws IOException, TemplateException {
		if (tempPath == null) {
			return null;
		}
		configuration= getConfiguration();
		StringWriter out = new StringWriter();

        Template template = configuration.getTemplate(tempPath); 
        template.process(model, out);
		return out.toString();
	}
	
}
