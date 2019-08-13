package com.yusufalicezik.BackEndProje.repository;

import com.yusufalicezik.BackEndProje.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
