package site.luofuxiang.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.luofuxiang.enums.ErrorType;
import site.luofuxiang.exception.ApiException;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class ErrorController {

    @RequestMapping(path = "/error", method = {GET, POST, DELETE})
    public Map<String, String> handleError(){
        throw new ApiException(ErrorType.UNAUTHORIZED_REQUEST);
    }

}
