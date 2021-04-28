/*
UBER driver has a vehicle, daily he used go in only one direction.
Capacity of the vehicle is S (no of seats except driver seat), 

Given a list of N bookings, booking[i]= [ num_customers, pickup, drop ].
booking indicates, number of customers to pick up, and pick up, droping points.

Initially the vehicle is empty.

Return true if and only if it is possible to pick up and drop off all customers 
of all bookings.

Input Format:
-------------
Line-1 -> Two integers N and S, number of bookings and number of seats in the vehicle.
Next N Lines -> three space separated integers, num_customers, pickup point, 
                dropping point

Output Format:
--------------
Print a boolean value.


Sample Input-1:
---------------
2 5
2 1 5
3 3 7

Sample Output-1:
----------------
true


Sample Input-2:
---------------
2 4
2 1 5
3 3 7

Sample Output-2:
----------------
false


Sample Input-3:
---------------
3 11
3 2 7
3 7 9
8 3 9

Sample Output-3:
----------------
true

*/

import java.util.*;
class Test
{
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int s=sc.nextInt();
        int[][] a= new int[n][3];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
            a[i][2]=sc.nextInt();
            max = Math.max(max,a[i][2]);
        }
        int[] num = new int[max+1];
        for(int i=0;i<n;i++)
        {
            num[a[i][1]]+=a[i][0];
            num[a[i][2]]-=a[i][0];
        }
        int cur=0;
        for(int i:num)
        {
            cur+=i;
            if(cur>s)
            {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}