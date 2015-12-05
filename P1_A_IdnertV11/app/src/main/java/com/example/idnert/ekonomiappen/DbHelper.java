package com.example.idnert.ekonomiappen;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

/**
 * Created by idnert on 2015-09-16.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME= "BUDGETINFO_DB";
    public static final int DATABASE_VERTION = 9;


    public static final String TABLE_NAME = "INCOME";
    public static final String COLUMN_MONEY = "MONEY";
    public static final String COLUMN_DATE_INCOME = "DATE";
    public static final String COLUMN_TITLE_INCOME = "TITLE";
    public static final String COLUMN_CATEGORY_INCOME = "CATEGORY";

    //Expencelist
    public static final String TABLE_NAMEB= "BUDGET";
    public static final String COLUMN_COST = "PRICE";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_EXPENCE = "EXPENCE";
    public static final String COLUMN_CATEGORY =  "CATEGORY" ;

    //Here the table for Expences
    public static final String CREATE_QUERY="CREATE TABLE "+TABLE_NAMEB+"("+COLUMN_COST+" integer, "+COLUMN_DATE+" text, "+COLUMN_EXPENCE+" text, "+COLUMN_CATEGORY+" text);";


    //Table for the Income
    public static final String CREATE_QUERY_INCOME="CREATE TABLE "+TABLE_NAME+"("+COLUMN_MONEY+" integer, "+COLUMN_TITLE_INCOME+" text, "+COLUMN_CATEGORY_INCOME+" text, "+COLUMN_DATE_INCOME+" text);";


   public DbHelper(Context context){
       super(context, DATABASE_NAME, null, DATABASE_VERTION);       //Creating the database
       Log.d("DatebaseOperation", "Datebase is open...");           //Logging the creation of the database

   }
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);                                  // Creating the database table
        db.execSQL(CREATE_QUERY_INCOME);                           // Creating table for Income

        Log.d("debug", "Table done");                              // Logging the creation of the Tables
    }

    //Input of the expences

    public void insertExpences(int price, String date, String description, String category){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_COST, price);
        contentValues.put(COLUMN_DATE, date);
        contentValues.put(COLUMN_EXPENCE, description);
        contentValues.put(COLUMN_CATEGORY,category);

        db.insert(TABLE_NAMEB, null, contentValues);
        Log.d("Value update Expences", "Value is update");               // Logging the creation of the value input
    }
//Input of Income
    public void insertIncome(int money, String category, String title, String date){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_MONEY, money);
        contentValues.put(COLUMN_CATEGORY_INCOME, category);
        contentValues.put(COLUMN_TITLE_INCOME, title);
        contentValues.put(COLUMN_DATE_INCOME, date);

        db.insert(TABLE_NAME, null, contentValues);
        Log.d("TableValue for Incom", "Income is update");


    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public int totalBalance() {
        int money,  incomeTotal=0, expences, expencesTotal=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String [] income = new String[]{COLUMN_MONEY};//Recives the value from the database

        Cursor cursor = db.query(TABLE_NAME, income, null, null, null, null, null);


        if(cursor.getCount() > 0) {
            cursor.moveToFirst();


            money = cursor.getColumnIndex(COLUMN_MONEY);
            do
                incomeTotal += cursor.getInt(money); //Sum up the expence values.
            while (cursor.moveToNext());
        }

        String [] incomeExpences = new String[]{COLUMN_COST};//Recives the value from the database

        Cursor cursorE = db.query(TABLE_NAMEB, incomeExpences, null, null, null, null, null);


        if(cursorE.getCount() > 0) {
            cursorE.moveToFirst();


            expences = cursorE.getColumnIndex(COLUMN_COST);
            do
                expencesTotal += cursorE.getInt(expences); //Sum up the expence values.
            while (cursorE.moveToNext());
        }


        return incomeTotal - expencesTotal;
        }

public int totalIncome(){

    int money,  incomeTotal=0;
    SQLiteDatabase db = this.getReadableDatabase();
    String [] income = new String[]{COLUMN_MONEY};//Recives the value from the database

    Cursor cursor = db.query(TABLE_NAME, income, null, null, null, null, null);


    if(cursor.getCount() > 0) {
        cursor.moveToFirst();


        money = cursor.getColumnIndex(COLUMN_MONEY);
        do
            incomeTotal += cursor.getInt(money); //Sum up the expence values.
        while (cursor.moveToNext());
    }
    return incomeTotal;
}

    public int expencesTotal(){
        int expences, expencesTotal=0;
        SQLiteDatabase db = this.getReadableDatabase();
        String [] incomeExpences = new String[]{COLUMN_COST};//Recives the value from the database

        Cursor cursorE = db.query(TABLE_NAMEB, incomeExpences, null, null, null, null, null);


        if(cursorE.getCount() > 0) {
            cursorE.moveToFirst();


            expences = cursorE.getColumnIndex(COLUMN_COST);
            do
                expencesTotal += cursorE.getInt(expences); //Sum up the expence values.
            while (cursorE.moveToNext());
        }


        return expencesTotal;
    }


   public IncomeBudget[] getIncome() {
       int money, category, title, date;
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("SELECT  * FROM INCOME", null);

       IncomeBudget[] income = new IncomeBudget[cursor.getCount()];

       money = cursor.getColumnIndex(COLUMN_MONEY);
       category = cursor.getColumnIndex(COLUMN_CATEGORY_INCOME);
       title = cursor.getColumnIndex(COLUMN_TITLE_INCOME);
       date = cursor.getColumnIndex(COLUMN_DATE_INCOME);

       for (int i = 0; i < income.length; i++) {

           cursor.moveToPosition(i);
           income[i] = new IncomeBudget(cursor.getInt(money),
                   cursor.getString(category),
                   cursor.getString(title),
                   cursor.getString(date));

           Log.d("TableValue for Expences", "Expences is update");
       }
       return income;

   }


    public ShowExpences[] getExpences() {
        int price, date, description, category;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAMEB, null);

        ShowExpences[] cost = new ShowExpences[cursor.getCount()];

        price = cursor.getColumnIndex(COLUMN_COST);
        date = cursor.getColumnIndex(COLUMN_DATE);
        description = cursor.getColumnIndex(COLUMN_EXPENCE);
        category = cursor.getColumnIndex(COLUMN_CATEGORY);



        for (int i = 0; i < cost.length; i++) {

            cursor.moveToPosition(i);
            cost[i] = new ShowExpences(cursor.getInt(price),
                    cursor.getString(date),
                    cursor.getString(description),
            cursor.getString(category));

            Log.d("TableValue for Expences", "Expences is update");
        }
        return cost;
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAMEB);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME);
        onCreate(db);
    }


}
