package com.yeswin.study.demo.param;


import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonNaming
public class EsCreateIndexParam {
    private String index;
}
