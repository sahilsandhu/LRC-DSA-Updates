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



// Number of Enclaves :::::::::::::: SAME (DFS)

class Solution {
public:
    
    void dfs(vector<vector<int>> &grid,int i,int j,vector<vector<int>> &dirs)
    {
        if(i<0 || j<0 || i==grid.size() || j==grid[0].size() || grid[i][j] == 0)
            return;
        
        grid[i][j] = 0;
        
        for(int k=0;k<4;k++)
        {
            int r = i+ dirs[k][0];
            int c = j+ dirs[k][1];
            dfs(grid,r,c,dirs);
        }
        
    }
    int numEnclaves(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        int count = 0;
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if((i==0 || j == 0 || i == m-1 || j == n-1) && grid[i][j]==1)
                    dfs(grid,i,j,dirs);
            }
        }
        
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j] == 1)
                    count++;
                
            }
        }
        return count;
    }
};


// Keys and Rooms ==================================
class Solution {
public:
    void dfs(vector<vector<int>> &graph, vector<int> &v,int src)
    {
        v[src] = true;
        for(auto a : graph[src])
        {
            if(v[a] == 0)
             dfs(graph,v,a);
        }
    }
    bool canVisitAllRooms(vector<vector<int>>& graph) {
        vector<int> vis(graph.size(),0);
        dfs(graph,vis,0);
        for(int i=0;i<graph.size();i++)
            if(vis[i] == 0)
                return false;
        return true;
    }
};

// 0 1 Matrix =======================================

class Solution {
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        queue<int> q;
        int n = mat.size();
        int m = mat[0].size();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j] == 0)
                {
                    q.push(i*m+j);
                }
                else
                {
                    mat[i][j] = -1;
                }
            }
        }
        int level = 0;
        vector<vector<int>> dirs = {{0,1},{1,0},{-1,0},{0,-1}};
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
                int t = q.front();
                q.pop();
                int i = t/m;
                int j = t%m;
                for(auto dir : dirs)
                {
                    int x = i + dir[0]; 
                    int y = j + dir[1];
                    if(x>=0 && y>=0 && x<n && y<m && mat[x][y] == -1)
                    {
                        mat[x][y] = level+1;
                        q.push(x*m+y);
                    }
                }
            }
            level++;
        }
        return mat;
    }
};


// Word Ladder =============================================

class Solution {
public:
    bool isdiff(string a,string b)
    {
        if(a.size() != b.size())
            return false;
        int count =0;
        for(int i=0;i<a.size();i++)
        {
            if(a[i] != b[i])
                count++;
            if(count > 1)
                return false;
        }
        return true;
    }
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        queue<string> q;
        q.push(beginWord);
        int level = 1;
        vector<bool> vis(n,false);
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
               string val = q.front();
                q.pop();
                for(int i=0;i<n;i++)
                {
                    if(isdiff(val,wordList[i]))
                    {
                        if(vis[i] == false){
                        if(wordList[i] == endWord)
                        {
                            return level+1;
                        }
                        vis[i] = true;
                        q.push(wordList[i]);
                    }
                    }
                }
            }
            level++;
        }
        return 0;
    }
};


// Word Ladder - 2 ========================================

class Solution {
public:
    bool isdiff(string a, string b)
    {
int c = 0;
        int i = 0;
        while(i<a.size())
        {
            if(a[i] != b[i])
                c++;
            if(c>1)return false;
            i++;
        }
        return c==1;
    }
    vector<vector<string>> findLadders(string beginWord, string endWord, vector<string>& wordList) {
        int n = wordList.size();
        vector<string> v = {beginWord};  
        queue<vector<string>> q;
        q.push(v);
        vector<bool> vis(n,false);
        vector<int> index;
        int count = 0;
        vector<vector<string>> ans;
        while(q.size() > 0)
        {
            int s = q.size();
                       

            while(s-- > 0)
            {
                auto rp = q.front();
                q.pop();
                string word = rp[rp.size()-1];
                if(word == endWord)
                    return ans;
                for(int i=0;i<n;i++)
                {
                    if(vis[i] == false) ///////
                    {
                      if(isdiff(wordList[i],word)) 
                        { 
                           rp.push_back(wordList[i]);
                           index.push_back(i);
                            if(wordList[i] == endWord)
                            {
                                if(count == 0)
                                {
                                   count = rp.size();
                                   ans.push_back(rp);
                                   index.pop_back();
                                    
                                }else if(count >= rp.size())
                                {
                                   ans.push_back(rp);
                                    index.pop_back();
                                        
                                }
                            }
                          q.push(rp);
                          rp.pop_back();
                        }
                    }
                }
            }
            
            int i = 0;
            while(i < index.size())
            {
                vis[index[i]] = true;
                i++;
            }
        }
        return ans;
    }
};


