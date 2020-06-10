package com.jojoldu.book.springboot.domain.user;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private int catcher_win;

    @Column(nullable = false)
    private int catcher_lose;

    @Column(nullable = false)
    private int runner_win;

    @Column(nullable = false)
    private int runner_lose;

    @Column(nullable = false)
    private int berry;


    @Builder
    public User(String name, String email, String picture, Role role, int berry) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.berry = berry;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User Rank(String name, int catcher_win, int catcher_lose, int runner_win, int runner_lose) {
        this.name = name;
        this.catcher_win = catcher_win;
        this.catcher_lose = catcher_lose;
        this.runner_win = runner_win;
        this.runner_lose = runner_lose;
        return this;
    }

    public User Berry(int berry) {
        this.berry = berry;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
