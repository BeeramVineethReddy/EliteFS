import java.util.*;
class Test
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = s.length;
        int a[] = new int[n];
        int lmax[]  = new int[n];
        int rmax[] = new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=Integer.parseInt(s[i]);
        }
        lmax[0]=a[0];
        for(int i=1;i<n;i++)
        {
            lmax[i]=Math.max(lmax[i-1],a[i]);
        }
        rmax[n-1]=a[n-1];
        for(int i=n-2;i>=0;i--)
        {
            rmax[i]=Math.max(rmax[i+1],a[i]);
        }
//        for(int i=0;i<n;i++)
//        {
//            System.out.print(lmax[i]);
//        }
//        System.out.println();
//        for(int i=0;i<n;i++)
//        {
//            System.out.print(rmax[i]);
//        }
        int w=0;
        for(int i=0;i<n;i++)
        {
            w=w+(Math.min(lmax[i], rmax[i])-a[i]);
        }
        System.out.println(w);
    }
}