package site.luofuxiang.enums;

import org.springframework.http.HttpStatus;

public enum ErrorType {

    API_SERVICE_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "apiServiceError"),

    UNAUTHORIZED_REQUEST(HttpStatus.UNAUTHORIZED, "unauthorizedRequest"),

    INVALID_PARAMETER(HttpStatus.BAD_REQUEST, "invalidParameter"),

    DEPARTMENT_NOT_EXISTS(HttpStatus.BAD_REQUEST, "departmentNotExists"),

    EMPLOYEE_NOT_EXISTS(HttpStatus.BAD_REQUEST, "employeeNotExists")
    ;

    private HttpStatus httpStatus;

    private String messageKey;

    ErrorType(HttpStatus httpStatus, String messageKey) {
        this.httpStatus = httpStatus;
        this.messageKey = messageKey;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getMessageKey() {
        return messageKey;
    }
}
