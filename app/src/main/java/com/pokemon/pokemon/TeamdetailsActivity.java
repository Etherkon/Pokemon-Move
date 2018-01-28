package com.pokemon.pokemon;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Petri on 2.8.2017.
 */
public class TeamdetailsActivity  extends AppCompatActivity {

    private ImageView pokemonP;
    private Bundle extras;
    private TextView hp;
    private TextView attack1;
    private TextView attack1A;
    private TextView attack2;
    private TextView attack2A;
    private Data data = new Data();
    private Pokemon[] team = new Pokemon[6];
    private int pokeChoice;
    private RelativeLayout bg;
    private String type;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.teamdetails);
        } catch (Error e) {
            System.out.println(e.toString());
        }catch (Exception e) { System.out.println(e.toString()); }

        pokemonP = (ImageView) findViewById(R.id.teamdet);
        hp = (TextView) findViewById(R.id.hp);
        attack1 = (TextView) findViewById(R.id.textView11);
        attack1A = (TextView) findViewById(R.id.textView12);
        attack2 = (TextView) findViewById(R.id.textView13);
        attack2A = (TextView) findViewById(R.id.textView14);
        team = data.getTeam();
        bg =  new RelativeLayout(this);
        bg = (RelativeLayout) findViewById(R.id.teambg);

        extras = getIntent().getExtras();
        pokeChoice = extras.getInt("pokemon");

        System.out.println(pokeChoice + " " + team[pokeChoice].getAttack1());

        pokemonP.setImageResource(team[pokeChoice].getPic());
        attack1.setText(team[pokeChoice].getAttack1N());
        attack2.setText(team[pokeChoice].getAttack2N());
        attack1A.setText(String.valueOf(team[pokeChoice].getAttack1()));
        attack2A.setText(String.valueOf(team[pokeChoice].getAttack2()));
        hp.setText(String.valueOf(team[pokeChoice].getHP())+ " HP");
        type = team[pokeChoice].getType();

        colors();
    //    backg();
    }

    private void colors(){
        if(team[pokeChoice].getAttack1T() == "electric"){
            attack1.setTextColor(Color.YELLOW);
        }
        else if(team[pokeChoice].getAttack1T() == "fire"){
            attack1.setTextColor(Color.RED);
        }
        else if(team[pokeChoice].getAttack1T() == "grass" || team[pokeChoice].getAttack1T() == "ground" || team[pokeChoice].getAttack1T() == "bug"){
            attack1.setTextColor(Color.GREEN);
        }
        else if(team[pokeChoice].getAttack1T() == "water" || team[pokeChoice].getAttack1T() == "dragon"){
            attack1.setTextColor(Color.BLUE);
        }
		else if(team[pokeChoice].getAttack1T() == "psychic" || team[pokeChoice].getAttack1T() == "ghost" || team[pokeChoice].getAttack1T() == "poison"){
			   attack1.setTextColor(Color.MAGENTA);
        } 
		else if(team[pokeChoice].getAttack1T() == "fighting" || team[pokeChoice].getAttack1T() == "rock"){
			   attack1.setTextColor(Color.RED);
        } 
		else if(team[pokeChoice].getAttack1T() == "steel"){
            attack1.setBackgroundColor(Color.GRAY);
		}

        if(team[pokeChoice].getAttack2T() == "electric"){
            attack2.setTextColor(Color.YELLOW);
        }
        else if(team[pokeChoice].getAttack2T() == "fire"){
            attack2.setTextColor(Color.RED);
        }
        else if(team[pokeChoice].getAttack2T() == "grass" || team[pokeChoice].getAttack2T() == "ground" || team[pokeChoice].getAttack2T() == "bug"){
            attack2.setTextColor(Color.GREEN);
        }
        else if(team[pokeChoice].getAttack2T() == "water" || team[pokeChoice].getAttack2T() == "dragon"){
            attack2.setTextColor(Color.BLUE);
        }
		else if(team[pokeChoice].getAttack2T() == "psychic" || team[pokeChoice].getAttack2T() == "ghost" || team[pokeChoice].getAttack1T() == "poison"){
			attack2.setTextColor(Color.MAGENTA);
        } 
		else if(team[pokeChoice].getAttack2T() == "fighting" || team[pokeChoice].getAttack2T() == "rock"){
			   attack1.setTextColor(Color.RED);
        } 
		else if(team[pokeChoice].getAttack2T() == "steel"){
            attack2.setBackgroundColor(Color.GRAY);
		}

    }

    private void backg(){

        if(type == "fire" || type == "dragon"){
            try {   bg.setBackgroundResource(R.drawable.firebg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "water"){
            try {   bg.setBackgroundResource(R.drawable.waterbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "ground"){
            try { bg.setBackgroundResource(R.drawable.groundbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "electric"){
            try { bg.setBackgroundResource(R.drawable.normalbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
    }


}
