package com.example.idnert.ekonomiappen;

import android.util.Log;

/**
 * Created by idnert on 2015-09-24.
 */
public class IncomeBudget {

    private int money;
    private String incomeMoney;
    private String category;
    private String date;
    private String title;


    public IncomeBudget(int money){
        this.money = money;
    }
    public IncomeBudget(int money, String category, String date, String title) {

        this.money = money;
        String incomeMoney = String.valueOf(money);

        this.incomeMoney = incomeMoney;
        this.category=category;
        this.date = date;
        this.title = title;

        Log.d("InCOME", category + " "  + title + " " + incomeMoney);

    }



    public void setMoney(int money) {
        this.money = money;
        String incomeMoney = String.valueOf(money);

    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTitle(String title) {
        this.title = title;
    }

   public void setDate(String date) {
        this.date = date;
    }

   public String getDate() {
        return date;
    }

    public  String getMony(){return incomeMoney;}

    public String getCategory(){return category;}

    public String getTitle(){return  title;}


}
