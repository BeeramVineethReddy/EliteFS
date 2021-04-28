/*

Given a flat surface of m*n size, each position contains either empty '0', 
a Iron ball 'B' or Metal Block 'M' (The Metal block is an anti magnetic block), 
Your task is to find the maximum Iron Balls you can attarct by using a Magnet.

The Magnet attarcts all the iron balls in the same row and column from their 
positions until the Metal Block. since the Metal block is an anti magnetic block.

Note: You can only put the magnet at an empty position.


Input Format:
-------------
Line-1 -> Two Integers, M and N, size of the grid
Next M Lines -> N space separated characters, allowed characters '0', 'B', 'M'


Output Format:
--------------
Print an integer, maximum Iron Balls you can attarct by using a Magnet


Sample Input-1:
---------------
3 4
0 B 0 0 
B 0 M B
0 B 0 0

Sample Output:
--------------
3 

Explanation: 
------------
For the given grid,

0 B 0 0 
B 0 M B
0 B 0 0

Placing a Magnet at (1,1) attacts 3 iron balls.
 


*/




import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r=sc.nextInt();
        int c =sc.nextInt();
        char a[][] = new char[r][c];
        for(int i=0;i<r;i++) 
        {
            for(int j=0;j<c;j++) 
            {
                a[i][j]=sc.next().charAt(0);
            }
        }
        int ans = 0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(a[i][j]=='0')
                {
                    int count = 0;
                    for(int k=j+1;k<c;k++)
                    {
                        if(a[i][k]=='B')
                        {
                            count++;
                        }
                        else if(a[i][k]=='M')
                        {
                            break;
                        }
                    }
                    
                    for(int k=j-1;k>=0;k--)
                    {
                        if(a[i][k]=='B')
                        {
                            count++;
                        }
                        else if(a[i][k]=='M')
                        {
                            break;
                        }
                    }
                    
                    for(int k=i+1;k<r;k++)
                    {
                        if(a[k][j]=='B')
                        {
                            count++;
                        }
                        else if(a[k][j]=='M')
                        {
                            break;
                        }
                    }
                    
                    for(int k=i-1;k>=0;k--)
                    {
                        if(a[k][j]=='B')
                        {
                            count++;
                        }
                        else if(a[k][j]=='M')
                        {
                            break;
                        }
                    }
                    
                    
                    ans=Math.max(count,ans);
                    
                }
            }
        }
        System.out.println(ans);
    }
}