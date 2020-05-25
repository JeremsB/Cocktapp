package com.mds.cocktapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.mds.cocktapp.R;
import com.mds.cocktapp.adapter.CocktailsAdapter;
import com.mds.cocktapp.model.Cocktail;
import com.mds.cocktapp.service.retrofit.DataContainer;
import com.mds.cocktapp.service.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Cocktail%";

    private RecyclerView rv_main_cocktails;

    private List<Cocktail> cocktails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main_cocktails = findViewById(R.id.rv_main_cocktails);

        final CocktailsAdapter cocktailsAdapter = new CocktailsAdapter(cocktails);

        rv_main_cocktails.setAdapter(cocktailsAdapter);
        rv_main_cocktails.setLayoutManager(new LinearLayoutManager(this));

        Call<DataContainer> getCocktailsCall = RetrofitClient.getCocktailService().getCocktails("rum");
        getCocktailsCall.enqueue(new Callback<DataContainer>() {
            @Override
            public void onResponse(Call<DataContainer> call, Response<DataContainer> response) {
                Log.d(TAG, "MainActivity - getCocktailsCall - onResponse");
                Log.d(TAG, response.code() + "");
                Log.d(TAG, response.body().toString() + "");
                cocktails.clear();
                cocktails.addAll(response.body().getCocktails());
                cocktailsAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DataContainer> call, Throwable t) {
                Log.d(TAG, "MainActivity - getCocktailsCall - onResponse");
                Log.d(TAG, t.getMessage());
            }
        });

    }
}
