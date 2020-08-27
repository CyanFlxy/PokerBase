package com.yuqiang.support.pokerbase;

public class TableBackImage {

    public static final int[] THUMBNAIL_IMAGE = {
            R.drawable.background_0_small,
            R.drawable.background_1_small,
            R.drawable.background_2_small,
            R.drawable.background_3_small,
            R.drawable.background_4_small,
            R.drawable.background_5_small,
            R.drawable.background_6_small,
            R.drawable.background_7_small,
            R.drawable.background_8_small,
    };

    public static final int[] BACKGROUND_IMAGE = {
            R.drawable.background_0,
            R.drawable.background_1,
            R.drawable.background_2,
            R.drawable.background_3,
            R.drawable.background_4,
            R.drawable.background_5,
            R.drawable.background_6,
            R.drawable.background_7,
            R.drawable.background_8,
    };

    public static int getBackImageId(int styleIndex) {
        return BACKGROUND_IMAGE[styleIndex];
    }

}
