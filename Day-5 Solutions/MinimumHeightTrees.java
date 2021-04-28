/*
Thomas constructing a Tree of N nodes, nodes labelled as 0, 1, 2, .. ,n-1.
He is given a list of N-1 edges[], where edge[i]=[v1, v2], is an undirected edge
between v1 and v2.

He can construct the tree by selecting any node as root node.
You task is to find out the trees with the smallest height, among all the trees.

Print the root nodes of all the smallest height trees in ascending order.

NOTE: A Tree,is a connected graph without simple cycles.

Input Format:
-------------
Line-1: An integer N, number of nodes.
Next N-1 lines: Two integers, represent an edge.

Output Format:
--------------
Print the list of root nodes of Smallest Height Trees.
In ascending order

Sample Input-1:
---------------
4
0 1
2 1
1 3

Sample Output-1:
----------------
[1]

Explanation:
-------------
Tree Combinations are.

		0						1			
		|					   / | \
	   1					 0  2  3
	 /	  \
	2     3
	
		2						3			
		|					    |
	   1					   1
	 /	  \					 /   \
	0    3 				0    2


Sample Input-1:
---------------
6
3 0
1 3
3 2
4 3
5 4

Sample Output-1:
----------------
[3, 4]

*/

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1) return Collections.singletonList(0);

		List<Set<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; ++i)
			if (adj.get(i).size() == 1) leaves.add(i);

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if (adj.get(j).size() == 1) newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int edges[][]=new int[n][2];
		for(int i=0;i<n-1;i++){
			edges[i][0]=sc.nextInt();
			edges[i][1]=sc.nextInt();
		}
		List<Integer> result=new MinimumHeightTrees().findMinHeightTrees(n,edges);
		Collections.sort(result);
		System.out.println(result);		
	}
}