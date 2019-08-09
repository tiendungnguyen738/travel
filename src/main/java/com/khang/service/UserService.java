package com.khang.service;

import com.khang.entity.User;
import com.khang.model.request.UserRequest;

public interface UserService {

    User insert(UserRequest userRequest);
}
