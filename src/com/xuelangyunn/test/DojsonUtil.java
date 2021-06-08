package com.xuelangyunn.test;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Properties;

/**
 * @author shkstart
 * @create 2021-04-29 15:07
 */
public class DojsonUtil {
    private static String url1;

//静态块，用来加载配置文件读取dojson.propertis的url链接
    static {
        Properties properties = new Properties();
        ClassLoader classLoader = DojsonUtil.class.getClassLoader();
        try {
            properties.load(classLoader.getResourceAsStream("dojson.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        url1 = properties.getProperty("url1");
    }
    public DojsonUtil() {
    }
    //获取URL连接字符串
    public static String getUrl1() {
        return url1;
    }

    public static void setUrl1(String url1) {
        DojsonUtil.url1 = url1;
    }



    public static Map<String, Object> getDatatoMap(){
        JSONObject jsonObject = JSON.parseObject(getJSONString());
        JSONArray jsonArray=jsonObject.getJSONArray("data");
        Map<String,Object> param= (Map<String, Object>) JSON.parseArray(jsonArray.toString());
        return param;
    }


    public static String getJSONString (){
        //创建一个URL类的对象url
        URL url=null;
        try {
            url = new URL(getUrl1());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
//通过对象url打开网络连接,并获取一个网络连接对象con
        URLConnection con= null;
        try {
            con = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
//通过网络连接对象con获取到读取网页内容的输入流is
        InputStream is= null;
        try {
            is = con.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
//将字节流装饰成字符流
        InputStreamReader re=new InputStreamReader(is);
//再将字符流装饰成可以读取一行的字符流
        BufferedReader br=new BufferedReader(re);
//通过字符流br读取一行信息,将其存储到变量str里
        String str= null;
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
//输出到控制台
        //System.out.println(str);
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            re.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    @Override
    public String toString() {
        return "DojsonUtil{}";
    }
}
