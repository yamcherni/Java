/**
 * @Author Yam Chernichovski
 * @Version 1
 */

import java.text.DecimalFormat;

public class MyThread extends Thread{
    int r,c,turn;
    Monitor monitor;
    Matrix a, b;
    double ans=0;
    private  final DecimalFormat df = new DecimalFormat("0.00");

    public MyThread(int row, int cal,Monitor mon,Matrix a,Matrix b,int turn){
        r= row;
        c= cal;
        monitor=mon;
        this.a =a;
        this.b=b;
        this.turn=turn;
    }

    public void run(){
       // System.out.println("my Turn is:"+ turn+" C="+c+" R="+r+" ans:");
        calc();
        print();
    }

    private void calc(){
        for (int i = 0; i < a.getWidth(); i++)
            ans+=((a.getVal(r,i))*(b.getVal(i,c)));

    }

    private void print(){
        monitor.waitForMyTurn(turn);
        //System.out.println();
        //System.out.print("my Turn is:"+ turn+" C="+c+" R="+r+" ans:");
        System.out.print(df.format(ans)+"  ");
        if (c==b.getWidth()-1)
            System.out.println();
        monitor.updateCount();
    }

}
