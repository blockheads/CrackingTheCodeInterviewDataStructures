package treesandgraphs;
import java.util.ArrayList;

public class Heap<T extends Comparable<T>>{

	private ArrayList<T> nodes;
	private int size;	

	public Heap(){
		this.nodes = new ArrayList<>();
		// we add a element at 0, this causes use to shift over 1 so
 		// the math stays consitent
		this.nodes.add(null);
	}

	public void add(T value){
		this.nodes.add(value);
		this.size++;
		this.heapifyUp();

	}

	private void heapifyUp(){
		int curr = this.size;
		int parent = curr/2;
		while(parent > 0 && this.nodes.get(curr).compareTo(this.nodes.get(parent)) < 0 ){
			// swap
			System.out.println("swapping: " + this.nodes.get(curr) + " with: " + this.nodes.get(parent));
			T temp = this.nodes.get(parent);
			this.nodes.set(parent, nodes.get(curr));
			this.nodes.set(curr, temp);
			curr = parent;
			parent = curr/2;
		}
	}

	public int size(){return this.size;}

	public void buildString(StringBuilder str, int curr, int depth){
		if(curr > this.size)
			return;

		for(int i=0; i < depth; i++){
			str.append("|");
		}
		str.append(nodes.get(curr)).append("\n");
		buildString(str, curr*2, depth+1);
		buildString(str, (curr*2)+1, depth+1);
	}

	// building string w/ post order morris traversal
/*	public String buildStringI(){
		StringBuilder str = new StringBuilder();
		

		if(this.size == 0)
			return;
		
		int curr = 0;
		int prev = -1;
		ArrayList<T> newList = this.nodes.copy();

		while(curr <= this.size){
			
			// left is null
			if(curr*2 > this.size){
				str.append(this.nodes.get(curr));
				
			}
			else{

			}
		}	

		return str.toString();
	}
*/
	public String toString(){
		System.out.println("underlying array");
		System.out.print("[");
		for(int i=1; i <= this.size; i++){
			System.out.print(" " + this.nodes.get(i));
		}
		System.out.println("]");
		StringBuilder str = new StringBuilder();
		buildString(str, 1, 0);
		return str.toString();
	}

	public static void main(String[] args){
		Heap<Integer> heap = new Heap<>();
		heap.add(50);
		heap.add(30);
		heap.add(70);
		heap.add(10);
		heap.add(90);
		heap.add(25);
		heap.add(200);
		heap.add(60);
		heap.add(40);
		heap.add(5);
		System.out.println(heap);
	}
}
