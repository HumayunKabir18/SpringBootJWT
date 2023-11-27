package com.security.springbootjwt.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.springbootjwt.Dao.UserDao;
import com.security.springbootjwt.Entites.user;
import com.security.springbootjwt.Services.UserService;

import jakarta.validation.Valid;

@RestController
@Validated
// @RequestMapping("/auth")
public class UserController {
     @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    public ResponseEntity<List<user>> getAlluser(){
        List<user> list = userService.users();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(list);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<user> getUserById(@PathVariable int id){
        Optional<user> userOptional = userService.getUserById(id);
        
        return userOptional
                .map(usr->ResponseEntity.ok().body(usr))
                .orElseGet(()->ResponseEntity.notFound().build());
                }

    @PostMapping("/user/add")
    public String userRegistration(@Valid @RequestBody UserDao userDao){
        userService.add(userDao);
        return "successfully added";
    }

   @PutMapping("/user/update")
   public ResponseEntity< Optional<user>> update(@RequestBody UserDao userDao){
    Optional<user> updateUser = userService.updateUser(userDao);
    return ResponseEntity.ok(updateUser);
   } 
}
