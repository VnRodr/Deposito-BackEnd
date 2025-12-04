package site.api.api_teste.enums;

import org.springframework.http.HttpStatus;

public class HttpsStatusCodes {

    static public HttpStatus OKCode()
    {
        return HttpStatus.OK;
    }

    static public HttpStatus NotFoundCode()
    {
        return HttpStatus.NOT_FOUND;
    }

    static public HttpStatus CreatedCode()
    {
        return HttpStatus.CREATED;
    }

    static public HttpStatus NoContentCode()
    {
        return HttpStatus.NO_CONTENT;
    }
}
