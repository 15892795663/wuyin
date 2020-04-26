package org.wuy.demo.Controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Map<String, Object>> mapListChild = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 2; i++) {
            Map<String, Object> mapaa = new HashMap<String, Object>();
            mapaa.put("aaaa", "aaaa");
            mapaa.put("bbbb", "bbbb");
            mapaa.put("cccc", "cccc");
            mapListChild.add(mapaa);
        }
        map.put("aaaa", "aaaa");
        map.put("bbbb", "bbbb");
        map.put("cccc", "cccc");
        map.put("dddd", "dddd");
        map.put("eeee", "eeee");
        map.put("data", mapListChild);
        System.out.println(map.toString());

        Map<String, Object> mapaa = new HashMap<String, Object>();
        mapaa.put("aaaa", "aaaa");
        mapaa.put("bbbb", "bbbb");
        mapaa.put("cccc", "cccc");
        String s =  "{\"nodeId\":\"client.8\",\"batchNo\":\"PTMS_PAYMENT_INNER_302_10\",\"channelId\":\"PTMS\",\"clientName\":\"PTMS\",\"data\":{\"itemList\":[{\"amount\":11.11,\"erpNo\":\"INNER205\"}],\"item\":{\"resultMsg\":null,\"payId\":302,\"payResult\":90,\"actDate\":\"2019-08-29\"}},\"txDateTime\":\"20190829181644\",\"code\":6200,\"clientId\":\"PTMS\"}";
        Map map2 = parseJSON2Map(JSONObject.parseObject(s));
        String s1= "";
    }
    /**
     * 将json对象转换为HashMap
     * @param json
     * @return
     */
    public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            // 如果内层还是json数组的话，继续解析
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = (JSONObject) it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else if (v instanceof JSONObject) {
                // 如果内层是json对象的话，继续解析
                map.put(k.toString(), parseJSON2Map((JSONObject) v));
            } else {
                // 如果内层是普通对象的话，直接放入map中
                map.put(k.toString(), v);
            }
        }
        return map;
    }


}
