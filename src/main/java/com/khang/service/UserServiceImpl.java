package com.khang.service;

import com.khang.entity.Role;
import com.khang.entity.User;
import com.khang.model.request.UserRequest;
import com.khang.repository.RoleRepository;
import com.khang.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public User insert(UserRequest userRequest) {

        User user = new User();

        BeanUtils.copyProperties(userRequest,user);
                                //bi sao chep, sao chep,

        Set<Role> roles = new HashSet<Role>();
        for(Long id : userRequest.getIds() ){
            Role role = roleRepository.findOne(id);
            roles.add(role);
        }

        user.setRoles(roles);
        userRepository.save(user);

//        for (Role role: roles){
//            role.setUsers(user);
//        }
        //đệ quy: ví dụ: 1 user có nhiều role, trong 1 role có nhiều user
        roles.forEach(role ->role.getUsers().add(user));

        return user;
    }

    public void Update(UserRequest userRequest, long id)
    {
        User userExist = userRepository.findOne(id);
        if(userExist == null){
            return;
        }
        User user  = new User();
        BeanUtils.copyProperties(userRequest,user);
        Set<Role> roles = new HashSet<>();
        for(Long idRole:userRequest.getIds()){
            Role role = roleRepository.findOne(idRole);
            roles.add(role);
        }
        user.setRoles(roles);
        user.setCreatedDate(userExist.getCreatedDate());
        user.setModifiedDate(userExist.getModifiedDate());
        user.setModifiedBy(userExist.getModifiedBy());
        user.setId(id);
        userRepository.save(user);
    }
    public void delete(long id){
        User userExist = userRepository.findOne(id);
        if(userExist == null){
            return;
        }
        userRepository.delete(id);
    }
}
