/**@Author Yam Chernichovsky 327484085
 * @version 26.4.2023
 *The menue represented by array at size 4 where eatch one of 4 is dinamic array that corespond to spesific food type.
 * apetiter- 0, main -1 , desert -2, drink -3
 */


import java.util.ArrayList;

public class Menue {
    ArrayList<Food>[] arr= new ArrayList[4];

    public Menue() {
        for (int i = 0; i < 4; i++)
            arr[i] = new ArrayList<Food>();
    }

    public void addToMenue(Food f) {
        int type = f.getType();
        arr[type - 1].add(f);
    }

    public double getTotalPrice() { //calculate the total price of selected items
        double total = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                if(arr[i].get(j).isOrdered())
                    total += arr[i].get(j).getPrice();
            }
        }
        return total;
    }

    public String toString() {
        String s="";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                String temp = arr[i].get(j).toString();
                s = s.concat(temp);

            }
        }
        return s;
    }

    public String toStringSelected() { //return only selectred items
        String s="";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr[i].size(); j++) {
                if(arr[i].get(j).isOrdered() && arr[i].get(j).getAmount()>0) {
                    String temp = arr[i].get(j).toString();
                    s = s.concat(temp);
                }
            }
        }
        return s;
    }

    public ArrayList<Food> getArr(int i){
        return arr[i];
    }

}