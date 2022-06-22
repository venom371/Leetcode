import java.util.*;

public class LL{
	Node head;
	Node tail;
	private int size = 0;
	
	class Node{
		int data;
		Node next;
		Node prev;
		Node(int data){
			this.prev = null;
			this.data = data;
			this.next = null;
		}
	}

	public void addFirst(int data){
		Node newNode = new Node(data);
		size++;
		if(head == null){
			head = newNode;
			tail = newNode;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
		if(tail == null){
			tail = newNode;
		}
	}
	
	public void addLast(int data){
		Node newNode = new Node(data);
		size++;
		if(head == null){
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}
	
	public void removeFirst(){
		if(head == null){
			System.out.println("empty linked list");
			return;
		}
		size--;
		head = head.next;
		head.prev = null;
	}

	public void removeLast(){
		if(head == null){
			System.out.println("empty linked list");
			return;
		}
		size--;
		tail = tail.prev;
		tail.next = null;
	}

	public void printList(){
		if(head == null){
			System.out.println("empty linked list");
			return;
		}
		Node curr = head;
		while(curr.next != null){
			System.out.print(curr.data + " -> ");
			curr = curr.next;
		}
		System.out.println(curr.data);
	}
	
	public void printReverse(){
		if(head == null){
			System.out.println("empty linked list");
			return;
		}
		Node curr = tail;
		while(curr.prev != null){
			System.out.print(curr.data + " -> ");
			curr = curr.prev;
		}
		System.out.println(curr.data);
	}

	public String find(int n){
		String result = "";
		Node curr = head;
		for(int i = 0; i <= n; i++){
			result = curr.data;
			curr = curr.next;
		}
		return result;
	}
	public void insert(int n, String str){
		Node curr = head;
		int i = 0;
		while(){

		}
	}
	public void pairs(int n){
		if(head == null || head.next == null){
			System.out.println("too short to find pairs");
			return;
		}
		boolean flag = true;
		Node first = head;
		Node second = tail;
		while(first != null && second != null && first != second){
			int num1 = first.data;
			int num2 = second.data;
			int check = num1 + num2;
			if(check == n){
				System.out.println("("+num1+", "+num2+")");
				first = first.next;
				second = second.prev;
			}
			else if(check < n)
				first = first.next;
			else
				second = second.prev;
		}
	}

	public void rotateClockwise(int n){
		int count = 0;
		Node curr = head;
		while(count < n){
			head = curr.next;
			curr.prev = tail;
			curr.next = null;
			tail.next = curr;
			tail = curr;
			count++;
			curr = head;
		}
		printList();
	}

	public Node reverseInGroup(Node node, int n){
		if(n == 0 || n == 1)
			return node;
		if(node == null)
			return node;
		int count = 0;
		node.prev = null;
		Node curr = node;
		Node temp;
		Node newHead = null;
		while(curr != null && count < n){
			newHead = curr;
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;
			count++;
			curr = curr.prev;
		}
		
		if(count >= n){
			Node rest = reverseInGroup(curr, n);
			node.next = rest;
			if(rest != null)
				rest.prev = node;
		}
		return newHead;
	}
	public void triplet(int n){
		if(head == null || head.next == null || head.next.next == null){
			System.out.println("insufficient nodes to find triplets");
			return;
		}
		Node ptr = head;
		
		while(ptr.next != null && ptr.next.next != null){
			Node start = ptr.next;
			Node end = tail;
			while(start != null && end != null && start != end){
				int num1 = ptr.data;
				int num2 = start.data;
				int num3 = end.data;
				int check = num1 + num2 + num3;
				if(check == n){
					System.out.println("("+num1+", "+num2+", "+num3+")");
					start = start.next;
					end = end.prev;
				}
				else if(check > n)
					end = end.prev;
				else
					start = start.next;
			}
			ptr = ptr.next;
		}
	}

	public int getSize(){
		return size;
	}
	public static void main(String[] args){
		LL list1 = new LL();
		//LL list2 = new LL();
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for(int i = 0; i < n; i++){
			int num = s.nextInt();
			list1.addLast(num);
		}
		list1.printList();
		int n1 = s.nextInt();
		list1.head = list1.reverseInGroup(list1.head, n1);
		list1.printList();
		
	}
}

