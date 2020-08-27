package com.yuqiang.support.pokerbase;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/**
 * 扑克牌定义.
 * <p>
 * Created by cyanflxy on 2017/1/18.
 */

public class Card implements Parcelable {

    private static final List<Card> allCards = new ArrayList<>(54);
    private static final Map<Suit, List<Card>> cardMap = new EnumMap<>(Suit.class);
    private static final Card backCard = new Card(Suit.HEART, -1) {
        @Override
        public boolean isBack() {
            return true;
        }
    };

    private static final Card emptyCard = new Card(Suit.HEART, 0) {
        @Override
        public boolean isEmpty() {
            return true;
        }
    };

    public static void init() {
        if (!cardMap.isEmpty()) {
            return;
        }

        for (Suit suit : Suit.values()) {
            List<Card> cardList = new ArrayList<>();
            cardList.add(emptyCard);

            for (int i = 1; i <= 13; i++) {
                cardList.add(new Card(suit, i));
            }

            cardMap.put(suit, cardList);
            allCards.addAll(cardList.subList(1, cardList.size()));
        }
    }

    public static Card getCard(Suit suit, int value) {
        return cardMap.get(suit).get(value);
    }

    public static Card getBackCard() {
        return backCard;
    }

    public static Card getEmptyCard() {
        return emptyCard;
    }

    public static List<Card> getAllCards() {
        return new ArrayList<>(allCards);
    }

    public static Card getRedJoker() {
        // 大王卡牌，当前没有该卡牌图片
        return null;
    }

    public static Card getBlackJoker() {
        // 小王卡牌，当前没有该卡牌图片
        return null;
    }

    private final Suit suit;
    private final int value;

    private Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isBack() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (value != card.value) return false;

        return value == 0 || suit == card.suit;

    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return 0;
        }

        int result = suit != null ? suit.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }

    @NonNull
    @Override
    public String toString() {
        if (isEmpty()) {
            return "EMPTY";
        }

        if (isBack()) {
            return "BACK";
        }

        String v;

        switch (value) {
            case 1:
                v = "A";
                break;
            case 11:
                v = "J";
                break;
            case 12:
                v = "Q";
                break;
            case 13:
                v = "K";
                break;
            default:
                v = String.valueOf(value);
                break;
        }

        return suit + " " + v;
    }

    protected Card(Parcel in) {
        suit = Suit.values()[in.readInt()];
        value = in.readInt();
    }

    public static final Creator<Card> CREATOR = new Creator<Card>() {
        @Override
        public Card createFromParcel(Parcel in) {
            return new Card(in);
        }

        @Override
        public Card[] newArray(int size) {
            return new Card[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(suit.ordinal());
        dest.writeInt(value);
    }
}
