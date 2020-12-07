package site.luofuxiang.context;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public interface ApiContext {

    String message(String code);

    String message(String code, Object... args);

    HttpServletRequest request();

    HttpServletResponse response();

    Locale locale();

}
