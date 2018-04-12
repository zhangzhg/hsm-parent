package com.hsm.api.em;


import com.hsm.common.ICodeMessage;

public class ApiJsonResult implements ICodeMessage {
    private String code;
    private String msg;
    private Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setResult(ICodeMessage result, String... args) {
        String message = result.getMsg();
        setCode(result.getCode());
        if ((args != null) && (args.length > 0)) {
            for (String s : args) {
                message = message.replaceFirst("\\{}", s);
            }
        }
        setMsg(message);
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
