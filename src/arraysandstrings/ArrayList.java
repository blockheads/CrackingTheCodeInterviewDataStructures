package arraysandstrings;

/**
 * Implementing my own array-list
 */
public class ArrayList<E> {

    private int size;
    // underlying array we use to store values
    private Object[] store;

    public ArrayList(){
        this.size = 0;
        // base array list size
        int INITIAL_SIZE = 10;
        this.store = new Object[INITIAL_SIZE];
    }

    private void tryResize(){
        if(shouldResize()){

            Object[] temp = this.store;
            int oldSize = this.size;

            this.size = 0;
            this.store = new Object[temp.length * 2];

            // add back in our previous elements
            for(int i = 0; i < oldSize; i ++){
                this.add((E) temp[i]);
            }

        }
    }

    public boolean empty(){
        return this.size == 0;
    }

    public int size(){
        return this.size;
    }

    // add's a element
    public void add(E element){

        tryResize();

        this.store[this.size] = element;

        this.size++;
    }

    // add's a element at a index
    public void add(int index, E element){

        tryResize();

        // move everything over to the right
        E prev = (E) this.store[index];

        for(int i = index + 1; i < this.store.length - 1; i++){
            // break out cause we don't need to shift over 1
            if(this.store[i] == null)
                break;

            prev = (E)this.store[i];
            this.store[i] = prev;
        }

        this.store[index] = element;

        this.size ++;
    }

    // retrives element at a index
    public E get(int index){
        return (E) this.store[index];
    }

    // retrives indexOf a element
    public int indexOf(E element){
        for(int i=0; i < this.store.length; i++){
            if(this.get(i).equals(element)){
                return i;
            }
        }
        // -1 if doesn't have
        return -1;
    }

    public void remove(int index){

        if(this.store[index] == null)
            return;

        this.store[index] = null;
        // shift everything in front back
        for(int i = index + 1; i < this.store.length; i++){
            this.store[i-1] = this.store[i];
        }
        this.size --;
    }

    public boolean remove(E element){
        // util function to remove
        int index = this.indexOf(element);
        if(index != -1){
            this.remove(index);
            return true;
        }
        return false;
    }

    private boolean shouldResize(){
        return size == store.length;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("[");

        for(int i = 0; i < this.store.length; i++){
            //if(this.store[i] != null)
                str.append(this.store[i]).append(", ");
        }
        str.append("]");
        return str.toString();
    }

    public void set(int index, E element){
        this.store[index] = element;
    }

    public static void main(String[] args){

        ArrayList<String> strs = new ArrayList<>();

        strs.add("hello");
        strs.add("world");
        System.out.println(strs);

        // removal
        strs.remove(0);
        System.out.println(strs);
        strs.remove(1);
        System.out.println(strs);
        strs.remove("world");
        System.out.println(strs);

        System.out.println("new size: " + strs.size());
        System.out.println("resizing tests....");

        for(char i='a' ; i <= 'z'; i++){
            System.out.println("i: " + i);
            strs.add("" + i);
        }

        System.out.println(strs);

        for(char i='a' ; i <= 'z'; i++){
            strs.remove("" + i);
        }

        System.out.println(strs);

        // custom index insertion
        strs.add("hello");

        strs.add("rut-roh-raggy");

        strs.add("something isn't");

        strs.add("quite right");

        strs.add("oh no");

        strs.add(1,"world");

        System.out.println(strs);
    }
}
