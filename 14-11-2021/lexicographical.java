import java.io.*;
import java.util.*;

public class Main {
    public static void dfs(int no,int n)
    {
        if(no>n)
        {
            return;
        }
        System.out.println(no);
        for(int i=0;i<10;i++)
        {
            dfs(no*10+i,n);
        }
    }
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
        for(int i=1;i<=9;i++)
        {
            dfs(i,n);
        }
		//write your code here
	}
	
}