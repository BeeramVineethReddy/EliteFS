/*
You are provided a string of characters(lowercase only),
You can change the order of the characters of the string.
After changing the order, the resultant string should be 
no two immidiate characters equal.

Return true, if you are able to find such resultant string, 
Otherwise false.

Input Format:
-------------
A String S

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
aaabd

Sample Output-1:
----------------
true

Sample Input-2:
---------------
aaab

Sample Output-2:
----------------
false

*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m;
        if(s.length()%2==0) m= s.length()/2;
        else m=(s.length()/2)+1;
        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
        for(char c:s.toCharArray())
        {
            if(hm.containsKey(c))
            {
                hm.put(c,hm.get(c)+1);
            }
            else
            {
                hm.put(c,1);
            }
        }
        for(char c:hm.keySet())
        {
            if(hm.get(c)>m)
            {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}
