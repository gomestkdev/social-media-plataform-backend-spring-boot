package io.github.gomestkdev.socialmediaplataform.repositories;

import io.github.gomestkdev.socialmediaplataform.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
