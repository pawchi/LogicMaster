package com.example.logicmaster;

import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Skoczek2 extends AppCompatActivity implements View.OnClickListener {

    public static final int NOT_CLICKED = 0;
    public static final int CLICKED = 1;

    public static final int COLOR_POSSIBLE_MOVE = Color.MAGENTA;
    public static final int COLOR_CLICKED = Color.GREEN;
    public static final int COLOR_NOT_CLICKED = Color.BLUE;

    Map<Integer,Skoczek2_Field> board = new HashMap<>();
    public ArrayList<ArrayList<Integer>> arrayMoves = new ArrayList<>();


    int fieldEmpty = Color.BLUE;



    GridLayout gridLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.skoczek2);

        setListWithPossibleMoves();

        gridLayout = (GridLayout)findViewById(R.id.tableGrid);
        gridLayout.removeAllViews();
        int total = 25;
        int column = 5;
        int row = total / column;
        gridLayout.setColumnCount(column);
        gridLayout.setRowCount(row + 1);
        for(int i =0, c = 0, r = 0; i < total; i++, c++){
            if(c == column){
                c = 0;
                r++;
            }
            TextView textView = new TextView(this);

            GridLayout.LayoutParams param =new GridLayout.LayoutParams();

            param.width = 130;
            param.height = 130;
            //param.rightMargin = 5;
            //param.leftMargin = 5;
            param.topMargin = 5;
            param.setGravity(Gravity.CENTER);
            param.columnSpec = GridLayout.spec(c);
            param.rowSpec = GridLayout.spec(r);
            textView.setLayoutParams(param);
            textView.setBackgroundColor(fieldEmpty);
            textView.setGravity(Gravity.CENTER);
            textView.setOnClickListener(this);
            textView.setText(Integer.toString(i+1));
            textView.setId(i+1);
            gridLayout.addView(textView);
        }

        for (int i=0; i<gridLayout.getChildCount(); i++){
            Skoczek2_Field field = new Skoczek2_Field(NOT_CLICKED,new ArrayList<Integer>(arrayMoves.get(i)));
            board.put(i,field);
        }


        Toast.makeText(this, "Board 0 moves size: " + board.get(7).getPossibleMoves().size() , Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView)findViewById(getResources().getIdentifier(Integer.toString(v.getId()),"id",getPackageName()));
        ColorDrawable textColor = (ColorDrawable) textView.getBackground();
        int viewCell = v.getId();
        int boardField = viewCell-1;

        setCurrentFieldStatus(v);

        Toast.makeText(this, "Get Id :" + v.getId() , Toast.LENGTH_SHORT).show();
        // 1) if status NOT CLICKED
        if (board.get(boardField).getFieldStatus()==NOT_CLICKED){
            board.get(boardField).setFieldStatus(CLICKED);
            v.setBackgroundColor(Color.GREEN);
            showPossibleMoves(v);
        } else {
            AlertDialog alertDialog = new AlertDialog.Builder(Skoczek2.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("To pole jest już kliknięte!!");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
        String possibleValues = "";

        for (int i = 0; i < board.get(boardField).getPossibleMoves().size(); i++){
            possibleValues = possibleValues + board.get(boardField).getPossibleMoves().get(i) + ", ";
        }


    }

    public void setCurrentFieldStatus(View view){

        for (int i=0; i<board.size(); i++){
            if (board.get(i).getFieldStatus()==CLICKED){
                gridLayout.getChildAt(i).setBackgroundColor(COLOR_CLICKED);
            } else {
                gridLayout.getChildAt(i).setBackgroundColor(COLOR_NOT_CLICKED);
            }

        }
    }
    private void showPossibleMoves(View view) {
        int viewCell = view.getId();
        int boardField = viewCell-1;
        for (int i : board.get(boardField).getPossibleMoves()){
            if (board.get(i-1).getFieldStatus()==NOT_CLICKED){
                gridLayout.getChildAt(i-1).setBackgroundColor(COLOR_POSSIBLE_MOVE);
            }

        }
    }

    public void setListWithPossibleMoves(){
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(8,12)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(9,11,13)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(6,10,12,14)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(7,13,15)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(8,14)));

        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(3,13,17)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(4,14,16,18)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(1,5,11,15,17,19)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(2,12,18,20)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(3,13,19)));

        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(2,8,18,22)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(1,3,9,19,21,23)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(2,4,6,10,16,20,22,24)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(3,5,7,17,23,25)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(4,8,18,24)));

        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(7,13,23)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(6,8,14,24)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(7,9,11,15,21,25)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(8,10,12,22)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(9,13,23)));

        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(12,18)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(11,13,19)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(12,14,16,20)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(13,15,17)));
        arrayMoves.add(new ArrayList<Integer>(Arrays.asList(14,18)));
    }



    //@SuppressLint("SetTextI18n")
    public void possibleToClick(GridLayout gridLay){
        for (int i = 0; i<25; i++){
            TextView currentText = (TextView) gridLay.getChildAt(i);
            currentText.setText(Integer.toString(i+1));
        }
        gridLay.getChildAt(0).setBackgroundColor(Color.RED);
    }

}
