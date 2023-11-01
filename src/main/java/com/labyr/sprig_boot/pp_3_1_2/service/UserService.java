package com.labyr.sprig_boot.pp_3_1_2.service;


import com.labyr.sprig_boot.pp_3_1_2.model.User;
import jakarta.validation.Valid;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    Object getUserById(long id);

    void addUser(User user);

    void removeUser(long id);

    void updateUser(@Valid User user);

}