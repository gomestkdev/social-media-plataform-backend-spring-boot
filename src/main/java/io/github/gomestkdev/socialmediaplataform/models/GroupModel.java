package io.github.gomestkdev.socialmediaplataform.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class GroupModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(mappedBy = "groups")
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private Set<UserModel> users = new HashSet<>();
}
