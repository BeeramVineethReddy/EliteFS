import java.util.*;
class Test
{
	private static void fn(int n, int[] in, HashMap<Integer, ArrayList<Integer>> hm, ArrayList<Integer> l) 
	{
		int c0=0,cv=0;
		for(int i=0;i<n;i++)
		{
			if(in[i]==0) c0+=1;
			else if(in[i]==-1) cv+=1;
		}
		if(cv==n) 
		{
			System.out.println(l);System.exit(0);
		}
		else if(c0==0)
		{
			System.out.println(new ArrayList<Integer>());System.exit(0);
		}
		for(int i=0;i<n;i++)
        {
        	if(in[i]==0)
        	{
        		l.add(i);
        		in[i]=-1;
        		for(int x:hm.get(i))
        		{
        			in[x]--;
        		}
        		fn(n,in,hm,l);
        	}
        }
		
	}
    public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<Integer,ArrayList<Integer>>(); 
        ArrayList<Integer> l = new ArrayList<Integer>();
        int in[] = new int[n];
        for(int i=0;i<n;i++)
        {
            hm.put(i,new ArrayList<Integer>());
        }
        int m = sc.nextInt();
        for(int i=0;i<m;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            in[x]++;
            hm.get(y).add(x);
        }
        //System.out.println(hm);
        fn(n,in,hm,l);
        
    }

	
}
