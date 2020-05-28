package com.mds.cocktapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.mds.cocktapp.R;
import com.mds.cocktapp.model.Cocktail;
import com.mds.cocktapp.service.retrofit.DataContainer;
import com.mds.cocktapp.service.retrofit.RetrofitClient;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    public static final String TAG = "DetailCocktail%";
    private List<Cocktail> cocktail = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String idCocktail = intent.getStringExtra("id");

        Call<DataContainer> getInfosCocktailCall = RetrofitClient.getCocktailService().getInfosCocktail(idCocktail);
        getInfosCocktailCall.enqueue(new Callback<DataContainer>() {
            @Override
            public void onResponse(Call<DataContainer> call, Response<DataContainer> response) {
                Log.d(TAG, "MainActivity - getInfosCocktailCall - onResponse");
                //Log.d(TAG, response.code() + "");
                Log.d(TAG, response.body().toString() + "");
                cocktail.clear();
                cocktail = response.body().getCocktails();
                Log.d(TAG, cocktail.toString());
                Log.d(TAG, String.valueOf(cocktail.getClass()));
            }

            @Override
            public void onFailure(Call<DataContainer> call, Throwable t) {
                Log.d(TAG, "MainActivity - getCocktailsCall - onResponse");
                Log.d(TAG, t.getMessage());
            }
        });

        //Log.d("test", String.valueOf(cocktail.toArray()));
        //Log.d("test", cocktail.toString());
        //Log.d(TAG, testCocktail.toString() + "");
/*
        TextView tv_cocktail_name = findViewById(R.id.tv_cocktail_name);
        tv_cocktail_name.setText(testCocktail.getName());

        TextView tv_cocktail_alcoolise = findViewById(R.id.tv_cocktail_alcoolise);
        tv_cocktail_alcoolise.setText(testCocktail.getAlcoholic());

        TextView tv_cocktail_category = findViewById(R.id.tv_cocktail_category);
        tv_cocktail_category.setText(testCocktail.getCategory());

        TextView tv_cocktail_glass = findViewById(R.id.tv_cocktail_glass);
        tv_cocktail_glass.setText(testCocktail.getGlass());

        TextView tv_cocktail_instructions = findViewById(R.id.tv_cocktail_instructions);
        tv_cocktail_instructions.setText(testCocktail.getInstructions());
*/
    }

}
