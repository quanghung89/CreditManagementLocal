package com.napt.spring.dao.service.impl;

import com.napt.spring.dao.service.UserAuthoritiesDaoService;
import com.napt.spring.dao.service.UserDaoService;
import com.napt.spring.entity.User;
import com.napt.spring.security.SpringSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDaoService userDaoService;

    @Autowired
    private UserAuthoritiesDaoService userAuthoritiesDaoService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = userDaoService.loadUserByName(username);
        if(optUser.isPresent()){
            User user = optUser.get();
            //I dont know why exception here cannot map???
            //Optional<String> optAuthorities = userAuthoritiesDaoService.getAuthoritiesOfUser(user.getId());
            Optional<String> optAuthorities = Optional.of("ADMIN");
            return new SpringSecurityUser(user.getId(),
                                          user.getName(),
                                          user.getPass(),null,null,
                                          AuthorityUtils.commaSeparatedStringToAuthorityList(optAuthorities.orElse("")));
        }

        throw new UsernameNotFoundException("Not found username!");
    }
}
