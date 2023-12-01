package com.tecsup.ferreteria.users;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserModel, Long>{
    Optional<UserModel> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<UserModel> findById(Long id);
}
