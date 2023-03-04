Problem Statement
You are given an array 'ARR' of 'N' positive integers. 
  Your task is to find if we can partition the given array into two subsets such that the sum of elements in both subsets is equal.
For example, let’s say the given array is [2, 3, 3, 3, 4, 5], then the array can be partitioned as [2, 3, 5], and [3, 3, 4] with equal sum 10.

    Follow Up:
Can you solve this using not more than O(S) extra space, where S is the sum of all elements of the given array?

  
  Sample Input 1:
2
6
3 1 1 2 2 1
5
5 6 5 11 6
Sample Output 1:
true
false    
  
  
Explanation Of Sample Input 1:
For the first test case, the array can be partitioned as ([2,1,1,1] and [3, 2]) or ([2,2,1], and [1,1,3]) with sum 5.

For the second test case, the array can’t be partitioned.

  
  Solution --->>
  
  public class Solution {

	static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        boolean [] prev = new boolean[k+1];
        prev[0] = true;
        
        
        
       if(arr[0]<=k)
        prev[arr[0]] = true;

        for(int ind=1; ind<n; ind++){
            boolean cur[]=new boolean[k+1];
            cur[0] = true;
            for(int target=1; target<=k; target++){
                 boolean notTaken = prev[target];
    
                 boolean taken = false;
                 if(arr[ind]<=target)
                     taken = prev[target-arr[ind]];

                cur[target]= notTaken || taken;     
            }
            prev = cur;
        }
        return prev[k];

    }
	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.

		int totSum = 0;
		for(int i=0; i<n; i++) totSum += arr[i];

		if(totSum % 2 == 1) return false;

		int target = totSum/2;

		return subsetSumToK(n,target,arr);


	}
}
