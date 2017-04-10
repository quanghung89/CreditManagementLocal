package com.napt.spring.dao.service.impl;

import com.napt.spring.dao.service.UserAuthoritiesDaoService;
import com.napt.spring.entity.UserAuthoritiesMap;
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
@Service(value = "userAuthoritiesDaoService")
public class UserAuthoritiesDaoServiceImpl implements UserAuthoritiesDaoService {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Optional<String> getAuthoritiesOfUser(int userId) {
        List<UserAuthoritiesMap> lstUserAuthoritiesMap = sessionFactory.getCurrentSession()
                                                                        .createQuery("from UserAuthoritiesMap where userId=?")
                                                                        .setParameter(0,userId)
                                                                        .list();
        if(lstUserAuthoritiesMap.size()>0){
            return Optional.of(lstUserAuthoritiesMap.get(0).getAuthorities());
        }

        return Optional.empty();
    }
}
