/*
BCCI wants to select the group of bowlers for an upcoming test-series, you want
to choose the group with highest number of wickets, which is the sum of wickets
taken by all the bowlers in that group.

However, the bowler group is not allowed to have any disputes. 
A dispute exists if a younger bowler has strictly highest wickets than an 
older bowler. A dispute does not occur between bowlers of the same age.

You are given information of N bowlers as two lists, wickets and ages, 
where each wickets[i] and ages[i] represents the wickets and age of the i-th bowler, 
respectively, return the highest number of wickets of all possible bowler groups.

Input Format:
-------------
Line-1: An integer N, number of bowlers.
Line-2: N space separated integers, wickets[].
Line-3: N space separated integers, ages[].

Output Format:
--------------
An integer, highest number of wickets of all possible bowler groups.


Sample Input-1:
---------------
4
5 3 5 6
3 5 4 2

Sample Output-1:
----------------
10

Explanation:
------------
It is best to choose 2 bowlers of age 3 and 4. 


Sample Input-2:
---------------
5
5 3 5 6 3
2 5 4 2 1

Sample Output-2:
----------------
14

Explanation:
------------
It is best to choose 3 bowlers of age 1 and 2. 
Notice that you are allowed to choose multiple bowlers of the same age.

Sample Input-3:
---------------
5
1 3 5 10 15
1 2 3 4 5

Sample Output-3:
----------------
34

Explanation:
------------
You can choose all the bowlers.
*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w[]=new int[n];
        int a[]=new int[n];
        for(int i=0;i<n;i++) w[i]=sc.nextInt();
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        //bubble sort
        for(int i=0;i<n-1;i++)
        {
            for(int j=0;j<n-i-1;j++)
            {
                if(a[j]>a[j+1])
                {
                    int t;
                    t=a[j];
                    a[j]=a[j+1];
                    a[j+1]=t;
                    
                    t=w[j];
                    w[j]=w[j+1];
                    w[j+1]=t;
                }
                else if(a[j]==a[j+1] && w[j]>w[j+1])
                {
                    int t=w[j];
                    w[j]=w[j+1];
                    w[j+1]=t;
                }
            }
        }
        
        //for(int i=0;i<n;i++) System.out.print(w[i]+" ");
		//System.out.println();
        //for(int i=0;i<n;i++) System.out.print(a[i]+" ");
        
        int dp[] = new int[n];
		for(int i=0;i<n;i++) dp[i] = w[i]; 
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(w[i]>=w[j])
				{
					dp[i]=Math.max(dp[i],dp[j]+w[i]);
				}
			}
		}
		int ans =0;
		for(int i:dp) ans=Math.max(ans,i);
		System.out.println(ans);
    }
}