/*

https://stackoverflow.com/questions/1622532/algorithm-to-find-next-greater-permutation-of-a-given-string/1622539

You are given a list of digits( 0 to 9) digits[].
A number is formed using the given order of the list.
for example: given list is [1,3,2], then number is 132.

Find the next biggest number in the lexographic order using 
the same list of digits, by using the each digit in the list only once,
and print the digit list of such biggest number.

If such biggest number is not possible, 
print the smallest lexographic order of the digits.

Input Format:
-------------
Line-1 : An integer N, number of digits.
Line-2 : N space separated integers, list of digits.

Output Format:
--------------
Print an integer list.


Sample Input-1:
---------------
4
1 2 4 3

Sample Output-1:
----------------
[1, 3, 2, 4]


Sample Input-2:
---------------
4
4 3 2 1

Sample Output-2:
----------------
[1, 2, 3, 4]

*/


import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) a[i]=sc.nextInt();
        // find highest index x such that a[x]<a[x+1];
        int x = -1;
        for(int i=0;i<n-1;i++)
        {
            if(a[i]<a[i+1]) x=i;
        }
        if(x==-1) 
        {
            ArrayList<Integer> l = new ArrayList<Integer>();
            for(int i=n-1;i>=0;i--) l.add(a[i]);
            System.out.println(l);
            System.exit(0);
        }
        else
        {
            //find highest index y(>x) such that 
            int y = x+1;
            for(int j=x+1;j<n;j++)
            {
                if(a[j]>a[x]) y=j;
            }
            //swap x and y
            int t = a[x];
            a[x]=a[y];
            a[y]=t;
            ArrayList<Integer> l = new ArrayList<Integer>();
            //reverse from x+1 to end
            
            for(int i=0;i<=x;i++)
            {
                l.add(a[i]);
            }
            for(int i=n-1;i>x;i--)
            {
                l.add(a[i]);
            }
            System.out.println(l);
        }
    }
}