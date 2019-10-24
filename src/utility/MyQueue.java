package utility;

import java.util.NoSuchElementException;

public class MyQueue<T> {

	private static class QueueNode<T> {
		
		public T data;
		public QueueNode<T> next;

		public QueueNode(T data) {
			this.data = data;
		}

	}

	private QueueNode<T> first;
	private QueueNode<T> last;

	public void add(T data) {
		QueueNode<T> newNode = new QueueNode<T>(data);
		if (first == null) {
			first = newNode;
			last = newNode;
		}
		if (last != null) {
			last.next = newNode;
		}
	}

	public T remove() {
		if (last == null) {
			throw new NoSuchElementException();
		}
		T data = first.data;
		first = first.next;
		if (first == null) {
			last = null;
		}
		return data;
	}

	public T peek() {
		if (first == null) {
			throw new NoSuchElementException();
		}
		return first.data;
	}

	public boolean isEmpty() {
		return first == null;
	}
}
