package io.github.gomestkdev.socialmediaplataform.services;

import io.github.gomestkdev.socialmediaplataform.models.UserModel;
import io.github.gomestkdev.socialmediaplataform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    UserRepository repository;

    public List<UserModel> getAllUsers() {
        return repository.findAll();
    }

    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }

    public UserModel deleteUser(Long id) {
        UserModel user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(("User not found.")));

        repository.delete(user);
        return user;
    }
}
