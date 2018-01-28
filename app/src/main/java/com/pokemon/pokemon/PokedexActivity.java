package com.pokemon.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Petri on 31.7.2017.
 */
public class PokedexActivity extends AppCompatActivity {

    private ImageButton poke1;
    private ImageButton poke2;
    private ImageButton poke3;
    private ImageButton poke4;
    private ImageButton poke5;
    private ImageButton poke6;
    private ImageButton poke7;
    private ImageButton poke8;
    private ImageButton poke9;
    private ImageButton poke10;
    private ImageButton poke11;
    private ImageButton poke12;
    private ImageButton poke13;
    private ImageButton poke14;
    private ImageButton poke15;
    private ImageButton poke16;
    private ImageButton poke17;
    private ImageButton poke18;
    private ImageButton poke19;
    private ImageButton poke20;
    private TextView caughtT;
    private ImageButton[] pokes = new ImageButton[20];

    private Data data = new Data();
    private int[] pokedex = new int[152];
    private int[] pokesToPokemon = new int[20];
    private List<Pokemon> pokemons;
    private int pokeCount = 0;
    private int pokemonFound = 0;
    private int choice = 0;

    protected void onCreate(Bundle savedInstanceState) {

        try {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokedex); } catch (Exception e) { System.out.println(e.toString()); }

        poke1 = (ImageButton) findViewById(R.id.imageView4); pokes[0] = poke1;
        poke2 = (ImageButton) findViewById(R.id.imageView5); pokes[1] = poke2;
        poke3 = (ImageButton) findViewById(R.id.imageView6); pokes[2] = poke3;
        poke4 = (ImageButton) findViewById(R.id.imageView7); pokes[3] = poke4;
        poke5 = (ImageButton) findViewById(R.id.imageView8); pokes[4] = poke5;
        poke6 = (ImageButton) findViewById(R.id.imageView9); pokes[5] = poke6;
        poke7 = (ImageButton) findViewById(R.id.imageView10); pokes[6] = poke7;
        poke8 = (ImageButton) findViewById(R.id.imageView11); pokes[7] = poke8;
        poke9 = (ImageButton) findViewById(R.id.imageView12); pokes[8] = poke9;
        poke10 = (ImageButton) findViewById(R.id.imageView13); pokes[9] = poke10;
        poke11 = (ImageButton) findViewById(R.id.imageView14); pokes[10] = poke11;
        poke12 = (ImageButton) findViewById(R.id.imageView15); pokes[11] = poke12;
        poke13 = (ImageButton) findViewById(R.id.imageView16); pokes[12] = poke13;
        poke14 = (ImageButton) findViewById(R.id.imageView17); pokes[13] = poke14;
        poke15 = (ImageButton) findViewById(R.id.imageView18); pokes[14] = poke15;
        poke16 = (ImageButton) findViewById(R.id.imageView19); pokes[15] = poke16;
        poke17 = (ImageButton) findViewById(R.id.imageView20); pokes[16] = poke17;
        poke18 = (ImageButton) findViewById(R.id.imageView21); pokes[17] = poke18;
        poke19 = (ImageButton) findViewById(R.id.imageView22); pokes[18] = poke19;
        poke20 = (ImageButton) findViewById(R.id.imageView23); pokes[19] = poke20;
        caughtT = (TextView) findViewById(R.id.textView2);

        pokedex = data.getPokedex();
        pokemons = data.getPokemons();
        System.out.println("Pokedexissa on " + data.getCaught());

        caughtT.setText("Caught = " + data.getCaught());

        for(int i = 0; i < pokes.length; ++i){
            pokes[i].setVisibility(View.INVISIBLE);
        }

        System.out.println("Pokedex, vaihe 1");

        for(int j = 1; j < 151; ++j){
            if(pokedex[j] != 0){
                pokemonFound = findPokemon(j);  // Pokedex -> Pokemons
                if(pokemonFound == -1) {continue;}
                  pokes[pokeCount].setImageResource(pokemons.get(pokemonFound).getPic());
                  pokes[pokeCount].setVisibility(View.VISIBLE);
                  pokesToPokemon[pokeCount] = pokemonFound;  // Buttons -> Pokemons
                  ++pokeCount;
                  if(pokeCount == 19){
                      break;
                 }
            }
        }

      //  check();

        System.out.println("Pokedex, vaihe 2");

        buttons();

        System.out.println("Pokedex, vaihe 3");
    }

    private void buttons(){
        poke1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[0]);
                startActivity(intent);
            }
        });
        poke2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[1]);
                startActivity(intent);
            }
        });
        poke3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[2]);
                startActivity(intent);
            }
        });
        poke4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[3]);
                startActivity(intent);
            }
        });
        poke5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[4]);
                startActivity(intent);
            }
        });
        poke6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[5]);
                startActivity(intent);
            }
        });
        poke7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[6]);
                startActivity(intent);
            }
        });
        poke8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[7]);
                startActivity(intent);
            }
        });
        poke9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[8]);
                startActivity(intent);
            }
        });
        poke10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[9]);
                startActivity(intent);
            }
        });
        poke11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[10]);
                startActivity(intent);
            }
        });
        poke12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[11]);
                startActivity(intent);
            }
        });
        poke13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[12]);
                startActivity(intent);
            }
        });
        poke14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[13]);
                startActivity(intent);
            }
        });
        poke15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[14]);
                startActivity(intent);
            }
        });
        poke16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[15]);
                startActivity(intent);
            }
        });
        poke17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[16]);
                startActivity(intent);
            }
        });
        poke18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[17]);
                startActivity(intent);
            }
        });
        poke19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[18]);
                startActivity(intent);
            }
        });
        poke20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(PokedexActivity.this, PokedetailsActivity.class);
                intent.putExtra("pokemon", pokesToPokemon[19]);
                startActivity(intent);
            }
        });
    }

    private void check(){
        for(int i = 0; i < 20; ++i){
            System.out.println(pokesToPokemon[i]);
        }
    }

    private int findPokemon(int pokeID){

        for(int i = 0; i < pokemons.size(); ++i){
            if(pokemons.get(i).getId() == pokeID){
                return i;
            }
        }
        return -1;
    }

}
