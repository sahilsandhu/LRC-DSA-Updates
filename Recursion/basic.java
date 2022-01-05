import java.util.*;
public class basic{
    public static Scanner scn = new Scanner(System.in);;

    // print Increasing and Decreasing
    public static void IncreasingDecreasing(int n)
    {
        if(n==0)
        return;
        System.out.println(n);
        IncreasingDecreasing(n-1);
        System.out.println(n);
    }
    
    
    // Factorial
    public static int Factorial(int n)
    {
        if(n==0)
        return 1;
        return n*Factorial(n-1);
    }

    //  power

    public static int power(int x, int n)
    {
        if(n == 0)
            return 1;
        return x*power(x,n-1);
    }
     //power log
    public static int powerLog(int x,int n)
    {
        if(n == 0)
        return 1;
        int ans = powerLog(x,n/2);
        ans = n%2 == 0 ? ans*ans : ans*ans*x;
        return ans;
    }
   
    // print zigzag
    public static void zigzag(int n) // --------- O(N)
    {
        if(n==0)
        return;
        System.out.println(n);
        zigzag(n-1);
        System.out.println(n);
        zigzag(n-1);
        System.out.println(n);
    }

    // Tower of Hanoi
    public static void TOH(int n, string f,string s, string t)
    {

    }
    public static void main(String[] args)
    {
     
     //IncreasingDecreasing(10);
     //System.out.println(Factorial(10));
     //System.out.println(powerLog(2,5));
    zigzag(5);
    }
}