//  Minimum Genetic Mutation ===============================

class Solution {
public:
     bool isonediff(string a, string b)
    {
int c = 0;
        int i = 0;
        while(i<a.size())
        {
            if(a[i] != b[i])
                c++;
            if(c>1)return false;
            i++;
        }
        return c==1;
    }
    int minMutation(string start, string end, vector<string>& bank) {
        int level = 1;
        int n = bank.size();
        queue<string> q;
        q.push(start);
        vector<int> vis(bank.size(),0);
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
            string s = q.front();
            q.pop();
            for(int i=0;i<n;i++)
            {
                if(vis[i] == false)
                {
                    if(isonediff(s,bank[i]))
                    {
                        if(bank[i] == end)
                        {
                            return level;
                        }
                        vis[i] = 1;
                        q.push(bank[i]);
                    }
                }
            }
            }
            level++;
        }
        return -1;
    }
};


// Is graph bipartite ======================================


class Solution {
public:
    bool helper(vector<vector<int>> &graph,vector<int> &vis,int src)
    {
        queue<int> q;
        q.push(src);
        int color = 0;
        while(q.size() > 0)
        {
            int s = q.size();
            while(s-- > 0)
            {
                int top = q.front();
                q.pop();
                if(vis[top]!=-1 && vis[top] != color)
                {
                    return true;
                }
                vis[top] = color;
                
               for(int nbr : graph[top])
               {
                   if(vis[nbr] == -1)
                       q.push(nbr);
               }
            }
            color  = (color+1)%2;
        } 
        return false;
    }
    
    bool isBipartite(vector<vector<int>>& graph) {
        int n = graph.size();
        vector<int>vis(n,-1);
        for(int i=0;i<n;i++){
            if(vis[i]==-1)
        if(helper(graph,vis,i)) return false;}
        return true;
    }
};


// Journey to the moon =========================+

#include <bits/stdc++.h>

using namespace std;

string ltrim(const string &);
string rtrim(const string &);
vector<string> split(const string &);

/*
 * Complete the 'journeyToMoon' function below.
 *
 * The function is expected to return an INTEGER.

 * The function accepts following parameters:
 *  1. INTEGER n
 *  2. 2D_INTEGER_ARRAY astronaut
 */

int dfs(vector<vector<int>> &graph,vector<bool> &vis,int src)
{
    int size = 0;
    vis[src] = true;
    for(auto nbr : graph[src])
    if(vis[nbr] == false)
    {
        size += dfs(graph,vis,nbr);
    }
    
    return size+1;
}
long long journeyToMoon(int n, vector<vector<int>> edge) {
vector<vector<int>>graph(n);
for(auto ed : edge)
{
    int u = ed[0];
    int v = ed[1];
graph[u].push_back(v);
graph[v].push_back(u);
}
vector<bool> vis(n,false);
vector<int> si;
for(int i=0;i<n;i++)
if(vis[i] == false){
    int size = dfs(graph,vis,i);
    si.push_back(size);
}
long long ans = 0;
long long cans = si[0];
for(int i=1;i<si.size();i++)
{
    ans+=(cans*si[i]);
    cans+=si[i];
}
return ans;

}

