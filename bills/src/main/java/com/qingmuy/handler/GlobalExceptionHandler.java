package com.qingmuy.handler;

import com.qingmuy.common.ErrorCode;
import com.qingmuy.common.Result;
import com.qingmuy.exception.AccountNotOnlyException;
import com.qingmuy.exception.AccountOrPasswordErrorException;
import com.qingmuy.exception.IllegalArgumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 密码错误 40102
     */
    @ExceptionHandler(AccountOrPasswordErrorException.class)
    public Result AccountOrPasswordErrorExceptionHandler(AccountOrPasswordErrorException e) {
        return Result.error(ErrorCode.ACCOUNT_OR_PASSWORD_ERROR);
    }

    /**
     * 关键参数为空或错误
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public Result IllegalArgumentExceptionHandler(IllegalArgumentException e) {
        return Result.error(ErrorCode.PARAMS_ERROR);
    }

    @ExceptionHandler(AccountNotOnlyException.class)
    public Result AccountNotOnlyExceptionHandler(AccountNotOnlyException e) {
        return Result.error(ErrorCode.ACCOUNT_ALREADY_OCCUPIED);
    }
}
