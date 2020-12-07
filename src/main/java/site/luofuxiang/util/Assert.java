package site.luofuxiang.util;

import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.exception.ApiException;

import java.util.Collection;

/**
 * 断言工具类
 */
public class Assert {

    public static void isNull(Object object, ErrorType errorType, Object... args){
        if(null != object){
            throw new ApiException(errorType, args);
        }
    }

    public static void notNull(Object object, ErrorType errorType, Object... args){
        if(null == object){
            throw new ApiException(errorType, args);
        }
    }

    public static void notEmpty(Object object, ErrorType errorType, Object... args){
        if(ObjectUtils.isEmpty(object)){
            throw new ApiException(errorType, args);
        }
    }

    public static void notEmpty(String string, ErrorType errorType, Object... args){
        if(StringUtils.isEmpty(string)){
            throw new ApiException(errorType, args);
        }
    }

    public static void notEmpty(Collection<?> collection, ErrorType errorType, Object... args){
        if(CollectionUtils.isEmpty(collection)){
            throw new ApiException(errorType, args);
        }
    }

    public static void isTrue(Boolean expression, ErrorType errorType, Object... args){
        if(!expression){
            throw new ApiException(errorType, args);
        }
    }

}
