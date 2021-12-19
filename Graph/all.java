// has Path ==============  DFS

bool hasPath(vector<Edge>graph[],int src,int dest,vector<int>&vis)
{
    if(src == dest)
    return true;
    vis[src] = 1;
    bool ans = false;
    for(Edge ed : graph[src])
    {
        if(vis[ed.nbr] == 0)
        {
          bool temp = hasPath(graph,ed.nbr,dest,vis);
          if(temp)
          ans = temp;
        }
    }
    return ans;
}

// Print Path

void printPath(vector<Edge> graph[],int src,int dest,vector<int> &vis,string psf)
{
    if(src == dest)
    {
        cout<<psf<<endl;
        return;
    }
    vis[src] = 1;
    for(Edge ed : graph[src])
    {
        if(vis[ed.nbr] == 0)
        {
            printPath(graph,ed.nbr,dest,vis,psf+to_string(ed.nbr));
        }
    }
    vis[src] = false;
    
}

// Rotting Oranges ====================

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
          int n = grid.size();
        int m = grid[0].size();
        queue<int>q;
        int count = 0 ;
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 2)
                    q.push(i*m+j);
                else if(grid[i][j] == 1)
                    count++;
            }
        
        int level = 0;
        if(count == 0)
            return 0;
        vector<vector<int>>dirs= {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
                int t = q.front();
                q.pop();
                int i = t/m;
                int j = t%m;
                for(auto a : dirs)
                {
                    int x = i + a[0];
                    int y = j + a[1];
                    if(x>=0 && y>=0 && x<n && y <m && grid[x][y] == 1)
                    {
                        q.push(x*m+y);
                        grid[x][y] = 2;
                        count--;
                        cout<<count<<endl;
                    }
                }
            }
            level++;
        }
        if(count == 0)
            return level-1;
        else return -1;
    }

};



// Max area of island =========================

class Solution {
public:
    vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(vector<vector<int>>&grid,int i,int j,int &count)
    {
        grid[i][j] = 2;
        for(auto a : dirs)
        {
            int x = i+a[0];
            int y = j+a[1];
            if(x>=0 && y>=0 && x<grid.size() && y<grid[0].size() && grid[x][y] == 1)
            {
                count++;
                dfs(grid,x,y,count);
            }
        }
    }
    int maxAreaOfIsland(vector<vector<int>>& grid) {
        int m =grid.size();
        int n = grid[0].size();
        int maxArea = ;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                {
                    int area = 1;
                    dfs(grid,i,j,area);
                    maxArea = max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
};

// Hamiltonian Path and cycle ========================

#include<bits/stdc++.h>

using namespace std;

class Edge {
public:
  int src = 0;
  int nbr = 0;
  int wt = 0;

  Edge(int src, int nbr, int wt) {
    this->src = src;
    this->nbr = nbr;
    this->wt  = wt;
  }
};
int count=0;
void dfs(vector<vector<Edge>> graph,int osrc,int src,vector<int> &vis,string s, int count)
{
    if(count == vis.size()-1)
    {
        int flag = 0;
        for(Edge ed : graph[src])
        {
            if(ed.nbr == osrc)
            {
                flag = 1;
                break;
            }
        }
        if(flag == 1)
        s+="*";
        else
        s+=".";
        
    cout<<s<<endl;
      return;  
    }
    vis[src] = 1;
    for(Edge ed : graph[src])
    {
        if(vis[ed.nbr] == 0)
        {
            dfs(graph,osrc,ed.nbr,vis,s+to_string(ed.nbr),count+1);
        }
    }
    vis[src] = 0;
}

int main() {
  int vtces;
  cin >> vtces;
  vector<vector<Edge>> graph(vtces, vector<Edge>());


  int edges;
  cin >> edges;

  for (int i = 0; i < edges; i++ ) {
    int u, v, w;
    cin >> u >> v >> w;

    graph[u].push_back(Edge(u, v, w));
    graph[v].push_back(Edge(v, u, w));

  }
  int src;
  cin >> src;
  vector<int> vis(vtces);
  int count = 0;
  dfs(graph,src,src,vis,to_string(src)+"",count);
  // write your codes here
  return 0;
}


// is graph Cyclic ===========================

import java.io.*;
import java.util.*;

public class Main {
   static class Edge {
      int src;
      int nbr;
      int wt;

      Edge(int src, int nbr, int wt) {
         this.src = src;
         this.nbr = nbr;
         this.wt = wt;
      }
   }
   
   public static boolean isCyclic(ArrayList<Edge>[] graph,boolean[] vis,int src)
   {
       Queue<Integer> q = new ArrayDeque<>();
       q.add(src);
       while(q.size()>0)
       {
           int s = q.size();
           while(s-- > 0)
           {
               int rv = q.remove();
               if(vis[rv] == true)
               return true;
               vis[rv] = true;
               for(Edge ed : graph[rv])
               {
                   if(vis[ed.nbr] == false)
                   {
                       q.add(ed.nbr);
                   }
               }
           }
       }
       return false;
   }

   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int vtces = Integer.parseInt(br.readLine());
      ArrayList<Edge>[] graph = new ArrayList[vtces];
      for (int i = 0; i < vtces; i++) {
         graph[i] = new ArrayList<>();
      }

      int edges = Integer.parseInt(br.readLine());
      for (int i = 0; i < edges; i++) {
         String[] parts = br.readLine().split(" ");
         int v1 = Integer.parseInt(parts[0]);
         int v2 = Integer.parseInt(parts[1]);
         int wt = Integer.parseInt(parts[2]);
         graph[v1].add(new Edge(v1, v2, wt));
         graph[v2].add(new Edge(v2, v1, wt));
      }
      boolean[] vis = new boolean[vtces];
      for(int i=0;i<vtces;i++)
      {
        
          if(vis[i] == false){
          boolean ans = isCyclic(graph, vis, i);
          if(ans == true)
          {
              System.out.println(ans);
              return;
          }
      }}
      System.out.println(false);

      // write your code here
   }
}

// Topological sort =======================================

// topo sort with cycle
void dfs_topo(vector<vector<innt>>& graph, int src,vector<int>& ans,vector<int >& vis){
   vis[src]=1;
 
   for(int nbr:graph[src]){
       if(vis[nbr]==0){
           dfs_topo(graph,nbr,ans,vis);
       } else if(vis[nbr]==1){
           cycle=true;
       } else {
           continue;
       }
   }
 
    vis[src]=2;
   ans.push_back(src);
}
 
vector<int> topo_sort(vector<vector<int>>& graph,int N){
    vector<int> vis(N,0);
 
    vector<int> ans;
 
    for(int i=0; i<N; i++){
        if(!vis[i]){
            dfs_topo(graph,i,ans,vis);
        }
    }
 
    reverse(ans.begin(),ans.end());
 
    return ans;
 
}
 
//
void dfs_topo(vector<vector<innt>>& graph, int src,vector<int>& ans,vector<bool>& vis){
   vis[src]=true;
 
   for(int nbr:graph[src]){
       if(!vis[nbr]){
           dfs_topo(graph,nbr,ans,vis);
       }
   }
 
   ans.push_back(src);
}
 
vector<int> topo_sort(vector<vector<int>>& graph,int N){
    vector<bool> vis(N,false);
 
    vector<int> ans;
 
    for(int i=0; i<N; i++){
        if(!vis[i]){
            dfs_topo(graph,i,ans,vis);
        }
    }
 
    reverse(ans.begin(),ans.end());
 
    return ans;
 
}

/// Find Eventual safe states ===============

class Solution {
public:
    bool dfs(vector<vector<int>> &graph,vector<int> &vis,int src)
    {
      vis[src] = 1;
        for(int nbr : graph[src])
        {
            if(vis[nbr] == 0)
            {
                if(dfs(graph,vis,nbr))
                return true;
            }
            else if(vis[nbr] == 1)
                return true;
        }
        vis[src] = 2;
        return false;
        
    }
    vector<int> eventualSafeNodes(vector<vector<int>>& graph) {
        vector<int> vis(graph.size(),0);
        int n= graph.size();
        vector<int> ans;
        for(int i=0;i<n;i++)
        {
            if(vis[i] == 0)
            {
                bool as = dfs(graph,vis,i);
                if(!as) 
                    ans.push_back(i);
                
            }
            else if(vis[i] == 2)
                ans.push_back(i);
        }
        return ans;
    }
};

//  Kosa Raju ===============================

class Solution {
public:
    vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(vector<vector<char>> & board, int i, int j)
    {
        board[i][j] = '#';
        for(auto dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y] == 'O')
                dfs(board,x,y);
        }
    }
    void solve(vector<vector<char>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] == 'O')
                {
                    
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
};

