/*

Gumadi Baleshwar Rao purchased two boxes (Box1,Box2) of unique weights 
of gold coins, where first box weights are subset of second box gold weights.

Now design a method for Gumadi Baleshwar Rao to find all the next largest weights 
of Box1 gold coins in the corresponding locations of box2 , 
if doesn’t exist return -1.

The Next largest Weight is Weight ‘W’ in Box1 is the first largest weight 
to its right side weight in Box2.

NOTE: Unique weights means, no two coins will have same weight.

Input Format:
-------------
Line-1: space separated integers, weihts of gold coins in the first box.
Line-2: space separated integers, weihts of gold coins in the second box.

Output Format:
--------------
Print a list of integers, next largest weights

Sample Input-1:
---------------
4 3 2
1 3 4 2

Sample Output-1:
----------------
[-1, 4, -1]


Sample Input-2:
---------------
5 6 3 4
1 5 3 7 8 6 4 2

Sample Output-2:
----------------
[7, -1, 7, -1]



*/



import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        for(String s:input) l1.add(Integer.parseInt(s));
        input = sc.nextLine().split(" ");
        ArrayList<Integer> l2 = new ArrayList<Integer>();
        for(String s:input) l2.add(Integer.parseInt(s));
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<l1.size();i++)
        {
            int a = l1.get(i) ;
            if(!l2.contains(a))
            {
                ans.add(-1);continue;
            }
            int c= 0;
            for(int j=l2.indexOf(a)+1;j<l2.size();j++)
            {
                if(l2.get(j)>a)
                {
                    ans.add(l2.get(j));
                    c=1;
                    break;
                }
            }
            if(c==0)
            {
                ans.add(-1);
            }
        }
        System.out.println(ans);
    }
}