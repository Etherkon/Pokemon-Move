package com.pokemon.pokemon;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.location.LocationListener;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.media.MediaPlayer;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;


public class MapActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;

    public LocationManager mlocManager;
    public String provider;
    private final int FINE_LOCATION_PERMISSION = 9999;
    private float zoomlevel = 16.0f;
    private LatLng loyty = new LatLng (0f,0f);
    private ImageButton radar;
    private ImageButton player;
    private Button start;
    private LatLng curLoc = new LatLng (0f,0f);
    private Data data = new Data();
    private List<Pokemon> pokemons;
    private List<Gym> gyms;
    private List<Marker> markers = new ArrayList<Marker>();
    private List<Boolean> markers2 = new ArrayList<>();
    private List<Marker> gmarkers = new ArrayList<Marker>();
    private List<Integer> pokedex = new ArrayList<Integer>();
    private CheckBox fog;
    private int markerClicked = 0;
    private MediaPlayer music;

    private Marker poke1 = null;
    private Marker gymM = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        radar = (ImageButton) findViewById(R.id.imageButton4);
        player = (ImageButton) findViewById(R.id.button2);
        start = (Button) findViewById(R.id.button4);
        fog = (CheckBox) findViewById(R.id.checkBox);
        radar.setVisibility(View.INVISIBLE);
        player.setVisibility(View.INVISIBLE);
        fog.setChecked(true);
        fog.setVisibility(View.INVISIBLE);
        music = MediaPlayer.create(MapActivity.this, R.raw.walk);
        music.setLooping(true);
        music.start();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, FINE_LOCATION_PERMISSION);
        }

        mMap = mapFragment.getMap();

        if(mMap == null) {
            System.out.println("WHY");
        }
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        mlocManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        criteria.setAltitudeRequired(false);
        criteria.setSpeedRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);

        provider = mlocManager.getBestProvider(criteria, false);

        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    start.setText("Loading");
                setUpMap(); } catch (Exception e) { System.out.println(e.toString()); }
            }
        });

        radar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                radar();
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MapActivity.this, PlayerActivity.class);
                startActivity(intent);
            }
        });
    }

    private Location getMyLocation() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_PERMISSION);}

        LocationManager lm = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Location myLocation = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if (myLocation == null) {
            Criteria criteria = new Criteria();
            criteria.setAccuracy(Criteria.ACCURACY_COARSE);
            criteria.setAltitudeRequired(false);
            criteria.setSpeedRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(false);
            String provider = lm.getBestProvider(criteria, true);
            myLocation = lm.getLastKnownLocation(provider);
        }
        return myLocation;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_PERMISSION);}

        mlocManager.requestLocationUpdates(provider, 400, 1, this);
        music.start();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setCompassEnabled(true);
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_PERMISSION);}

        mlocManager.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        Double lat,lng;
        lat = location.getLatitude();
        lng = location.getLongitude();
        curLoc = new LatLng(lat, lng);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(curLoc));
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
    }

    @Override
    public void onProviderEnabled(String s) {
    }

    @Override
    public void onProviderDisabled(String s) {
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data2) {
     //   music.start();
        String result = data2.getStringExtra("result");
        System.out.println("Palattiin takaisin karttaan " + result);
        if(result.contentEquals("1")){
            markers.get(markerClicked).setVisible(false);
            markers2.set(markerClicked, true);
            data.addPokedex(markerClicked);
            data.addTeam(pokemons.get(markerClicked));
        }
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {

        for(int i = 0; i < markers.size(); ++i){

          if (marker.equals(markers.get(i)))
           {
               music.pause();
               markerClicked = i;
               Intent intent = new Intent(MapActivity.this, CameraActivity.class);
               intent.putExtra("pokemon",markerClicked);
               startActivityForResult(intent, 1);
           }
        }
        for(int j = 0; j < gmarkers.size(); ++j){
            if (marker.equals(gmarkers.get(j)) && data.getTeammembers() > 0)
            {
                music.pause();
                markerClicked = j;
                Intent intent = new Intent(MapActivity.this, BattleActivity.class);
                intent.putExtra("pokemon",markerClicked);
                startActivityForResult(intent,2);
            }
        }
        return true;
    }

    private void setUpMap(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},FINE_LOCATION_PERMISSION);}

        double dLatitude = getMyLocation().getLatitude();
        double dLongitude = getMyLocation().getLongitude();
        curLoc = new LatLng (dLatitude,dLongitude);
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(curLoc, zoomlevel));
        data.setPokemons();
        pokemons = data.getPokemons();
        System.out.println("Pokemonit saatu");
        data.setGyms();
        gyms = data.getGyms();
        System.out.println("Gymit saatu");
        mMap.setOnMarkerClickListener(this);
        radar.setVisibility(View.VISIBLE);
        player.setVisibility(View.VISIBLE);
        start.setVisibility(View.INVISIBLE);
        fog.setVisibility(View.VISIBLE);
        for(int i = 0; i < pokemons.size(); ++i) {
            addPokemon(i);
        }
        System.out.println("Pokemonit kartalla");
        addGym();
        System.out.println("Gymit kartalla");
    }

    private void radar(){
        pokemonVisibility();
    }

    private void addPokemon(int i){

        loyty = new LatLng (pokemons.get(i).getLocation().latitude, pokemons.get(i).getLocation().longitude);

        int height = 110;
        int width = 110;

     //   System.out.println(i + " " + pokemons.get(i).getId() + " " + pokemons.get(i).getName());
        if(pokemons.get(i) == null){ return; }
        int pokemon = pokemons.get(i).getPic();
        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(pokemon);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);

        poke1 = mMap.addMarker(new MarkerOptions().position(loyty).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Pokemon found"));
        poke1.setVisible(false);
        markers.add(poke1);
        markers2.add(false);
    }

    private void addGym(){
        int height = 140;
        int width = 140;
        System.out.println("Sali lisätty");

        int gpic =  R.drawable.gym1;
        LatLng gloc = new LatLng (gyms.get(0).getLocation().latitude, gyms.get(0).getLocation().longitude);

        BitmapDrawable bitmapdraw=(BitmapDrawable)getResources().getDrawable(gpic);
        Bitmap b=bitmapdraw.getBitmap();
        Bitmap smallMarker = Bitmap.createScaledBitmap(b, width, height, false);
        gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
     //   gymM.setVisible(false);
        gmarkers.add(gymM);
		
        gloc = new LatLng (gyms.get(1).getLocation().latitude, gyms.get(1).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(2).getLocation().latitude, gyms.get(2).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(3).getLocation().latitude, gyms.get(3).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(4).getLocation().latitude, gyms.get(4).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(5).getLocation().latitude, gyms.get(5).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(6).getLocation().latitude, gyms.get(6).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
		
		gloc = new LatLng (gyms.get(7).getLocation().latitude, gyms.get(7).getLocation().longitude);
		gymM = mMap.addMarker(new MarkerOptions().position(gloc).icon(BitmapDescriptorFactory.fromBitmap(smallMarker)).title("Gym found"));
		gmarkers.add(gymM);
    }

    private void pokemonVisibility(){
        LatLng loc;
        for(int i = 0; i < markers.size(); ++i){
            loc =  new LatLng (pokemons.get(i).getLocation().latitude, pokemons.get(i).getLocation().longitude);
            float[] results = new float[1];
            Location.distanceBetween(curLoc.longitude,curLoc.latitude,loc.longitude,loc.latitude,results);

            if(results[0] < 200f && fog.isChecked() && markers2.get(i) == false){
                markers.get(i).setVisible(true);
            }
            else if(!fog.isChecked() && markers2.get(i) == false){
                markers.get(i).setVisible(true);
            }
            else {
                markers.get(i).setVisible(false);
            }
        }
    }

}
