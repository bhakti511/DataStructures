import java.util.Scanner;

//Node Structure
class Node {
	int data;
	Node next;
    Node prev;

	// Constructor - Create new Node
	Node(int data) {
		this.data = data;
		this.next = null;
        this.prev = null;
	}
}

public class DoublyLinkedList {
	Node head;

	//Insert element at beginning
	Node insertAtBeg(int key, Node head) {
		Node tmp = new Node(key);
		if (head == null) {
			head = tmp;
		} else {
			tmp.next = head;
            head.prev = tmp;
			head = tmp;
		}

		return head;
	}

	//Insert element at last
	Node insertAtLast(int key, Node head) {
		Node tmp = new Node(key);
		Node dummy = head;
		if (dummy == null) {
			dummy = tmp;
			head = dummy;
		}
		else {
			while (dummy.next != null) {
				dummy = dummy.next;
			}
			dummy.next = tmp;
            tmp.prev = dummy;
		}
		
		return head;
	}

	//Insert element at given position
	Node insertAtPos(int pos, int key, Node head) {
		Node tmp = new Node(key);
		if (pos == 1) {
			tmp.next = head;
            head.prev = tmp;
			head = tmp;
		}
		else if (pos >= length(head)) {
			head = insertAtLast(key, head);
		}
		else {
			pos--;
			Node dummy = head;
			while (pos != 1) {
				dummy = dummy.next;
				pos--;
			}
			tmp.next = dummy.next;
            dummy.next.prev = tmp;
            dummy.next = tmp;
            tmp.prev = dummy;
		}

		return head;
	}

	//Display Linked List
	void display(Node head) {
		Node tmp = head;
		System.out.print("List elemnets are : ");
		while (tmp != null) {
			System.out.print(tmp.data + " ");
			tmp = tmp.next;
		}
		System.out.println();
	}

	//Find length of linked list
	int length(Node head) {
		int i = 0;
		Node tmp = head;
		if (tmp == null) {
			return 0;
		} else {
			while (tmp != null) {
				tmp = tmp.next;
				i++;
			}
		}
		return i;
	}

	//Reverse the linked list
	Node reverse(Node head) {

		Node currNode = head;
		Node prevNode = null;
		
		while (currNode != null) {
			currNode.prev = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = currNode.prev;
		}

		head = prevNode;
		return head;
	}

	//Delete the node at certain position
	Node deleteAtPos(int pos, Node head) {
		Node tmp = head;

		if (pos == 1) {
			head = tmp.next;
		}
		else {
			for (int i = 1; i < pos - 1; i++) {
				tmp = tmp.next;
			}
			if (pos == length(head)) {
				tmp.next = null;
			}
			else {
				tmp.next = tmp.next.next;
            	tmp.next.prev = tmp;
			}
		}
		return head;
	}

	
	public static void main(String args[]) {

        DoublyLinkedList d = new DoublyLinkedList();
        d.head = null;
		Scanner in = new Scanner(System.in);
		do {
			System.out.println("\n********* MENU *********");
			System.out.println("\n1.Insert In End");
			System.out.println("\n2.Insert In Beg");
			System.out.println("\n3.Insert At A  Particular Pos");
			System.out.println("\n4.Delete At a Pos");
			System.out.println("\n5.Length");
			System.out.println("\n6.Reverse");
			System.out.println("\n7.Display");
			System.out.println("\n8.EXIT");
			System.out.println("\nenter ur choice : ");
			int n = in.nextInt();
			switch (n) {
			case 1:
				System.out.println("Enter the value: ");
				d.head = d.insertAtLast(in.nextInt(), d.head);
				break;
			case 2:
				System.out.println("Enter the value: ");
				d.head = d.insertAtBeg(in.nextInt(), d.head);
				break;
			case 3:
				System.out.println("Enter the value: ");
				int key = in.nextInt();
				System.out.println("Enter the Position: ");
				int pos = in.nextInt();
				
				d.head = d.insertAtPos(pos, key, d.head);
				break;
			case 4:
				System.out.println("Enter the position of element You want to delete : ");
				d.head = d.deleteAtPos(in.nextInt(), d.head);
				break;
			case 5:
				System.out.println(d.length(d.head));
				break;
			case 6:
				d.head = d.reverse(d.head);
				break;
			case 7:
				d.display(d.head);
				break;
			case 8:
				System.out.println("Exiting you from the application!!");
				System.exit(0);
				break;
			default:
				System.out.println("\n Wrong Choice!");
				break;
			}
			System.out.println("\n do u want to cont... ");
		} while (in.nextInt() == 1);
	}
}
