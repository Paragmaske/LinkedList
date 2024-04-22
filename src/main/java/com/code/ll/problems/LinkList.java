package com.code.ll.problems;

public class LinkList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int val) {
			this.data = val;
		}
	}

	static void insertData(LinkList l, int val) {
		Node newNode = new Node(val);
		if (l.head == null) {
			l.head = newNode;
			return;
		} else {
			Node curr = l.head;
			while (curr.next != null) {
				curr = curr.next;
			}
			curr.next = newNode;

		}
	}

	static void deleteData(LinkList l, int val) {

		if (l.head.data == val) {
			l.head = l.head.next;
			return;
		} else {
			Node curr = l.head;
			Node prev = null;
			while (curr != null) {
				if (curr.data == val) {
					prev.next = curr.next;
				}
				prev = curr;
				curr = curr.next;
			}
		}
	}

	static void printData(LinkList l) {
		Node curr = l.head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
	}

	static int lengthOfll(LinkList l) {
		int count = 0;
		Node curr = l.head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public static Node getIntersectionNode(Node headA, Node headB) {
		Node currA = headA;
		Node currB = headB;
		int l1 = 0, l2 = 0;
		while (currA != null) {
			currA = currA.next;
			l1++;
		}
		// System.out.println(l1);
		while (currB != null) {
			currB = currB.next;
			l2++;
		}
		// System.out.println(l2);
		int diff;
		Node i1 = headA;
		Node i2 = headB;
		if (l1 > l2) {
			diff = l1 - l2;
			int inner = 0;
			while (i1 != null) {
				if (inner == diff)
					break;
				i1 = i1.next;
				inner++;
			}

		} else {
			diff = l2 - l1;
			int inner = 0;
			while (i2 != null) {
				if (inner == diff)
					break;
				i2 = i2.next;
				inner++;
			}
		}

		while (i1 != null && i2 != null) {
			if (i1 == i2) {
				return i1;

			}
			i1 = i1.next;
			i2 = i2.next;
		}
		return i2;
	}

	public static void main(String[] args) {
		LinkList l = new LinkList();
		insertData(l, 4);
		insertData(l, 1);
		insertData(l, 8);
		insertData(l, 4);
		insertData(l, 5);

		LinkList l2 = new LinkList();
		insertData(l2, 5);
		insertData(l2, 6);
		insertData(l2, 1);
		insertData(l2, 8);
		insertData(l2, 4);
		insertData(l2, 5);

		System.out.println(getIntersectionNode(l.head, l2.head).data);

	}
}
