import java.util.Scanner;
public class Einstein
{
    public static void main(String[]args)
    {
        Scanner scan = new Scanner (System.in);
        int num,dig1,dig2,dig3;
        final int FINAL_NUM = 1089;
        System.out.println ("Welcome to the Einstein magic game");
        System.out.println ("Please enter a 3 digit positive number whose first and last digits are different:");
        
        num = scan.nextInt();
        dig1 = num/100;
        dig2 = ((num-dig1*100)/10);
        dig3 = ((num-dig1*100)%10);
        
        if (num>=999||num<=99)
        System.out.println("The number you entered is not a 3 digit positive number");
        else
        if (dig1==dig3)
        System.out.println("The first and the last digits of the number should be different");
        else
        System.out.println("User number is: "+num);
        
        int revNum = ((dig3*100)+(dig2*10)+(dig1));
        int difference = Math.abs(num-revNum);
        System.out.println("Difference: "+difference);
        
        num = difference;
        dig1 = num/100;
        dig2 = ((num-dig1*100)/10);
        dig3 = ((num-dig1*100)%10);
        revNum = ((dig3*100)+(dig2*10)+(dig1));
        
        System.out.println("Reversed difference: "+revNum);
        if ((difference+revNum)==FINAL_NUM)
        System.out.println("SUCCEEDED");
        else System.out.println("FAILED");
        
        
    }
}
