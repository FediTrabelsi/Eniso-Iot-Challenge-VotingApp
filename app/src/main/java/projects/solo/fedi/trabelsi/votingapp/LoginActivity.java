package projects.solo.fedi.trabelsi.votingapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import projects.solo.fedi.trabelsi.votingapp.Login.Login;
import projects.solo.fedi.trabelsi.votingapp.Teams.Teams;

public class LoginActivity extends AppCompatActivity {
    RelativeLayout relativeLayout;
    Context context;
    RequestQueue mQueue;
    EditText username,password;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context=getApplicationContext();
        mQueue= Volley.newRequestQueue(context);
        relativeLayout= findViewById(R.id.loginrl);
        signin= findViewById(R.id.signin);
        username= findViewById(R.id.username);
        password=findViewById(R.id.password);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usrname,pass;
                usrname=username.getText().toString();
                pass=password.getText().toString();
                //Login.login(usrname,pass,mQueue,context);
                Intent intent= new Intent(context, Teams.class);
                startActivity(intent);
            }
        });
    }
}
