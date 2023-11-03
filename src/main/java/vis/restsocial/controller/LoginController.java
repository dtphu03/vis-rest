package vis.restsocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vis.restsocial.model.Login;
import vis.restsocial.service.LoginRepo;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    LoginRepo loginRepo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<List<Login>> listAllLogin() {
        List<Login> listLogins = loginRepo.findAll();
        if (listLogins.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Login>>(listLogins, HttpStatus.OK);

    }

    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public Login saveLogin(Login login){
        return loginRepo.save(login);
    }

    @RequestMapping(value = "/login/", method = RequestMethod.PUT)
    public ResponseEntity<Login> updateLogin (@PathVariable(value = "id") Long loginId, @RequestBody Login loginForm){
        Login login = loginRepo.getOne(loginId);
        if (login == null){
            return ResponseEntity.notFound().build();
        }
        login.setPassword(loginForm.getPassword());
        login.setUser_id(loginForm.getUser_id());

        Login updateLogin = loginRepo.save(login);
        return ResponseEntity.ok(updateLogin);
    }

    @RequestMapping(value = "/login/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Login> deleteLogin(@PathVariable(value = "id") Long id){
        Login login = loginRepo.getOne(id);
        if(login == null){
            return ResponseEntity.notFound().build();
        }
        loginRepo.delete(login);
        return ResponseEntity.ok().build();
    }
}
