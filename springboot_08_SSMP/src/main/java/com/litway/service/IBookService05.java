package com.litway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.litway.entity.Book;

public interface IBookService05 extends IService<Book> {

    Page<Book> getPage(int currentPage, int pageSize);

}
