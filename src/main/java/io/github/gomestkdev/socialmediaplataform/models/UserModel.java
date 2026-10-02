package io.github.gomestkdev.socialmediaplataform.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne
//    @JoinColumn(name = "social_profile_id")
    private ProfileModel profile;

    @OneToMany(mappedBy = "user")
    private List<PostModel> posts = new ArrayList<>();

    @ManyToMany
    private Set<GroupModel> groups = new HashSet<>();
}
