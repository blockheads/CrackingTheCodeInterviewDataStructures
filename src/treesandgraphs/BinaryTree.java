package treesandgraphs;

class BinaryNode<T>{

	BinaryNode<T> left;
	BinaryNode<T> right;

	T value;

	public BinaryNode(T value){
		this.value = value;
	}
}

public class BinaryTree<T extends Comparable<T>>{
	
	private BinaryNode<T> root;
	private int size;

	public BinaryTree(){
		this.root = null;
		this.size = 0;
	}

	public boolean empty(){ return this.size == 0;}

	public void add(T value){
		
		BinaryNode<T> node = new BinaryNode<>(value);
		
		// if this is the first node input into the tree
		if(this.root == null){
			this.root = node;
			return;
		}
	   	this.addRecursive(this.root, node);
	}	
	

	// @current is our recursive current node, @node stores the value
	public BinaryNode<T> addRecursive(BinaryNode<T> current, BinaryNode<T> node){
			
		if(current == null){
			this.size++;
			return node;
		}


		if( node.value.compareTo(current.value) < 0){
			current.left = addRecursive(current.left, node);
		}
		else if(node.value.compareTo(current.value) > 0){
			current.right = addRecursive(current.right, node);
		}
		else{
			return node;
		} 
	
		return current;
	}

	public void delete(T value){	
		this.root = this.deleteRecursive(this.root, value);
	}

	public BinaryNode<T> getMin(BinaryNode<T> node){
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	public BinaryNode<T> deleteRecursive(BinaryNode<T> curr, T value){
	
		if(curr == null)
			return null;
	
		System.out.println("curr value: " + curr.value + " looking for: " + value );
		System.out.println("curr.value.compareTo(value): " + curr.value.compareTo(value));
					
		if(value.compareTo(curr.value) > 0){
			curr.right = deleteRecursive(curr.right, value);
		}
		else if(value.compareTo(curr.value) < 0)
			curr.left = deleteRecursive(curr.left, value);
		else{	
			System.out.println("found match");	
			// no children 
			if(curr.left == null && curr.right == null){
				return null;
			}
			// single right child				
			else if(curr.left == null){
				return curr.right;
			}
			// single left child
			else if(curr.right == null){
				return curr.left;
			}
			// both children
			// get minimum value from the right
			// set that as our new nodes value
			// delete the value we stole from the right
			else{
				BinaryNode<T> min = this.getMin(curr.right);
				curr.value = min.value;
				curr.right = deleteRecursive(curr.right, min.value);
			}
		}
		return curr;
	
	}

	public void inOrder(){
		this.inOrderRecursive(this.root);
	}

	public void inOrderRecursive(BinaryNode<T> node){
		if(node == null)
			return;

		this.inOrderRecursive(node.left);
		System.out.print(node.value + ",");
		this.inOrderRecursive(node.right);
	}

	public void preOrder(){
		this.preOrderRecursive(this.root);
	}

	public void preOrderRecursive(BinaryNode<T> node){
		if(node == null)
			return;


		this.preOrderRecursive(node.left);
		this.preOrderRecursive(node.right);
		System.out.print(node.value + ",");

	}


	public void postOrder(){
		this.postOrderRecursive(this.root);
	}

	public void postOrderRecursive(BinaryNode<T> node){
		if(node == null)
			return;

		System.out.print(node.value + ",");
		this.postOrderRecursive(node.left);
		this.postOrderRecursive(node.right);
		
	}
	
	// recursive method to build the tree output
	public void BuildTreeR(StringBuilder str, BinaryNode<T> node, int depth, int size){
		if(node == null)
			return;		
	
		for(int i=0; i < depth; i++){	
			str.append('|');
		}
	
		str.append(node.value);	

		str.append("\n");
		
		this.BuildTreeR(str, node.left, depth+1, size-1);
		this.BuildTreeR(str, node.right, depth+1, size-1);
	}

	public String toString(){
		StringBuilder str = new StringBuilder();
		this.BuildTreeR(str, this.root, 0, this.size);
		return str.toString();	
	}

	public static void main(String[] args){
		BinaryTree<Integer> tree = new BinaryTree<>();

		// adding elements
		tree.add(10);
		tree.add(5);
		tree.add(7);
		tree.add(12);
		tree.add(13);
		tree.add(4);
		tree.add(25);
		tree.add(8);
		tree.add(6);

		// our tree
		System.out.println(tree);

		// in order
		tree.inOrder();

		System.out.println("\n---\n");
	
		// pre order
		tree.preOrder();

		System.out.println("\n---\n");
		
		// post order
		tree.postOrder();

		System.out.println("\n---\n");

		// deletion
		tree.delete(6);
		
		System.out.println(tree);

		tree.delete(7);

		System.out.println(tree);

		tree.delete(5);
		
		System.out.println(tree);

		tree.delete(10);

		System.out.println(tree);
	}
}
