package linkedlists;

import arraysandstrings.StringBuilder;

import java.util.LinkedList;

class DLNode<T>{

    private T value;
    DLNode<T> next;
    DLNode<T> prev;

    public DLNode(T value){
        this.value = value;
    }

    public T getValue(){return value;}

}

public class DoublyLinkedList<T> {

    private DLNode<T> head;  
	private DLNode<T> tail;  

    public DoublyLinkedList(){
        this.head = null;
    }

    // appends a node to the linked list
    public void prepend(T value){

        DLNode<T> node = new DLNode<>(value);

        if(this.head != null){
            node.next = this.head;
            this.head.prev = node;
        }
		this.head = node;
		
		// error handle case where only append
		if(tail == null)
			this.tail = node;		


    }

    // appends a node to the tail of the list
    public void append(T value){

		DLNode node = new DLNode<>(value);

		if(this.tail != null){
			this.tail.next = node;
			node.prev = this.tail;
		}
				this.tail = node;

		// error handle case where only append
		if(head == null)
			this.head = node;		

    }

    // get's a value at a index
    private T get(int index){
        
		DLNode<T> curr = head;
		int i = 0;		

        while(curr != null){
            if(i == index)
                return curr.getValue();

            curr = curr.next;
			i++;
        }

        return null;
    }
	
	// get's the head
	public DLNode<T> getHead(){
		return this.head;
	}

	// get's the tail
	public DLNode<T> getTail(){
		return this.tail;
	}

    // deletes a specific value from the linked list
    public boolean delete(T value){
        DLNode<T> curr = head;
        DLNode<T> prev = null;

        while(curr != null){

            if(curr.getValue().equals(value) && prev != null){
                prev.next = curr.next;
            }

            prev = curr;
            curr = curr.next;
        }

        return false;
    }

    public String toString(){

        DLNode<T> curr = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(curr != null){
            stringBuilder.append(curr.getValue()).append("<->");
            curr = curr.next;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){

        DoublyLinkedList<Character> l = new DoublyLinkedList<>();

        for(char i='a'; i < 'f'; i++){
            l.append(i);
        }

        System.out.println(l);

        // append f to the front
        l.prepend('f');

        System.out.println(l);

        // get d

        System.out.println(l.get(3));
		
		// get head
		System.out.println(l.getHead().getValue());

		// tail
		System.out.println(l.getTail().getValue());

        // delete c

        l.delete('c');

        System.out.println(l);
    }
}
