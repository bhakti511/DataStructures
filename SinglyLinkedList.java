import java.util.Scanner;

//Node Structure
class Node {
	int data;
	Node next;

	// Constructor - Create new Node
	Node(int data) {
		this.data = data;
		this.next = null;
	}
}


public class SinglyLinkedList {
	Node head;

	//Insert element at beginning
	Node insertAtBeg(int key, Node head) {
		Node tmp = new Node(key);
		if (head == null) {
			head = tmp;
		} else {
			tmp.next = head;
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
		}
		
		return head;
	}

	//Insert element at given position
	Node insertAtPos(int pos, int key, Node head) {
		Node tmp = new Node(key);
		if (pos == 1) {
			tmp.next = head;
			head = tmp;
		} else {
			pos--;
			Node dummy = head;
			while (pos != 1) {
				dummy = dummy.next;
				pos--;
			}
			tmp.next = dummy.next;
			dummy.next = tmp;
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
		Node nextNode;

		while (currNode != null) {
			nextNode = currNode.next;
			currNode.next = prevNode;
			prevNode = currNode;
			currNode = nextNode;
		}

		head = prevNode;
		return head;
	}

	//Delete the node at certain position
	Node deleteAtPos(int pos, Node head) {

		Node tmp = head;

		if (pos == 1) {
			head = tmp.next;
		} else {
			for (int i = 1; i < pos - 1; i++) {
				tmp = tmp.next;
			}
			tmp.next = tmp.next.next;
		}
		return head;
	}

	
	public static void main(String args[]) {
		SinglyLinkedList l = new SinglyLinkedList();
		l.head = null;
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
				l.head = l.insertAtLast(in.nextInt(), l.head);
				break;
			case 2:
				System.out.println("Enter the value: ");
				l.head = l.insertAtBeg(in.nextInt(), l.head);
				break;
			case 3:
				System.out.println("Enter the value: ");
				int key = in.nextInt();
				System.out.println("Enter the Position: ");
				int pos = in.nextInt();
				
				l.head = l.insertAtPos(pos, key, l.head);
				break;
			case 4:
				System.out.println("Enter the position of element You want to delete : ");
				l.head = l.deleteAtPos(in.nextInt(), l.head);
				break;
			case 5:
				System.out.println(l.length(l.head));
				break;
			case 6:
				l.head = l.reverse(l.head);
				break;
			case 7:
				l.display(l.head);
				break;
			case 8:
;				System.out.println("Exiting you from the application!!");
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
