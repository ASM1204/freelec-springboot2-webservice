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
    private String catcher_win;

    @Column(nullable = false)
    private String catcher_lose;

    @Column(nullable = false)
    private String runner_win;

    @Column(nullable = false)
    private String runner_lose;


    @Builder
    public User(String name, String email, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User Rank(String name, String catcher_win, String catcher_lose, String runner_win, String runner_lose){
        this.name=name;
        this.catcher_win=catcher_win;
        this.catcher_lose=catcher_lose;
        this.runner_win=runner_win;
        this.runner_lose=runner_lose;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
