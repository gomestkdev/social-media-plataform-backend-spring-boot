package io.github.gomestkdev.socialmediaplataform.repositories;

import io.github.gomestkdev.socialmediaplataform.models.ProfileModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<ProfileModel, Long> {
}
