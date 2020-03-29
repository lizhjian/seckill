package org.seckill.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * <pre>
 * desc ：TODO
 * author ：lizj
 * date ：2020-03-29 15:11
 * </pre>
 */
@Data
public class SecKillResult<T> implements Serializable {

    private boolean success;

    private T data;

    private String msg;

    public SecKillResult(boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SecKillResult(boolean success, String msg) {
        this.success = success;
        this.msg = msg;
    }
}
