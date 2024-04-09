package interviewPrep;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InsertingNodeSortedDoublyLinkedList {

    static class DoublyLinkedListNode {
        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
            this.prev = null;
        }
    }

    static class DoublyLinkedList {
        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }

            this.tail = node;
        }
    }

    public static void printDoublyLinkedList(DoublyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }



    /*
     * Complete the 'sortedInsert' function below.
     *
     * The function is expected to return an INTEGER_DOUBLY_LINKED_LIST.
     * The function accepts following parameters:
     *  1. INTEGER_DOUBLY_LINKED_LIST llist
     *  2. INTEGER data
     */

    /*
     * For your reference:
     *
     * DoublyLinkedListNode {
     *     int data;
     *     DoublyLinkedListNode next;
     *     DoublyLinkedListNode prev;
     * }
     *
     */

    public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
    // Write your code here
        System.out.println("#### START ####");
        // check inputs
        System.out.println("inputs:");
        System.out.println("data -> " + data);
        System.out.println("llist.data -> " + llist.data);
        // DLL = 1, 3, 4, 10
        
        // create new node item 
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        // create pointer
        DoublyLinkedListNode pointer = llist;
        
                    // llist = 1        2       3           data 4
        // check null
        if (llist != null) {
            // check if data < llist
            // while(pointer.next != null) {       // might just change this to pointer != null?
            while(pointer != null && pointer.next != null) { 
                // check if insert is first
                if(newNode.data <= pointer.data ) {
                    newNode.next = pointer;
                    pointer.prev = newNode;
                    return newNode;
                }
                
                // check if insert is here
                if((pointer.data <= newNode.data) && ((pointer.next.equals(null)) || (pointer.next.data >= newNode.data))) {
                    // insert new node
                    // set newNode's points
                    newNode.prev = pointer;
                    newNode.next = pointer.next;
                    // reassign existing nodes
                    pointer.next.prev = newNode;
                    pointer.next = newNode;
                    // should at this point return the head node...
                    return llist;
                }

                pointer = pointer.next;
                
            }
            if(pointer.next == null) {
                    newNode.prev = pointer;
                    newNode.next = null;
                    // reassign existing nodes
                    pointer.next = newNode;

                    // should at this point return the head node...
                    return llist;
                }
            
            
            // single input.. check if newNode > or smaller.. insert.. return head.
            if(llist.data <= newNode.data) {
                // new node is bigger/equal
                newNode.prev = llist;
                llist.next = newNode;
                return llist;
            } else {
                // new node is smaller
                llist.prev = newNode;
                newNode.next = llist;
                return newNode;
            }
            
            // return back head of list, after inserting new node
            // return null;    // this might be break???
        } else {
            // input list was null... return back new node
        return newNode;
        }
        
        
        
        //System.out.println("#### END ####");
        
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            DoublyLinkedList llist = new DoublyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            int data = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            DoublyLinkedListNode llist1 = sortedInsert(llist.head, data);

            printDoublyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}



