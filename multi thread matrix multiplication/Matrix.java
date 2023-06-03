/**
 * @Author Yam Chernichovski
 * @Version 1
 */

import java.text.DecimalFormat;

public class Matrix {

    private  final DecimalFormat df = new DecimalFormat("0.0");
    private double myMatrix[][];
    int r,c;
    Matrix (int r, int c){
        this.r=r;
        this.c=c;
        myMatrix=new double[r][c];
        fill(myMatrix);
    }

    private void fill(double tmp[][]) {
        int row = tmp.length;
        int cal = tmp[0].length;
        for (int i = 0; i < row; i++)
            for (int j = 0; j < cal; j++)
                tmp[i][j] = Double.parseDouble(df.format(Math.random() * 10.0));
    }

    public void print() {
        int row = myMatrix.length;
        int cal = myMatrix[0].length;
        for (int i = 0; i < row; i++) {
            System.out.println();
            for (int j = 0; j < cal; j++)
                System.out.print(myMatrix[i][j] + "  ");
        }
    }

    public int getWidth(){
        return c;
    }
    public int getHight(){
        return r;
    }
    public double getVal(int r,int c){
        return myMatrix[r][c];
    }
}