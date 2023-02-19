package com.yeswin.study.demo.service;

import java.io.IOException;

public interface ESTestService {

    /**
     * 这个接口的实现应该有分布式锁
     *
     * @param index
     * @return
     */
    boolean createIndexIfNotExists(String index) throws IOException;
}
