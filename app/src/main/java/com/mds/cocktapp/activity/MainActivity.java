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
    private String ingredient;
    private EditText et_search;

    private List<Cocktail> cocktails = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv_main_cocktails = findViewById(R.id.rv_main_cocktails);

        final CocktailsAdapter cocktailsAdapter = new CocktailsAdapter(cocktails);

        rv_main_cocktails.setAdapter(cocktailsAdapter);
        rv_main_cocktails.setLayoutManager(new LinearLayoutManager(this));

        String [] arr = {"Gin", "Vodka", "Rum", "Tequila", "Jagermeister", "Whiskey"};
        Random random = new Random();
        int select = random.nextInt(arr.length);
        ingredient = arr[select];

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
        });


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

}
