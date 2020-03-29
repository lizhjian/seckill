package org.seckill.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * <pre>
 * desc ：
 * author ：lizj
 * date ：2020-03-29 07:18
 * </pre>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecKill {

    private Long seckillId;

    private String name;

    private Integer number;

    private Date startTime;

    private Date endTime;

    private Date createTime;

}
