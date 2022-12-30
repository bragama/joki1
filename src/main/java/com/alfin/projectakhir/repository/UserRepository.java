package com.alfin.projectakhir.repository;

import com.alfin.projectakhir.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.name = :name AND u.password = :password")
    User getUserLogin(String name, String password);
}
