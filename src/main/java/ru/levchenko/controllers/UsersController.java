package ru.levchenko.controllers;

import com.sun.net.httpserver.Authenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.levchenko.forms.UserForm;
import ru.levchenko.models.User;
import ru.levchenko.models.dto.UserDto;
import ru.levchenko.repositories.UsersRepository;

import ru.levchenko.services.SignUpService;

import java.util.List;

import static ru.levchenko.models.dto.UserDto.from;

@RestController
public class UsersController {

    @Autowired
    UsersRepository usersRepository;
    @Autowired
    SignUpService signUpService;


    @GetMapping("users")
    public List<UserDto> getUsers(){
        return from(usersRepository.findAll());
    }
    @GetMapping("users/{user-id}")
    public User getUser(@PathVariable("user-id") Long id){
        return usersRepository.findById(id).orElseThrow(IllegalAccessError::new);
    }
    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody UserForm user){
        if (signUpService.signUp(user))
            return new ResponseEntity<Authenticator.Success>(HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

}
