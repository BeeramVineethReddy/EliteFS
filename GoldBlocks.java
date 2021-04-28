/* 
A magic box with p rows and r columns is initially filled with silver .If we invoke a method
addMagicOperation which turns the silver at index (row, col) into gold. 
Given N set of indices to work up on, find the number of gold-blocks which are formed after each
addMagicOperation. A gold-block is a block of gold cells connected horizontally and vertically
and surrounded by silver. Consider all four edges of the magic box are surrounded by
silver.

Input Format:
--------------
Line-1: Three space separated integers p, r , and n (number of add Magic Operations)
Next N lines: Two space separated integers, cell to perform addMagicOperation 

Output Format:
--------------
Print a list of numbers, number of gold-blocks formed after each addMagicOperation


Sample Input-1:
-----------------
3 3 5
0 0
0 1
1 2
2 1
1 1

Sample Output-1:
-----------------
[1, 1, 2, 3, 1]

Explanation:

Initially, the magic box is filled with silver. (Assume 0 represents silver and 1 represents gold).

0 0 0
0 0 0
0 0 0

Operation #1: addMagicOperation(0, 0) turns the silver at cell[0][0] into gold.

1 0 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #2: addMagicOperation(0, 1) turns the silver at cell[0][1] into gold.

1 1 0
0 0 0   Number of Gold-blocks = 1
0 0 0

Operation #3: addMagicOperation(1, 2) turns the silver at cell[1][2] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 2
0 0 0

Operation #4: addMagicOperation(2, 1) turns the silver at cell[2][1] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 3
0 1 0

Operation #5: addMagicOperation(1, 1) turns the silver at cell[1][1] into gold.

1 1 0
0 0 1   Number of Gold-blocks = 1
0 1 0

==== Testcases ====
case =1
input =3 3 5
0 0
0 1
1 2
2 1
1 1
output =[1, 1, 2, 3, 1]

case =2
input =4 4 8
0 1
2 3
3 3
1 2
2 1
1 3
0 2
1 1
output =[1, 2, 2, 3, 4, 3, 2, 1]

case =3
input =5 6 10
1 2
2 3
4 4
3 3
4 5
3 5
1 1
3 4
0 5
2 4
output =[1, 2, 3, 3, 3, 3, 3, 2, 3, 3]

case =4
input =7 7 15
1 2
2 3
3 4
4 5
5 6
1 4
1 6
2 5
3 6
2 2
3 3
4 4
5 5
6 6
1 5
output =[1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 5, 3]

case =5
input =7 7 20
1 2
2 3
3 4
4 5
5 6
1 4
1 6
2 5
3 6
2 2
3 3
4 4
5 5
6 6
1 5
1 1
3 5
2 4
5 2
6 3
output =[1, 2, 3, 4, 5, 6, 7, 8, 9, 8, 7, 6, 5, 5, 3, 3, 1, 1, 2, 3]

case =6
input =8 8 26
0 0
2 0
4 0
6 0
0 3
2 3
4 3
6 3
0 7
2 7
4 7
6 7
1 3
3 3
5 3
1 0
3 0
5 0
1 7
3 7
5 7
0 1
0 2
6 4
6 5
6 6
output =[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 3, 2, 2, 2, 1]

 */
import java.util.*;

public class GoldBlocks {
	
	static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

	public static List<Integer> numGoldBocks(int m, int n, int[][] positions) {
	    List<Integer> result = new ArrayList<>();
	    if(m <= 0 || n <= 0) return result;

	    int count = 0;                      // number of islands
	    int[] roots = new int[m * n];       // one island = one tree
	    Arrays.fill(roots, -1);            

	    for(int[] p : positions) {
	        int root = n * p[0] + p[1];     // assume new point is isolated island
	        roots[root] = root;             // add new island
	        count++;

	        for(int[] dir : dirs) {
	            int x = p[0] + dir[0]; 
	            int y = p[1] + dir[1];
	            int nb = n * x + y;
	            if(x < 0 || x >= m || y < 0 || y >= n || roots[nb] == -1) continue;
	            
	            int rootNb = findGoldBlock(roots, nb);
	            if(root != rootNb) {        // if neighbor is in another island
	                roots[root] = rootNb;   // union two islands 
	                root = rootNb;          // current tree root = joined tree root
	                count--;               
	            }
	        }

	        result.add(count);
	    }
	    return result;
	}
	
	public static int findGoldBlock(int[] roots, int id) {
	    while(id != roots[id]) {
	        roots[id] = roots[roots[id]];   // only one line added
	        id = roots[id];
	    }
	    return id;
	}

	
	public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
			int m=scan.nextInt();
			int n=scan.nextInt();      
			int p=scan.nextInt();      

			int[][] positions=new int[p][2];
		       for(int i=0; i<p; i++)
		       {
		        	positions[i][0] = scan.nextInt();
		        	positions[i][1] = scan.nextInt();
		       }
		       System.out.println(numGoldBocks(m,n,positions));
	}
}
