package org.seckill.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.seckill.dao.SecKillDao;
import org.seckill.dao.SuccessKillDao;
import org.seckill.dto.SeckillResponse;
import org.seckill.entity.SecKill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SeckillService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * <pre>
 * desc ：TODO
 * author ：lizj
 * date ：2020-03-29 13:20
 * </pre>
 */
@Service
@Slf4j
public class SeckillServiceImpl implements SeckillService {

    private SecKillDao secKillDao;

    private SuccessKillDao successKillDao;

    @Override
    public List<SecKill> getSeckillList() {
        return secKillDao.queryAll(0,10);
    }

    @Override
    public SecKill getSeckillById(long seckillId) {
        return null;
    }

    @Override
    public SeckillResponse executeSeckill(long seckillId, long userPhone, String md5)
            throws SeckillException, RepeatKillException, SeckillCloseException {
        Date nowTime = new Date();
        try {
            int updateCount = secKillDao.reduceNumber(seckillId,nowTime);
            if(updateCount<=0){
                throw new SeckillCloseException("秒杀已结束");
            }else {
                int insertCount = successKillDao.insertSuccessKilled(seckillId,userPhone);
                if(insertCount<=0){
                    throw new RepeatKillException("您已经买过了");
                }else {
                    SuccessKilled successKilled = successKillDao.queryByIdWithSeckill(seckillId,userPhone);
                    return new SeckillResponse(seckillId, SeckillStateEnum.SUCCESS,successKilled);
                }
            }
        }catch (SeckillCloseException e1){
            throw e1;
        }catch (RepeatKillException e2){
            throw e2;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
