package com.back;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Rq {

    private String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }


    public String getActionName() {

        return cmd.split("\\?")[0];
    }

    public String getParam(String inputKey, String defaultValue) {


        Map<String, String> paramMap = new HashMap<>();

        String[] cmdBits = cmd.split("\\?");
        String queryString = cmdBits[1];

        String[] queryBits= queryString.split("&");

        //고향=서울 && 이름=홍길동으로 나누기
//        for(String param : queryBits){
//            String[] paramBits = param.split("=");
//            String key = paramBits[0];
//            String value = paramBits[1];
//
//            paramMap.put(key,value);
//            }
//        }

        paramMap = Arrays.stream(queryBits)
                .map(param -> param.split("="))
                .collect(
                        Collectors.toMap(
                                bits -> bits[0],
                                bits -> bits.length > 1 ? bits[1] : ""
                        )
                );

        return paramMap.getOrDefault(inputKey, defaultValue);
    }

    public int getParamAsInt(String key, int defaultValue) {

        String value = getParam(key, "");
        if (value.isBlank()) {
            return defaultValue;
        }

        return Integer.parseInt(value);
    }

}