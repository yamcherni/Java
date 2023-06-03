/**
 * @Author Yam Chernichovski
 * @Version 1
 */

public class Monitor {
    private int count=0;

    public Monitor(){

    }

    public synchronized void waitForMyTurn(int num){
        while (count<num) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void updateCount(){
        count ++;
        notifyAll();
    }
}
