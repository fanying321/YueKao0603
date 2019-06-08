package com.fy.fanying20190603.bean;

import java.util.List;

/**
 * @Author：莹
 * @E-mail： 2016906034@qq.com
 * @Date：2019/6/3 14:16
 * @Description：描述信息
 */
public class SouBean {
    private List<Result> result;
    private String message;
    private String status;

    public SouBean(List<Result> result, String message, String status) {
        this.result = result;
        this.message = message;
        this.status = status;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SouBean() {
    }
}
