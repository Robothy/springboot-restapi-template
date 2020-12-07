package site.luofuxiang.controller.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.luofuxiang.exception.ApiException;
import site.luofuxiang.util.ResponseUtil;

@RestControllerAdvice
public class ApiExceptionHandler extends BaseHandler {

    @ExceptionHandler(ApiException.class)
    public Object handle(ApiException apiException){
        apiContext.response().setStatus(apiException.getErrorType().getHttpStatus().value());
        return ResponseUtil.message(apiContext.message(apiException.getErrorType().getMessageKey(), apiException.getArgs()));
    }
}