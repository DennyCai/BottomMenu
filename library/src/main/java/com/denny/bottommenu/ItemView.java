package com.denny.bottommenu;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hasee on 2016/6/22.
 */
class ItemView extends FrameLayout {
    private ImageView mImage;
    private TextView mText;

    public ItemView(Context context) {
        super(context);
        init();
    }


    public ItemView(Context context, AttributeSet attrs) {
        this(context);
    }

    public ItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context);
    }

    private void init() {
        mImage = new ImageView(getContext());
        mText = new TextView(getContext());
        LayoutParams lp = generateDefaultLayoutParams();
        lp.width = lp.height = (int) getResources().getDimension(R.dimen.bottom_menu_item_icon_size);
        lp.gravity = Gravity.CENTER_HORIZONTAL;
        mImage.setLayoutParams(lp);
        lp = generateDefaultLayoutParams();
        lp.width = lp.height = LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL;
        mText.setLayoutParams(lp);
    }

    ItemView setUpByMenuItem(MenuItem item){
        mImage.setImageDrawable(item.mStateDrawable);
        mText.setTextColor(item.mColorState);
        mText.setText(item.mTitle);
        return this;
    }

    static View createFrom(Context context,MenuItem item) {
        return new ItemView(context).setUpByMenuItem(item);
    }
}
