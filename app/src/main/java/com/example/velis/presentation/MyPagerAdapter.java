package com.example.velis.presentation;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MyPagerAdapter extends PagerAdapter {

    private String text1, text2, text3;

    MyPagerAdapter(Context context) {
        super();
        text1 = context.getResources().getString(R.string.welcome_text);
        text2 = context.getResources().getString(R.string.presentation_text);
        text3 = context.getResources().getString(R.string.motivation_text);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return o == view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, int position) {

        TextView text = new Button(container.getContext());
        text.setTextAppearance(container.getContext(), R.style.textViewStyle);
        text.setAllCaps(false);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        text.setLayoutParams(params);

        if (position == 0) {

            text.setText(text1);
        } else if (position == 1) {
            text.setText(text2);
        } else {
            text.setText(text3);
        }
        container.addView(text);

        return text;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((Button) object);
    }
}

