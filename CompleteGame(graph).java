/*
EA Sports, developed a video game.
They designed a game in such a way that, there are L number of levels from 1 to L.
There are D number of dependencies where each dependency[m] = [ Xm, Ym ], represents
a prerequisite relationship, that is, in order to play level-Ym,  
you must have completed the level-Xm . 

In one day you can complete any number of levels as long as you have completed all 
the prerequisites levels in the game. 

You cannont play a level-Ym which has some prerequisite level-Xm on same day.

Write a method to return the minimum number of days to complete all the levels in the game. 
If there is no way to complete all the levels, return -1.


Input Format:
-------------
Line-1: An integer L, number of courses.
Line-2: An integer D, number of dependencies.
Next D lines: Two space separated integers, Xm and Ym.

Output Format:
--------------
An integer, the minimum number of days to complete all the levels in the game.


Sample Input-1:
---------------
3
2
1 3
2 3

Sample Output-1:
----------------
2

Explanation-1:
--------------
On the first day, levels 1 and 2 are completed. On the second day, level 3 is completed.


Sample Input-2:
---------------
3
3
1 2
2 3
3 1

Sample Output-2:
----------------
-1

Explanation-2:
-------------
No level can be completed because they depend on each other.

*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CompleteGame {
	public int minimumDays(int N, int[][] relations) {
        // 1. build a graph
        int days=0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] relation: relations) {
            graph.computeIfAbsent(relation[0]-1, x -> new ArrayList()).add(relation[1]-1);
        }
        int[] visited = new int[N];
        int[] dp = new int[N];
        int semesters = -1;
        for(int i = 0; i < N; i++) {
            // calculate max Path using dynamic programming
            if (!dfs(graph, visited, dp, i)) {
                return -1;
            }
            days = Math.max(days, dp[i]);
        }
        return days;
    }
    
    private boolean dfs(Map<Integer, List<Integer>> graph, int[] visited, int[] dp, int node) {
        if (visited[node] == 2) {
            // cycle detected
            return false;
        }
        if (visited[node] == 1) {
            // value already calculated
            return true;
        }
        visited[node] = 2; // node is visited and in dfs stack
        dp[node] = 1;
        for (int child: graph.getOrDefault(node, new ArrayList<>())) {
            if (!dfs(graph, visited, dp, child)) {
                return false;
            }
            dp[node] = Math.max(dp[node], 1+dp[child]); // calcualte the max path
        }
        visited[node] = 1; // node is visited, remove from visited stack
        return true;
    }
	 
	public static void main(String args[] ) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str ;
		String[] rel;
		int levels,nrelations;
		levels = Integer.parseInt(br.readLine());
		nrelations=Integer.parseInt(br.readLine());
		int[][] relations=new int[nrelations][2];

	   for(int i=0; i<nrelations; i++)
	   {
		   str = br.readLine();
		   rel = str.split(" ");
		   relations[i]=Arrays.asList(rel).stream().mapToInt(Integer::parseInt).toArray();
	   }  	   
	   System.out.println(new CompleteGame().minimumDays(levels,relations));
	} 
}