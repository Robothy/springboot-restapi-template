package site.luofuxiang.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.util.ResponseUtil;

@ControllerAdvice
public class RootExceptionHandler extends BaseHandler{

    private Logger log = LoggerFactory.getLogger(BaseHandler.class);

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e){
        log.error(e.getMessage(), e);
        String message = super.apiContext.message(ErrorType.API_SERVICE_ERROR.getMessageKey());
        return ResponseUtil.message(message);
    }

}
