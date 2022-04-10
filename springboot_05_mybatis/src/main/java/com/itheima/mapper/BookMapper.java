package com.itheima.mapper;

import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/*
    Mapper注解表示: 不需要再为本接口编写相应的XML映射文件, Mybatis直接自动化注册, 直接写SQL语句就可以.
    当使用注解开发DAO层时必须加上Mapper注解
 */
@Repository("bookMapper1")
@Mapper
public interface BookMapper {

    @Select("select * from `t_book` where id=#{id} ")
    public Book getBookById(Integer id);

}
