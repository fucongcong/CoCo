package {{ group }}.{{ module }}.user.web.errors;

import com.clothesmake.common.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    Result<Map> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);

        if (ex instanceof NoHandlerFoundException) {
            return Result.error(404, ex.getMessage());
        }

        return Result.error(status.value(), ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}