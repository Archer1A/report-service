package com.vic.report.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ResponseResult<T> {
    private int status;
    private String resMsg;
    private T data;

    public static ResponseResult<String > successString(String data){
        return new ResponseResult<>(0, "",data);

    }
    public static ResponseResult<String > failString(String data){

        return new ResponseResult<>(1,data,"");
    }

    public static ResponseResult<Map> successList(List list, long count) {
        Map<String, Object> map = new HashMap();
        map.put("total", count);
        map.put("items", list);
        return new ResponseResult<>(0, "", map);

    }

    public static ResponseResult successObject(Object object) {
        return new ResponseResult(0, "", object);
    }

}

