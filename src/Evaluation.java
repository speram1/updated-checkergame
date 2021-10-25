import java.util.Arrays;

public class Evaluation {

	
	static int evaluateBoardValue(String who, Tree tree, String command)
	{
		int total = 0;
		Piece[][] board = tree.getBoard();
		String[] white = {"w1","w2","w3","w4","w5","w6"};
		String place="";

		if(command.equals("move"))
		{
			 for (int r =0; r <= 5; r++)
		      {
		         for (int c =0; c <= 5; c++)
		         {
		        	 place= (board[r][c]!=null)? board[r][c].getPlace():"";
		            if(board[r][c]!= null && !place.equals("X"))
		            {
		            	if(Arrays.asList(white).contains(place))
		            	{
		            		
		            		total += board[r][c].getValue()-1;
		            	}
		            	else
		            	{
		            		total += board[r][c].getValue()*1;
		            	} 
		            }
		         }
		      }
			
		}
		else
		{
			if(who.equals("player"))
			{
				total+= -100;
			}
			else
			{
				total += +100;
			}
		}
		return total;
	}
}
