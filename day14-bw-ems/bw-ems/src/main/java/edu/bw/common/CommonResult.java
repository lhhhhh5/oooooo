package edu.bw.common;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class CommonResult extends HashMap<String, Object> {

    public CommonResult() {
        put("code", HttpStatus.SC_OK);
        put("msg", "success");
    }

    public CommonResult put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static CommonResult ok() {
        return new CommonResult();
    }

    public static CommonResult ok(String msg) {
        CommonResult r = new CommonResult();
        r.put("msg", msg);
        return r;
    }

    public static CommonResult ok(Map<String, Object> map) {
        CommonResult r = new CommonResult();
        r.putAll(map);
        return r;
    }

    public static CommonResult error(int code, String msg) {
        CommonResult r = new CommonResult();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static CommonResult error(String msg) {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
    }

    public static CommonResult error() {
        return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
    }

}