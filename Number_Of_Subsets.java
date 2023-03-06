Problem Statement
You are given an array (0-based indexing) of positive integers and you have to tell how many different ways of selecting
the elements from the array are there such that the sum of chosen elements is equal to the target number “tar”.

  
  Note:
Two ways are considered different if sets of indexes of elements chosen by these ways are different.

Input is given such that the answer will fit in a 32-bit integer.

  If N = 4 and tar = 3 and the array elements are [1, 2, 2, 3], then the number of possible ways are:
{1, 2}
{3}
{1, 2}
Hence the output will be 3.

  Sample Input 1 :
2
4 3
1 2 2 3
2 3
1 2
Sample Output 1 :
 3
 1


Explanation For Sample Output 1:
For the first test case, N = 4 and tar = 3 and array elements are [1, 2, 2, 3] then the number of possible ways of making sum = 5 are:
{1,2}
{3}
{1,2}

Hence the output will be 3.

For the second test case, N = 2 and tar = 3 and array elements are [1, 2], there is only one way of making sum = 3 which is {1,2}.

Hence the output will be 1.

  SOLUTION ----->>>>
  import java.util.* ;

// import sun.java2d.marlin.DPathConsumer2D;

import java.io.*; 
public class Solution {
    // static int fun(int ind,int sum, int[] nums, int[][] dp)
    // {
    //     if(sum == 0) return 1;
    //     if(ind == 0) return nums[0]==sum?1:0;
            if(i == 0){
                     if(target ==0 || arr[0]==0) return 1;
                     if(target == 0 || target == arr[0]) return 1;
                     return 0;
                 }

    //     if(dp[ind][sum] != -1) return dp[ind][sum];

    //     int nontake = fun(ind-1,sum,nums,dp);
    //     int take = 0;

    //     if(nums[ind] <= sum) 
    //         take = fun(ind-1,sum-nums[ind], nums, dp);

    //     return dp[ind][sum] = take+nontake;
    }
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n=num.length;
        int[][] dp = new int[n][tar+1];
        for(int row[] : dp)
            Arrays.fill(row,0);

        for(int i=0; i<n; i++) dp[i][0] = 1;

        if(num[0] <= tar) dp[0][num[0]]=1;

        for(int ind=1; ind<n; ind++){
            for(int sum = 0; sum<=tar; sum++){
                int nontake = dp[ind-1][sum];
                int take = 0;

                if(num[ind] <= sum) 
                    take = dp[ind-1][sum-num[ind]];

                dp[ind][sum] = take+nontake;
                    }
        }
        return dp[n-1][tar];
    }
}
  
SPace Optimization --->>>>

import java.util.* ;

// import sun.java2d.marlin.DPathConsumer2D;

import java.io.*; 
public class Solution {
    public static int findWays(int num[], int tar) {
        // Write your code here..
        int n=num.length;
        int[] prev = new int[tar+1];

        prev[0] = 1;

        if(num[0] <= tar) prev[num[0]]=1;

        for(int ind=1; ind<n; ind++){
            int[] curr = new int[tar+1];
            curr[0] =1;
            for(int sum = 0; sum<=tar; sum++){
                int nontake = prev[sum];
                int take = 0;

                if(num[ind] <= sum) 
                    take = prev[sum-num[ind]];

                curr[sum] = take+nontake;
            }
            prev = curr;
        }
        return prev[tar];
    }
}
