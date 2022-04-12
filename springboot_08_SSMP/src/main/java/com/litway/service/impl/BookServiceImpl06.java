package com.litway.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.litway.entity.Book;
import com.litway.mapper.BookMapper;
import com.litway.service.IBookService05;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl06 extends ServiceImpl<BookMapper, Book> implements IBookService05 {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<Book>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }
}
