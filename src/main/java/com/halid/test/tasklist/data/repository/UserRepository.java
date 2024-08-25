package com.halid.test.tasklist.data.repository;

import com.halid.test.tasklist.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);

//    @Query("select u from User u where " +
//            "upper(u.firstName) like upper(concat('%', :firstName, '%'))" +
//            "or upper(u.lastName) like upper(concat('%', :lastName, '%'))")
//    List<User> findUserByName(String firstName, String lastName);



}
