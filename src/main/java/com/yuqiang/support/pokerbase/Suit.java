package com.yuqiang.support.pokerbase;

/**
 * 卡牌花色。
 * <p>
 * Created by cyanflxy on 2017/2/11.
 */

public enum Suit {
    /**
     * 大小王
     */
    JOKER() {
        @Override
        public boolean isSameColor(Suit suit) {
            return suit == JOKER;
        }
    },
    /**
     * 红桃，♥️
     */
    HEART() {
        @Override
        public boolean isSameColor(Suit suit) {
            return suit == HEART || suit == DIAMOND;
        }
    },
    /**
     * 黑桃，♠️
     */
    SPADE() {
        @Override
        public boolean isSameColor(Suit suit) {
            return suit == SPADE || suit == CLUB;
        }
    },
    /**
     * 梅花，♣️
     */
    CLUB() {
        @Override
        public boolean isSameColor(Suit suit) {
            return suit == SPADE || suit == CLUB;
        }
    },
    /**
     * 方片，♦️
     */
    DIAMOND() {
        @Override
        public boolean isSameColor(Suit suit) {
            return suit == HEART || suit == DIAMOND;
        }
    };

    public abstract boolean isSameColor(Suit suit);
}
