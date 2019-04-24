package com.example.clickracer;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import static com.example.clickracer.R.id.scorul;
import static java.lang.Integer.parseInt;

public class DisplayMessageActivity extends AppCompatActivity {
    CountDownTimer cTimer=null;
    Button b;
    public int count;
   public TextView scor;
   public TextView timer;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        count =0;
        scor = (TextView) findViewById(R.id.scorul);

timer=(TextView) findViewById(R.id.timerul);
        //SixtySeconds();
        b = (Button) findViewById(R.id.click);
        cTimer=new CountDownTimer(11000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(""+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                timer.setText("Stop");

            }
        };
        cTimer.start();
}

public void ClickButton(View view){
        if((timer.getText().equals("Stop"))==false){
    scor.setText(ToString(count));
    count++;
        Animation animation = AnimationUtils.loadAnimation(DisplayMessageActivity.this, R.anim.zoomout);
        b.startAnimation(animation);

}}

    private String ToString(int count) {
        return ""+count;
    }


    }

