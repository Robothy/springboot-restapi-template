package site.luofuxiang.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.util.ResponseUtil;

import javax.servlet.ServletException;

/**
 * 统一处理 Servelet 异常，包括 HttpMediaTypeException, NoHandlerFoundException
 * 等继承了 ServletException 的异常类，
 * 全部返回 Unauthorized 消息。
 *
 */
@ControllerAdvice
public class ServletExceptionHandler extends BaseHandler {

    private Logger log = LoggerFactory.getLogger(ServletExceptionHandler.class);

    @ExceptionHandler({
            ServletException.class
    })
    public Object handle(ServletException exception){
        log.error(exception.getMessage(), exception);
        apiContext.response().setStatus(ErrorType.UNAUTHORIZED_REQUEST.getHttpStatus().value());
        return ResponseUtil.message(apiContext.message(ErrorType.UNAUTHORIZED_REQUEST.getMessageKey()));
    }

}