package com.pokemon.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Spinner;

/**
 * Created by Petri on 31.7.2017.
 */
public class PokedetailsActivity extends AppCompatActivity {

    private ImageView pokemonP;
    private Bundle extras;
    private TextView nameT;
    private TextView descT;
    private TextView stats;
    private Data data = new Data();
    private int pokeChoice;
    private RelativeLayout bg;
    private String type;
    private Spinner spinner;
    private String[] poke = {"1","2","3","4","5","6"};
    private int choice = 0;
    private Button add;
    private int members = 0;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        try {  setContentView(R.layout.pokedetails);  } catch (Error e) { System.out.println(e.toString()); }
        catch (Exception e) { System.out.println(e.toString()); }

        pokemonP = (ImageView) findViewById(R.id.pokedet);
        nameT = (TextView) findViewById(R.id.pokename);
        descT = (TextView) findViewById(R.id.textView4);
        stats = (TextView) findViewById(R.id.textView18);
        bg =  new RelativeLayout(this);
        bg = (RelativeLayout) findViewById(R.id.pokedexbg);
        spinner = (Spinner) findViewById(R.id.spinner);
        add = (Button) findViewById(R.id.button6);
        members = data.getTeammembers();

        extras = getIntent().getExtras();
        pokeChoice = extras.getInt("pokemon");

        System.out.println(pokeChoice);

        nameT.setText(data.getPokemons().get(pokeChoice).getName());
        stats.setText("Height = " + data.getPokemons().get(pokeChoice).getHeight() + "   Weight = "
                        + data.getPokemons().get(pokeChoice).getWeight());
        pokemonP.setImageResource(data.getPokemons().get(pokeChoice).getPic());
        descT.setText(data.getPokemons().get(pokeChoice).getDesc());
        type = data.getPokemons().get(pokeChoice).getType();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, poke);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapter2, View v,
                                       int position, long id) {
                if (position == 0) {
                    choice = 0;
                } else if (position == 1) {
                    choice = 1;
                } else if (position == 2) {
                    choice = 2;
                } else if (position == 3) {
                    choice = 3;
                } else if (position == 4) {
                    choice = 4;
                } else if (position == 5) {
                    choice = 5;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if(choice < members){
                data.updateTeam(choice,data.getPokemons().get(pokeChoice)); }
            }
        });

      //  backg();
    }

    private void backg(){
        if(type == "fire" || type == "dragon" || type == "psychic"){
            try {   bg.setBackgroundResource(R.drawable.firebg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "water"){
            try {   bg.setBackgroundResource(R.drawable.waterbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "ground"){
            try { bg.setBackgroundResource(R.drawable.groundbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
        else if(type == "electric" || type == "bug" || type == "normal"){
            try { bg.setBackgroundResource(R.drawable.normalbg);  } catch (Error e) { System.out.println(e.toString()); }
        }
    }
}
