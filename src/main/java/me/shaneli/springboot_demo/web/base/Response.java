package me.shaneli.springboot_demo.web.base;

/**
 * @author Shane
 */
public class Response {

    private ResponseStatus status;
    private String msg;
    private Object data;

    public static Response success(Object data) {
        return new Response(ResponseStatus.SUCCESS, null, data);
    }

    public static Response success(String msg, Object data) {
        return new Response(ResponseStatus.SUCCESS, msg, data);
    }

    public static Response fail(String msg) {
        return new Response(ResponseStatus.FAIL, msg, null);
    }

    public static Response error(String msg) {
        return new Response(ResponseStatus.SYS_ERR, msg, null);
    }

    public Response(ResponseStatus status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
