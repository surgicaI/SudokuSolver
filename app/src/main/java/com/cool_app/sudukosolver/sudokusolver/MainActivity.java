package com.cool_app.sudukosolver.sudokusolver;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private View.OnClickListener sudokuGridListener;
    private Integer currentSelectedGridBox = null;
    private View.OnClickListener numPadListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOnCreateListeners();
        setListeners();
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
    private void setListeners(){
        findViewById(R.id.b11).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b12).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b13).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b14).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b15).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b16).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b17).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b18).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b19).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b21).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b22).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b23).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b24).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b25).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b26).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b27).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b28).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b29).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b31).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b32).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b33).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b34).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b35).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b36).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b37).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b38).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b39).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b41).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b42).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b43).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b44).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b45).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b46).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b47).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b48).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b49).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b51).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b52).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b53).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b54).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b55).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b56).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b57).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b58).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b59).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b61).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b62).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b63).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b64).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b65).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b66).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b67).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b68).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b69).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b71).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b72).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b73).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b74).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b75).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b76).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b77).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b78).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b79).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b81).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b82).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b83).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b84).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b85).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b86).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b87).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b88).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b89).setOnClickListener(sudokuGridListener);

        findViewById(R.id.b91).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b92).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b93).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b94).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b95).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b96).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b97).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b98).setOnClickListener(sudokuGridListener);
        findViewById(R.id.b99).setOnClickListener(sudokuGridListener);

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
        //solves the puzzle
    }
}
