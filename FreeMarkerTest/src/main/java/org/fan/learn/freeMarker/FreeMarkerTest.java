package org.fan.learn.freeMarker;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {
	private static Configuration configuration;
	public static void main(String[] args) throws IOException, TemplateException{ 
		System.out.println("######################start");
		StringBuilder varStr=FileTools.read("D:\\GitHub\\demo\\FreeMarkerTest\\src\\main\\java\\var.txt", "utf-8");
		String[] varArg=varStr.toString().split("\r\n");
		for (int i = 0; i < varArg.length; i++) {
			String string = varArg[i];
			if(string!=null&&!"".equals(string.trim())) {
				Map<String,Object> map = new HashMap<String,Object>(); 
				map.put("orderCode", string);
				String resultStr = process("t1.ftl",map); 
				FileTools.write("out.sql", resultStr);
			}
		}
		

		System.out.println("######################end");
		
		
		
		
		
		
		
//		Map<String,Object> map = new HashMap<String,Object>();  // map，需要动态填充的数据
//		map.put("name", "张三");
//		map.put("age", "25");
//		String resultStr = process("t1.ftl",map); // 解析字符串模板的方法，并返回处理后的字符串
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
	 * 解析字符串模板,通用方法
	 * 
	 * @param template
	 *            字符串模板
	 * @param model; 
	 *            数据
	 * @param configuration
	 *            配置
	 * @return 解析后内容
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
