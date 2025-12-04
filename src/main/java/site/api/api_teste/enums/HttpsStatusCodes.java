package site.api.api_teste.enums;

import org.springframework.http.HttpStatus;

public class HttpsStatusCodes {

    static public HttpStatus OKStatus()
    {
        return HttpStatus.OK;
    }

    static public HttpStatus NotFoundStatus()
    {
        return HttpStatus.NOT_FOUND;
    }

    static public HttpStatus CreatedStatus()
    {
        return HttpStatus.CREATED;
    }

    static public HttpStatus NoContentStatus()
    {
        return HttpStatus.NO_CONTENT;
    }
}
