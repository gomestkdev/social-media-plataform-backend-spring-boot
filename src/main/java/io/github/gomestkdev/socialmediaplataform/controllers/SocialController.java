package io.github.gomestkdev.socialmediaplataform.controllers;

import io.github.gomestkdev.socialmediaplataform.models.GroupModel;
import io.github.gomestkdev.socialmediaplataform.models.PostModel;
import io.github.gomestkdev.socialmediaplataform.models.ProfileModel;
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

    // --- Users ---

    @GetMapping()
    public ResponseEntity<List<UserModel>> getUsers() {
        return new ResponseEntity<>(service.getAllUsers(), OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserModel> getUserById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.getUserById(id), OK);
    }

    @PostMapping("/users")
    public ResponseEntity<UserModel> saveUser(@RequestBody UserModel user) {
        return new ResponseEntity<>(service.saveUser(user), CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserModel> updateUser(@PathVariable("id") Long id, @RequestBody UserModel user) {
        return new ResponseEntity<>(service.updateUser(id, user), OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserModel> deleteUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(service.deleteUser(id), NO_CONTENT);
    }

    // --- Profiles ---

    @PostMapping("/{id}/profiles")
    public ResponseEntity<ProfileModel> saveProfile(@PathVariable("id") Long id, @RequestBody ProfileModel profile) {
        return new ResponseEntity<>(service.saveProfile(id, profile), CREATED);
    }

    // --- Posts ---

    @GetMapping("/posts")
    public ResponseEntity<List<PostModel>> getPosts() {
        return new ResponseEntity<>(service.getAllPosts(), OK);
    }

    @PostMapping("/{id}/posts")
    public ResponseEntity<PostModel> savePost(@PathVariable("id") Long id, @RequestBody PostModel post) {
        return new ResponseEntity<>(service.savePost(id, post), CREATED);
    }

    // --- Groups ---

    @GetMapping("/groups")
    public ResponseEntity<List<GroupModel>> getGroups() {
        return new ResponseEntity<>(service.getAllGroups(), OK);
    }

    @PostMapping("/groups")
    public ResponseEntity<GroupModel> saveGroup(@RequestBody GroupModel group) {
        return new ResponseEntity<>(service.saveGroup(group), CREATED);
    }

    @PutMapping("/{userId}/groups/{groupId}")
    public ResponseEntity<UserModel> addGroupToUser(@PathVariable("userId") Long userId, @PathVariable("groupId") Long groupId) {
        return new ResponseEntity<>(service.addGroupToUser(userId, groupId), OK);
    }
}