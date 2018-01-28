package com.pokemon.pokemon;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.media.MediaPlayer;

/**
 * Created by Petri on 2.8.2017.
 */
public class BattleActivity extends AppCompatActivity {

    private ImageView pokemon1;
    private ImageView pokemon2;
    private ImageView effect;
    private TextView pokemonLeft;
    private TextView text;
    private Button move1;
    private Button move2;
    private ProgressBar prog1;
    private ProgressBar prog2;
    private Bundle extras;
    private int leader = 0;
    private Data data = new Data();
    private Gym gym;
    private Pokemon[] gpokemons = new Pokemon[3];
    private Pokemon[] ppokemons = new Pokemon[6];
    private ImageButton gymP;
    private int myPoke = 0;
    private int gymPoke = 0;
    private int php;
    private int ghp;
    private static Random randomGenerator = new Random();
    private int ran;
    private boolean battleEnded = false;
    private int teammembers;
    private boolean defeat = false;
    private boolean over = false;
    private MediaPlayer music;
    private MediaPlayer attack;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try { setContentView(R.layout.battle); } catch(Exception e)  { System.out.println(e.toString()); }  catch (Error e) { System.out.println(e.toString()); }

        pokemon1 = (ImageView) findViewById(R.id.imageView31);
        pokemon2 = (ImageView) findViewById(R.id.imageView30);
        effect = (ImageView) findViewById(R.id.imageView33);
        text = (TextView) findViewById(R.id.textView15);
        pokemonLeft = (TextView) findViewById(R.id.textView16);
        move1 = (Button) findViewById(R.id.button3);
        move2 = (Button) findViewById(R.id.button5);
        prog1 = (ProgressBar) findViewById(R.id.progressBar2);
        prog2 = (ProgressBar) findViewById(R.id.progressBar3);
        gymP = (ImageButton) findViewById(R.id.imageView32);

        extras = getIntent().getExtras();
        leader = extras.getInt("pokemon");
        gym = data.getGyms().get(leader);
        gpokemons = gym.getPokemons();
        ppokemons = data.getTeam();
        php = ppokemons[gymPoke].getHP();
        ghp = ppokemons[gymPoke].getHP();
        teammembers = data.getTeammembers();
        music = MediaPlayer.create(BattleActivity.this, R.raw.battle);
        music.setLooping(true);
        music.start();
        attack = MediaPlayer.create(BattleActivity.this, R.raw.pistol);

        pokemon1.setImageResource(ppokemons[myPoke].getPic());
        System.out.println(gpokemons[gymPoke].getName());
        pokemon2.setImageResource(gpokemons[gymPoke].getPic());
        text.setText(gym.getIntro());
        gymP.setImageResource(gym.getPic());
        prog1.setMax(php);
        prog1.setScaleY(4f);
        prog1.setProgress(php);
        prog1.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        prog2.setMax(ghp);
        prog2.setProgress(ghp);
        prog2.setScaleY(4f);
        prog2.getProgressDrawable().setColorFilter(Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);
        move1.setText(ppokemons[myPoke].getAttack1N());
        move2.setText(ppokemons[myPoke].getAttack2N());
        pokemon1.setVisibility(View.INVISIBLE);
        pokemon2.setVisibility(View.INVISIBLE);
        prog1.setVisibility(View.INVISIBLE);
        prog2.setVisibility(View.INVISIBLE);
        pokemonLeft.setVisibility(View.INVISIBLE);
        move1.setVisibility(View.INVISIBLE);
        move2.setVisibility(View.INVISIBLE);
        effect.setVisibility(View.INVISIBLE);
        colors();

