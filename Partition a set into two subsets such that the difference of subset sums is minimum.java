You are given an array containing N non-negative integers. 
  Your task is to partition this array into two subsets such that the absolute difference between subset sums is minimum.
You just need to find the minimum absolute difference considering any valid division of the array elements.
Note:

1. Each element of the array should belong to exactly one of the subset.

2. Subsets need not be contiguous always. For example, for the array : {1,2,3}, some of the possible divisions are a) {1,2} and {3}  b) {1,3} and {2}.

3. Subset-sum is the sum of all the elements in that subset. 
  
  
Sample Input 1:
1
4
1 2 3 4
Sample Output 1:
0

We can partition the given array into {2,3} and {1,4}, as this will give us the minimum possible absolute difference i.e (5-5=0) in this case.
Sample Input 2:
1
3
8 6 5
Sample Output 2:
3
Explanation For Sample Input 2:
We can partition the given array into {8} and {6,5}, as this will give us the minimum possible absolute difference i.e (11-8=3) in this case

  
  SOultion --->>>
  
  
  import java.util.* ;
import java.io.*; 
public class Solution {
	public static int minSubsetSumDifference(int[] arr, int n) {
		// Write your code here.
		int totSum = 0;
		for(int i=0; i<n; i++) totSum += arr[i];

		int k = totSum;
		boolean dp[][]=new  boolean[n][k+1];
        
        for(int i=0; i<n; i++)
            dp[i][0] = true;
        
       if(arr[0]<=k)
        dp[0][arr[0]] = true;

        for(int ind=1; ind<n; ind++){
            for(int target=1; target<=k; target++){
                 boolean notTaken = dp[ind-1][target];
    
                 boolean taken = false;
                 if(arr[ind]<=target)
                     taken = dp[ind-1][target-arr[ind]];

                dp[ind][target]= notTaken || taken;     
            }
        }

		int mini = (int)Math.pow(10,9);

		for(int s1=0; s1<= totSum/2; s1++){

			if(dp[n-1][s1] == true)
				mini = Math.min(mini, Math.abs((totSum-s1)-s1));
		}
	return mini;

	}

}
