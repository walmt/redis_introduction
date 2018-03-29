package cn.walmt.dao;

import cn.walmt.entity.User;

/**
 * Created by walmt on 2018/3/14.
 */
public interface UserDao {
    String select(String username);
    boolean insert(User user);
    boolean delete(String username);
    boolean update(User user);
}
