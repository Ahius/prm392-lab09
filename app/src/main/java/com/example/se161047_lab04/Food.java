package com.example.se161047_lab04;

public class Food {
    private int id;
    private String foodName;
    private String foodDes;
//    private int image;
    private String imgae;

    public Food(int id, String foodName, String foodDes, String imgae) {
        this.id = id;
        this.foodName = foodName;
        this.foodDes = foodDes;
        this.imgae = imgae;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDes() {
        return foodDes;
    }

    public void setFoodDes(String foodDes) {
        this.foodDes = foodDes;
    }

    public String getImgae() {
        return imgae;
    }

    public void setImgae(String imgae) {
        this.imgae = imgae;
    }
}

