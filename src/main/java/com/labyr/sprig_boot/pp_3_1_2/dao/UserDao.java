package com.labyr.sprig_boot.pp_3_1_2.dao;

import com.labyr.sprig_boot.pp_3_1_2.model.User;

import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    User getUserById(long id);

    void addUser(User user);

    void removeUser(long id);

    void updateUser(User user);

}
