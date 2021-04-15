package com.simpla.randomfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.ArgbEvaluator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.transition.Fade;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIds();
    }

    private void findIds() {
        layout = findViewById(R.id.main_layout);
        button = findViewById(R.id.main_btn);
        setListeners();
    }

    private void setListeners() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity();
            }
        });
        handleBackground();
    }

    private void handleBackground() {
        AnimationDrawable animationDrawable = (AnimationDrawable) layout.getBackground();
       // animationDrawable.setOneShot(true);
        animationDrawable.start();

        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

        layout.setAnimation(animation);
        animation.start();
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }
            @Override
            public void onAnimationEnd(Animation animation) {
                Animation fadeOut = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_out);
                layout.startAnimation(fadeOut);
            }
            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        /*int colorFrom = R.drawable.background1;
        int colorTo = R.drawable.background2;
        int c3 = R.drawable.background3;
        int c4 = R.drawable.background4;
        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(),colorFrom, colorTo,c3,c4);
        colorAnimation.setDuration(5000); // milliseconds
        colorAnimation.setRepeatMode(ValueAnimator.RESTART);
        colorAnimation.setRepeatCount(ValueAnimator.INFINITE);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                Drawable d = getResources().getDrawable((int) animator.getAnimatedValue());
                layout.setBackground(d);

            }
        });
        colorAnimation.start();*/
    }
}