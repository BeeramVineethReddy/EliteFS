/*
Major Ajay Krishna and Prasad garu are working on a military operation at 
Himachal Pradesh. They are given an operation to defuse the bomb, and they have 
time falling short.

Their informer will provide them with a round-shape lock of length ‘L’, 
where L number of integers on the lock and a clue ‘C’.

To defuse the bomb they have to restore the original state of the lock, 
by restoring every integer on lock. All the integers must be restored in the 
same way based on the clue.

Its your task to help Major Ajay Krishna, to restore the original code on the lock, 
to defuse the bomb.

To restore the lock to its original state, you have to follow these instructions:
	- If C > 0, restore every i-th number with the sum of the next C integers.
	- If C < 0, restore every i-th number with the sum of the previous C integers.
	- If C == 0, restore every i-th number with 0.
	
As the lock is in round shpae, the next element of lock[n-1] is lock[0], 
and the previous element of lock[0] is lock[n-1].


Input Format:
-------------
Line-1: Two space separated integers L, C.
Line-2: L space separated integers, integers on the Lock.

Output Format:
--------------
Print the original state of the lock.


Sample Input-1:
---------------
5 2
2 5 9 4 7

Sample Output-1:
----------------
[14, 13, 11, 9, 7]


Sample Input-2:
---------------
5 0
1 5 6 3 2

Sample Output-2:
----------------
[0, 0, 0, 0, 0]

*/


//bezouts identity

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int c = Math.abs(q);
        int a[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        if(q==0)
        {
            for(int i=0;i<n;i++)
            {
                l.add(0);
            }
        }
        else if(q>0)
        {
            for(int i=0;i<n;i++)
            {
                int x=0;
                for(int z=1;z<=c;z++)
                {
                    x=x+(a[(i+z)%n]);
                }
                l.add(x);
            }
        }
        else
        {
            
            for(int i=0;i<n;i++)
            {
                int x=0;
                for(int z=1;z<=c;z++)
                {
					if(i-z<0)
					{
						x+=(a[n+(i-z)]);
					}
					else{
						x=x+(a[(i-z)%n]);
					} 
                }
                l.add(x);
            }
        }
        
        System.out.println(l);
    }
}