int main()
{
    ofstream fout(getenv("OUTPUT_PATH"));

    string first_multiple_input_temp;
    getline(cin, first_multiple_input_temp);

    vector<string> first_multiple_input = split(rtrim(first_multiple_input_temp));

    int n = stoi(first_multiple_input[0]);

    int p = stoi(first_multiple_input[1]);

    vector<vector<int>> astronaut(p);

    for (int i = 0; i < p; i++) {
        astronaut[i].resize(2);

        string astronaut_row_temp_temp;
        getline(cin, astronaut_row_temp_temp);

        vector<string> astronaut_row_temp = split(rtrim(astronaut_row_temp_temp));

        for (int j = 0; j < 2; j++) {
            int astronaut_row_item = stoi(astronaut_row_temp[j]);

            astronaut[i][j] = astronaut_row_item;
        }
    }

    int result = journeyToMoon(n, astronaut);

    fout << result << "\n";

    fout.close();

    return 0;
}

string ltrim(const string &str) {
    string s(str);

    s.erase(
        s.begin(),
        find_if(s.begin(), s.end(), not1(ptr_fun<int, int>(isspace)))
    );

    return s;
}

string rtrim(const string &str) {
    string s(str);

    s.erase(
        find_if(s.rbegin(), s.rend(), not1(ptr_fun<int, int>(isspace))).base(),
        s.end()
    );

    return s;
}

vector<string> split(const string &str) {
    vector<string> tokens;

    string::size_type start = 0;
    string::size_type end = 0;

    while ((end = str.find(" ", start)) != string::npos) {
        tokens.push_back(str.substr(start, end - start));

        start = end + 1;
    }

    tokens.push_back(str.substr(start));

    return tokens;
}


// ISland Perimeter =====================

class Solution {
public:
    int islandPerimeter(vector<vector<int>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        //vector<vector<int>> vis(n,vector<int>(m));
        vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
        int ans = 0;
        for(int i=0;i<n;i++)
        {
            for(int  j=0;j<m;j++)
            {
                int count= 0;
                if(grid[i][j] == 1)
                {
                    for(auto dir : dirs)
                    {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x>=0 && y>=0 && x<n && y<m && grid[x][y] == 1)
                        {
                            count++;
                        }
                    }
                ans+=(4-count);
                }
            }
        }
        return ans;
    }
};


// Redundant Connection ==================================

class Solution {
public:
    
    vector<int> parent;
    vector<int> size;
    int findParent(int u )
    { if(parent[u] == u)
        return u;
     else 
         return parent[u] = findParent(parent[u]);
        
    }
    void merge(int u, int v)
    {
        if(size[u] > size[v])
        {
            parent[v] = u;
            size[u] += size[v];
        }
        else
        {
            parent[u] = v;
            size[v] += size[u];
        }
    }
    vector<int> findRedundantConnection(vector<vector<int>>& edges) {
          int n = edges.size();
        parent.resize(n+1);
        size.resize(n+1);
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
        int x = -1,y = -1;
        for(auto ed : edges)
        {
            int u = ed[0];
            int v = ed[1];
            int par1 = findParent(u);
            int par2 = findParent(v);
            if(par1 == par2)
            {
                x = u;
                y = v;
            }
            else
            {
                merge(par1,par2);
          }
        }
        vector<int> ans = {x,y};
        return ans;
    }
};


// Count server that communicate =============================

class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
       int n = grid.size();
       int m = grid[0].size();
        vector<int> left(n,0);
        vector<int> right(m,0);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                left[i]+=grid[i][j];
            }
        }
        for(int j=0;j<m;j++)
         for(int i=0;i<n;i++)
            {
                right[j] += grid[i][j];
            }
        int count = 0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    if(left[i]>1 || right[j] > 1)
                        count++;
                }
            }
        }
        return count;
        
    }
};

// Similar String groups =======================================

class Solution {
public:
    int countServers(vector<vector<int>>& grid) {
       int n = grid.size();
       int m = grid[0].size();
        vector<int> left(n,0);
        vector<int> right(m,0);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                left[i]+=grid[i][j];
            }
        }
        for(int j=0;j<m;j++)
         for(int i=0;i<n;i++)
            {
                right[j] += grid[i][j];
            }
        int count = 0;
         for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j] == 1)
                {
                    if(left[i]>1 || right[j] > 1)
                        count++;
                }
            }
        }
        return count;
        
    }
};


