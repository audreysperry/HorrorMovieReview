package com.audreysperry.moviereview.services;

import com.audreysperry.moviereview.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User findByUsername(String username);

}
