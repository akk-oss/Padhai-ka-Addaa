package com.padhai.backend.repository;
import com.padhai.backend.enums.Role;
import com.padhai.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
    long countByRole(Role role);
}
