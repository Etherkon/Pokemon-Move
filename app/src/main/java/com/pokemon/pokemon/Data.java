package com.pokemon.pokemon;


import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Petri on 29.7.2017.
 */
public class Data  {

    private static List <Pokemon> pokemons = new ArrayList<Pokemon>();
    private static List<Gym> gyms = new ArrayList <Gym>();
    private static Random randomGenerator = new Random();
    private static int pokedex[] = new int[152];
    private static Pokemon team[] = new Pokemon[6];

    private static int level = 1;
    private static String player = "Petri Mattila";
    private static int exp = 0;
    private static int caught = 0;
    private static int teammembers = 0;
    private static int badges = 0;
	
	private Pokemon pikachu;
	private Pokemon sandslash;
	private Pokemon squirtle;
	private Pokemon charmander;
	private Pokemon charizard;
	private Pokemon gengar;
	private Pokemon caterpie;
	private Pokemon mew;
	private Pokemon snorlax;
	private Pokemon eevee;
	private Pokemon lapras;
	private Pokemon gyarados;
	private Pokemon mewtwo;
	private Pokemon onix;
	private Pokemon magnemite;
	private Pokemon vulpix;
	private Pokemon dragonite;
	private Pokemon pidgey;
	private Pokemon arcanine;
	private Pokemon tentacruel;
	private Pokemon nidoking;
	private Pokemon alakazam;
	private Pokemon starmie;
	private Pokemon weezing;
	private Pokemon raichu;
	private Pokemon golem;
	private Pokemon rhydon;
	private Pokemon hypno;
	private Pokemon vileplume;
	private Pokemon victreebel;
	private Pokemon venusaur;
	private Pokemon magmar;
	private Pokemon ratata;

    // Martti = Lat 60.63106141312751   Long 24.89670110583815

