package com.cjpnice.word.constant;



import java.util.HashMap;
import java.util.Map;

public class TokenConstant {

    private static Map<String,String> map=new HashMap();


    public static String getToken(){
        return map.get("token");
    }

    public static void updateTokenMap(String token){
        map.put("token",token);
    }


}

