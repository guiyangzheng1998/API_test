package com.xuelangyunn.api.java;

/**
 * @author shkstart
 * @create 2021-04-29 15:01
 */
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.xuelangyunn.test.Data;
import com.xuelangyunn.test.DojsonUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;


public class JavaApiDemoJob implements JavaApiJobBase {
    /**
     * 通过访问url获取json数据，回写数据库
     * @param args
     */
//    public static void main(String[] args) {
//        /**
//         * 将json字符串转化为RetuValues对象
//         */
//    //        把json字符串转化为javabean（ReturnValues）对象
////        ReturnValues p=JSON.parseObject(getJSONString(),ReturnValues.class);
////        //System.out.println(p);
////        JSONArray formList=p.getData();
////        for (Object jsonObject : formList
////        ) {
////            //把JSONArray对象转化为javaB（Data）对象
////            Data DataObject = JSONObject.parseObject(jsonObject.toString(), Data.class);
////            System.out.println(DataObject);
////            //platformList.put(platformModel.getId(), platformModel);
////        }
//
//        /**
//         * 1.将json字符串中的转化为json对象，
//         * 2.然后把json数组转化为JSONArray对象；
//         * 3.把JSONArray对象转化为JavaBean（Data）对象
//         */
//        try {
//        JSONObject jsonObject = JSON.parseObject(getJSONString());
//        JSONArray jsonArray=jsonObject.getJSONArray("data");
//
//
//            ComboPooledDataSource cpds=null;
//            Connection conn=null;
//            PreparedStatement ps=null;
//            cpds=new ComboPooledDataSource();
//            conn = cpds.getConnection();
//            String string ="insert into DATA_GOVERNANCE_RESULTS values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//            ps=conn.prepareStatement(string);
//        for (Object dataObject:jsonArray) {
//            Data data=JSON.parseObject(dataObject.toString(),Data.class);
//                ps.setInt(1,data.getCustomer_zb());
//                ps.setInt(2,data.getCustomer_zf());
//                ps.setInt(3,data.getSupplier_zb());
//                ps.setInt(4,data.getSupplier_zf());
//                ps.setInt(5,data.getMaterail());
//                ps.setInt(6,data.getOrg());
//                ps.setInt(7,data.getAccount());
//                ps.setInt(8,data.getAccountingbook());
//                ps.setInt(9,data.getCostregionn());
//                ps.setInt(10,data.getBank());
//                ps.setInt(11,data.getBankacct());
//                ps.setInt(12,data.getDept());
//                ps.setInt(13,data.getEmp());
//                ps.setInt(14,data.getStordoc());
//                ps.setInt(15,data.getCountry());
//                ps.setInt(16,data.getMeasdoc());
//                ps.setInt(17,data.getPortdoc());
//                ps.setInt(18,data.getCurrtype());
//                ps.executeUpdate();
//            //System.out.println(data.getDept());
//            //System.out.println(data);
//        }
//            ps.close();
//            conn.close();
//        }catch (Exception e) {
//            e.toString();
//        }
//    }



    public static void main(String[] args) {


        System.out.println(new JavaApiDemoJob().run(new HashMap<>()));

    }



    @Override
    public Object run(Map<String,Object> param) {
        JavaApiDemoJob.Result result = new JavaApiDemoJob.Result();
        if(getList().isEmpty()){
            result.setParam(param);
            result.setStatus(2);
            result.setMsg("处理失败");
        }else {
            result.setParam(param);
            result.setStatus(1);
            result.setMsg("处理成功");
        }
        result.setData(getList());
        return result;
    }


    class Result {
        private Integer status;

        private Map<String, Object> param;

        private String msg;
        private List data;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Map<String, Object> getParam() {
            return param;
        }

        public void setParam(Map<String, Object> param) {
            this.param = param;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public List getData() {
            return data;
        }

        public void setData(List data) {
            this.data = data;
        }
    }



   public static List getList() {
JSONObject jsonObject =JSON.parseObject(DojsonUtil.getJSONString());
    JSONArray jsonArray=jsonObject.getJSONArray("data");
    List list= new ArrayList();
    Map <String,Object>map=null;
        for (Object ArrayList:jsonArray) {
        map=new HashMap<String,Object>();
        for (Object entry:((Map)ArrayList).entrySet()) {
            map.put(((Map.Entry) entry).getKey().toString(),((Map.Entry) entry).getValue());
        }
        list.add(map);
    }
       return  list;
   }

}

