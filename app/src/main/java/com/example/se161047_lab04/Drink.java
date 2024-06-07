package com.example.se161047_lab04;

public class Drink {


    private String drinkName;
    private String drinkDes;
    private int image;

    public Drink(String drinkName, String drinkDes, int image) {
        this.drinkName = drinkName;
        this.drinkDes = drinkDes;
        this.image = image;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkDes() {
        return drinkDes;
    }

    public void setDrinkDes(String drinkDes) {
        this.drinkDes = drinkDes;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

