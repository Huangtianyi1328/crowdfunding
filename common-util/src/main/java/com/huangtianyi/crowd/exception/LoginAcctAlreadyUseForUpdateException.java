package com.huangtianyi.crowd.exception;
/**
 * 更新Admin时检测到账户重复抛出该异常
 * @author huangtianyi
 * @Date 2022/6/7 18:51
 */
public class LoginAcctAlreadyUseForUpdateException extends RuntimeException {
    public LoginAcctAlreadyUseForUpdateException() {
        super();
    }

    public LoginAcctAlreadyUseForUpdateException(String message) {
        super(message);
    }

    public LoginAcctAlreadyUseForUpdateException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyUseForUpdateException(Throwable cause) {
        super(cause);
    }

    protected LoginAcctAlreadyUseForUpdateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
