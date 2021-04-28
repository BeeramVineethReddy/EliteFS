/*
You are decorating a side wall with balloons.
You have an unlimited set of ballons of three different colors.

The decoration should have N rows of 3 balloons each. 
You have to make sure that no two adjacent balloons have the same colour.
both vertically and horizontally.

Return the number of ways you can decorate the wall,  
the answer must be computed modulo 10^9 + 7

Input Format:
-------------
An integer N

Output Format:
--------------
Print an integer as outpur, number of ways to decorate.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
12

Explanation:
------------
Suppose the colors are, B, G, R. Given N is 1
RBR	BRB	GRB
RBG	BRG	GRG
RGR	BGR	GBR
RGB	BGB	GBG


Sample Input-2:
---------------
2

Sample Output-2:
----------------
54


*/



import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long mod = (long)Math.pow(10,9)+7;
        long aba[] = new long[(int)n];
        long abc[] = new long[(int)n];
        aba[0]=6;
        abc[0]=6;
        for(int i=1;i<n;i++)
        {
            aba[i]=aba[i-1]*3+abc[i-1]*2;
            abc[i]=aba[i-1]*2+abc[i-1]*2;
        }
        System.out.println((abc[(int)n-1]+aba[(int)n-1])%mod);
    }
}