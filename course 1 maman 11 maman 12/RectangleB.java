
/**
 * This class represents a Rectangle object in the Cartesian coordunate system.
 * The Rectangle represented by the north west point (NW) and south east point (SE).
 * 
 * 
 * @author Yam Chernichovsky
 * @version 26.11
 * 
 */
public class RectangleB
{
    private Point _pointSW;
    private Point _pointNE;
    /**
     * Constructs a new RectangleB object from width and height, and create the neede Points.
     * @param w the width of the RectangeB.
     * @param h the height of the RectangleAB.
     */
    public RectangleB(int w, int h)
    {
        _pointSW = new Point(0,0);
        if (h<=0 && w<=0)
            _pointNE = new Point(1,1);
        else if (w<=0)
            _pointNE = new Point(1,h);
        else if (h<=0)
            _pointNE = new Point(w,1);
        else 
            _pointNE = new Point(w,h);

    }
    /**
     * Constructs a new RectangleB object from Point, width and height.
     * if the Point given as paramether is null.
     * the poin wiil be (0,0), else it wiil be the given Point.
     * the width and height must be positibe or they will be 1 as diffult.
     * @param w the width of the RectangeB.
     * @param h the height of the RectangleB.
     * @param p Point object used to construct RectangleB.
     */
    public RectangleB(Point p, int w, int h)
    {
        if (p==null)
        _pointSW =new Point (0,0);
        else _pointSW = new Point(p);
        if (w<=0)
        {
         w=1;   
        }
        if (h<=0)
        {
         h =1;
        }
        _pointNE = new Point (p.getX()+w,p.getY()+h);
    }
    /**
     * Creates new RectangleB from the gaven Points.
     * @param sw The SW point of RectangleB.
     * @param ne The NE point of RectangleB.
     */
    public RectangleB(Point sw, Point ne)
    {
        _pointSW = new Point(sw);
        _pointNE = new Point(ne);
    }
    /**
     * Copy constructor that takes RectangleB and creates a new one with the same properties.
     * @param r RectangleB used to create new RectangleB with same properties.
     */
    public RectangleB(RectangleB r)
    {
        _pointSW = r._pointSW;
        _pointNE = r._pointNE;   
    }
    /**
     * Return the width of the rectangle.
     * @return Width of the rectangle.
     */
    public int getWidth()
    {
        return Math.abs (_pointSW.getX() - _pointNE.getX());
    }
    /**
     * Return the height of the rectangle.
     * @return Height of the rectangle.
     */
    public int getHeight()
    {
        return Math.abs (_pointSW.getY() - _pointNE.getY());
    }
    /**
     * Return the PointSW of the rectangle.
     * @return PointSW of the rectangle.
     */
    public Point getPointSW()
    {
        return new Point(_pointSW);
    }
    /**
    * Change the width of a RectangleB if the value is positive.
    * @param w New width of the RectangleB.
    */
    public void setWidth(int w)
    {
        if (w>0)
        {
            _pointNE = new Point (_pointSW.getX()+w,_pointNE.getY());
        }
    }
    /**
     * Change the height of the RectangleB if the value is positive.
     * @param a New height of the RectangleB.
     */
    public void setHeight(int h)
    {
        if (h>0)
        {
         _pointNE = new Point (_pointNE.getX(),_pointSW.getY()+h);
        }
    }
    /**
     * Change the PointSW to the given Point .
     * @param p Point that will be used as PointSW.
     */
    public void setPointSW(Point p)
    {
        int wid = getWidth();
        int hei = getHeight();
        _pointSW = new Point(p);
        this.setWidth(wid);
        this.setHeight(hei);
    }
    /**
     * Return the RectangleB properties as width, height and PointSW.
     */
    public String toString()
    {
        return "Width="+ getWidth() + " Height="+getHeight()+ " PointSW="+_pointSW.toString();
    }
    /**
     * Return the perimeter of RectangleB.
     * @return Perimeter of RectangleB.
     */
    public int getPerimeter()
    {
        return 2*(getWidth()+getHeight());
    }
    /**
     * Return the area of RectangleB.
     * @return Area of RectangleB.
     */
    public int getArea()
    {
        return (getWidth()*getHeight());
    }
    /**
     * Move the PointSW of RectangleB.
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
     * Return if the RectangleB that runned the procces equals to the given RectangleB.
     * @return If the RectangleB that runned the procces equals to the given RectangleB.
     * @param other RectangleB that the RectangleB that runned the proces check equality with.
     */
    public boolean equals(RectangleB other)
    {
        return (this.getWidth()==other.getWidth() && this.getHeight()==other.getHeight() && _pointSW.equals(other._pointSW));
    }
    /**
     * Return the diagonal length of the RectangleB.
     * @return Diagonal length of the RectangleB.
     */
    public double getDiagonalLength()
    {
        return Math.sqrt(getHeight()*getHeight()+getWidth()*getWidth());
    }
    /**
     * Return if the RectangleB that runned the method larger then the RectangleB that gaven
     * as paranether.
     * @return If the RectangleB that runned the method larger then the RectangleB that gaven
     * as paranether.
     * @param other RectangleB a that the RectangleB that runned the method check if it larger from.
     */
    public boolean isLarger(RectangleB other)
    {
        return (this.getArea()>other.getArea());
    }
    /**
     * Return the point in the north east side of the RectangleB.
     * @retuen New Point in the north east side of the RectangleB.
     */
    public Point getPointNE()
    {
        return new Point(_pointNE);
    }
    /**
     * Change the sides of the RectangleB
     */
    public void changeSides()
    {
        int x = getWidth();
        _pointNE.setX(_pointSW.getX()+getHeight());
        _pointNE.setY(_pointSW.getY()+x);
    }
    /**
     * Return if the RectangleB that runs the method located inside RectangleB that gaven as paramether.
     * @return If the RectangleB that runs the method located inside RectangleB that gaven as paramether.
     * @param r RectangleB that the RectangleB who run method check if it in it. 
     */
    public boolean isIn (RectangleB r)
    {
        return (this._pointSW.getX() >= r._pointSW.getX() &&
            this._pointSW.getY() >= r._pointSW.getY() &&
            this.getPointNE().getX() <= r.getPointNE().getX() &&
            this.getPointNE().getY() <= r.getPointNE().getY() );
    }
    /**
     * Return if the rectangles overlap.
     * @return If the rectangles overlap.
     * @param r RectangleB that the RectangleB that runned the method check with.
     */
    public boolean overlap (RectangleB r)
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
