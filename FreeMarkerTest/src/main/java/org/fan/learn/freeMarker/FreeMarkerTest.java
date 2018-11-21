package org.fan.learn.freeMarker;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreeMarkerTest {
	private static Configuration configuration;
	public static void main(String[] args) throws IOException, TemplateException{ 
		System.out.println("######################start");
		StringBuilder varStr=FileTools.read("D:\\workspace-sts\\FmTest\\src\\main\\java\\var.txt", "utf-8");
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
		
		
		
		
		
		
		
//		Map<String,Object> map = new HashMap<String,Object>();  // map����Ҫ��̬��������
//		map.put("name", "����");
//		map.put("age", "25");
//		String resultStr = process("t1.ftl",map); // �����ַ���ģ��ķ����������ش������ַ���
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
	 * �����ַ���ģ��,ͨ�÷���
	 * 
	 * @param template
	 *            �ַ���ģ��
	 * @param model; 
	 *            ����
	 * @param configuration
	 *            ����
	 * @return ����������
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
