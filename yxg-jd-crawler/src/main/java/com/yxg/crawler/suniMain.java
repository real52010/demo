package com.yxg.crawler;

import java.util.HashMap;
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
import com.yxg.crawler.pojo.Item;

/**
 * 
 * 爬虫程序入口
 */
public class suniMain {

	public static final String URL = "http://list.suning.com/0-20006-{page}.html";
	private static final ObjectMapper MAPPER = new ObjectMapper();

	public static void main(String[] args) throws Exception {
		start();

	}

	public static void start() throws Exception {
		// 给入口url
		Integer totalPage = getTotalPage();
		System.out.println(totalPage);

		for (int i = 0; i < totalPage; i++) {
			System.out.println("当前执行文件" + i + "/" + totalPage);
			String url = StringUtils.replace(URL, "{page}", "" + i);
			doStart(url);
			break;
		}

	}

	public static void doStart(String url) throws Exception {

		String content = doGet(url);
		// 变成Document
		Document document = Jsoup.parse(content);
		Elements ems = document.select("#filter-results .product.subcode");
		// List<Item> items = new ArrayList<Item>();
		Map<Long, Item> items = new HashMap<Long, Item>();
		for (Element em : ems) {
			// 获取id
			String datapro = em.select(".border-in").select(".wrap").not(".hide")
					.select("input").attr("datapro");
			String id = StringUtils.substring(datapro, 2, 11);
			System.out.println(id);

			// 获取名称
			String name = em.select(".border-in").select(".wrap").not(".hide")
					.select(".res-info .sell-point a").text();
			System.out.println(name);

			// 获取图片
			String imgage = em.select(".border-in").select(".wrap").not(".hide")
					.select(".res-img .img-block").select("img").attr("src2");
			System.out.println(imgage);

			System.out.println("=====================");

			// 构造商品
			Item item = new Item();
			item.setId(Long.valueOf(id));
			item.setTitle(name);
			item.setImage(imgage);
			items.put(item.getId(), item);
		}
		// 000000000153844307__2
		// http://ds.suning.cn/ds/generalForTile/000000000153844307__2-9051-100-0000000000-1--ds000000000.jsonp
		String strIds = "";
		for (Long id : items.keySet()) {
			strIds = "000000000" + id + "__2";
			String priceUrl = "http://ds.suning.cn/ds/generalForTile/" + strIds
					+ "-9051-100-0000000000-1--.jsonp";
			String priDate = doGet(priceUrl);
			String priDate1 = StringUtils.substringBetween(priDate, "(", ");");
			JsonNode arrayNode = (JsonNode) MAPPER.readTree(priDate1);
			JsonNode rs = arrayNode.get("rs");
			String cmmdtyCode = rs.findValue("cmmdtyCode").asText();
			Long price = rs.findValue("price").asLong();
			Long id_v = Long.valueOf(StringUtils.substringAfterLast(cmmdtyCode,
					"000000000"));
			items.get(id_v).setPrice(price);

		}

		// 打印商品
		for (Item item : items.values()) {
			System.out.println(item.toString());
		}

	}

	/**
	 * 获取总页数
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Integer getTotalPage() throws Exception {
		String url = StringUtils.replace(URL, "{page}", "0");
		// 抓取网页文本

		String content = doGet(url);
		// 变成Document

		Document document = Jsoup.parse(content);
		String str = StringUtils.remove(document.select(".page-more").text(), "页，到第页 确定");
		String str1 = StringUtils.remove(str, "共");
		Integer totalPage = Integer.valueOf(str1);
		return totalPage;

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
