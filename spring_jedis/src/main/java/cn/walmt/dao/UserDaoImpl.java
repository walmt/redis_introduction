package cn.walmt.dao;

import cn.walmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * Created by walmt on 2018/3/14.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    StringRedisTemplate redisTemplete;

    @Override
    public String select(String username) {
        ValueOperations<String, String> vos = redisTemplete.opsForValue();
        return vos.get(username);
    }

    @Override
    public boolean insert(User user) {
        BoundValueOperations<String, String> bvo = redisTemplete.boundValueOps(user.getUsername());
        bvo.set(user.getPassword());
        return true;
    }

    @Override
    public boolean delete(String username) {
        redisTemplete.delete(username);
        return true;
    }

    @Override
    public boolean update(User user) {
        ValueOperations<String, String> vos = redisTemplete.opsForValue();
        if (vos.get(user.getUsername()) != null) {
            vos.set(user.getUsername(), user.getPassword());
            return true;
        }
        return false;
    }
}
