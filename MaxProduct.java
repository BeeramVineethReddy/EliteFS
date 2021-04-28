/*
You are given a list of N integers List[], list contains both +ve and -ve integers.
Your task is to findout, the Highest Product possible,
Where the product is the product of all the elements of contiguous sublist sList[],
and sub list should conatin atleast 1 integer.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
Print an integer output, the highest product.

Sample Input-1:
---------------
4
2 3 -2 4

Sample Output-1:
----------------
6

Explanation:
------------
Product of contiguous sub list [2,3].


Sample Input-2:
---------------
3
-2 0 -3

Sample Output-2:
----------------
0

Explanation:
------------
Product of sub list [0], where [-2,-3] is not a contiguous sublist

******* MAX Product *******
case =1
input =4
2 3 -2 4
output =6

case =2
input =3
-2 0 -3
output =0

case =3
input =5
-4 2 -3 4 -5
output =120

case =4
input =8
-6 -15 20 -14 2 -15 -9 12
output =13608000

case =5
input =15
4 3 7 -1 0 -9 5 3 -7 8 -6 1 -3 3 -9
output =408240

case =6
input =10
-1 -2 4 5 0 -3 -2 -4 6 3
output =144

case =7
input =11
4 -1 7 8 -9 4 -1 4 -2 7 -7
output =790272


case =8
input =20
4 -11 7 8 -9 -10 4 0 -2 2 -7 4 -3 0 -4 -1 4 -2 -7 7
output =22176


*/

import java.util.*;

class MaxProduct {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) 
			return 0;
        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;
            result = Math.max(max_so_far, result);
        }
        return result;
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int nums[]=new int[n];
		for(int i=0;i<n;i++)
			nums[i]=sc.nextInt();
		System.out.println(new MaxProduct().maxProduct(nums));		
	}
}