package org.seckill.exception;

/**
 * <pre>
 * desc ：重复秒杀(运行时异常)
 * author ：lizj
 * date ：2020-03-29 13:11
 * </pre>
 */
public class RepeatKillException extends RuntimeException {
    public RepeatKillException() {
        super();
    }

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }

    public RepeatKillException(Throwable cause) {
        super(cause);
    }

    protected RepeatKillException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
