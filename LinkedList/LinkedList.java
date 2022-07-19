

public class LinkedList {
	
		Node head; // head of list
	    Node slow, fast, second_halflist;
	  
	  
	    class Node {
	        char data;
	        Node next;
	  
	        Node(char d)
	        {
	            data = d;
	            next = null;
	        }
	    }
	  
	    //to check if given linked list is palindrome or not 
	    boolean isPalindrome(Node head)
	    {
	        slow = head;
	        fast = head;
	        Node prev_of_slow = head;
	        Node midnode = null; // To handle odd size list
	        boolean result = true; // initialize result
	  
	        if (head != null && head.next != null) {
	            
	            while (fast != null && fast.next != null) {
	                fast = fast.next.next;
	  
	               
	                prev_of_slow = slow;
	                slow = slow.next;
	            }
	  
	            
	            if (fast != null) {
	                midnode = slow;
	                slow = slow.next;
	            }
	  
	           
	            second_halflist = slow;
	            prev_of_slow.next = null; 
	            reverse(); // Reverse the second half
	            result = compareLists(head, second_halflist); 
	  
	          
	            reverse(); // Reverse the second half 
	  
	            if (midnode != null) {
	                // If there was a mid node which was not part of either first  or second half.
	                prev_of_slow.next = midnode;
	                midnode.next = second_halflist;
	            }
	            else
	                prev_of_slow.next = second_halflist;
	        }
	        return result;
	    }
	  
	    // reverse the linked list  
	    void reverse()
	    {
	        Node prev = null;
	        Node current = second_halflist;
	        Node next;
	        while (current != null) {
	            next = current.next;
	            current.next = prev;
	            prev = current;
	            current = next;
	        }
	        second_halflist = prev;
	    }
	  
	    //check if two input lists have same data
	    boolean compareLists(Node head1, Node head2)
	    {
	        Node temp1 = head1;
	        Node temp2 = head2;
	  
	        while (temp1 != null && temp2 != null) {
	            if (temp1.data == temp2.data) {
	                temp1 = temp1.next;
	                temp2 = temp2.next;
	            }
	            else
	                return false;
	        }
	  
	      
	        if (temp1 == null && temp2 == null)
	            return true;
	  
	      
	        return false;
	    }
	  
	    
	    public void push(char new_data)
	    {
	       
	        Node new_node = new Node(new_data);
	  
	        
	        new_node.next = head;
	  
	       
	        head = new_node;
	    }
	  
	    //  print a given linked list
	    void printList(Node ptr)
	    {
	        while (ptr != null) {
	            System.out.print(ptr.data + "->");
	            ptr = ptr.next;
	        }
	        System.out.println("NULL");
	    }
	  
	   
	    public static void main(String[] args)
	    {
	  
	      // Starting with the empty list 
	        LinkedList linkedList = new LinkedList();
	  
	        char str[] = { 'R', 'A', 'C', 'E' ,'C','A','R' };
	        String string = new String(str);
	        for (int i = 0; i < 7; i++) {
				linkedList.push(str[i]);
	            linkedList.printList(linkedList.head);
	            if (linkedList.isPalindrome(linkedList.head) != false) {
	                System.out.println("It is a Palindrome");
	                System.out.println("");
	            }
	            else {
	                System.out.println("It is not a Palindrome");
	                System.out.println("");
	            }
	        }
	    }

}