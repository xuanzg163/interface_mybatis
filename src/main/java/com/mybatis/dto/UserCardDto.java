package com.mybatis.dto;

import com.mybatis.po.Card;
import com.mybatis.po.User;

public class UserCardDto {

    private User user;
    private Card card;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "UserCardDto{" +
                "user=" + user +
                ", card=" + card +
                '}';
    }
}
