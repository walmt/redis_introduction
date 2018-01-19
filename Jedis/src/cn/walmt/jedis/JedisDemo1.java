package cn.walmt.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Jedis的测试
 * Created by walmt on 2018/1/19.
 */
public class JedisDemo1 {

    @Test
    /**
     * 单实例的测试
     */
    public void demo1() {
        // 1.设置IP地址和端口
        Jedis jedis = new Jedis("123.207.45.43", 6379);
        // 2.保存数据
        jedis.set("name", "老王");
        // 3.获取数据
        String value = jedis.get("name");
        System.out.println(value);
        // 4.释放资源
        jedis.close();
    }

    @Test
    /**
     * 连接池方式连接
     */
    public void demo2() {
        // 获得连接池的配置对象：
        JedisPoolConfig config = new JedisPoolConfig();
        // 设置最大连接数
        config.setMaxTotal(30);
        // 设置最大空闲连接数：
        config.setMaxIdle(10);

        // 获得连接池
        JedisPool jedisPool = new JedisPool(config, "123.207.45.43", 6379);

        // 获得核心对象
        Jedis jedis = null;

        try {
            // 通过连接池获得连接
            jedis = jedisPool.getResource();
            // 设置数据
            jedis.set("name", "张三");
            // 获取数据
            String value = jedis.get("name");
            System.out.println(value);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (jedis != null) {
                jedis.close();
            }
            jedisPool.close();
        }
    }
}
