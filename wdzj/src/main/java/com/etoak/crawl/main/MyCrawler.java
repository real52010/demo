package com.etoak.crawl.main;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import com.etoak.crawl.bean.WdData;
import com.etoak.crawl.link.LinkFilter;
import com.etoak.crawl.link.Links;
import com.etoak.crawl.page.Page;
import com.etoak.crawl.page.RequestAndResponseTool;
import com.etoak.crawl.util.FileTool;
import com.etoak.crawl.util.PoiExcelExport;
import com.etoak.crawl.util.PoiExcelExport.CellType;
import com.jayway.jsonpath.JsonPath;

public class MyCrawler {

    /**
     * 使用种子初始化 URL 队列
     *
     * @param seeds 种子 URL
     * @return
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }

    /**
     * 抓取过程
     *
     * @param seeds
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public void crawling(String[] seeds) throws KeyManagementException, NoSuchAlgorithmException, IOException {

        // 初始化 URL 队列
        initCrawlerWithSeeds(seeds);

        // 定义过滤器，提取以 http://www.baidu.com 开头的链接
        LinkFilter filter = new LinkFilter() {

            public boolean accept(String url) {
                // if (url.startsWith("http://www.baidu.com"))
                return true;
                // else
                // return false;
            }
        };

        // 循环条件：待抓取的链接不空且抓取的网页不多于 1000
        while (!Links.unVisitedUrlQueueIsEmpty() && Links.getVisitedUrlNum() <= 1000) {

            // 先从待访问的序列中取出第一个；
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null) {
                continue;
            }

            // 根据URL得到page;
            Page page = RequestAndResponseTool.sendPost(visitUrl);

            // //对page进行处理： 访问DOM的某个标签
            // Elements es = PageParserTool.select(page,"a");
            // if(!es.isEmpty()){
            // System.out.println("下面将打印所有a标签： ");
            // System.out.println(es);
            // }

            // 将保存文件
            FileTool.saveToLocal(page);

            // //将已经访问过的链接放入已访问的链接中；
            // Links.addVisitedUrlSet(visitUrl);

            // //得到超链接
            // Set<String> links = PageParserTool.getLinks(page,"img");
            // for (String link : links) {
            // Links.addUnvisitedUrlQueue(link);
            // System.out.println("新增爬取路径: " + link);
            // }
        }
    }

    	public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {

        Page page = RequestAndResponseTool .sendPost("http://domain.aliyuncs.com/?Action=CheckDomain&DomainName=abc.com");
        System.out.println(page.getHtml());
        // System.out.println(page.getContentStr());
    }
}
