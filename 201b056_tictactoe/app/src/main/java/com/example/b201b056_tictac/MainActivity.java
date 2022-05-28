package com.example.b201b056_tictac;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int player=1;
    boolean iswinner=false;
    int imageclicked=-1;
    int [][]winningstates={{0,1,2},{3,4,5},{6,7,8}};
    int []gamestate={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v=(ImageView) view;
        int tag=Integer.parseInt(v.getTag().toString());
        imageclicked=gamestate[tag];
        if(iswinner==false && imageclicked==-1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross2);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + " Cross", Toast.LENGTH_SHORT).show();
                player = 0;
            } else {
                v.setImageResource(R.drawable.zero1);
                gamestate[tag] = player;
                Toast.makeText(this, tag + "" + " Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }

            for (int i = 0; i < winningstates.length; i++) {
                if (gamestate[winningstates[i][0]] == gamestate[winningstates[i][1]] && gamestate[winningstates[i][1]] == gamestate[winningstates[i][2]] && gamestate[winningstates[i][0]] > -1) {
                    Toast.makeText(this, "Winner is " + (player == 0 ? 1 : 0), Toast.LENGTH_SHORT).show();
                    iswinner = true;
                }
            }
        }

    }
    public void reset(View view){
        GridLayout gridLayout=findViewById(R.id.gridlayout);
        int total_images=gridLayout.getChildCount();
        for(int i=0;i<total_images;i++)
        {
            ImageView v =(ImageView) gridLayout.getChildAt(i);
            v.setImageDrawable(null);
        }
        iswinner=false;
        player=1;
        imageclicked=-1;
        for(int i=0;i<gamestate.length;i++){
            gamestate[i]=-1;
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}

