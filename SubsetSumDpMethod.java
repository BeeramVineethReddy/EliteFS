/*
Zee Telugu started a world champion’s game show for the kids between 8-12 years.
The main moto of this game is to check the IQ level of the kids in few concepts related to
Mathematics.

Pillai has participated in this competition, where he was given few variety of chocolate bags, each 
variety has a unque price per chocolate. Now he was asked to find all possible ways to sell the chocolates
with given amount T.

Your task is to help Pillai, to find all the possible ways of selling the variety of chacolates for a given amount, and print the count.

Input Format:
-------------
Line-1: Two space separated integers N and T, N varieties, T is amount.
Line-2: N space separated integers, price of each variety of chocolate.

Output Format:
--------------
Print an integer, number of possible ways.


Sample Input-1:
---------------
3 10
2 3 5

Sample Output-1:
----------------
4


Sample Input-2:
---------------
2 8
2 5

Sample Output-2:
----------------
1

*/



import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        int dp[] = new int[sum+1];
        dp[0]=1;
        for(int i=0;i<n;i++)
        {
            for(int j=a[i];j<=sum;j++)
            {
                dp[j]+=dp[j-a[i]];
            }
        }
        System.out.println(dp[sum]);
    }
}