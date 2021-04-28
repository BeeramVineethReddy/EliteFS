import java.util.*;
class DP_LengthOfLongestIncreasingArrangement
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] z = sc.nextLine().split(" ");
        int n = z.length ;
        int a[] = new int[n];
        int dp[] = new int[n];
        int i=0;
        for(String y:z)
        {
            a[i]=Integer.parseInt(y);
            i+=1;
        }
        dp[0]=1;
        for(i=1;i<n;i++)
        {
            dp[i]=1;
            for(int j=0;j<=i;j++)
            {
                if(a[i]>a[j])
                {
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = 1;
        for(int x:dp)
        {
            if(max<x) max=x;
        }
        System.out.println(max);
    }
}