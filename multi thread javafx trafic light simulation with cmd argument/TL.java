/**
 * @Author Yam Chernichovski
 * @Version 1
 */

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class TL extends Thread {
    private boolean up,drive;
    private Monitor m;
    double canvW,canvH;
    int xpos1,xpos2,ypos1,ypos2;
    int CONST = 20;
    boolean lastState=true;
    boolean blinkON;

    public TL(boolean up,Monitor m) {
        this.up = up;
        this.m=m;
        if (up)  //upper and lower trafic lights start in no drive mode (car light is red)
            this.drive=false;
        else
            this.drive=true;
        setMyLocation();
    }



    public void run() { //evry 200 ms check for update
        super.run();
        while (true) {
            if(m.getState() == !lastState) {
                drive = !drive;
                lastState = !lastState;
                 draw(m.getGc());
                 try{}finally {m.unlockGc();}
            }
            if (!drive){
                blink(m.getGc());
                try{} finally {m.unlockGc();}
            }
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



    public void blink(GraphicsContext gc){
        if (blinkON) {
            gc.setFill(Color.GREEN);
            gc.fillRect(xpos2, ypos2 + 3 * CONST, CONST, CONST);
            gc.fillRect(xpos1, ypos1 + 3 * CONST, CONST, CONST);
        }
        else {
            gc.clearRect(xpos2, ypos2 + 3 * CONST, CONST, CONST);
            gc.clearRect(xpos1, ypos1 + 3 * CONST, CONST, CONST);
        }
        blinkON= !blinkON;
    }

    public void setMyLocation(){ //set the trafic lights location in the canvas based on UP
        canvW = m.getGc().getCanvas().getWidth();
        m.unlockGc();
        canvH = m.getGc().getCanvas().getHeight();
        m.unlockGc();
        if (up) {
            xpos1 =  xpos2 = (int) (canvW/2);
            ypos1 =   CONST;
            ypos2 = (int) (canvH-5*CONST);
        }
        else {
            xpos1 = 2*CONST;
            xpos2 = (int) (canvW-2*CONST);
            ypos1 = ypos2 = (int) (canvH/2+CONST);
        }

    }

    public void draw(GraphicsContext gc) { //daw 2 trafic liights
        if(!drive) { //the lights are in not drive mode (the car light is red)
            Platform.runLater(() ->{
                gc.setFill(Color.RED);
                gc.fillOval(xpos1, ypos1, CONST, CONST);
                gc.strokeOval(xpos1, ypos1 + CONST, CONST, CONST);
                gc.setFill(Color.GREEN);
                gc.strokeRect(xpos1, ypos1 + 2 * CONST, CONST, CONST);
                gc.fillRect(xpos1, ypos1 + 3 * CONST, CONST, CONST);
                gc.setFill(Color.RED);
                gc.fillOval(xpos2, ypos2, CONST, CONST);
                gc.strokeOval(xpos2, ypos2 + CONST, CONST, CONST);
                gc.setFill(Color.GREEN);
                gc.strokeRect(xpos2, ypos2 + 2 * CONST, CONST, CONST);
                gc.fillRect(xpos2, ypos2 + 3 * CONST, CONST, CONST);
            });
        }
        else {  //the lights are in drive mode (the car light is green)
            Platform.runLater(() ->{
                gc.setFill(Color.GREEN);
                gc.strokeOval(xpos1, ypos1, CONST, CONST);
                gc.fillOval(xpos1, ypos1 + CONST, CONST, CONST);
                gc.setFill(Color.RED);
                gc.fillRect(xpos1, ypos1 + 2 * CONST, CONST, CONST);
                gc.strokeRect(xpos1, ypos1 + 3 * CONST, CONST, CONST);

                gc.setFill(Color.GREEN);
                gc.strokeOval(xpos2, ypos2, CONST, CONST);
                gc.fillOval(xpos2, ypos2 + CONST, CONST, CONST);
                gc.setFill(Color.RED);
                gc.fillRect(xpos2, ypos2 + 2 * CONST, CONST, CONST);
                gc.strokeRect(xpos2, ypos2 + 3 * CONST, CONST, CONST);
            });
        }
    }
}