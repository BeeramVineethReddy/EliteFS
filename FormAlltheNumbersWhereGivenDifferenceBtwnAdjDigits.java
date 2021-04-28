/*

Basava interested playing with digits.
He wants create a set of integers of length N, using the digits[0-9].
The rules to create the integers are as follows:
	- digits in each integer are like d0,d1,d2...dn-1
	- and |d0-d1| = |d1-d2| = |d2-d3| ... |dn-2 - dn-1|= D

Basava is given two integers N and D, where N is length of the integer and 
D is the difference. Can you help Basava, to create such list of integers 
and print all the possible integers in ascending order


Note:
-----
Integers with leading 0's are not allowed


Input Format:
-------------
Two space separated integers N and K.

Output Format:
--------------
Print all the possible integers in ascending order.


Sample Input-1:
---------------
3 6

Sample Output-1:
----------------
[171, 282, 393, 606, 717, 828, 939]


Sample Input-2:
---------------
2 3

Sample Output-2:
----------------
[14, 25, 30, 36, 41, 47, 52, 58, 63, 69, 74, 85, 96]



*/

import java.util.*;
class Test
{
    public static TreeSet<Integer> l = new TreeSet<Integer>();
    public static void fn(int num,int diff,int cur_digits,int digits)
    {
        if(cur_digits==digits)
        {
            l.add(num);
            return;
        }
        int x = num%10;
        int big = x+diff;
        int small = x-diff;
        if(small>=0 && small<=9)
        {
            fn(num*10+small,diff,cur_digits+1,digits);
        }
        if(big>=0 && big<=9)
        { 
            fn(num*10+big,diff,cur_digits+1,digits);
        }
        
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int digits = sc.nextInt();
        int diff = sc.nextInt();
        
        for(int i=1;i<=9;i++)
        {
            fn(i,diff,1,digits);
        }
        System.out.println(l);
    }
}