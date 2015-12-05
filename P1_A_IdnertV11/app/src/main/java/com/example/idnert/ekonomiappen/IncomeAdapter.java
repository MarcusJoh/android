package com.example.idnert.ekonomiappen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by idnert on 2015-09-29.
 */
public class IncomeAdapter extends ArrayAdapter <IncomeBudget> {

    private LayoutInflater inflater;


    public IncomeAdapter(Context context, IncomeBudget[] objects) {
        super(context, R.layout.income_list_row, objects);
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }




    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvDate;
        TextView tvCategory;
        TextView tvTitle;
        TextView tvIncome;
        if (convertView == null) {
            convertView = (LinearLayout) inflater.inflate(R.layout.income_list_row, parent, false);
        }
        tvDate = (TextView) convertView.findViewById(R.id.showDate);
        tvCategory = (TextView) convertView.findViewById(R.id.showCategory);
        tvTitle = (TextView) convertView.findViewById(R.id.showTitle);
        tvIncome = (TextView) convertView.findViewById(R.id.showMoney);

        tvDate.setText(this.getItem(position).getDate());
        tvCategory.setText(this.getItem(position).getCategory());
        tvTitle.setText(this.getItem(position).getTitle());
        tvIncome.setText(this.getItem(position).getMony());

        return convertView;

    }
}