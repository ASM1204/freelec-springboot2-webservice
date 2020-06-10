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
    private String catcherWin;

    @Column(nullable = false)
    private String catcherLose;

    @Column(nullable = false)
    private String runnerWin;

    @Column(nullable = false)
    private String runnerLose;

    @Column(nullable = false)
    private String nickName;


    @Builder
    public User(String name, String email, String picture, Role role, String nickName) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.nickName = nickName;
    }

    public User update(String name, String picture) {
        this.name = name;
        this.picture = picture;

        return this;
    }

    public User Rank(String name, String catcherWin, String catcherLose, String runnerWin, String runnerLose){
        this.name=name;
        this.catcherWin=catcherWin;
        this.catcherLose=catcherLose;
        this.runnerWin=runnerWin;
        this.runnerLose=runnerLose;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
