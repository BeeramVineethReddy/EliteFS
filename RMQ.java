/*
Malika taught a new fun time program practice for Engineering Students.
As a part of this she has given set of numbers, and asked the students 
to find the minimum number between indices S1 and S2 (S1<=S2), inclusive.

Now it’s your task to implement the Solution class:
	- Solution(int[] nums) : Initializes the object with the integer array nums .
	- int findMinimum(int S1, int S2) 
	Returns the minimum value in the subarray nums[S1, S2] 
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
2 9

Sample Output-1:
----------------
10208

NOTE: First 10 values of the input are: 
66905 11444 18252 54299 10208 59466 17861 24128 31974 69081


=====Testcases====
case =1
input =100
4 87
output =312

case =2
input =1000
78 951
output =537

case =3
input =10000
92 8765
output =113

case =4
input =25000
1145 18754
output =109

case =5
input =30000
12321 29876
output =110

case =6
input =35000
21321 34876
output =102

case =7
input =49999
567 43786
output =101

case =8
input =49999
1 575
output =312

*/
import java.io.*;
import java.util.*;
// Program for range minimum query using segment tree 
class Solution 
{ 
	int st[]; 
	int minVal(int x, int y) { 
		return (x < y) ? x : y; 
	} 

	int getMid(int s, int e) { 
		return s + (e - s) / 2; 
	} 

	int findMinimumUtil(int ss, int se, int qs, int qe, int index) 
	{ 

		if (qs <= ss && qe >= se) 
			return st[index]; 

		if (se < qs || ss > qe) 
			return Integer.MAX_VALUE; 

		int mid = getMid(ss, se); 
		return minVal(findMinimumUtil(ss, mid, qs, qe, 2 * index + 1), 
				findMinimumUtil(mid + 1, se, qs, qe, 2 * index + 2)); 
	} 

	int findMinimum(int n, int qs, int qe) 
	{ 
		if (qs < 0 || qe > n - 1 || qs > qe) { 
			return -1; 
		} 

		return findMinimumUtil(0, n - 1, qs, qe, 0); 
	} 

	int segmentTreeUtil(int arr[], int ss, int se, int si) 
	{ 
		if (ss == se) { 
			st[si] = arr[ss]; 
			return arr[ss]; 
		} 

		int mid = getMid(ss, se); 
		st[si] = minVal(segmentTreeUtil(arr, ss, mid, si * 2 + 1), 
				segmentTreeUtil(arr, mid + 1, se, si * 2 + 2)); 
		return st[si]; 
	} 

	void segmentTree(int arr[], int n) 
	{ 
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 


		int max_size = 2 * (int) Math.pow(2, x) - 1; 
		st = new int[max_size];

		segmentTreeUtil(arr, 0, n - 1, 0); 
	} 
}

public class RMQ{
	public static void main(String args[]) throws Exception
	{ 
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();     
		int[] nums=new int[n];
	    Scanner scan1 = new Scanner(new File("input2.txt"));
		for(int i=0; i<n; i++)
	    {
	 		 nums[i] = scan1.nextInt();
	    }
		Solution tree = new Solution(); 
		tree.segmentTree(nums, n); 
		int s1 = scan.nextInt();
		int s2 = scan.nextInt();

		System.out.println(tree.findMinimum(n, s1, s2)); 
	} 
} 
