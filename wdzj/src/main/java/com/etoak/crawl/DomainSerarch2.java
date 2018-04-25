package com.etoak.crawl;

import java.io.File;
import java.io.FileWriter;

import com.etoak.crawl.page.Page;
import com.etoak.crawl.util.HttpClientUtils;
import com.jayway.jsonpath.JsonPath;

public class DomainSerarch2 {

    private static final String accessKeyId     = "LTAIoHqHoMZdX5o7";
    private static final String accessKeySecret = "iYkeVz0wv3z4Zr1xaWtLVQ1dHbbJNw";

    public static void main(String[] args) throws Exception {

        String filePath = "E://domainxyz.txt";

        String suffix = ".xyz";
        File file = new File(filePath);

        if (file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter(file);
        String url = null;
        String dominName = null;
        int availSize = 0;
        for (int i = 10000; i < 100000; i++) {
           
//            for (int j = 97; j < 123; j++) {
//                for (int m = 97; m < 123; m++) {
//                    for (int n = 97; n < 123; n++) {
                        dominName = String.valueOf( i) 
//                                    + String.valueOf((char) j) 
//                                    + String.valueOf((char) m)
//                                    + String.valueOf((char) n) 
                                    + suffix;
//                        if(  dominName.indexOf("3")>0){
//                            continue;
//                        }
//                        if(  dominName.indexOf("4")>0){
//                            continue;
//                        }
                       
                        url = AliYunApi.creatApiURL("http://domain.aliyuncs.com",
                            accessKeyId,
                            accessKeySecret,
                            "Action=CheckDomain;DomainName=" + dominName);
                        Page page = HttpClientUtils.post(url, null);
                        if (page != null) {
                            Integer avail = JsonPath.read(page.getHtml(), "$.Avail");
                            if (avail.intValue() == 1) {
                                System.err.println(dominName);
                                fw.write(dominName + "\r\n");
                                availSize++;
                                if (availSize % 10 == 0) {
                                    fw.flush();
                                }
                            }else{
                                System.out.println(dominName);
                            }
//
//                        }
//
//                    }
//                }
            }

        }

        fw.flush();
        fw.close();
    }
}
