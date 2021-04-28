/*
Ismart Shankar is given a set of N pluck cards, each card labelled a number on it
and he is also given a difference value as ‘D’.
Now Ismart Shankar has to find out the length of the largest arithmetic set ‘S’.

A subset is called as arithmetic set, iff the difference between the numbers on 
any two adjacent cards is same as D.

A subset can be derived from the set of N pluck cads by deleting some or no cards 
without changing the order of the remaining cards.

Input Format:
------------- 
Line-1: Two space separated integers N, D, number of cards, difference.
Line-2: N space separated integers, numbers on the set of cards.

Output Format:
--------------
Print an integer, length of longest arithmetic subset.


Sample Input-1:
---------------
6 2
1 2 3 4 6 8

Sample Output-1:
----------------
4


Sample Input-2:
---------------
8 -2
8 1 2 6 5 4 2 0 

Sample Output-2:
----------------
5

*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            int req = a[i]-d;
            if(hm.containsKey(req))
            {
                hm.put(a[i],hm.get(req)+1);
            }
            else
            {
                hm.put(a[i],1);
            }
        }
        int ans=1;
        for(int i=0;i<n;i++)
        {
            ans=Math.max(ans,hm.get(a[i]));
        }
        System.out.println(ans);
    }
}