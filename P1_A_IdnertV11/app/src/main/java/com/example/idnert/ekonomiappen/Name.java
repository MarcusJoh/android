package com.example.idnert.ekonomiappen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Name extends AppCompatActivity {

    private TextView tvName;
    private Controller controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);


    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

}
