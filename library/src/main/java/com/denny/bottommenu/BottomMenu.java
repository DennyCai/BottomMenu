package com.denny.bottommenu;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

/**
 * Created by hasee on 2016/6/22.
 */
public class BottomMenu extends FrameLayout {

    private View mContainer;

    public BottomMenu(Context context) {
        this(context,null);
    }

    public BottomMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public BottomMenu(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context,attrs);
    }

    private void init(Context context, AttributeSet attrs) {
//        MenuItem item = MenuItem.MenuFactory.create(context,"1",R.color.text_color,R.drawable.icon);
//        setMenus();
    }

    @Override
    public void setLayoutParams(ViewGroup.LayoutParams params) {
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = (int) getResources().getDimension(R.dimen.bottom_menu_size);
        super.setLayoutParams(params);
    }

    public void setMenus(MenuItem... items){
        if(mContainer==null)
            initializeView();

        for (int i=0;i<items.length;++i){
            addItemMenu(items[i]);
        }
    }

    private void initializeView() {
        LayoutInflater.from(getContext()).inflate(R.layout.container,this);

        mContainer = findViewById(R.id.rgContainer);
    }


    private void addItemMenu(MenuItem item) {
        View view = ItemView.createFrom(getContext(),item);
        view.setLayoutParams(generateLayoutParams(new LayoutParams(0,0,1)));
    }

}
