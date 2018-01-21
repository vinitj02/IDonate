package com.androidprojects.vinit.idonate.server;

/**
 * Created by vaibhav on 21/1/18.
 */
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vaibhav on 31/3/17.
 */

public class checkUser {
    private JSONObject jsonObject;
    private Context context;

    public checkUser(Context context,JSONObject jsonObject){
        this.jsonObject=jsonObject;
        this.context=context;
    }



    public void send() throws JSONException {
        String url = "http://192.168.137.241:8000/register/check/";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Toast.makeText(context,response.get("found").toString(),Toast.LENGTH_LONG).show();
                    /*

                    here will come what to do after successfull
                    checking if user exist or not


                     */


                    //context.sendBroadcast(new Intent("update_view_sent").putExtra("timestamp",jsonObject.get("timestamp").toString()).putExtra("message",jsonObject.get("message").toString()));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded");
                return params;
            }
        };

        Volley.newRequestQueue(context).add(jsonObjectRequest);

    }
}