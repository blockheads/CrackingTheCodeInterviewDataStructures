package stacksandqueues;

class QueueNode<T>{

	QueueNode<T> next;
	T value;

	public QueueNode(T value){
		this.value = value;	
	}

}

public class Queue<T>{
	
	QueueNode<T> head;
	QueueNode<T> tail;
	private int size;
	
	public Queue(){
		this.head = null;
		this.tail = null;
		this.size = 0;
	}

	// adds value on to tail
	public void add(T value){
		
		QueueNode<T> node = new QueueNode<>(value);

		if(this.tail != null)
			this.tail.next = node;
	
		if(this.head == null)
			this.head = node;

		this.tail = node;
	
		this.size++;
	}

	public boolean empty(){return this.size == 0;}

	// removes first value of queue
	public T remove(){
		
		if(this.empty())
			return null;
				
		QueueNode<T> temp = this.head;
		this.head = this.head.next;

		return temp.value;
	}

	public T peek(){
		return this.head.value;
	}


	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("[");
		QueueNode<T> node = this.head;
		
		while(node != null){
			str.append(node.value).append(", ");
			
			node = node.next;
		}
		str.append("]");

		return str.toString();
	}

	public static void main(String[] args){
		
		Queue<Integer> queue = new Queue<>();

		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(500);
		queue.add(4);

		System.out.println(queue);
		System.out.println("head " + queue.peek());

		// popping values
		for(int i =0; i < 5; i++){
			System.out.println("popped: " + queue.remove() );
		}

		System.out.println(queue);
	}

}
