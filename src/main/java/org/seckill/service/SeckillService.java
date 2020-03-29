package org.seckill.service;

import org.seckill.dto.SeckillResponse;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * <pre>
 * desc ：业务接口: 站在""
 * author ：lizj
 * date ：2020-03-29 11:47
 * </pre>
 */
public interface SeckillService {

    List<SecKill> getSeckillList();

    SecKill getSeckillById(long seckillId);

    SeckillResponse executeSeckill(long seckillId, String userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException;


}
