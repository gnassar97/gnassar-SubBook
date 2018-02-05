package com.example.gnassar_subbook;

import android.annotation.SuppressLint;
import android.app.PictureInPictureParams;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;




public class MainActivity extends AppCompatActivity {
    private ListView viewList;
    private static final String FILENAME = "save_file.sav";
    public static ArrayAdapter<Subscriptions> subscriptionAdapter;
    public static ArrayList<Subscriptions> subscriptions;
    private TextView TotalCost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewList = (ListView) findViewById(R.id.list_view);
    }

    /**
     * onStart loads the savefile if it exists as well as creates the custom adapter list view
     *
     * This function also updates the total cost of all subscriptions on any add or delete
     */
    @SuppressLint("SetTextI18n")
    protected void onStart() {
        super.onStart();
        loadFromFile();
        subscriptionAdapter = new SubAdapter(this, subscriptions);
        viewList.setAdapter(subscriptionAdapter);
        int arrayLength;
        float sumOfCost = 0;
        TotalCost=((TextView)findViewById(R.id.totalCost));
        arrayLength = subscriptions.size();
        for(int i = 0; i < arrayLength; i++){
            sumOfCost += subscriptions.get(i).getSubCost();
        }
        TotalCost.setText("$" + sumOfCost);
    }

    /**
     * Buttonclick createSub in activity_main.xml brings us to the list_information activity
     * @param v is the view
     */
    public void createSub(View v) {
        Intent intent = new Intent(this, list_information.class);
        startActivity(intent);
    }



    /**
     * Taken from lab 3 in CMPUT 301 W18
     */
    private void loadFromFile() {
        try {
            FileInputStream file_input = openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(file_input));

            Gson gson = new Gson();

            Type listType = new TypeToken<ArrayList<Subscriptions>>() {
            }.getType();

            subscriptions = gson.fromJson(in, listType);

        } catch (FileNotFoundException e) {
            subscriptions = new ArrayList<Subscriptions>();
        }

    }
    /**
     * Taken from lab 3 in CMPUT 301 W18
     * @param cont used as context for saving
     */
    public static void saveInFile(Context cont){
        try{
            FileOutputStream file_output = cont.openFileOutput(FILENAME, Context.MODE_PRIVATE);
            BufferedWriter out_put = new BufferedWriter(new OutputStreamWriter(file_output));

            Gson gson = new Gson();

            gson.toJson(subscriptions, out_put);

            out_put.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

