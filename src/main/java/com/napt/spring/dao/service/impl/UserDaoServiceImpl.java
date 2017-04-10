package com.napt.spring.dao.service.impl;

import com.napt.spring.dao.service.UserDaoService;
import com.napt.spring.entity.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
@SuppressWarnings("ALL")
@Service(value = "userDaoService")
public class UserDaoServiceImpl implements UserDaoService {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> findAllUsers() {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public boolean isUserExist(String username) {
        return false;
    }

    @Transactional
    @Override
    public Optional<User> loadUserByName(String userName) {
        List<User> lstUser =  sessionFactory.getCurrentSession().createQuery("from User where name =?").setParameter(0,userName).list();
        if(lstUser.size()>0){
            return Optional.of(lstUser.get(0));
        }
        return Optional.empty();
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUserById(long id) {

    }

    @Override
    public void deleteAllUsers() {

    }

    @Override
    public void showDatabaseInfomaton() {

    }
}
