package com.example.idnert.ekonomiappen;


import android.app.Activity;
import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainDesign extends Fragment implements View.OnClickListener {
    public static final String userPref = "name";
    private Controller controller;
    private Button insertExpences;
    private Button inserIncome;
    private Button insertBudgetList;
    private Button fetchExpences;
    private TextView tvName;
    private EditText edUserName;
    private Button saveUserName;
    private Button viewUserName;
    private TextView mainBudget;
    private TextView tvMoneyLeft;
    private TextView showMonyLeft;
    private TextView tvTotalIncom;
    private TextView tvTotalExpence;
    private TextView showBudgetMain;
    private String balanceBudget;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Button back;




    public MainDesign() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=  inflater.inflate(R.layout.fragment_main_design, container, false);

        initContent(view);



    //    registerListeners();

                return view;
    }

public void initContent(View view){


    insertExpences = (Button)view.findViewById(R.id.btnInsertExpences);
    insertExpences.setOnClickListener(new OpenFragment());

    inserIncome = (Button)view.findViewById(R.id.btnIncome);
    inserIncome.setOnClickListener(new InserIncome());

    insertBudgetList = (Button)view.findViewById(R.id.btnBudgetList);
    insertBudgetList.setOnClickListener(new InsertBudget());

    fetchExpences = (Button)view.findViewById(R.id.btnListExpences);
    fetchExpences.setOnClickListener(new ShowExpenceList());

    //tvMoneyLeft = (TextView) view.findViewById(R.id.showMonyLeft);
   // tvMoneyLeft.setText(controller.showbalance());

    tvTotalIncom  = (TextView) view.findViewById(R.id.showTotalIncome);
    tvTotalIncom.setText(controller.totalIncome());

    tvTotalExpence = (TextView) view.findViewById(R.id.showTotalExpences);
    tvTotalExpence.setText(controller.totalExpence());
    mainBudget=(TextView)view.findViewById(R.id.mainBudget);

    showMonyLeft = (TextView)view.findViewById(R.id.showMoney);
    //showBudgetMain = (TextView) view.findViewById(R.id.showBudgetMain);


    tvName = (TextView)view.findViewById(R.id.tvName);
    String name=MainActivity.getPref("myKey",getActivity().getApplicationContext());
     if(name!=null||name!=""){

    tvName.setText(name);
     }

    edUserName= (EditText)view.findViewById(R.id.edSaveName);

    saveUserName=(Button)view.findViewById(R.id.btnSaveName);


    viewUserName=(Button)view.findViewById(R.id.btnViewName);

    saveUserName.setOnClickListener(this);
    viewUserName.setOnClickListener(this);



}


    public void setController(Controller controller) {
        this.controller = controller;

    }

    @Override
    public void onClick(View v) {

        if (    v.getId()==R.id.btnSaveName){

           String name=edUserName.getText().toString();

            SharedPreferences sharedPreferences = getActivity().getSharedPreferences("name", Activity.MODE_PRIVATE);

            SharedPreferences.Editor editor= sharedPreferences.edit();
            Log.d("testaNamn", name);
            editor.putString("userName", name);
            editor.commit();
///////////// ny kod
            MainActivity.putPref("myKey", name, getActivity().getApplicationContext());

            tvName.setText(name);
//////////////
        } else {

          controller.setNameFragment();

        }

    }



    @Override
    public void onPause() {

        super.onPause();


    }

    private class OpenFragment implements View.OnClickListener {
        @Override
        public void onClick(View v) {

        controller.setIncomFragmetn();

        }
    }

    private class InserIncome implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            controller.setInserIncome();
        }
    }

    private class InsertBudget implements View.OnClickListener {
        @Override
        public void onClick(View v) {controller.setNew_incomeList();}
    }

    private class ShowExpenceList implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setShowExpences();}
    }
    private class Back implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setMainActivity();}
    }
}
