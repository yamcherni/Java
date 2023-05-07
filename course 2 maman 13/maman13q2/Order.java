
/**@Author Yam Chernichovsky 327484085
 * @version 26.4.2023
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Order {
    Menue m;
    public Order() { //constractor that reads from text file and initialize food and menue
        m = new Menue();
        try {
            File file = new File("menu.txt");
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String p1 = scan.nextLine();
                int p2 = orderType(scan.nextLine());
                double p3 = scan.nextDouble();
                String p4 = scan.nextLine();
                if (p2 == -1)
                    System.out.println("Eror: not valid food type");
                else
                    m.addToMenue(new Food(p1, p2, p3));
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        }
    }

    public int orderType(String input) { //string to int
        if (input.equals("Apetiter"))
            return 1;
        else if (input.equals("Main"))
            return 2;
        else if (input.equals("Desert"))
            return 3;
        else if (input.equals("Drink"))
            return 4;
        else return -1;
    }

    public ArrayList<Food> getType(int i){
            return this.m.getArr(i);
}

}
