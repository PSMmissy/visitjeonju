package com.example.visit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    HorizontalScrollView scrollView;
    boolean isInit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        isInit = true;
        layout=findViewById(R.id.scroll_layout);
        scrollView = findViewById(R.id.scrollview);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);



        if (isInit) {
            isInit = false;
            int but = (scrollView.getWidth() - (int) dpToPx(this, 1)) / 3;
            int ba = (scrollView.getHeight()/3);
            Log.e("but", "layout " + scrollView.getWidth() + " " + "but " + but);


            for (int i = 0; i < 9; i++) {
                if (i % 2 == 0) {
                    Button button = new Button(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(but, LinearLayout.LayoutParams.MATCH_PARENT);
                    Typeface typeface = getResources().getFont(R.font.notosanscjkkr_medium);
                    button.setTypeface(typeface);
                    button.setTextSize(TypedValue.COMPLEX_UNIT_DIP,15);
                    button.setPadding(0,0,0,0);
                    if(i==0){
                        button.setText("전시/공연");
                    }
                    else if(i==2){
                        button.setText("체험놀이");
                    }
                    else if(i==4){
                        button.setText("예약관리자");
                    }
                    else if(i==6){
                        button.setText("일단");
                    }
                    else{
                        button.setText("아무거나");
                    }
                    params.setMargins(0, 0, 0, 0);
                    button.setTextColor(Color.parseColor("#ffffff"));
                    button.setLayoutParams(params);
                    button.setBackground(null);
                    layout.addView(button);

                } else {
                    View bar = new View(this);

                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) dpToPx(this, 1), LinearLayout.LayoutParams.MATCH_PARENT);
                    params.setMargins(0, ba, 0, ba);
                    bar.setBackgroundResource(R.drawable.block);
                    bar.setLayoutParams(params);
                    layout.addView(bar);
                }
            }
        }
    }

    public float dpToPx(Context context, float dp) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, dm);
    }
}
