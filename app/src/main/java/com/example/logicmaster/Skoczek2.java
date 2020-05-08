package com.example.logicmaster;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Skoczek2 extends AppCompatActivity implements View.OnClickListener {

    public static final int NOT_CLICKED = 0;
    public static final int CLICKED = 1;
    public static final int MOVE_POSSIBLE = 2;

    public static final int COLOR_MOVE_POSSIBLE = Color.MAGENTA;
    public static final int COLOR_CLICKED = Color.GREEN;
    public static final int COLOR_NOT_CLICKED = Color.BLUE;

    Map<Integer,Skoczek2_Field> board = new HashMap<>();
    public ArrayList<ArrayList<Integer>> arrayMoves = new ArrayList<>();
    public int firstClik = 0;


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
            textView.setBackgroundColor(COLOR_NOT_CLICKED);
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


        //Toast.makeText(this, "Board 0 moves size: " + board.get(7).getPossibleMoves().size() , Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onClick(View v) {
        TextView textView = (TextView)findViewById(getResources().getIdentifier(Integer.toString(v.getId()),"id",getPackageName()));
        ColorDrawable textColor = (ColorDrawable) textView.getBackground();
        ColorDrawable itemColor = (ColorDrawable)v.getBackground();

        Toast.makeText(this, "Id  "+v.getId(), Toast.LENGTH_SHORT).show();
        int viewCell = v.getId(); //1-25
        int boardField = viewCell-1;

        //cancelDisplayOldPossibleFields();
        //setWholeBoardColors(v); //current board view


        if (firstClik==0){
            board.get(boardField).setFieldStatus(CLICKED); //BOARD
            v.setBackgroundColor(Color.GREEN); //TEMPORARY
            showAndSetPossibleMoves(v); //TEMPORARY
            removeFieldFromPossibleMoves(viewCell);
            //setPossibleMoveStatus(v);//setPossibleMovesStatus as MOVE_POSSIBLE
            firstClik=1;
        } else {
            if ( itemColor.getColor()==COLOR_MOVE_POSSIBLE){ //board.get(boardField).getFieldStatus()==NOT_CLICKED &&
                cancelDisplayOldPossibleFields();//
                board.get(boardField).setFieldStatus(CLICKED);
                v.setBackgroundColor(Color.GREEN);
                removeFieldFromPossibleMoves(viewCell);

                showAndSetPossibleMoves(v);
            } //else {
//                AlertDialog alertDialog = new AlertDialog.Builder(Skoczek2.this).create();
//                alertDialog.setMessage("Ten ruch nie jest możliwy.");
//                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
//                        new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                dialog.dismiss();
//                            }
//                        });
//                alertDialog.show();
//            }
        }

//        String possibleValues = "";
//
//        for (int i = 0; i < board.get(boardField).getPossibleMoves().size(); i++){
//            possibleValues = possibleValues + board.get(boardField).getPossibleMoves().get(i) + ", ";
//        }


    }

    private void cancelDisplayOldPossibleFields() {
        for (int i=0; i<gridLayout.getChildCount(); i++){
            ColorDrawable itemColor = (ColorDrawable)gridLayout.getChildAt(i).getBackground();
            if (itemColor.getColor()==COLOR_MOVE_POSSIBLE){
                itemColor.setColor(COLOR_NOT_CLICKED);
            }
        }
    }

    public void removeFieldFromPossibleMoves(int boardField){
        for (int i=0; i<board.size(); i++){
            for (int x=0; x < board.get(i).getPossibleMoves().size(); x++){
                if (board.get(i).getPossibleMoves().get(x)==boardField){
                    board.get(i).getPossibleMoves().remove(x);
                }
            }
        }
    }

    public void setWholeBoardColors(View view){
        for (int i=0; i<board.size(); i++){
            switch (board.get(i).getFieldStatus()){
                case CLICKED: gridLayout.getChildAt(i).setBackgroundColor(COLOR_CLICKED);
                break;
                case NOT_CLICKED: gridLayout.getChildAt(i).setBackgroundColor(COLOR_NOT_CLICKED);
                break;
                case MOVE_POSSIBLE: gridLayout.getChildAt(i).setBackgroundColor(COLOR_MOVE_POSSIBLE);
                break;
            }
        }

//        for (int i=0; i<board.size(); i++){
//            if (board.get(i).getFieldStatus()==CLICKED){
//                gridLayout.getChildAt(i).setBackgroundColor(COLOR_CLICKED);
//            } else if (board.get(i).getFieldStatus()==NOT_CLICKED){
//                gridLayout.getChildAt(i).setBackgroundColor(COLOR_NOT_CLICKED);
//            } else {
//                gridLayout.getChildAt(i).setBackgroundColor(COLOR_MOVE_POSSIBLE);
//            }
//        }
    }

    private void showAndSetPossibleMoves(View view) {
        int viewCell = view.getId();
        int boardField = viewCell-1;
        for (int i : board.get(boardField).getPossibleMoves()){
            if (board.get(i-1).getFieldStatus()==NOT_CLICKED){
                gridLayout.getChildAt(i-1).setBackgroundColor(COLOR_MOVE_POSSIBLE);
                board.get(i-1).setFieldStatus(MOVE_POSSIBLE);
            }

        }
    }

    private void updateBoardFields(View view){

    }

    private void setPossibleMoveStatus(View view){
        int position = view.getId();
        board.get(view.getId()).setFieldStatus(MOVE_POSSIBLE);
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

    public void updateListWithPossibleMoves(){

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
