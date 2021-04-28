/*
Murali playing a mobile game, Blast the letters.

In the game he is given a word W and value R.
Murali has to perform the blasting operation as follows:
	- He has to blast the mimeograph M of length R in W, 
	  a mimeograph is a string such that each letter in it should be same.
	- After blasting the mimeograph, the rest of the string on its left side and right side, concatenated together.

Murali has to perform the blasting operation repeatedly, until no more blasting is possible.

Your task is to return the final string after all the blast operations have been done.

Input Format:
-------------
Line-1: A string and an integer, W and R.

Output Format:
--------------
Print a string, the final string after all the blast operations have been done.


Sample Input-1:
--------------- 
ababbaaab 3

Sample Output-1:
----------------
aba

Sample Input-2:
--------------- 
caaabbbaacdddd 2

Sample Output-2:
----------------
cabc


===== Testcases =====
case =1
input =deeedbbcccbdaa 3
output ="aa"

case =2
input =pbbcggttciiippooaais 2
output ="ps"

case =3
input =deeeedbbcccbdaa 3
output ="deddaa"

case =4
input =ababbaaab 3
output ="aba"

case =5
input =caaabbbaacdddd 2
output ="cabc"

case =6
input =ksseeedcccaaabbbbbaaccddddeessssh 5
output ="ksh"

case =7
input =kmbbggaciiicppooopcaagbit 3
output ="kmit"

case =8
input =mdaacccaabbbbaacaaddd 4
output ="m"

*/
import java.util.*;

class RemoveDuplicates {
    public String removeDuplicates(String s, int k) {
        int i = 0, n = s.length(), count[] = new int[n];
        char[] stack = s.toCharArray();
        for (int j = 0; j < n; ++j, ++i) {
            stack[i] = stack[j];
            count[i] = i > 0 && stack[i - 1] == stack[j] ? count[i - 1] + 1 : 1;
            if (count[i] == k) i -= k;
        }
        return new String(stack, 0, i);
    }
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s=sc.next();
		int k=sc.nextInt();
		System.out.println(new RemoveDuplicates().removeDuplicates(s,k));		
	}
}