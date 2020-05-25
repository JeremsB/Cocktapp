package com.mds.cocktapp.service.retrofit;

import com.google.gson.annotations.SerializedName;
import com.mds.cocktapp.model.Cocktail;

import java.util.List;

public class DataContainer {

    @SerializedName("cocktails")
    private List<Cocktail> cocktails;

    public DataContainer() {
    }

    public DataContainer(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    public List<Cocktail> getCocktails() {
        return cocktails;
    }

    public void setCocktails(List<Cocktail> cocktails) {
        this.cocktails = cocktails;
    }

    @Override
    public String toString() {
        return "DataContainer{" +
                "cocktails=" + cocktails +
                '}';
    }
}
