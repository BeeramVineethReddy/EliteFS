import java.util.*;

class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1=sc.next();int n1=s1.length();
        String s2=sc.next();int n2=s2.length();
        int idx1=0,idx2=0;
        int arr[] = new int[n1+n2];
        for(int i=n1-1;i>=0;i--)
        {
            int x = s1.charAt(i)-'0';
            for(int j=n2-1;j>=0;j--)
            {
                int y=s2.charAt(j)-'0';
				System.out.println(x+" "+y);
                int mul = (x*y);
                int p1=i+j, p2=i+j+1;
                int sum=mul+arr[p2];//with adding carry of previous
                
                arr[p1]+=(sum/10);
                arr[p2]=sum%10;
            }
        }
		
        String ans = "";
        for(int i=0;i<arr.length;i++)
        {
            ans+=arr[i];
        }
        System.out.println(ans);
    }
}
