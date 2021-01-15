package com.example.projectcompany.storage;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.projectcompany.models.User;

public class SharedPreManager {

    private static final String SHARED_PREF_NAME= "my_shared_preff";

    private static SharedPreManager mInstance;
    private Context mCtx;

    private SharedPreManager(Context mCtx)
    {
        this.mCtx=mCtx;
    }

    public static synchronized  SharedPreManager getInstance(Context mCtx)
    {
        if(mInstance == null)
        {
            mInstance= new SharedPreManager(mCtx);
        }
        return mInstance;
    }

    public void saveUser(User user)
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putInt("id", user.getId());
        editor.putString("firstname",user.getFirstname());
        editor.putString("lastname",user.getLastname());
        editor.putString("emailid",user.getEmailid());
        editor.putString("address",user.getAddress());
        editor.putString("gender",user.getGender());
        editor.putString("birthdate",user.getBirthdate());
        editor.putInt("mobileno",user.getMobileno());
        editor.putString("password",user.getPassword());
        editor.putString("confirmpassword",user.getConfirmpassword());


        editor.apply();
    }

    public boolean isLoggedIn()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return sharedPreferences.getInt("id",-1) != -1;
    }

    public User getUser()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        return new User(
                sharedPreferences.getInt("id",-1),
                sharedPreferences.getString("firstname",null),
                sharedPreferences.getString("lastname",null),
                sharedPreferences.getString("emailid",null),

                sharedPreferences.getString("address",null),
                sharedPreferences.getString("gender",null),
                sharedPreferences.getString("birthdate",null),

                sharedPreferences.getString("profile",null),
                sharedPreferences.getInt("mobileno",-1),
                sharedPreferences.getString("password",null),
                sharedPreferences.getString("confirmpassword",null)

        );
    }

    public void clear()
    {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
