/*
	
Pramod is working on words. He used to remove all the duplicate letters from a
word.

Pramod is given a word W. His task to remove all theduplicated letters from W,
in such a way that the resulatant word R, contains no duplicate letters and all
distinct letters from W should be there in R.and R should appear first in the 
dictionary order. 

Input Format:
-------------
A String, the word W.

Output Format:
--------------
Print a String, resulatant word R.


Sample Input-1:
---------------
cbadccb

Sample Output-1:
----------------
adcb

Sample Input-2:
---------------
silicosis

Sample Output-2:
----------------
ilcos    
*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<n;i++)
        {
			//System.out.println(stack);
            if(stack.empty())
            {
                stack.push(s.charAt(i));
            }
			else if(stack.contains(s.charAt(i)))
			{
				continue;
			}
            else
            {
				if(!stack.empty())
				{
					while((stack.peek()>s.charAt(i) && s.lastIndexOf(stack.peek())>i) )
					{
						stack.pop();
						if(stack.empty()) break;
					}
				}
                if(!stack.contains(s.charAt(i))) stack.push(s.charAt(i));
            }
            //System.out.println(stack);
        }
		String ans="";
		while(!stack.empty())
		{
			ans += stack.pop();
		}
		System.out.println(new StringBuilder(ans).reverse().toString());
        
    }
}