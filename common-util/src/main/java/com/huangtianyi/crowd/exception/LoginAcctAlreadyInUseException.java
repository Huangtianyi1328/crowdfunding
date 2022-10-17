package com.huangtianyi.crowd.exception;
/**
* 保存Admin时检测到账户重复抛出该异常
* @author huangtianyi
* @Date 2022/6/7 18:51
*/
public class LoginAcctAlreadyInUseException extends RuntimeException{
    public LoginAcctAlreadyInUseException() {
        super();
    }

    public LoginAcctAlreadyInUseException(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseException(Throwable cause) {
        super(cause);
    }

    protected LoginAcctAlreadyInUseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
