package com.yeswin.study.demo.test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yeswin.study.demo.module.CategoryDO;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

@Component
@Slf4j
public class JacksonTest implements Serializable {



    public static void main( String[] args ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        objectMapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        File file =  new File("json_test.txt");
        CategoryDO categoryDO = new CategoryDO();
        categoryDO.setName("哈哈哈");
        categoryDO.setId(1L);
        objectMapper.writeValue(file, categoryDO);
    }
}
