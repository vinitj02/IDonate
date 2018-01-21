package com.androidprojects.vinit.idonate.server;

/**
 * Created by vaibhav on 20/1/18.
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

public class sendOtp {
    private JSONObject jsonObject;
    private Context context;

    public sendOtp(Context context){
        this.jsonObject=new JSONObject();
        this.context=context;

    }

    public void send() throws JSONException {
        String url = "http://192.168.137.241:8000/register/otp/";
        jsonObject.put("number","7017001398");
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.POST, url, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String sent=response.get("sent").toString();

                    /*
                    here will come what to do after otp is
                    successfully sent (i.e sent="Y")

                     */


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