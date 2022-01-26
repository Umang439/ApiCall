package com.example.apicall;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListReciver extends AppCompatActivity {

    private ArrayList<PostResponse>postResponseArrayList;
    private ReadApiCall readApiCall;
    private ListView lv;
    private String BaseUrl="https://jsonplaceholder.typicode.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_reciver);

        lv=findViewById ( R.id.lst1 );
       postResponseArrayList=new ArrayList<> ();
        //create a method
        displayRetrofitData();


    }
     private void displayRetrofitData(){
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        readApiCall = retrofit.create(ReadApiCall.class);
        Call<ArrayList<PostResponse>>arrayListCall=readApiCall.getPosts();
        arrayListCall.enqueue(new Callback<ArrayList<PostResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<PostResponse>> call, Response<ArrayList<PostResponse>> response) {
                postResponseArrayList=response.body();
                for (int i= 0;i<postResponseArrayList.size();i++) {
                    ;
                }
                Custom custom = new Custom(postResponseArrayList,ListReciver.this,R.layout.singleview);
//                Log.d(TAG, "onResponse: ");
                lv.setAdapter((ListAdapter) custom);
            }

            @Override
            public void onFailure(Call<ArrayList<PostResponse>> call, Throwable t) {
                Toast.makeText ( ListReciver.this, "Failed to load data", Toast.LENGTH_SHORT ).show ();
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}