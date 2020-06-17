package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.shop.Shop;
import com.jojoldu.book.springboot.web.dto.UserResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    List<User> findUserMy(Long user_id);

}
