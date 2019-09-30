package com.demoandroid.news.ui.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;


/**
 *
 */
public class AppFontBoldTextView extends AppCompatTextView {

    public AppFontBoldTextView(Context context) {
        super(context);
        setTypeFace(context);
    }

    public AppFontBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypeFace(context);
    }

    public AppFontBoldTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setTypeFace(context);
    }

    private void setTypeFace(Context context) {
        Typeface typeface = FontCache.getTypeface("Nunito-Bold.ttf", context);
        setTypeface(typeface);
    }
}
