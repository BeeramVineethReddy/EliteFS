import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[][] = new int[n*3][3];
        int dp[] = new int[n*3];
        for(int i=0;i<n;i++)
        {
            int h=sc.nextInt();int b=sc.nextInt();int l=sc.nextInt();
            a[(3*i)][0]=l;a[(3*i)][1]=Math.max(b,h);a[(3*i)][2]=Math.min(b,h);
            dp[3*i]=l;
            a[(3*i)+1][0]=b;a[(3*i)+1][1]=Math.max(l,h);a[(3*i)+1][2]=Math.min(l,h);
            dp[(3*i)+1]=b;
            a[(3*i)+2][0]=h;a[(3*i)+2][1]=Math.max(b,l);a[(3*i)+2][2]=Math.min(b,l);
            dp[(3*i)+2]=h;
        }

        Arrays.sort(a,(x,y)->{return(y[1]*y[2])-(x[1]*x[2]);});
		

		
        for(int i=0;i<n*3;i++)
        {
			int var = 0;
            for(int j=0;j<i;j++)
            {
                if(a[j][1]>a[i][1] && a[j][2]>a[i][2])
                {
					var = Math.max(var,dp[j]);
                    //dp[i]=Math.max(dp[i],dp[i]+dp[j]);
                }
            }
			dp[i]=a[i][0]+var;
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n*3;i++)
        {
            if(dp[i]>max) max = dp[i];
        }
        System.out.println(max);
    }
}