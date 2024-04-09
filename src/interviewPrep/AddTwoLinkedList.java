package interviewPrep;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;





public class AddTwoLinkedList {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// setup
		LinkedList<ListNode> list1 = new LinkedList<>();
		LinkedList<ListNode> list2 = new LinkedList<>();
		list1.add(new ListNode(2));
		list1.add(new ListNode(4));
		list1.add(new ListNode(3));
		list2.add(new ListNode(5));
		list2.add(new ListNode(6));
		list2.add(new ListNode(4));
		
		
		// expected output -> 807 	(LinkedList)-> (7)->(0)->(8)
		System.out.println(addTwoNumbers(list1.getFirst(), list2.getFirst()));
	}
	
	// Solution
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int one = 0;
        int two = 0;
        ListNode cursor = l1;
        

        // grab both numbers from the linked lists
        // grab first number
        while(null != cursor) {
        	StringBuilder numberHelper = new StringBuilder();
        	numberHelper = numberHelper.append(cursor.val);
        	
        	// if cursor.next is NOT null... do something...
        	if(null != cursor.next) {

        		cursor = cursor.next;
        		// if cursor.next IS null... do something
        	} else {
        		numberHelper.reverse();
        		one = Integer.parseInt(numberHelper.toString());

        		continue;
        	}
        }
        cursor = l2;
        // grab second number
        while(null != cursor) {
        	StringBuilder numberHelper = new StringBuilder();
        	numberHelper = numberHelper.append(cursor.val);
        	
        	// if cursor.next is NOT null... do something...
        	if(null != cursor.next) {

        		cursor = cursor.next;
        		// if cursor.next IS null... do something
        	} else {
        		numberHelper.reverse();
        		two = Integer.parseInt(numberHelper.toString());

        		continue;
        	}
        }




            // put them in correct/reverse order?
        // add them together 
        
        
        
        
                // maybe reverse the order???
        // put them into a linked list... (in reverse order)
        // return new linked list
		
		return null;
	}

}



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}




