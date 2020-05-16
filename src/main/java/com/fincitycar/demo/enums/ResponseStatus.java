package com.fincitycar.demo.enums;

import java.util.HashMap;
import java.util.Map;

public enum ResponseStatus {

    SUCCESS("success"),
    FAILURE("failure");

    String value;

    ResponseStatus(String value){
        this.value = value;
    }

    private static Map<String, ResponseStatus> map = new HashMap<String, ResponseStatus>();
    static {
        for (ResponseStatus status : values())
            map.put(status.value, status);
    }



    ResponseStatus getServiceStatus(String status) {
        return map.get(status);
    }
}