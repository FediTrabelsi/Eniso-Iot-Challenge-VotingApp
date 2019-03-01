package projects.solo.fedi.trabelsi.votingapp.Login;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import projects.solo.fedi.trabelsi.votingapp.Teams.Teams;

public class Login {
    public static String sessionId;
    public static String id;
    public static String iconurl;
    public static String username;
    public   static String password;


    public static void login(final String u , final String p, RequestQueue mQueue,  final Context context){
        final String url1 = "http://eniso.info/ws/core/login/"+u+"?password="+p+"";


        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, url1, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                         /*   Intent i = new Intent(getApplicationContext(),Groupes.class);
                            startActivity(i);*/
                            JSONObject res = response.getJSONObject("$1");

                            String ustid = res.getString("userId");
                            id=ustid;
                            String Name=res.getString("userFullName");
                            username=Name;
                            String profileimg=res.getString("iconURL");
                            iconurl="http://eniso.info/fs"+profileimg;
                            String sessioniD = res.getString("sessionId");
                            sessionId="JSESSIONID="+sessioniD;


                            Intent intent= new Intent(context, Teams.class);
                            context.startActivity(intent);





                        } catch (JSONException e) {
                            try {
                                JSONObject res1 = response.getJSONObject("$error");
                                String m = res1.getString("message");


                            } catch (JSONException a) {


                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                         }
        }){

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Cookie", "JSESSIONID="+sessionId);
                return params;
            }
        };





        mQueue.add(request);

    }


}

