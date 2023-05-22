/**
 * This class represents a Rectangle object in the Cartesian coordunate system.
 * The Rectangle represented by his with, height and the lowest Point on the left side of
 * it, called SW.
 * 
 * @author Yam Chernichovsky
 * @version 26.11
 * 
 */
public class RectangleA
{
    //instance variables
    private int _width,_height;
    private Point _pointSW;

    //constructors
    /**
     * Constructs a new RectangleA object from width and height, and SW point at (0,0) 
     * @param w the width of the RectangeA
     * @param h the height of the RectangleA
     */
    public RectangleA(int w, int h)
    {
        _pointSW =new Point (0,0);
        if (w>0)
            _width = w;
        else _width = 1;
        if (h>0)
            _height = h;
        else _height = 1;
    }
    /**
     * Constructs a new RectangleA object from Point, width and height.
     * if the Point given as paramether is null
     * the poin wiil be (0,0), else it wiil be the given Point.
     * the width and height must be positibe or they will be 1 as diffult.
     * @param w the width of the RectangeA
     * @param h the height of the RectangleA
     * @param p Point object used to construct RectangleA
     */
    public RectangleA(Point p, int w, int h)
    {
        if (p==null)
            _pointSW =new Point (0,0);
        else _pointSW = new Point(p);
        if (w>0)
            _width = w;
        else _width = 1;
        if (h>0)
            _height = h;
        else _height = 1;

    }
    /**
     * Costructs a new RectangleA from tow Points and calculates the width and the height.
     * @param sw Point that wiil create new PointSW.
     * @param ne Point used to calculate rhe width and the height of the RectangleA.
     */
    public RectangleA(Point sw, Point ne)
    {
        _pointSW = new Point(sw); 
        _width = (ne.getX()-sw.getX());
        _height =(ne.getY()-sw.getY());
    }
    /**
     * Copy constructor that takes RectangleA and creates a new one with the same properties.
     * @param r RectangleA used to create new RectangleA with same properties.
     */
    public RectangleA(RectangleA r)
    {
        _pointSW =new Point(r._pointSW);
        _width=r._width;
        _height=r._height;    
    }
    /**
     * Return the width of the rectangle.
     * @return Width of the rectangle.
     */
    public int getWidth()
    {
        return _width;
    }
    /**
     * Return the height of the rectangle.
     * @return Height of the rectangle
     */
    public int getHeight()
    {
        return _height;
    }
    /**
     * Return the PointSW of the rectangle.
     * @return PointSW of the rectangle
     */
    public Point getPointSW()
    {
        return new Point (_pointSW);
    }
    /**
    * Change the width of a RectangleA if the value is positive
    * @param w New width of the RectangleA
    */
    public void setWidth(int w)
    {
        if (w>0)
        {
            _width = w;
        }
    }
    /**
     * Change the height of the RectangleA if the value is positive
     * @param a New height of the RectangleA
     */
    public void setHeight(int h)
    {
        if (h>0)
        {
            _height= h;  
        }
    }
    /**
     * Change the PointSW to new point.
     * @param a Point that will be used as new PointSW.
     */
    public void setPointSW(Point p)
    {
        _pointSW = new Point (p);
    }
    /**
     * Return the RectangleA properties if format: width, height, pointSW.
     */
    public String toString()
    {
        return "Width="+_width+ " Height="+_height+ " PointSW="+_pointSW.toString();
    }
    /**
     * Return the perimeter of RectangleA.
     * @return Perimeter of RectangleA.
     */
    public int getPerimeter()
    {
        return 2*(_width+_height);
    }
    /**
     * Return the area of RectangleA.
     * @return Area of RectangleA.
     */
    public int getArea()
    {
        return (_width*_height);
    }
    /**
     * Move the PointSW of RectangleA.
     * X moved by deltaX, y moved by deltaY.
     * When the paraneters isn't positive it moved by 1. 
     * @param deltaX Move PointSW x by deltaX.
     * @param deltaY Move PointSW y by deltaY
     */
    public void move(int deltaX, int deltaY)
    {
        _pointSW.move(deltaX,deltaY);
    }
    /**
     * Return if the RectangleA that runned the procces equals to the given RectangleA.
     * @return If the RectangleA that runned the procces equals to the given RectangleA.
     * @param other RectangleA that the RectangleA that runned the proces check equality with.
     */
    public boolean equals(RectangleA other)
    {
        return (_width==other._width && _height==other._height && _pointSW.equals(other._pointSW));
    }
    /**
     * Return the diagonal length of the RectangleA.
     * @return Diagonal length of the RectangleA.
     */
    public double getDiagonalLength()
    {
        return Math.sqrt(_height*_height+_width*_width);
    }
    /**
     * Return if the RectangleA that runned the method larger then the RectangleA that gaven
     * as paranether.
     * @return If the RectangleA that runned the method larger then the RectangleA that gaven
     * as paranether.
     * @param other RectangleA a that the RectangleA that runned the method check if it larger from.
     */
    public boolean isLarger(RectangleA other)
    {
        return (this.getArea()>other.getArea());
    }
    /**
     * Return the point in the north east side of the RectangleA.
     * @retuen New Point in the north east side of the RectangleA.
     */
    public Point getPointNE()
    {
        Point nw = new Point(_pointSW);
        nw.move(_width,_height);
        return nw;
    }
    /**
     * Change the sides of the RectangleA
     */
    public void changeSides()
    {
        int x = _width;
        _width = _height;
        _height = x;
    }
    /**
     * Return if the RectangleA that runs the method located inside RectangleA that gaven as paramether.
     * @return If the RectangleA that runs the method located inside RectangleA that gaven as paramether.
     * @param r RectangleA that the RectangleA who run method check if it in it. 
     */
    public boolean isIn (RectangleA r)
    {
        return (this._pointSW.getX() >= r._pointSW.getX() &&
            this._pointSW.getY() >= r._pointSW.getY() &&
            this.getPointNE().getX() <= r.getPointNE().getX() &&
            this.getPointNE().getY() <= r.getPointNE().getY() );
    }
    /**
     * Return if the rectangles overlap.
     * @return If the rectangles overlap.
     * @param r RectangleA that the RectangleA that runned the method check with.
     */
    public boolean overlap (RectangleA r)
    {
        if (
        this._pointSW.getX() > r.getPointNE().getX() &&
        this._pointSW.getY() > r.getPointNE().getY() &&
        r._pointSW.getX() > this.getPointNE().getX() &&
        r._pointSW.getY() > this.getPointNE().getY())
        return false;
        else return true;
        
    }
   
    }

    

