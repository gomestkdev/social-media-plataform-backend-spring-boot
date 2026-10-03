package io.github.gomestkdev.socialmediaplataform;

import io.github.gomestkdev.socialmediaplataform.models.GroupModel;
import io.github.gomestkdev.socialmediaplataform.models.PostModel;
import io.github.gomestkdev.socialmediaplataform.models.ProfileModel;
import io.github.gomestkdev.socialmediaplataform.models.UserModel;
import io.github.gomestkdev.socialmediaplataform.repositories.GroupRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.PostRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.ProfileRepository;
import io.github.gomestkdev.socialmediaplataform.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;
    private final ProfileRepository profileRepository;
    private final PostRepository postRepository;


    public DataInitializer(
            UserRepository userRepository, GroupRepository groupRepository,
            ProfileRepository profileRepository, PostRepository postRepository
    ) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
        this.profileRepository = profileRepository;
        this.postRepository = postRepository;
    }

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            UserModel user1 = new UserModel();
            UserModel user2 = new UserModel();
            UserModel user3 = new UserModel();

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            GroupModel group1 = new GroupModel();
            GroupModel group2 = new GroupModel();

            // Associating users with groups
            group1.getUsers().add(user1);
            group1.getUsers().add(user2);

            group2.getUsers().add(user2);
            group2.getUsers().add(user3);

            groupRepository.save(group1);
            groupRepository.save(group2);

            // Saving users again to update the associations
            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);

            PostModel post1 = new PostModel();
            PostModel post2 = new PostModel();
            PostModel post3 = new PostModel();

            // Associating posts with users
            post1.setUser(user1);
            post2.setUser(user2);
            post3.setUser(user3);

            ProfileModel profile1 = new ProfileModel();
            ProfileModel profile2 = new ProfileModel();
            ProfileModel profile3 = new ProfileModel();

            // Associating profiles with users
            profile1.setUser(user1);
            profile2.setUser(user2);
            profile3.setUser(user3);

            profileRepository.save(profile1);
            profileRepository.save(profile2);
            profileRepository.save(profile3);

            // FETCH TYPES
            System.out.println("FETCHING SOCIAL USER");
            userRepository.findById(1L);
        };
    }
}
