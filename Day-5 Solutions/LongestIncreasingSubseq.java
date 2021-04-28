/*
There are some balls in a row, the balls are numbered from -1000 to +1000.
You need do arrange the balls in a such way that, 
the numbers on the balls in the row, should be in ascending order.
You are allowed to remove few balls in the row, 
but you are not allowed to shuffle their position.

Given an set of integers, numbers printed on the balls. 
Your task is to find the length of longest ascending arrangement of the numbered balls.

Input Format:
-------------
Space separated integers, numbers printed on the balls in a row.

Output Format:
--------------
Print an integer, length of longest ascending arrangement of the numbered balls.

Sample Input: 
----------------
10 9 2 5 3 7 101 18

Sample Output: 
------------------
4 

Explanation: 
-------------
The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 


*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LongestIncreasingSubseq {

	 public static int lengthOfLIS(int[] nums) {
	        int[] dp = new int[nums.length];
	        int len = 0;
	        for (int num : nums) {
	            int i = Arrays.binarySearch(dp, 0, len, num);
	            if (i < 0) {
	                i = -(i + 1);
	            }
	            dp[i] = num;
	            if (i == len) {
	                len++;
	            }
	        }
	        return len;
	    }
	 
	 public static void main(String args[] ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		String[] numbers = str.split(" ");
		int[] nums = Arrays.asList(numbers).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println(lengthOfLIS(nums));
		}	 
}
