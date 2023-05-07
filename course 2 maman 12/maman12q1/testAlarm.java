/**
 * @Author Yam chernichovski
 * @Version 4.7
 * Maman 11, Question 1
 */
import java.util.ArrayList;

public class testAlarm {

    public static void main(String[] args){

        Alarm a = new SmokeAlarm("Tavor","Beni");
        Alarm b = new SmokeAlarm("Karmel","Avner");
        Alarm c = new FireAlarm("Shomron",null);
        Alarm d = new ElevatorAlarm("Shaked",5);
        Alarm e = new FireAlarm("Aliya","Moshe");
        Alarm f = new FireAlarm("Tavor","beni");
        Alarm g = new ElevatorAlarm("Shomron",1);
        Alarm h = new ElevatorAlarm("Aliya",5);

        ArrayList<Alarm> alarms = new ArrayList<>();

        alarms.add(a);
        alarms.add(b);
        alarms.add(c);
        alarms.add(d);
        alarms.add(e);
        alarms.add(f);
        alarms.add(g);
        alarms.add(h);

        process(alarms);
    }

    public static void process(ArrayList<Alarm> arr){
        int count = 0;
        for(Alarm a : arr){
            a.action();
            if (a instanceof SmokeAlarm && !(a instanceof FireAlarm ))
                count++;
            else if (a instanceof ElevatorAlarm)
                ((ElevatorAlarm) a).reset();
        }
        System.out.println("The number of smoke alarms is:" + count);
    }
}
