package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			DoubleLinkedListNode<T> newHeadNode = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<T>(),
					new DoubleLinkedListNode<T>());
			newHeadNode.setNext(head);
			((DoubleLinkedListNode<T>) head).setPrevious(newHeadNode);

			if (head.isNIL()) {
				this.setLast(newHeadNode);
			}
			this.setHead(newHeadNode);
		}
	}

	@Override
	public void removeFirst() {
		if (!this.getHead().isNIL()) {
			this.setHead(this.getHead().getNext());

			if (this.getHead().isNIL()) {
				this.setLast((DoubleLinkedListNode<T>) this.getHead());
			}

			((DoubleLinkedListNode<T>) this.getHead()).setPrevious(new DoubleLinkedListNode<>());
		}
	}

	@Override
	public void removeLast() {
		if (!this.last.isNIL()) {
			this.last = this.last.getPrevious();

			if (this.last.isNIL()) {
				this.head = this.last;
			}
			this.last.setNext(new DoubleLinkedListNode<T>());
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
