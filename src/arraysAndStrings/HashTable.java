package arraysAndStrings;


class Node<K,V>{

    K key;
    V value;
    // store's a reference to the next node
    Node<K,V> next;

    Node(K key, V value){
        this.key = key;
        this.value = value;
    }

}

public class HashTable<K,V> {

    private ArrayList<Node<K,V>> hashes;
    private int size;

    private static final int INIT_SIZE = 10;

    public HashTable(){
        this.hashes = new ArrayList<>();

        for(int i = 0; i < INIT_SIZE; i++){
            this.hashes.add(null);
        }

        this.size = 0;
    }

    public boolean empty(){ return this.size == 0;}
    public int size(){return this.size;}

    public void put(K key, V value){

        // resize
        if((1.0*this.size) / hashes.size() > .7){

            this.size=0;
            ArrayList<Node<K,V>> temp = this.hashes;
            this.hashes = new ArrayList<>();
            // double our bucket size
            for(int i = 0; i < temp.size()*2; i++){
                this.hashes.add(null);
            }

            // store previous values back in
            for(int i =0; i<temp.size(); i++){
                Node<K,V> node = temp.get(i);
                // have to make sure we include bucketed value
                while(node != null){
                    this.put(node.key, node.value);
                    node = node.next;
                }

            }
        }

        // construct our node
        Node<K,V> node = new Node<K,V>(key, value);

        int index = hash(key);

        if(this.hashes.get(index) != null){

            Node<K,V> curr = this.hashes.get(index);

            while(curr != null){

                if(curr.key.equals(key)){
                    // replace
                    curr.value = value;
                    return;
                }

                curr = curr.next;
            }

        }

        // set our next to the current head
        node.next = this.hashes.get(index);

        this.hashes.set(index, node);

        this.size++;

    }

    public V remove(K key){

        int index = hash(key);

        Node<K,V> node = this.hashes.get(index);
        Node<K,V> previous = null;

        while(node != null) {

            // we find the node that matches
            if (key.equals(node.key)) {
                break;
            }

            previous = node;
            node = node.next;
        }

        // now that we have the node and the previous we can easily remove it
        if(node == null)
            return null;

        if(previous != null){
            previous.next = node.next;
        }
        else{
            this.hashes.set(index, node.next);
        }

        return  node.value;
    }

    public Node<K,V> get(K key) {
        int index = hash(key);

        if (this.hashes.get(index) != null) {

            Node<K, V> node = this.hashes.get(index);

            while (node != null) {

                if (key.equals(node.key)) {
                    return node;
                }

                node = node.next;
            }
        }

        return null;
    }

    public boolean has(K key) {
        return this.get(key) != null;
    }

    // custom toString for output
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("{\n");
        for(int i=0; i < this.hashes.size(); i++){
            Node<K,V> node = this.hashes.get(i);
            if(node != null)
                str.append(node.key).append(": ").append(node.value).append("\n");
        }
        str.append("}\n");

        return str.toString();
    }

    private int hash(K key){
        // hash key
        return Math.abs(key.hashCode() % this.hashes.size());
    }


    public static void main(String args[]){

        HashTable<String, Integer> map = new HashTable<>();
        map.put("hello world", 1);

        System.out.println(map.get("hello world").value);
        System.out.println(map);

        map.put("hello world", 3);

        System.out.println(map.get("hello world").value);
        System.out.println(map);

        map.put("pretty cool", 5);

        System.out.println(map);

        for(int i = 'a'; i < 'z'; i++){
            System.out.println("i: " + i);
            map.put("" + i, 30);
        }

        System.out.println(map);

        // removal

        for(int i = 'a'; i < 'z'; i++){

            System.out.println("i: " + map.get("" + i).value);
            map.remove("" + i);
            if(map.has("" + i)){
                System.out.println("still has i: " + "" + i);
            }
            else{
                System.out.println("removed: " + i);
            }


        }

        System.out.println(map);

    }
}
