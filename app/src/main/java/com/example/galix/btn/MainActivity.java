package com.example.galix.btn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    RelativeLayout ll;
    Button btn;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ll = new RelativeLayout(this);
        RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        setContentView(ll, llp);

        btn = new Button(this);
        btn.setText("Button");
        btn.setTextSize(30);
        LinearLayout.LayoutParams llp3 = new LinearLayout
                .LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ll.addView(btn, llp3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                count++;
                RelativeLayout.LayoutParams btnll = (RelativeLayout.LayoutParams) btn.getLayoutParams();

                switch (count){
                    case 0: btnll.removeRule(RelativeLayout.CENTER_IN_PARENT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_TOP);
                        break;
                    case 1: btnll.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        break;
                    case 2:
                            btnll.removeRule(RelativeLayout.ALIGN_PARENT_TOP);
                        btnll.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

                        break;
                    case 3: btnll.removeRule(RelativeLayout.ALIGN_PARENT_LEFT);
                            btnll.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                        break;
                    case 4:
                            btnll.removeRule(RelativeLayout.ALIGN_PARENT_RIGHT);
                            btnll.removeRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
                            btnll.addRule(RelativeLayout.CENTER_IN_PARENT);

                        break;
                    case 5:  Animation a = AnimationUtils.
                            loadAnimation(MainActivity.this, R.anim.anim);
                            btn.startAnimation(a);
                            count = 0;
                        break;
                }
                Log.d("new",""+count);
                btn.setLayoutParams(btnll);

            }
        });

    }

}
