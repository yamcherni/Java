/*
 * user enter a number of mili seconds and the program output the amount of days,
 * hours,minuts and seconds that this number represent.
 * 1 milli second = 1/1000 second 
 */
import java.util.Scanner;
public class Milliseconds
{ public static void main(String[]args)
    {
        float miliSec;
        int days,hours,minuts,sec;
        final float MILI_SEC_TO_SEC = (1000);
        final float MILI_SEC_TO_MINUTS = (1000*60);
        final float MILI_SEC_TO_HOURS = (1000*60*60);
        final float MILI_SEC_TO_DAYS = (1000*60*60*24);    
        Scanner scan = new Scanner (System.in);

        System.out.println ("This program reads an integer which " +
            "represents Milliseconds and converts it to days, " +
            "hours, minutes and seconds. ");
        System.out.println ("Please enter the number of Milliseconds");
        miliSec = scan.nextLong();

        days = (int)(miliSec/MILI_SEC_TO_DAYS);
        miliSec = (miliSec-(days*MILI_SEC_TO_DAYS)); //update the milliseconds every round (mili sec at start - mili sec used for the int).

        hours = (int)(miliSec/MILI_SEC_TO_HOURS);   
        miliSec = (miliSec-(hours*MILI_SEC_TO_HOURS));

        minuts = (int)(miliSec/MILI_SEC_TO_MINUTS);
        miliSec = (miliSec-(minuts*MILI_SEC_TO_MINUTS));

        sec = (int)(miliSec/MILI_SEC_TO_SEC);

        System.out.println(days+" days "+hours+":"+minuts+":"+sec+" hours");
    }
}