Problem Statement -->
    There is a frog on the '1st' step of an 'N' stairs long staircase. 
    The frog wants to reach the 'Nth' stair. 
    'HEIGHT[i]' is the height of the '(i+1)th' stair.
    If Frog jumps from 'ith' to 'jth' stair, the energy lost in the jump is given by absolute value of ( HEIGHT[i-1] - HEIGHT[j-1] ). 
    If the Frog is on 'ith' staircase, he can jump either to '(i+1)th' stair or to '(i+2)th' stair.
    Your task is to find the minimum total energy used by the frog to reach from '1st' stair to 'Nth' stair.
   
    If the given ‘HEIGHT’ array is [10,20,30,10], 
    the answer 20 as the frog can jump from 1st stair to 2nd stair (|20-10| = 10 energy lost) and 
    then a jump from 2nd stair to last stair (|10-20| = 10 energy lost).
    So, the total energy lost is 20.
        
Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1:
2
4
10 20 30 10
3
10 50 10
Sample Output 1:
20
0
    
    
    
    
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

    
Solution 2-->
        public static int frogJump(int n, int heights[]) {

        // Write your code here..
        int[] dp= new int[n];
        Arrays.fill(dp,-1);
        dp[0]=0;
        int ind;
        int fs;
        int ss = Integer.MAX_VALUE;
        for(ind = 1; ind<n; ind++){
             fs = dp[ind-1] + Math.abs(heights[ind]-heights[ind-1]);
            if(ind > 1)
                ss = dp[ind-2] + Math.abs(heights[ind]-heights[ind-2]);
        
        dp[ind] = Math.min(fs,ss);
        }
        return dp[n-1];
    }



Solution 3-->
 public static int frogJump(int n, int heights[]) {
    int prev=0;
        int prev2=0;
        int curr=0;
        int ind;
        int fs;
        int ss = Integer.MAX_VALUE;
        for(ind = 1; ind<n; ind++){
             fs = prev + Math.abs(heights[ind]-heights[ind-1]);
            if(ind > 1)
                ss = prev2 + Math.abs(heights[ind]-heights[ind-2]);
        
        curr = Math.min(fs,ss);
        prev2=prev;
        prev=curr;
        }
        return prev;
}