// Count sub island ================================================

class Solution {
public:
    vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    bool dfs(vector<vector<int>>&grid1, vector<vector<int>>&grid2, int i,int j)
    {
        grid2[i][j] = 0;
        bool ans = true;
        for(auto dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<grid1.size() && y<grid1[0].size() && grid2[x][y] == 1 && grid1[x][y] == 1)
              ans = dfs(grid1,grid2,x,y) && ans;
        }
        return ans && grid1[i][j] == 1;
    }
    
    int countSubIslands(vector<vector<int>>& grid1, vector<vector<int>>& grid2) {
        int n = grid1.size();
        int m = grid1[0].size();
        int count = 0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid1[i][j] == 1 && grid2[i][j] == 1)
                {
                   bool ans = dfs(grid1, grid2,i,j);
                    if(ans)
                    count++;
                }
            }
        }
        return count;
    }
};

// Number of island 2

class Solution {
public:
    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */

     vector<int> parent;
    int findParent(int u)
    {
         if(parent[u] == u)
         return u;
         return parent[u] = findParent(parent[u]);
    }
    vector<int> numIslands2(int n, int m, vector<Point> &operators) {
        // write your code here
    parent.resize(n*m, -1);
    vector<int> ans;
    vector<vector<int>> dirs = {{1,0},{0,1},{-1,0},{0,-1}};
    int count = 0;
    for(Point op : operators)
    {
        int i = op.x;
        int j = op.y;
        int idx = i*m+j;
        if(parent[idx] != -1)
        {
            ans.push_back(count);
            continue;
        }
        count++;
        parent[idx] = idx;
        for(auto dir : dirs)
        {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x>=0 && y>=0 && x<n && y<m && parent[x*m+y] != -1)
            {
                int par1 = findParent(x*m+y);
                int par2 = findParent(idx);
                if(par1 != par2)
                {
                    parent[par1] = par2;
                    count--;
                }
            }
        }
        ans.push_back(count);
    }
    return ans;
    }
};


// 1584. Min Cost to Connect All Points ==========================================

class Solution {
public:
    vector<int> parent;
    int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    int mst(vector<vector<int>> &edges, int n)
    {
        parent.resize(n,-1);
        for(int i=0;i<n;i++)
            parent[i] = i;
        //queue<int>q;
        int ans = 0;
        sort(edges.begin(),edges.end());
        for(auto ed : edges)
        {
            int u= ed[1]; 
            int v= ed[2];
            int par1 = findParent(u);
            int par2 = findParent(v);
            if(par1 != par2)
            {
                parent[par1] = par2; 
                ans+=ed[0];
            }
        }
        return ans;
        
    }
    int minCostConnectPoints(vector<vector<int>>& pt) {
        vector<vector<int>> edges;
        int n = pt.size();
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                int x1 = pt[i][0];
                int y1 = pt[i][1];
                int x2 = pt[j][0];
                int y2 = pt[j][1];
                int ans = abs(x1 - x2) + abs(y1 - y2);
                edges.push_back({ans,i,j});
            }    
        }
        return mst(edges,n);
    }
};


// optimize water distribution ===============================================

#include<bits/stdc++.h>
using namespace std;

