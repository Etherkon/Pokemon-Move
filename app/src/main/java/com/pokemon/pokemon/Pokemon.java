package com.pokemon.pokemon;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Petri on 29.7.2017.
 */
public class Pokemon {

    private String name;
    private int pic;
    private LatLng location;
    private int rate;
    private int id;
    private String desc;
    private String type;
    private String weight;
    private String height;
    private int hp;
    private String attack1N;
    private int attack1;
    private int attack1A;
    private String attack1T;
    private String attack2N;
    private int attack2;
    private int attack2A;
    private String attack2T;

    public void setName(String pname) { name = pname; }
    public String getName() { return name; }
    public void setPic (int ppic) { pic = ppic; }
    public int getPic () { return pic; }
    public void setLocation(LatLng ploc) { location = null; location = ploc; }
    public LatLng getLocation () { return location; }
    public void setRate (int prate) { rate = prate; }
    public int getRate () { return rate; }
    public void setId(int value) { id = value; }
    public int getId() { return id; }
    public void setDesc(String text) { desc = text; }
    public String getDesc() { return desc; }
    public void setType(String tvalue) { type = tvalue; }
    public String getType() { return type; }
    public void setWeight(String value) { weight = value; }
    public String getWeight() { return weight; }
    public void setHeight(String value) { height = value; }
    public String getHeight() { return height; }
    public void setAttack1(String name, int attack, int accuracy, String type) { attack1N = name; attack1 = attack; attack1A = accuracy; attack1T = type;}
    public void setAttack2(String name, int attack, int accuracy, String type) { attack2N = name; attack2 = attack; attack2A = accuracy;  attack2T = type;}
    public String getAttack1N() { return attack1N; }
    public String getAttack2N() { return attack2N; }
    public String getAttack1T() { return attack1T; }
    public String getAttack2T() { return attack2T; }
    public int getAttack1() { return attack1; }
    public int getAttack2() { return attack2; }
    public int getAttack1A() { return attack1A; }
    public int getAttack2A() { return attack2A; }
    public int getHP() { return hp; }
    public void setHP(int value) { hp = value; }
}
