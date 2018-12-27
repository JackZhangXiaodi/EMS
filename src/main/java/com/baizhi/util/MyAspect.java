package com.baizhi.util;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;


@Component// spring中管理组建的注解
@Aspect //声明这个类是一个额外功能类
public class MyAspect {
    //设置日志的打印(当前类对象)
    private static final Logger LOG = LoggerFactory.getLogger(MyAspect.class);
    //声明静态类 使用static 修饰类 在全类中唯一
    private static Log log = new Log();
    //声明jedis
    private Jedis jedis;
    @Autowired
    private LogService logService;
    /**
     * 额外功能
     */
//    声明定义切入点方法
    @Pointcut(value = "execution(* com.baizhi.service..*.*(..))")
    public void pc(){}

//    环绕通知
    @Around(value = "pc()")
    public Object around(ProceedingJoinPoint pjp){
        //获取方法的签名对象
         MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        String name = methodSignature.getMethod().getName();
        LOG.info(name);
        Object o=null;
        if(name.equals("login")){
            Object[] args = pjp.getArgs();
            //获取管理员的昵称
            String username = (String) args[0];
            log.setUname(username);
        }//判断是否为添加方法
        if(name.equals("add")){
            //获取方法的参数列表
            Object[] arg = pjp.getArgs();
            log.setArticle("添加用户信息："+arg[0]);
            logService.addLog(log);
        }else if(name.equals("modify")){
            //获取方法的参数列表
            Object[] arg = pjp.getArgs();
            log.setArticle("修改用户信息："+arg[0]);
            logService.addLog(log);
        }else if(name.equals("remove")){
            //获取方法的参数列表
            Object[] arg = pjp.getArgs();
            log.setArticle("删除id为："+arg[0]+"的用户");
            logService.addLog(log);
        }else if(name.equals("register")){
            //获取方法的参数列表
            Object[] arg = pjp.getArgs();
            log.setArticle("添加管理员信息："+arg[0]);
            logService.addLog(log);
        }
        try {
             log.setResult("成功");
             o = pjp.proceed();//继续执行后续代码
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            log.setArticle("操作失败");
            log.setResult("失败");
        }
        return o;
    }
}
