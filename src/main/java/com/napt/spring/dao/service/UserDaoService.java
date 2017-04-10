package com.napt.spring.dao.service;

import com.napt.spring.entity.User;

import java.util.List;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
public interface UserDaoService {
    List<User> findAllUsers();
    User findById(long id);
    boolean isUserExist(String username);
    Optional<User> loadUserByName(String userName);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUserById(long id);
    void deleteAllUsers();
    void showDatabaseInfomaton();
}
