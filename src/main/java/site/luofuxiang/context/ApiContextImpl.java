package site.luofuxiang.context;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Component
public class ApiContextImpl implements ApiContext {

    private MessageSource messageSource;

    public ApiContextImpl(@Qualifier("templateMessageSource") MessageSource messageSource){
        this.messageSource = messageSource;
    }

    @Override
    public String message(String code) {
        return this.messageSource.getMessage(code, null,locale());
    }

    @Override
    public String message(String code, Object... args) {
        return this.messageSource.getMessage(code, args, locale());
    }

    @Override
    public HttpServletRequest request() {
        return servletRequestAttributes().getRequest();
    }

    @Override
    public HttpServletResponse response() {
        return servletRequestAttributes().getResponse();
    }

    @Override
    public Locale locale() {
        return request().getLocale();
    }

    private ServletRequestAttributes servletRequestAttributes(){
        return (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    }

}
