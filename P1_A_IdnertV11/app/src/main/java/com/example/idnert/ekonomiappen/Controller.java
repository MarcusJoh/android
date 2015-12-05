package com.example.idnert.ekonomiappen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Button;

/**
 * Created by idnert on 2015-09-14.
 */
public class Controller {

   private AddExpences expences;
    private MainActivity mainActivity;
    private Income income;
    private Budget_List budgetList;
    private MainDesign maindesign;
    private AddExpences addexpences;
    private Context context;
    private DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;
    private Button button;
    private IncomeBudget[] incomeBudget;
    private ShowExpences showExpences;
    private Name name;
    //private ShowIncomeList showIncomeList;
    private ShowExpences[] expencesItems;
    private ShowExpences[] items;
    private ExpenceList listOfExpences;  //fragment to show List of expences

    private String []title;
    private String []kategory;

    public Controller(Context context) {
        dbHelper = new DbHelper(context);
    }

    public Controller(MainActivity mainActivity, MainDesign maindesign, Income income, AddExpences addexpences, Budget_List budgetList, Name name, ExpenceList listOfExpences  ) {
        this.mainActivity = mainActivity;
        this.maindesign = maindesign;
        this.income = income;
        this.budgetList = budgetList;
        this.addexpences = addexpences;
        this.name=name;
        this.listOfExpences=listOfExpences;




        dbHelper = new DbHelper(mainActivity);
        this.maindesign.setController(this);
        this.income.setController(this);
        this.addexpences.setController(this);
        this.budgetList.setController(this);
        this.name.setController(this);
        this.listOfExpences.setController(this);






    }

    public void data(int price,String finalday,String day,String category) {
        DbHelper dba = new DbHelper(mainActivity);
        dba.insertExpences(price, finalday, day, category);

    }

    public void setIncomFragmetn() {
        mainActivity.setFragment(addexpences);
    }

    public void setInserIncome() {
        mainActivity.setFragment(income);
    }

   // public void setInserBudgetList() {mainActivity.setFragment(budgetList);}

    public void setMainActivity(){mainActivity.setFragment(maindesign);}
    public void setNew_incomeList(){mainActivity.setFragment(budgetList);}
    public void incomeData(int money, String title, String category, String day) {

        DbHelper dba = new DbHelper(mainActivity);
        dba.insertIncome(money, title, category, day);

    }

/*Shows the total balance of the budget*/

public String showbalance(){
    int banlance;
    banlance = dbHelper.totalBalance();
    String totalBalance = String.valueOf(banlance);
    return totalBalance;
}
    public  String totalIncome(){
        int total;
        total = dbHelper.totalIncome();
        String totalIncome = String.valueOf(total);
        return totalIncome;
    }
    public  String totalExpence(){
        int total;
        total = dbHelper.expencesTotal();
        String totalExpence = String.valueOf(total);
        return totalExpence;
    }
/*Shows the expences list*/
   public ShowExpences[] fetchExpencesList(){

        expencesItems = dbHelper.getExpences();


           Log.d("Expence", expencesItems.toString());

        return expencesItems;
    }


   public void setNameFragment() {mainActivity.setFragment(new NameFragment());}

    public void setShowExpences() {mainActivity.setFragment(new ExpenceList());}

    /* Shows the income budget*/
    public IncomeBudget[] fetchIncomeList() {
      incomeBudget=dbHelper.getIncome();
        return  incomeBudget;
    }
}
