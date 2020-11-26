package com.example.petview.ui.home;

public class HomeRankingData {

    private String name;
    private String price;
    private String rank;
    private int img;

    public HomeRankingData(String name, String price, String rank, int img) {
        this.name = name;
        this.price = price;
        this.rank = rank;
        this.img = img;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }

    public String getPrice() { return price;}

    public void setPrice(String price) { this.price = price; }

    public String getRank() { return rank;}

    public void setRank(String rank) { this.rank = rank; }

    public int getImg() { return img;}

    public void setImg(int img) { this.img = img; }

}
