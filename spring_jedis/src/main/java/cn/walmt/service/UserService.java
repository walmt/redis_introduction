package cn.walmt.service;

import cn.walmt.entity.User;

/**
 * Created by walmt on 2018/3/14.
 */
public interface UserService {
    void getUser(String username);
    void deleteUser(String username);
    void insertUser(User user);
    void updateUser(User user);
}
