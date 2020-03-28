package org.seckill.entity;

import lombok.Data;

import java.util.Date;

/**
 * <pre>
 * desc ：秒杀成功类
 * author ：lizj
 * date ：2020-03-29 07:22
 * </pre>
 */
@Data
public class SuccessKilled {

    private Long seckillId;

    private Long userPhone;

    private Integer state;

    private Date createTime;

    private SecKill secKill;

}
