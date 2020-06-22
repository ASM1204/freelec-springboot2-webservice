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
    private Long user_id;

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

    @Column(nullable = false)
    private int smoke_bomb;

    @Column(nullable = false)
    private int smoke_bomb1;

    @Column(nullable = false)
    private int smoke_bomb2;

    @Column(nullable = false)
    private int smoke_bomb3;

    @Column(nullable = false)
    private int smoke_bomb4;

    @Column(nullable = false)
    private int smoke_bomb5;

    @Column(nullable = false)
    private int smoke_bomb13;


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

    public User Rank(String name, int catcher_win, int catcher_lose, int runner_win, int runner_lose) {
        this.name = name;
        this.catcher_win = catcher_win;
        this.catcher_lose = catcher_lose;
        this.runner_win = runner_win;
        this.runner_lose = runner_lose;
        return this;
    }

    public void my_berry(String name, int berry) {
        this.name = name;
        this.berry = berry;
    }

    public void item_add(String item_name, int item_berry) {
        switch (item_name) {
            case "smoke_bomb":
                smoke_bomb++;
                berry -= item_berry;
                break;
            case "smoke_bomb1":
                smoke_bomb1++;
                berry -= item_berry;
                break;
            case "smoke_bomb2":
                smoke_bomb2++;
                berry -= item_berry;
                break;
            case "smoke_bomb3":
                smoke_bomb3++;
                berry -= item_berry;
                break;
            case "smoke_bomb4":
                smoke_bomb4++;
                berry -= item_berry;
                break;
            case "smoke_bomb5":
                smoke_bomb5++;
                berry -= item_berry;
                break;
            case"smoke_bomb13":
                smoke_bomb13++;
                berry -= item_berry;
                break;
        }
    }
    public void item_sell(int item_berry) {
        berry += item_berry;
    }
    public void select_item(String item_name) {
        switch (item_name) {
            case "smoke_bomb":
                smoke_bomb--;
                break;
            case "smoke_bomb1":
                smoke_bomb1--;
                break;
            case "smoke_bomb2":
                smoke_bomb2--;
                break;
            case "smoke_bomb3":
                smoke_bomb3--;
                break;
            case "smoke_bomb4":
                smoke_bomb4--;
                break;
            case "smoke_bomb5":
                smoke_bomb5--;
                break;
            case"smoke_bomb13":
                smoke_bomb13--;
                break;
        }
    }

    public String getRoleKey() {
        return this.role.getKey();
    }
}
