// package LinkedListclass;

public class LinkedListCode {
	private class Node {
		public int data;
		public Node next;
	}

	private Node head;
	private Node tail;
	private int size;
	// only for 1 function--rdr
	private Node rdr_left;

	// o1
	public LinkedListCode() {
		head = tail = null;
		size = 0;
	}

	// on
	public void display() {
		Node temp = head;
		for (int i = 0; i < size; i++) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	// o1
	private void handleAddWhenSizeIs0(int data) {
		Node nn = new Node();

		nn.data = data;
		nn.next = null;

		head = tail = nn;
		size = 1;
	}

	// o1
	public void addLast(int data) {
		if (size == 0) {
			handleAddWhenSizeIs0(data);
		} else {
			Node nn = new Node();

			nn.data = data;
			nn.next = null;

			tail.next = nn;

			tail = nn;
			size++;
		}
	}

	// o1
	public boolean isEmpty() {
		return size == 0;
	}

	// o1
	public int getSize() {
		return size;
	}

	// o1
	public int getFirst() {
		if (size == 0) {
			return -1;
		} else {
			return head.data;
		}
	}

	// o1
	public int getLast() {
		if (size == 0) {
			return -1;
		} else {
			return tail.data;
		}
	}

	// on
	private Node getNodeAt(int idx) {
		Node temp = head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}
		return temp;
	}

	// o1
	private int handleRemoveWhenSizeIs1() {
		int temp = head.data;

		head = tail = null;
		size = 0;

		return temp;
	}

	// on
	public int removeAt(int idx) {
		if (idx < 0 || idx >= size) {
			return -1;
		} else if (idx == 0) {
			return removeFirst();
		} else if (idx == size - 1) {
			return removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;
			size--;

			int temp = n.data;
			return temp;
		}
	}

	// on
	public int removeLast() {
		if (size == 1) {
			return handleRemoveWhenSizeIs1();
		} else {
			Node sl = getNodeAt(size - 2);
			sl.next = null;

			int temp = tail.data;

			tail = sl;
			size--;

			return temp;
		}
	}

	// o1
	public int removeFirst() {
		if (size == 0) {
			return -1;
		} else if (size == 1) {
			return handleRemoveWhenSizeIs1();
		} else {
			Node oh = head;

			head = head.next;
			size--;

			int temp = oh.data;
			return temp;
		}
	}

	public void addFirst(int data) {
		if (size == 0) {
			handleAddWhenSizeIs0(data);
		} else {
			// space
			Node nn = new Node();

			// dandn
			nn.data = data;
			nn.next = null;

			// connect
			nn.next = head;

			// summaries
			head = nn;
			size++;
		}
	}

	// on
	public void addAt(int data, int idx) {
		if (idx < 0 || idx > size) {
			return;
		} else if (idx == 0) {
			addFirst(data);
		} else if (idx == size) {
			addLast(data);
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			Node n = new Node();
			n.data = data;

			nm1.next = n;
			n.next = np1;
			size++;
		}
	}

	public void rdi() {// Reverse Display Inverse--having complexity of n*n
		int li = 0;
		int ri = size - 1;
		while (li < ri) {
			Node left = getNodeAt(li);
			Node right = getNodeAt(ri);
			int temp = left.data;
			left.data = right.data;
			right.data = temp;
			li++;
			ri--;
		}
	}

	public void rpi() {//// Reverse pointer iterate
		Node p = null;
		Node c = head;
		Node n = c.next;

		while (c != null) {
			c.next = p;
			p = c;
			c = n;
			if (n != null) {
				n = n.next;

			}
		}

		Node temp = head;
		head = tail;
		tail = temp;

	}

	private void display_reverse(Node node) {
		if (node == null) {
			return;
		}
		display_reverse(node.next);
		System.out.print(node.data + " ");
	}

	public void displayReverse() {
		display_reverse(head);

	}

	private void rpr(Node node) {
		if (node == tail) {
			return;
		}
		rpr(node.next);
		node.next.next = node;
	}

	public void rpr() {
		rpr(head);
		Node temp = head;
		head = tail;
		tail = temp;

	}

	private void rdr(Node right, int floor) {
		if (right == null) {
			return;
		}
		rdr(right.next, floor + 1);
		if (floor <= size / 2) {
			int temp = right.data;
			right.data = rdr_left.data;
			rdr_left.data = temp;

		}
		rdr_left = rdr_left.next;
	}

	public void rdr() {
		Node right = head;
		rdr_left = head;
		rdr(right, 0);

	}

	boolean Ispal(Node right) {
		if (right == null) {
			return true;
		}
		boolean rr = Ispal(right.next);
		boolean mr = rr == true && rdr_left.data == right.data;
		rdr_left = rdr_left.next;
		return mr;

	}

	boolean Ispal() {
		Node right = head;
		rdr_left = head;
		return Ispal(right);
	}

	private void fold(Node right, int floor) {
		if (right == null) {
			return;

		}
		fold(right.next, floor + 1);
		if (floor > size / 2) {
			right.next = rdr_left.next;
			rdr_left.next = right;
			rdr_left = right.next;
		}
		if (floor == size / 2) {
			tail = right;
			tail.next = null;
		}

	}

	public void fold() {
		Node right = head;
		rdr_left = head;
		fold(right, 0);
	}

	private void unfold(Node t1) {
		if (t1.next == null) {
			head = tail = t1;
			return;
		} else if (t1.next.next == null) {
			head = t1;
			tail = t1.next;
			return;
		}
		Node t2 = t1.next;
		unfold(t1.next.next);
		t1.next = head;
		head = t1;
		tail.next = t2;
		tail = t2;
		tail.next = null;

	}

