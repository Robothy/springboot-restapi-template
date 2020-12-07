package site.luofuxiang.controller.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.luofuxiang.context.ApiContext;

/**
 * 异常处理器基类，处理其它处理器未能处理的异常。
 * 其它处理器继承此类来获得 ApiContext
 *
 */
@RestControllerAdvice
public class BaseHandler {

    ApiContext apiContext;

    @Autowired
    public void setApiContext(ApiContext apiContext) {
        this.apiContext = apiContext;
    }

}
