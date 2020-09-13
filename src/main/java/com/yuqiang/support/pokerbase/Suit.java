package com.yuqiang.support.pokerbase;

/**
 * 卡牌花色。
 * <p>
 * Created by cyanflxy on 2017/2/11.
 */

public enum Suit {
    /**
     * 红桃，♥️
     */
    HEART() {
        @Override
        int getIndex() {
            return 0;
        }

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
        int getIndex() {
            return 1;
        }

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
        int getIndex() {
            return 2;
        }

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
        int getIndex() {
            return 3;
        }

        @Override
        public boolean isSameColor(Suit suit) {
            return suit == HEART || suit == DIAMOND;
        }
    },
    /**
     * 大小王
     */
    JOKER() {
        @Override
        int getIndex() {
            return 4;
        }

        @Override
        public boolean isSameColor(Suit suit) {
            return suit == JOKER;
        }
    },
    ;

    abstract int getIndex();

    public abstract boolean isSameColor(Suit suit);
}
