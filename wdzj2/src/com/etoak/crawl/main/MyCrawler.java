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
import com.google.gson.Gson;
import com.jayway.jsonpath.JsonPath;

public class MyCrawler {

    /**
     * ʹ�����ӳ�ʼ�� URL ����
     *
     * @param seeds ���� URL
     * @return
     */
    private void initCrawlerWithSeeds(String[] seeds) {
        for (int i = 0; i < seeds.length; i++) {
            Links.addUnvisitedUrlQueue(seeds[i]);
        }
    }

    /**
     * ץȡ����
     *
     * @param seeds
     * @return
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @throws IOException
     */
    public void crawling(String[] seeds) throws KeyManagementException, NoSuchAlgorithmException, IOException {

        // ��ʼ�� URL ����
        initCrawlerWithSeeds(seeds);

        // �������������ȡ�� http://www.baidu.com ��ͷ������
        LinkFilter filter = new LinkFilter() {

            public boolean accept(String url) {
                // if (url.startsWith("http://www.baidu.com"))
                return true;
                // else
                // return false;
            }
        };

        // ѭ����������ץȡ�����Ӳ�����ץȡ����ҳ������ 1000
        while (!Links.unVisitedUrlQueueIsEmpty() && Links.getVisitedUrlNum() <= 1000) {

            // �ȴӴ����ʵ�������ȡ����һ����
            String visitUrl = (String) Links.removeHeadOfUnVisitedUrlQueue();
            if (visitUrl == null) {
                continue;
            }

            // ����URL�õ�page;
            Page page = RequestAndResponseTool.sendRequstAndGetResponse(visitUrl);

            // //��page���д��� ����DOM��ĳ����ǩ
            // Elements es = PageParserTool.select(page,"a");
            // if(!es.isEmpty()){
            // System.out.println("���潫��ӡ����a��ǩ�� ");
            // System.out.println(es);
            // }

            // �������ļ�
            FileTool.saveToLocal(page);

            // //���Ѿ����ʹ������ӷ����ѷ��ʵ������У�
            // Links.addVisitedUrlSet(visitUrl);

            // //�õ�������
            // Set<String> links = PageParserTool.getLinks(page,"img");
            // for (String link : links) {
            // Links.addUnvisitedUrlQueue(link);
            // System.out.println("������ȡ·��: " + link);
            // }
        }
    }
    public static void main(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        
        
          
            Page page = RequestAndResponseTool
            .sendRequstAndGetResponse("http://panda.www.net.cn/cgi-bin/check.cgi?area_domain=teapic.com");
//            System.out.println(page.getContentStr());
    }
    // main �������
    public static void main2(String[] args) throws KeyManagementException, NoSuchAlgorithmException, IOException {
        MyCrawler crawler = new MyCrawler();
        // crawler.crawling(new
        // String[]{"https://m.wdzj.com/shuju/interfaceWapPlatDataPost"});

        Page page = RequestAndResponseTool
            .sendRequstAndGetResponse("https://m.wdzj.com/shuju/interfaceWapPlatDataPost");

        // Gson gson = new Gson();
        // gson.fromJson(page.getContentStr(), typeOfT)
        String bodydata = page.getContentStr();
        // JSONArray
        long start = System.currentTimeMillis();
        List<Object> data = JsonPath.read(bodydata, "$.data");
       
        System.out.println("����ʱ����" + (System.currentTimeMillis() - start));
        WdData wd = null;
        List<WdData> list = new ArrayList<>();
        int i=1;
        for (Object object : data) {
            // System.out.println(object.getClass());
            LinkedHashMap<String, String> map = (LinkedHashMap) object;
            wd = new WdData();
            wd.setIndex(i++);
            wd.setAmount(map.get("amount"));
            wd.setIncomeRate(map.get("incomeRate"));
            wd.setLoanPeriod(map.get("loanPeriod"));
            wd.setPlatName(map.get("platName"));
            wd.setStayStillOfTotal(map.get("stayStillOfTotal"));
            list.add(wd);
        }

        
        PoiExcelExport pee = new PoiExcelExport("E:/test.xls","sheet1"); 
        
        //����  
        String titleColumn[] = {"index","platName","amount","incomeRate","loanPeriod","stayStillOfTotal"};  
        String titleName[] = {"���","ƽ̨","�ɽ���","ƽ���ο�������(%)","ƽ���������(��)","�������(��Ԫ)"};  
        CellType cellType[] = {CellType.TYPE_INT,CellType.TYPE_STRING,CellType.TYPE_DOUBLE,CellType.TYPE_DOUBLE,CellType.TYPE_DOUBLE,CellType.TYPE_DOUBLE};  

        int titleSize[] = {10,18,18,18,18,18};  
        //�������� set������ȫ������  
        String colFormula[] = new String[6];  
//        colFormula[4] = "D@*12";   //���õ�5�еĹ�ʽ  
//        pee.setColFormula(colFormula);  
        pee.setAddress("A1:F1");  //�Զ�ɸѡ   
//        pee.setTitleBackColor(titleBackColor);
        pee.wirteExcel(titleColumn, titleName,cellType, titleSize, list);  
    }
}
