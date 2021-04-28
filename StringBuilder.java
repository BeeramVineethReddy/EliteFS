/*

Somesh is given a task to you on Strings.
You have given a string S ([a-z]), and an integer array Arr[]
Now your task is to modify 'S' in such way:
replace the 'i+1' characters in the string, with next i-th character 
in alphabetic order(cyclic).

For example, if S="art", Arr[]=[2,3,5] is 3, 
i=0, modify('a') = 'c' , S="crt".
i=1, modify('c') = 'f', modify('r') = 'u', S="fut".
i=2, modify('f') = 'k', modify('u') = 'z', modify('t') = 'y', S="kzy"
Finally modified string is kzy. 

Note: if arr[i]=3 modify('z') ='c'

Return the final modified string after all such modifications to S are applied.

Input Format:
-------------
Line-1 -> A String S,  string length is L
Line-2 -> L space separated integers.

Output Format:
--------------
Print modifed String.


Sample Input-1:
-------------------
adbp
1 2 3 4

Sample Output-1:
--------------------
kmit


*/

import java.util.*;
class Test
{
    public static char modify(char ch,int x)
    {
        int start = 97;
        int cur = (int)ch-97;
        int next = 97+((cur+x)%26);
        return (char)next;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.next());
        int n = sb.length();
        int[] l = new int[n];
        for(int i=0;i<n;i++) l[i]=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int x = l[i];
            for(int j=0;j<=i;j++)
            {
                
                sb.setCharAt(j,modify(sb.charAt(j),x));
            }
        }
        System.out.println(sb.toString());
    }
}
