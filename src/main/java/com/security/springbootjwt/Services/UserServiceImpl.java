package com.security.springbootjwt.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.security.springbootjwt.Dao.UserDao;
import com.security.springbootjwt.Entites.user;
import com.security.springbootjwt.Repositories.UserRepository;

@Component
public class UserServiceImpl implements UserService {

     @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepo;
    @Override
    public void add(UserDao userdao) {
       user usr = new user(userdao.getEmail(), passwordEncoder.encode(userdao.getPassword()),userdao.getFullname());
       userRepo.save(usr);
       
    }
    @Override
    public List<user> users() {
        List<user> userList = (List<user>) userRepo.findAll();
        return userList;
    }
    @Override
    public Optional<user> getUserById(int id) {
        
        return userRepo.findById(id);
    }
    @Override
    public Optional<user> updateUser(UserDao userDao) {
       Optional<user> userOptional = userRepo.findByEmail(userDao.getEmail());
       if (userOptional.isEmpty()) {
        return Optional.empty();
    }
       userOptional.ifPresent(user->{
       String fullname = userDao.getFullname();
       if(fullname!=null && !fullname.isEmpty()){
        user.setFullname(fullname);
       }
    }
       );


        userOptional.ifPresent(user->{
       String password = userDao.getPassword();
       if(password!=null && !password.isEmpty()){
        user.setPassword(password);
       }
    }
       );
       
    return userOptional;
    //    if(!userDao.getFullname().isEmpty()){
    //     userOptional.setFullname(userDao.getFullname());
    //    }
    //    if(!userDao.getPassword().isEmpty()){
    //     userOptional.setPassword(userDao.getPassword());
    //    }
    //    userRepo.save(userOptional);
    //    return userOptional;
 
    
}
    
}
