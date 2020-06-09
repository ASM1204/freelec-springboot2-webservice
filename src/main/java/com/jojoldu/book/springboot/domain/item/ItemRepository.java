package com.jojoldu.book.springboot.domain.item;

import com.jojoldu.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<User, Long> {

    @Query("SELECT i FROM shop i")
    List<User> findItem();

}
