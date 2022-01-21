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

    //Print Maze Paths
     public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
	        if(sr>dr || sc>dc)
	        return;
	        if(sr==dr && sc==dc)
	        {
	            System.out.println(psf);
	            return;
	        }
	        printMazePaths(sr,sc+1,dr,dc,psf+"h");
	        printMazePaths(sr+1,sc,dr,dc,psf+"v");
	    }
    // Print maze path with jump

     public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        if(sr > dr && sc > dc)
        return;
        if(sr == dr && sc == dc)
        {
            System.out.println(psf);
            return;
        }
        for(int jmp = 1; jmp+sc<=dc ; jmp++){
            printMazePaths(sr,sc+jmp,dr,dc,psf+"h"+jmp);
        }
        for(int jmp = 1; jmp+sr<=dr ; jmp++){
            printMazePaths(sr+jmp,sc,dr,dc,psf+"v"+jmp);
        }
        for(int jmp = 1; jmp+sr<=dr && jmp+sc<=dc; jmp++){
            printMazePaths(sr+jmp,sc+jmp,dr,dc,psf+"d"+jmp);
        }
    }

    // toh

    import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n;
        n = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int n3 = scn.nextInt();
        toh(n,n1,n2,n3);
    }

    public static void toh(int n, int src, int dest, int help){
        if(n==0)
        return;
        toh(n-1,src,help,dest);
        System.out.println(n+"["+src+"->"+dest);
        toh(n-1,help,dest,src);
    }

}

