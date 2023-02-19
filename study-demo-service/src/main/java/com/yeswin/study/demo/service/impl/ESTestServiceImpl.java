package com.yeswin.study.demo.service.impl;

import com.yeswin.study.demo.service.ESTestService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class ESTestServiceImpl implements ESTestService {

    @Autowired
    private RestHighLevelClient client;

    @Override
    public boolean createIndexIfNotExists(String index) throws IOException {
        final boolean exists = client.indices().exists(new GetIndexRequest(index), RequestOptions.DEFAULT);
        return exists;
    }
}
