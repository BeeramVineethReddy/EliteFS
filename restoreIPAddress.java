/*
Pramod is planning to design a program, which helps to create 
the IP addresses posssible from a given string S, 
where each IP address should be valid.

It is guaranteed that S contains only digits.

Can you help pramod in designing such program, which returns all possible IP addresses.
Print the answer in lexicographic order.

NOTE:
-----

- A valid IP address consists of exactly four integers, 
each integer is between 0 and 255, separated by single dots 
and cannot have leading zeros
- IP Addresses are said to be valid if it falls in the range 
from 0.0.0.0 to 255.255.255.255

- IP addresses like [123.012.234.255 , 123.234.345.34] are invalid.

Input Format:
-------------
A string S, contains only digits [0-9].

Output Format:
--------------
Print all possible IP addresses which are valid.


Sample Input-1:
---------------
23323311123

Sample Output-1:
----------------
[233.233.11.123, 233.233.111.23]


Sample Input-2:
---------------
12345678

Sample Output-2:
----------------
[1.234.56.78, 12.34.56.78, 123.4.56.78, 123.45.6.78, 123.45.67.8]


Sample Input-3:
---------------
02550255

Sample Output-3:
----------------
[0.25.50.255, 0.255.0.255]

*/

import java.util.*;
class Test
{
    public static boolean valid(String a)
    {
        int x = Integer.parseInt(a);
        if(x>=0 && x<=255 && a.equals(x+""))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        ArrayList<String> l = new ArrayList<String>();
        for(int i=1;i<n-2;i++)
        {
            for(int j=i+1;j<n-1;j++)
            {
                for(int k=j+1;k<n;k++)
                {
                    String a1 = s.substring(0,i);
                    String a2 = s.substring(i,j);
                    String a3 = s.substring(j,k);
                    String a4 = s.substring(k,n);
                    if(valid(a1) && valid(a2) && valid(a3) && valid(a4))
                    l.add(a1+"."+a2+"."+a3+"."+a4);
                }
            }
        }
        System.out.println(l);
    }
}