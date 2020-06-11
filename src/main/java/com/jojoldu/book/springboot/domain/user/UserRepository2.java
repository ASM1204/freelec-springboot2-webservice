package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository2 extends JpaRepository<User, Long> {

    @Query("SELECT i FROM User i ORDER BY i.id DESC")
    List<User> findUser();

}
