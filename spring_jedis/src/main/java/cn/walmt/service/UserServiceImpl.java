package cn.walmt.service;

import cn.walmt.dao.UserDao;
import cn.walmt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by walmt on 2018/3/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void getUser(String username) {
        System.out.println(userDao.select(username));
    }

    @Override
    public void deleteUser(String username) {
        userDao.delete(username);
    }

    @Override
    public void insertUser(User user) {
        userDao.insert(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.update(user);
    }
}
