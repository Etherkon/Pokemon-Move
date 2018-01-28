package com.pokemon.pokemon;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Petri on 2.8.2017.
 */
public class Gym {

    private String name;
    private Pokemon[] pokemons = new Pokemon[3];
    private int pic;
    private LatLng location;
    private String intro;

    public void setName(String value) { name = value; }
    public String getName() { return name; }
    public void addPokemons(int i, Pokemon poke){
        pokemons[i] = poke;
    }

    public Pokemon[] getPokemons() { return pokemons; }
    public void addPic(int value) { pic = value;}
    public int getPic() { return pic; }
    public void setLocation(LatLng loc) { location = loc; }
    public LatLng getLocation() { return location; }
    public void setIntro(String value) { intro = value;
    }
    public String getIntro() { return intro; }
}
