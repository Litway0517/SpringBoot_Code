package com.litway.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.entity.Book;
import com.litway.mapper.BookMapper;
import com.litway.service.BookService02;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Service注解. 交给Spring容器管理别忘了
@Service
public class BookServiceImpl03 implements BookService02 {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 保存
     *
     * @param book 书
     * @return boolean
     */
    @Override
    public boolean save(Book book) {
        return bookMapper.insert(book) > 0;
    }

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    @Override
    public boolean update(Book book) {
        return bookMapper.updateById(book) > 0;
    }

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    @Override
    public boolean delete(Integer id) {
        return bookMapper.deleteById(id) > 0;
    }

    /**
     * 通过id
     *
     * @return {@link Book}
     */
    @Override
    public Book getById(Integer id) {
        return bookMapper.selectById(id);
    }

    /**
     * 得到所有
     *
     * @return {@link List}<{@link Book}>
     */
    @Override
    public List<Book> getAll() {
        return bookMapper.selectList(null);
    }

    /**
     * 页面
     *
     * @param current  当前
     * @param pageSize 页面大小
     * @return {@link Page}<{@link Book}>
     */
    @Override
    public Page<Book> page(int current, int pageSize) {
        Page<Book> bookPage = new Page<Book>(current, pageSize);
        return bookMapper.selectPage(bookPage, null);
    }
}
