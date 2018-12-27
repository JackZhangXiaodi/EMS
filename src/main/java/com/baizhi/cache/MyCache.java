package com.baizhi.cache;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import redis.clients.jedis.Jedis;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

/**
 * 自定义shiro的自定义缓存实现
 */
public class MyCache implements Cache {
//    声明成员变量 jedis
    private Jedis jedis;

    public MyCache(String host , Integer port){
        this.jedis = new Jedis(host,port);
    }
    /**
     * 根据key获取value
    * @param k
     * @return
     * @throws CacheException
     */
    @Override
    public Object get(Object k) throws CacheException {
//        需要判断查询的value是否为空
        byte[] bytes = jedis.get(SerializationUtils.serialize((Serializable) k));
        if(bytes !=null){
//            因为返回值是一个Object对象 所以需要将byte[]数组 反序列化为对象
            Object o = SerializationUtils.deserialize(bytes);
            return o;
        }
        return null;
    }

    /**
     * reids 存储缓存数据方法
     * @param k
     * @param v
     * @return
     * @throws CacheException
     */
    @Override
    public Object put(Object k, Object v) throws CacheException {
//        将对象 kv 序列化 添加到redis
        String set = jedis.set(SerializationUtils.serialize((Serializable) k), SerializationUtils.serialize((Serializable) v));
        return set;
    }
//  根据key值删除所对应的值
    @Override
    public Object remove(Object k) throws CacheException {
        return jedis.del(SerializationUtils.serialize((Serializable)k));
    }
//  清空缓存数据库
    @Override
    public void clear() throws CacheException {
        jedis.flushDB();
    }
//  获取数据库中数据的长度
    @Override
    public int size() {
        Long size = jedis.dbSize();
        int i = size.intValue();
        return i;
    }
//  获取所有key的集合
    @Override
    public Set keys() {
        Set<String> keys = jedis.keys("*");
        return keys;
    }
//  获取所有的values的集合
    @Override
    public Collection values() {
//        获取所有的key
        Set<String> keys = jedis.keys("*");
//        创建一个集合
        ArrayList<String> list = new ArrayList<String>();
//        遍历所有的key
        keys.forEach(s -> {
//            获取每一个key所对应的值
            String s1 = jedis.get(s);
            list.add(s1);
        });
        return list;
    }
}
