package com.example.idnert.ekonomiappen;

import android.util.Log;

/**
 * Created by idnert on 2015-10-06.
 */

//Showing list to expences
public class ShowExpences {
    private String date;
    private String description;
    private int price;
    private String category;
    private String cost;
/*This constructor is used to show the image and titel in the list*/
    public ShowExpences( String description, String category){
        this.description= description;
        this.category=category;
    }

    public ShowExpences(int price, String date, String description, String category){

        this.price = price;
        String cost = String.valueOf(price);
        this.cost = cost;

        this.date = date;

        this.description = description;
        this.category = category;
        Log.d("InCOME", category + " " + cost + " " + date);

    }


    public String getCost(){return cost;}
    public String getday(){return date;}
    public String getDescription(){return  description;}

    public String getCategory(){return category;}



}
