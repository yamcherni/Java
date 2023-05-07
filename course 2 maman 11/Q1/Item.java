public class Item {
    private String name;
    private double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

    /**
     private String name;
     private double price;
     public Item(String n,double p) {
        name=n;
        price=p;
    }
    public double getPrice(){
         return this.price;
    }
    public String getName(){
         return this.name;
    }
    public String toString(){
         return name+" "+price;
    }

    }
**/