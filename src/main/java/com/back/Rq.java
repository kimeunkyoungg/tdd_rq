package com.back;


public class Rq {

    private String cmd;

    public Rq(String cmd) {
        this.cmd = cmd;
    }


    public String getActionName() {

        return cmd.split("\\?")[0];
    }

    public String getParam(String inputKey) {

        String[] cmdBits = cmd.split("\\?");
        String queryString = cmdBits[1];

        String[] paramBits = queryString.split("=");
        String value = paramBits[1];

        return value;
    }
}