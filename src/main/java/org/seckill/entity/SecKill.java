package org.seckill.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

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

    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    private Date endTime;

    private Date createTime;

}
