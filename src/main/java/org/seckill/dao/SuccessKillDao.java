package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

import java.util.Date;

/**
 * <pre>
 * desc ：秒杀成功接口
 * author ：lizj
 * date ：2020-03-29 07:37
 * </pre>
 */
public interface SuccessKillDao {

    /**
     * 插入购买明细
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone") String userPhone, @Param("createTime")Date createTime);

    /**
     * desc :根据id 查询successKill
     * @author lizj
     * @date 2020-03-29 07:38:29
     * @param seckillId
     * @param userPhone
     * @return SuccessKilled
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId")long seckillId, @Param("userPhone") String userPhone);
}
