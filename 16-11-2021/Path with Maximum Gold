class Solution {
    int m,n,maxgold = Integer.MIN_VALUE;
    int offset[][] = {{0,1},{0,-1},{-1,0},{1,0}};
    
    public void dfs(int[][] grid,int i,int j,int goldcollected)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] == 0)
            return;
        
        int cur = grid[i][j];
        grid[i][j] = 0;
        maxgold = Math.max(maxgold, goldcollected + cur);
        for(int[] x : offset)
        {
            dfs(grid,i+x[0],j+x[1],goldcollected + cur);
        }
        grid[i][j] = cur;
    }
    
    public int getMaximumGold(int[][] grid) {
        
        //int[][] vis = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]!=0){
                    dfs(grid,i,j,0);
                }
                    
            }
        }
        if(maxgold==Integer.MIN_VALUE)
        return 0;
        else
            return maxgold;
    }
}
