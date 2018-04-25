package com.yxg.crawler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.yxg.crawler.pojo.Item;

/**
 * 
 * 爬虫程序入口
 */
public class jdMain {

	public static final String URL = "http://list.jd.com/list.html?cat=9987,653,655&page={page}&trans=1&JL=6_0_0&ms=5#J_main";
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		start();
		System.out.println(System.currentTimeMillis()-start);

	}

	public static void start() throws Exception {
		// 给入口url
		Integer totalPage = getTotalPage();
		for (int i = 1; i < totalPage; i++) {
			System.out.println("当前执行文件" + i + "/" + totalPage);
			String url = StringUtils.replace(URL, "{page}", "" + i);
			doStart(url);
		}

	}

	public static void doStart(String url) throws Exception {

		String content = doGet(url);
		// 变成Document
		Document document = Jsoup.parse(content);
		
		System.out.println(document.html());
		Elements ems = document.select("#plist li.gl-item");
		// List<Item> items = new ArrayList<Item>();
		Map<Long, Item> items = new HashMap<Long, Item>();
		for (Element em : ems) {
			// 获取id
			String id = em.select(".gl-i-wrap").attr("data-sku");
			// 获取名称
			String name = em.select(".p-name a em").text();
			// 获取图片
			String imgage = em.select(".gl-i-wrap >.p-img > a >img").attr("src")
					.replace("//", "");

			// 构造商品
			Item item = new Item();
			item.setId(Long.valueOf(id));
			item.setTitle(name);
			item.setImage(imgage);
			items.put(item.getId(), item);
		}

		// 添加id 要以这个格式 J_3466744
		List<String> strIds = new ArrayList<String>();
		for (Long id : items.keySet()) {
			strIds.add("J_" + id);
		}

		// 获取商品的价格StringUtils.join([1, 2, 3], ';') = "1;2;3"
		String priceUrl = "http://p.3.cn/prices/mgets?type=1&area=19_1607_3155_0&skuIds="
				+ StringUtils.join(strIds, ",");
		String priceDate = doGet(priceUrl);
		// 解析json
		ArrayNode arrayNode = (ArrayNode) MAPPER.readTree(priceDate);
		for (JsonNode jsonNode : arrayNode) {
			Long id = Long.valueOf(StringUtils.substringAfter(
					jsonNode.get("id").asText(), "_"));
			// 利用map 将price 回填 高明
			Long price = jsonNode.get("p").asLong();
			items.get(id).setPrice(price);
		}
		int i=0;
////		// 打印商品
//		for (Item item : items.values()) {
//			System.out.println(i+++":"+item.toString());
//		}
	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer getTotalPage() throws Exception {
		String url = StringUtils.replace(URL, "{page}", "1");
		// 抓取网页文本

		String content = doGet(url);
		// 变成Document

		Document document = Jsoup.parse(content);
		String str = document.select("#J_bottomPage>span.p-skip>em>b").text();
		Integer totalPage = Integer.valueOf(str);
		return 2;
	}

	public static String doGet(String url) throws Exception {
		// 创建Httpclient对象
		CloseableHttpClient httpclient = HttpClients.createDefault();

		// 创建http GET请求
		HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader(
				"User-Agent",
				"Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.118 Safari/537.36");
		CloseableHttpResponse response = null;
		try {
			// 执行请求
			response = httpclient.execute(httpGet);
			// 判断返回状态是否为200
			if (response.getStatusLine().getStatusCode() == 200) {
				String content = EntityUtils.toString(response.getEntity(), "UTF-8");
				return content;
			}
		} finally {
			if (response != null) {
				response.close();
			}
			// 相当于关闭浏览器
			httpclient.close();
		}
		return null;
	}
}
