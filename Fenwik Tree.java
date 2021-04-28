/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the sum of numbers between indices S1 and S2 (S1<=S2), inclusive.

Now it’s your task to implement the Solution class:
	- Solution(int[] nums) : Initializes the object with the integer array nums .
	- int sum(int S1, int S2) Returns the sum of the subarray nums[S1, S2] 
	(i.e., nums[S1] + nums[S1 + 1], ..., nums[S2] ).


Input Format:
-------------
Line-1: An integer n, size of the array nums[] (set of numbers).
		where 1<= n <= 50000
Line-2: Two integers S1 and S2, index positions 
		where 0 <= S1 <= S2 < n
		and 1<= nums[i] <= 9999.

Output Format:
--------------
An integer, sum of integers between indices(s1, s2).


Sample Input-1:
---------------
8
2 6

Sample Output-1:
----------------
34562

NOTE: First 8 values of the input are: 9530 5518 8598 4698 6726 5259 9281 827
*/

import java.io.*;
import java.util.*;

class Solution {
	int[] nums;
	long[] BIT;
	int n;

	public Solution(int[] nums) {
		this.nums = nums;

		n = nums.length;
		BIT = new long[n + 1];
		for (int i = 0; i < n; i++)
			init(i, nums[i]);
	}

	public void init(int i, int val) {
		i++;
		while (i <= n) {
			BIT[i] += val;
			i += (i & -i);
		}
	}

	public long getSum(int i) {
		long sum1 = 0;
		i++;
		while (i > 0) {
			sum1 += BIT[i];
			i -= (i & -i);
		}
		return sum1;
	}

	public long sum(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}
}

public class NumArray{
	public static void main(String args[] ) throws Exception{
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();     
		int[] nums=new int[n];
	    Scanner scan1 = new Scanner(new File("input.txt"));
		for(int i=0; i<n; i++)
	    {
	 		 nums[i] = scan1.nextInt();
	    }
	    Solution s=new Solution(nums);
		int s1 = scan.nextInt();
		int s2 = scan.nextInt();
		System.out.println(s.sum(s1,s2));
	}
}