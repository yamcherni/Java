
/**
 *Represents a Square at size 3x3.
 *
 * @author Yam Chernichovsky
 * @version 7.12
 */
public class Square3x3
{
    private int [][] arr;

    /**
     * Constructs and initializes a 2-dimensional array of the size 3X3, with the values of –1 in each cell.
     * Difult constructor.
     */
    public Square3x3()
    {
        arr = new int [3][3];
        for (int i =0 ; i<3 ; i++)
            for (int j =0 ; j<3 ; j++)
                arr[i][j]=-1;
    }

    /**
     * Constructs a 2-dimensional array of the size 3X3, whose values are taken from the given array.
     * If the given array’s size is bigger than 3X3, only the first 3X3 cells are taken. If the given array is smaller,
     * the rest of the cells are initialized to –1. 
     * if and only if the corresponding cell in the given array does not exist.
     * @param array Int[][] object that we copy values from.
     */
    public Square3x3(int[][]array)
    {
        this();
        for(int i =0 ;i<array.length && i<3;i++)
            for(int j =0 ;j<array[i].length && j<3 ;j++)
                arr[i][j] =  array[i][j];
    }

    /**
     * Copy constructor. Constructs a 2-dimensional array of the size 3X3,
     * whose values are taken from the array of the given Square3x3 object.
     * @param other Squere3x3 object that we copy the values from.
     */
    public Square3x3(Square3x3 other)
    {
        arr = new int [3][3];

        for(int i =0 ;i<other.arr.length && i<3;i++)
            for(int j =0 ;j<other.arr[i].length && j<3 ;j++)
                arr[i][j] =  other.arr[i][j];

    }
    /**
     * Returns the value in the (row, col) cell. If the row and/or col are out of the array bounds,returns –1.
     * @param row Row number of Square3x3.
     * @param col Collom number of Square3x3.
     */

    public int getCell(int row, int col)
    {
        if (row>=0 && row <=2)
        {
            if(col>=0 && col <=2)
                return arr[row][col];
        }
        return -1;
    }
    /**
     * Sets the cell (row, col) in the array to the given value. 
     * If the row and/or col are out of the array bounds – does nothing.
     * @param row Row number of Square3x3.
     * @param col Collom number of Square3x3.
     * @param val The number that you wont to put in the chosen plase.
     */
    public void setXY(int row, int col, int value)
    {
        if (row>=0 && row <=2)
        {
            if(col>=0 && col <=2)
                arr[row][col] = value;
        }
    }
    /**
     * Returns a String representation of the Square3x3 array. 
     * @return String representation of the Square3x3 array.
     */
    public String toString()
    {
        String temp ="";
        for (int i = 0 ; i<3 ; i++)
        {
            for (int j =0 ; j<3 ; j++)
                temp += (arr[i][j]+ "\t");
            temp += "\n";
        }
        return temp;

    }
    /**
     * Cheks if all the numbrs from 1 to 9 is in the Square3x3 array.
     * @return If all the numbrs from 1 to 9 is in the Square3x3 array return true, if one 
     *  or more numbers missing or seen twise return false.
     */
    public boolean allThere()
    {
        int howMutchIsIn = 0;
        boolean stop = false;

        for(int n = 1; n <=9 ;n++)
        {
            stop = false;
            for (int i =0 ; i<3 && stop==false ; i++){
                for (int j =0 ; j<3 && stop==false ; j++){
                    if (n==arr[i][j])
                    {
                        howMutchIsIn++;
                        stop = true;
                    }
                }
            }
        }       
        return howMutchIsIn==9;
    }
    /**
     * Changes the value of array at places that feets to numbers in selected row of
     * the Square3x3 array.
     * @param row The row that you wont to take number from
     * @param values boolean[] that wiil be updated acording to the selected row.
     */
    public void whosThereRow (int row, boolean[] values )
    {

        for(int i = 0; i<3 ; i++)
        {
            values[getCell(row,i)] = true;

        }
    }
    /**
     * Changes the value of array at places that feets to numbers in selected callom of
     * the Square3x3 array.
     * @param col The callom that you wont to take number from
     * @param values boolean[] that wiil be updated acording to the selected callom.
     */
    public void whosThereCol (int col, boolean[] values )
    {

        for(int i = 0; i<3 ; i++)
        {
            values[getCell(i,col)] = true;
        }
    }






    
    
    
    
}
