package com.baizhi.controller;

import com.baizhi.entity.Log;
import com.baizhi.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {
    //日志信息采集器对象
    private static final Logger log= LoggerFactory.getLogger(LogController.class);
    @Autowired
    private LogService logService;

    @RequestMapping("/showAll")
    public String  showAll(Model model,Integer page){
        if(page==null || page==0){
            page=1;
        }
        model.addAttribute("page",page);
        //起始条数
        Integer pageStart=(page-1)*5;
        //获取总条数
        Integer counts = logService.findCounts();
        //控制台日志打印
        log.info("总条数为："+counts);
        //总页码
        Integer count;
        if(counts%5==0){
            count=counts/5;
        }else{
            count=counts/5+1;
        }
        model.addAttribute("counts",count);
        //终止条数
        Integer pageEnd=page*5;
        List<Log> all = logService.findAll(pageStart,pageEnd);
        model.addAttribute("log",all);
        return "logShowAll";
    }
}
