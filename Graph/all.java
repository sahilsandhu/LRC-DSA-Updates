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

