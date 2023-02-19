package com.yeswin.study.demo.controller;

import com.yeswin.common.core.response.YeswinResponse;
import com.yeswin.study.demo.constant.ErrorCode;
import com.yeswin.study.demo.service.ESTestService;
import com.yeswin.study.demo.param.EsCreateIndexParam;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/es")
public class ESTestController {

    @Resource
    private ESTestService esTestService;

    @PostMapping(path = "/hlc/index/create")
    public YeswinResponse<Void> createIndex(@RequestBody EsCreateIndexParam param) {
        try {
            esTestService.createIndexIfNotExists(param.getIndex());
        } catch (Exception e) {
            return YeswinResponse.fail(ErrorCode.DEFAULT_ERROR_CODE, e.getMessage());
        }
        return YeswinResponse.success();
    }
}
