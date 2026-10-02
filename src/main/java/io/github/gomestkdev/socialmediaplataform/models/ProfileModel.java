package io.github.gomestkdev.socialmediaplataform.models;

import jakarta.persistence.*;

@Entity
public class ProfileModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "profile")
    @JoinColumn(name = "user")
    private UserModel user;
}
