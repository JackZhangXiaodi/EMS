package com.baizhi.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;

@Configuration
@Repository
@ConfigurationProperties(value = "my")
public class MyRedis {
    private String host;
    private Integer port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Jedis getJedis(){
        Jedis jedis = new Jedis(host,port);
        return jedis;
    }
}
