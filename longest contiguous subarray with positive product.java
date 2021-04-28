/*
Ashok is given an array of integers nums.
His task is to find the longest contiguous subsequence S, 
the product of all the numbers in the subsequence should be positive.

Return the length of longest contiguous subarray.

Input Format:
-------------
Space separated integers nums[], list of numbers.

Output Format:
--------------
Print the length of the longest contiguous subsequence


Sample Input-1:
---------------
1 -1 2 -2

Sample Output-1:
----------------
4


Sample Input-2:
---------------
-1 -2 -3 0 1

Sample Output-2:
----------------
2

Explanation:
------------
0 is considered as positive number.


Sample Input-3:
---------------
1 2 3 4 -5 6  7 8

Sample Output-3:
----------------
4

*/

import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String[] q = sc.nextLine().split(" ");
        int n = q.length;
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i]=Integer.parseInt(q[i]);
        int fn = Integer.MAX_VALUE;
        int nc = 0;
        int zero = -1;
        int max = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                nc=0;
                fn=Integer.MAX_VALUE;
                zero = i;
                continue;
            }
            if(nums[i]<0)
            {
                nc++;
                fn=Math.min(fn,i);
            }
            if(nc%2==0)
            {
                max=Math.max(max,i-zero);
            }
            else
            {
                max = Math.max(max,i-fn);
            }
        }
        System.out.println(max);
    }
}