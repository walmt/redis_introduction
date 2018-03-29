package cn.walmt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by walmt on 2018/3/18.
 */
@Repository
public class StringRedisDao {

    @Autowired
    RedisTemplate redisTemplate;

    private ValueOperations getOps() {
        return redisTemplate.opsForValue();
    }

    public String get(String key) {
        return (String) getOps().get(key);
    }

    public void set(String key, String value) {
        getOps().set(key, value);
    }

    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
