package com.example.gnassar_subbook;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by firew on 2018-01-31.
 */

/**
 * This class represents a custom adapter object created to be part of a linear layout
 *
 * Citation: https://www.journaldev.com/10416/android-listview-with-custom-adapter-example-tutorial
 * Citation: https://developer.android.com/reference/android/widget/LinearLayout.html
 */

public class SubAdapter extends ArrayAdapter<Subscriptions> {
    public SubAdapter(Context context, ArrayList<Subscriptions> subscriptions){
        super(context, R.layout.sub_adapter, subscriptions);
    }
    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater in_Flate = LayoutInflater.from(getContext());
        @SuppressLint("ViewHolder") final View data = in_Flate.inflate(R.layout.sub_adapter, parent, false);

        String subscriptionName = getItem(pos).getSubName();
        String subscriptionDate = getItem(pos).getSubDate();
        float subscriptionCost = getItem(pos).getSubCost();
        String subscriptionComment = getItem(pos).getSubComment();

        TextView sub_name = (TextView) data.findViewById(R.id.displayName);
        TextView sub_date = (TextView) data.findViewById(R.id.displayDate);
        TextView sub_cost = (TextView) data.findViewById(R.id.displayCost);
        TextView sub_comment = (TextView) data.findViewById(R.id.displayComment);

        LinearLayout editClick = (LinearLayout) data.findViewById(R.id.display_main);

        sub_name.setText(subscriptionName);
        sub_date.setText(subscriptionDate);
        String sub_cost_string = String.valueOf(subscriptionCost);
        sub_cost.setText(sub_cost_string);
        sub_comment.setText(subscriptionComment);

        /**
         * Clicking on an adapter object at position pos will call the function editSubscription
         */
        editClick.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                editSubscription(pos);
            }
        });
        return data;
    }

    /**
     * Function to switch interfaces to edit existing subscription using intent
     * @param pos is the position of the adapter in an array
     */
    public void editSubscription(int pos){
        Intent intent = new Intent(getContext(), editInformation.class);
        Log.v("HERE is my position", String.valueOf(pos));
        intent.putExtra("Sub_Index", String.valueOf(pos));
        ((Activity)getContext()).startActivityForResult(intent, 0);

    }

}