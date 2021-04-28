import java.util.*;
class Test
{
	public static void fn(int cur,int n,int grid[][],ArrayList<Integer> t,boolean[] visited)
	{
		if(visited[cur]) return;
		visited[cur]=true;
		t.add(cur);
		for(int []i:grid)
		{
			if(i[0]==cur && !visited[i[1]])
			{
				fn(i[1],n,grid,t,visited);
			}
			if(i[1]==cur && !visited[i[0]])
			{
				fn(i[0],n,grid,t,visited);
			}
		}
	}
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int n = s.length();
		int x = sc.nextInt();
		int grid[][] = new int[x][2];
		ArrayList<ArrayList<Integer>> l = new ArrayList<ArrayList<Integer>>();
		boolean visited[] = new boolean[n];
		for(int i=0;i<x;i++)
		{
			grid[i][0]=sc.nextInt();
			grid[i][1]=sc.nextInt();
		}
		for(int i=0;i<n;i++)
		{
			if(!visited[i]) 
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				fn(i,n,grid,temp,visited);
				l.add(temp);
			}
		}
		System.out.println(l);
		ArrayList<String> ans = new ArrayList<String>();
		for(int i=0;i<l.size();i++)
		{
			char[] ca = new char[l.get(i).size()];
			for(int a=0;a<l.get(i).size();a++)
			{
				ca[a]=s.charAt(l.get(i).get(a));
			}
			ArrayList<Integer> t = l.get(i);
			Collections.sort(t);
			Arrays.sort(ca);
			char[] c = s.toCharArray();
			int j=0;
			for(int idx : t)
			{
				c[idx]=ca[j++];
			}
			s ="";
			for(j=0;j<c.length;j++)
			{
				s+=c[j];
			}
		}
		System.out.println(s);
		
	}
}