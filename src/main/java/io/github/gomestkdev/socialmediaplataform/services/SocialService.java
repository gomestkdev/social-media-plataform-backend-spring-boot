package io.github.gomestkdev.socialmediaplataform.services;

import io.github.gomestkdev.socialmediaplataform.models.GroupModel;
import io.github.gomestkdev.socialmediaplataform.models.PostModel;
import io.github.gomestkdev.socialmediaplataform.models.ProfileModel;
import io.github.gomestkdev.socialmediaplataform.models.UserModel;
import io.github.gomestkdev.socialmediaplataform.repositories.GroupRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.PostRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.ProfileRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ProfileRepository profileRepository;

    // --- Users ---

    public List<UserModel> getAllUsers() {
        return repository.findAll();
    }

    public UserModel getUserById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }

    public UserModel saveUser(UserModel user) {
        return repository.save(user);
    }

    public UserModel updateUser(Long id, UserModel updatedUser) {
        UserModel existingUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        existingUser.setUsername(updatedUser.getUsername());
        return repository.save(existingUser);
    }

    public UserModel deleteUser(Long id) {
        UserModel user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found."));

        repository.delete(user);
        return user;
    }

    // --- Profiles ---

    public ProfileModel saveProfile(Long userId, ProfileModel profile) {
        UserModel user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));
        profile.setUser(user);
        return profileRepository.save(profile);
    }

    // --- Posts ---

    public List<PostModel> getAllPosts() {
        return postRepository.findAll();
    }

    public PostModel savePost(Long userId, PostModel post) {
        UserModel user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));
        post.setUser(user);
        return postRepository.save(post);
    }

    // --- Groups ---

    public List<GroupModel> getAllGroups() {
        return groupRepository.findAll();
    }

    public GroupModel saveGroup(GroupModel group) {
        return groupRepository.save(group);
    }

    public UserModel addGroupToUser(Long userId, Long groupId) {
        UserModel user = repository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found."));
        GroupModel group = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found."));

        user.getGroups().add(group);
        return repository.save(user);
    }
}