/**
 * @Author Yam Chernichovski
 * @Version 1
 */

import javafx.scene.canvas.GraphicsContext;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Monitor {

    GraphicsContext gc;
    private Lock lock = new ReentrantLock();
    private boolean state = true;


    public Monitor(GraphicsContext gc) {
        this.gc=gc;
    }
    public  void changeState(){
        state = !state;
    }
    public  boolean getState(){
        return state;
    }


    public GraphicsContext getGc(){
        lock.lock();
        return gc;
    }
    public void unlockGc(){
        lock.unlock();
    }
}
