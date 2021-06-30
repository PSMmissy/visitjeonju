package com.example.visit;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    LinearLayout layout;
    HorizontalScrollView scrollView;
    boolean isInit;
    boolean isInit2;
    LinearLayout layout2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        isInit = true;
        isInit2 = true;
        layout=findViewById(R.id.scroll_layout);
        scrollView = findViewById(R.id.scrollview);
        layout2 = findViewById(R.id.lin_layout);
        scrollView.setOnTouchListener(new OnTouch());

    }

    public void scmx(View v) {
        int scrollx = (scrollView.getWidth() + (int) dpToPx(this, 3)) / 3;
        scrollView.smoothScrollBy(-scrollx,0);
    }
    public void scrx(View v) {
        int scrollx = (scrollView.getWidth() +  (int) dpToPx(this, 3)) / 3;
        scrollView.smoothScrollBy(scrollx,0);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (isInit2){
            isInit2 = false;
            int btn = (layout2.getWidth() - (int) dpToPx(this, 1)) / 4;
            Log.e("btn","layout" + layout2.getWidth() + " " + "btn " + btn);

            for (int j = 0; j <7; j++){
                if(j % 2 == 0){
                    Button butt = new Button(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(btn, LinearLayout.LayoutParams.MATCH_PARENT);
                    butt.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                    butt.setPadding(0,0,0,0);
                    if(j == 0){
                        butt.setText("홈");
                        butt.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.button,0,0);
                    }
                    else if ( j == 2 ){
                        butt.setText("이전");
                        butt.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.layback,0,0);
                    }
                    else if (j==4){
                        butt.setText("다음");
                        butt.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.laynext,0,0);
                    }
                    else{
                        butt.setText("설정");
                        butt.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.sett,0,0);
                    }
                    params.setMargins(0, 0, 0, 0);
                    butt.setTextColor(Color.parseColor("#a9a9a9"));
                    butt.setLayoutParams(params);
                    butt.setBackground(null);
                    layout2.addView(butt);
                }
                else{
                    View bar = new View(this);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams((int) dpToPx(this, 1), LinearLayout.LayoutParams.MATCH_PARENT);
                    params.setMargins(0, 0, 0, 0);
                    bar.setBackgroundResource(R.drawable.block_white);
                    bar.setLayoutParams(params);
                    layout2.addView(bar);

                }
            }
        }


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
                        button.setText("MY여행계획");
                    }
                    else{
                        button.setText("전주신기루");
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

    private class OnTouch implements ScrollView.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }

    }



}
