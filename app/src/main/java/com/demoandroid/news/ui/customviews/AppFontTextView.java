package com.demoandroid.news.ui.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


/**
 *
 */
public class AppFontTextView extends AppCompatTextView {

    public AppFontTextView(Context context) {
        super(context);
        setTypeFace(context);
    }

    public AppFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    public AppFontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context) {
        Typeface typeface = FontCache.getTypeface("Nunito-Regular.ttf", context);
        setTypeface(typeface);
    }
}
