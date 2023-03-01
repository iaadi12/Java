(Image: CodeStudio)
Guided Paths
Contests
Interview Prep

Ninjaland is a country in the shape of a 2-Dimensional grid 'GRID', with 'N' rows and 'M' columns.
  Each point in the grid has some cost associated with it.
Find a path from top left i.e. (0, 0) to the bottom right i.e. ('N' - 1, 'M' - 1)
  which minimizes the sum of the cost of all the numbers along the path.
  You need to tell the minimum sum of that path.
  
  Sample Input 1:
2
2 3
5 9 6
11 5 2
1 1
5
Sample Output 1:
21
5

For this the grid the path with minimum value is (0,0) -> (0,1) -> (1,1) -> (1,2). And the sum along this path is 5 + 9 +5 + 2 = 21. So the ans is 21.

  
  Solutions-->
  
  1
  
  import java.util.* ;
import java.io.*; 
public class Solution {
    static int fun(int i, int j, int[][]grid, int[][]dp){
        if(i == 0 && j == 0)return grid[i][j];
        if(i < 0 || j < 0) return (int)Math.pow(10,9);
        if(dp[i][j] != -1) return dp[i][j];
        int up= grid[i][j]+fun(i-1,j,grid,dp);
        int left= grid[i][j]+fun(i,j-1,grid,dp);
        return dp[i][j] = Math.min(up,left);
    }
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp = new int[n][m];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return fun(n-1,m-1,grid,dp);
    }
}



2
  
  
  import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int n=grid.length;
        int m=grid[0].length;
        int[][] dp = new int[n][m];
        // for(int row[]: dp)
        //     Arrays.fill(row,);
        for(int i=0; i<n ; i++){
        for(int j=0; j<m; j++){
            if(i==0 && j==0) dp[i][j] = grid[i][j];
            else{
                
                int up = grid[i][j];
                if(i>0) up += dp[i-1][j];
                else up += (int)Math.pow(10,9);
                
                int left = grid[i][j];
                if(j>0) left+=dp[i][j-1];
                else left += (int)Math.pow(10,9);
                
                dp[i][j] = Math.min(up,left);
            }
        }
    }
    
    return dp[n-1][m-1];
    }
}


3
  
  import java.util.* ;
import java.io.*; 
public class Solution {
    public static int minSumPath(int[][] grid) {
    	// Write your code here.
        int n=grid.length;
        int m=grid[0].length;
        int [] prev = new int[n];
        for(int i=0; i<n ; i++){
            int curr[] = new int[m];
        for(int j=0; j<m; j++){
            if(i==0 && j==0) curr[j] = grid[i][j];
            else{
                
                int up = grid[i][j];
                if(i>0) up += prev[j];
                else up += (int)Math.pow(10,9);
                
                int left = grid[i][j];
                if(j>0) left+=curr[j-1];
                else left += (int)Math.pow(10,9);
                
                curr[j] = Math.min(up,left);
            }
        }
        prev=curr;
    }
    
    return prev[m-1];
    }
}
  
