package com.pokemon.pokemon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/**
 * Created by Petri on 27.8.2016.
 */
public class CameraActivity extends AppCompatActivity   {

    private Camera mCamera = null;
    private CameraView mCameraView = null;

    private ImageView pokemon;
    private TextView text;
    private Bundle extras;
    private int pic;
    private int rate;
    private int pokeChoice;
    private String name;
    private ImageButton ball;
    private String result;
    private Animation anim;
    private Data data = new Data();
    private MediaPlayer music;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        pokemon = (ImageView) findViewById(R.id.pokemon);
        text = (TextView) findViewById(R.id.poke);
        ball = (ImageButton) findViewById(R.id.imageButton);
        music = MediaPlayer.create(CameraActivity.this, R.raw.wild);
        music.setLooping(true);
        music.start();

        extras = getIntent().getExtras();
        pokeChoice = extras.getInt("pokemon");
        pic = data.getPokemons().get(pokeChoice).getPic();
        rate = data.getPokemons().get(pokeChoice).getRate();
        name = data.getPokemons().get(pokeChoice).getName();

      //  System.out.println(data.getPokemons().size());

        anim = new TranslateAnimation(0, 0, 0, -700);
        anim.setDuration(900);
        anim.setFillAfter(true);
        anim.setAnimationListener(new MyAnimationListener());

        try{

            mCamera = Camera.open();
        } catch (Exception e){
            Log.d("ERROR", "Failed to get camera: " + e.getMessage());
        }

        if (mCamera != null) {
            mCameraView = new CameraView(this, mCamera);
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.camera_view);
            camera_view.addView(mCameraView);
        }

        ImageButton imgClose = (ImageButton)findViewById(R.id.imgClose);
        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", "-1");
                setResult(Activity.RESULT_OK, returnIntent);
                music.stop();
                music.release();
                finish();
            }
        });

        ball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move();

            }
        });

        text.setText(name);
        pokemon.setImageResource(pic);
    }

    private void move(){
        ball.setClickable(false);
        ball.startAnimation(anim);
    }

    private class MyAnimationListener implements Animation.AnimationListener {

        @Override
        public void onAnimationEnd(Animation animation) {
            int win = randInt(0, 100);
            System.out.println(win + " " + rate );
            if(win > rate){
                ball.clearAnimation();
                ball.setVisibility(View.INVISIBLE);
                text.setText("Missed !");
                ends(false);
            }
            else {
                data.addExp(100-rate);
                pokemon.setVisibility(View.INVISIBLE);
                text.setText("Caught !");
                ends(true);
            }
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationStart(Animation animation) {
        }

    }

    public static int randInt(int min, int max) {

        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        return randomInt;
    }

    private void ends(boolean situation){

        if(situation){
            result = "1";
        }
        else {
            result = "-1";
        }

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent returnIntent = new Intent();
                returnIntent.putExtra("result", result);
                setResult(Activity.RESULT_OK, returnIntent);
                music.stop();
                music.release();
                finish();
            }
        }, 3000);

    }

}