// Get Subsequence

    public static ArrayList<String> gss(String str) {
        if(str.length() == 0)
        {
             ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        char ch = str.charAt(0);
        ArrayList<String> gs = gss(str.substring(1));
        ArrayList<String> ans = new ArrayList<>(gs);
        for(String val : gs)
        {
            ans.add(ch+val);
        }
        return ans;
    }



//  get KPC

    public static String[] words = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
    public static ArrayList<String> getKPC(String str) {
        if(str.length() == 0)
        {
            ArrayList<String> s = new ArrayList<>();
            s.add("");
            return s;
        }
        
        String word = words[str.charAt(0)-'0'];
        ArrayList<String>ans = new ArrayList<>();
        ArrayList<String> temp = getKPC(str.substring(1));
        
        for(int i=0;i<word.length();i++)
        {
            for(String s: temp)
            {
                ans.add(word.charAt(i)+s);
            }
        }
        return ans;
    }

    // get Stair PAths
    public static ArrayList<String> getStairPaths(int n) {
        if(n<0)
        return new ArrayList<>();
        if(n == 0)
        {
            ArrayList<String>temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        ArrayList<String>ans = new ArrayList<>();
        ArrayList<String> temp1 = getStairPaths(n-1);
        ArrayList<String> temp2 = getStairPaths(n-2);
        ArrayList<String> temp3 = getStairPaths(n-3);
        for(String s: temp1)
        {
            ans.add(1+s);
        }
        for(String s: temp2)
        {
            ans.add(2+s);
        }
         for(String s: temp3)
        {
            ans.add(3+s);
        }
        return ans;
    }

    // get maze path

   public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        if(sr >= dr+1 || sc >= dc+1)
        {
            return new ArrayList<>();
        }
        if(sr==dr && sc==dc)
        {
            ArrayList<String> tmp = new ArrayList<>();
            tmp.add("");
            return tmp;
        }
        ArrayList<String> ans = new ArrayList<>();
        ArrayList<String> hans = getMazePaths(sr,sc+1,dr,dc);
        ArrayList<String> vans = getMazePaths(sr+1,sc,dr,dc);
        for(String s : hans)
        {
            ans.add("h"+s);
        }
        for(String s: vans)
        {
            ans.add("v"+s);
        }
        return ans;
    }

// print permutationss

public static void printPermutations(String str, String asf) {
        if(str.length() == 0)
        {
            System.out.println(asf);
            return;
        }
        for(int i=0;i<str.length();i++){
        char ch = str.charAt(i);
        printPermutations(str.substring(0,i)+str.substring(i+1),asf+ch);}
        return;
    }


   // print encodings



   // print permutatons of repetition :
   public static void printpermutation(String str,String ans)
   {
       if(str.size() == 0)
       {
           System.out.println(ans);
           return;
       } 
       for(int i=0;i<str.size();i++)
       {
           if(i == 0 || str[i-1] == str[i])
           continue;
           char ch = str.charAt(i);
           printpermutation(str.substring(0,i)+str.substring(i+1),ch+ans);
       }
       return;
   } 

   // leetcode 46 permutations of array 

   class Solution {
public:
    vector<vector<int>>finalans;
    void helper(vector<int>&nums,vector<int> &vis,vector<int>&ans)
    {
        if(ans.size() == nums.size()) 
        {
            finalans.push_back(ans);
            return;
        }
        for(int i=0;i<nums.size();i++)
        {
            if(vis[i] == 0)
            {
                vis[i] = 1;
                ans.push_back(nums[i]);
                helper(nums,vis,ans);
                ans.pop_back();
                vis[i] = 0 ;
            }
        }
    }
    vector<vector<int>> permute(vector<int>& nums) {
        finalans.clear();
        vector<int> ans;
        vector<int> vis(nums.size(),0);
        helper(nums,vis,ans);
        return finalans;
    }
};


// leetcode 47 permutaion 2 of array with repetitions
// hold

// GFG Rat in a maze backtrackig

class Solution{
    public:
    int dirs[4][2] = {{1,0},{0,-1},{0,1},{-1,0}};
    char pos[4] = {'D','L','R','U'};
    vector<string>fans;
    void helper(int sr,int sc,int dr,int dc,vector<vector<int>>&m,vector<vector<int>> &vis,string ans){
        if(sr == dr && sc == dc && m[sr][sc]==1)
        {
            fans.push_back(ans);
            return;
        }
        
        for(int i=0;i<4;i++)
        {
            int x = sr+dirs[i][0];
            int y = sc+dirs[i][1];
            if(x>=0&& y>=0 && x<dr+1 && y<dc+1 && m[x][y]==1 && vis[x][y] == 0)
            {
                vis[sr][sc] = 1;
                helper(x,y,dr,dc,m,vis,ans+pos[i]);
                vis[sr][sc] = 0;
            }
        }
            //vis[sr][sc] = 0;
    }
    vector<string> findPath(vector<vector<int>> &m, int n) {
        fans.clear();
        if(m[0][0] == 0)
        return fans;
        vector<vector<int>> vis(n,vector<int>(n,0));
        helper(0,0,n-1,n-1,m,vis,"");
        return fans;
        
    }
};

    
 // Speical MAtrix ---------- hold
 // Rat in a maze with jumps ------hold
 // rat in a maze with moveemnt in all possible direction    

// Longest Path in the grid
// Shortest path in the grid


// Permutation with infinte coins
int helper(vector<int>&nums, int tar, string ans)
    {
        if(tar == 0)
        {
            cout<<ans<<endl;
            return 1;
        }
        int count = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(tar - nums[i] >= 0)
            count+=helper(nums,tar-nums[i],ans+to_string(nums[i]));
        }
        return count;
    }
//  combination with infinite coins
int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(tar == 0)
        {
            cout<<ans<<endl;
            return 1;
        }
        int count = 0;
        for(int i=idx;i<nums.size();i++)
        {
            if(tar - nums[i] >= 0)
            count+=helper(nums,i,tar-nums[i],ans+to_string(nums[i]));
        }
        return count;
    }

// combination with unique coins 
int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(tar == 0)
        {
            cout<<ans<<endl;
            return 1;
        }
        int count = 0;
        for(int i=idx;i<nums.size();i++)
        {
            if(tar - nums[i] >= 0)
            count+=helper(nums,i+1,tar-nums[i],ans+to_string(nums[i]));
        }
        return count;
    }

// permutations with unique values

int helper(vector<int>&nums, int tar, string ans)
    {
        if(tar == 0)
        {
            cout<<ans<<endl;
            return 1;
        }
       
        int count = 0;
        for(int i=0;i<nums.size();i++)
        {
            int ele = nums[i];
            if(nums[i]>0 && tar - nums[i] >= 0){
            nums[i] = -nums[i];
            count+=helper(nums,tar-ele,ans+to_string(ele));
            nums[i] = -nums[i];
            }
        }
        return count;
    }

