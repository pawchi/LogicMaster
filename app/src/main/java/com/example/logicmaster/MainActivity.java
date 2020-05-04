package com.example.logicmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button1, button2,button3,button4, button5, button6, button7, button8, button9, button10, button11, button12;
    ImageView img1, img2, img3, img4;
    private int img1Temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        button10 = findViewById(R.id.button10);
        button11= findViewById(R.id.button11);
        button12= findViewById(R.id.button12);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        button10.setOnClickListener(this);
        button11.setOnClickListener(this);
        button12.setOnClickListener(this);


        img1 = findViewById(R.id.image_1);
        img2 = findViewById(R.id.image_2);
        img3 = findViewById(R.id.image_3);
        img4 = findViewById(R.id.image_4);

        img1.setImageResource(R.drawable.img_1);
        img2.setImageResource(R.drawable.img_2);
        img3.setImageResource(R.drawable.img_1);
        img4.setImageResource(R.drawable.img_2);


        Log.i("MainActivity", "onCreate");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                img1.setImageResource(R.drawable.img_1_bis);
                img1Temp = R.drawable.img_1_bis;
                break;
            case R.id.button2:
                img2.setImageResource(R.drawable.img_2_bis);
                break;
            case R.id.button3:
                img3.setImageResource(R.drawable.img_1_bis);
                break;
            case R.id.button4:
                img4.setImageResource(R.drawable.img_2_bis);
                break;
            case R.id.button5:
                startActivity(new Intent(getApplicationContext(), RecyclerList.class));
                break;
            case R.id.button6:
                startActivity(new Intent(getApplicationContext(), MainActivity_Gridview_ex_33.class));
                break;
            case R.id.button7:
                startActivity(new Intent(getApplicationContext(), SimpleListView.class));
                break;
            case R.id.button8:
                startActivity(new Intent(getApplicationContext(), Payment.class));
                break;
            case R.id.button9:
                startActivity(new Intent(getApplicationContext(), HTTP_Get.class));
                break;
            case R.id.button10:
                startActivity(new Intent(getApplicationContext(), TicTacToe.class));
                break;
            case R.id.button11:
                startActivity(new Intent(getApplicationContext(), Skoczek.class));
                break;
            case R.id.button12:
                startActivity(new Intent(getApplicationContext(), Skoczek2.class));
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("saved_img1", img1Temp);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.i("MainActivity", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy");
    }
}
