package com.litway.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.litway.entity.Book;
import org.apache.ibatis.annotations.Mapper;

/**
 * 书映射器
 *
 * @author DELL_
 * @date 2022/04/19
 */
@Mapper
public interface BookMapper extends BaseMapper<Book> {


    Book selectById(@Param("id")Integer id);





}