// Subsequence method combination
int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(idx == nums.size() || tar == 0)
        {
            if(tar == 0){
            cout<<ans<<endl;
            return 1;}
            return 0;
        }
       
        int count = 0;
        
        if(tar - nums[idx] >= 0){
        count+=helper(nums,idx+1,tar-nums[idx],ans+to_string(nums[idx]));
        }
        count+=helper(nums,idx+1,tar,ans);
    
        return count;
    }

// Subsequence method infinite Combintation

int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(idx == nums.size() || tar == 0)
        {
            if(tar == 0){
            cout<<ans<<endl;
            return 1;}
            return 0;
        }
       
        int count = 0;
        
        if(tar - nums[idx] >= 0){
        count+=helper(nums,idx,tar-nums[idx],ans+to_string(nums[idx]));
        }
        count+=helper(nums,idx+1,tar,ans);
    
        return count;
    }

// Subsequence method infinite permutstions
int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(idx == nums.size() || tar == 0)
        {
            if(tar == 0){
            cout<<ans<<endl;
            return 1;}
            return 0;
        }
       
        int count = 0;
        
        if(tar - nums[idx] >= 0){
        count+=helper(nums,0,tar-nums[idx],ans+to_string(nums[idx]));
        }
        count+=helper(nums,idx+1,tar,ans);
    
        return count;
    }

// Subsequence mwthod unique permutations

int helper(vector<int>&nums,int idx, int tar, string ans)
    {
        if(idx == nums.size() || tar == 0)
        {
            if(tar == 0){
            cout<<ans<<endl;
            return 1;}
            return 0;
        }
       
        int count = 0;
        int ele = nums[idx];
        if(tar - nums[idx] >= 0 && nums[idx]>0){
            nums[idx] = -nums[idx];
        count+=helper(nums,0,tar-ele,ans+to_string(ele));
        nums[idx] = -nums[idx];
        }
        
        count+=helper(nums,idx+1,tar,ans);
    
        return count;
    }


    //friends pairing tabulatiom
    class Solution
{
public:
     long mod = 1e9 + 7;
    long helper(int n, vector<long> &dp)
    {
       if(n==0){
       dp[n] = 1;
       return dp[n];
       }
       if(dp[n] != -1)
       return dp[n];
       long ans1 = helper(n-1,dp);
       long ans2 = n-2>=0 ? (n-1)*helper(n-2,dp):0;
       dp[n] = (ans1+ans2)%mod;
       return dp[n];
    }
    int countFriendsPairings(int n) 
    { 
        vector<long> v(n+1,-1);
        return (int)helper(n,v);
    }
};    


//memoization
public:
     long mod = 1e9 + 7;
    long helper(int n)
    {
       long a = 1;
       long b = 1;
       for(int i=2;i<=n;i++)
       {
           long sum = b+(a*(i-1)%mod);
          a = b;
          b = sum%mod;
       }
       return b%mod;
    }
    int countFriendsPairings(int n) 
    { 
        return (int)helper(n);
    }


    // Partition into subsets
    // REcurssion
    public static long helper(int n,int k)
    {
        if(k==1 || n<=k)
        return 1;
        return helper(n-1,k-1) + (k)*helper(n-1,k);
    }
    public static long partitionKSubset(int n, int k) {
     return helper(n,k);
    }

    // Memoization

    //??

    // Longest Palindrominc Subsequence
    // Recurssion
    class Solution {
    int helper(String s, int i,int j)
    {
        if(i>=j)
            return (i==j)?1:0;
        int count = 0;
        if(s.charAt(i) == s.charAt(j))
        {
            count=helper(s,i+1,j-1)+2;;
            
        }
        else
        count = count + Math.max(helper(s,i+1,j) , helper(s,i,j-1));
        return count;
    }
    public int longestPalindromeSubseq(String s) {
    
        return helper(s,0,s.length()-1);
        
    }
}
// Tabulation
class Solution {
    int helper(String s, int i,int j,int[][] dp)
    {
        if(i>=j)
            return (i==j)?1:0;
        if(dp[i][j] != 0)
            return dp[i][j];
        int count = 0;
        if(s.charAt(i) == s.charAt(j))
        {
            count=helper(s,i+1,j-1,dp)+2;;
            
        }
        else
        count = count + Math.max(helper(s,i+1,j,dp) , helper(s,i,j-1,dp));
        dp[i][j] = count;
        return count;
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return helper(s,0,s.length()-1,dp);
        
    }
}


/// memoization 

