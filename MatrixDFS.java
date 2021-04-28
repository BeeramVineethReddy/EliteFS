/*
A forest is represented as a square grid consist of 0's an 1's only.
Few people stuck in the forest, where 1's are indicate people, 
and 0's are indicate as trees. A person cannot move from the tree.

You want to save people, a person can be saved, if he/she connected to other person 
who is at the boundary of forest
If 'a' is connected to 'b' and 'b' is connected to 'c',
then you can consider that 'a' is also connected to 'c'. 
They can connected in 4 directions only (up, right, left and down).

You need to find out the number of persons, whom cannot be saved from 
the given forest grid.


Input Format:
-------------
Line-1 -> An integer N, size of the grid N*N
next N lines -> N space separated integers(0's and 1's)

Output Format:
--------------
Print an integer as your result


Sample Input-1:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 0 0
0 1 1 0 1
1 0 0 1 0

Sample Output-1:
----------------
3

Explanation:
------------
In the given grid, 1's at (2,2), (3,1), (3,2) positions are not connected 
to the boundary. So, number of people cannot be saved are 3

Sample Input-2:
---------------
5
0 0 1 1 0
1 0 0 1 0
0 0 1 1 0
0 1 1 0 1
1 0 0 1 0

Sample Output-2:
----------------
0

Explanation:
------------
In the given grid, each 1 is either at the boundary or connceted to 1 at boundary.
So, number of people cannot be saved are '0'
*/

import java.util.*;
class Test
{
    public static int c=0;
    public static boolean dfs(int grid[][],int n,int i,int j,int[][] v)
    {
        if(v[i][j]==1) return false;
        if(grid[i][j]==0) return false;
        v[i][j]=1;
        if(i==0 || i==n-1 || j==0 || j==n-1)
        {
            return true;
        }
        return dfs(grid,n,i+1,j,v) || dfs(grid,n,i-1,j,v) || dfs(grid,n,i,j+1,v) || dfs(grid,n,i,j-1,v);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int grid[][] = new int[n][n];
        for(int i=0;i<n;i++) for(int j=0;j<n;j++) grid[i][j]=sc.nextInt();
        for(int i=1;i<n-1;i++)
        {
            for(int j=1;j<n-1;j++)
            {
                if(grid[i][j]==1)
                {
                    int v[][] = new int[n][n];
                    if(!dfs(grid,n,i+1,j,v) && !dfs(grid,n,i-1,j,v) && !dfs(grid,n,i,j+1,v) && !dfs(grid,n,i,j-1,v))
                    {
                        c+=1;
                    }
                }
            }
        }
        System.out.println(c);
    }
}
