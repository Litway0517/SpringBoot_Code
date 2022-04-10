package com.itheima.dao;

import com.itheima.pojo.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

// Mapper注解表示: 不需要再为本接口编写相应的XML映射文件, Mybatis直接自动化注册, 直接写SQL语句就可以
@Repository("bookMapper2")
@Mapper
public interface BookMapper {

    @Select("select * from `t_book` where id=#{id} ")
    default Book getBookById(Integer id) {

        System.out.println("这个是bookMapper2");
        return new Book();
    }

}
