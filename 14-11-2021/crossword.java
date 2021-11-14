import java.io.*;
import java.util.*;

public class Main {

  public static void solution(char[][] arr, String[] words, int vidx) {
      if(vidx == words.length)
      {
          print(arr);
          return;
      }
      
    //write your code here
    String word = words[vidx];
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            if(arr[i][j]=='-' || arr[i][j]==word.charAt(0))
            {
                if(canPlaceVertical(arr,word,i,j))
                {
                boolean[] isplaced1 = placeVerticval(arr,word,i,j);
                    solution(arr,words, vidx+1);
                    unplaceVertical(arr,isplaced1,word,i,j);
                }
                if(canPlaceHorizonta(arr,word,i,j))
                {
                boolean[] isplaced2 = placeHorizontal(arr,word,i,j);
                    solution(arr,words,vidx+1);
                    unplaceHorizontal(arr,isplaced2,word,i,j);
                }
                
            }
            
        }
    }
  }
  
  public static void unplaceVertical(char[][] ar,boolean[] isplaced1, String word, int r,int c)
  {
      for(int i=0;i<word.length();i++)
      {
          if(isplaced1[i] == true)
          {
              ar[r+i][c] = '-';
          }
      }
  }
  public static void unplaceHorizontal(char[][] ar,boolean[] isplaced2, String word, int r,int c)
  {
     for(int i=0;i<word.length();i++)
      {
          if(isplaced2[i] == true)
          {
              ar[r][c+i] = '-';
          }
      } 
  }
  
  public static boolean[] placeVerticval(char[][] ar,String word ,int r,int c)
  {
      boolean[] temp = new boolean[word.length()];
      for(int pos = 0;pos<word.length();pos++)
      {
          if(ar[r+pos][c] =='-'){
          ar[r+pos][c] = word.charAt(pos);
             temp[pos] = true; 
          }
      }
      return temp;
  }
  
  public static boolean[] placeHorizontal(char[][] ar,String word ,int r,int c)
  {
      boolean[] temp = new boolean[word.length()];
      for(int pos = 0;pos<word.length();pos++)
      {
          if(ar[r][c+pos] == '-'){
          ar[r][c+pos] = word.charAt(pos);
             temp[pos] = true; 
          }
      }
      return temp;
  }
  
  
  public static boolean canPlaceVertical(char[][] arr,String word,int r,int c)
  {
    int i = 0;
    for(;i<word.length();i++)
    {
      if(r+i >= arr.length)
        return false;
      else if(arr[r+i][c]=='-' || arr[r+i][c]==word.charAt(i))
      {
          continue;
      }
      else
      return false;
    }
    if(r+i == arr.length || arr[r+i][c]=='+')
    return true;
    else 
    return false;
  }
  
  public static boolean canPlaceHorizonta(char[][] arr,String word,int r,int c)
  {
    int i = 0;
    for(;i<word.length();i++)
    {
      if(c+i >= arr[0].length)
        return false;
      else if(arr[r][c+i]=='-' || arr[r][c+i]==word.charAt(i))
      {
          continue;
      }
      else
      return false;
    }
    if(c+i == arr.length || arr[r][c+i]=='+')
    return true;
    else 
    return false;
  }
  


  public static void print(char[][] arr) {
    for (int i = 0 ; i < arr.length; i++) {
      for (int j = 0 ; j < arr.length; j++) {
        System.out.print(arr[i][j]);
      }
      System.out.println();
    }

  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    char[][] arr = new char[10][10];
    for (int i = 0 ; i < arr.length; i++) {
      String str = scn.next();
      arr[i] = str.toCharArray();
    }
    int n = scn.nextInt();
    String[] words = new String[n];
    for (int i = 0 ; i  < words.length; i++) {
      words[i] = scn.next();
    }
    solution(arr, words, 0);
  }
}