        gymP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(battleEnded){
                    music.stop();
                    music.release();
                    System.out.println("Ottelu on loppunut");
                    try {
                        Intent returnIntent = new Intent();
                        returnIntent.putExtra("result", "-2");
                        setResult(Activity.RESULT_OK, returnIntent);
                        finish();  } catch(Exception e)  { System.out.println(e.toString()); }  catch (Error e) { System.out.println(e.toString()); }
                }
                else {
                    text.setText("What will you do ?");
                    pokemon1.setVisibility(View.VISIBLE);
                    pokemon2.setVisibility(View.VISIBLE);
                    prog1.setVisibility(View.VISIBLE);
                    prog2.setVisibility(View.VISIBLE);
                    pokemonLeft.setVisibility(View.VISIBLE);
                    move1.setVisibility(View.VISIBLE);
                    move2.setVisibility(View.VISIBLE);
                    gymP.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Moves

        move1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(1);
            }
        });
        move2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                move(2);
            }
        });
    }

    private void move(int i){
        ran =  randomGenerator.nextInt(100);
        attack.start();

        if(i == 1){
            text.setText(ppokemons[myPoke].getName() + " uses " + ppokemons[myPoke].getAttack1N());
            if (ppokemons[myPoke].getAttack1A() >= ran) {
                ghp -= ppokemons[myPoke].getAttack1() * effective(1,true);
                effect.setVisibility(View.VISIBLE);
                prog2.setProgress(ghp);
                if(ghp <= 0){
                    defeat = true;
                }
            }
            else {
                text.setText("The attack misses.");
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    effect.setVisibility(View.INVISIBLE);
                    if(defeat) { over = gymChange(); defeat = false;  }
                    if(!over) { opponent(); }
                }
            }, 2000);
        }

        else {
            text.setText(ppokemons[myPoke].getName() + " uses " + ppokemons[myPoke].getAttack2N());
            if (ppokemons[myPoke].getAttack2A() >= ran) {
                effect.setVisibility(View.VISIBLE);
                ghp -= ppokemons[myPoke].getAttack2()* effective(2,true);
                prog2.setProgress(ghp);
                if(ghp <= 0){
                    defeat = true;
                }
            }
            else {
                text.setText("The attack misses.");
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    effect.setVisibility(View.INVISIBLE);
                    if(defeat) { over =  gymChange(); defeat = false;  }
                    if(!over) { opponent(); }
                }
            }, 2000);
        }
    }

    private void omove(int i){
        ran =  randomGenerator.nextInt(100);
        attack.start();

        if(i == 1){
            text.setText("The foe's " + gpokemons[gymPoke].getName() + " uses " + gpokemons[gymPoke].getAttack1N());
            if (gpokemons[gymPoke].getAttack1A() >= ran) {
                effect.setVisibility(View.VISIBLE);
                php -= gpokemons[gymPoke].getAttack1() * effective(1,false);
                prog1.setProgress(php);
                if(php <= 0){
                    defeat = true;
                }
            }
            else {
                text.setText("The attack misses.");
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    effect.setVisibility(View.INVISIBLE);
                    if(defeat) { over = playerChange(); defeat = false;  }
                    if(!over) { player(); }
                }
            }, 2000);
        }
        else {
            text.setText("The foe's " + gpokemons[gymPoke].getName() + " uses " + gpokemons[gymPoke].getAttack2N());
            if (gpokemons[gymPoke].getAttack2A() >= ran) {
                effect.setVisibility(View.VISIBLE);
                php -= gpokemons[gymPoke].getAttack2()* effective(2,false);
                prog1.setProgress(php);
                if(php <= 0){
                    defeat = true;
                }
            }
            else {
                text.setText("The attack misses.");
            }

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    effect.setVisibility(View.INVISIBLE);
                    if(defeat) { over = playerChange(); defeat = false;  }
                    if(!over) { player(); }
                }
            }, 2000);
        }
    }

    private boolean playerChange(){
        System.out.println("Pokemoneja tällä hetkellä " + teammembers);
        if(teammembers == 1){
            defeat();
            return true;
        }
        ++myPoke;
        --teammembers;
        php = ppokemons[myPoke].getHP();
        prog1.setMax(php); prog1.setProgress(php);
        pokemon1.setImageResource(ppokemons[myPoke].getPic());
        move1.setText(ppokemons[myPoke].getAttack1N());
        move2.setText(ppokemons[myPoke].getAttack2N());
        colors();
        return false;
    }
    private boolean gymChange(){
        if(gymPoke == 2){
            victory();
            return true;
        }
        ++gymPoke;
        pokemonLeft.setText("x " + String.valueOf(3-gymPoke));
        ghp = gpokemons[gymPoke].getHP();
        prog2.setMax(ghp); prog2.setProgress(ghp);
        pokemon2.setImageResource(gpokemons[gymPoke].getPic());
        return false;
    }

    private void player(){
        move1.setClickable(true);
        move2.setClickable(true);
        text.setText("What are you going to do ?");
    }

    private void opponent(){
        move1.setClickable(false);
        move2.setClickable(false);

        ran = randomGenerator.nextInt(3);
        if(ran < 3){
            omove(1);
        }
        else {
            omove(2);
        }
    }

    private void defeat(){

        pokemon1.setVisibility(View.INVISIBLE);
        pokemon2.setVisibility(View.INVISIBLE);
        prog1.setVisibility(View.INVISIBLE);
        prog2.setVisibility(View.INVISIBLE);
        pokemonLeft.setVisibility(View.INVISIBLE);
        move1.setVisibility(View.INVISIBLE);
        move2.setVisibility(View.INVISIBLE);
        gymP.setVisibility(View.VISIBLE);
        battleEnded = true;
        text.setText("I guess you are not strong enough.");
    }

    private void victory(){
        pokemon1.setVisibility(View.INVISIBLE);
        pokemon2.setVisibility(View.INVISIBLE);
        prog1.setVisibility(View.INVISIBLE);
        prog2.setVisibility(View.INVISIBLE);
        pokemonLeft.setVisibility(View.INVISIBLE);
        move1.setVisibility(View.INVISIBLE);
        move2.setVisibility(View.INVISIBLE);
        gymP.setVisibility(View.VISIBLE);
        battleEnded = true;
        data.addBadge();
        text.setText("Wow ! You're amazing.");
    }

    private void colors(){
        if(ppokemons[myPoke].getAttack1T() == "electric"){
            move1.setBackgroundColor(Color.YELLOW);
            move1.setTextColor(Color.BLACK);
        }
        else if(ppokemons[myPoke].getAttack1T() == "fire"){
            move1.setBackgroundColor(Color.RED);
            move1.setTextColor(Color.WHITE);
        }
        else if(ppokemons[myPoke].getAttack1T() == "grass" || ppokemons[myPoke].getAttack1T() == "ground" || ppokemons[myPoke].getAttack1T() == "bug"){
            move1.setBackgroundColor(Color.GREEN);
            move1.setTextColor(Color.WHITE);
        }
        else if(ppokemons[myPoke].getAttack1T() == "water" || ppokemons[myPoke].getAttack1T() == "dragon"){
            move1.setBackgroundColor(Color.BLUE);
            move1.setTextColor(Color.WHITE);
        }
		else if(ppokemons[myPoke].getAttack1T() == "psychic" || ppokemons[myPoke].getAttack1T() == "ghost" || ppokemons[myPoke].getAttack1T() == "ghost"){
            move1.setBackgroundColor(Color.MAGENTA);
            move1.setTextColor(Color.WHITE);
        }
        else if(ppokemons[myPoke].getAttack1T() == "normal" || ppokemons[myPoke].getAttack1T() == "flying" ){
            move1.setBackgroundColor(Color.WHITE);
            move1.setTextColor(Color.BLACK);
        }
		else if(ppokemons[myPoke].getAttack1T() == "fighting" || ppokemons[myPoke].getAttack2T() == "rock"){
            move1.setBackgroundColor(Color.RED);
            move1.setTextColor(Color.WHITE);
        }
		else if(ppokemons[myPoke].getAttack1T() == "steel"){
            move1.setBackgroundColor(Color.GRAY);
            move1.setTextColor(Color.BLACK);
        }
		
        if(ppokemons[myPoke].getAttack2T() == "electric"){
            move2.setBackgroundColor(Color.YELLOW);
            move2.setTextColor(Color.BLACK);
        }
        else if(ppokemons[myPoke].getAttack2T() == "fire"){
            move2.setBackgroundColor(Color.RED);
            move2.setTextColor(Color.WHITE);
        } 
		else if(ppokemons[myPoke].getAttack2T() == "steel"){
            move2.setBackgroundColor(Color.GRAY);
            move2.setTextColor(Color.BLACK);
        }
        else if(ppokemons[myPoke].getAttack2T() == "grass" && ppokemons[myPoke].getAttack2T() == "ground" && ppokemons[myPoke].getAttack2T() == "bug"){
            move2.setBackgroundColor(Color.GREEN);
            move2.setTextColor(Color.WHITE);
        }
        else if(ppokemons[myPoke].getAttack2T() == "water"|| ppokemons[myPoke].getAttack2T() == "dragon"){
            move2.setBackgroundColor(Color.BLUE);
            move2.setTextColor(Color.WHITE);
        }
		else if(ppokemons[myPoke].getAttack2T() == "psychic" || ppokemons[myPoke].getAttack2T() == "ghost" || ppokemons[myPoke].getAttack2T() == "poison"){
            move2.setBackgroundColor(Color.MAGENTA);
            move2.setTextColor(Color.WHITE);
        }
        else if(ppokemons[myPoke].getAttack2T() == "normal" || ppokemons[myPoke].getAttack2T() == "flying"){
            move2.setBackgroundColor(Color.WHITE);
            move2.setTextColor(Color.BLACK);
        }
		else if(ppokemons[myPoke].getAttack2T() == "fighting" || ppokemons[myPoke].getAttack2T() == "rock"){
            move2.setBackgroundColor(Color.RED);
            move2.setTextColor(Color.WHITE);
        }
    }

    private int effective(int move, boolean player){
        String aType;
        String pType;
        if(player) {
            if (move == 1) {
                aType = ppokemons[myPoke].getAttack1T();
            } else {
                aType = ppokemons[myPoke].getAttack2T();
            }
            pType = gpokemons[gymPoke].getType();
        }
        else {
            if (move == 1) {
                aType = gpokemons[gymPoke].getAttack1T();
            } else {
                aType = gpokemons[gymPoke].getAttack2T();
            }
            pType = ppokemons[myPoke].getType();
        }

        if (aType == "fire" && (pType == "grass" || pType == "bug" || pType == "ice")) {
            return 2;
        }
        if (aType == "water" && (pType == "fire" || pType == "ground")) {
            return 2;
        }
        if(aType == "grass" && (pType == "water" || pType == "ground" || pType == "rock")){
            return 2;
        }
        if(aType == "electric" && (pType == "water"|| pType == "flying")){
            return 2;
        }
		if(aType == "flying" && (pType == "grass" || pType == "ground" || pType == "fighting") ){
            return 2;
        }
		if(aType == "normal" && pType == "ghost"){
			return 0;
		}
        if(aType == "electric" && pType == "ground"){
            return 0;
        }
		if(aType == "ground" && pType == "flying"){
            return 0;
        }
		if(aType == "fighting" && pType == "ghost"){
			return 0;
		}
		if(aType == "fighting" && (pType == "normal" || pType == "ice")){
			return 2;
		} 
		if(aType == "poison" && pType == "grass"){
			return 2;
		} 
		if(aType == "flying" && (pType == "grass" || pType == "fighting" || pType == "bug")){
			return 2;
		}
		if(aType == "bug" && (pType == "grass" || pType == "psychic")){
			return 2;
		}
		if(aType == "psychic" && (pType == "fighting" || pType == "poison")){
			return 2;
		}
		if(aType == "ghost" && (pType == "psychic" || pType == "ghost")){
			return 2;
		}
		if(aType == "dragon" && pType == "dragon"){
			return 2;
		}
		if(aType == "rock" && (pType == "bug" || pType == "fire" || pType == "flying" || pType == "ice")){
			return 2;
		}
        return 1;
    }
}
