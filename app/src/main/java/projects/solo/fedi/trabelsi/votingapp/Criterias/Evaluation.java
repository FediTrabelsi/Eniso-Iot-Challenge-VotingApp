package projects.solo.fedi.trabelsi.votingapp.Criterias;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

import projects.solo.fedi.trabelsi.votingapp.R;
import projects.solo.fedi.trabelsi.votingapp.Teams.Adapter;
import projects.solo.fedi.trabelsi.votingapp.Teams.TeamModel;

public class Evaluation extends AppCompatActivity {
    Toolbar toolbar;
    ImageView img;
    Button submit;
    RecyclerView rv;
    ArrayList<Criteria> mlist;
    Context mcontext;
    EditText e1,e2,e3,e4,e5,e6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluation);
        toolbar= findViewById(R.id.toolbareval);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Evaluation Menu");
        img=findViewById(R.id.photo);
        img.setImageResource(Adapter.src);
        mcontext=getApplicationContext();
        e1=findViewById(R.id.valeur);
        e2=findViewById(R.id.valeur2);
        e3=findViewById(R.id.valeur3);
        e4=findViewById(R.id.valeur4);
        e5=findViewById(R.id.valeur5);
        e6=findViewById(R.id.valeur6);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String t1,t2,t3,t4,t5,t6;
                t1=e1.getText().toString();
                t2=e2.getText().toString();
                t3=e3.getText().toString();
                t4=e4.getText().toString();
                t5=e5.getText().toString();
                t6=e6.getText().toString();
            }
        });

        mlist=new ArrayList<>();
        mlist.add(new Criteria("Innovative Idea","","Score"));
        mlist.add(new Criteria("Presentation & Design","","Score"));
        mlist.add(new Criteria("Marketing Arguments","","Score"));
        mlist.add(new Criteria("Business plan","","Score"));
        mlist.add(new Criteria("Intelligent","","Score"));
        mlist.add(new Criteria("Enegrgetic & Embedded feachers","","Score"));


    }
}
