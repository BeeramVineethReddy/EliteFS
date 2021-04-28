/*
A Kid is arranging a structure using building blocks, 
by placing individual building-block adjacent to each other.

A building-block is a vertical alignment of blocks.
		                            ___
here one block each represents  as |___|.

The following structure made up of using building blocks

                      ___
                  ___|___|    ___
                 |___|___|_w_|___|___              ___
              ___|___|___|___|___|___| w   _w_  w |___| 
          ___|___|___|___|___|___|___|_w__|___|_w_|___|____________

            0  1   3   4   2   3    2   0   1   0   2

Once the structure is completed, kid pour water(w) on it.

You are given a list of integers, heights of each building-block in a row.
Now your task How much amount of water can be stored by the structure.


Input Format:
-------------
Space separated integers, heights of the blocks in the structure. 

Output Format:
--------------
Print an integer, 


Sample Input:
-------------
0 1 3 4 2 3 2 0 1 0 2
    
Sample Output:
--------------
6
    
Explanation:
-----------
In the above structure,  6 units of water (w represents the water in the structure)
can be stored.

========TestCases========
case =1
input =1 4 2 5 6 3 7 1 2 6
output =14

case =2
input =1 5 1 1 4 6 7 8 3 0 0 5
output =21

case =3
input =5 0 0 0 0 0 1 1 1 0 0 4
output =37

case =4
input =5 4 2 2 6 0 1 1 1 3 0 4
output =25

case =5
input =1 2 3 4 5 6 7 8 9 3
output =0

case =6
input =1 6 3 4 8 2 4 8 1 12
output =22

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class TrapWater {
	public int trap(int[] A){
		int a=0;
		int b=A.length-1;
		int max=0;
		int leftmax=0;
		int rightmax=0;
		while(a<=b){
			leftmax=Math.max(leftmax,A[a]);
			rightmax=Math.max(rightmax,A[b]);
			if(leftmax<rightmax){
				max+=(leftmax-A[a]);       // leftmax is smaller than rightmax, so the (leftmax-A[a]) water can be stored
				a++;
			}
			else{
				max+=(rightmax-A[b]);
				b--;
			}
		}
		return max;
	}
		
	public static void main(String args[])throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] height = str.split(" ");
		int[] heights = Arrays.asList(height).stream().mapToInt(Integer::parseInt).toArray();
		System.out.println(new TrapWater().trap(heights));
	}
}