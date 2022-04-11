package com.litway.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.litway.entity.Book;

import java.util.List;

/**
 * 书service02
 *
 * @author DELL_
 * @date 2022/04/11
 */
public interface BookService02 {

    /**
     * 保存
     *
     * @param book 书
     * @return boolean
     */
    boolean save(Book book);

    /**
     * 更新
     *
     * @param book 书
     * @return boolean
     */
    boolean update(Book book);

    /**
     * 删除
     *
     * @param id id
     * @return boolean
     */
    boolean delete(Integer id);

    /**
     * 通过id
     *
     * @param id id
     * @return {@link Book}
     */
    Book getById(Integer id);

    /**
     * 得到所有
     *
     * @return {@link List}<{@link Book}>
     */
    List<Book> getAll();

    /**
     * 页面
     *
     * @param current  当前
     * @param pageSize 页面大小
     * @return {@link Page}<{@link Book}>
     */
    Page<Book> page(int current, int pageSize);

}
