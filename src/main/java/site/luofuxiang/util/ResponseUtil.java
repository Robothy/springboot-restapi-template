package site.luofuxiang.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> message(Object message){
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", message);
        return result;
    }

    public static Map<String, Object> success(){
        return message("success");
    }
}
