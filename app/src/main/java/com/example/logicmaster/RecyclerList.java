package com.example.logicmaster;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerList extends AppCompatActivity {

    private Integer[] myPicturesList = {R.drawable._2x2_b, R.drawable._2x2_b_prim, R.drawable._2x2_d, R.drawable._2x2_d_prim, R.drawable._2x2_f, R.drawable._2x2_f_prim,
    R.drawable._2x2_l,  R.drawable._2x2_l_prim, R.drawable._2x2_r, R.drawable._2x2_r_prim, R.drawable._2x2_u, R.drawable._2x2_u_prim};
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        ArrayList<ExampleItem> exampleList = new ArrayList<>();



        for (int i:myPicturesList){
            exampleList.add(new ExampleItem(i, "Position_"+i, "File name: "+getResources().getResourceName(i)));
        }

        mRecyclerView = findViewById(R.id.recyclerView);
        //mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new ExampleAdapter(exampleList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }
}
