/*
In South Central Railways, There are N Railway Tracks,
Each Railway track passing through a set of stations, each station indicated 
with positive integer.

You are given K railway-tracks information, with the stations number list of 
each track in ascending order.

Your task is to return the merged list of station numbers of all tracks together


Input Format:
-------------
Line-1: AN integer K, number of railway tracks
Next K lines: space separated of integrs, numbers of stations in each track.

Output Format:
--------------
Print the list of merged station numbers of all tracks.


Sample Input-1:
---------------
3
1 2 3 4
2 4 8
2 3 7 11

Sample Output-1:
----------------
1 2 2 2 3 3 4 4 7 8 11



Sample Input-2:
---------------
3
1 3 8 10
2 5 8 9
3 5 6 8 10

Sample Output-2:
----------------
1 2 3 3 5 5 6 8 8 8 9 10 10


==== Testcases ====
case =1
input =3
1 3 8 10
2 5 8 9
3 5 6 8 10
output =1 2 3 3 5 5 6 8 8 8 9 10 10

case =2
input =3
1 2 3 4
2 4 8
2 3 7 11
output =1 2 2 2 3 3 4 4 7 8 11

case =3
input =4
1 2 3 4 5 6 7 8 9
1 2 4 6 7 8 11 12 13
2 4 6 8 10 12 14
1 3 5 7 9 11
output =1 1 1 2 2 2 3 3 4 4 4 5 5 6 6 6 7 7 7 8 8 8 9 9 10 11 11 12 12 13 14

case =4
input =5
1 2 3 4 5 6 7 8 9
1 2 4 6 7 8 11 12 13
2 4 6 8 10 12 14
1 3 5 7 9 11
1 2 4 5 7 8 9 10 11 12 13 15 16 17
output =1 1 1 1 2 2 2 2 3 3 4 4 4 4 5 5 5 6 6 6 7 7 7 7 8 8 8 8 9 9 9 10 10 11 11 11 12 12 12 13 13 14 15 16 17

case =5
input =6
1 2 3
4 5 6
1 2 3 4 5 6
1 2 3 4 5 6 7 8 9
7 8 9
10 11 12
output =1 1 1 2 2 2 3 3 3 4 4 4 5 5 5 6 6 6 7 7 8 8 9 9 10 11 12

case =6
input =8
1 2 3
4 5 6
1 2 3 4 5 6
1 2 3 4 5 6 7 8 9
7 8 9
10 11 12
7 8 9 10 11 12
1 2 3 4 5 6 7 8 9 10 11 12
output =1 1 1 1 2 2 2 2 3 3 3 3 4 4 4 4 5 5 5 5 6 6 6 6 7 7 7 7 8 8 8 8 9 9 9 9 10 10 10 11 11 11 12 12 12

*/


/*
	we can simply add all numbers to a priority queue then create a new linked list and return head
	this is accepted in leetcode * 23. Merge k Sorted Lists *
*/
import java.util.*;

class ListNode {
	public ListNode next;
	public int val;

	// Creates an empty node.
	public ListNode() {
		next = null;
		val = Integer.MIN_VALUE;
	}

	// Creates a node storing the specified val.
	public ListNode(int val) {
		next = null;
		this.val = val;
	}

	// Returns the node that follows this one.
	public ListNode getNext() {
		return next;
	}

	// Sets the node that follows this one.
	public void setNext(ListNode node) {
		next = node;
	}

	// Returns the val stored in this node.
	public int getval() {
		return val;
	}

	// Sets the val stored in this node.
	public void setval(int elem) {
		val = elem;
	}

	// Sets the val stored in this node.
	public String toString() {
		return Integer.toString(val);
	}
}

class MyLinkedList {
	// This class has a default constructor:
	public MyLinkedList() {
		length = 0;
	}

	// Length of the linked list
	private int length = 0;
	// This is the only field of the class. It holds the head of the list
	ListNode head;

	// Insert a node at the end of the list
	public synchronized void insertAtEnd(ListNode node) {
		if (head == null)
			head = node;
		else {
			ListNode p, q;
			for (p = head; (q = p.getNext()) != null; p = q)
				;
			p.setNext(node);
		}
		length++;
	}

	// Return a string representation of this collection, in the form
	// "str1" "str2" ....
	public String toString() {
		String result = "";
		if (head == null) {
			return "NULL";
		}
		result = result + head.getval();
		ListNode temp = head.getNext();
		while (temp != null) {
			result = result + " " + temp.getval();
			temp = temp.getNext();
		}
		
		return result;
	}

	// Return the current length of the list.
	public int length() {
		return length;
	}

}

class Solution {
	public ListNode mergeTwoLists(ListNode l1,ListNode l2){
		ListNode dummy = new ListNode(-1);
		ListNode prev = dummy;
		
		ListNode c1 = l1;
		ListNode c2 = l2;
		
		while(c1 != null && c2 != null){
			if(c1.val < c2.val){
				prev.next = c1;
				c1 = c1.next;
			}else{
				prev.next = c2;
				c2 = c2.next;
			}
			prev = prev.next;
		}
		
		prev.next = c1 != null ? c1 : c2;
		return dummy.next;
	}

	public ListNode mergeKLists(ListNode[] lists,int si,int ei){
		if(si == ei){
			return lists[si];
		}
			
		int mid = (si + ei) / 2;
		ListNode l1 = mergeKLists(lists,si,mid);
		ListNode l2 = mergeKLists(lists,mid + 1,ei);
		
		return mergeTwoLists(l1,l2);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		
		return mergeKLists(lists,0,lists.length - 1);
	}
}	

public class MergeKLists{
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		MyLinkedList res = new MyLinkedList();
		sc.nextLine();
		MyLinkedList[] lists=new MyLinkedList[n];
		
		for(int i=0;i<n;i++){
			String[] str = sc.nextLine().split(" ");
			lists[i]=new MyLinkedList();
			for(String s:str)
				lists[i].insertAtEnd(new ListNode(Integer.parseInt(s)));
		}
		
		ListNode heads[]=new ListNode[n];
		for(int i=0;i<n;i++)
			heads[i]=lists[i].head;
		
		res.head = new Solution().mergeKLists(heads);
			System.out.println(res.toString());
	}
}
