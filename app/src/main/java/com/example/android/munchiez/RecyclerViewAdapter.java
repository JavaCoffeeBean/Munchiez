package com.example.android.munchiez;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<ImageButton> mfavoriteButton = new ArrayList<>();
    private ArrayList<Button> mcartButton = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(Context context, ArrayList<String> imageNames, ArrayList<String> images, ArrayList<ImageButton> favoriteButtons, ArrayList<Button> cartButtons) {
        mImages = images;
        mImageNames = imageNames;
        mfavoriteButton = favoriteButtons;
        mcartButton = cartButtons;
        mContext = context;

    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: called.");
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.recipeImage);

        holder.recipeName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: clicked on: " + mImageNames.get(position));

                Toast.makeText(mContext, mImageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        RelativeLayout parentLayout;
        TextView recipeName;
        ImageButton favoriteButton;
        Button cartButton;
        ImageView recipeImage;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            parentLayout = itemView.findViewById(R.id.parent_layout1);
            recipeName = itemView.findViewById(R.id.recipe_name);
            favoriteButton = itemView.findViewById(R.id.favorite_button);
            cartButton = itemView.findViewById(R.id.cart_button);
            recipeImage = itemView.findViewById(R.id.recipe_image);
        }
    }
}
