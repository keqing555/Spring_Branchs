package com.psi.util;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * 自定义容器获取实例对象
 */
public class MyApplicationContext {
    private Map<String, Object> map;

    //无参
    public MyApplicationContext() {
    }

    //有参
    public MyApplicationContext(String config) {
        //加载配置文件
        ResourceBundle bundle = ResourceBundle.getBundle(config);
        //获取配置文件中所有的key
        Enumeration<String> keys = bundle.getKeys();
        //初始化map
        map = new HashMap<>();
        //遍历keys
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            String value = bundle.getString(key);
            //创建配置文件中的实例对象
            try {
                Class aClass = Class.forName(value);
                Object object = aClass.newInstance();
                map.put(key, object);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    //获取实例对象方法
    public Object getBean(String key) {
        return map.get(key);
    }
}
