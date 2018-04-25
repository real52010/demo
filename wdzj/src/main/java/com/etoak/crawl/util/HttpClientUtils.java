package com.etoak.crawl.util;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.etoak.crawl.page.Page;

/**
 * 依赖的jar包有：commons-lang-2.6.jar、httpclient-4.3.2.jar、httpcore-4.3.1.jar、commons
 * -io-2.4.jar
 * 
 * @author zhaoyb
 */
public class HttpClientUtils {

    public static final int     connTimeout          = 10000;
    public static final int     readTimeout          = 10000;
    public static final String  charset              = "UTF-8";
    private static final String default_content_type = "application/x-www-form-urlencoded";
    private static HttpClient   client               = null;

    static {
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(128);
        cm.setDefaultMaxPerRoute(128);
        client = HttpClients.custom().setConnectionManager(cm).build();
    }

    public static Page get(String url) throws Exception {
        return get(url, charset, null, null);
    }

    public static Page get(String url, String charset) throws Exception {
        return get(url, charset, connTimeout, readTimeout);
    }

    /**
     * 发送一个 GET 请求
     * 
     * @param url
     * @param charset
     * @param connTimeout 建立链接超时时间,毫秒.
     * @param readTimeout 响应超时时间,毫秒.
     * @return
     * @throws ConnectTimeoutException 建立链接超时
     * @throws SocketTimeoutException 响应超时
     * @throws Exception
     */
    public static Page get(String url, String charset, Integer connTimeout,
                           Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception {

        HttpClient client = null;
        HttpGet get = new HttpGet(url);
        try {
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (connTimeout != null) {
                customReqConf.setConnectTimeout(connTimeout);
            }
            if (readTimeout != null) {
                customReqConf.setSocketTimeout(readTimeout);
            }
            get.setConfig(customReqConf.build());

            HttpResponse res = null;

            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(get);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(get);
            }

            // result = IOUtils.toString(res.getEntity().getContent(), charset);

            String body = EntityUtils.toString(res.getEntity(), charset);
            Page page = new Page(body, url, charset); // 封装成为页面
            return page;
        } finally {
            get.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    public static Page postParameters(String url, String queryStr) throws ConnectTimeoutException,
                                                                   SocketTimeoutException, Exception {
        return post(url, queryStr, default_content_type, charset, null, connTimeout, readTimeout);
    }

    public static Page postParameters(String url, String queryStr, String charset, Integer connTimeout,
                                      Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException,
                                                           Exception {
        return post(url, queryStr, default_content_type, charset, null, connTimeout, readTimeout);
    }

    public static Page postParameters(String url, Map<String, String> params) throws ConnectTimeoutException,
                                                                              SocketTimeoutException, Exception {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static Page postParameters(String url, Map<String, String> params, Integer connTimeout,
                                      Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException,
                                                           Exception {
        return postForm(url, params, null, connTimeout, readTimeout);
    }

    public static Page post(String url, String body) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        try {
          return post(url, body, default_content_type,  charset,null, connTimeout, readTimeout);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 发送一个 Post 请求, 使用指定的字符集编码.
     * 
     * @param url
     * @param body RequestBody
     * @param mimeType 例如 application/xml "application/x-www-form-urlencoded"
     * a=1&b=2&c=3
     * @param charset 编码
     * @param connTimeout 建立链接超时时间,毫秒.
     * @param readTimeout 响应超时时间,毫秒.
     * @return ResponseBody, 使用指定的字符集编码.
     * @throws ConnectTimeoutException 建立链接超时异常
     * @throws SocketTimeoutException 响应超时
     * @throws Exception
     */
    public static Page post(String url, String body, String contentType, String charset, Map<String, String> headers,
                            Integer connTimeout,
                            Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception {
        HttpClient client = null;
        HttpPost post = new HttpPost(url);
        // httpPost.setHeader("Content-type",
        // "application/x-www-form-urlencoded");
        // httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0;
        // Windows NT; DigExt)");
        try {
            if (StringUtils.isNoneBlank(body)) {
                HttpEntity entity = new StringEntity(body, ContentType.create(contentType, charset));
                post.setEntity(entity);
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (connTimeout != null) {
                customReqConf.setConnectTimeout(connTimeout);
            }
            if (readTimeout != null) {
                customReqConf.setSocketTimeout(readTimeout);
            }
            if (headers != null && !headers.isEmpty()) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            post.setConfig(customReqConf.build());

            HttpResponse res;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(post);
            }

            // result = IOUtils.toString(res.getEntity().getContent(), charset);
            // 按指定编码转换结果实体为String类型
            body = EntityUtils.toString(res.getEntity(), charset);
            Page page = new Page(body, url, charset); // 封装成为页面
            return page;
        } finally {
            post.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    /**
     * 提交form表单
     * 
     * @param url
     * @param params
     * @param connTimeout
     * @param readTimeout
     * @return
     * @throws ConnectTimeoutException
     * @throws SocketTimeoutException
     * @throws Exception
     */
    public static Page postForm(String url, Map<String, String> params, Map<String, String> headers,
                                Integer connTimeout,
                                Integer readTimeout) throws ConnectTimeoutException, SocketTimeoutException, Exception {

        HttpClient client = null;
        HttpPost post = new HttpPost(url);
        try {
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> formParams = new ArrayList<org.apache.http.NameValuePair>();
                Set<Entry<String, String>> entrySet = params.entrySet();
                for (Entry<String, String> entry : entrySet) {
                    formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);
                post.setEntity(entity);
            }

            if (headers != null && !headers.isEmpty()) {
                for (Entry<String, String> entry : headers.entrySet()) {
                    post.addHeader(entry.getKey(), entry.getValue());
                }
            }
            // 设置参数
            Builder customReqConf = RequestConfig.custom();
            if (connTimeout != null) {
                customReqConf.setConnectTimeout(connTimeout);
            }
            if (readTimeout != null) {
                customReqConf.setSocketTimeout(readTimeout);
            }
            post.setConfig(customReqConf.build());
            HttpResponse res = null;
            if (url.startsWith("https")) {
                // 执行 Https 请求.
                client = createSSLInsecureClient();
                res = client.execute(post);
            } else {
                // 执行 Http 请求.
                client = HttpClientUtils.client;
                res = client.execute(post);
            }
            // return IOUtils.toString(res.getEntity().getContent(), "UTF-8");
            String body = EntityUtils.toString(res.getEntity(), charset);
            Page page = new Page(body, url, charset); // 封装成为页面
            return page;
        } finally {
            post.releaseConnection();
            if (url.startsWith("https") && client != null && client instanceof CloseableHttpClient) {
                ((CloseableHttpClient) client).close();
            }
        }
    }

    /**
     * 从 response 里获取 charset
     * 
     * @param ressponse
     * @return
     */
    @SuppressWarnings("unused")
    private static String getCharsetFromResponse(HttpResponse ressponse) {
        // Content-Type:text/html; charset=GBK
        if (ressponse.getEntity() != null && ressponse.getEntity().getContentType() != null
            && ressponse.getEntity().getContentType().getValue() != null) {
            String contentType = ressponse.getEntity().getContentType().getValue();
            if (contentType.contains("charset=")) {
                return contentType.substring(contentType.indexOf("charset=") + 8);
            }
        }
        return null;
    }

    /**
     * 创建 SSL连接
     * 
     * @return
     * @throws GeneralSecurityException
     */
    private static CloseableHttpClient createSSLInsecureClient() throws GeneralSecurityException {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {

                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();

            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, new X509HostnameVerifier() {

                @Override
                public boolean verify(String arg0, SSLSession arg1) {
                    return true;
                }

                @Override
                public void verify(String host, SSLSocket ssl) throws IOException {
                }

                @Override
                public void verify(String host, X509Certificate cert) throws SSLException {
                }

                @Override
                public void verify(String host, String[] cns, String[] subjectAlts) throws SSLException {
                }

            });

            return HttpClients.custom().setSSLSocketFactory(sslsf).build();

        } catch (GeneralSecurityException e) {
            throw e;
        }
    }

    public static void main(String[] args) {
        try {
            // String contentType = "application/x-www-form-urlencoded";
            // String queryStr = "name=12&page=34";

            // Map<string, string=""> headers = new HashMap<string,
            // string="">();
            // //最后在header中的格式(中间是英文空格)为Authorization:APPCODE
            // 83359fd73fe94948385f570e3c139105
            // headers.put("Authorization", "APPCODE " + appcode);
            // Map<string, string=""> querys = new HashMap<string, string="">();
            // querys.put("mobile", "这里填写你要发送的手机号码");
            // //querys.put("param", "code:1234");
            // //querys.put("param", "这里填写你和商家定义的变量名称和变量值填写格式看上一行代码");
            // querys.put("tpl_id", "这里填写你和商家商议的模板");
            // Map<string, string=""> bodys = new HashMap<string, string="">();
            //
            // http://domain.aliyuncs.com/?Action=CheckDomain
            // &DomainName=abc.com
            // &<公共请求参数>
            Page page = post("http://domain.aliyuncs.com/?Action=CheckDomain", null);
            System.out.println(page.getHtml());

        } catch (ConnectTimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
