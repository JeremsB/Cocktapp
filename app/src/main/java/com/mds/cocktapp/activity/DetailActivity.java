package com.mds.cocktapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
    private Cocktail cocktail;
    ImageView iv_cocktail_image;
    TextView tv_cocktail_name;
    TextView tv_cocktail_alcoolise;
    TextView tv_cocktail_category;
    TextView tv_cocktail_glass;
    TextView tv_cocktail_instructions;
    TextView tv_cocktail_ingred1;
    TextView tv_cocktail_ingred2;
    TextView tv_cocktail_ingred3;
    TextView tv_cocktail_ingred4;
    TextView tv_cocktail_ingred5;
    TextView tv_cocktail_ingred6;
    TextView tv_cocktail_ingred7;
    TextView tv_cocktail_ingred8;
    TextView tv_cocktail_ingred9;
    TextView tv_cocktail_ingred10;
    TextView tv_cocktail_measure1;
    TextView tv_cocktail_measure2;
    TextView tv_cocktail_measure3;
    TextView tv_cocktail_measure4;
    TextView tv_cocktail_measure5;
    TextView tv_cocktail_measure6;
    TextView tv_cocktail_measure7;
    TextView tv_cocktail_measure8;
    TextView tv_cocktail_measure9;
    TextView tv_cocktail_measure10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        iv_cocktail_image = findViewById(R.id.iv_cocktail_image);
        tv_cocktail_name = findViewById(R.id.tv_cocktail_name);
        tv_cocktail_alcoolise = findViewById(R.id.tv_cocktail_alcoolise);
        tv_cocktail_category = findViewById(R.id.tv_cocktail_category);
        tv_cocktail_glass = findViewById(R.id.tv_cocktail_glass);
        tv_cocktail_instructions = findViewById(R.id.tv_cocktail_instructions);
        tv_cocktail_ingred1 = findViewById(R.id.tv_cocktail_ingred1);
        tv_cocktail_ingred2 = findViewById(R.id.tv_cocktail_ingred2);
        tv_cocktail_ingred3 = findViewById(R.id.tv_cocktail_ingred3);
        tv_cocktail_ingred4 = findViewById(R.id.tv_cocktail_ingred4);
        tv_cocktail_ingred5 = findViewById(R.id.tv_cocktail_ingred5);
        tv_cocktail_ingred6 = findViewById(R.id.tv_cocktail_ingred6);
        tv_cocktail_ingred7 = findViewById(R.id.tv_cocktail_ingred7);
        tv_cocktail_ingred8 = findViewById(R.id.tv_cocktail_ingred8);
        tv_cocktail_ingred9 = findViewById(R.id.tv_cocktail_ingred9);
        tv_cocktail_ingred10 = findViewById(R.id.tv_cocktail_ingred10);
        tv_cocktail_measure1 = findViewById(R.id.tv_cocktail_measure1);
        tv_cocktail_measure2 = findViewById(R.id.tv_cocktail_measure2);
        tv_cocktail_measure3 = findViewById(R.id.tv_cocktail_measure3);
        tv_cocktail_measure4 = findViewById(R.id.tv_cocktail_measure4);
        tv_cocktail_measure5 = findViewById(R.id.tv_cocktail_measure5);
        tv_cocktail_measure6 = findViewById(R.id.tv_cocktail_measure6);
        tv_cocktail_measure7 = findViewById(R.id.tv_cocktail_measure7);
        tv_cocktail_measure8 = findViewById(R.id.tv_cocktail_measure8);
        tv_cocktail_measure9 = findViewById(R.id.tv_cocktail_measure9);
        tv_cocktail_measure10 = findViewById(R.id.tv_cocktail_measure10);

        Intent intent = getIntent();
        String idCocktail = intent.getStringExtra("id");

        System.out.println("ID COCKTAIL: " + idCocktail);

        Call<DataContainer> getInfosCocktailCall = RetrofitClient.getCocktailService().getInfosCocktail(idCocktail);
        getInfosCocktailCall.enqueue(new Callback<DataContainer>() {
            @Override
            public void onResponse(Call<DataContainer> call, Response<DataContainer> response) {
                cocktail = response.body().getCocktails().get(0);
                DetailActivity.this.showCocktail();
            }

            @Override
            public void onFailure(Call<DataContainer> call, Throwable t) {
                Log.d(TAG, "MainActivity - getCocktailsCall - onResponse");
                Log.d(TAG, t.getMessage());
            }
        });

    }

    void showCocktail() {

        Picasso.get().load(cocktail.getStrDrinkThumb()).into(iv_cocktail_image);
        tv_cocktail_name.setText(cocktail.getName());
        tv_cocktail_alcoolise.setText(cocktail.getAlcoholic());
        tv_cocktail_category.setText(cocktail.getCategory());
        tv_cocktail_glass.setText(cocktail.getGlass());
        tv_cocktail_instructions.setText(cocktail.getInstructions());
        tv_cocktail_ingred1.setText(cocktail.getIngred1());
        tv_cocktail_ingred2.setText(cocktail.getIngred2());
        tv_cocktail_ingred3.setText(cocktail.getIngred3());
        tv_cocktail_ingred4.setText(cocktail.getIngred4());
        tv_cocktail_ingred5.setText(cocktail.getIngred5());
        tv_cocktail_ingred6.setText(cocktail.getIngred6());
        tv_cocktail_ingred7.setText(cocktail.getIngred7());
        tv_cocktail_ingred8.setText(cocktail.getIngred8());
        tv_cocktail_ingred9.setText(cocktail.getIngred9());
        tv_cocktail_ingred10.setText(cocktail.getIngred10());
        tv_cocktail_measure1.setText(cocktail.getMeasure1());
        tv_cocktail_measure2.setText(cocktail.getMeasure2());
        tv_cocktail_measure3.setText(cocktail.getMeasure3());
        tv_cocktail_measure4.setText(cocktail.getMeasure4());
        tv_cocktail_measure5.setText(cocktail.getMeasure5());
        tv_cocktail_measure6.setText(cocktail.getMeasure6());
        tv_cocktail_measure7.setText(cocktail.getMeasure7());
        tv_cocktail_measure8.setText(cocktail.getMeasure8());
        tv_cocktail_measure9.setText(cocktail.getMeasure9());
        tv_cocktail_measure10.setText(cocktail.getMeasure10());

        ArrayList<TextView> mylist = new ArrayList<TextView>();
        mylist.add(tv_cocktail_name);
        mylist.add(tv_cocktail_alcoolise);
        mylist.add(tv_cocktail_category);
        mylist.add(tv_cocktail_glass);
        mylist.add(tv_cocktail_instructions);
        mylist.add(tv_cocktail_ingred1);
        mylist.add(tv_cocktail_ingred2);
        mylist.add(tv_cocktail_ingred3);
        mylist.add(tv_cocktail_ingred4);
        mylist.add(tv_cocktail_ingred5);
        mylist.add(tv_cocktail_measure1);
        mylist.add(tv_cocktail_measure2);
        mylist.add(tv_cocktail_measure3);
        mylist.add(tv_cocktail_measure4);
        mylist.add(tv_cocktail_measure5);

        for (TextView tv : mylist) {
            if (tv.getText().toString().equals("")) {
                tv.setVisibility(View.GONE);
            } else {
                tv.setVisibility(View.VISIBLE);
            }
        }

    }

}
