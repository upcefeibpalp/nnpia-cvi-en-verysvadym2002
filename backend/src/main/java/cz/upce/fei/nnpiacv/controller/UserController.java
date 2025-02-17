package cz.upce.fei.nnpiacv.controller;

import cz.upce.fei.nnpiacv.domain.User;
import cz.upce.fei.nnpiacv.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService = new UserService();

    @GetMapping("/")
    public String findUser(){
        return userService.findUser();
    }

    @GetMapping("/user/{id}")
    public User findUser(
            @PathVariable Long id
    ){
        return userService.findById(id);
    }

    @GetMapping("/user")
    public Collection<User> findAllUsers(

    ){
        return  userService.geAllUsers();
    }
}
