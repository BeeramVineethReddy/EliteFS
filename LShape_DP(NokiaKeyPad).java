/*
Given a nokia phone,with the following dialpad.
		1 2 3
		4 5 6
		7 8 9
		* 0 #
And You are given an L band to dial the number,  
Using the L band you can dial the number as follows, 
You can start with any digit,
	if you are at digit 1, next digit you can choose {6,8}
	if you are at digit 2, next digit you can choose {7,9}
	if you are at digit 3, next digit you can choose {4,8}
	and so on..

Now your task is to find how many distinct numbers of length N you can dial.

Note: Numbers should contain only digits, {* , #} -> not allowed.
Answer should be modulo 1000000007.

Input Format:
-----------------
An integer N, length of numbers
 
Output Format:
------------------
Print an integer, number of distinct numbers you can dial.


Sample Input-1:
---------------
1

Sample Output-1:
----------------
10

Explanation:
-------------
To dial a number of length 1, you can dial all digits.


Sample Input-2:
---------------
2

Sample Output-2:
----------------
20

Explanation:
------------
To dial a number of length 2, the possible numbers are
{04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94}

Sample Input-3:
---------------
5

Sample Output-3:
----------------
240

*/

import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
		long t1[] = new long[10];
		long mod = 1000000007;
		for(int i=0;i<10;i++)
		{
			t1[i]=1;
		}
        for(int i=2;i<=n;i++)
		{
			    long t2[] = new long[10];
				t2[0]=(t1[6]+t1[4])%mod;
                t2[1]=(t1[6]+t1[8])%mod;
                t2[2]=(t1[7]+t1[9])%mod;
                t2[3]=(t1[4]+t1[8])%mod;
                t2[4]=(t1[0]+t1[3]+t1[9])%mod;
                t2[5]=0;
                t2[6]=(t1[0]+t1[1]+t1[7])%mod;
                t2[7]=(t1[2]+t1[6])%mod;
                t2[8]=(t1[1]+t1[3])%mod;
                t2[9]=(t1[2]+t1[4])%mod;
			for(int x=0;x<10;x++) t1[x]=t2[x];
		}
		long sum = 0;
		for(int i=0;i<10;i++)
		{
			sum+=(t1[i]);
		}
		System.out.println((int)(sum%mod));
    }
}
