package com.example.cowin;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

import static com.example.cowin.MainActivity2.yash;

public class MainActivity extends AppCompatActivity {

    static String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());


    public static  String pincode;
     public  static String JSON_URL;




    ListView listView;


    List<Hero> heroList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent=getIntent();
          pincode = intent.getStringExtra(yash);
          JSON_URL="https://cdn-api.co-vin.in/api/v2/appointment/sessions/public/findByPin?pincode="+pincode+"&date="+date;










        listView = (ListView) findViewById(R.id.listView);
        heroList = new ArrayList<>();


        loadHeroList();
    }



    private void loadHeroList() {

        final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);



        progressBar.setVisibility(View.VISIBLE);


        StringRequest stringRequest = new StringRequest(Request.Method.GET, JSON_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        progressBar.setVisibility(View.INVISIBLE);



                        try {

                            JSONObject obj = new JSONObject(response);


                            JSONArray heroArray = obj.getJSONArray("sessions");


                            for (int i = 0; i < heroArray.length(); i++) {

                                JSONObject heroObject = heroArray.getJSONObject(i);


                                Hero hero = new Hero(heroObject.getString("name"),heroObject.getString("center_id"),heroObject.getString("slots"),
                                        heroObject.getString("vaccine"),heroObject.getString("from"),
                                        heroObject.getString("to"),heroObject.getString("date"),heroObject.getString("min_age_limit")
                                ,heroObject.getString("available_capacity"));


                                heroList.add(hero);
                            }


                            ListViewAdapter adapter = new ListViewAdapter(heroList, getApplicationContext());


                            listView.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });


        RequestQueue requestQueue = Volley.newRequestQueue(this);


        requestQueue.add(stringRequest);
    }
}