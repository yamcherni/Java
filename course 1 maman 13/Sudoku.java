/**
 *Represents a Sudoku 9x9 build from 3x3 Squares.
 *
 * @author Yam Chernichovsky
 * @version 7.12
 */
public class Sudoku
{
    private Square3x3[][]sud;
    /**
     * Constructs and initializes a 2-dimensional array of the size 9X9, with the values of –1 in each cell.
     * Difult constructor.
     */
    public Sudoku()
    {
        sud = new Square3x3[3][3];
        for (int i =0 ; i<3 ; i++)
            for (int j =0 ; j<3 ; j++)
                sud[i][j]=new Square3x3();
    }

    /**
     * Constructs a 2-dimensional array of the size 9X9, whose values are taken from the given array of Square 3x3 objects.
     * @param square3x3Array Square3x3[][] array of Square objects that we copy values from.
     */
    public Sudoku(Square3x3[][] square3x3Array)
    {
        sud = new Square3x3[3][3];
        for (int i =0 ; i<3 ; i++)
            for (int j =0 ; j<3 ; j++)
                sud[i][j] = new Square3x3(square3x3Array[i][j]);

    }
    /*
    public String toString()
    {
    String toPrint = "";
    for (int i =0 ; i<3 ; i++)
    for (int j =0 ; j<3 ; j++)
    toPrint += (sud[i][j].toString());
    toPrint += "\n";
    return toPrint;
    }
     */

    private int rowSum(int x)//all rows sum should be 55
    {
        int mat,row;
        int sum = 0;
        if (x/3==0)
        {
            mat =0;
            row = x;
        }
        else //(x/3 >0)
        {
            mat = x/3;
            row = x%3;
        }
        for(int i =0 ; i<3 ; i++)
            for(int j=0 ; j<3 ; j++)
                sum += sud[mat][i].getCell(row,j);

        return sum;
    }

    private int calSum(int x) //calloms sum.
    {
        int mat,cal;
        int sum = 0;
        if (x/3==0)
        {
            mat =0;
            cal = x;
        }
        else //(x/3 >0)
        {
            mat = x/3;
            cal = x%3;
        }
        for(int i =0 ; i<3 ; i++)
            for(int j=0 ; j<3 ; j++)
                sum += sud[i][mat].getCell(j,cal);

        return sum;
    }

    /* public String printRow(int x ) //for personal use. return sudoku print. max vlaue 8
    {
    int mat,row;
    String sum = "";
    if (x/3==0)
    {
    mat =0;
    row = x;
    }
    else //(x/3 >0)
    {
    mat = x/3;
    row = x%3;
    }
    for(int i =0 ; i<3 ; i++)
    for(int j=0 ; j<3 ; j++)
    sum += sud[mat][i].getCell(row,j)+"\t";
    sum += "\n";

    return sum;
    }
     */
    /**
     * Cheks if the Sudoku is valid
     * @return If valid - true, else false.
     */
    public Boolean isValid()
    {   
        boolean stop = false;
        boolean ret = true;
        for(int i =0 ; i<3 && stop==false ; i++)
        {
            for(int j =0 ; j<3 && stop==false ; j++)
            {
                if(sud[i][j].allThere()==false)
                {   
                    stop = true;
                    return false;
                }
            }
        }
        if (ret == true)
        {
            for(int i =0 ; i<8 ; i++)
                if (rowSum(i)!=45)
                {
                    ret=false;
                    break;
                }
        }
        if (ret == true)
        {
            for(int i =0 ; i<8 ; i++)
                if (calSum(i)!=45)
                {
                    ret=false;
                    break;
                }
        }

        return ret;
    }
}


