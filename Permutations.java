/*
There are pair of words namely W1 and W2 with a limited of word range, 
Create a method to return a true value if W2 contains the anagram of W1. 
In additional, one of the anagram of first word is the substring of the second word.

Your task is to implement the Solution class, and implement a method in it, 
	- public boolean checkSubstring(String w1, String w2){}.

Input Format:
-------------
Two space separated words w1 and w2, consist of lowercase letters only.

Output Format:
--------------
Print a boolean value, if W2 contains the anagram of W1 or not.


Sample Input-1:
---------------
abbcbb abbbabbcb

Sample Output-1:
----------------
true

Sample Input-2:
---------------
abbcbbc abbbabbcb

Sample Output-2:
----------------
false

*/
import java.util.*;

class Solution {
    public static boolean checkSubstring(String w1, String w2) {
        if(w1.length() > w2.length()) return false;
        int textHash = 0;
        int patternHash = 0;

        for (int i = 0; i < w1.length(); i++) {
            textHash += w1.charAt(i);
            patternHash += w2.charAt(i);
        }

        if (textHash == patternHash) {
            if (isEqual(w1, w2.substring(0, w1.length()))) return true;
        }

        for (int i = w1.length(); i < w2.length(); i++) {
            patternHash -= w2.charAt(i - w1.length());
            patternHash += w2.charAt(i);
            if (textHash == patternHash) {
                String str = w2.substring(i + 1 - w1.length(), i + 1);
                if (isEqual(w1, str)) return true;
            }
        }
        return false;
    }

    public static boolean isEqual(String a, String b) {
        int[] freq = new int[26];

        for (int i = 0; i < a.length(); i++) {
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }
}

public class Permutations{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String w1=sc.next();
		String w2=sc.next();
		System.out.println(new Solution().checkSubstring(w1,w2));
	}
}