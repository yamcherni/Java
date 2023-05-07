
/**
 * This class describes a list.
 *
 * @author Yam Chernichovsky
 * @version 21.2
 */
public class RectList
{
    private RectNode _head;
    
    //constructors
    public RectList()
    {
          _head= null;
    }
    
    //methods
    public void addRect(RectangleA r)
    {
        RectNode tmp = _head;
        if(tmp==null)
        {
            _head = new RectNode(r);
        }
        
     while (tmp!=null)
     {
         if (r.equals(tmp.getRect()))   
         {
             break;
         }  
         if (tmp.getNext()==null)
         {
             tmp.setNext(new RectNode(r));
             break;
         }
         tmp=tmp.getNext();
        }          
    }
    
    
    public int howManyWithPoint(Point p)
    {       
        RectNode tmp = _head;
        int c = 0;
        while (tmp!=null)
        {
        RectangleA a = tmp.getRect();
        Point b = a.getPointSW();
        if(p.equals(b)==true)
        c++;
        tmp=tmp.getNext();
        }
        return c;
    }
    
    public double longestDiagonal()
    {
        RectNode tmp = _head;
        if(tmp==null)
        return 0;
        double dis=0;
        double a =0;
        while (tmp!=null)
        {
        a=tmp.getRect().getDiagonalLength();
        if(a>dis)
        dis=a;
        tmp=tmp.getNext();
        }
        return dis;
    }
    
    public Point mostLeftRect()
    {
        RectNode tmp = _head;
        if(tmp==null)
        return null;
        Point sWtmp = tmp.getRect().getPointSW();
        tmp=tmp.getNext();
        while (tmp!=null)
        {
        Point a = tmp.getRect().getPointSW();
        if(a.isLeft(sWtmp))
        sWtmp = a;
        tmp=tmp.getNext();
        }
        return sWtmp;
    }
    
    public Point highestRect()
    {
        RectNode tmp = _head;
        if(tmp==null)
        return null;
        Point nEtmp = tmp.getRect().getPointNE();
        tmp=tmp.getNext();
        while (tmp!=null)
        {
        Point a = tmp.getRect().getPointNE();
        if(a.isAbove(nEtmp))
        nEtmp = a;
        tmp=tmp.getNext();
        }
        return nEtmp;
    }
    
    public RectangleA minimalContainer()
    {   
        Point leftDown = new Point (mostLeftRect().getX(),lowestRect().getY());
        Point upRight = new Point (mostRightRect().getX(),highestRect().getY());
        RectangleA a = new RectangleA(leftDown,upRight);
        return a;
    }
    
    public String toString()
    {   
        RectNode tmp = _head;
        if(tmp==null)
        return "The list has 0 rectangles.";
        
        else return "The list has "+numOfRec()+" rectangles. \r"+toString(1)+"\r";
    }
    private String toString(int i)
    {   
        RectNode tmp = _head;
        if(tmp==null)
        return "";
        String s ="";
        while (tmp!=null)
        {
        s=s+(i+". "+tmp.getRect().toString()+"\r");
        tmp=tmp.getNext();
        i++;
        }
        return s;
        
    }
    private String numOfRec()
    {
        RectNode tmp = _head;
        int c = 0;
        while (tmp!=null)
        {
        c++;
        tmp=tmp.getNext();
        }
        return Integer.toString(c);

    }
    private Point lowestRect()
    {
            RectNode tmp = _head;
        if(tmp==null)
        return null;
        Point sWtmp = tmp.getRect().getPointSW();
        tmp=tmp.getNext();
        while (tmp!=null)
        {
        Point a = tmp.getRect().getPointSW();
        if(a.isUnder(sWtmp))
        sWtmp = a;
        tmp=tmp.getNext();
        }
        return sWtmp;
    }
    private Point mostRightRect()
    {
        RectNode tmp = _head;
        if(tmp==null)
        return null;
        Point nEtmp = tmp.getRect().getPointNE();
        tmp=tmp.getNext();
        while (tmp!=null)
        {
        Point a = tmp.getRect().getPointNE();
        if(a.isRight(nEtmp))
        nEtmp = a;
        tmp=tmp.getNext();
        }
        return nEtmp;

    }
    
    
}
