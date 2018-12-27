package com.baizhi.dao;

import com.baizhi.entity.Log;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface LogDAO {
//    查询所有的日志信息
    @Select("select id,uname,time,article,result from t_log order by time desc limit #{page},#{endPage}")
    List<Log> queryAll(@Param("page") Integer page,@Param("endPage") Integer endPage);
//
    @Select("select count(id) from t_log")
    Integer queryCounts();

//    添加日志信息
    @Insert("insert into t_log values(#{id},#{uname},#{time},#{article},#{result})")
    void insert(Log log);
}
