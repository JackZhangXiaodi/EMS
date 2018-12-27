package com.baizhi.service;

import com.baizhi.dao.LogDAO;
import com.baizhi.entity.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class LogServiceImpl implements LogService {
    @Autowired
    private LogDAO logDAO;
//查询数据库的有效条数
    @Override
    public Integer findCounts() {
        Integer integer = logDAO.queryCounts();
        return integer;
    }
//展示所有的方法
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Log> findAll(Integer page,Integer endPage) {
        List<Log> logs = logDAO.queryAll(page,5);
        return logs;
    }
//添加日志信息
    @Override
    public void addLog(Log log) {
        log.setTime(new Date());
        log.setId(UUID.randomUUID().toString());
        logDAO.insert(log);
    }
}
