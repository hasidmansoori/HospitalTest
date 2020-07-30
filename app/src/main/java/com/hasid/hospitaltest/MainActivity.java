package com.hasid.hospitaltest;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

public class MainActivity extends AppCompatActivity {
    MeowBottomNavigation bottomNavigation;
    TextView textDashboard,textSetting,textProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigation = findViewById(R.id.bottomNavigation);
        textDashboard=findViewById(R.id.textDashboard);
        textSetting=findViewById(R.id.textSetting);
        textProfile=findViewById(R.id.textProfile);
        bottomNavigation.add(new MeowBottomNavigation.Model(1, R.drawable.dashboardimg));
        bottomNavigation.add(new MeowBottomNavigation.Model(2, R.drawable.settingimg));
        bottomNavigation.add(new MeowBottomNavigation.Model(3, R.drawable.profileimg));
       bottomNavigation.show(2,true);

        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                model=model;
                if (model.getId()==1){
                    textDashboard.setVisibility(View.GONE);
                    textSetting.setVisibility(View.VISIBLE);
                    textProfile.setVisibility(View.VISIBLE);

                }else if (model.getId()==2){
                    textDashboard.setVisibility(View.VISIBLE);
                    textSetting.setVisibility(View.GONE);
                    textProfile.setVisibility(View.VISIBLE);

                }if (model.getId()==3){
                    textDashboard.setVisibility(View.VISIBLE);
                    textSetting.setVisibility(View.VISIBLE);
                    textProfile.setVisibility(View.GONE);

                }
                return null;
            }
        });
    }
}