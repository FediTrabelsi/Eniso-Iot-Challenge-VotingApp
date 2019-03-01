package projects.solo.fedi.trabelsi.votingapp.Teams;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import projects.solo.fedi.trabelsi.votingapp.Criterias.Evaluation;
import projects.solo.fedi.trabelsi.votingapp.R;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context mcontext;
    ArrayList<TeamModel> mliist;
    public static int src;

    public Adapter(Context context,ArrayList<TeamModel> list){
        mliist=list;
        mcontext=context;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater= LayoutInflater.from(mcontext);

        View view= layoutInflater.inflate(R.layout.team_struc,viewGroup,false);
        Adapter.ViewHolder viewHolder= new Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, int i) {
        TeamModel team=mliist.get(i);
        final int pos=i;
        TextView num;
        Button n;
        n=viewHolder.name;
        num=viewHolder.number;

        LayoutInflater inflater = (LayoutInflater)   mcontext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_evaluation, null);
        final ImageView img= view.findViewById(R.id.photo);
        n.setText(team.getTeamname());
        n.append("\nFrom :  "+team.getUniversity());
        num.setText(team.getNumber());
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(pos){
                    case 0 : {
                        src=R.drawable.azert;
                        break;
                    }
                    case 1 : {
                        src=R.drawable.en;
                        break;
                    }
                    case 2 : {
                        src=R.drawable.tab;
                        break;
                    }
                    case 3 : {
                        src=R.drawable.table;
                        break;
                    }
                    case 4 : {
                        src=R.drawable.iconapp;
                        break;
                    }
                    case 5 : {
                        src=R.drawable.a;
                        break;
                    }
                }
                Intent i = new Intent(mcontext, Evaluation.class);
                mcontext.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mliist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView number;
        Button name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.number);
            name=itemView.findViewById(R.id.name);

        }
    }
}
