You have been given an N*M matrix filled with integer numbers,
find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
From a cell in a row, you can move to another cell directly below that row, 
or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.
  
  
Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)


Input 1 :
2
4 4
1 2 10 4
100 3 2 1
1 1 20 2
1 2 2 1
3 3
10 2 3
3 7 2
8 1 5
Output 1 :
105
25

  
The maximum path sum will be 2->100->1->2, So the sum is 105(2+100+1+2).

In the second test case for the given matrix, the maximum path sum will be 10->7->8, So the sum is 25(10+7+8).

  
  Solution ---->
  
  
  
import java.util.* ;
import java.io.*; 
public class Solution {
	static int maxChocoUtil(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] dp) {
    if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
      return (int)(Math.pow(-10, 9));

    if (i == n - 1) {
      if (j1 == j2)
        return grid[i][j1];
      else
        return grid[i][j1] + grid[i][j2];
    }

    if (dp[i][j1][j2] != -1)
      return dp[i][j1][j2];

    int maxi = Integer.MIN_VALUE;
    for (int di = -1; di <= 1; di++) {
      for (int dj = -1; dj <= 1; dj++) {
        int ans;
        if (j1 == j2)
          ans = grid[i][j1] + maxChocoUtil(i + 1, j1 + di, j2 + dj, n, m, grid, dp);
        else
          ans = grid[i][j1] + grid[i][j2] + maxChocoUtil(i + 1, j1 + di, j2 + dj,n,m, grid, dp);
        maxi = Math.max(maxi, ans);
      }
    }
    return dp[i][j1][j2] = maxi;
  }
	public static int maximumChocolates(int r, int c, int[][] grid) {
		// Write your code here.
		int dp[][][] = new int[r][c][c];

    	for (int row1[][]: dp) {
    	  for (int row2[]: row1) {
    	    Arrays.fill(row2, -1);
    	  }
    	}

		return maxChocoUtil(0,0,c-1,r,c,grid,dp);

	}
}
