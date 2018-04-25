package com.etoak.crawl;

import java.io.File;
import java.io.FileWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import com.etoak.crawl.page.Page;
import com.etoak.crawl.util.HttpClientUtils;
import com.jayway.jsonpath.JsonPath;

public class AliYunApi {

    private static final String accessKeyId         = "LTAIoHqHoMZdX5o7";
    private static final String accessKeySecret     = "iYkeVz0wv3z4Zr1xaWtLVQ1dHbbJNw";

    private static final String ENCODING            = "UTF-8";
    private static final String ALGORITHM           = "HmacSHA1";

    private static final String HTTP_METHOD         = "POST";

    // 不同的产品API version不一样
    private static final String urlAPIVersion       = "2016-05-11";
    private static final String urlSecALG           = "HMAC-SHA1";
    private static final String urlSecVer           = "1.0";
    private static String       urlAccKeyID         = "";
    private static String       ulrSeckey           = "";

    // private static String urlSecNonce = UUID.randomUUID().toString();
    private static final String urlFromat           = "json";
    private static String       ulrTimeStamp        = formatIso8601Date(new Date());

    private static final String ISO8601_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

    // public static void main(String[] args) throws Exception {
    // System.out.println(AliYunApi.creatApiURL(accessKeyId, accessKeySecret,
    // "DomainName=abc.com"));
    // }

    private static String formatIso8601Date(Date date) {
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return df.format(date);
    }

    private static String percentEncode(String value) throws UnsupportedEncodingException {

        return value != null ? URLEncoder.encode(value, "utf-8").replace("+", "%20").replace("*", "%2A").replace("%7E",
            "~") : null;

    }

