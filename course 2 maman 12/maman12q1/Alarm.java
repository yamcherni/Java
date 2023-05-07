import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class Alarm {
    String address;
    String time;

    public Alarm(String address){
        this.address=address;
        time=new SimpleDateFormat("HH:mm").
                format(Calendar.getInstance().getTime ());
    }
    public void action(){}

    public String toString() {
       return "Time : "+ time +"\t\tAddress : "+ this.address;
    }
}
