package com.mds.cocktapp.model;

import com.google.gson.annotations.SerializedName;

public class Cocktail {

    @SerializedName("idDrink")
    private String idDrink;
    @SerializedName("strDrink")
    private String strDrink;
    @SerializedName("instructions")
    private String instructions;
    @SerializedName("alcoholic")
    private String alcoholic;
    @SerializedName("glass")
    private String glass;
    @SerializedName("strDrinkThumb")
    private String strDrinkThumb;
    @SerializedName("ingred1")
    private String ingred1;
    @SerializedName("ingred2")
    private String ingred2;
    @SerializedName("ingred3")
    private String ingred3;
    @SerializedName("ingred4")
    private String ingred4;
    @SerializedName("ingred5")
    private String ingred5;
    @SerializedName("measure1")
    private String measure1;
    @SerializedName("measure2")
    private String measure2;
    @SerializedName("measure3")
    private String measure3;
    @SerializedName("measure4")
    private String measure4;
    @SerializedName("measure5")
    private String measure5;

    public Cocktail(){}

    public Cocktail(String idDrink, String strDrink, String instructions, String alcoholic, String glass, String strDrinkThumb, String ingred1, String ingred2, String ingred3, String ingred4, String ingred5, String measure1, String measure2, String measure3, String measure4, String measure5) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.instructions = instructions;
        this.alcoholic = alcoholic;
        this.glass = glass;
        this.strDrinkThumb = strDrinkThumb;
        this.ingred1 = ingred1;
        this.ingred2 = ingred2;
        this.ingred3 = ingred3;
        this.ingred4 = ingred4;
        this.ingred5 = ingred5;
        this.measure1 = measure1;
        this.measure2 = measure2;
        this.measure3 = measure3;
        this.measure4 = measure4;
        this.measure5 = measure5;
    }

    public String getIdDrink() {
        return idDrink;
    }

    public void setIdDrink(String idDrink) {
        this.idDrink = idDrink;
    }

    public String getStrDrink() {
        return strDrink;
    }

    public void setStrDrink(String strDrink) {
        this.strDrink = strDrink;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getAlcoholic() {
        return alcoholic;
    }

    public void setAlcoholic(String alcoholic) {
        this.alcoholic = alcoholic;
    }

    public String getGlass() {
        return glass;
    }

    public void setGlass(String glass) {
        this.glass = glass;
    }

    public String getStrDrinkThumb() {
        return strDrinkThumb;
    }

    public void setStrDrinkThumb(String strDrinkThumb) {
        this.strDrinkThumb = strDrinkThumb;
    }

    public String getIngred1() {
        return ingred1;
    }

    public void setIngred1(String ingred1) {
        this.ingred1 = ingred1;
    }

    public String getIngred2() {
        return ingred2;
    }

    public void setIngred2(String ingred2) {
        this.ingred2 = ingred2;
    }

    public String getIngred3() {
        return ingred3;
    }

    public void setIngred3(String ingred3) {
        this.ingred3 = ingred3;
    }

    public String getIngred4() {
        return ingred4;
    }

    public void setIngred4(String ingred4) {
        this.ingred4 = ingred4;
    }

    public String getIngred5() {
        return ingred5;
    }

    public void setIngred5(String ingred5) {
        this.ingred5 = ingred5;
    }

    public String getMeasure1() {
        return measure1;
    }

    public void setMeasure1(String measure1) {
        this.measure1 = measure1;
    }

    public String getMeasure2() {
        return measure2;
    }

    public void setMeasure2(String measure2) {
        this.measure2 = measure2;
    }

    public String getMeasure3() {
        return measure3;
    }

    public void setMeasure3(String measure3) {
        this.measure3 = measure3;
    }

    public String getMeasure4() {
        return measure4;
    }

    public void setMeasure4(String measure4) {
        this.measure4 = measure4;
    }

    public String getMeasure5() {
        return measure5;
    }

    public void setMeasure5(String measure5) {
        this.measure5 = measure5;
    }

    @Override
    public String toString() {
        return "Cocktail{" +
                "idDrink='" + idDrink + '\'' +
                ", strDrink='" + strDrink + '\'' +
                ", instructions='" + instructions + '\'' +
                ", alcoholic='" + alcoholic + '\'' +
                ", glass='" + glass + '\'' +
                ", strDrinkThumb='" + strDrinkThumb + '\'' +
                ", ingred1='" + ingred1 + '\'' +
                ", ingred2='" + ingred2 + '\'' +
                ", ingred3='" + ingred3 + '\'' +
                ", ingred4='" + ingred4 + '\'' +
                ", ingred5='" + ingred5 + '\'' +
                ", measure1='" + measure1 + '\'' +
                ", measure2='" + measure2 + '\'' +
                ", measure3='" + measure3 + '\'' +
                ", measure4='" + measure4 + '\'' +
                ", measure5='" + measure5 + '\'' +
                '}';
    }
}
