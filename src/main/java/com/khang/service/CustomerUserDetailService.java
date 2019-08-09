package com.khang.service;

import com.khang.entity.Role;
//import com.khang.entity.User;
import com.khang.repository.UserRepository;

///import com.khang.security.CustomerUserDetail;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class CustomerUserDetailService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public CustomerUserDetailService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      /*  User user = userRepository.findUserByUserName(s);
        if(user == null){
            throw  new UsernameNotFoundException("user not found");
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

        for (Role role: user.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }*/

        //  CustomerUserDetail userDetail = new CustomerUserDetail(s,user.getPassword(),grantedAuthorities);
        //    BeanUtils.copyProperties(user,userDetail);
        //    return userDetail;
        // }
        return null;
    }
}
