package com.khang.repository.customer.impl;

import com.khang.entity.User;
import com.khang.model.request.UserRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

public class UserRepositoryImpl implements UserCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // @Override
    public List<User> findAllByProperties(UserRequest userRequest)
    {
        StringBuilder sql = new StringBuilder("SELECT *FROM user WHERE 1 = 1");

        Query query = entityManager.createNativeQuery(sql.toString());
       return null;
    }
}
