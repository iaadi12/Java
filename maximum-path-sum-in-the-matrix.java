You have been given an N*M matrix filled with integer numbers,
find the maximum sum that can be obtained from a path starting from any cell in the first row to any cell in the last row.
From a cell in a row, you can move to another cell directly below that row, 
or diagonally below left or right. So from a particular cell (row, col), we can move in three directions i.e.
 
  Down: (row+1,col)
Down left diagonal: (row+1,col-1)
Down right diagonal: (row+1, col+1)


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

  
The maximum path sum will be 2->100->1->2, So the sum is 105(2+100+1+2).

In the second test case for the given matrix, the maximum path sum will be 10->7->8, So the sum is 25(10+7+8).

  
  SOLTUION --->
  
  import java.util.* ;
import java.io.*; 

public class Solution {
	// static int fun(int i, int j, int[][] matrix,int[][] dp){
	// 	if(j < 0 || j>= matrix[0].length)
	// 		return (int)Math.pow(-10,9);
	// 	if( i == 0) return matrix[0][j];
	// 	if(dp[i][j] != -1) return dp[i][j];
	// 	int s = matrix[i][j] + fun(i-1, j, matrix, dp); 
	// 	int ld = matrix[i][j] + fun(i-1, j-1, matrix, dp); 
	// 	int rd = matrix[i][j] + fun(i-1, j+1, matrix, dp); 

	// 	return dp[i][j] = Math.max(s,Math.max(ld,rd));
	// }
	public static int getMaxPathSum(int[][] matrix) {
		// Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		int[][] dp = new int[n][m];
		for(int row[]: dp)
			Arrays.fill(row,0);
		
		for(int j=0; j<m; j++) dp[0][j] = matrix[0][j];
		for(int i=1; i<n; i++){
			for(int j=0; j<m; j++){
				int s = matrix[i][j] + dp[i-1][j]; 
				int ld = matrix[i][j];
				if(j-1 >= 0){
					ld += dp[i-1][j-1];
				}
				else ld += (int)Math.pow(-10,9);
				int rd = matrix[i][j];
				if(j+1 < m){
					rd += dp[i-1][j+1];
				}
				else rd += (int)Math.pow(-10,9);
				dp[i][j] = Math.max(s,Math.max(ld,rd));
			}
		}

		int maxi = (int)Math.pow(-10,9);
		for(int j=0; j<m; j++){
			maxi = Math.max(maxi, dp[n-1][j]);
		}
		return maxi;
	}
}



Space Optimization --->
  import java.util.* ;
import java.io.*; 

public class Solution {
	public static int getMaxPathSum(int[][] matrix) {
		// // Write your code here
		int n = matrix.length;
		int m = matrix[0].length;
		
		int[] prev = new int[m];

		for(int j=0; j<m; j++) prev[j] = matrix[0][j];

		for(int i=1; i<n; i++){
			int[] curr = new int[m];
			for(int j=0; j<m; j++){

				int s = matrix[i][j] + prev[j]; 

				int ld = matrix[i][j];
				if(j-1 >= 0){
					ld += prev[j-1];
				}
				else ld += (int)Math.pow(-10,9);
				int rd = matrix[i][j];
				if(j+1 < m){
					rd += prev[j+1];
				}
				else rd += (int)Math.pow(-10,9);
				curr[j] = Math.max(s,Math.max(ld,rd));
			}
			prev = curr;
		}

		int maxi = (int)Math.pow(-10,9);
		for(int j=0; j<m; j++){
			maxi = Math.max(maxi, prev[j]);
		}
		return maxi;
	}
}
