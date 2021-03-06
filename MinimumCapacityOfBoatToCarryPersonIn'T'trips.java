/*
A group of people planned to go Antarvedi Temple, 
They have reached Narsapur Railway station.

From the station they have reached to a boating point to cross the river Godavari.
All of them formed in a line, and you are given their weights as an array Weights[].
Where i-th person weight is Weights[i].

Each boat can carry only few people whose total weight is atmost W.
Each person from the group get into the boat according to the given order only.
The boat takes T number of trips to transport all the people of the group.

You will be given the weights of the people in the line, and number of trips T.
Now, its your turn to find out the minimum weight, the boat can carry, 
So that the boat can transport all the people to cross the river.


Input Format:
-------------
Line-1: Two space separated integers, N and T, Number of people and T trips.
Line-2: N space separated integers, weights of the people.

Output Format:
--------------
Print an integer, minimum weight, the boat can carry.


Sample Input-1:
---------------
6 3
3 2 3 4 1 5

Sample Output-1:
----------------
7

Explanation:
------------
A boat can carry a weight 7 is the minimum to transport all the people in 3 trips:
    trip-1: 3, 2
    trip-2: 3, 4
    trip-3: 1, 5



Sample Input-2:
---------------
8 4
1 2 3 4 5 6 7 8

Sample Output-2:
----------------
11

Explanation:
------------
A boat can carry a weight 11 is the minimum to transport all the people in 4 trips:
    1st day: 1, 2, 3, 4
    2nd day: 5, 6
    3rd day: 7
    4th day: 8

Note:
-----
The people must be transported in the order given, so using a
boat can carry a weight 10 and splitting the packages into parts like 
(8, 1), (7, 2), (6, 3), (5, 4) is not allowed.

https://www.youtube.com/watch?v=eeIWzt7ZvO4
*/

import java.util.*;
class Test
{
    public static boolean check(int arr[],int n,int d,int cap)
    {
        int days=1;
        int wt=0;
        for(int i=0;i<n;i++)
        {
            if(arr[i]>cap) return false;
            wt+=arr[i];
            if(wt>cap)
            {
                days++;
                wt=arr[i];
            }
        }
        if(days<=d) return true;
        return false;
    }
    public static int bs(int arr[],int n,int d)
    {
        int low=0,high=0;
        for(int i=0;i<n;i++) high+=arr[i];
        
        int ans=0;
        while(low<=high)
        {
            int mid = (low+high)/2;
            if(check(arr,n,d,mid))
            {
                ans=mid;
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return ans;
    }
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextInt();
        System.out.println(bs(arr,n,d));
    }
}