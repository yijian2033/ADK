package com.adk.adk;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.adk.adk.util.PreferenceUtils;

import java.lang.reflect.InvocationTargetException;

public class SplashActivity extends AppCompatActivity {

    private ImageView mIvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mIvSplash = (ImageView) findViewById(R.id.iv_splash);

        try {
//            PackageInfo packageInfo = getPackageManager().getPackageInfo("com.adk.adk", 0);
//            int versionCode = packageInfo.versionCode;
//            int onTime = PreferenceUtils.getInt(getApplicationContext(), "OnTime", 0);
//            if (onTime >= versionCode) {
//                startActivity(new Intent(SplashActivity.this, MainActivity.class));
//                finish();
//                return;
//            }
//            PreferenceUtils.putInt(getApplicationContext(), "OnTime", versionCode);
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1f);
            alphaAnimation.setDuration(3000);

            mIvSplash.startAnimation(alphaAnimation);
            alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
