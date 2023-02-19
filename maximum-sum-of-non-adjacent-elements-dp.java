Problem Statement
You are given an array/list of ‘N’ integers. 
  You are supposed to return the maximum sum of the subsequence
  with the constraint that no two elements are adjacent in the given array/list.

 Note:
A subsequence of an array/list is obtained by
deleting some number of elements (can be zero) from the array/list,
leaving the remaining elements in their original order.

  
Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1:
2
3
1 2 4
4
2 1 4 9
Sample Output 1:
5
11
  
  Solution 1-->
  
  import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	static int solveUtil(int ind, ArrayList<Integer> arr){
    if(ind<0)  return 0;
    if(ind==0) return arr.get(ind);
    int pick= arr.get(ind)+ solveUtil(ind-2, arr);
    int nonPick = 0 + solveUtil(ind-1, arr);
    
    return Math.max(pick, nonPick);
}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		return solveUtil(n-1, nums);
	}
}

Solution 2--->
  
  import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	static int solveUtil(int ind, ArrayList<Integer> arr,int[] dp){
    if(ind<0)  return 0;
    if(ind==0) return arr.get(ind);
    if(dp[ind]!=-1) return dp[ind];
    int pick= arr.get(ind)+ solveUtil(ind-2, arr,dp);
    int nonPick = 0 + solveUtil(ind-1, arr,dp);
    
    return dp[ind]=Math.max(pick, nonPick);
}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		int[] dp = new int[n];
		Arrays.fill(dp,-1);
		return solveUtil(n-1, nums,dp);
	}
}


Tabulation :-
	Solution 1-->
	import java.util.* ;
import java.io.*; 
import java.util.*;
public class Solution {
	static int solveUtil(int ind, ArrayList<Integer> arr,int[] dp){
    if(ind<0)  return 0;
    if(ind==0) return arr.get(ind);
    if(dp[ind]!=-1) return dp[ind];
    int pick= arr.get(ind)+ solveUtil(ind-2, arr,dp);
    int nonPick = 0 + solveUtil(ind-1, arr,dp);
    
    return dp[ind]=Math.max(pick, nonPick);
}
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		// Write your code here.
		int n=nums.size();
		int[] dp = new int[n];
		Arrays.fill(dp,-1);
		return solveUtil(n-1, nums,dp);
	}
}


Solution 2-->
	