vector<int> par;
vector<vector<int>> dir{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
int findPar(int u)
{
    return par[u] == u ? u : (par[u] = findPar(par[u]));
}

int minCostToSupplyWater(int n, vector<int>&wells, vector<vector<int>>& pipes){
    for (int i = 0; i < wells.size(); i++)
    {
        pipes.push_back({0, i + 1, wells[i]});
    }

    sort(pipes.begin(), pipes.end(), [](vector<int> &a, vector<int> &b)
         { return a[2] < b[2]; });

    for (int i = 0; i <= n; i++)
        par.push_back(i);

    int cost = 0;
    for (vector<int> &e : pipes)
    {
        int u = e[0], v = e[1], w = e[2];
        int p1 = findPar(u), p2 = findPar(v);
        if (p1 != p2)
        {
            par[p1] = p2;
            cost += w;
        }
    }

    return cost;
}


int main(){
    int v,e;
    cin>>v>>e;
    
    
    vector<int>wells(v);
    
    for(int i=0;i<v;i++){
        cin>>wells[i];
    }
    
    
    vector<vector<int>>pipes(e,vector<int>(3));
    
    for(int i=0;i<e;i++){
        for(int j=0;j<3;j++){
            cin>>pipes[i][j];
        }
    }
    
    cout<<minCostToSupplyWater(v, wells, pipes);
    
}


// connecting cities with minimum costs  ===================================

#include<algorithm>
vector<int> parent;        // Write your code here.
int findParent(int u)
{
    if(u == parent[u])
        return u;
    return parent[u] = findParent(parent[u]);
}

int getMinimumCost(int n, int m, vector<vector<int>> &edges)
{
sort(edges.begin(),edges.end(),[&](vector<int> a,vector<int> b){
            return a[2] > b[2];
        });
        
        parent.resize(n,0);
        for(int i=0;i<n;i++)
            parent[i] = i;
        
        int comp = n;
        int cost = 0;
        for(auto ed : edges)
        {
            int u = ed[0];
            int v = ed[1];
            int w = ed[2];
            int p1 = findParent(u);
            int p2 = findParent(v);
            if(p1!=p2)
            {
                parent[p1] = p2; 
                cost+=w;
                comp--;
            }  
        }
        return comp==0?cost:-1;
    }
   
	//	Write your code here.

// Satisfiability of equations equation ========================

class Solution {
public:
    vector<int> parent;
    vector<int> size;
    int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    void merge(int p1,int p2)
    {
        if(size[p1] < size[p2])
        {
            parent[p1] = p2;
            size[p2]+=size[p1];
        }
        else
        {
            parent[p2] = p1;
            size[p1]+=size[p2];
        }
    }
    bool equationsPossible(vector<string>& equations) {
       parent.resize(26,0);
        size.resize(26,0);
        for(int i=0;i<26;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
        for(auto eq : equations)
        {
            if(eq[1] == '=')
            {
                int u = eq[0]-'a';
                int v = eq[3] - 'a';
                int par1 = findParent(u);
                int par2 = findParent(v);
                if(par1 != par2)
                merge(par1,par2);
            }
        }
        for(auto eq : equations)
        {
            if(eq[1] != '=')
            {
                int u = eq[0]-'a';
                int v = eq[3] - 'a';
                int par1 = findParent(u);
                int par2 = findParent(v);
                if(par1==par2)
                {
                    return false;
                }
            }
        }
        return true;
    }
}; 


// Number of opreations to make network connected ================================

class Solution {
public:
    vector<int> parent;
    int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    int makeConnected(int n, vector<vector<int>>& connections) {
        parent.resize(n,1);
        for(int i=0;i<n;i++)
            parent[i] = i;
        int cable = 0;
        for(auto val :  connections)
        {
            int u = val[0];
            int v = val[1];
            int par1 = findParent(u);
            int par2 = findParent(v);
            if(par1!=par2)
            {
                parent[par1] = par2;
            }
            else
                cable++;
        }
        
        int nodes = 0;
        for(int i=0;i<n;i++)
        {
            if(parent[i] == i)
               nodes++;
        }
        nodes--;
        return cable>=nodes?nodes:-1;
    }
};

// Minimize Malware Spread =============================

class Solution {
public:
    vector<int> parent;
    vector<int> size;
    int findParent(int u)
    {
        return parent[u]==u ? u : parent[u] = findParent(parent[u]);
    }
    void merge(int a,int b)
    {
        if(size[a] > size[b])
        {
            parent[b] = a;
            size[a]+=size[b];
        }else
        {
            parent[a] = b;
            size[b]+=size[a];
        }
    }
    int minMalwareSpread(vector<vector<int>>& graph, vector<int>& initials) {
        int n = graph.size();
        int m = graph[0].size();
        parent.resize(n,1);
        size.resize(n,1);
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
            size[i] = 1;
        }
        
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(graph[i][j] == 1)
                {
                    int p1 = findParent(i);
                    int p2 = findParent(j);
                    if(p1!=p2)
                    {
                        merge(p1,p2);
                    }
                }
            }
        }
        vector<int> count(n);
        for(int val : initials)
        {
            int p = findParent(val);
            count[p]++;
        }
        int maxi = -1;
        int ans = -1;
        for(int val : initials)
        {
            int p = findParent(val);
            if(count[p] == 1 && size[p] >= maxi)
            {
                if(maxi == size[p])
                {
                 ans =  min(val,ans);   
                }
                else
                {
                ans = val;
                }
                maxi = size[p];
            }
        }
        if(ans != -1)
            return ans;
        else
        {
            ans = n+1;
            for(int val: initials)
                ans = min(ans,val);
            return ans;
        }
    }
};



