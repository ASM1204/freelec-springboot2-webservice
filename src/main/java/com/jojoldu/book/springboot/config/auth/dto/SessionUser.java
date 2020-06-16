package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private String user_id;
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.user_id = String.valueOf(user.getUser_id());
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
