
import java.lang.Math;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tree {
    private LinkedList<Tree>  child = new LinkedList<Tree>();
    private Piece[][] gameboard;
    private double number= 0;
    private boolean capture;

   public Tree(Piece[][] gameboard)
   {
	   this.gameboard = gameboard;
   }
     
    public Piece[][] getBoard()
     {
    	 return this.gameboard;
     }
    
    public List<Tree> getChildren()
    {
    	return this.child;
    }
    
    public double getValue()
    {
		return number;
    }
    
    public void setValue(double value)
    {
    	this.number = value;
    }
 
    public double minmax(boolean isComputer)
    { 	 
   		 if(this.getChildren().isEmpty())
   		 {
   			 return this.getValue();
   		 }
   		
   	  if(isComputer){ 
          double a = Double.MIN_VALUE;
          for(Iterator<Tree> i = child.iterator(); i.hasNext();){  //cycle through all of the possible resulting moves
              Tree tree =(Tree)i.next();
        	  a = Math.max(a,tree.minmax(!isComputer));
          }
          return a;
      }
      else{   
          double a = Double.MAX_VALUE;
          for(Iterator<Tree> i = child.iterator(); i.hasNext();){  //cycle through all of the possible resulting moves
        	  Tree tree = (Tree)i.next();
        	  a = Math.min(a, tree.minmax(!isComputer));
          }
          return a;
   	 }
    }
  
    public Tree getMove(boolean isComputer){
        if(child.isEmpty()){
            return null;
        }
        Tree best = null;
        double maxScore = (isComputer ? Double.MIN_EXPONENT : Double.MAX_VALUE);  //highest or lowest, depending on what we want
        for(Iterator<Tree> i = child.iterator(); i.hasNext();){
        	Tree child = (Tree) i.next();
            double value = child.minmax(isComputer);
            if(best == null || value * (isComputer ? 1 : -1) > maxScore * (isComputer ? 1 : -1)){
                maxScore = value;
                best = child;
            }
        }       
        return best;
    }
    
    public boolean isCapture()
    {
    	return capture;
    }

    public void setIsCapture(boolean isCapture)
    {
    	this.capture = isCapture;
    }
   
}