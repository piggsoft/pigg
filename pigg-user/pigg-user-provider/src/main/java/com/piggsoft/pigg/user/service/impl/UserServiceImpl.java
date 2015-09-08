package com.piggsoft.pigg.user.service.impl;

import com.piggsoft.pigg.user.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;

import com.piggsoft.pigg.user.dao.UserMapper;
import com.piggsoft.pigg.user.model.User;
import com.piggsoft.pigg.user.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int save(User user) {
        return userMapper.insert(user);
    }

    @Override
    public User find(Long userId) {
        User user = userMapper.selectByPrimaryKey(Integer.parseInt(userId.toString()));
        return user;
    }

    @Override
    public List<User> findByExample(UserExample example) {
        return userMapper.selectByExample(example);
    }

    @Override
    public List<User> find() {
        return userMapper.selectByExample(new UserExample());
    }

    @Override
    public int updateUserByExample(User user, UserExample example) {
        return 0;
    }

    @Override
    public int deleteById(Long userId) {
        return 0;
    }

    @Override
    public int deleteByUserExample(UserExample example) {
        return 0;
    }

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

}
