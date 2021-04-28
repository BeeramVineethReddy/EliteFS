/*
Few people standing in row, where male candidates are represented with 0 and 
Female with 1. We are given any random number ‘R’ such that ‘R’ values of males
need to be replaced with female at certain positions in such a way that we can
form longest female continuous group given in a row.

Your task is to help to form the longest female continuous group 
in the row and print the length of it.

Input Format:
-------------
Line-1: Two integers N and R, number of people and R.
Line-2: N space separated integers, [0, 1] only.

Output Format:
--------------
Print the length of longest female group.

Sample Input-1:
---------------
10 3
1 0 1 1 1 0 0 0 1 0

Sample Output-1:
----------------
7

Sample Input-2:
---------------
14 2
1 1 1 1 0 0 1 1 1 1 1 0 1 1 0

Sample Output-2:
----------------
11

*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        int max = Integer.MIN_VALUE;
        int i=0,j=0;
        int c=0;
        for(i=0;i<n;i++)
        {
            if(a[i]==0)
            {
                c++;
            }
            if(c==r+1)
            {
                max=Math.max(max,i-j);
                while(a[j]==1)
                {
                    j++;
                }
                j+=1;c-=1;
            }
        }
    if(a[n-1]==1) max=Math.max(max,i-j);
        System.out.println(max);
    }
}