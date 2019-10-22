package com.example.android.munchiez;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_test);

        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps");



//        mImageUrls.add(/*place image url here*/);
//        mNames.add(/*place rerecipe name here*/);


//        Example

        mImageUrls.add("https://i.pinimg.com/474x/51/f2/25/51f225cc7735e271da581e71e1d42041.jpg");
        mNames.add("Chicken Salad");

        mImageUrls.add("https://pbs.twimg.com/profile_images/430129632310878209/Wiu5QAFe.jpeg");
        mNames.add("Sloppy Joe");

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init RecyclerView.");
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
