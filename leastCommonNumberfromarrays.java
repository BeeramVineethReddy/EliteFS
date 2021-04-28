/*

There are N bags containing gold boxes. In each bag, gold boxes are with certain weights that are
arranged according to weights from smallest to largest arranged strictly ,create a method in such a way
that we need to return the least weight of gold box which is common in all the given bags.
If we don’t have any least common weight of gold box in any bag then return -1.

Input Format:
-------------
Line-1: Two integers B and N, number of bags and number of goldboxes in each Bag.
Next B lines: N space separated integers, weights of GoldBoxes.

Output Format:
--------------
Print the least weight of gold box, if found
Print -1, if not found.


Sample Input:
---------------
5 5
1 2 3 4 5
2 3 6 7 9
1 2 3 5 8
1 3 4 6 8 
2 3 5 7 8

Sample Output:
----------------
3



*/






import java.util.*;
class Test
{
    public static int fn(int[][] a,int r, int c)
    {
        for(int i=0;i<c;i++)
        {
            int cur_min = a[0][i];
            int ct=0;
            for(int j=1;j<r;j++)
            {
                if(Arrays.binarySearch(a[j],cur_min)>=0)
                {
                    ct+=1;
                }
            }
            if(ct==r-1)
            {
                return cur_min;
            }
        }
        return -1;
    }
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int a[][]=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        System.out.println(fn(a,r,c));
    }
}