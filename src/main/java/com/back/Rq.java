package com.back;


public class Rq {

    private String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }


    public String getActionName() {

        return cmd.split("\\?")[0];
    }

    public String getParam(String inputKey, String defaulValue) {

//        if(cmd.equals("등록?고향=서울&이름=홍길동") && inputKey.equals("고향")){
//            return "서울";
//        }
//
//        if(cmd.equals("등록?고향=서울&이름=홍길동") && inputKey.equals("이름")){
//            return "홍길동";
//        }


        String[] cmdBits = cmd.split("\\?");
        String queryString = cmdBits[1];

        String[] queryBits= queryString.split("&");

        //고향=서울 && 이름=홍길동으로 나누기
        for(String param : queryBits){
            String[] paramBits = param.split("=");
            String key = paramBits[0];
            String value = paramBits[1];

            if(inputKey.equals(key)){
                return value;
            }
        }


        return defaulValue;
    }
}