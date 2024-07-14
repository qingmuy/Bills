package com.qingmuy.exception;

/**
 * 账号不存在异常
 */
public class AccountNotOnlyException extends BaseException {

    public AccountNotOnlyException() {
    }

    public AccountNotOnlyException(String msg) {
        super(msg);
    }

}
