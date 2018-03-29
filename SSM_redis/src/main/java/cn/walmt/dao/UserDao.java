package cn.walmt.dao;

import cn.walmt.entity.User;
import org.apache.ibatis.annotations.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

/**
 * Created by walmt on 2018/1/14.
 */
public interface UserDao {

    // 根据id查询用户信息
    @Select("SELECT * FROM user u WHERE u.id = #{id}")
    public User findUserById(@Param(value = "id") int id);

    // 根据id更新用户信息
    @Update("update user u set " +
            "u.username = #{username}, u.birthday = #{birthday}, u.sex = #{sex}, u.address = #{address} " +
            "where u.id = #{id}")
    public void updateUserById(User user);

    // 添加用户信息
    @Insert("insert into user(username, birthday, sex, address) values ( #{username}, #{birthday}, #{sex}, #{address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertUser(User user);
}
