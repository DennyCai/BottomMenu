package com.denny.bottommenu;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;

/**
 * Created by hasee on 2016/6/22.
 */
class MenuItem {
    String mTitle;
    StateListDrawable mStateDrawable;
    ColorStateList mColorState;

    public static class MenuFactory{
        /**
         *
         * @param context
         * @param title 标题
         * @param colorId 字体颜色
         * @param drawableId 图标
         * @return
         */
        public static MenuItem create(Context context,String title,int colorId,int drawableId){
            MenuItem item = new MenuItem();
            Resources res = context.getResources();
            ColorStateList colorStateList = null;
            StateListDrawable listDrawable = null;
            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.M) {
                colorStateList = res.getColorStateList(colorId);
            }
            else {
                colorStateList = res.getColorStateList(colorId, context.getTheme());
            }
            if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP_MR1) {
                Drawable drawable = res.getDrawable(drawableId);
                if(drawable instanceof StateListDrawable)
                    listDrawable = (StateListDrawable) drawable;
                else {
                    listDrawable = new StateListDrawable();
                    listDrawable.addState(new int[]{},drawable);
                }
            }
            item.mColorState = colorStateList;
            item.mStateDrawable = listDrawable;
            item.mTitle = title;
            return item;
        }
    }
}
