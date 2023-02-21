There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]).
  The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]).
  The robot can only move either down or right at any point in time.
  
  

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.

 

Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down

Solution -->
  class Solution {
    static int fun(int n, int m, int[][] dp){
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(dp[n][m]!=-1) return dp[n][m];
        int up = fun(n-1, m,dp);
        int dn = fun(n, m-1,dp);
        dp[n][m]=up+dn;
        return dp[n][m];
        // if(n == 0 && m == 0) return 1;
        // if(n < 0 || m < 0) return 0;
        // int up = fun(n-1, m);
        // int dn = fun(n, m-1);
        // return up+dn;
    }
    public int uniquePaths(int m, int n) {
        // int N = n+m-2;
        // int r = m-1;
        // double res = 1;
        // for(int i=1; i<=r; i++)
        //     res = res*(N - r + i) / i;
        // return (int)res;
        int dp[][]=new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);  
        return fun(m-1,n-1,dp);
    }
}
