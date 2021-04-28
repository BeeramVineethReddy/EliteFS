import java.util.*;
class Test
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int a[][] = new int[m][n];
		int dp[][] = new int[m][n];
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				a[i][j]=sc.nextInt();
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==1)
				{
					if(i==0 || j==0)
					{
						dp[i][j]=1;
					}
					else
					{
						dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
					}
				}
				max = Math.max(max,dp[i][j]);
			}
		}
		System.out.println(max*max);
	}
}
