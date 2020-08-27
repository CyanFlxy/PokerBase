package com.yuqiang.support.pokerbase;

import android.content.Context;
import android.graphics.drawable.Drawable;

public class CardBackImage {

    public static final int[] CARD_BACK_IMAGE = {
            R.drawable.cardback_1,
            R.drawable.cardback_2,
            R.drawable.cardback_3,
            R.drawable.cardback_4,
            R.drawable.cardback_5,
            R.drawable.cardback_6,
            R.drawable.cardback_7,
            R.drawable.cardback_8,
            R.drawable.cardback_9,
            R.drawable.cardback_10,
            R.drawable.cardback_11,
            R.drawable.cardback_12,
            R.drawable.cardback_13,
            R.drawable.cardback_14,
            R.drawable.cardback_15,
            R.drawable.cardback_16,
            R.drawable.cardback_17,
            R.drawable.cardback_18,
            R.drawable.cardback_19,
            R.drawable.cardback_20,
    };

    private static final Drawable[] cardBackDrawable = new Drawable[CARD_BACK_IMAGE.length];

    public static Drawable getBackImageId(Context context, int theme) {
        int id = CARD_BACK_IMAGE[theme];

        if (cardBackDrawable[theme] == null) {
            cardBackDrawable[theme] = context.getResources().getDrawable(id);
        }

        return cardBackDrawable[theme];
    }

}
