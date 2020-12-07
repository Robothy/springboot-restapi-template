package site.luofuxiang.exception;

import site.luofuxiang.enums.ErrorType;

public class ApiException extends RuntimeException {

    private ErrorType errorType;

    private Object[] args;

    public ApiException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public ApiException(ErrorType errorType, Object... args) {
        this.errorType = errorType;
        this.args = args;
    }

    public ErrorType getErrorType() {
        return errorType;
    }

    public Object[] getArgs() {
        return args;
    }

}
