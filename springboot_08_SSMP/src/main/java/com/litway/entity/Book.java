package com.litway.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("t_book")
public class Book {
    private Integer id;

    private String type;

    private String name;

    private String description;
}
