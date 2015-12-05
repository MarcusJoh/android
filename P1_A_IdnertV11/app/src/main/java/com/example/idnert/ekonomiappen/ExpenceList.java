package com.example.idnert.ekonomiappen;

import android.app.Activity;
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

/**
 * A fragment representing a list of Items.
 * <p/>
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnFragmentInteractionListener}
 * interface.
 */
public class ExpenceList extends Fragment implements AbsListView.OnItemClickListener {

    private Controller controller;
    private ExpenceAdapter expenceAdapter;
    private ShowExpences showExpences;

    Context applicationContext ;
    private OnFragmentInteractionListener mListener;

    /**
     * The fragment's ListView/GridView.
     */
    private AbsListView mListView;

    /**
     * The Adapter which will be used to populate the ListView/GridView with
     * Views.
     */
    private ListAdapter mAdapter;



    public ExpenceList() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_expencelist_list, container, false);

        // Set the adapter
        mListView = (AbsListView) view.findViewById(R.id.liExpences);
        if (controller == null) {
            controller = new Controller(getActivity());
        }
        mAdapter = new ExpenceAdapter(getActivity(), controller.fetchExpencesList());





        mListView.setAdapter(mAdapter);

        // Set OnItemClickListener so we can be notified on item clicks
        mListView.setOnItemClickListener(this);







        return view;
    }


    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

 /*   @Override
    public void onItemClick(AdapterView parent, View view, int position, long id) {
        if (null != mListener) {
            Toast.makeText(getApplicationContext(),"position", Toast.LENGTH_LONG).show();
            mListener.onFragmentInteraction(getActivity(), controller.fetchExpencesList());
            Log.d("TostInfo", "Position");
        }

        return;
    }*/



    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
  /*  public void setEmptyText(CharSequence emptyText) {
        View emptyView = mListView.getEmptyView();

        if (emptyView instanceof TextView) {
            ((TextView) emptyView).setText(emptyText);
        }
    }*/
    public void setController(Controller controller) {
        this.controller = controller;
    }
    public Context getApplicationContext() {return applicationContext;}

    /*Click list shows the rest of the information that the user clicks on*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


        TextView date=(TextView)view.findViewById(R.id.tvDate);
        TextView money = (TextView)view.findViewById(R.id.tvShowCost);
        TextView descripton = (TextView)view.findViewById(R.id.tvDescription);
        Toast toast = Toast.makeText(getActivity(), date.getText().toString() + " " + descripton.getText().toString() + " " + money.getText().toString() + " kr", Toast.LENGTH_LONG);

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
    private class Back implements View.OnClickListener {

        @Override
        public void onClick(View v) {controller.setMainActivity();}
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
        public void onFragmentInteraction(Activity activity, ShowExpences[] id);
    }

}
