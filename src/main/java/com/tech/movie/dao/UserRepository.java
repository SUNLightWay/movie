package com.tech.movie.dao;
import com.tech.movie.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByAccount(String account);

    User findByEmail(String email);

    User findByPhone(String phone);

    User findByAccountAndPassword(String account, String password);

    User findByEmailAndPassword(String email, String password);

    User findByPhoneAndPassword(String phone, String password);

}