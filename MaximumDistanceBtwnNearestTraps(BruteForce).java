/*
Few people travelling in N*N grid land.
and there are few traps set by local goons. Due to safety restrictions, 
people has to maximize the distance between the traps near to them.

You are given the current status of N*N grid containing values 0 and 1, 
where 0 represents a person and 1 represents trap, 
your task is to find a person's cell such that his/her distance to the 
nearest trap cell is maximized, and return the distance.

The distance used in this problem is the Manhattan distance: 
the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1| .

Input Format:
-------------
Line-1: An integer N, size of the square grid.
Next N lines: N space separated integers, grid[][] either 0 or 1.

Output Format:
--------------
An integer, maximum distance.


Sample Input-1:
---------------
3
1 0 1
0 0 0
1 0 1

Sample Output-1:
----------------
2

Explanation: 
------------
The person at (1, 1) is with distance 2 from all the traps.


Sample Input-2:
---------------
3
1 0 0
0 0 0
1 0 0

Sample Output-2:
----------------
3

Explanation: 
------------
The person at (1, 2) is with distance 3 from all the traps.

*/

import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                grid[i][j]=sc.nextInt();
            }
        }
        ArrayList<Integer> l = new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                {
					int ans =Integer.MAX_VALUE;
                    for(int x=0;x<n;x++) 
                    {
                        for(int y=0;y<n;y++) 
                        {
                            if(grid[x][y]==1)
                            {
                                ans=Math.min(ans,Math.abs(i-x)+Math.abs(j-y));
                            }
                        }
                    }
					l.add(ans);
                }
            }
        }
        System.out.println(Collections.max(l));
    }
}

