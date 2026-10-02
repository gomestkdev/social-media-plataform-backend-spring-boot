package io.github.gomestkdev.socialmediaplataform.repositories;

import io.github.gomestkdev.socialmediaplataform.models.GroupModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<GroupModel, Long> {
}