// Course Schedule 

class Solution {
public:
    bool canFinish(int n, vector<vector<int>>& courses) {
         vector<int> graph[n];
        for(int i=0;i<courses.size();i++)
        {
            graph[courses[i][0]].push_back(courses[i][1]);
            
        }
        vector<int>indegree(n,0);
        for(int i=0;i<n;i++)
        {
            for(int val : graph[i])
            {
                indegree[val]++;
            }
        }
        queue<int>q;
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0)
                q.push(i);
        }
        int cnt = 0;
        while(q.size() > 0)
        {
            int t = q.front();
            q.pop();
            for(int u : graph[t])
            {
                indegree[u]--;
                if(indegree[u] == 0)
                    q.push(u);
            }
            cnt++;
        }
        if(cnt!=n)
            return false;
        else
            return true;
       
    }
};

// minimum hamming distance ====================================

class Solution {
    int[] parent;
    
    int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }
        for(var val : allowedSwaps)
        {
            int u = val[0];
            int v = val[1];
            int p1 = findParent(u);
            int p2 = findParent(v);
            if(p1!=p2)
                parent[p1] = p2;
        }
        
        HashMap<Integer, HashMap<Integer,Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int root = findParent(i);
            int num = source[i];
            if(!hm.containsKey(root))
            {
                hm.put(root, new HashMap<>());
            }
            HashMap<Integer,Integer> mp = hm.get(root);
            if(mp.containsKey(num))
            {
                mp.put(num,mp.get(num)+1);
            }
            else
            {
                mp.put(num,1);
            }
        }
        int hd = 0;
        for(int i=0;i<n;i++)
        {
            int root = findParent(i);
            int num = target[i];
            HashMap<Integer,Integer>mp = hm.get(root);
            if(!mp.containsKey(num))
            {
                hd++;
                continue;
            }
            if(mp.get(num) <= 0)
                hd++;
            mp.put(num,mp.get(num)-1);
        }
        return hd;
    }
}

//  Parallel Course 2 ======== Topological Sort =========

class Solution {
public:
    int minimumTime(int n, vector<vector<int>>& relations, vector<int>& time) {
        vector<vector<int>> graph(n+1);
        vector<int> maxtime(n+1,0);
        for(auto val : relations)
        {
            graph[val[0]].push_back(val[1]);
        }
        vector<int> indegree(n+1,0);
        
        for(int i=0;i<=n;i++)
        {
            for(int v : graph[i])
            {
                indegree[v]++;
            }
        }
        queue<int>q;
        for(int i=1;i<=n;i++)
        {
            if(indegree[i] == 0)
                q.push(i);
        }
        
        int ans = 0;
        while(q.size() > 0)
        {
            int s = q.size();
            int m = 0;
            while(s-- > 0)
            {
                int t = q.front();
                q.pop();
                for(auto nbr : graph[t])
                {
                    indegree[nbr]--;
                    maxtime[nbr] = max(time[t-1],maxtime[nbr]);
                    if(indegree[nbr] == 0){
                     time[nbr-1] += maxtime[nbr];
                        q.push(nbr);
                    }
                }
            }
              
        } 
        ans = INT_MIN;
          for(int val : time)
              ans = max(ans, val);
          
        return ans;
    }
};


