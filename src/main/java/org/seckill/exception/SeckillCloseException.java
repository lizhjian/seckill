package org.seckill.exception;

/**
 * <pre>
 * desc ：秒杀关闭
 * author ：lizj
 * date ：2020-03-29 13:12
 * </pre>
 */
public class SeckillCloseException extends RuntimeException {

    public SeckillCloseException() {
        super();
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }

    public SeckillCloseException(String message) {
        super(message);
    }
}
