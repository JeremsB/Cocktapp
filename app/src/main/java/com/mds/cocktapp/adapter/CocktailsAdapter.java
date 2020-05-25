package com.mds.cocktapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mds.cocktapp.R;
import com.mds.cocktapp.model.Cocktail;
import com.mds.cocktapp.viewholder.CocktailViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CocktailsAdapter extends RecyclerView.Adapter<CocktailViewHolder> {

    private List<Cocktail> cocktails;

    public CocktailsAdapter(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    @NonNull
    @Override
    public CocktailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mainViewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cocktail, parent, false);
        CocktailViewHolder cocktailViewHolder = new CocktailViewHolder(mainViewHolder);
        return cocktailViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CocktailViewHolder holder, int position) {
        Cocktail cocktail = cocktails.get(position);
        TextView tv_item_cocktail_name = holder.getTv_item_cocktail_name();
        tv_item_cocktail_name.setText(cocktail.getName());

        ImageView tv_item_cocktail_image = holder.getTv_item_cocktail_image();
        Picasso.get().load(cocktail.getImagePath()).into(tv_item_cocktail_image);
    }

    @Override
    public int getItemCount() {
        return cocktails.size();
    }

}
