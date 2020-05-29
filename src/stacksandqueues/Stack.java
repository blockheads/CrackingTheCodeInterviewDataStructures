package stacksandqueues;

class StackNode<T>{
	
	T value;
	StackNode<T> next;

	public StackNode(T value){
		this.value = value;
	}

}

public class Stack<T>{

	private StackNode<T> head;
	private int size;

	public Stack(){
		this.head = null;
		this.size = 0;
	}

	public boolean empty(){
		return this.size == 0;
	}

	public int size(){ return this.size;}

	public T pop(){
		if(this.empty())
			return null;
		
		StackNode<T> temp = this.head;	
		
		this.head = this.head.next;
		
		this.size--;
		return temp.value;
	}

	public void push(T value){
		StackNode<T> node = new StackNode(value);

		node.next = this.head;
		this.head = node;

		this.size++;
	}	

	public T peek(){
		return this.head.value;
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		str.append("[");
		StackNode<T> node = this.head;
		
		while(node != null){
			str.append(node.value).append(", ");
			
			node = node.next;
		}
		str.append("]");

		return str.toString();
	}

	public static void main(String[] args){
		
		Stack<Integer> stack = new Stack<>();

		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(500);
		stack.push(4);

		System.out.println(stack);
		System.out.println("head " + stack.peek());

		// popping values
		for(int i =0; i < 5; i++){
			System.out.println("popped: " + stack.pop() );
		}

		System.out.println(stack);
	}
}
