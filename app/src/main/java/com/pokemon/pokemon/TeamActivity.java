package com.pokemon.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Petri on 2.8.2017.
 */
public class TeamActivity extends AppCompatActivity {

    private ImageButton poke1;
    private ImageButton poke2;
    private ImageButton poke3;
    private ImageButton poke4;
    private ImageButton poke5;
    private ImageButton poke6;
    private TextView poke1t;
    private TextView poke2t;
    private TextView poke3t;
    private TextView poke4t;
    private TextView poke5t;
    private TextView poke6t;
    private ImageButton[] pokes = new ImageButton[6];
    private TextView[] pokesT = new TextView[6];

    private Data data = new Data();
    private Pokemon team[] = new Pokemon[6];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team);

        poke1 = (ImageButton) findViewById(R.id.imageView24);  pokes[0] = poke1;
        poke2 = (ImageButton) findViewById(R.id.imageView25);  pokes[1] = poke2;
        poke3 = (ImageButton) findViewById(R.id.imageView26); pokes[2] = poke3;
        poke4 = (ImageButton) findViewById(R.id.imageView27); pokes[3] = poke4;
        poke5 = (ImageButton) findViewById(R.id.imageView28); pokes[4] = poke5;
        poke6 = (ImageButton) findViewById(R.id.imageView29); pokes[5] = poke6;
        poke1t = (TextView) findViewById(R.id.textView5); pokesT[0] = poke1t;
        poke2t = (TextView) findViewById(R.id.textView6); pokesT[1] = poke2t;
        poke3t = (TextView) findViewById(R.id.textView7); pokesT[2] = poke3t;
        poke4t = (TextView) findViewById(R.id.textView8); pokesT[3] = poke4t;
        poke5t = (TextView) findViewById(R.id.textView9); pokesT[4] = poke5t;
        poke6t = (TextView) findViewById(R.id.textView10); pokesT[5] = poke6t;

        for(int i = 0; i < pokes.length; ++i){
            pokes[i].setVisibility(View.INVISIBLE);
            pokesT[i].setVisibility(View.INVISIBLE);
        }

        team = data.getTeam();

        for(int j = 0; j < 6; ++j){
            if(team[j] != null){
                pokes[j].setImageResource(team[j].getPic());
                pokes[j].setVisibility(View.VISIBLE);
                pokesT[j].setText(team[j].getName());
                pokesT[j].setVisibility(View.VISIBLE);
            }
        }
        buttons();
    }

    private void buttons() {
        poke1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 0);
                startActivity(intent);
            }
        });
        poke2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 1);
                startActivity(intent);
            }
        });
        poke3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 2);
                startActivity(intent);
            }
        });
        poke4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 3);
                startActivity(intent);
            }
        });
        poke5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 4);
                startActivity(intent);
            }
        });
        poke6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(TeamActivity.this, TeamdetailsActivity.class);
                intent.putExtra("pokemon", 5);
                startActivity(intent);
            }
        });
    }
}