class Solution {
    int helper(String s, int I,int J,int[][] dp)
    {
        int n = s.length();
        for(int gap = 0; gap<n;gap++)
        {
            for(int i=0,j=gap;j<n;i++,j++)
            {
                if(i>=j){
                dp[i][j] =  (i==j)?1:0;
                    continue;
                }
                if(s.charAt(i) == s.charAt(j))
                {
                dp[i][j]=dp[i+1][j-1]+2;;
                }
                else
                dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
            }
        }
        
        return dp[I][J];
    }
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        return helper(s,0,s.length()-1,dp);
        
    }
}

// longest common subsequence

// Recurssion + tabulation
class Solution {
     int helper(String s1,String s2, int i,int j,int[][] dp)
    {
        if(i == s1.length() || j == s2.length())
            return 0;
        if(dp[i][j] != 0)
            return dp[i][j];
        int count = 0;
        if(s1.charAt(i) == s2.charAt(j))
        {
            count = helper(s1,s2,i+1,j+1,dp)+1;
            
        }
        else
        count = count + Math.max(helper(s1,s2,i+1,j,dp) , helper(s1,s2,i,j+1,dp));
        return dp[i][j] = count;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        return helper(text1,text2,0,0,dp);
    }
}

// memoization

class Solution {
     int helper(String s1,String s2, int I,int J,int[][] dp)
    {
        int n = s1.length();
        int m = s2.length();
         for(int i=0 ;i<=n;i++)
         {
             for(int j=0;j<=m;j++)
             {
                  if(i == 0 || j ==0 ){
                    dp[i][j] = 0;
                  continue;
                  }
                  
                  if(s1.charAt(i-1) == s2.charAt(j-1))
                  {
                     dp[i][j] = dp[i-1][j-1]+1;
            
                  }
                 else
                 dp[i][j] =  Math.max(dp[i-1][j] , dp[i][j-1]);
             }
         }
         return dp[I][J];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        return helper(text1,text2,text1.length(),text2.length(),dp);
    }
}


// Edit Distance

class Solution {
public:
    int helper(string s1, string s2, int I,int J,vector<vector<int>> &dp)
    {
        for(int i=0;i<=I;i++)
        {
            for(int j=0;j<=J;j++){
               if(i == 0 || j == 0){
               dp[i][j] = i==0?j:i;
               continue;
               }
               int insert = dp[i][j-1];
               int deletee = dp[i-1][j];
               int replace = dp[i-1][j-1];
               if(s1[i-1] == s2[j-1])
               {
               dp[i][j] = replace;
               }
               else
               {
               dp[i][j] = min(min(insert,deletee),replace) + 1;
               } 
            }
        }
        
        return dp[I][J];
    }
    int minDistance(string word1, string word2) {
        vector<vector<int>> dp(word1.size()+1,vector<int>(word2.size()+1,-1)); 
        return helper(word1,word2,word1.size(),word2.size(),dp);
        
    }
};

// Follow up question : 1. we are provided some cost of insertion, deletion
// replacement we need to minimize the cost

#include<bits/stdc++.h>
using namespace std;
int helper(string s1,string s2,int i,int j,int ins,int del,int rep,vector<vector<int>>&dp){
    if(i == 0 || j == 0)
    {
        if(i == 0 && j==0)
        return dp[i][j] = 0;
        else
        return dp[i][j] = (i == 0) ? j*ins : i*del;
    }
    if(dp[i][j] != -1)
    return dp[i][j];
    int insert = helper(s1,s2,i,j-1,ins,del,rep,dp);
    int deletee = helper(s1,s2,i-1,j,ins,del,rep,dp);
    int replace = helper(s1,s2,i-1,j-1,ins,del,rep,dp);
    if(s1[i-1] == s2[j-1])
    dp[i][j] = replace;
    else
    dp[i][j] = min(min(insert+ins,deletee+del),replace+rep);
    return dp[i][j];
}
int main()
{
string s1 = "horse";
string s2 = "ros";
int ins = 2;
int del = 3;
int rep = 4;
vector<vector<int>>dp(s1.size()+1,vector<int>(s2.size()+1,-1));
cout<<helper(s1,s2,s1.size(),s2.size(),ins,del,rep,dp);
}

