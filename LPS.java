/*
Mr. James professor of at Illinois state university, as a part of assignment he created a
problem statement related to strings.
He gave a String S, and asked them to design a method to 
return the longest substring in S, which is a palindrome.

NOTE: Alphabets are case sensitive
"Aa" is not considered a palindrome here.

Input Format:
-------------
A string S, consist of lowercase/uppercase letters or/and digits

Output Format:
--------------
Print a string, longest palindrome substring.


Sample Input-1:
---------------
abbbabbcbbacdb

Sample Output-1:
----------------
abbcbba


Sample Input-2:
---------------
thedivideriswide

Sample Output-2:
----------------
edivide


*/

import java.util.*;

class LPS {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int start = 0;
        int end = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j <= i; j++) {
                if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j+1][i-1])) {
                    dp[j][i] = true;
                }
                if(dp[j][i] && max < i - j + 1) {
                    max = i - j + 1;
                    start = j;
                    end = i;
                }
            }
        }
        return s.substring(start, end + 1);
    }


	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		System.out.println(new LPS().longestPalindrome(s));
	}
}