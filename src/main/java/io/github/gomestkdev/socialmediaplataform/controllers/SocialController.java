package io.github.gomestkdev.socialmediaplataform.controllers;

import io.github.gomestkdev.socialmediaplataform.models.UserModel;
import io.github.gomestkdev.socialmediaplataform.services.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/social-media")
public class SocialController {

    @Autowired
    private SocialService service;

    @GetMapping()
    public ResponseEntity<List<UserModel>> getUsers() {
        return new ResponseEntity<>(service.getAllUsers(), OK);
    }

    @PostMapping()
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(service.saveUser(user), CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.deleteUser(id), NO_CONTENT);
    }
}
