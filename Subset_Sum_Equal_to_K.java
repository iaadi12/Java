You are given an array/list ‘ARR’ of ‘N’ positive integers and an integer ‘K’.
  Your task is to check if there exists a subset in ‘ARR’ with a sum equal to ‘K’.
Note: Return true if there exists a subset with sum equal to ‘K’. Otherwise, return false.
  
  Sample Input 1:
2
4 5
4 3 2 1
5 4
2 5 1 6 7
Sample Output 1:
true
false

  Explanation For Sample Input 1:
In example 1, ‘ARR’ is {4,3,2,1} and ‘K’ = 5. There exist 2 subsets with sum = 5. These are {4,1} and {3,2}. Hence, return true.
In example 2, ‘ARR’ is {2,5,1,6,7} and ‘K’ = 4. There are no subsets with sum = 4. Hence, return false.

  
  SOLUTION  ---->>>
  
  
  import java.util.* ;
import java.io.*; 
public class Solution {
    static boolean fun(int ind, int target,int[] arr,int[][] dp){
    if(target==0)
        return true;
    
    if(ind == 0)
        return arr[0] == target;
    
    if(dp[ind][target]!=-1)
        return dp[ind][target]==0?false:true;
        
    boolean notTaken = fun(ind-1,target,arr,dp);
    
    boolean taken = false;
    if(arr[ind]<=target)
        taken = fun(ind-1,target-arr[ind],arr,dp);
    dp[ind][target]=notTaken | taken?1:0;
    return notTaken | taken;
}

    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int dp[][]=new int[n][k+1];
        for(int row[]: dp)
            Arrays.fill(row,-1);
        return fun(n-1,k, arr, dp);
    }
}
