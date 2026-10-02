package io.github.gomestkdev.socialmediaplataform.repositories;

import io.github.gomestkdev.socialmediaplataform.models.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostModel, Long> {
}
