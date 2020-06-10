package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.web.dto.UserBuyResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Query("SELECT i FROM User i where i.email = :email")
    Collection<UserBuyResponseDto> findUser(String email);

}
