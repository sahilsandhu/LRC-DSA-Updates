//1.  fibonacci recurssion
public static int helper(int n)
{
    if(n<=1)
    return n;
    return helper(n-1) + helper(n-2);
}

// fibonacci tabulation
public static int helper(int n,int[]dp)
{
    if(n<=1)
    return dp[n] = n;
    if(dp[n] != 0)
    return dp[n];
    return dp[n] = (helper(n-1,dp) + helper(n-2,dp));
}

// fibonacci memoization
public static int helper(int n,int[]dp)
{
    dp[0] = 0;
    dp[1] = 1;
    for(int i=2;i<=n;i++)
    dp[i] = dp[i-1] + dp[i-2];
    return dp[n];
}

// 2. climb stairs Recurssion
public static int helper(int n)
    {
        if(n<0)
        return 0;
        if(n == 0)
        return 1;
        int count = 0;
        count += helper(n-1) + helper(n-2) + helper(n-3);
        return count;
    }

// climb stairs tabulation
public static int helper(int n,int[] dp)
    {
        if(n<0)
        return 0;
        if(n == 0)
        return dp[n] = 1;
        if(dp[n]!= 0)
        return dp[n];
        int count = 0;
        count += helper(n-1,dp) + helper(n-2,dp) + helper(n-3,dp);
        return dp[n] = count;
    }

// climb stairs memoization
public static int helper(int n,int[] dp)
    {
        for(int i=0;i<=n;i++){
        if(i == 0)
        {
         dp[i] = 1;
         continue;
        }
        int count = 0;
        count += (i-1>=0)?dp[i-1]:0;
        count += (i-2>=0)?dp[i-2]:0; 
        count += (i-3>=0)?dp[i-3]:0;
        dp[i] = count;
        }
        return dp[n];
        
    }
 
// 3. Climb stairs with variable jumps Recurssion

public static int helper(int n,int idx,int[] ar)
    {
        if(idx == n)
        return 1;
        
        int count = 0;
        for(int j = 1;j<=ar[idx] && idx+j<=n;j++)
        {
            count+=helper(n,idx+j,ar);
        }
        return count;
    }

//Climb stairs with variable jumps Memoization

 public static int helper(int n,int idx,int[] ar,int[] dp)
    {
        if(idx == n)
        return dp[idx] = 1;
        if(dp[idx] != 0)
        return dp[idx];
        int count = 0;
        for(int j = 1;j<=ar[idx] && idx+j<=n;j++)
        {
            count+=helper(n,idx+j,ar,dp);
        }
        return dp[idx] = count;
    }

// Climb stairs with variable jumps Tabulation
public static int helper(int n,int[] ar,int[] dp)
    {
        for(int idx=n;idx>=0;idx--)
        {
        if(idx == n){
         dp[idx] = 1;
        continue;
        }
        int count = 0;
        for(int j = 1;j<=ar[idx] && idx+j<=n;j++)
        {
            count+=dp[idx+j];
        }
        dp[idx] = count;
        }
        return dp[0];
    }

// 4. climb stairs with minimum moves Recurssion

public static int helper(int n,int idx,int[] ar)
    {
        if(idx==n)
        return 0;
        int count = 30;
        for(int j = 1;j<=ar[idx] && j+idx<=n; j++)
        {
            count = Math.min(count,helper(n,idx+j,ar)+1);
        }
        return count;
    }

// climb stairs with minimum moves Tabulation
public static int helper(int n,int idx,int[] ar,int[] dp)
    {
        if(idx==n)
        return 0;
        if(dp[idx] != 0)
        return dp[idx];
        int count = 30;
        for(int j = 1;j<=ar[idx] && j+idx<=n; j++)
        {
            count = Math.min(count,helper(n,idx+j,ar,dp)+1);
        }
        return dp[idx] = count;
    }

// climb stairs with minimum moves Memoization
public static int helper(int n,int[] ar,int[] dp)
    {
        for(int idx=n;idx>=0;idx--){
        if(idx==n){
        dp[idx] = 0;
        continue;
        }
        int count = 30;
        for(int j = 1;j<=ar[idx] && j+idx<=n; j++)
        {
            if(idx+j <= n)
            count = Math.min(count, dp[idx+j]+1);
            
        }
        dp[idx] = count;
        }
        return dp[0];
        
    }

// 5. Min cost maze traversal Tabulation

public static int helper(int sr,int sc,int dr,int dc,int[][] ar,int[][] dp)
    {
        if(sr == dr && sc == dc)
        return ar[sr][sc];
        if(sr>dr || sc>dc)
        return Integer.MAX_VALUE;
        if(dp[sr][sc] != 0)
        return dp[sr][sc];
        
        int count = 0;
        count = Math.min(helper(sr+1,sc,dr,dc,ar,dp),helper(sr,sc+1,dr,dc,ar,dp)) + ar[sr][sc]; 
        return dp[sr][sc] = count;
    }

// Min cost maze traversal Meoization

