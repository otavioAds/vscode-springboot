package com.carlos.springvscode.controller.exceptions;

public class StandardError {
    private Integer status;
    private String msg;
    private Long timesStamp;
    public StandardError(Integer status, String msg, Long timesStamp) {
        this.status = status;
        this.msg = msg;
        this.timesStamp = timesStamp;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Long getTimesStamp() {
        return timesStamp;
    }
    public void setTimesStamp(Long timesStamp) {
        this.timesStamp = timesStamp;
    }

    
    
}