    public static String creatApiURL(String url, String strAccKeyID, String strSeckey, String strcmd) throws Exception {
        // String signature = "";
        // urlAccKeyID = strAccKeyID;
        // ulrSeckey = strSeckey;
        // ulrSeckey = ulrSeckey + "&";
        // String urlNonce = UUID.randomUUID().toString();
        //
        // String phrase = strcmd;
        //
        // Date date = new Date();
        // SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        // df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        // ulrTimeStamp = df.format(date);
        //
        // Map<String, String> parameters = new HashMap<String, String>();
        // // 加入公共请求参数
        // parameters.put("Format", urlFromat);
        // parameters.put("Version", urlAPIVersion);
        // parameters.put("SignatureMethod", urlSecALG);
        // parameters.put("SignatureNonce", urlNonce);
        // parameters.put("SignatureVersion", urlSecVer);
        // parameters.put("AccessKeyId", urlAccKeyID);
        // parameters.put("Timestamp", ulrTimeStamp);
        //
        // String delims1 = ";";
        // String[] tokens1 = phrase.split(delims1);
        //
        // for (int i = 0; i < tokens1.length; i++) {
        // String delims2 = "=";
        // String[] tokens2 = tokens1[i].split(delims2);
        //
        // parameters.put(tokens2[0], tokens2[1]);
        // }
        //
        // // 对参数进行排序
        // String[] sortedKeys = parameters.keySet().toArray(new String[] {});
        // Arrays.sort(sortedKeys);
        //
        // try {
        //
        // final String SEPARATOR = "&";
        //
        // // 生成stringToSign字符串
        //
        // StringBuilder stringToSign = new StringBuilder();
        //
        // stringToSign.append("POST").append(SEPARATOR);
        //
        // stringToSign.append(percentEncode("/")).append(SEPARATOR);
        //
        // StringBuilder canonicalizedQueryString = new StringBuilder();
        //
        // for (String key : sortedKeys) {
        //
        // // 这里注意对key和value进行编码
        //
        // canonicalizedQueryString.append("&")
        // .append(percentEncode(key))
        //
        // .append("=")
        //// .append(percentEncode((String) parameters.get(key)));
        // .append(parameters.get(key));
        //
        // }
        //
        // // 这里注意对canonicalizedQueryString进行编码
        //
        // stringToSign.append(percentEncode(canonicalizedQueryString.toString()
        //
        // .substring(1)));
        //
        // final String ALGORITHM = "HmacSHA1";
        //
        // final String ENCODING = "UTF-8";
        //
        // String key = "testsecret&";
        //
        // Mac mac = Mac.getInstance(ALGORITHM);
        //
        // mac.init(new SecretKeySpec(key.getBytes(ENCODING), ALGORITHM));
        //
        // byte[] signData =
        // mac.doFinal(stringToSign.toString().getBytes(ENCODING));
        //
        // signature = new String(Base64.encodeBase64(signData));
        //
        // signature = percentEncode(signature);
        //
        // StringBuilder urlReq = new StringBuilder();
        // // vpc的调用入口，如果是云监控的入口，则是http://metrics.cn-beijing.aliyuncs.com/的形式
        // urlReq.append(url);
        // urlReq.append("?Signature=");
        // urlReq.append(signature);
        // System.out.println(signature);
        // for (String key2 : sortedKeys) {
        // urlReq.append("&").append(key2).append("=").append(parameters.get(key2));
        // }
        //
        // return urlReq.toString();
        //
        // } catch (InvalidKeyException e)
        //
        // {
        //
        // // TODO Auto-generated catch block
        //
        // e.printStackTrace();
        //
        // } catch (
        //
        // UnsupportedEncodingException e)
        //
        // {
        //
        // // TODO Auto-generated catch block
        //
        // e.printStackTrace();
        //
        // } catch (
        //
        // NoSuchAlgorithmException e)
        //
        // {
        //
        // // TODO Auto-generated catch block
        //
        // e.printStackTrace();
        //
        // } catch (
        //
        // IllegalStateException e)
        //
        // {
        //
        // // TODO Auto-generated catch block
        //
        // e.printStackTrace();
        //
        // }
        //
        // return null;

        urlAccKeyID = strAccKeyID;
        ulrSeckey = strSeckey;
        ulrSeckey = ulrSeckey + "&";
        String urlNonce = UUID.randomUUID().toString();

        String phrase = strcmd;

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(ISO8601_DATE_FORMAT);
        df.setTimeZone(new SimpleTimeZone(0, "GMT"));
        ulrTimeStamp = df.format(date);

        Map<String, String> parameters = new HashMap<String, String>();
        // 加入公共请求参数
        parameters.put("Format", urlFromat);
        parameters.put("Version", urlAPIVersion);
        parameters.put("SignatureMethod", urlSecALG);
        parameters.put("SignatureNonce", urlNonce);
        parameters.put("SignatureVersion", urlSecVer);
        parameters.put("AccessKeyId", urlAccKeyID);
        parameters.put("Timestamp", ulrTimeStamp);

        String delims1 = ";";
        String[] tokens1 = phrase.split(delims1);

        for (int i = 0; i < tokens1.length; i++) {
            String delims2 = "=";
            String[] tokens2 = tokens1[i].split(delims2);

            parameters.put(tokens2[0], tokens2[1]);
        }

        // 对参数进行排序
        String[] sortedKeys = parameters.keySet().toArray(new String[] {});
        Arrays.sort(sortedKeys);
        final String SEPARATOR = "&";
        // 生成stringToSign字符串
        StringBuilder stringToSign = new StringBuilder();
        stringToSign.append(HTTP_METHOD).append(SEPARATOR);

        String value = "/";
        try {
            value = URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        stringToSign.append(value).append(SEPARATOR);

        StringBuilder canonicalizedQueryString = new StringBuilder();
        for (String key : sortedKeys) {
            // 这里注意对key和value进行编码
            String value1 = key;
            try {
                value1 = URLEncoder.encode(value1, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E",
                    "~");
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            String value2 = parameters.get(key);
            try {
                value2 = URLEncoder.encode(value2, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E",
                    "~");
            } catch (UnsupportedEncodingException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

            canonicalizedQueryString.append("&").append(value1).append("=").append(value2);

        }
        // 这里注意对canonicalizedQueryString进行编码
        String value3 = canonicalizedQueryString.toString().substring(1);
        try {
            value3 = URLEncoder.encode(value3, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        stringToSign.append(value3);

        Mac mac = null;
        try {
            mac = Mac.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        try {

            mac.init(new SecretKeySpec(ulrSeckey.getBytes(ENCODING), ALGORITHM));
        } catch (InvalidKeyException | UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        byte[] signData = null;
        try {
            signData = mac.doFinal(stringToSign.toString().getBytes(ENCODING));
        } catch (IllegalStateException | UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        String signature = new String(Base64.encodeBase64(signData));

        value = signature;
        try {
            value = URLEncoder.encode(value, ENCODING).replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        String urlSignature = value;

        StringBuilder urlReq = new StringBuilder();
        // vpc的调用入口，如果是云监控的入口，则是http://metrics.cn-beijing.aliyuncs.com/的形式
        urlReq.append(url);
        urlReq.append("?Signature=");
        urlReq.append(urlSignature);

        for (String key : sortedKeys) {
            urlReq.append("&").append(key).append("=").append(parameters.get(key));
        }

        // System.out.println(urlReq.toString());

        return urlReq.toString();

    }

    public static void main(String[] args) throws Exception {
        String filePath = "E://domain.txt";

        String suffix = ".com";
        File file = new File(filePath);

        if (file.exists()) {
            file.delete();
        }
        FileWriter fw = new FileWriter(file);
        String url = null;
        String dominName = null;
        int availSize = 0;
        for (int i = 97; i < 123; i++) {
            for (int j = 97; j < 123; j++) {
                for (int m = 97; m < 123; m++) {
                    for (int n = 97; n < 123; n++) {
                        dominName = String.valueOf((char) i) + String.valueOf((char) j) + String.valueOf((char) m)
                                    + String.valueOf((char) n) + suffix;
                        System.out.println(dominName);
                        url = AliYunApi.creatApiURL("http://domain.aliyuncs.com",
                            accessKeyId,
                            accessKeySecret,
                            "Action=CheckDomain;DomainName=" + dominName);
                        Page page = HttpClientUtils.post(url, null);
                        if (page != null) {
                            Integer avail = JsonPath.read(page.getHtml(), "$.Avail");
                            if (avail.intValue() == 1) {
                                fw.write(dominName + "\r\n");
                                availSize++;
                                if (availSize % 10 == 0) {
                                    fw.flush();
                                }
                            }

                        }

                    }
                }
            }

        }

        fw.flush();
        fw.close();
    }
}
