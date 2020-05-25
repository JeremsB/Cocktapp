package com.mds.cocktapp.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mds.cocktapp.R;

public class CocktailViewHolder extends RecyclerView.ViewHolder {

    private TextView tv_item_cocktail_name;
    private ImageView tv_item_cocktail_image;

    public CocktailViewHolder(@NonNull View itemView) {
        super(itemView);
        tv_item_cocktail_name = itemView.findViewById(R.id.tv_item_cocktail_name);
        tv_item_cocktail_image = itemView.findViewById(R.id.tv_item_cocktail_image);
    }

    public TextView getTv_item_cocktail_name() {
        return tv_item_cocktail_name;
    }

    public ImageView getTv_item_cocktail_image() {
        return tv_item_cocktail_image;
    }
}
