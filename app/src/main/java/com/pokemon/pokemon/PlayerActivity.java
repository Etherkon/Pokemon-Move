package com.pokemon.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Petri on 30.7.2017.
 */
public class PlayerActivity extends AppCompatActivity {

    private ImageButton settingsB;
    private ImageButton pokedexB;
    private Data data = new Data();
    private String name;
    private int level;
    private int exp;
    private int expcap = 50;
    private int progress;
    private int target;
    private ProgressBar pbar;
    private TextView levelT;
    private TextView nameT;
    private TextView badges;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        settingsB = (ImageButton) findViewById(R.id.imageButton3);
        pokedexB = (ImageButton) findViewById(R.id.imageButton2);
        pbar = (ProgressBar) findViewById(R.id.progressBar);
        levelT = (TextView) findViewById(R.id.textView);
        badges = (TextView) findViewById(R.id.textView17);
        nameT = (TextView) findViewById(R.id.name);
        name = data.getPlayer();
        exp = data.getExp();
        level = data.getLevel();

        progress = exp - expcap * (level-1);
        target = expcap * (level + 0) - expcap * (level - 1);
        pbar.setMax(target);
        pbar.setProgress(progress);
        levelT.setText("Level " + level);
        badges.setText(String.valueOf(data.getBadges()) + " Badges");
        nameT.setText(name);

        settingsB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PlayerActivity.this, TeamActivity.class);
                startActivity(intent);
            }
        });
        pokedexB.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent(PlayerActivity.this, PokedexActivity.class);
                startActivity(intent);
            }
        });
    }
}
