package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SecKill;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * desc ：秒杀dao
 * author ：lizj
 * date ：2020-03-29 07:34
 * </pre>
 */
public interface SecKillDao {

    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);

    /**
     * desc : 根据id查询秒杀接口
     * @author lizj
     * @date 2020-03-29 07:36:50
     * @param seckillId
     * @return org.seckill.entity.SecKill
     */
    SecKill queryById(long seckillId);


    /**
     * desc : 查询秒杀商品列表
     * @author lizj
     * @date 2020-03-29 07:36:20
     * @param offset
     * @param limit
     * @return java.util.List<org.seckill.entity.SecKill>
     */
    List<SecKill> queryAll(@Param("offset") int offset, @Param("limit") int limit);
}
