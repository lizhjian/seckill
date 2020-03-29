package org.seckill.dao;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.seckill.entity.SecKill;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * <pre>
 * desc ：redis
 * author ：lizj
 * date ：2020-03-29 16:17
 * </pre>
 */
@Slf4j
public class RedisDao {

    private  final JedisPool jedisPool;

    public RedisDao(String ip , int port) {
        this.jedisPool = new JedisPool(ip, port);
    }

    public SecKill getSeckill(long seckillId){
        try {
            Jedis jedis = jedisPool.getResource();
            String key = "seckill:" + seckillId;
            String value = jedis.get(key);
            if(StringUtils.isEmpty(value)){
                return null;
            }else {
                return JSON.parseObject(value, SecKill.class);
            }

        }catch (Exception e){
            log.error(e.getMessage(), e);
        }finally {
            jedisPool.close();
        }
        return null;
    }
    public String setSeckill(SecKill secKill){
        try {
            Jedis jedis = jedisPool.getResource();
            String key = "seckill:" + secKill.getSeckillId();
            int timeout = 60* 60;
            return jedis.setex(key, timeout, JSON.toJSONString(secKill));
        }catch (Exception e){
            log.error(e.getMessage(), e);
        }finally {
            jedisPool.close();
        }
        return null;
    }
}
