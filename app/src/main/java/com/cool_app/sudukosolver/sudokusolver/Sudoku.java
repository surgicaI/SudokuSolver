package com.cool_app.sudukosolver.sudokusolver;

/**
 * Created by simranjyotsingh on 14/12/16.
 */

public class Sudoku {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        if(!isValid(board)) return false;
        for(int i =0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j]=='.'){
                    for(int k=1;k<10;k++){
                        board[i][j]=(char) (k + '0');
                        if(solve(board)) return true;
                        else if(k==9) {board[i][j]='.'; return false;}
                    }   }   }   }
        return true;
    }

    private boolean isValid(char[][] board){
        for(int row=0;row<9;row++){
            boolean[] bRow = new boolean[10];
            boolean[] bCol = new boolean[10];
            for(int col=0;col<9;col++){
                if(board[row][col]!='.' && bRow[Character.getNumericValue(board[row][col])]) return false;
                else if(board[row][col]!='.')
                    bRow[Character.getNumericValue(board[row][col])] = true;
                if(board[col][row]!='.' && bCol[Character.getNumericValue(board[col][row])]) return false;
                else if(board[col][row]!='.')
                    bCol[Character.getNumericValue(board[col][row])] = true;
            }
        }
        for(int i=0;i<9;i++){
            boolean[] bBox = new boolean[10];
            for(int j=((i%3)*3);j<((i%3)*3)+3;j++){
                for(int k =((i/3)*3);k<((i/3)*3)+3;k++){
                    if(board[j][k]!='.' && bBox[Character.getNumericValue(board[j][k])]) return false;
                    else if(board[j][k]!='.')
                        bBox[Character.getNumericValue(board[j][k])] = true;
                }
            }
        }
        return true;
    }
}
