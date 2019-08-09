package com.khang.repository;

import com.khang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
/*    @Query("SELECT u FROM User u Where u.userName = :userName")
    User findUserByUserName(@Param("userName") String userName);*/

    User findUserByUserName(String userName);

    @Query("SELECT u FROM User u WHERE u.userName = :userName AND u.password = :password")
    User findUser(@Param("userName") String userName, @Param("password") String password);

    List<User> findUserByCreatedDate(Date createDate);


  //  @Query("SELECT u FROM User u WHERE u.Date >= :fromAge and u.age <= :toAge");
    List<User> findUserByAgeBetween(@Param("fromAge") Long fromAge,@Param("toAge") Long toAge);
}
