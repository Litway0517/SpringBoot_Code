package com.litway.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.litway.entity.Book;
import com.litway.mapper.BookMapper;
import com.litway.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 书服务impl06
 *
 * @author DELL_
 * @date 2022/04/19
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements IBookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public Page<Book> getPage(int currentPage, int pageSize) {
        Page<Book> page = new Page<Book>(currentPage, pageSize);
        bookMapper.selectPage(page, null);
        return page;
    }

    @Override
    public Page<Book> getPage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lambdaQueryWrapper = new LambdaQueryWrapper<Book>();
        lambdaQueryWrapper.like(StringUtils.isNotBlank(book.getType()), Book::getType, book.getType())
                .like(StringUtils.isNotBlank(book.getName()), Book::getName, book.getName())
                .like(StringUtils.isNotBlank(book.getDescription()), Book::getDescription, book.getDescription());
        Page<Book> page = new Page<Book>(currentPage, pageSize);
        bookMapper.selectPage(page, lambdaQueryWrapper);
        return page;
    }
}
