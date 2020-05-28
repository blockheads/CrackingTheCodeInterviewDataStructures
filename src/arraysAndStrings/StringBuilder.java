package arraysAndStrings;

/**
 * String builder concatenates strings
 */
public class StringBuilder {

    private ArrayList<String> list;

    public StringBuilder(){
        list = new ArrayList<>();
    }

    public StringBuilder append(Object word){
        list.add(word.toString());
        return this;
    }

    public void insert(int index, String word){
        list.add(index, word);
    }

    public String toString(){
        String ret = "";
        for(int i=0; i <  list.size(); i++){
            ret += list.get(i);
        }

        return ret;
    }

    public static void main(String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hello ");
        stringBuilder.append("world");

        System.out.println(stringBuilder);
    }
}
