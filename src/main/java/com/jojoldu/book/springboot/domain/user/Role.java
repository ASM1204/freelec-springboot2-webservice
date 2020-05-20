package com.jojoldu.book.springboot.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    USER("ROLE_USER", "유저"),
    GM("ROLE_GM", "매니저");

    private final String key;
    private final String title;

}
