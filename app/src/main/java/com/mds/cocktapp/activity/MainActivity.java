package com.mds.cocktapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mds.cocktapp.R;
import com.mds.cocktapp.adapter.CocktailsAdapter;
import com.mds.cocktapp.model.Cocktail;
import com.mds.cocktapp.service.retrofit.DataContainer;
import com.mds.cocktapp.service.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "Cocktail%";

    private RecyclerView rv_main_cocktails;
    private ImageButton btn_search;
    private ImageButton btn_random;
    private Button bt_vodka;
    private Button bt_rhum;
    private Button bt_whisky;
    private Button bt_eaudevie;
    private Button bt_tequila;
    private Button bt_gin;
    private String ingredient;
    private EditText et_search;

    private List<Cocktail> cocktails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main_cocktails = findViewById(R.id.rv_main_cocktails);

        String [] arr = {"Gin", "Vodka", "Rum", "Tequila", "Jagermeister", "Whiskey"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        ingredient = arr[select];

        this.showCocktails(ingredient);

        et_search = findViewById(R.id.et_search);
        et_search.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    btn_search.performClick();
                    return true;
                }
                return false;
            }
        });

        btn_search = findViewById(R.id.btn_search);
        btn_search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ingredient = et_search.getText().toString();
                et_search.setText("");

                showCocktails(ingredient);

            }
        });

        bt_vodka = findViewById(R.id.bt_vodka);
        bt_vodka.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Vodka");

            }
        });

        bt_rhum = findViewById(R.id.bt_rhum);
        bt_rhum.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Rum");

            }
        });

        bt_eaudevie = findViewById(R.id.bt_eaudevie);
        bt_eaudevie.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Brandy");

            }
        });

        bt_whisky = findViewById(R.id.bt_whisky);
        bt_whisky.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Whiskey");

            }
        });

        bt_gin = findViewById(R.id.bt_gin);
        bt_gin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Brandy");

            }
        });

        bt_tequila = findViewById(R.id.bt_tequila);
        bt_tequila.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showCocktails("Whiskey");

            }
        });

        btn_random = findViewById(R.id.btn_random);
        btn_random.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                showRandomCocktail();

            }
        });

    }

    private void showCocktails(String ingredient) {

        final CocktailsAdapter cocktailsAdapter = new CocktailsAdapter(cocktails);
        rv_main_cocktails.setAdapter(cocktailsAdapter);
        rv_main_cocktails.setLayoutManager(new LinearLayoutManager(this));

        Call<DataContainer> getCocktailsCall = RetrofitClient.getCocktailService().getCocktails(ingredient);
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

    private void showRandomCocktail(){
        Call<DataContainer> getRandomCocktailCall = RetrofitClient.getCocktailService().getRandomCocktail();
        getRandomCocktailCall.enqueue(new Callback<DataContainer>() {
            @Override
            public void onResponse(Call<DataContainer> call, Response<DataContainer> response) {
                Log.d(TAG, "MainActivity - getRandomCocktailCall - onResponse");
                Log.d(TAG, response.code() + "");
                Log.d(TAG, response.body().toString() + "");
                cocktails.clear();
                cocktails.addAll(response.body().getCocktails());
                Log.d(TAG, cocktails.toString() + "");
                Log.d(TAG, cocktails.get(0).getId() + "");
            }

            @Override
            public void onFailure(Call<DataContainer> call, Throwable t) {
                Log.d(TAG, "MainActivity - getRandomCocktailCall - onResponse");
                Log.d(TAG, t.getMessage());
            }
        });

        //Récupérer l'id
        //String idCocktail=cocktails.getId();
        Log.d(TAG, cocktails + "TEST");
        //String idCocktail = "12772";
        String idCocktail = cocktails.get(0).getId();
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("id", idCocktail);
        startActivity(intent);
    }

}
