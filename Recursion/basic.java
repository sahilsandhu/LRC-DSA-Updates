public class Main{
    public static Scanner;

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
        if(n<=1)
        return 1;
        return n*Factorial(n-1);
    }
    Public static void main(String[] args)
    {
     Scanner = scn.nextLine();
     IncreasingDecreasing(10);
     System.out.println(Factorial(10));
    }
}