package com.mds.cocktapp.service.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    //Singleton
    private static CocktailService cocktailService;
    public static CocktailService getCocktailService() {

        if (cocktailService == null) {
            //Retrofit builder to instantiate CocktailService
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.thecocktaildb.com/api/json/v1/1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            //Create PokeService
            cocktailService = retrofit.create(CocktailService.class);
        }

        return cocktailService;

    }
}
