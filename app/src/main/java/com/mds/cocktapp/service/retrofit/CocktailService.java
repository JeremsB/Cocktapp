package com.mds.cocktapp.service.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CocktailService {

    @GET("filter.php")
    Call<DataContainer> getCocktails(@Query("i") String search);

    @GET("lookup.php")
    Call<DataContainer> getInfosCocktail(@Query("i") String id);

    @GET("random.php")
    Call<DataContainer> getRandomCocktail();

}