/// Surrounded Regions ===========================

class Solution {
public:
    vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    void dfs(vector<vector<char>> & board, int i, int j)
    {
        board[i][j] = '#';
        for(auto dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<board.size() && y<board[0].size() && board[x][y] == 'O')
                dfs(board,x,y);
        }
    }
    void solve(vector<vector<char>>& board) {
        
        int m = board.size();
        int n = board[0].size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] == 'O')
                {
                    
                    dfs(board,i,j);
                }
            }
        }
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }
};

/// 1162. As Far from Land as Possible ========================================

class Solution {
public:
    int maxDistance(vector<vector<int>>& grid) {
        queue<int> q;
        int m = grid.size();
        int n = grid[0].size();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                    q.push(i*n+j);
            }
        }
        if(q.size() == m*n || q.size() == 0)
            return -1;
        
        int level = 0;
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
            int rp = q.front();
            q.pop();
            int i = rp/n;
            int j = rp%n;
            for(auto dir : dirs)
            {
                int x = i + dir[0]; 
                int y = j + dir[1];
                if(x>=0 && y>=0 && x<m && y<n && grid[x][y] == 0){
                    q.push(x*n+y);
                 grid[x][y] = 1;
                }
            }
            }
            level++;
            
        }
    return level-1;
    }
    
};



/// Walls and Gatess ==============================


class Solution {
public:
    /**
     * @param rooms: m x n 2D grid
     * @return: nothing
     */
    void wallsAndGates(vector<vector<int>> &rooms) {
        // write your code here
        queue<int> q;
        int n = rooms.size();
        int m = rooms[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(rooms[i][j] == 0)
                q.push(i*m+j);
            }
        }
        int level = 1;
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        while(q.size()>0)
        {
            int s = q.size();
            while(s-- > 0)
            {
              int rv = q.front();
              q.pop();
              int i = rv/m;
              int j = rv%m;
              for(auto dir : dirs)
              {
                  int x = i + dir[0];
                  int y = j + dir[1];
                  if(x>=0 && y>=0 && x<n && y<m && rooms[x][y] == 2147483647)
                  {
                      rooms[x][y] = level;
                      q.push(x*m + y);
                  }
              }
            }
            level++;
        }
    }
};




