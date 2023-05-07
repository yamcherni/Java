import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Item apple = new Item("apple", 10);
        Item banana = new Item("banana", 11);
        Item mouse = new Item("mouse", 12);
        Item pen = new Item("pen", 5);
        Item paper = new Item("paper", 3);
        Item iphone = new Item("iphone", 200);
        Item iarr[]={apple,banana,mouse,pen,paper,iphone};
        Scanner scan = new Scanner(System.in);

        System.out.println("Hello,enter the amount of money in the cass ");
        int choice = scan.nextInt();
        scan.nextLine();
        CashRegister c = new CashRegister(choice);

        int choice3 =0;
        System.out.println("MENU:\nregister item -1 \nshow the registered items -2\nget current total -3\nrevice payment -4");
        System.out.println("see the amount of money in the cass -5\nshow items lyst-6\nexit -7\n");
        while (choice3!=7) {
            System.out.println("Select item from the menu");
            choice3 = scan.nextInt();
            scan.nextLine();
            switch (choice3) {
                case 1:
                    System.out.println("Enter the item id");
                    int itemId = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Enter the amount");
                    int am = scan.nextInt();
                    scan.nextLine();
                    c.addItem(iarr[itemId], am);
                    break;
                case 2:
                    System.out.println(c.getCurrentPurchase());
                    break;
                case 3:
                    System.out.println(c.getCurrentPurchaseTotal());
                    break;
                case 4:
                    System.out.println("Enter the emount of money to recive");
                    double recive = scan.nextDouble();
                    scan.nextLine();
                    c.receivePayment(recive);
                    break;
                case 5:
                    System.out.println(c.getCashTotal());
                    break;
                case 6:
                    System.out.println("apple-0 ,banana -1,mouse -2,pen -3,paper -4,iphone -5");
                    break;
                case 7:
                    System.exit(0);
            }
            }
        }
    }

