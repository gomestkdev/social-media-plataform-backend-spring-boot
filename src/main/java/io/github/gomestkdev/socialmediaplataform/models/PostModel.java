package io.github.gomestkdev.socialmediaplataform.models;

import jakarta.persistence.*;

@Entity
public class PostModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserModel user;
}
