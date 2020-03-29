package org.seckill.exception;

/**
 * <pre>
 * desc ：所有秒杀异常
 * author ：lizj
 * date ：2020-03-29 13:13
 * </pre>
 */
public class SeckillException extends RuntimeException {

    public SeckillException() {
        super();
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
