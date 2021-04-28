/*
A dangerous virus "ebola" is spreading across african countries.
Few people stand in a form of p*q grid, some positions in the grid are empty.

The grid is represented with three values 0,1, 2.
Where
	- 0 indicates an empty position,
	- 1 indiactes a healthy person , or
	- 2 indiactes an infected person.
	
Every minute, any healthy person who is 4-directionally adjacent to an infected person becomes infected.

Your task is to find out the minimum amount of time in minutes that the virus takes to spread over all the people in that grid.

If this is impossible, return -1.

NOTE:
4-directions are Up, Down, Left, Right.

Input Format:
-------------
Line-1: Two integers P and Q, size of the grid.
Next P lines: contains Q space separated integers, either 0, 1, or 2.

Output Format:
--------------
An integer, the minimum amount of time in minutes


Sample Input-1:
---------------
3 3
2 1 1
1 1 0
0 1 1

Sample Output-1:
----------------
4

Explanation-1:
--------------
There is an infected person at position (0, 0).
In the first minute: people in (0, 1) and (1, 0) positions are infected.
In the second minute: people in (0, 2) and (1, 1) positions are infected.
In the third minute: person in (1, 2) position is infected.
In the fourth minute: person in (2, 2) position is infected.


Sample Input-2:
---------------
3 3
2 1 1
0 1 1
1 0 1

Sample Output-2:
----------------
-1

Explanation-2:
--------------
The healthy person in the bottom left corner (row 2, column 0) is never infected, 
because infection only happens 4-directionally.

Sample Input-3:
---------------
1 2
0 2

Sample Output-3:
----------------
0

Explanation-3: 
-------------
Since there is already no healthy person at minute 0, the answer is just 0.

*/
import java.util.*;
class EbolaVirus {
    // run the rotting process, by marking the rotten oranges with the timestamp
    public boolean runInfectionProcess(int timestamp, int[][] grid, int ROWS, int COLS) {
        int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        // flag to indicate if the rotting process should be continued
        boolean toBeContinued = false;
        for (int row = 0; row < ROWS; ++row)
            for (int col = 0; col < COLS; ++col)
                if (grid[row][col] == timestamp)
                    // current contaminated cell
                    for (int[] d : directions) {
                        int nRow = row + d[0], nCol = col + d[1];
                        if (nRow >= 0 && nRow < ROWS && nCol >= 0 && nCol < COLS)
                            if (grid[nRow][nCol] == 1) {
                                // this fresh orange would be contaminated next
                                grid[nRow][nCol] = timestamp + 1;
                                toBeContinued = true;
                            }
                    }
        return toBeContinued;
    }

    public int peopleInfected(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int timestamp = 2;
        while (runInfectionProcess(timestamp, grid, ROWS, COLS))
            timestamp++;
		
        // end of process, to check if there are still fresh oranges left
        for (int[] row : grid)
            for (int cell : row)
                // still got a fresh orange left
                if (cell == 1)
                    return -1;

        // return elapsed minutes if no fresh orange left
        return timestamp - 2;
    }
	
    public static void main(String args[] ) {
		 Scanner scan = new Scanner(System.in);
			int R=scan.nextInt();
			int C=scan.nextInt();      
			EbolaVirus ev=new EbolaVirus();
			int[][] grid=new int[R][C];
		       for(int i=0; i<R; i++)
		       {
		           for(int j=0; j<C; j++)
		           {
		        	   grid[i][j] = scan.nextInt();
		           }
		       }
		       System.out.println(ev.peopleInfected(grid));
	}
}