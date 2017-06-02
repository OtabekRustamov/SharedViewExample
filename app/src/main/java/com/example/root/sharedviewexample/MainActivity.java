package com.example.root.sharedviewexample;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton floatingActionButton;
    private FrameLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.fbMainActivity);
        linearLayout = (FrameLayout) findViewById(R.id.llAnimation);

        floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(2f, 230f);
        valueAnimator.setDuration(300);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float val = (float) animation.getAnimatedValue();

                float px = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, val,
                        getResources().getDisplayMetrics());

                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
                        (ViewGroup.LayoutParams.MATCH_PARENT, (int) px);
                layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
                linearLayout.setLayoutParams(layoutParams);
            }
        });

        valueAnimator.start();
    }


}
