package com.example.logicmaster;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button button1, button2,button3,button4, button5, button6, button7, button8;
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

        img1 = findViewById(R.id.image_1);
        img2 = findViewById(R.id.image_2);
        img3 = findViewById(R.id.image_3);
        img4 = findViewById(R.id.image_4);

        img1.setImageResource(R.drawable.img_1);
        img2.setImageResource(R.drawable.img_2);
        img3.setImageResource(R.drawable.img_1);
        img4.setImageResource(R.drawable.img_2);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img1.setImageResource(R.drawable.img_1_bis);
                img1Temp = R.drawable.img_1_bis;
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img2.setImageResource(R.drawable.img_2_bis);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img3.setImageResource(R.drawable.img_1_bis);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img4.setImageResource(R.drawable.img_2_bis);
            }
        });

        if (savedInstanceState != null){
            img1Temp = savedInstanceState.getInt("saved_img1");
            img1.setImageResource(img1Temp);
        } else {
            img1 = findViewById(R.id.image_1);
        }

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecyclerList.class));
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity_Gridview_ex_33.class));
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SimpleListView.class));
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Payment.class));
            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("saved_img1", img1Temp);
    }


}
