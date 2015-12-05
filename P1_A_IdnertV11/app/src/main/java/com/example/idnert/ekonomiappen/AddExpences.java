package com.example.idnert.ekonomiappen;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddExpences  extends Fragment  {
    private MainActivity activity;
    private Button saveExpences;
    private EditText cost;               //Price of the expences
    private EditText date;              // Date of the expence
    private EditText description;       // Name of expence
    private EditText category;
    private Controller controller;
    private Bundle bundle = new Bundle();
    private int userSelection=0;
    private static String USER_SELECTION = "USER_SELECTION";
    private int selection;


    public AddExpences( ) {
        // Required empty public constructor
    }
    @Override
    public  void onCreate(android.os.Bundle savedInstanseSate){
        super.onCreate(savedInstanseSate);
        setRetainInstance(true);
        if(savedInstanseSate !=null){
            userSelection = savedInstanseSate.getInt(USER_SELECTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             android.os.Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_expences, container, false);
        cost = (EditText)view.findViewById(R.id.inputPrice);                            ///Saves the price from the user

        date= (EditText)view.findViewById(R.id.inputDate);                              ///Saves date from the user

        description=(EditText)view.findViewById(R.id.inputItem);                        ///Saves the description from the user

        category=(EditText)view.findViewById(R.id.edCategory);

        saveExpences = (Button)view.findViewById(R.id.btnSave);
        saveExpences.setOnClickListener(new addExpences());


        return view;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }


    private class  addExpences implements View.OnClickListener {
        @Override
        public void onClick(View view) {

         String day = date.getText().toString();                                        ///Convert the input from the user to an int


         String info = description.getText().toString();

            String price = cost.getText().toString();                                   ///Convert user input to a int
            int finalPrice = Integer.parseInt(price);

            String chooseCategory = category.getText().toString();

            controller.data(finalPrice,day,info,chooseCategory);

        }

    }
    private class Back implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setMainActivity();}
    }



}