// Regions Cut by Slashes ============================================
/* 
Here we assume a 2 d matrix and we work only on the cells of those matrixs.
*/
class Solution {
        int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    
    void merge(int u,int v)
    {
        int p1 = findParent(u);
        int p2 = findParent(v);
        if(p1!=p2)
        {
            if(rnk[p1] > rnk[p2])
            {
                parent[p2] = p1;
                rnk[p1]+= rnk[p2];
            }
            else{
                parent[p1] = p2;
                rnk[p2]+= rnk[p1];
            }
        }
        else
        {
            count++;
        }
    }
    int[] parent;
    int[] rnk;
    int count;

    public int regionsBySlashes(String[] grid) {
        int size = grid.length+1;
        //int n = size;
        parent = new int[size*size];
        rnk =   new int[size*size];
        count = 1;
        
        for(int i=0;i<parent.length;i++)
        {
            parent[i] = i; 
            rnk[i] = 1;
        }
        
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                if(i==0 || j==0 || i == size-1 || j==size-1)
                {
                    int cell = i*size+j;
                    if(cell != 0)
                        merge(0,cell);
                }
            }
        }
        
        for(int i=0;i<grid.length;i++)
        {
            char[] ch = grid[i].toCharArray();
            for(int j=0;j<ch.length;j++)
            {
                if(ch[j] == '/')
                {
                   int p1 = (i+1)*size+j;
                   int p2 = i*size+(j+1);
                    merge(p1,p2);
                }
                else if(ch[j] == '\\')
                {
                    int p1 = i*size+j;
                    int p2 = (i+1)*size+(j+1);
                    merge(p1,p2);
                }
            }
        }
        return count;
        
    }
}


// Redundant Connection 2 


//Note : Whenever a tree get converted into the graph with an extra edge 3 cases will occur:
// 1. A Cycle will form
// 2. An Edge will have 2 parent
// 3. A cycle will form and also one edge will have 2 parent.
// Note : we can't use the DSU to find the cycle in a directed graph, but if we are sure that cycle is present in the graph, and there is only one cycle which
// is present. so we can use the DSU to find the last edge due to which the cycle is present.
// 

class Solution {
public:
    vector<int> parent;
    vector<int> size;
    
    int findParent(int u)
    {
        if(parent[u] == u)
            return u;
        return parent[u] = findParent(parent[u]);
    }
    void merge(int u, int v)
    {
        if(size[u] > size[v])
        {
            parent[v] = u;
            size[u]+=size[v];
        }
        else
        {
            parent[u] = v;
            size[v]+=size[u];
        }
    }
    vector<int> findRedundantDirectedConnection(vector<vector<int>>& edges) {
    
        int n = edges.size();
        vector<int> indegree(n+1,-1);
        int blacklist1 = -1;
        int blacklist2 = -1;
        for(int i=0;i<n;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            if(indegree[v] == -1)
               indegree[v] = i;
            else
            {    blacklist1 = i;
                 blacklist2 = indegree[v];
             break;
            }
                
        }
        parent.resize(n+1,0);
        size.resize(n+1,1);
        for(int i=1;i<=n;i++)
            parent[i] = i;
        
        for(int i=0;i<n;i++)
        {
            if(i == blacklist1)
                continue;
            int u = edges[i][0];
            int v = edges[i][1];
            int p1 = findParent(u);
            int p2 = findParent(v);
            if(p1!=p2)
                merge(p1,p2);
            else
            {
              if(blacklist1 == -1)   // case 2 ------ cycle, no 2 parent
                  return edges[i]; 
              else    
              return edges[blacklist2]; // case 3 ----- cycle and 2 parent
            }
        }
        return edges[blacklist1]; // case 1 ------ 2 parent
    }
};

