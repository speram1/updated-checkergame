import java.util.Arrays;
import java.util.Iterator;

public class PlayMove {

 static void getMoves(String who, Piece[][] board, Tree tree, int currentDepth )
{
	 	
		String nextTurn;
		int requiredDepth= 2;
		if(currentDepth <= requiredDepth ) 
		{
		String occupier = null;
		String[] pieces = new String[6];
		
		if(who == "player") 	
		{
			pieces[0] =  "w1"; pieces[1] =  "w2"; pieces[2] =  "w3";pieces[3] =  "w4";
			pieces[4] =  "w5";pieces[5] =  "w6";
		}
		else
		{
			pieces[0] =  "b1"; pieces[1] =  "b2"; pieces[2] =  "b3";pieces[3] =  "b4";
			pieces[4] =  "b5";pieces[5] =  "b6";
		}
			for (int row =0; row <= 5; row++)
		      {
		         for (int column =0; column <= 5; column++)
		         {
		        	
		        	Tree xscenario;
		        	Tree yscenario;
		        	Tree zscenario;
		        	Tree qscenario;
		        	 		        	
		        	if(board[row][column]!=null)
		        	{
		        	occupier = board[row][column].getPlace();  
		        	
		            if(Arrays.asList(pieces).contains(occupier))
		            {
		            	if(Move.canMoveLeft(who, board,row, column, false ))	// if piece moves left, create scenario
		            	{
		            		
		            		 Piece[][] x= copyBoard(board);		            		 
		            		 x= Move.moveLeft(who, x, row, column); 
		            		 xscenario = new Tree(x);
		            		tree.getChildren().add(xscenario);

		            		 if(currentDepth==requiredDepth)
		            		 {
		            			xscenario.setValue(Evaluation.evaluateBoardValue(who,xscenario,"move"));
		            			
		            		 }
	
		            	}
		            	if(Move.canMoveRight(who, board,row, column, false ))	// if piece moves right, create scenario
		            	{
		            		Piece[][]y= copyBoard(board);
		            		y= Move.moveRight(who, y, row, column);
		            		 yscenario = new Tree(y);
		            		tree.getChildren().add(yscenario);
		            		if(currentDepth==requiredDepth)
		          			 {
		            			 yscenario.setValue(Evaluation.evaluateBoardValue(who,yscenario,"move"));
		            		 }

		            	}
		            	if(Capture.canCaptureLeft(who, board,row, column, false ))	// if piece captures left, create scenario
		            	{
		            		Piece[][] z = copyBoard(board);
		            		 z= Capture.captureLeft(who, z, row, column, false);
		            		
		            		 zscenario = new Tree(z);
		            		 zscenario.setIsCapture(true);
		            		tree.getChildren().add(zscenario);

		            		zscenario.setValue(Evaluation.evaluateBoardValue(who,zscenario,"capture"));          		
		            	}
     	
		            	if(Capture.canCaptureRight(who, board,row, column, false ))	// if piece captures right, create scenario
		            	{
		            		Piece[][]q= copyBoard(board);
		            		q= Capture.captureRight(who, q, row, column, false);
		            		 qscenario = new Tree(q);
		            		 qscenario.setIsCapture(true);
		            		tree.getChildren().add(qscenario);		            		
		            		qscenario.setValue(Evaluation.evaluateBoardValue(who,qscenario,"capture"));
	            		
		            	}		            	 
		            	
		            }
		           
		         }
		         }
		         
		      }
			
			 nextTurn = (who.equals("player"))? "computer": "player";
			 for(Iterator<Tree> i = tree.getChildren().iterator(); i.hasNext();)
			 {
				Tree child = (Tree) i.next();
				 if(!child.isCapture()) getMoves( nextTurn,  child.getBoard(),  child,  currentDepth+1 );
			 }
			 
		}
		
	}
 
 
 public static Piece[][] copyBoard(Piece [][] board)
 {
	 Piece [][] newBoard = new Piece[6][6];
	 Piece[][] y= board;
	 for (int Row =0; Row <=5 ; Row++)
     {
        for (int Column =0; Column <= 5; Column++)
        {
        	if(y[Row][Column]!=null)
        	{
            	newBoard[Row][Column]  = new Piece(y[Row][Column].getName(),y[Row][Column].getValue(),y[Row][Column].getPlace());

        	}
        	else
        	{
        		newBoard[Row][Column] = null;
        	}
           
        }
     }
 
 return newBoard;
 }	
}
	