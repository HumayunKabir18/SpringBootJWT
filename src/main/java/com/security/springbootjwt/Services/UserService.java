package com.security.springbootjwt.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.security.springbootjwt.Dao.UserDao;
import com.security.springbootjwt.Entites.user;

@Service
public interface UserService {
      public void add(UserDao userdao);
    public List<user> users();
    public Optional<user> getUserById(int id);
    public Optional<user> updateUser(UserDao userDao);
}
