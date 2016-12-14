package com.cool_app.sudukosolver.sudokusolver;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener sudokuGridListener;
    private Integer currentSelectedGridBox = null;
    private View.OnClickListener numPadListener;
    private ArrayList<Button> gridButtons;
    Sudoku sudoku;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOnCreateListeners();
        initSudokuGridButtons();
        setListeners();
        sudoku = new Sudoku();
    }

    private void initOnCreateListeners(){
        sudokuGridListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentSelectedGridBox!=null){
                    Button button = (Button) findViewById(currentSelectedGridBox);
                    button.setBackgroundColor(Color.WHITE);
                }
                currentSelectedGridBox = view.getId();
                view.setBackgroundColor(getResources().getColor(R.color.selected_light));
            }
        };
        numPadListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.button_clear:
                        if(currentSelectedGridBox!=null){
                            Button button = (Button) findViewById(currentSelectedGridBox);
                            button.setText("");
                        }
                        break;
                    case R.id.button_solve:
                        solveSuduko();
                        break;
                    default:
                        if(currentSelectedGridBox!=null){
                            Button button = (Button) findViewById(currentSelectedGridBox);
                            Button numPadButton = (Button) view;
                            button.setText(numPadButton.getText());
                        }
                        break;
                }
            }
        };
    }

    private void initSudokuGridButtons(){
        gridButtons = new ArrayList<Button>();
        gridButtons.add((Button)findViewById(R.id.b11));
        gridButtons.add((Button)findViewById(R.id.b12));
        gridButtons.add((Button)findViewById(R.id.b13));
        gridButtons.add((Button)findViewById(R.id.b14));
        gridButtons.add((Button)findViewById(R.id.b15));
        gridButtons.add((Button)findViewById(R.id.b16));
        gridButtons.add((Button)findViewById(R.id.b17));
        gridButtons.add((Button)findViewById(R.id.b18));
        gridButtons.add((Button)findViewById(R.id.b19));

        gridButtons.add((Button)findViewById(R.id.b21));
        gridButtons.add((Button)findViewById(R.id.b22));
        gridButtons.add((Button)findViewById(R.id.b23));
        gridButtons.add((Button)findViewById(R.id.b24));
        gridButtons.add((Button)findViewById(R.id.b25));
        gridButtons.add((Button)findViewById(R.id.b26));
        gridButtons.add((Button)findViewById(R.id.b27));
        gridButtons.add((Button)findViewById(R.id.b28));
        gridButtons.add((Button)findViewById(R.id.b29));

        gridButtons.add((Button)findViewById(R.id.b31));
        gridButtons.add((Button)findViewById(R.id.b32));
        gridButtons.add((Button)findViewById(R.id.b33));
        gridButtons.add((Button)findViewById(R.id.b34));
        gridButtons.add((Button)findViewById(R.id.b35));
        gridButtons.add((Button)findViewById(R.id.b36));
        gridButtons.add((Button)findViewById(R.id.b37));
        gridButtons.add((Button)findViewById(R.id.b38));
        gridButtons.add((Button)findViewById(R.id.b39));

        gridButtons.add((Button)findViewById(R.id.b41));
        gridButtons.add((Button)findViewById(R.id.b42));
        gridButtons.add((Button)findViewById(R.id.b43));
        gridButtons.add((Button)findViewById(R.id.b44));
        gridButtons.add((Button)findViewById(R.id.b45));
        gridButtons.add((Button)findViewById(R.id.b46));
        gridButtons.add((Button)findViewById(R.id.b47));
        gridButtons.add((Button)findViewById(R.id.b48));
        gridButtons.add((Button)findViewById(R.id.b49));

        gridButtons.add((Button)findViewById(R.id.b51));
        gridButtons.add((Button)findViewById(R.id.b52));
        gridButtons.add((Button)findViewById(R.id.b53));
        gridButtons.add((Button)findViewById(R.id.b54));
        gridButtons.add((Button)findViewById(R.id.b55));
        gridButtons.add((Button)findViewById(R.id.b56));
        gridButtons.add((Button)findViewById(R.id.b57));
        gridButtons.add((Button)findViewById(R.id.b58));
        gridButtons.add((Button)findViewById(R.id.b59));

        gridButtons.add((Button)findViewById(R.id.b61));
        gridButtons.add((Button)findViewById(R.id.b62));
        gridButtons.add((Button)findViewById(R.id.b63));
        gridButtons.add((Button)findViewById(R.id.b64));
        gridButtons.add((Button)findViewById(R.id.b65));
        gridButtons.add((Button)findViewById(R.id.b66));
        gridButtons.add((Button)findViewById(R.id.b67));
        gridButtons.add((Button)findViewById(R.id.b68));
        gridButtons.add((Button)findViewById(R.id.b69));

        gridButtons.add((Button)findViewById(R.id.b71));
        gridButtons.add((Button)findViewById(R.id.b72));
        gridButtons.add((Button)findViewById(R.id.b73));
        gridButtons.add((Button)findViewById(R.id.b74));
        gridButtons.add((Button)findViewById(R.id.b75));
        gridButtons.add((Button)findViewById(R.id.b76));
        gridButtons.add((Button)findViewById(R.id.b77));
        gridButtons.add((Button)findViewById(R.id.b78));
        gridButtons.add((Button)findViewById(R.id.b79));

        gridButtons.add((Button)findViewById(R.id.b81));
        gridButtons.add((Button)findViewById(R.id.b82));
        gridButtons.add((Button)findViewById(R.id.b83));
        gridButtons.add((Button)findViewById(R.id.b84));
        gridButtons.add((Button)findViewById(R.id.b85));
        gridButtons.add((Button)findViewById(R.id.b86));
        gridButtons.add((Button)findViewById(R.id.b87));
        gridButtons.add((Button)findViewById(R.id.b88));
        gridButtons.add((Button)findViewById(R.id.b89));

        gridButtons.add((Button)findViewById(R.id.b91));
        gridButtons.add((Button)findViewById(R.id.b92));
        gridButtons.add((Button)findViewById(R.id.b93));
        gridButtons.add((Button)findViewById(R.id.b94));
        gridButtons.add((Button)findViewById(R.id.b95));
        gridButtons.add((Button)findViewById(R.id.b96));
        gridButtons.add((Button)findViewById(R.id.b97));
        gridButtons.add((Button)findViewById(R.id.b98));
        gridButtons.add((Button)findViewById(R.id.b99));
    }

    private void setListeners(){
        for(Button button:gridButtons){
            button.setOnClickListener(sudokuGridListener);
        }

        findViewById(R.id.button_0).setOnClickListener(numPadListener);
        findViewById(R.id.button_1).setOnClickListener(numPadListener);
        findViewById(R.id.button_2).setOnClickListener(numPadListener);
        findViewById(R.id.button_3).setOnClickListener(numPadListener);
        findViewById(R.id.button_4).setOnClickListener(numPadListener);
        findViewById(R.id.button_5).setOnClickListener(numPadListener);
        findViewById(R.id.button_6).setOnClickListener(numPadListener);
        findViewById(R.id.button_7).setOnClickListener(numPadListener);
        findViewById(R.id.button_8).setOnClickListener(numPadListener);
        findViewById(R.id.button_9).setOnClickListener(numPadListener);
        findViewById(R.id.button_solve).setOnClickListener(numPadListener);
        findViewById(R.id.button_clear).setOnClickListener(numPadListener);
    }

    private void resetGrid(){
        //reset the grid
    }

    private void solveSuduko(){
        char[][] board = new char[9][9];
        createBoardFromGrid(board);
        sudoku.solveSudoku(board);
        createGridFromBoard(board);
    }

    private void createBoardFromGrid(char[][] board){
        Iterator<Button> iterator = gridButtons.iterator();
        String s;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                s = iterator.next().getText().toString();
                board[i][j] = s.isEmpty() ? '.' : s.charAt(0);
            }
        }
    }

    private void createGridFromBoard(char[][] board){
        Iterator<Button> iterator = gridButtons.iterator();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                iterator.next().setText(String.valueOf(board[i][j]));
            }
        }
    }
}