    public void setPokemons(){

        pikachu = new Pokemon();
        pikachu.setName("Pikachu");
        pikachu.setPic(R.drawable.pikachu);
        pikachu.setLocation(new LatLng(60.6315, 24.8972));
        pikachu.setRate(100);
        pikachu.setId(24);
        pikachu.setType("electric");
        pikachu.setDesc("It keeps its tail raised to monitor its surroundings. If you yank its tail, it will try to bite you.");
        pikachu.setHP(35);
        pikachu.setHeight("0.4 m");
        pikachu.setWeight("6.0 kg");
		pikachu.setAttack1("Thunder Shock ",5,95,"electric");
        pikachu.setAttack2("Quick Attack", 8, 92,"normal");
        pokemons.add(pikachu);
		
		

        // ADDING POKEMONS ---------------------------------------------------------------------------------

        for(int i = 0; i < 400; ++i) {

            float lat = 0f + randomGenerator.nextFloat() * (180f - 0f) - 90f;
            float lon = 0f + randomGenerator.nextFloat() * (360f - 0f) - 180f;
            int choose = randomGenerator.nextInt(79);
            LatLng loc = new LatLng(lat, lon);

        //    System.out.println(choose);

            // 33 Pokemons
			// 8 Gyms
            // Common = 4, Uncommon = 3, Rare = 2, Legendary = 1
			// BB = 1/3 1/2    BS = 2/3 1/1   SS 3/3 2/2   

            if (choose < 5) {   // Common
                pikachu = new Pokemon();
                pikachu.setName("Pikachu");
                pikachu.setPic(R.drawable.pikachu);
                pikachu.setLocation(loc);
                pikachu.setRate(90);
                pikachu.setId(24);
                pikachu.setType("electric");
                pikachu.setDesc("It keeps its tail raised to monitor its surroundings. If you yank its tail, it will try to bite you.");
                pikachu.setHP(35);
                pikachu.setHeight("0.4 m");
                pikachu.setWeight("6.0 kg");
                pikachu.setAttack1("Thunder Shock ",5,95,"electric");
                pikachu.setAttack2("Quick Attack", 8, 92,"normal");
                pokemons.add(pikachu);
            } else if (choose >= 5 && choose < 8) {  // Uncommon
                sandslash = new Pokemon();
                sandslash.setName("Sandslash");
                sandslash.setPic(R.drawable.sandslash);
                sandslash.setRate(75);
                sandslash.setId(27);
                sandslash.setType("ground");
                sandslash.setDesc("It is skilled at slashing enemies with its claws. If broken, they start to grow back in a day.");
                sandslash.setHP(70);
                sandslash.setHeight("1.0 m");
                sandslash.setWeight("29.5 kg");
                sandslash.setAttack1("Bulldoze", 80, 30,"ground");
                sandslash.setAttack2("Earthquake",120,20,"ground");
                sandslash.setLocation(loc);
				pokemons.add(sandslash);
            } else if (choose >= 8 && choose < 11) {  // Uncommon
                squirtle = new Pokemon();
                squirtle.setName("Squirtle");
                squirtle.setPic(R.drawable.squirtle);
                squirtle.setRate(75);
                squirtle.setId(6);
                squirtle.setType("ground");
                squirtle.setDesc("Shoots water at prey while in the water. Withdraws into its shell when in danger.");
                squirtle.setHP(44);
                squirtle.setHeight("0.5 m");
                squirtle.setWeight("9.0 kg");
                squirtle.setAttack1("Tackle", 5, 95,"normal");
                squirtle.setAttack2("Bubble",12,88,"water");
                squirtle.setLocation(loc);
				pokemons.add(squirtle);
            } else if (choose >= 11 && choose < 14) {  // Uncommon
                charmander = new Pokemon();
                charmander.setName("Charmander");
                charmander.setPic(R.drawable.charmander);
                charmander.setRate(75);
                charmander.setId(3);
                charmander.setType("fire");
                charmander.setDesc("The flame at the tip of its tail makes a sound as it burns. You can only hear it in quiet places.");
                charmander.setHP(39);
                charmander.setHeight("0.6 m");
                charmander.setWeight("8.5 kg");
                charmander.setAttack1("Scratch", 6, 94,"normal");
                charmander.setAttack2("Ember",10,90,"fire");
                charmander.setLocation(loc);
				pokemons.add(charmander);
            } else if (choose >= 14 && choose < 16){  // Rare
                charizard = new Pokemon();
                charizard.setName("Charizard");
                charizard.setPic(R.drawable.charizard);
                charizard.setRate(20);
                charizard.setId(5);
                charizard.setType("fire");
                charizard.setDesc("When expelling a blast of super hot fire, the red flame at the tip of its tail burns more intensely.");
                charizard.setHP(78);
                charizard.setHeight("1.65 m");
                charizard.setWeight("81.92 kg");
                charizard.setAttack1("Fire Blast", 140,30,"fire");
                charizard.setAttack2("Overheat",160,20,"fire");
                charizard.setLocation(loc);
				pokemons.add(charizard);
            } else if (choose >= 16 && choose < 18){  // Rare
                gengar = new Pokemon();
                gengar.setName("Gengar");
                gengar.setPic(R.drawable.gengar);
                gengar.setRate(30);
                gengar.setId(93);
                gengar.setType("ghost");
                gengar.setDesc("A Gengar is close by if you feel a sudden chill. It may be trying to lay a curse on you.");
                gengar.setHP(60);
                gengar.setHeight("1.5 m");
                gengar.setWeight("40.5 kg");
                gengar.setAttack1("Sludge Bomb", 80, 30,"poison");
                gengar.setAttack2("Shadow Ball",100,20,"ghost");
                gengar.setLocation(loc);
				pokemons.add(gengar);
            } else if (choose >= 18 && choose < 22){  // Common
                caterpie = new Pokemon();
                caterpie.setName("Caterpie");
                caterpie.setPic(R.drawable.caterpie);
                caterpie.setRate(90);
                caterpie.setId(9);
                caterpie.setType("bug");
                caterpie.setDesc("If you touch the feeler on top of its head, it will release a horrible stink to protect itself.");
                caterpie.setHP(45);
                caterpie.setHeight("0.3 m");
                caterpie.setWeight("2.9 kg");
                caterpie.setAttack1("Bug Bite", 5, 95,"bug");
                caterpie.setAttack2("Tackle",5,95,"normal");
                caterpie.setLocation(loc);
				pokemons.add(caterpie);
            } else if (choose >= 22 && choose < 23){  // Legendary
                mew = new Pokemon();
                mew.setName("Mew");
                mew.setPic(R.drawable.mew);
                mew.setRate(5);
                mew.setId(151);
                mew.setType("psychic");
                mew.setDesc("So rare that it is still said to be a mirage by many experts. Only a few people have seen it worldwide.");
                mew.setHP(100);
                mew.setHeight("0.4 m");
                mew.setWeight("4.0 kg");
                mew.setAttack1("Confusion", 20, 80,"psychic");
                mew.setAttack2("Hyper Beam",150,20,"normal");
                mew.setLocation(loc);
				pokemons.add(mew);
            } else if (choose >= 23 && choose < 25){  // Rare
                snorlax = new Pokemon();
                snorlax.setName("Snorlax");
                snorlax.setPic(R.drawable.snorlax);
                snorlax.setRate(20);
                snorlax.setId(142);
                snorlax.setType("normal");
                snorlax.setDesc("Will eat anything, even if the food happens to be a little moldy. It never gets an upset stomach.");
                snorlax.setHP(160);
                snorlax.setHeight("2.1 m");
                snorlax.setWeight("460.0 kg");
                snorlax.setAttack1("Zen Headbutt", 12, 88,"psychic");
                snorlax.setAttack2("Hyper Beam",150,20,"normal");
                snorlax.setLocation(loc);
				pokemons.add(snorlax);
            } else if (choose >= 25 && choose < 28){  // Uncommon
                eevee = new Pokemon();
                eevee.setName("Eevee");
                eevee.setPic(R.drawable.eevee);
                eevee.setRate(60);
                eevee.setId(132);
                eevee.setType("normal");
                eevee.setDesc("Its genetic code is unstable, so it could evolve in a variety of ways. There are only a few alive.");
                eevee.setHP(55);
                eevee.setHeight("0.3 m");
                eevee.setWeight("6.5 kg");
                eevee.setAttack2("Quick Attack", 8, 92,"normal");
                eevee.setAttack1("Tackle",5,95,"normal");
                eevee.setLocation(loc);
				pokemons.add(eevee);
            } else if (choose >= 28 && choose < 30){  // Rare
                lapras = new Pokemon();
                lapras.setName("Lapras");
                lapras.setPic(R.drawable.lapras);
                lapras.setRate(30);
                lapras.setId(130);
                lapras.setType("water");
                lapras.setDesc("A gentle soul that can read the minds of people. It can ferry people across the sea on its back.");
                lapras.setHP(130);
                lapras.setHeight("2.5 m");
                lapras.setWeight("220.0 kg");
                lapras.setAttack1("Water Gun", 5, 95,"water");
                lapras.setAttack2("Hydro Pump",130,20,"water");
                lapras.setLocation(loc);
				pokemons.add(lapras);
            } else if (choose >= 30 && choose < 32){  // Rare
                gyarados = new Pokemon();
                gyarados.setName("Gyarados");
                gyarados.setPic(R.drawable.gyarados);
                gyarados.setRate(30);
                gyarados.setId(129);
                gyarados.setType("water");
                gyarados.setDesc("Brutally vicious and enormously destructive. Known for totally destroying cities in ancient times.");
                gyarados.setHP(95);
                gyarados.setHeight("6.5 m");
                gyarados.setWeight("235.0 kg");
                gyarados.setAttack1("Outrage", 110, 30,"dragon");
                gyarados.setAttack2("Hydro Pump",130, 20,"water");
                gyarados.setLocation(loc);
				pokemons.add(gyarados);
            } else if (choose >= 32 && choose < 33){  // Legendary
                mewtwo = new Pokemon();
                mewtwo.setName("Mewtwo");
                mewtwo.setPic(R.drawable.mewtwo);
                mewtwo.setRate(5);
                mewtwo.setId(149);
                mewtwo.setType("psychic");
                mewtwo.setDesc("It was created by a scientist after years of horrific gene splicing and DNA engineering experiments.");
                mewtwo.setHP(106);
                mewtwo.setHeight("2.0 m");
                mewtwo.setWeight("122.0 kg");
                mewtwo.setAttack1("Confusion", 20, 80,"psychic");
                mewtwo.setAttack2("Psychic",100,20,"psychic");
                mewtwo.setLocation(loc);
				pokemons.add(mewtwo);
            } else if (choose >= 33 && choose < 36){  // Uncommon
                onix = new Pokemon();
                onix.setName("Onix");
                onix.setPic(R.drawable.onix);
                onix.setRate(60);
                onix.setId(94);
                onix.setType("rock");
                onix.setDesc("Burrows at high speed in search of food. The tunnels it leaves are used as homes by Diglett.");
                onix.setHP(35);
                onix.setHeight("8.8 m");
                onix.setWeight("210.0 kg");
                onix.setAttack1("Tackle", 10, 90,"normal");
                onix.setAttack2("Stone Edge",100,20,"rock");
                onix.setLocation(loc);
				pokemons.add(onix);
            } else if (choose >= 36 && choose < 39){  // Uncommon
                magnemite = new Pokemon();
                magnemite.setName("Magnemite");
                magnemite.setPic(R.drawable.magnemite);
                magnemite.setRate(70);
                magnemite.setId(80);
                magnemite.setType("electric");
                magnemite.setDesc("It is born with the ability to defy gravity. It floats in air on powerful electromagnetic waves.");
                magnemite.setHP(25);
                magnemite.setHeight("0.3 m");
                magnemite.setWeight("6.0 kg");
                magnemite.setAttack1("Thunder Shock", 5, 95,"electric");
                magnemite.setAttack2("Spark",7,93,"electric");
                magnemite.setLocation(loc);
				pokemons.add(magnemite);
            } else if (choose >= 39 && choose < 42){  // Uncommon
                vulpix = new Pokemon();
                vulpix.setName("Vulpix");
                vulpix.setPic(R.drawable.vulpix);
                vulpix.setRate(60);
                vulpix.setId(36);
                vulpix.setType("fire");
                vulpix.setDesc("Both its fur and its tails are beautiful. As it grows, the tails split and form more tails.");
                vulpix.setHP(38);
                vulpix.setHeight("0.6 m");
                vulpix.setWeight("9.9 kg");
                vulpix.setAttack1("Quick Attack",9,92,"normal");
                vulpix.setAttack2("Ember", 10, 90,"fire");
                vulpix.setLocation(loc);
				pokemons.add(vulpix);
            } else if (choose >= 42 && choose < 44){  // Rare
                dragonite = new Pokemon();
                dragonite.setName("Dragonite");
                dragonite.setPic(R.drawable.dragonite);
                dragonite.setRate(10);
                dragonite.setId(148);
                dragonite.setType("dragon");
                dragonite.setDesc("It is said that this Pokémon lives somewhere in the sea and that it flies. However, it is only a rumor.");
                dragonite.setHP(91);
                dragonite.setHeight("2.2 m");
                dragonite.setWeight("210.0 kg");
                dragonite.setAttack1("Hurricane ", 110, 20,"flying");
                dragonite.setAttack2("Outrage",110,10,"dragon");
                dragonite.setLocation(loc);
				pokemons.add(dragonite);
            } else if (choose >= 44 && choose < 48){  // Common
                pidgey = new Pokemon();
                pidgey.setName("Pidgey");
                pidgey.setPic(R.drawable.pidgey);
                pidgey.setRate(90);
                pidgey.setId(15);
                pidgey.setType("normal");
                pidgey.setDesc("Very docile. If attacked, it will often kick up sand to protect itself rather than fight back.");
                pidgey.setHP(40);
                pidgey.setHeight("0.3 m");
                pidgey.setWeight("1.8 kg");
                pidgey.setAttack1("Tackle",5,95,"normal");
                pidgey.setAttack2("Quick Attack", 8, 92,"normal");
                pidgey.setLocation(loc);
				pokemons.add(pidgey);
            } else if (choose >= 48 && choose < 50){  // Rare
                arcanine = new Pokemon();
                arcanine.setName("Arcanine");
                arcanine.setPic(R.drawable.arcanine);
                arcanine.setRate(30);
                arcanine.setId(58);
                arcanine.setType("fire");
                arcanine.setDesc("A Pokémon that has been admired since the past for its beauty. It runs agilely as if on wings.");
                arcanine.setHP(90);
                arcanine.setHeight("1.9 m");
                arcanine.setWeight("155.0 kg");
                arcanine.setAttack1("Wild Charge",90,30,"electric");
                arcanine.setAttack2("Fire Blast", 140, 20,"fire");
                arcanine.setLocation(loc);
				pokemons.add(arcanine);
            } else if (choose >= 50 && choose < 52){  // Rare
                tentacruel = new Pokemon();
                tentacruel.setName("Tentacruel");
                tentacruel.setPic(R.drawable.tentacruel);
                tentacruel.setRate(40);
                tentacruel.setId(72);
                tentacruel.setType("water");
                tentacruel.setDesc("Its 80 tentacles can stretch and contract freely. They wrap around prey and weaken it with poison.");
                tentacruel.setHP(80);
                tentacruel.setHeight("1.6 m");
                tentacruel.setWeight("55.0 kg");
                tentacruel.setAttack1("Sludge Wave",110,30,"poison");
                tentacruel.setAttack2("Hydro Pump", 130, 20,"water");
                tentacruel.setLocation(loc);
				pokemons.add(tentacruel);
            } else if (choose >= 52 && choose < 54){  // Rare
                nidoking = new Pokemon();
                nidoking.setName("Nidoking");
                nidoking.setPic(R.drawable.nidoking);
                nidoking.setRate(30);
                nidoking.setId(33);
                nidoking.setType("poison");
                nidoking.setDesc("Its 80 tentacles can stretch and contract freely. They wrap around prey and weaken it with poison.");
                nidoking.setHP(81);
                nidoking.setHeight("1.4 m");
                nidoking.setWeight("62.0 kg");
                nidoking.setAttack1("Megahorn",90,30,"bug");
                nidoking.setAttack2("Earthquake", 120, 20,"ground");
                nidoking.setLocation(loc);
				pokemons.add(nidoking);
            } else if (choose >= 54 && choose < 56){  // Rare
                alakazam = new Pokemon();
                alakazam.setName("Alakazam");
                alakazam.setPic(R.drawable.alakazam);
                alakazam.setRate(20);
                alakazam.setId(64);
                alakazam.setType("psychic");
                alakazam.setDesc("A Pokémon that can memorize anything. It never forgets what it learns—that's why this Pokémon is smart.");
                alakazam.setHP(55);
                alakazam.setHeight("1.5 m");
                alakazam.setWeight("48.0 kg");
                alakazam.setAttack1("Shadow Ball",100,30,"ghost");
                alakazam.setAttack2("Future Sight", 120, 20,"psychic");
                alakazam.setLocation(loc);
				pokemons.add(alakazam);
            } else if (choose >= 56 && choose < 58){  // Rare
                starmie = new Pokemon();
                starmie.setName("Starmie");
                starmie.setPic(R.drawable.starmie);
                starmie.setRate(30);
                starmie.setId(120);
                starmie.setType("water");
                starmie.setDesc("The center section is named the core. People think it is communicating when it glows in 7 colors.");
                starmie.setHP(60);
                starmie.setHeight("1.1 m");
                starmie.setWeight("80.0 kg");
                starmie.setAttack1("Psychic",100,30,"psychic");
                starmie.setAttack2("Hydro Pump", 130, 20,"water");
                starmie.setLocation(loc);
				pokemons.add(starmie);
            } else if (choose >= 58 && choose < 60){  // Rare
                weezing = new Pokemon();
                weezing.setName("Weezing");
                weezing.setPic(R.drawable.weezing);
                weezing.setRate(30);
                weezing.setId(109);
                weezing.setType("poison");
                weezing.setDesc("It lives and grows by absorbing dust, germs, and poison gases that are contained in toxic waste and garbage.");
                weezing.setHP(65);
                weezing.setHeight("1.2 m");
                weezing.setWeight("9.5 kg");
                weezing.setAttack1("Sludge Bomb",80,30,"poison");
                weezing.setAttack2("Shadow Ball", 100, 20,"ghost");
                weezing.setLocation(loc);
				pokemons.add(weezing);
            } else if (choose >= 60 && choose < 62){  // Rare
                raichu = new Pokemon();
                raichu.setName("Raichu");
                raichu.setPic(R.drawable.raichu);
                raichu.setRate(30);
                raichu.setId(25);
                raichu.setType("electric");
                raichu.setDesc("When electricity builds up inside its body, it becomes feisty. It also glows in the dark.");
                raichu.setHP(60);
                raichu.setHeight("0.8 m");
                raichu.setWeight("30.0 kg");
                raichu.setAttack1("Thunder Punch",45,55,"electric");
                raichu.setAttack2("Wild Charge", 90, 20,"electric");
                raichu.setLocation(loc);
				pokemons.add(raichu);
            } else if (choose >= 62 && choose < 64){  // Rare
                golem = new Pokemon();
                golem.setName("Golem");
                golem.setPic(R.drawable.golem);
                golem.setRate(20);
                golem.setId(75);
                golem.setType("rock");
                golem.setDesc("Its boulder-like body is extremely hard. It can easily withstand dynamite blasts without damage.");
                golem.setHP(80);
                golem.setHeight("1.4 m");
                golem.setWeight("300.0 kg");
                golem.setAttack1("Rock Blast",50,50,"rock");
                golem.setAttack2("Earthquake", 120, 20,"ground");
                golem.setLocation(loc);
				pokemons.add(golem);
            } else if (choose >= 64 && choose < 66){  // Rare
                rhydon = new Pokemon();
                rhydon.setName("Rhydon");
                rhydon.setPic(R.drawable.rhydon);
                rhydon.setRate(20);
                rhydon.setId(111);
                rhydon.setType("rock");
                rhydon.setDesc("Protected by an armor-like hide, it is capable of living in molten lava of 3,600 degrees.");
                rhydon.setHP(105);
                rhydon.setHeight("1.9 m");
                rhydon.setWeight("120.0 kg");
                rhydon.setAttack1("Megahorn",90,30,"bug");
                rhydon.setAttack2("Earthquake", 120, 20,"ground");
                rhydon.setLocation(loc);
				pokemons.add(rhydon);
            } else if (choose >= 66 && choose < 68){  // Rare
                hypno = new Pokemon();
                hypno.setName("Hypno");
                hypno.setPic(R.drawable.hypno);
                hypno.setRate(30);
                hypno.setId(96);
                hypno.setType("psychic");
                hypno.setDesc("Avoid eye contact if you come across one. It will try to put you to sleep by using its pendulum.");
                hypno.setHP(85);
                hypno.setHeight("1.6 m");
                hypno.setWeight("75.6 kg");
                hypno.setAttack1("Psychic",70,30,"psychic");
                hypno.setAttack2("Focus Blast", 140, 20,"fighting");
                hypno.setLocation(loc);
				pokemons.add(hypno);
            } else if (choose >= 68 && choose < 70){  // Rare
                vileplume = new Pokemon();
                vileplume.setName("Vileplume");
                vileplume.setPic(R.drawable.vileplume);
                vileplume.setRate(20);
                vileplume.setId(44);
                vileplume.setType("grass");
                vileplume.setDesc("The larger its petals, the more toxic pollen it contains. Its big head is heavy and hard to hold up.");
                vileplume.setHP(75);
                vileplume.setHeight("1.2 m");
                vileplume.setWeight("18.6 kg");
                vileplume.setAttack1("Petal Blizzard",110,30,"grass");
                vileplume.setAttack2("Solar Beam", 180, 20,"grass");
                vileplume.setLocation(loc);
				pokemons.add(vileplume);
            } else if (choose >= 70 && choose < 72){  // Rare
                victreebel = new Pokemon();
                victreebel.setName("Victreebel");
                victreebel.setPic(R.drawable.victreebel);
                victreebel.setRate(20);
                victreebel.setId(70);
                victreebel.setType("grass");
                victreebel.setDesc("Lures prey with the sweet aroma of honey. Swallowed whole, the prey is melted in a day, bones and all.");
                victreebel.setHP(80);
                victreebel.setHeight("1.7 m");
                victreebel.setWeight("15.5 kg");
                victreebel.setAttack1("Leaf Blade",70,30,"grass");
                victreebel.setAttack2("Sludge Bomb", 80, 20,"poison");
                victreebel.setLocation(loc);
				pokemons.add(victreebel);
            } else if (choose >= 72 && choose < 74){  // Rare
                venusaur = new Pokemon();
                venusaur.setName("Venusaur");
                venusaur.setPic(R.drawable.venusaur);
                venusaur.setRate(20);
                venusaur.setId(2);
                venusaur.setType("grass");
                venusaur.setDesc("The flower on its back catches the sun's rays. The sunlight is then absorbed and used for energy.");
                venusaur.setHP(80);
                venusaur.setHeight("2.0 m");
                venusaur.setWeight("100.0 kg");
                venusaur.setAttack1("Sludge Bomb",80,30,"poison");
                venusaur.setAttack2("Solar Beam", 180, 20,"grass");
                venusaur.setLocation(loc);
				pokemons.add(venusaur);
            } else if (choose >= 74 && choose < 76){  // Rare
                magmar = new Pokemon();
                magmar.setName("Magmar");
                magmar.setPic(R.drawable.magmar);
                magmar.setRate(20);
                magmar.setId(125);
                magmar.setType("fire");
                magmar.setDesc("Born in an active volcano. Its body is always cloaked in flames, so it looks like a big ball of fire.");
                magmar.setHP(65);
                magmar.setHeight("1.3 m");
                magmar.setWeight("44.5 kg");
                magmar.setAttack1("Karate Chop",8,92,"fighting");
                magmar.setAttack2("Fire Punch", 55, 45,"fire");
                magmar.setLocation(loc);
				pokemons.add(magmar);
            } else { // if (choose >= 76 && choose < 80){  // Common
                ratata = new Pokemon();
                ratata.setName("Rattata");
                ratata.setPic(R.drawable.ratata);
                ratata.setRate(90);
                ratata.setId(18);
                ratata.setType("normal");
                ratata.setDesc("Bites anything when it attacks. Small and very quick, it is a common sight in many places.");
                ratata.setHP(30);
                ratata.setHeight("0.3 m");
                ratata.setWeight("3.5 kg");
                ratata.setAttack1("Tackle ",5,95,"normal");
                ratata.setAttack2("Quick Attack", 8, 92,"normal");
                ratata.setLocation(loc);
				pokemons.add(ratata);
            }
		
		
        }
        System.out.println("Pokemoneja on yhteensä " + pokemons.size());
    }