// count aibjck
int fun(string &s) {
        //code here
        long empty = 1;
        long acount = 0;
        long bcount = 0;
        long ccount = 0;
        long mod = 1e9+7;
        for(int i=0;i<s.size();i++)
        {
            if(s[i] == 'a')
            {
                acount = acount + (empty + acount)%mod;
            }
            else if(s[i] == 'b')
            {
                bcount = (bcount + (acount + bcount))%mod;
            }
            else if(s[i] == 'c')
            {
                ccount = (ccount + (ccount + bcount))%mod;
            }
        }
        return (int)(ccount%mod);
    }

// word break
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int len = 0;
        for(String ss: wordDict)
        {
            set.add(ss);
            len = Math.max(ss.length(),len);
        }
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i=0;i<s.length();i++)
        {
            if(!dp[i]) 
                continue;
            for(int l = 1;l<=len && i+l<=s.length();l++)
            {
               
                    String str = s.substring(i,i+l);
                    if(set.contains(str))
                        dp[i+l] = true;
            }
        }
        return dp[s.length()];
    }
}

// Longest Increasing Subsequence
class Solution {
    int helper(int[] ar,int idx,int[] dp)
    {
        if(dp[idx] != 0)
            return dp[idx];
        int max = 1;
        for(int i = idx-1; i>=0;i--)
        {
            if(ar[i] < ar[idx])
            {
                int ans = helper(ar,i,dp)+1;
                max = Math.max(ans,max);
            }
        }
        return dp[idx] = max;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int ans = 0;
        for(int i=0;i<nums.length;i++)
        {
            int rans = helper(nums,i,dp);
            ans = Math.max(ans,rans);
        }
        return ans;
    }
}

// LIS Tabulation

int helper(int[] ar,int idx,int[] dp)
    {
        int n = dp.length,maxlen = 0;
       for(int i=0;i<dp.length;i++)
       {
           dp[i] = 1;
           for(int j = i-1;j>=0;j--)
           {
               if(ar[i]>ar[j])
                   dp[i] = Math.max(dp[i],dp[j]+1);
           }
           maxlen = Math.max(dp[i],maxlen);
       }
        return maxlen;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // int ans = 0;
        // for(int i=0;i<dp.length;i++)
        // {
        //    int rans = 
        //   ans = Math.max(rans,ans);
        // }
        return helper(nums,0,dp);
    }

// Longest Decreasing Subsequence

class Solution {
    int helper(int[] ar,int idx,int[] dp)
    {
        int n = dp.length,maxlen = 0;
       for(int i=0;i<dp.length;i++)
       {
           dp[i] = 1;
           for(int j = i-1;j>=0;j--)
           {
               if(ar[i]<ar[j])
                   dp[i] = Math.max(dp[i],dp[j]+1);
           }
           maxlen = Math.max(dp[i],maxlen);
       }
        return maxlen;
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        // int ans = 0;
        // for(int i=0;i<dp.length;i++)
        // {
        //    int rans = 
        //   ans = Math.max(rans,ans);
        // }
        return helper(nums,0,dp);
    }
}

// Longest Bitonic Subsequene
class Solution
{
    public void helper(int[] ar,int n,int[] lis)
    {
        
        for(int i=0;i<n;i++)
        {
            lis[i] = 1;
            for(int j = i-1;j>=0;j--)
            {
                if(ar[j] < ar[i])
                {
                    lis[i] = Math.max(lis[i],lis[j]+1); 
                }
            }
        }
    }
    public void helper_lis(int[] ar,int n,int[] lis)
    {
        
        for(int i=n-1;i>=0;i--)
        {
            lis[i] = 1;
            for(int j = i+1;j<n;j++)
            {
                if(ar[j] < ar[i])
                {
                    lis[i] = Math.max(lis[i],lis[j]+1); 
                }
            }
        }
    }
    public int LongestBitonicSequence(int[] nums)
    {
        int n = nums.length;
        int[] lis = new int[n];
        int[] lis_r = new int[n];
        helper(nums,n,lis);
        helper_lis(nums,n,lis_r);
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            ans = Math.max(lis[i]+lis_r[i]-1,ans);
        }
        
        return ans;
        // Code here
    }
}

// Longest Reverse Bitnoic Subsequence

    public static void main(String[] args)
    {
     
     //IncreasingDecreasing(10);
     //System.out.println(Factorial(10));
     //System.out.println(powerLog(2,5));
    zigzag(5);
    }

}
