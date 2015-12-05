package com.example.idnert.ekonomiappen;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by idnert on 2015-10-08.
 */
//The Adapter to the Expences
public class ExpenceAdapter extends ArrayAdapter <ShowExpences> {
    private LayoutInflater inflater;
    private Controller controller;

    public ExpenceAdapter(Context context,ShowExpences[] objects) {
        super(context, R.layout.expence_row, objects);

     inflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        ImageView imageView;
        TextView money;
        TextView date;
        TextView description;


        if (convertView == null) {
            convertView = (LinearLayout) inflater.inflate(R.layout.expence_row, parent, false);
        }
       imageView =(ImageView)convertView.findViewById(R.id.imageView);
        money = (TextView)convertView.findViewById(R.id.tvShowCost);
       date=(TextView)convertView.findViewById(R.id.tvDate);
        description = (TextView)convertView.findViewById(R.id.tvDescription);




       money.setText(this.getItem(position).getCost());
       date.setText(this.getItem(position).getday());
        description.setText(this.getItem(position).getDescription());

        String category = this.getItem(position).getCategory();
        if(category == null) {
            Log.d("catergory", "KATERGORI null");
        }


        else if (category.equals("Activity")){
            imageView.setImageResource(R.drawable.icon_activity);
        }
        else if (category.equals("Food")){
                imageView.setImageResource(R.drawable.icon_food);
            }
            else if (category.equals("Living")){
                imageView.setImageResource(R.drawable.icon_living);

            }else if (category.equals("Remaining")){

                imageView.setImageResource(R.drawable.icon_remainging);

            }else if (category.equals("Transport")){

                imageView.setImageResource(R.drawable.icon_transport);
            }
        return convertView;

    }


}
