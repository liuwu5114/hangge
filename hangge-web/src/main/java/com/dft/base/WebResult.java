package com.dft.base;

/**
 * @program: hangge
 * @description:
 * @author: 刘武
 * @create: 2021-05-14 14:28
 **/
public class WebResult<T> {

    // 数据
    private T data;

    // 编码
    private String code;

    // 描述
    private String message;

    public WebResult() {
    }

    public WebResult(T data) {
        this.data = data;
    }
    private enum CodeType {
        ERROR("201", "失败"),
        SUCCESS("200", "成功");

        private String value;
        private String descript;

        CodeType(String value, String descript) {
            this.value = value;
            this.descript = descript;
        }

        @Override
        public String toString() {
            return this.descript;
        }
    }

    public WebResult success() {
        code = CodeType.SUCCESS.value;
        message = CodeType.SUCCESS.toString();
        return this;
    }

    public WebResult error() {
        code = CodeType.ERROR.value;
        message = CodeType.ERROR.toString();
        return this;
    }

    public WebResult success(String message) {
        code = CodeType.SUCCESS.value;
        this.message = message;
        return this;
    }

    public WebResult error(String message) {
        code = CodeType.ERROR.value;
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
