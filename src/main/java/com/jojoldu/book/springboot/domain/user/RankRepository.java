package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RankRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u")
    List<User> findRank();

}
