package com.shulin.winter.biz;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * Created by shulin on 16/12/23.
 */
@Slf4j
public class JRedisTest {

    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1");
        log.info("服务器连接成功！");
        log.info("server is running...{}", jedis.ping());
    }

    /**
     * 往redis里面插入值并且取出来
     */
    @Test
    public void test2() {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
        jedis.set("zhou", "huangxuemei");
        System.out.println("Stored string in redis:: " + jedis.get("zhou"));
    }

    /**
     * 赋值到列表并且取出来
     */
    @Test
    public void test3() {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("Connection to server sucessfully");
//        jedis.lpush("lovelist", "A");
//        jedis.lpush("lovelist", "B");
//        jedis.lpush("lovelist", "C");
//        jedis.lpush("lovelist", "D");
        List<String> loveList = jedis.lrange("lovelist", 0, 3);
        for (String tmp : loveList) {
            log.info("redis存储的值-> {}", tmp);
        }
    }

}
