package pers.li.orm.exception;

/**
 * create by lishengbo 2018/6/11
 * 自定义异常类
 */
public class ORMException extends RuntimeException {

    public ORMException() {
        super();
    }

    public ORMException(String message) {
        super(message);
    }

    public ORMException(String message, Throwable cause) {
        super(message, cause);
    }

    public ORMException(Throwable cause) {
        super(cause);
    }

    protected ORMException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
