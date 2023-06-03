/**
 * @Author Yam Chernichovski
 * @Version 1
 */
public class Main {
    public static void main(String[] args) {
        int N,M,P;
        N=Integer.parseInt(args[0]);
        M=Integer.parseInt(args[1]);
        P=Integer.parseInt(args[2]);

        Monitor monitor =new Monitor();
        Matrix a = new Matrix(N, M);
        Matrix b = new Matrix(M, P);
        int turn=0;
        System.out.println("\n*********************** First Matrix **********************");
        a.print();
        System.out.println("\n\n*********************** Second Matrix **********************");
        b.print();
        System.out.println("\n\n*********************** Answer Matrix **********************\n");
        MyThread [][] t=new MyThread[N][P];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < P; j++)
                t[i][j]=new MyThread(i,j,monitor,a,b,turn++);

        for (int i = 0; i < N; i++)
            for (int j = 0; j < P; j++)
                t[i][j].start();


    }
}