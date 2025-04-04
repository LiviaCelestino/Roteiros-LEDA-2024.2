package adt.linkedList;

public class RecursiveDoubleLinkedListImpl<T> extends
		RecursiveSingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected RecursiveDoubleLinkedListImpl<T> previous;

	public RecursiveDoubleLinkedListImpl() {

	}

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (this.isEmpty()) {
				this.insert(element);
			} else {
				RecursiveDoubleLinkedListImpl<T> newNode = new RecursiveDoubleLinkedListImpl<>();

				newNode.setData(this.data);
				this.data = element;
				newNode.setNext(this.next);
				this.next = newNode;
				newNode.setPrevious(this);
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(newNode);
			}
		}
	}

	@Override
	public void removeFirst() {
		if (!this.isEmpty()) {
			if (this.previous.isEmpty() && this.next.isEmpty()) {
				this.data = null;
				this.next = null;
				this.previous = null;
			} else {
				this.data = this.next.getData();
				this.next = this.next.getNext();
				((RecursiveDoubleLinkedListImpl<T>) this.next).setPrevious(this);
			}
		}
	}

	@Override
	public void removeLast() {
		if (!this.isEmpty()) {
			if (this.next.isEmpty()) {
				this.data = null;
				this.next = null;

				if (this.previous.isEmpty()) {
					this.previous = null;
				}

			} else {
				((RecursiveDoubleLinkedListImpl<T>) this.next).removeLast();
			}
		}
	}

	public RecursiveDoubleLinkedListImpl<T> getPrevious() {
		return previous;
	}

	public void setPrevious(RecursiveDoubleLinkedListImpl<T> previous) {
		this.previous = previous;
	}

}
