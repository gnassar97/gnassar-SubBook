package com.example.gnassar_subbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by firew on 2018-01-31.
 */

/**
 * This class handles the editing of an existing subscription object and the limitations for input
 */

public class editInformation extends AppCompatActivity {
    private int pos;
    private Subscriptions subscription;
    private TextView subscriptionName;
    private TextView subscriptionDate;
    private TextView subscriptionCost;
    private TextView subscriptionComment;
    private String checkName;
    private String checkDate;
    private Float checkCost;
    private String checkComment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);

        Intent intent = getIntent();
        pos = Integer.parseInt(intent.getStringExtra("Sub_Index"));
        subscription = MainActivity.subscriptions.get(pos);

        Button delEntry = (Button) findViewById(R.id.delEntryButton);
        Button saveEntry = (Button) findViewById(R.id.saveEntryButton);

        subscriptionName = (TextView) findViewById(R.id.nameText);
        subscriptionDate = (TextView) findViewById(R.id.dateText);
        subscriptionCost = (TextView) findViewById(R.id.costText);
        subscriptionComment = (TextView) findViewById(R.id.commentText);

        subscriptionName.setText(MainActivity.subscriptions.get(pos).getSubName());
        subscriptionDate.setText(MainActivity.subscriptions.get(pos).getSubDate());
        subscriptionCost.setText(String.valueOf(MainActivity.subscriptions.get(pos).getSubCost()));
        subscriptionComment.setText(MainActivity.subscriptions.get(pos).getSubComment());

        /**
         * Save button click updates and saves variable information to FILENAME
         */
        saveEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkName = subscriptionName.getText().toString();
                checkDate = subscriptionDate.getText().toString();
                checkCost = Float.valueOf(subscriptionCost.getText().toString());
                checkComment = subscriptionComment.getText().toString();

                subscription.setSubName(checkName);
                subscription.setSubDate(checkDate);
                subscription.setSubCost(checkCost);
                subscription.setSubComment(checkComment);
                MainActivity.subscriptionAdapter.notifyDataSetChanged();
                MainActivity.saveInFile(editInformation.this);
                finish();
            }});

        /**
         * Unsubscribe button deletes a subscription and saves the deletion to FILENAME
         */
        delEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.subscriptions.remove(pos);
                MainActivity.subscriptionAdapter.notifyDataSetChanged();
                MainActivity.saveInFile(editInformation.this);
                finish();
            }
        });
    }
}