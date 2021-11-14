// import java.io.*;
import java.util.*;

public class Main {
  public static void display(int[][] board) {
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solveSudoku(int[][] board, int i, int j) {
    // write yopur code here
    if (i == board.length)
    {
      display(board);
      return;
    }
    int ni = 0;
    int nj = 0;
    if (j == board[0].length-1)
    {
      ni = i + 1;
      nj = 0;
    }
    else
    {
      ni = i;
      nj = j + 1;
    }
    if (board[i][j] != 0)
    {
      solveSudoku(board, ni, nj);
    }
    else
    {
      for (int val = 1; val <= 9; val++) {
        if (isvalid(board,val,i,j)) {
          board[i][j] = val;
          solveSudoku(board, ni, nj);
          board[i][j] = 0;
        }
      }
    }
  }

  public static boolean isvalid(int[][] board,int val, int i,int j){
      int n = board.length;
      for(int k=0;k<n;k++)
      {
          if(board[i][k] == val)
          return false;
      }
       for(int k=0;k<n;k++)
      {
          if(board[k][j] == val)
          return false;
      }
      i = i/3*3;
       j = j/3*3;
      for(int x = 0;x<3;x++)
      {
          for(int y = 0; y<3;y++)
          {
              if(board[i+x][j+y] == val)
              return false;
          }
      }
      return true;
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int[][] arr = new int[9][9];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        arr[i][j] = scn.nextInt();
      }
    }

    solveSudoku(arr, 0, 0);
  }
}
