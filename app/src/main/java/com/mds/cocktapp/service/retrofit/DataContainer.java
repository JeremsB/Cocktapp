package com.mds.cocktapp.service.retrofit;

import com.google.gson.annotations.SerializedName;
import com.mds.cocktapp.model.Cocktail;

import java.util.Collection;
import java.util.List;

public class DataContainer {

    @SerializedName("drinks")
    private List<Cocktail> drinks;

    public DataContainer() {
    }

    public DataContainer(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    public List<Cocktail> getCocktails() {
        return drinks;
    }

    public void setCocktails(List<Cocktail> drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "DataContainer{" +
                "cocktails=" + drinks +
                '}';
    }

}
