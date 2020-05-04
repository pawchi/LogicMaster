package com.example.logicmaster;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.common.internal.Objects;

public class Skoczek extends AppCompatActivity {




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skoczek);

        GridLayout gridLayout = findViewById(R.id.gridLayout);
        Button button = new Button(this);
        Button button2 = new Button(this);
        GridLayout.LayoutParams params = new GridLayout.LayoutParams(GridLayout.spec(GridLayout.UNDEFINED,1f), GridLayout.spec(GridLayout.UNDEFINED,1f));
        // The above defines LayoutParameters as not specified Column and Row with grid:layout_columnWeight="1" and grid:layout_rowWeight="1"
        params.width = 0; // Setting width to "0dp" so weight is applied instead
        params.height = 100;

        GridLayout.LayoutParams params2 = new GridLayout.LayoutParams(GridLayout.spec(0), GridLayout.spec(6));
        params2.width = 0;
        params2.height = 100;

//        GridLayout.LayoutParams params = new GridLayout.LayoutParams(GridLayout.spec(row, 1F), GridLayout.spec(column, 1F));
//        params.width = 50;
//        params.height = 50;
        //view.setLayoutParams(params);
        button.setLayoutParams(params);
        button.setText("My dutton");
        button2.setLayoutParams(params2);
        button2.setText("My dutton");
        //gridLayout.addView(button);
        //gridLayout.addView(button2);

        }





//        GridLayout gridLayout = findViewById(R.id.gridLayout);
//        final int MAX_COLUMN = 2; //5
//        Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
//        //final int MAX_ROW = gridLayout.getRowCount();
//        final int MAX_ROW = 2;//7
//        final int itemsCount = MAX_ROW * MAX_COLUMN; //35
//        int row = 0, column = 0;
//
//        for (int i = 0; i < itemsCount; i++) {
//            ImageView view = new ImageView(this);
//            Button button = new Button(this);
//
//            //Just to provide alternate colors
//            if (i % 2 == 0) {
//                view.setBackgroundColor(Color.RED);
//            } else {
//                view.setBackgroundColor(Color.GREEN);
//            }
//
//            GridLayout.LayoutParams params = new GridLayout.LayoutParams(GridLayout.spec(row, 1F), GridLayout.spec(column, 1F));
//            params.width = 50;
//            params.height = 50;
//            view.setLayoutParams(params);
//            gridLayout.addView(view);
//
//            column++;
//
//            if (column >= MAX_COLUMN) {
//                column = 0;
//                row++;
//            }
//        }

}