    public void setGyms(){

        try {
        Gym gym1 = new Gym();
        gym1.setName("Misty");
        gym1.setIntro("I hope you are ready for a challenge !");
        gym1.addPic(R.drawable.misty);
        gym1.setLocation(new LatLng(-35.343784,149.082977));
        gym1.addPokemons(0, squirtle);
		gym1.addPokemons(1, tentacruel);
		gym1.addPokemons(2, starmie);
        gyms.add(gym1);

    Gym gym2 = new Gym();
        gym2.setName("Koga");
        gym2.setIntro("Prepare yourself !");
        gym2.addPic(R.drawable.koga);
        gym2.setLocation(new LatLng(60.192059, 24.945831));
		gym2.addPokemons(0, pidgey);
		gym2.addPokemons(1, weezing);
		gym2.addPokemons(2, nidoking);
		gyms.add(gym2);
		
		Gym gym3 = new Gym();
        gym3.setName("Surge");
        gym3.setIntro("The battle shall start now !");
        gym3.addPic(R.drawable.surge);
        gym3.setLocation(new LatLng(52.518623,13.376198));
		gym3.addPokemons(0,pikachu);
		gym3.addPokemons(1,magnemite);
		gym3.addPokemons(2,raichu);
		gyms.add(gym3);
		
		Gym gym4 = new Gym();
        gym4.setName("Brock");
        gym4.setIntro("Determination is the key to victory !");
        gym4.addPic(R.drawable.brock);
        gym4.setLocation(new LatLng(55.751244, 	37.618423));
		gym4.addPokemons(0, onix);
		gym4.addPokemons(1, golem);
		gym4.addPokemons(2, rhydon);
		gyms.add(gym4);
		
		Gym gym5 = new Gym();
        gym5.setName("Sabrina");
        gym5.setIntro("I can see your mind !");
        gym5.addPic(R.drawable.sabrina);
        gym5.setLocation(new LatLng(35.652832,	139.839478));
		gym5.addPokemons(0, hypno);
		gym5.addPokemons(1, gengar);
		gym5.addPokemons(2, alakazam);
		gyms.add(gym5);
		
		Gym gym6 = new Gym();
        gym6.setName("Erika");
        gym6.setIntro("Isn't it a lovely day ?");
        gym6.addPic(R.drawable.erika);
        gym6.setLocation(new LatLng(39.913818,	116.36325));
		gym6.addPokemons(0, eevee);
		gym6.addPokemons(1, vileplume);
		gym6.addPokemons(2, venusaur);
		gyms.add(gym6);
		
		Gym gym7 = new Gym();
        gym7.setName("Blaine");
        gym7.setIntro("My fire will destroy you !");
        gym7.addPic(R.drawable.blaine);
        gym7.setLocation(new LatLng(64.128288,	-21.827774));
		gym7.addPokemons(0, vulpix);
		gym7.addPokemons(1, arcanine);
		gym7.addPokemons(2, magmar);
		gyms.add(gym7);
		
		Gym gym8 = new Gym();
        gym8.setName("Giovanni");
        gym8.setIntro("This is your end !");
        gym8.addPic(R.drawable.giovanni);
        gym8.setLocation(new LatLng(38.889931,	-77.009003));
		gym8.addPokemons(0, gyarados);
		gym8.addPokemons(1, dragonite);
		gym8.addPokemons(2, mewtwo);
		gyms.add(gym8); } catch(Exception e)  { System.out.println(e.toString()); }  catch (Error e) { System.out.println(e.toString()); }

}
	
	
    public static List <Pokemon> getPokemons() { return pokemons; }
    public static List <Gym> getGyms() {return gyms; }
    public static int getLevel() { return level; }
    public static String getPlayer() { return player; }
    public static int getExp() { return exp; }
    public static void addExp(int adds) {
        exp += adds;
        if(exp >= level  * 50){
            ++level;
        }
    }
    public static void addPokedex(int location){
        int pid = pokemons.get(location).getId();

        if(pokedex[pid] == 0){
            ++caught;
        }
        ++pokedex[pid];
    }
    public static int[] getPokedex() { return pokedex; }
    public static int getCaught() { return caught; }
    public static void addTeam(Pokemon poke) {
        if(teammembers == 6) { return; }
        team[teammembers] = poke;
        ++teammembers;}
    public static int getTeammembers() {return teammembers; }
    public static void updateTeam(int i, Pokemon poke) { team[i] = poke; }
    public static Pokemon[] getTeam() { return team; }
    public static void addBadge() { ++badges; }
    public static int getBadges() { return badges; }
}