	public void unfold() {
		Node t1 = head;
		unfold(t1);
	}

	public void removeduplic() {
		LinkedListCode l2 = new LinkedListCode();
		while (this.size > 0) {
			int temp = this.removeFirst();
			if (l2.size == 0 || l2.tail.data != temp) {
				{
					l2.addLast(temp);
				}
			}

		}
		this.head = l2.head;
		this.head = l2.head;
		this.size = l2.size;

	}

	public void oddeven() {
		LinkedListCode odd = new LinkedListCode();
		LinkedListCode even = new LinkedListCode();
		while (this.size > 0) {
			int temp = this.removeFirst();
			if (temp % 2 == 0) {
				even.addLast(temp);
			}

			else {
				odd.addLast(temp);
			}
		}
		if (odd.size == 0) {
			head = even.head;
			size = even.size;
			tail = even.tail;
		} else if (even.size == 0) {
			head = odd.head;
			size = odd.size;
			tail = odd.tail;
		} else {
			odd.tail.next = even.head;
			this.head = odd.head;
			this.tail = even.tail;
			this.size = odd.size + even.size;
		}
	}

	public void kReversal(int n) {
		LinkedListCode acc = new LinkedListCode();
		while (this.size > 0) {
			LinkedListCode temp = new LinkedListCode();
			for (int i = 0; i < n && size > 0; i++) {
				temp.addFirst(this.removeFirst());
			}
			if (acc.size == 0) {
				acc = temp;
			} else {
				acc.tail.next = temp.head;
				acc.tail = temp.tail;
				acc.size += temp.size;

			}

		}
		this.head = acc.head;
		this.tail = acc.tail;
		this.size = acc.size;

	}

	private Node midNode(Node sp, Node ep) {
		Node slow = sp;
		Node fast = sp;
		while (fast != ep && fast.next != ep) {
			slow = slow.next;
			fast = fast.next.next;

		}

		return slow;

	}

	public int midElement() {
		Node mid = midNode(head, tail);
		return mid.data;
	}

	public int kfromlast(int c) {
		Node slow = head;
		Node fast = head;
		for (int i = 0; i < c; i++) {
			fast = fast.next;
		}
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;

		}
		return slow.data;

	}

	public void mergetwosortedlists(LinkedListCode l1, LinkedListCode l2) {
		Node l1temp = l1.head;
		Node l2temp = l2.head;
		while (l1temp != null && l2temp != null) {
			if (l1temp.data < l2temp.data) {
				this.addLast(l1temp.data);
				l1temp = l1temp.next;

			} else {
				this.addLast(l2temp.data);
				l2temp = l2temp.next;
			}
		}
		while (l1temp != null) {
			this.addLast(l1temp.data);
			l1temp = l1temp.next;
		}
		while (l2temp != null) {
			this.addLast(l2temp.data);
			l2temp = l2temp.next;
		}

	}

	private LinkedListCode mergesort(Node sp, Node ep) {

		if (sp == ep) {
			LinkedListCode br = new LinkedListCode();
			br.addLast(sp.data);
			return br;
		}
		Node mid = midNode(sp, ep);
		LinkedListCode fhshorted = mergesort(sp, mid);
		LinkedListCode shshorted = mergesort(mid.next, ep);
		LinkedListCode msr = new LinkedListCode();
		msr.mergetwosortedlists(fhshorted, shshorted);
		return msr;

	}

	public LinkedListCode mergesort() {
		LinkedListCode l1 = mergesort(this.head, this.tail);
		return l1;
	}
	

	public static void main(String[] args) {
		LinkedListCode l = new LinkedListCode();
		
		// l.addLast(10);
		// l.addLast(20);
		// l.addLast(30);
		// l.addLast(40);
		// l.addLast(50);
		// l.addLast(60);
		// l.addLast(70);
		// l.display(); // 10 20 30
		// l.addFirst(40);
		// l.addFirst(50);
		// l.display(); // 50 40 10 20 30
		// l.addAt(100, 3);
		// l.display(); // 50 40 10 100 20 30
		// l.removeFirst();
		// l.removeFirst();
		// l.display(); // 10 100 20 30
		// l.removeLast();
		// l.display(); // 10 100 20
		// l.addLast(200);
		// l.display(); // 10 100 20 200
		// l.removeAt(2);
		// l.display(); // 10 100 200
		// l.rdi();
		// l.rpi();
		// l.displayReverse();
		// l.rpr();
		// l.rdr();
		// System.out.println(l.Ispal());
		// l.fold();
		// l.display();
		// l.unfold();
		// l.addFirst(-2);
		// l.addLast(98);
		// l.addLast(1);
		// l.addLast(2);
		// l.addLast(3);
		// l.addLast(4);
		// l.addLast(5);
		// l.addLast(6);
		// l.addLast(7);
		// l.addLast(8);

		// l.removeduplic();
		// l.oddeven();
		// l.kReversal(3);
		// l.display();
		// System.out.println(l.midElement());
		// System.out.println(l.kfromlast(2));

		LinkedListCode l1 = new LinkedListCode();
		LinkedListCode l2 = new LinkedListCode();
		LinkedListCode l3 = new LinkedListCode();
		l1.addLast(10);
		l1.addLast(20);
		l1.addLast(30);
		l1.addLast(40);
		l2.addLast(11);
		l2.addLast(22);
		l2.addLast(300);
		l2.addLast(400);
		// l3.mergetwosortedlists(l1, l2);
		//
		// l1.display();
		// l2.display();
		// l3.display();
		l3.addLast(22);
		l3.addLast(13);
		l3.addLast(6);
		l3.addLast(23);
		LinkedListCode l4 = l3.mergesort();
		l4.display();
		l3.display();
			
	}
}
