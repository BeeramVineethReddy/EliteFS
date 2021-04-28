/*

// https://leetcode.com/problems/remove-k-digits/

Somesh is working on Number Strings.
He got an idea to find the smallest possible number by 
deleting some digits from the number without changing 
the relative order of digits in it.

You will be given a integer String 'num', and an integer n.
Find the smallest number possible after deleting n digits from 'num'.

Note: If the number string 'num' turns to empty, print 0.

Input Format:
-------------
Line-1 : A string num, consist of digits only.
Line-2 : An integer n, number of digits to delete.

Output Format:
--------------
Print the smallest possible number.


Sample Input-1:
---------------
1432219
3

Sample Output-1:1
----------------
1219

Explanation: 
------------
Delete the three digits 4, 3, and 2 to form the smallest number 1219.

Sample Input-2:
---------------
10200
1

Sample Output-2:
----------------
200

Explanation:
------------
Delete the leading 1 and the smallest number is 200. 
Note that the output must not contain leading zeroes.


*/


import java.util.*;
class Test
{
    public static String fn(String num,int k)
    {
        
        if(num.length()<=k) return "0";
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<num.length();i++)
        {
            char c = num.charAt(i);
            while(!stack.empty() && stack.peek()>c && k>0)
            {
                stack.pop();
                k--;
            }
            if(c!='0' || (c=='0' && !stack.empty())) stack.push(c);
            //System.out.println(stack);
        }
        while(!stack.empty() && k>0) 
        {
            stack.pop();
            k--;
        }
        String ans = "";
        while(!stack.empty())
        {
            ans+=stack.pop();
        }
        if(ans.length()==0) return "0"; 
        return (new StringBuilder(ans).reverse().toString());
        
    }
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        int n = sc.nextInt();
		System.out.println(fn(in,n));
    }
}