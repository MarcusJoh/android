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
public class Income extends Fragment {
    private Controller controller;
    private Button btnSave;
    private EditText incomeCategory;
    private EditText income;
    private EditText date;
    private EditText incomeTitle;


    public Income() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_income2, container, false);



        incomeCategory = (EditText)view.findViewById(R.id.edInputIncome);
        income =(EditText)view.findViewById(R.id.edIncome);
        date = (EditText)view.findViewById(R.id.edIncomeDate);
        incomeTitle = (EditText)view.findViewById(R.id.edTitleIncome);

        btnSave = (Button)view.findViewById(R.id.btnSaveIncome);
        btnSave.setOnClickListener(new SaveIncome());


        return view;
    }


    public void setController(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void onPause() {

        super.onPause();



    }


    private class SaveIncome implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            String newIncome = income.getText().toString();
            int finalIncome = Integer.parseInt(newIncome);

            String category = incomeCategory.getText().toString();

            String title = incomeTitle.getText().toString();

            String newDate = date.getText().toString();

            controller.incomeData(finalIncome, title, category, newDate);

        }
    }
    private class Back implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setMainActivity();}
    }
}
