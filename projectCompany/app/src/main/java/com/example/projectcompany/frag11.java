package com.example.projectcompany;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.projectcompany.activities.ProfileActivity;
import com.example.projectcompany.activities.loadingDialog;
import com.example.projectcompany.adapters.UsersAdapter;
import com.example.projectcompany.api.RetrofitClient;
import com.example.projectcompany.models.Alluser;
import com.example.projectcompany.models.User;
import com.example.projectcompany.models.UsersResponse;
import com.github.ybq.android.spinkit.sprite.Sprite;
import com.github.ybq.android.spinkit.style.DoubleBounce;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class frag11 extends Fragment {

    private RecyclerView recyclerView;
    private UsersAdapter adapter;
    ArrayList<Alluser> userList=new ArrayList<>();
    String keys="846012712784601271278460127127";



    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        Log.d("xyz" ,"fragment created ");
        View view = inflater.inflate(R.layout.flag12,container,false);

//        loadingDialog loadingDialog = new loadingDialog(frag11.this);

        return view;


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        recyclerView =view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter=new UsersAdapter(getActivity(), userList, new UsersAdapter.ClickHandler() {
            @Override
            public void onButtonClick(int position) {
                Alluser item = userList.get(position);
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                intent.putExtra("Firstname",item.getFirstname());
                intent.putExtra("Lastname",item.getLastname());
                intent.putExtra("Email",item.getEmailid());
                intent.putExtra("Birthdate",item.getBirthdate());
                intent.putExtra("Gender",item.getGender());
                intent.putExtra("Mobileno",item.getMobileno());
                intent.putExtra("Address",item.getAddress());

                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        Log.d("view Created", "aasxso;kc");

//        Call call= RetrofitClient.getmInstance().getApi().getUsers();
//
//        call.enqueue(new Callback() {
//            @Override
//            public void onResponse(Call call, Response response) {
//
////                String res= response.body().toString();
////
////                Log.d("response",res);
//                if(response.isSuccessful())
//                {
//                    try {
//                        String main = new Gson().toJson(response.body());
//                        JSONObject fi = new JSONObject(main);
//                        JSONArray reson = fi.getJSONArray("responsemsg");
//                       // userList.clear();
//
//                        for(int i=0;i<reson.length();i++)
//                        {
//                            JSONObject jc=reson.getJSONObject(i);
//                            Alluser u = new Alluser();
//                            u.setId(jc.getString("id"));
//                            u.setFirstname(jc.getString("firstname"));
//                            u.setLastname (jc.getString ("lastname"));
//                            u.setEmailid (jc.getString ("emailid"));
//
//                           u.setMobileno (jc.getString ("mobileno"));
//                           // u.setMobileno((int) Long.parseLong(jc.getString ("mobileno").toString()));
//                            u.setAddress (jc.getString ("address"));
//                            u.setPassword (jc.getString ("password"));
//                            u.setGender (jc.getString ("gender"));
//                            u.setBirthdate (jc.getString ("birthdate"));
//                            u.setProfilepic (jc.getString ("profilepic"));
//                            userList.add(u);
//
//                        }
//                        adapter=new UsersAdapter(getActivity(),userList);
//                        recyclerView.setAdapter(adapter);
//
//                    }catch (JSONException e)
//                    {
//                        e.printStackTrace ();
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call call, Throwable t) {
//                Log.d("err",call.toString());
//            }
//        });

        backTask bg = new backTask();
        bg.execute();




    }

    class backTask extends AsyncTask<Void,Void,Void>
    {

        @Override
        protected Void doInBackground(Void... voids) {


//            recyclerView =view.findViewById(R.id.recyclerView);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//            Log.d("view Created", "aasxso;kc");

            Log.d("thread", Thread.currentThread().getName());
            Call call= RetrofitClient.getmInstance().getApi().getUsers();

            call.enqueue(new Callback() {
                @Override
                public void onResponse(Call call, Response response) {

//                String res= response.body().toString();
//
//                Log.d("response",res);
                    if(response.isSuccessful())
                    {
                        try {
                            String main = new Gson().toJson(response.body());
                            JSONObject fi = new JSONObject(main);
                            JSONArray reson = fi.getJSONArray("responsemsg");
                            // userList.clear();

                            for(int i=0;i<reson.length();i++)
                            {
                                JSONObject jc=reson.getJSONObject(i);
                                Alluser u = new Alluser();
                                u.setId(jc.getString("id"));
                                u.setFirstname(jc.getString("firstname"));
                                u.setLastname (jc.getString ("lastname"));
                                u.setEmailid (jc.getString ("emailid"));

                                u.setMobileno (jc.getString ("mobileno"));
                                // u.setMobileno((int) Long.parseLong(jc.getString ("mobileno").toString()));
                                u.setAddress (jc.getString ("address"));
                                u.setPassword (jc.getString ("password"));
                                u.setGender (jc.getString ("gender"));
                                u.setBirthdate (jc.getString ("birthdate"));
                                u.setProfilepic (jc.getString ("profilepic"));
                                userList.add(u);

                            }
                            adapter.notifyDataSetChanged();
                        }catch (JSONException e)
                        {
                            e.printStackTrace ();
                        }

                    }
                }

                @Override
                public void onFailure(Call call, Throwable t) {
                    Log.d("err",call.toString());
                }
            });

            return null;
        }
    }
}
