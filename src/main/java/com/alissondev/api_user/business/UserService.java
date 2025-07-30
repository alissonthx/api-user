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

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User with email " + email + " not found")
        );
    }

    public void deleteUserByEmail(String email) {
        userRepository.deleteByEmail(email);
    }

    public void updateUserById(Long id, User user) {
        User userEntity = userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found")
        );

        User userToUpdate = User.builder()
                .name(user.getName() != null && !user.getName().isEmpty() ? user.getName() : userEntity.getName())
                .email(user.getEmail() != null && !user.getEmail().isEmpty() ? user.getEmail() : userEntity.getEmail())
                .id(user.getId())
                .build();
        userRepository.saveAndFlush(userToUpdate);
    }
}
