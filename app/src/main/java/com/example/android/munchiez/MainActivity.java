package com.example.android.munchiez;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private ArrayList<ImageButton> favoriteIcons = new ArrayList<>();
    private ArrayList<Button> cartIcons = new ArrayList<>();


    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_fragments);

        BottomNavigationView bottomnav = findViewById(R.id.bottom_navigation);
        bottomnav.setOnNavigationItemSelectedListener(navlistener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new HomeFragment()).commit();

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlistener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.nav_favorites:
                            selectedFragment = new FavoriteFragment();
                            break;
                        case R.id.nav_cart:
                            selectedFragment = new CartFragment();
                            break;
                        case R.id.nav_options:
                            selectedFragment = new OptionsFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");




//        mImageUrls.add(/*place image url here that you got from api*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mImageUrls.add("https://i.pinimg.com/474x/51/f2/25/51f225cc7735e271da581e71e1d42041.jpg");
        mNames.add("Chicken Salad");

        mImageUrls.add("https://pbs.twimg.com/profile_images/430129632310878209/Wiu5QAFe.jpeg");
        mNames.add("Sloppy Joe");

        mImageUrls.add("https://www.yummyhealthyeasy.com/wp-content/uploads/2018/04/california-sushi-rolls-4.jpg");
        mNames.add("Sushi");

        mImageUrls.add("https://www.sprinklesomesugar.com/wp-content/uploads/2017/02/IMG_6846.jpg");
        mNames.add("Red Velvet Cookies");

        mImageUrls.add("https://www.jessicagavin.com/wp-content/uploads/2015/03/shrimp-spring-rolls-with-dipping-sauce-1200.jpg");
        mNames.add("Spring Rolls");

        mImageUrls.add("http://blog.williams-sonoma.com/wp-content/uploads/2018/03/bouchon-bakery-macarons-smaller-800px.jpg");
        mNames.add("Macarons");


    }
    
    protected void onStart(){
        super.onStart();

        Log.d(TAG, "onStart: this method started");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls, favoriteIcons, cartIcons);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }




}