package com.litway.mapper;

import com.litway.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;


@Mapper
public interface BookMapper {

    @Select("select * from `t_book` where id=#{id} ")
    public Book getBookById(Integer id);

}
