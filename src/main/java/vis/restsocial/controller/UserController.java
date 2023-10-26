package vis.restsocial.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.service.UserService;
import vis.restsocial.model.User;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserService userService;


    //Get AllUsers
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ResponseEntity<List<User>> listAllUser(){
        List<User> listUsers = userService.findAll();
        if(listUsers.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
    }

    //New
    @RequestMapping(value = "/user/", method = RequestMethod.POST)
    public User saveUser (@RequestBody User user){
        return userService.save(user);
    }


    //Update
    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser (@PathVariable(value  = "id") Long userId, @RequestBody User userForm){
        User user = userService.getOne(userId);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        user.setName(userForm.getName());
        user.setDate(userForm.getDate());
        user.setPhone(userForm.getPhone());
        user.setEmail(userForm.getEmail());

        User updateUser = userService.save(user);
        return ResponseEntity.ok(updateUser);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id){
        User user = userService.getOne(id);
        if(user == null){
            return ResponseEntity.notFound().build();
        }
        userService.delete(user);
        return ResponseEntity.ok().build();
    }
}


