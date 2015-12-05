package com.example.idnert.ekonomiappen;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class Budget_List extends Fragment implements AbsListView.OnItemClickListener {


    private Controller controller;
    private OnFragmentInteractionListener mListener;
    private IncomeBudget incomeBudget;
    private IncomeAdapter incomeAdapter;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    private ListAdapter mAdapter;
    private Context applicationContext;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budgetlist, container, false);

        // Set the adapter
       mListView = (AbsListView) view.findViewById(R.id.incomeFetch);
      mAdapter = new IncomeAdapter(getActivity(), controller.fetchIncomeList());




        mListView.setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
      mListView.setOnItemClickListener(this);




     

        return view;
    }


    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        TextView date=(TextView)view.findViewById(R.id.showDate);
        TextView money = (TextView)view.findViewById(R.id.showMoney);
        TextView descripton = (TextView)view.findViewById(R.id.showCategory);
        TextView titel = (TextView)view.findViewById(R.id.showTitle);
        Toast toast = Toast.makeText(getActivity(), titel.getText().toString()+" "+ date.getText().toString() + " " + descripton.getText().toString() + " " + money.getText().toString() + " kr", Toast.LENGTH_LONG);

/* The layout for the toast message */
        view = toast.getView();
        TextView toastMessage = (TextView)view.findViewById(android.R.id.message);
        toastMessage.setTextSize(25);
        toastMessage.setTextColor(Color.GRAY);
        toastMessage.setGravity(Gravity.CENTER_VERTICAL);
        toastMessage.setGravity(Gravity.CENTER_HORIZONTAL);
        toastMessage.setCompoundDrawablePadding(16);
        view.setBackgroundColor(Color.WHITE);
        toast.show();
        Log.d("TostInfo", String.valueOf(position));

    }


    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(String id);
    }
    private class Back implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setMainActivity();}
    }

}
