package projects.solo.fedi.trabelsi.votingapp.Teams;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import java.util.ArrayList;

import projects.solo.fedi.trabelsi.votingapp.Login.Login;
import projects.solo.fedi.trabelsi.votingapp.R;

public class Teams extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<TeamModel> mlist;
    Context mcontext;
    Adapter mAdapter;
    TextView indi;

    android.support.v7.widget.Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);
        toolbar= findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Teams List");
        mcontext=getApplicationContext();
        rv=findViewById(R.id.rv);
        indi= findViewById(R.id.indi);
        Spannable word = new SpannableString("Welcome Mr "+ Login.username);
        word.setSpan(new RelativeSizeSpan(2f), 0,word.length(), 0);
        word.setSpan(new ForegroundColorSpan(Color.DKGRAY), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        indi.setText(word);
        indi.append("\n\nBenheath your will find all the teams that previously presented their projects.");
        indi.append(" In order to crown a winner, u can select each time a team, evaluate their works");
        indi.append(" based on a set of criterias and commit to send your evaluation to our server to determine the rankings.");

        mlist=new ArrayList<>();
        mlist.add(new TeamModel("A","Eniso","1","c"));
        mlist.add(new TeamModel("B","Eniso","2","c"));
        mlist.add(new TeamModel("C","Eniso","3","c"));
        mlist.add(new TeamModel("D","Eniso","4","c"));
        mlist.add(new TeamModel("E","Eniso","5","c"));
        mlist.add(new TeamModel("F","Ensi","6","c"));
        mAdapter = new Adapter(mcontext, mlist);
        rv.setAdapter(mAdapter);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplication());
        rv.setLayoutManager(layoutManager);


        mAdapter.notifyDataSetChanged();

    }
}
