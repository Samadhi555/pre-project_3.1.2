package com.labyr.sprig_boot.pp_3_1_2.service;

import com.labyr.sprig_boot.pp_3_1_2.dao.UserDao;
import com.labyr.sprig_boot.pp_3_1_2.model.User;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao UserDao;

    @Autowired
    public UserServiceImpl(UserDao UserDao) {
        this.UserDao = UserDao;
    }

    @Override
    public List<User> getAllUsers() {
        return UserDao.getAllUsers();
    }

    @Override
    public Object getUserById(long id) {
        return UserDao.getUserById(id);
    }

    @Override
    public void addUser(User user) {
        if (getAllUsers().contains(user)) {
            return;
        }
        UserDao.addUser(user);
    }

    @Override
    public void removeUser(long id) {
        UserDao.removeUser(id);
    }

    @Override
    public void updateUser(@Valid User user) {
        UserDao.updateUser(user);
    }
}