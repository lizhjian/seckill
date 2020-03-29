package org.seckill.dao;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;


/**
 * <pre>
 * desc ：配置spring和junit整合
 * author ：lizj
 * date ：2020-03-29 09:44
 * </pre>
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring 配置文件位置
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SecKillDaoTest {

    @Resource
    private SecKillDao secKillDao;


    @Test
    public void reduceNumber() {
        long id = 100;
        int updateCount = secKillDao.reduceNumber(id, new Date());
        System.out.println("========");
        System.out.println(JSON.toJSONString(updateCount));

    }

    @Test
    public void queryById() {
        long id = 100;
        SecKill secKill = secKillDao.queryById(id);
        System.out.println("========");
        System.out.println(JSON.toJSONString(secKill));
    }

    @Test
    public void queryAll() {
        long id = 100;
        List<SecKill> secKills = secKillDao.queryAll(0, 100);
        System.out.println("========");
        for (SecKill secKill : secKills) {
            System.out.println(secKill.getStartTime());
        }
        //System.out.println(JSON.toJSONString(secKills));
    }
}