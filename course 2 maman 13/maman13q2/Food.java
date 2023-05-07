/**@Author Yam Chernichovsky 327484085
 * @version 26.4.2023
 *
 */


public class Food {
    private String discription; //name of the dish
    private int type;           // cattegory
    private double price;
    private int amount=0;
    private boolean ordered = false;

    public Food(String s,int i,double d){ //constructor
        this.discription=s;
        this.type=i;
        this.price=d;
    }
    public String getDiscription(){
        return discription;
    }

    public int getType(){
        return type;
    }     // apetiter- 1, main -2 , desert -3, drink -4;

    public double getPrice(){
        return price*amount;
    }

    public String getPriceString(){
        return price+"";
    } //price as string

    public String toString(){
        return discription+"  "+reOrderType(type)+"  Price: "+price+"  Amount: "+amount+"\n";
    }

    public void setAmount(int i){
        this.amount = i;
    }

    public boolean selected(){
        ordered =!ordered;
        return ordered;
    } //if the user press the selection

    public boolean isOrdered(){
        return ordered;
    } //return if this item selected

    public String reOrderType ( int i){
        if (i == 0)
            return "Apetiter";
        else if (i == 1)
            return "Main";
        else if (i == 2)
            return "Desert";
        else if (i == 3)
            return "Drink";
        else return "";
    } //int to string

    public int getAmount(){
        return amount;
    }

}
