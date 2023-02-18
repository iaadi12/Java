Solution 1--->
import java.util.* ;
import java.io.*; 


public class Solution {

    public static int fun(int ind, int[] height, int[] dp){
        if(ind == 0)return 0;
        if(dp[ind] != -1) return dp[ind];
        int right = Integer.MAX_VALUE;
        int left = fun(ind-1, height, dp) + Math.abs(height[ind] - height[ind-1]);
        if(ind > 1){
             right = fun(ind-2, height, dp) + Math.abs(height[ind] - height[ind-2]);
        }
        return dp[ind] = Math.min(left, right);
    }
    public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        return fun(n-1, heights, dp);
        
        
    }
