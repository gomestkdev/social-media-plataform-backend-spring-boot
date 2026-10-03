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

import java.util.Arrays;

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
            // 1. Create Users
            UserModel user1 = new UserModel();
            user1.setUsername("jose.bolivar");

            UserModel user2 = new UserModel();
            user2.setUsername("dev_python");

            UserModel user3 = new UserModel();
            user3.setUsername("mtg_player");

            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            // 2. Create Groups and associate Users
            GroupModel group1 = new GroupModel();
            group1.setName("Backend Developers");
            group1.getUsers().addAll(Arrays.asList(user1, user2));

            GroupModel group2 = new GroupModel();
            group2.setName("Commander Players");
            group2.getUsers().addAll(Arrays.asList(user2, user3));

            groupRepository.saveAll(Arrays.asList(group1, group2));

            // Update users to reflect the ManyToMany relationship
            userRepository.saveAll(Arrays.asList(user1, user2, user3));

            // 3. Create Posts (Aqui estão as descriptions dos posts)
            PostModel post1 = new PostModel();
            post1.setDescription("Starting the architecture setup for a new Python RESTful API for an e-commerce platform!");
            post1.setUser(user1);

            PostModel post2 = new PostModel();
            post2.setDescription("Tweaking my Commander deck list. Zhulodok, Void Gorger is an absolute powerhouse.");
            post2.setUser(user2);

            PostModel post3 = new PostModel();
            post3.setDescription("Just submitted the final research paper on computational thinking to the journal.");
            post3.setUser(user3);

            postRepository.saveAll(Arrays.asList(post1, post2, post3));

            // 4. Create Profiles (Aqui estão as descriptions dos perfis)
            ProfileModel profile1 = new ProfileModel();
            profile1.setDescription("Computer Science graduate student and backend developer.");
            profile1.setUser(user1);

            ProfileModel profile2 = new ProfileModel();
            profile2.setDescription("Magic: The Gathering enthusiast and software architect.");
            profile2.setUser(user2);

            ProfileModel profile3 = new ProfileModel();
            profile3.setDescription("Researcher focusing on Problem-Based Learning.");
            profile3.setUser(user3);

            profileRepository.saveAll(Arrays.asList(profile1, profile2, profile3));

            // 5. Fetch Test
            System.out.println("FETCHING SOCIAL USER");
            userRepository.findById(1L).ifPresent(user -> {
                System.out.println("User successfully found during initialization.");
            });
        };
    }
}