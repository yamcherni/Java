/**
 * @Author Yam chernichovski
 * @Version 4.7
 * Maman 12, Question 2, b
 */

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        boolean exit = false;
        System.out.println("First set tow numbers, from now on they will be called a and b.");
        while (!exit) {  //the main loop
            boolean flag = true;
            Scanner scan = new Scanner(System.in);
            BigInt a = null, b = null;
            System.out.println("Set a:");
            while (flag) { //try until get valid number
                flag = false;
                try {
                    String str1 = scan.nextLine();
                    a = new BigInt(str1);
                } catch (Exception e) {
                    flag = true;
                    System.out.println(e.getMessage());
                    System.out.println("Try again");
                }
            }
            flag = true;
            System.out.println("Set b:"); //try until get valid number
            while (flag) {
                flag = false;
                try {
                    String str2 = scan.nextLine();
                    b = new BigInt(str2);
                } catch (Exception e) {
                    flag = true;
                    System.out.println(e.getMessage());
                    System.out.println("Try again");
                }
            }
            System.out.println("Now you can add, substract, multiply and divide by writing number and operator Example: (a+b)");
            System.out.println("Plus : + \tMinus : - \tMultiply : *\tDivide : /");

            String op = scan.nextLine();
            switch (op.charAt(0)) { //switch that handles the options
                case 'a' -> {
                    switch (op.charAt(1)) {
                        case '+' -> a.plus(b).print();
                        case '-' -> a.minus(b).print();
                        case '*' -> a.multiply(b).print();
                        case '/' -> {
                            try {
                                a.divide(b).print();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
                case 'b' -> {
                    switch (op.charAt(1)) {
                        case '+' -> b.plus(a).print();
                        case '-' -> b.minus(a).print();
                        case '*' -> b.multiply(a).print();
                        case '/' -> {
                            try {
                                b.divide(a).print();
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                }
            }
            System.out.println();
            System.out.println("To exit press : 1, to restart any key.");
            String exits = scan.nextLine();
            if (exits.equals("1"))
                exit = true;

        }
    }
}

