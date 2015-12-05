package com.example.idnert.ekonomiappen;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class NameFragment extends android.app.Fragment {
    private TextView tvMoneyLeft;
    private Controller controller;
    public NameFragment() {
    }
    public void setController(Controller controller) {
        this.controller = controller;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_name, container, false);

        TextView tvName = (TextView) v.findViewById(R.id.tvName);

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Activity.MODE_PRIVATE);

        String name = sharedPreferences.getString("userName", "Inget namn");
        Log.d("noName", name);

        tvName.setText(name);
        tvMoneyLeft = (TextView) v.findViewById(R.id.showMonyLeft);
        //Här är de problemet att aktiviteten inte kan prata med kontrollern
        String money=null;

     //   tvMoneyLeft.setText(controller.showbalance());
    return  v;

}

}


