/*
Kiran is given a string S, and an integer N.
Kiran wants to find the longest substring which has following properties:
	- the substring of S should be maximum in length, and 
	- should contains atmost N distint characters in it.
	
Can you help Kiran to find the longest substring 'ls' with above properties,
and return the length of the substring 'ls'.

Input Format:
-------------
Line-1: A string S
Line-2: An integer N, number of distinct characters.

Output Format:
--------------
Print an integer, lenth of longest substring with atmost N distinct characters.


Sample Input-1:
---------------
philippines
3

Sample Output-1:
----------------
6

Sample Input-2:
---------------
abaccdbcca
2

Sample Output-2:
----------------
3

*/

import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int k = sc.nextInt();
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        int i=0,j=0,ans=0,c=0;
        while(j<n)
        {
			
            if(map.containsKey(s.charAt(j)))
            {
                map.put(s.charAt(j),map.get(s.charAt(j))+1);
				j++;c++;
            }
            else
            {
                map.put(s.charAt(j),1);
				j++;c++;
            }
			
            while(map.size()>k)
            {
				if(map.containsKey(s.charAt(i)))
				{
					
					if(map.get(s.charAt(i))==1)
					{
						map.remove(s.charAt(i));
					}
					else
					{
						map.put(s.charAt(i),map.get(s.charAt(i))-1);
						
					}
				}
				c--;
				i++;	
            }
			//System.out.println(map);
			//System.out.println(map.size());
			//System.out.println(i+" "+j);
            ans=Math.max(ans,j-i);
        }
		
        System.out.println(ans);
    }
}