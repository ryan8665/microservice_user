package com.ns.user.enums;

public enum  ResultEnum {
    success("000","success"),
    exist("001","exist"),
    internal_Error("002","internal error"),
    time_out("003","time out"),
    token_not_valid("004","token is not valid"),
    cellphone_not_valid("005","cellphone is not valid"),
    user_locked("006","user is locked"),
    user_expired("007","user is expired"),
    bad_user_credential("008","Bad credential"),
    bad_user("009","data not valid"),
    dara_not_correct("010","data not valid"),
    other("020","other"),
    ;


    ResultEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private String code;
    private String desc;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
