/**
 * This class represents a Point object in the Cartesian coordunate system.
 * 
 * @author Yam Chernichovsky
 * @version 26.11
 * 
 */
public class Point
{
    private int _x,_y;
    
    /**
     * Constructs a point at a(x,y) location at the Cartesian coordinate system.
     * @param x The X coordinate of this point.
     * @param y The Y coordinate of this point.
     */
   
    public Point(int x, int y)
    {
        _x=x;
        _y=y;
    }
    /**
     * Constructs a point at location given by other point (x,y) cordinate.
     * @param other Point uesd to create new Point with same coordinate.
     */
    public Point (Point other)
    {
        _x=other._x;
        _y=other._y;
    }
    /**
     * Returns the x value of the Point.
     * @return x value of the point.
     */
    public int getX()
    {
        return _x;
    }
    /**
     * Change the x value of the Point.
     * @param num change x coordinate.
     */
    public void setX(int num)
    {
        _x=num;
    }
    /**
     * Returns the y value of the Point.
     * @return y value of the point.
     */
    public int getY()
    {
        return _y;
    }
    /**
     * Change the y value of the Point.
     * @param num change y coordinate.
     */
    public void setY(int num)
    {
        _y=num;
    }
    /**
     * Return the point coordinare in a format (x,y)
     */
    public String toString()
    {
        return "(" + _x + "," + _y +")";
    }
    /**
     * Check if point that runs the proces equals to the other point.
     * return true or false.
     * @param other the Point that we check the distance from.
     */
    public boolean equals (Point other)
    {
        return (_x==other._x && _y==other._y);
    }
    /**Check if the Point that runned the proces located above the other point.
     * return true or false.
     * @param other the Point that we check if located under Point that run the procces.
     */
    public boolean isAbove (Point other)
    {
        return (_y>other._y);
    }
    /**check if the Point that runned the proces located above the other point.
     * return true or false.
     * @param other the Point that we check if located above Point that run the procces.
     */
    
    public boolean isUnder (Point other)
    {
        return other.isAbove(this);
    }
    /** Check if the Point that runned the proces located left to the other point.
     * return true or false.
     * @param other the Point that we check if located right to the Point that run the procces.
     */
    public boolean isLeft (Point other)
    {
        return (_x<other._x);
    }
    /** Check if the Point that runned the proces located right to the other point.
     * return true or false.
     * @param other the Point that we check if located left to the Point that run the procces.
     */
    public boolean isRight (Point other)
    {
        return other.isLeft(this);
    }
    /**
     * Moves the point cordinate - x by deltaX and y by delta Y
     * @param deltaX the value to move the x coordinate.
     * @param deltaY the value to move the y coordinate.
     */
    public void move (int deltaX, int deltaY)
    {
        _x+=deltaX;
        _y+=deltaY;
    }
    /** Calculare the distance betweed the point that renned the procces and the other point called p.
     * @param p Point that we check the distance from.
     */
    public double distance (Point p)
    {
        return Math.sqrt((_x-p._x)*(_x-p._x)+(_y-p._y)*(_y-p._y));
    }
}   


