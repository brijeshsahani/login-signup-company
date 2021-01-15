package com.example.apiobject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private RequestQueue mQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       textView=findViewById(R.id.showdataid);
        Button button=findViewById(R.id.getdataid);
       textView.setMovementMethod(new ScrollingMovementMethod());

        mQueue = Volley.newRequestQueue(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonparse();
            }
        });
    }

    private void jsonparse()
    {
        String url="http://nilkanthvarniapi.co.in/priyanka/fresherapi/getusers.php";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray=response.getJSONArray("responsemsg");
                            for (int i=0;i<jsonArray.length();i++)
                            {
                                JSONObject items=jsonArray.getJSONObject(i);
                                String ids = items.getString("id");
                                String fnames=items.getString("firstname");
                                String lnames = items.getString("lastname");
                                String emails=items.getString("emailid");
                                String addresss = items.getString("address");
                                String genders=items.getString("gender");
                                String dob = items.getString("birthdate");
                                String mobilenos=items.getString("mobileno");
                                String passwords = items.getString("password");

//                                String[] strs = new String[]{ids,fnames,lnames,emails,addresss,genders,dob,mobilenos,passwords};
//                                ListView listviewuser=findViewById(R.id.listviewuser);
//                                ArrayAdapter<String> listviewadapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,strs);
//                                listviewuser.setAdapter(listviewadapter);

                              textView.append("id ="+ids + "\n fname ="+ fnames +"\n lname =" +lnames+ "\n email =" +emails+ "\n address =" +addresss+ "\n gender =" +genders+ "\ndob =" +dob+" \n mobileno =" +mobilenos+ "\n passowrd =" +passwords+ "\n\n");
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }

        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("key", "846012712784601271278460127127");


                return params;
            }
        };
        mQueue.add(request);
    }
}