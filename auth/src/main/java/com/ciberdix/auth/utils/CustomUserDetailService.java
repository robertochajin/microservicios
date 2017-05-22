package com.ciberdix.auth.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by robertochajin on 20/05/17.
 */
public class CustomUserDetailService implements CustomUserDetails {
    @Override
    public UserDetails loadUserByIdUsername(Integer var1) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
