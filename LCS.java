/*
Vihaan is given a pair of words likely word1 and word2, he is asked to create a method which
returns the numbers of characters in a word formed from long lasting frequent posteriority.
Posteriority is a latest word formed from the native word with few characters removed
without modifying the corresponding order of the left over characters.
A frequent posteriority of two words is a posteriority that is frequent to both words.
Return 0 if no common posteriority.

Input Format:
-------------
Two space separated strings S1, S2.

Output Format:
--------------
Print an integer, the length of longest common subsequence.


Sample Input-1:
---------------
abcde ace

Sample Output-1:
----------------
3


Sample Input-2:
---------------
acd bef

Sample Output-2:
----------------
0


====TestCases====
case =1
input =abcdefghijklmno iamthebeststudentincollege
output =7

case =2
input =abcdefghijklmnopqrstuvwxyz hjkdhowiqjfmaknfeiuwpowrvnkljgopopqwjdknfjbdhjfewg
output =10

case =3
input =cucwxladpycawcvqeoshgmcmpxxvhmtszwxtlkomkdvdcaytzv tyxdbygmehbqeobnxydakrhwztxmdacapiasnfifhlfsutgldhpglikzxbhgtfcjgmedqj
output =17

case =4
input =idckldaiieilfbdaeflhehfadghaldeikehkadeehejklglebf jcbaffgegcjflhgihfgifliflhjcfbagcbkkjagfffkakfclhgbahdfakeihebala
output =20

case =5
input =abcde adobe
output =3

case =6
input =abcdefghijklmnopqrstuvwxyz zyxwvutsrqponmlkjihgfedcba
output =1

case =7
input =nagarjunaisahero cementfactorynamedasnagarjuncements
output =9

case =8
input =abcdefghijklm nopqrstuvwxyz
output =0

*/

import java.util.*;

class LCS {
    public int longestCommonSubsequence(String text1, String text2) {      
		int[] dp = new int[text2.length()+1];
        for(int i = 0; i< text1.length(); i++){
            int prev = dp[0];
            for(int j = 1; j < dp.length; j++){
                int temp = dp[j];
                if(text1.charAt(i) != text2.charAt(j-1)){
                    dp[j] = Math.max(dp[j-1], dp[j]);
                }else{
                    dp[j] = prev +1;
                }
                prev = temp;
            }
        }
        return dp[dp.length-1];
    }
    
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		String s1=sc.next();
		String s2=sc.next();
		System.out.println(new LCS().longestCommonSubsequence(s1,s2));
	}
}