package com.alissondev.api_user.business;

import com.alissondev.api_user.infrastructure.entitys.User;
import com.alissondev.api_user.infrastructure.entitys.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.saveAndFlush(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found")
        );
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void updateUserByEmail(String email, User user) {
        User userEntity = findByEmail(email);

        User userToUpdate = User.builder()
                .email(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : email)
                .build();
    }

    public void updateUserById(Long id, User user) {
        User userEntity = findById(id);

        User userToUpdate = User.builder()
                .email(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : userEntity.getEmail())
                .build();
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
