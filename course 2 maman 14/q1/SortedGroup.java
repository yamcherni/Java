import java.util.ArrayList;
import java.util.Iterator;

public class SortedGroup <T> {
    ArrayList<T> arrayList;

    public SortedGroup (){
        arrayList = new ArrayList<T>();
    }
    public void add(T thing){
        arrayList.add(thing);
        sort();
    }
    public void remove(T thing) {
        T temp = thing;
        for (int i =0; i<arrayList.size();i++)
            if (temp.toString().equals(arrayList.get(i).toString()) ){
                arrayList.remove(i);
                i--;
              }
       }

       public ArrayList<T> getArrayList(){
        return (ArrayList<T>) arrayList.clone();
       }

       public void setArrayList(ArrayList<T> other){
        this.arrayList=other;
       }

    public Iterator<T> interior (){
        return arrayList.iterator();
    }

    private void sort(){
        arrayList.sort(null);
    }
    public int getSize(){
        return arrayList.size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(T s: arrayList)
            str.append(s +"\n");
        return str.toString();
    }

}
