package com.example.idnert.ekonomiappen;


import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    Controller controller;
    private AddExpences expences;
    private Income income;
    private FragmentManager fm;
    private FragmentTransaction ft;
    private MainDesign mainDesign;
    private Budget_List budgetList;
    private Name name;
    private ExpenceList listOfExpences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mainDesign = new MainDesign();
        income = new Income();
        expences = new AddExpences();
        budgetList = new Budget_List();
        name = new Name();
        listOfExpences = new ExpenceList();

        fm = getFragmentManager();
        ft = fm.beginTransaction();

        InitComponent();
        controller = new Controller(this, mainDesign, income, expences, budgetList, name, listOfExpences );




        if (savedInstanceState==null) {
            setFragment(mainDesign);
        }



    }

    public void setFragment(Fragment fragment) {
        ft = fm.beginTransaction();

        ft.replace(R.id.content, fragment);


        ft.commit();                                         //End transaction

    }

       private void InitComponent(){



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
          Intent refresh= new Intent(this, MainActivity.class);
            startActivity(refresh);
            this.finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


//screan rotation
    public static void putPref(String key, String value, Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getPref(String key, Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getString(key, null);
    }
}
