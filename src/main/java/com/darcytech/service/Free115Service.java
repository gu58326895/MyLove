package com.darcytech.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.CookiePolicy;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Maps;

@Service
public class Free115Service {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final static DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-M-d");
    private final static DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");
    private final static DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("yyyy年M月d日");

    private Map<LocalDate, Boolean> map = Maps.newConcurrentMap();

    private final static String pattern = "<p>.*?</p>";

    @Autowired
    private MailService mailService;

    public void dispatch() {

        logger.info("跑任务，时间：{}", dateTimeFormatter1.format(LocalDateTime.now()));
        if (map.get(LocalDate.now(ZoneId.of("Asia/Shanghai"))) == null) {
            LocalDate now = LocalDate.now(ZoneId.of("Asia/Shanghai"));
            String url = getUrl(now);
            if(url!=null && url.length() > 0) {
                sendMessage(url, now);
            } else {
                logger.info("未发布，时间：{}", dateTimeFormatter1.format(LocalDateTime.now(ZoneId.of("Asia/Shanghai"))));
            }
        } else {
            logger.info("今天发过了，时间：{}", dateTimeFormatter1.format(LocalDateTime.now(ZoneId.of("Asia/Shanghai"))));
        }
    }



    private String getUrl(LocalDate time){
        String url = "http://in115.com/";
        HttpClient client = new DefaultHttpClient();
        HttpClientParams.setCookiePolicy(client.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        HttpGet getHttp = new HttpGet(url);
        getHttp.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
        getHttp.addHeader("Cookie", "_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
        HttpResponse response;
        try {
            response = client.execute(getHttp);
            HttpEntity entity = response.getEntity();
            String content = convertStreamToString(entity.getContent());
            String key = dateTimeFormatter2.format(time);
            if (content.contains(key)) {

                    String p = "<a title=\""+key+".*?>" ;
                    Pattern r = Pattern.compile(p);
                    Matcher m = r.matcher(content);
                    if(m.find()){
                        String text = m.group();
                        Matcher m1 = Pattern.compile("http.*?html").matcher(text);
                        if(m1.find()){
                            map.clear();
                            map.put(LocalDate.now(ZoneId.of("Asia/Shanghai")), true);
                            return m1.group();
                        }
                    }
            }

            return null;

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }
        return null;
    }



    private void sendMessage(String url, LocalDate time) {
         /* 实例化一个HttpClient客户端 */
        HttpClient client = new DefaultHttpClient();
        HttpClientParams.setCookiePolicy(client.getParams(), CookiePolicy.BROWSER_COMPATIBILITY);
        HttpGet getHttp = new HttpGet(url);
        getHttp.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/42.0.2311.152 Safari/537.36");
        getHttp.addHeader("Cookie", "_gat=1; nsfw-click-load=off; gif-click-load=on; _ga=GA1.2.1861846600.1423061484");
        HttpResponse response;
        try {
             /*获得信息载体*/
            response = client.execute(getHttp);
            HttpEntity entity = response.getEntity();

            String content = convertStreamToString(entity.getContent());
            if (content.contains(dateTimeFormatter.format(time))) {
                    Pattern r = Pattern.compile(pattern);
                    // 现在创建 matcher 对象
                    Matcher m = r.matcher(content);
                    String text = "没有找到";
                    while (m.find()) {
                        if (m.group().contains("<br/>")) {
                            text = m.group();
                            break;
                        }
                    }
                    logger.info("发送email，时间：{}", dateTimeFormatter1.format(LocalDateTime.now(ZoneId.of("Asia/Shanghai"))));
                    mailService.sendMail("wazqy12345@163.com", "115年费劵通知",  text);
            }

        }  catch (IOException e) {
            e.printStackTrace();
        } finally {
            client.getConnectionManager().shutdown();
        }

    }

    private static String convertStreamToString(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("/n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        new Free115Service().dispatch();
    }
}
