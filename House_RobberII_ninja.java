Problem Statement : -

It is possible for Mr. X to rob the same amount of money by looting two different sets of houses. 
  Just print the maximum possible robbed amount, irrespective of sets of houses robbed.
For Example:
(i) Given the input array arr[] = {2, 3, 2} the output will be 3 
  because Mr X cannot rob house 1 (money = 2) and then rob house 3 (money = 2), 
because they are adjacent houses. So, he’ll rob only house 2 (money = 3)

(ii) Given the input array arr[] = {1, 2, 3, 1} the output will be 4 
  because Mr X rob house 1 (money = 1) and then rob house 3 (money = 3).

(iii) Given the input array arr[] = {0} the output will be 0 because Mr. X has got nothing to rob.

Detailed explanation ( Input/output format, Notes, Constraints, Images )
Sample Input 1:
3
1
0
3
2 3 2
4
1 3 2 1
Sample Output 1:
0
3
4
  
  Solution -->
  import java.util.* ;
import java.io.*; 
public class Solution {
	static long solve(int[] arr){
    int n = arr.length;
    long prev = arr[0];
    long prev2 =0;
    
    for(int i=1; i<n; i++){
        long pick = arr[i];
        if(i>1)
            pick += prev2;
        long nonPick = 0 + prev;
        
        long cur_i = Math.max(pick, nonPick);
        prev2 = prev;
        prev= cur_i;
        
    }
    return prev;
}

static long houseRobber(int[] arr){
    int n= arr.length;
	int [] arr1= new int[n+1];
	int [] arr2= new int[n+1];

    if(n==1)
       return arr[0];
    
    for(int i=0; i<n; i++){
        
        if(i!=0) arr1[i]=arr[i];
        if(i!=n-1) arr2[i]=arr[i];
    }
    
    long ans1 = solve(arr1);
    long ans2 = solve(arr2);
    
    return Math.max(ans1,ans2);
}

}
