package linkedlists;

import arraysandstrings.StringBuilder;

import java.util.LinkedList;

class Node<T>{

    private T value;
    Node<T> next;

    public Node(T value){
        this.value = value;
    }

    public T getValue(){return value;}

}

public class SinglyLinkedList<T> {

    private Node<T> head;

    public SinglyLinkedList(){
        this.head = null;
    }

    // appends a node to the linked list
    public void prepend(T value){

        Node<T> node = new Node<>(value);

        if(this.head != null)
            node.next = this.head;

        this.head = node;
    }

    // appends a node to the tail of the list
    public void append(T value){

        Node<T> curr = this.head;
        Node<T> prev = null;
        while(curr != null){

            prev = curr;
            curr = curr.next;
        }

        if(prev != null){
            prev.next = new Node<>(value);
        }
        else{
            this.head = new Node<>(value);
        }

    }

    // get's a node
    private Node<T> get(T value){
        Node<T> curr = head;

        while(curr != null){
            if(curr.getValue().equals(value))
                return curr;

            curr = curr.next;
        }

        return null;
    }

    public String toString(){

        Node<T> curr = head;
        StringBuilder stringBuilder = new StringBuilder();
        while(curr != null){
            stringBuilder.append(curr.getValue()).append("->");
            curr = curr.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }

    public static void main(String[] args){

        SinglyLinkedList<Character> l = new SinglyLinkedList<>();

        for(char i='a'; i < 'f'; i++){
            l.append(i);
        }

        System.out.println(l);

        // append f to the front
        l.prepend('f');

        System.out.println(l);

        // get d

        System.out.println(l.get('d').getValue());
    }
}
