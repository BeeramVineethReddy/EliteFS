/*
Given a set of weights of n items weights[], and another item wieght w.
Your task is to check if the sum of weights of continuous subset is equal to 
one of the multiple of w, where subset size should be minimum 2.

For example: Mulitple of w means, w=3 then multiple of w are
3, 6, 9, 12, .... so on.

Print true, if such subset sum is possible.
Otherwise, print false.

Input Format:
-------------
Line-1 : Two integers n and w, number of weights and weight to match.
Line-2 : n space separated integers, weights of n items.

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
5 4
1 2 3 5 6

Sample Output-1:
----------------
false


Sample Input-2:
---------------
5 4
1 2 3 6 5

Sample Output-2:
----------------
true

Explanation: 
------------
sum of  continuous subset of weights [1,2,3,6]  equals to 12, multiple of 4.


*/


import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        for(int s=0;s<=n-2;s++)
        {
            for(int end=s+1;end<n;end++)
            {
                int x=0;
                for(int i=s;i<=end;i++)
                {
                    x+=a[i];
                }
                if(x%w==0)
                {
                    //System.out.println(s+" "+end);
                    System.out.println(true);
                    System.exit(0);
                }
            }
        }
        System.out.println(false);
    }
}
