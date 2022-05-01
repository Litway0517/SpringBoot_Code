package com.litway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.litway.entity.Book;

/**
 * ibook service05
 *
 * @author DELL_
 * @date 2022/04/19
 */
public interface IBookService extends IService<Book> {

    Page<Book> getPage(int currentPage, int pageSize);

    Page<Book> getPage(int currentPage, int pageSize, Book book);
}
