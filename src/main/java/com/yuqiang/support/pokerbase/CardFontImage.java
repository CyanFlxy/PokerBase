package com.yuqiang.support.pokerbase;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class CardFontImage {

    public static int[] FRONT_STYLE_IMAGE = {
            R.drawable.theme_card_front_style1,
            R.drawable.theme_card_front_style2,
            R.drawable.theme_card_front_style3,
            R.drawable.theme_card_front_style4,};


    public static final int[] FRONT_STYLE = {
            R.style.Card_Front_Theme0,
            R.style.Card_Front_Theme1,
            R.style.Card_Front_Theme2,
            R.style.Card_Front_Theme3};

    private static int[] HEART_STYLE_INDEX = {
            R.attr.card_heart_1,
            R.attr.card_heart_2,
            R.attr.card_heart_3,
            R.attr.card_heart_4,
            R.attr.card_heart_5,
            R.attr.card_heart_6,
            R.attr.card_heart_7,
            R.attr.card_heart_8,
            R.attr.card_heart_9,
            R.attr.card_heart_10,
            R.attr.card_heart_11,
            R.attr.card_heart_12,
            R.attr.card_heart_13,
    };

    private static int[] SPADE_STYLE_INDEX = {
            R.attr.card_spade_1,
            R.attr.card_spade_2,
            R.attr.card_spade_3,
            R.attr.card_spade_4,
            R.attr.card_spade_5,
            R.attr.card_spade_6,
            R.attr.card_spade_7,
            R.attr.card_spade_8,
            R.attr.card_spade_9,
            R.attr.card_spade_10,
            R.attr.card_spade_11,
            R.attr.card_spade_12,
            R.attr.card_spade_13,
    };

    private static int[] CLUB_STYLE_INDEX = {

            R.attr.card_club_1,
            R.attr.card_club_2,
            R.attr.card_club_3,
            R.attr.card_club_4,
            R.attr.card_club_5,
            R.attr.card_club_6,
            R.attr.card_club_7,
            R.attr.card_club_8,
            R.attr.card_club_9,
            R.attr.card_club_10,
            R.attr.card_club_11,
            R.attr.card_club_12,
            R.attr.card_club_13,
    };

    private static int[] DIAMOND_STYLE_INDEX = {

            R.attr.card_diamond_1,
            R.attr.card_diamond_2,
            R.attr.card_diamond_3,
            R.attr.card_diamond_4,
            R.attr.card_diamond_5,
            R.attr.card_diamond_6,
            R.attr.card_diamond_7,
            R.attr.card_diamond_8,
            R.attr.card_diamond_9,
            R.attr.card_diamond_10,
            R.attr.card_diamond_11,
            R.attr.card_diamond_12,
            R.attr.card_diamond_13,
    };

    private static final Map<Suit, int[]> attrMap = new EnumMap<>(Suit.class);

    static {
        attrMap.put(Suit.HEART, HEART_STYLE_INDEX);
        attrMap.put(Suit.SPADE, SPADE_STYLE_INDEX);
        attrMap.put(Suit.CLUB, CLUB_STYLE_INDEX);
        attrMap.put(Suit.DIAMOND, DIAMOND_STYLE_INDEX);
    }

    private static int currentFrontStyle;
    private static int[] cardImageId;
    private static Drawable[] cardDrawable;

    public static Drawable getCardImageId(Context context, Card card, int styleIndex) {
        int style = FRONT_STYLE[styleIndex];
        initCardFrontStyle(style);

        int index = card.getSuit().ordinal() * 13 + card.getValue() - 1;

        if (cardImageId[index] == 0) {
            cardImageId[index] = getCardImage(context, card, style);
        }

        if (cardDrawable[index] == null && cardImageId[index] != 0) {
            cardDrawable[index] = context.getResources().getDrawable(cardImageId[index]);
        }

        return cardDrawable[index];
    }

    private static void initCardFrontStyle(int style) {

        if (style != currentFrontStyle) {
            currentFrontStyle = style;

            if (cardImageId == null) {
                cardImageId = new int[53];
                cardImageId[52] = 0;

                cardDrawable = new Drawable[53];
                cardDrawable[52] = null;

            } else {
                Arrays.fill(cardImageId, 0);
                Arrays.fill(cardDrawable, null);
            }
        }
    }


    private static int getCardImage(Context context, Card card, int style) {
        int attr = attrMap.get(card.getSuit())[card.getValue() - 1];
        TypedArray a = context.obtainStyledAttributes(style, new int[]{attr});
        int id = a.getResourceId(0, 0);
        a.recycle();

        return id;
    }

}
