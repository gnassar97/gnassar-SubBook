package com.example.gnassar_subbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by firew on 2018-01-31.
 */

/**
 * This class represents the creation of a subscription in listview
 */

public class list_information extends AppCompatActivity {
    private String subName;
    private String subDate;
    private String subCost;
    private String subComment;
    private TextView subscriptionName;
    private TextView subscriptionDate;
    private TextView subscriptionCost;
    private TextView subscriptionComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_information);

        Button saveEntry = (Button)findViewById(R.id.saveEntryButton);

        subscriptionName = (TextView) findViewById(R.id.nameText);
        subscriptionDate = (TextView) findViewById(R.id.dateText);
        subscriptionCost = (TextView) findViewById(R.id.costText);
        subscriptionComment = (TextView) findViewById(R.id.commentText);


        /**
         * Save button in this class creates a new subscription object
         */
        saveEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subName = subscriptionName.getText().toString();
                subDate = subscriptionDate.getText().toString();
                subCost = subscriptionCost.getText().toString();
                subComment = subscriptionComment.getText().toString();

                //Create new subscription object
                Subscriptions subscriptions = new Subscriptions(subName,subDate,Float.valueOf(subCost),subComment);
                MainActivity.subscriptions.add(subscriptions);
                MainActivity.subscriptionAdapter.notifyDataSetChanged();
                MainActivity.saveInFile(list_information.this);
                finish();
            }
        });
    }
}
