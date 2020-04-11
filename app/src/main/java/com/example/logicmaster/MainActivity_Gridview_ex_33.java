package com.example.logicmaster;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;

public class MainActivity_Gridview_ex_33 extends Activity {
    private int[] listForGridView = {R.drawable._2x2_b, R.drawable._2x2_b_prim, R.drawable._2x2_d, R.drawable._2x2_d_prim, R.drawable._2x2_f, R.drawable._2x2_f_prim,
            R.drawable._2x2_l,  R.drawable._2x2_l_prim, R.drawable._2x2_r, R.drawable._2x2_r_prim, R.drawable._2x2_u, R.drawable._2x2_u_prim};
    GridView simpleGridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_grid_view_ex_33);

        simpleGridView = findViewById(R.id.simpleGridView);
        CustomAdapter_GridView_ex_33 customAdapter_gridView_ex_33 = new CustomAdapter_GridView_ex_33(getApplicationContext(),listForGridView);
        simpleGridView.setAdapter(customAdapter_gridView_ex_33);

    }
}
