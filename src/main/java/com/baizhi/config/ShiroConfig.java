package com.baizhi.config;

import com.baizhi.cache.MyCache;
import com.baizhi.cache.MyCacheManager;
import com.baizhi.realm.MyRealm;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;

@Configuration
public class ShiroConfig {
    @Value("${my.host}")
    private String host;
    @Value("${my.port}")
    private Integer port;
    /**
     * 需要将spring配置文件中的内容转变为java代码
     */
    @Bean
    public ShiroFilterFactoryBean creatSFB(){
//        创建声明shiro过滤器工厂
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
//        注入登陆路径 和错误路径
        shiroFilterFactoryBean.setLoginUrl("/views/login.jsp");
        shiroFilterFactoryBean.setUnauthorizedUrl("/views/error.jsp");

//        定义拦截规则
        HashMap<String,String> map = new HashMap<>();
        map.put("/css/**","anon");
        map.put("/img/**","anon");
        map.put("/views/**","anon");
        map.put("/user/**","user");
        map.put("/admin/**","anon");
        map.put("/**","user");
//        将拦截规则注入
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
//        将安全管理器注入
        shiroFilterFactoryBean.setSecurityManager(creatSm());
        return  shiroFilterFactoryBean;
    }
    @Bean
//    创建安全管理器
    public DefaultWebSecurityManager creatSm(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        注入realm域
        securityManager.setRealms(Arrays.asList(creatRealm()));
//        注入记住我 管理器
        securityManager.setRememberMeManager(creatRM());
//        注入缓存管理器
        securityManager.setCacheManager(creatCM());
        return securityManager;
    }

//    创建cacheManager 缓存管理器
//    @Bean
//    public CacheManager creatCM(){
//        CacheManager cacheManager = new MemoryConstrainedCacheManager();
//        return cacheManager;
//    }
    @Bean
    public MyCacheManager creatCM(){
        MyCacheManager myCacheManager = new MyCacheManager(creatMC());
        return myCacheManager;
    }
//    创建自定义shiro缓存类
    @Bean
    public MyCache creatMC(){
        MyCache myCache = new MyCache(host, port);
        return myCache;
    }
//    创建Realm
    @Bean
    public MyRealm creatRealm(){
        MyRealm myRealm = new MyRealm();
        return myRealm;
}
//    记住我（设置）创建记住我管理器
    @Bean
    public CookieRememberMeManager creatRM(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        注入cookie对象
        cookieRememberMeManager.setCookie(creatSC());
        return cookieRememberMeManager;
    }
//     创建cookie对象
    @Bean
    public SimpleCookie creatSC(){
        SimpleCookie cookie = new SimpleCookie();
//        设置cookie存活时间
        cookie.setMaxAge(604800);
//        设置cookie的名称
        cookie.setName("rm");
//        设置cookie的作用域
        cookie.setPath("/");
        return  cookie;
    }
}
