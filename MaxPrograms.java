/*
In Hyderabad after a long pandemic gap, the Telangana Youth festival Is Organized at HITEX.

In HITEX, there are a lot of programs planned. During the festival in order
to maintain the rules of Pandemic, they put a constraint that one person can only
attend any one of the programs in one day according to planned days.

Now it’s your aim to implement the "Solution" class in such a way that you need to 
return the maximum number of programs you can attend according to given constraints.

Explanation:
You have a list of programs ‘p’ and days ’d’, where you can attend only one program on one day.
Programs [p] = [first day, last day], p is the program's first day and the last day.


Input Format:
-------------
Line-1: An integer N, number of programs.
Line-2: N comma separated pairs, each pair(f_day, l_day) is separated by space.

Output Format:
--------------
An integer, the maximum number of programs you can attend.


Sample Input-1:
---------------
4
1 2,2 4,2 3,2 2

Sample Output-1:
----------------
4

Sample Input-2:
---------------
6
1 5,2 3,2 4,2 2,3 4,3 5

Sample Output-2:
----------------
5


*/

import java.util.*;
import java.io.*;
/*
//BruteForce
class Solution {
    public int maxPrograms(int[][] events) {
        List<int[]> l = new ArrayList<>();
        for (int[] e : events) {
            l.add(e);
        }
        Collections.sort(l, (e1, e2) -> ((e1[1] != e2[1]) ? e1[1] - e2[1] : e1[0] - e2[0]));
        boolean[] slots = new boolean[l.get(l.size()-1)[1]+1];
        int count = 0;
        for (int[] e : l) {
            for (int x = e[0]; x <= e[1]; x++) {
                if (slots[x] == false) {
                    slots[x] = true;
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
*/

// Segment Tree
class Solution {
    
    class SegmentTreeNode {
        
        int start, end;
        SegmentTreeNode left, right;
        int val;
        
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            left = null;
            right = null;
            val = 0;
        }
    }
    
    SegmentTreeNode root;
    public int maxPrograms(int[][] events) {
        if (events == null || events.length == 0)
            return 0;
        
        Arrays.sort(events, (a, b) -> {
            if (a[1] == b[1])
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        int lastDay = events[events.length-1][1];
        int firstDay = Integer.MAX_VALUE;
        for (int i = 0; i < events.length; i++) {
            firstDay = Math.min(firstDay, events[i][0]);
        }
        
        root = buildSegmentTree(firstDay, lastDay);
        
        int count = 0;
        for (int[] event: events) {
            int earliestDay = query(root, event[0], event[1]);
            if (earliestDay != Integer.MAX_VALUE) {
                count++;
                update(root, earliestDay);
            }
            
        }
        return count;
    }
    
    private SegmentTreeNode buildSegmentTree(int start, int end) {
        if (start > end)
            return null;
        SegmentTreeNode node = new SegmentTreeNode(start, end);
        node.val = start;
        if (start != end) {
            int mid = start + (end - start)/2;
            node.left = buildSegmentTree(start, mid);
            node.right = buildSegmentTree(mid+1, end);
            
        }
        return node;
    }
    
    private void update(SegmentTreeNode curr, int lastDay) {
        if (curr.start == curr.end) {
            curr.val = Integer.MAX_VALUE;
        }
        else {
            int mid = curr.start + (curr.end - curr.start)/2;
            
            if (mid >= lastDay) {
                update(curr.left, lastDay);
            }
            else {
                update(curr.right, lastDay);
            }
            curr.val = Math.min(curr.left.val, curr.right.val);
        }
    }
    
    
    private int query(SegmentTreeNode curr, int left, int right) {
        if (curr.start == left && curr.end == right) {
            return curr.val;
        }
        
        int mid = curr.start + (curr.end - curr.start)/2;
        
        if (mid >= right) {
            return query(curr.left, left, right);
        }
        else if (mid < left) {
            return query(curr.right, left, right);
        }
        else
            return Math.min(query(curr.left, left, mid), query(curr.right, mid+1, right));
    }  
}

/*
//Greedy + Segment Tree
class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] event : events) {
            min = Math.min(min, event[0]);
            max = Math.max(max, event[1]);
        }

        Node root = build(min, max);
        int result = 0;

        for (int[] event : events) {
            if (attend(root, event[0], event[1])) {
                result++;
            }
        }

        return result;
    }

    private Node build(int start, int end) {
        Node node = new Node();
        node.start = start;
        node.end = end;
        node.attendable = true;

        if (start < end) {
            int c = start + (end - start) / 2;
            node.left = build(start, c);
            node.right = build(c + 1, end);
        }

        return node;
    }

    private boolean attend(Node node, int start, int end) {
        if (node == null || start > node.end || end < node.start || !node.attendable) {
            return false;
        }

        if (node.start == node.end) {
            node.attendable = false;
            return true;
        }

        boolean result = attend(node.left, start, end);
        if (!result) {
            result = attend(node.right, start, end);
        }

        node.attendable = node.left.attendable || node.right.attendable;

        return result;
    }

    private static class Node {
        int start, end;
        boolean attendable;

        Node left, right;
    }
}
*/

public class MaxPrograms{
	public static void main(String args[])  throws IOException 
    {
        Scanner scan = new Scanner(System.in);
        int n=scan.nextInt();
		scan.nextLine();
		String str[]=scan.nextLine().split(",");
        //Scanner s = new Scanner(str);// input file 
		//s.useDelimiter(",");
        int nums[][] = new int[n][2];// declaring 10000 records to read from the input.txt file 
        for (int i = 0; i < n; i++){
			String val[]=str[i].split(" ");
            nums[i][0] = Integer.parseInt(val[0]);
            nums[i][1] = Integer.parseInt(val[1]);
		}
		//  reading input into nums array 
        long startTime,finishTime,exetime,result;
        Solution fna=new Solution(); // Fenwick Tree Approch Class Object Creation
        startTime = System.nanoTime(); // record nanoTime() before the Fenwick Tree sumRange() call
        result=fna.maxPrograms(nums); // call Fenwick sumRange()
        finishTime = System.nanoTime(); // record nanoTime() After the Fenwick Tree sumRange() call
        exetime=finishTime-startTime;
        System.out.println(result);
        System.out.println("Time Taken(ns)$"+(exetime));
    }
}