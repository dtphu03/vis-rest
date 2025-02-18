package vis.restsocial.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.DTO.UserDTO;
import vis.restsocial.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;


    //Get AllUsers
//    @RequestMapping(value = "/user", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUser(){
//        List<User> listUsers = userRepo.findAll();
//        if(listUsers.isEmpty()){
//            return new ResponseEntity(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<User>>(listUsers, HttpStatus.OK);
//    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<UserDTO>> getUsers(){
        List<UserDTO> userDTOS = userService.getUsers();
        return ResponseEntity.ok(userDTOS);
    }

    //New
//    @RequestMapping(value = "/user/", method = RequestMethod.POST)
//    public User saveUser (@RequestBody User user){
//        return userRepo.save(user);
//    }
//
//
//    //Update
//    @RequestMapping(value = "/user/", method = RequestMethod.PUT)
//    public ResponseEntity<User> updateUser (@PathVariable(value  = "id") Long userId, @RequestBody User userForm){
//        User user = userRepo.getOne(userId);
//        if(user == null){
//            return ResponseEntity.notFound().build();
//        }
//        user.setName(userForm.getName());
//        user.setDate(userForm.getDate());
//        user.setPhone(userForm.getPhone());
//        user.setEmail(userForm.getEmail());
//
//        User updateUser = userRepo.save(user);
//        return ResponseEntity.ok(updateUser);
//    }
//
//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<User> deleteUser(@PathVariable(value = "id") Long id){
//        User user = userRepo.getOne(id);
//        if(user == null){
//            return ResponseEntity.notFound().build();
//        }
//        userRepo.delete(user);
//        return ResponseEntity.ok().build();
//    }
}


