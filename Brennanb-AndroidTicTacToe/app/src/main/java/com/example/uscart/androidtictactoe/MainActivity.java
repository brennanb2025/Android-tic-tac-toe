package com.example.uscart.androidtictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    private GameLogic logic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int boardLength = 9;
        logic = new GameLogic(boardLength);

        int[] buttonIDs = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9};
        for (int i = 0; i < buttonIDs.length; i++) {
            Button b = this.findViewById(buttonIDs[i]);
            b.setOnClickListener(new BtnListener());
            b.setTag(i);
        }
        //View v = this.findViewById(buttonIDs[i]);
        //v.setOnClickListener( new BtnListener() );



    }

    private class BtnListener implements View.OnClickListener {
        public void onClick( View v ) {
            Button b = (Button)v;
            ((Button) v).setText("X");
        }

    }

}