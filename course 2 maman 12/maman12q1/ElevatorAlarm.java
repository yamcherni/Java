
public class ElevatorAlarm extends Alarm {
    private int floor;

    public ElevatorAlarm(String address,int floor) {
        super(address);
        this.floor=floor;
    }
    public void reset(){
        this.floor=0;
    }
    @Override
    public void action() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString()+"\t\tFloor : "+floor;
    }
}
