package com.mds.cocktapp.model;

import com.google.gson.annotations.SerializedName;

public class Cocktail {

    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("instructions")
    private String instructions;
    @SerializedName("alcoholic")
    private String alcoholic;
    @SerializedName("glass")
    private String glass;
    @SerializedName("imagePath")
    private String imagePath;
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

    public Cocktail(String id, String name, String instructions, String alcoholic, String glass, String imagePath, String ingred1, String ingred2, String ingred3, String ingred4, String ingred5, String measure1, String measure2, String measure3, String measure4, String measure5) {
        this.id = id;
        this.name = name;
        this.instructions = instructions;
        this.alcoholic = alcoholic;
        this.glass = glass;
        this.imagePath = imagePath;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", instructions='" + instructions + '\'' +
                ", alcoholic='" + alcoholic + '\'' +
                ", glass='" + glass + '\'' +
                ", imagePath='" + imagePath + '\'' +
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
