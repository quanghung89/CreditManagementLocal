package com.napt.spring.dao.service;

import java.util.Optional;

/**
 * Created by napt2017 on 4/6/2017.
 */
public interface UserAuthoritiesDaoService {
    Optional<String> getAuthoritiesOfUser(int userId);
}
