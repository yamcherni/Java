public class SmokeAlarm extends Alarm {

    String wname;

    public SmokeAlarm(String address, String name) {
        super(address);
        try {
            wname=name;
           if (name==null)
                throw new BadAlarmException("You must insert a name");
        }
        catch (BadAlarmException e) {
            System.out.println("A problem occured: " + e.getMessage());
        }
    }
    @Override
    public void action() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString()+"\t\tName : "+wname;
    }
}