package com.yeswin.study.demo.module;

import lombok.Data;

import java.time.LocalTime;

@Data
public class CategoryDO {
    private Long id;
    private String name;
    private Integer version;
    private LocalTime createdAt;
    private LocalTime updatedAt;
}
