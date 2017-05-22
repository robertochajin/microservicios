package com.ciberdix.auth.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by robertochajin on 20/05/17.
 */
public interface CustomUserDetails extends UserDetailsService {
    UserDetails loadUserByIdUsername(Integer var1) throws UsernameNotFoundException;
}