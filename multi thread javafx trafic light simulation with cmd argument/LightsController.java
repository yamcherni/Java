/**
 * @Author Yam Chernichovski
 * @Version 1
 */

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;


public class LightsController extends  Thread{

    @FXML
    private Canvas canv;
    private GraphicsContext gc;
    TL u,s;
    Monitor m;
    boolean UP = true;
    int TIME;

    public void initData(String args){
        TIME = Integer.parseInt(args);
    }

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        m = new Monitor(gc);
        u=new TL(UP,m); //create upper and lower trafic lights
        s=new TL(!UP,m); //create side trafic lights
        start();
        u.start();
        s.start();
    }

    public void run() {
        super.run();
        while(true){
            m.changeState(); //changing the lights from dsrive to not drive
            gc.clearRect(0,0,gc.getCanvas().getWidth(),gc.getCanvas().getHeight());
            try {
                sleep(TIME);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

