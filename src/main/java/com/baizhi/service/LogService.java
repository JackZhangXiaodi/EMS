package com.baizhi.service;


import com.baizhi.entity.Log;

import java.util.List;

public interface LogService {
//    展示所有的日志信息
    List<Log> findAll(Integer page,Integer endPage);

//    查询数据库中所有的有效条数
    Integer findCounts();

//    添加操作日志信息
    void addLog(Log log);
}
