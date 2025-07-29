package com.alissondev.api_user.infrastructure.entitys.repository;

import com.alissondev.api_user.infrastructure.entitys.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

    @Modifying
    void updateUserById(Long id);
}
