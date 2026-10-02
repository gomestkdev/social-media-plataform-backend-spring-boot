package io.github.gomestkdev.socialmediaplataform.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
//    @JoinColumn(name = "social_profile_id")
    @JsonIgnore
    private ProfileModel profile;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<PostModel> posts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "user_group",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    @JsonIgnore
    private Set<GroupModel> groups = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(id, userModel.id) && Objects.equals(profile, userModel.profile) && Objects.equals(posts, userModel.posts) && Objects.equals(groups, userModel.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, profile, posts, groups);
    }
}
