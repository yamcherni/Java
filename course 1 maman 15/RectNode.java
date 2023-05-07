
/**
 * This class describes a node in a list.
 *
 * @author Yam Chernichovsky
 * @version 21.2
 */
public class RectNode
{
    private RectangleA _rect;
    private RectNode _next;
    //constructors
    public RectNode (RectangleA r)
    {
        _rect = r;
        _next = null;
    }
    
    public RectNode (RectangleA r, RectNode n)
    {
        _rect = r;
        _next = n;
    }
    
    public RectNode (RectNode r)
    {
        _rect = r.getRect();
        _next = r.getNext();
    }
    //methods
    public RectangleA getRect()
    {
        return new RectangleA​(_rect);
    }
    
    public RectNode getNext()
    {   
        return _next;
    }
    
    public void setRect(RectangleA r)
    {
        _rect=r;
    }
    
    public void setNext(RectNode next)
    {
        _next = next;        
    }
}   
