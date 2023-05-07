
public class FireAlarm extends SmokeAlarm{

    boolean active;

    public FireAlarm(String address,String name) {
        super(address,name);
        active=true;
    }

    @Override
    public void action() {
        active=false;
        System.out.println(super.toString());
    }
}
