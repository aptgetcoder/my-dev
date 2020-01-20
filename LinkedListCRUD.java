
public class LinkedListCRUD {
	
	Node head;
	
	class Node{
		int data;
		Node next;
		
		Node (int d){
			data = d;
			next = null;
		}
	}

	public static void main(String[] args) {
		LinkedListCRUD list = new LinkedListCRUD();
		
		list = list.insert(1, list);
		list = list.insert(2, list);
		list = list.insert(3, list);
		
		printList(list);
		
		list = list.remove(3, list);
		
		printList(list);
		
		list = list.update(1, 5, list);
		
		printList(list);

	}

	private LinkedListCRUD update(int i, int j, LinkedListCRUD list) {
		Node curNode = list.head;
		int count = 0;
		while(curNode != null) {
			if(count == i) {
				curNode.data = j;
				return list;
			} else {
				curNode = curNode.next;
				count++;
			}
		}
		System.out.println("Key not found");
		return list;
	}

	private LinkedListCRUD remove(int i, LinkedListCRUD list) {
		
		Node curNode = list.head;
		Node prevNode = null;
		if(curNode != null && curNode.data == i) {
			list.head = curNode.next;
			return list;
		} 
		
		while(curNode != null && curNode.data != i) {
			prevNode = curNode;
			curNode = curNode.next;
		}
		
		if(curNode != null) {
			prevNode.next = curNode.next;
		}
		
		if(curNode == null) {
			System.out.println("Not Found");
		}
		return list;
	}

	private static void printList(LinkedListCRUD list) {
		
		Node curNode = list.head;
		
		while(curNode != null) {
			System.out.println(curNode.data);
			curNode = curNode.next;
		}
		
	}

	private LinkedListCRUD insert(int i, LinkedListCRUD list) {
		Node newNode = new Node(i);
		newNode.next = null;
		
		if(list.head == null) {
			list.head = newNode;
		} else {
			Node curNode = list.head;
			while(curNode.next != null) {
				curNode = curNode.next;
			}
			curNode.next = newNode;
		}
		return list;
	}

}
