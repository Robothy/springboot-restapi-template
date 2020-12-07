package site.luofuxiang.controller.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.util.ResponseUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler extends BaseHandler {

    private Logger log = LoggerFactory.getLogger(MethodArgumentNotValidException.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object handle(MethodArgumentNotValidException e){
        log.error(e.getMessage());
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        apiContext.response().setStatus(ErrorType.INVALID_PARAMETER.getHttpStatus().value());
        Map<String, Object> message = ResponseUtil.message(apiContext.message(ErrorType.INVALID_PARAMETER.getMessageKey()));
        List<String> details = new ArrayList<>(errors.size());
        for(ObjectError error : errors){
            details.add(retrieveMessage(error));
        }
        message.put("details", details);
        return message;
    }

    private String retrieveMessage(ObjectError error){
        String[] codes = error.getCodes();
        for (int i = Objects.requireNonNull(codes).length - 1; i >= 0; i--) {
            String message = apiContext.message(codes[i]);
            // 判断一下获取到的 message, 如果为空或者和 code 的值一样，则说明没有获取到有效数据
            if (message != null && !message.equals(codes[i])) {
                return message;
            }
        }
        return apiContext.message(error.getDefaultMessage());
    }

}
