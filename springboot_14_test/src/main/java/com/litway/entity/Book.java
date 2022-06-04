package com.litway.entity;

import lombok.Data;

/**
 * Book ORM映射实体类
 */
@Data
public class Book {
    private Integer id;

    private String type;

    private String name;

    private String description;
}