public static int helper(int sr,int sc,int dr,int dc,int[][] ar,int[][] dp)
    {
        for(sr = dr;sr>=0;sr--)
        {
            for(sc = dc;sc>=0;sc--)
            {
        if(sr == dr && sc == dc){
        dp[sr][sc] = ar[sr][sc];
            continue;
        }
        int count = 0;
        int a = sr+1>dr? Integer.MAX_VALUE : dp[sr+1][sc];
        int b = sc+1>dc? Integer.MAX_VALUE : dp[sr][sc+1];
        count = Math.min(a,b) + ar[sr][sc]; 
        dp[sr][sc] = count;
        }
    }
    return dp[0][0];
    }

//6. Special Matrix

public int dirs[][] = {{1,0},{0,1}};
     public int helper(int sr,int sc,int dr,int dc,boolean[][] cells,int[][] dp)
     {
         if(sr == dr && sc == dc && cells[dr][dc] == false)
         return dp[sr][sc] = 1;
         if(dp[sr][sc] != -1)
         return dp[sr][sc];
         int count = 0;
         for(int[] dir : dirs)
         {
            int x = sr + dir[0];
            int y = sc + dir[1];
            
            if(x>=0 && y>=0 && x<=dr && y<= dc && cells[x][y] == false)
            count += helper(x,y,dr,dc,cells,dp)%1000000007;
         }
         return dp[sr][sc] = count%1000000007;
     }
    public int FindWays(int n, int m, int[][] blocked_cells)
    {
        boolean[][] ar = new boolean[n+1][m+1];
        for(int[] val : blocked_cells)
        {
            ar[val[0]][val[1]] = true;
        }
        if(ar[1][1] == true)
        return 0;
        int[][] dp = new int[n+1][m+1];
        for(int[] d:dp)
        Arrays.fill(d,-1);
        return helper(1,1,n,m,ar,dp);
    }

// 7. Unique Paths

 int[][] dirs = {{0,1},{1,0}};
    public int helper(int sr,int sc,int dr,int dc,int[][] dp)
    {
        if(sr == dr && sc == dc)
            return dp[sr][sc] =1;
        if(dp[sr][sc] != 0)
            return dp[sr][sc];
        int count = 0;
        for(int[] dir : dirs)
        {
            int x = sr + dir[0];
            int y = sc + dir[1];
            if(x>=0 && y>=0 && x<=dr && y<=dc)
            {
                count += helper(x,y,dr,dc,dp);
            }
        }
        return dp[sr][sc] = count;
        
    }

// Unique PAth 2
int[][] dirs = {{1,0},{0,1}};
    int uniquePathsWithObstacles_(int sr,int sc,int dr,int dc,int[][] grid,int[][] dp)
    {
        if(sr == dr && sc == dc)
            return 1;
        if(dp[sr][sc] != 0)
            return dp[sr][sc];
        int count = 0;
        for(int[] dir : dirs)
        {
            int x = sr+dir[0];
            int y = sc+dir[1];
            if(x>=0 && y>=0 && x<=dr && y<=dc && grid[x][y] != 1)
                count+= uniquePathsWithObstacles_(x,y,dr,dc,grid,dp);
        }
        return dp[sr][sc] = count;
        
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        if(grid[0][0] == 1)
            return 0;
        return uniquePathsWithObstacles_(0,0,n-1,m-1,grid,dp);
    }

// leetcode 70
public int climbStairs_(int n,int[] dp)
    {
        if(n<0)
            return 0;
        if(n == 0)
        {
            return dp[n] =  1;
        }
        if(dp[n] != 0)
            return dp[n];
       
        return dp[n] = climbStairs_(n-1,dp) + climbStairs_(n-2,dp);
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return climbStairs_(n,dp);
    }

// leetcode 746

public int minCostClimbingStairs_(int[] cost,int n,int[] dp)
    {
        if(n <=1)
            return dp[n] = cost[n];
        if(dp[n] != 0)
            return dp[n];
        return dp[n] = Math.min(minCostClimbingStairs_(cost,n-1,dp),minCostClimbingStairs_(cost,n-2,dp)) + cost[n];
            
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        return Math.min(minCostClimbingStairs_(cost,cost.length-1,dp),minCostClimbingStairs_(cost,cost.length-2,dp));
    }

// Tabulation

public int minCostClimbingStairs_(int[] cost,int N,int[] dp)
    {
        for(int n=0;n<=N;n++)
        {
        if(n <=1){
             dp[n] = cost[n];
        continue;
        }
        dp[n] = Math.min(dp[n-1] , dp[n-2]) + cost[n];
        }  
        return dp[N];
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[] = new int[cost.length+1];
        minCostClimbingStairs_(cost,cost.length-1,dp);
        return Math.min(dp[cost.length-1] , dp[cost.length-2]);
    }

// Dice Question : 
// There is a dice which rolls and give a value (1,2,3,4,5,6), we are at position 0, and need to reach the 10.
// Each time the we rolls the dice and take the number of steps which comes up on the dice. Calculate the different
// number of ways with which we reach on the position n (10).
 