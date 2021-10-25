
public class Move {
 
	
static boolean canMove(String path, String who, Piece[][] board, int row, int column,boolean isPlayer) {
		
		if(path.equals("moveLeft"))
		{
			return canMoveLeft(who, board, row, column,  isPlayer);
		}
		else if(path.equals("moveRight"))
		{
			return canMoveRight(who, board, row, column, isPlayer);
		}
		else
		{
			return false;
		}
		
	}



public static boolean canMoveRight(String Who, Piece[][] board, int pieceRow, int pieceCol, boolean isPlayer)
{
boolean can;
int rowAlter;		// Alter  row to determine desired position
int colAlter;		// Alter column to determine desired position
if(Who.equals("player"))
{
	rowAlter = -1;
	colAlter = 1;
}
else
{
	rowAlter = 1;
	colAlter = 1;
}
	if(pieceCol == 5)
	{
		if(isPlayer ) System.out.println("there are no right spots for"+board[pieceRow][pieceCol].getPlace()+", you are at edge");
		can = false; 
	}
	else
	{
		if(Main.inBounds((pieceRow+rowAlter), (pieceCol+colAlter)) && board[pieceRow+rowAlter][pieceCol+colAlter]!= null && board[pieceRow+rowAlter][pieceCol+colAlter].getPlace().equals("X"))
		{
			can = true;
		}
		else
		{
			if(isPlayer && !board[pieceRow][pieceCol].getPlace().equals("X")) System.out.println("the right spot of "+board[pieceRow][pieceCol].getPlace()+", is occupied");
			can = false;
		}
		
		
	}
	return can;
}


public static boolean canMoveLeft(String Who, Piece[][] board, int pieceRow, int pieceCol, boolean isPlayer)
{
boolean can;
int rowAlter;		
int colAlter;	
if(Who.equals("player"))
{
	rowAlter = -1;
	colAlter = -1;
}
else
{
	rowAlter = 1;
	colAlter = -1;
}
	if(pieceCol == 0)
	{
		if(isPlayer && !board[pieceRow][pieceCol].getPlace().equals("X")) System.out.println("there are no Left spots for "+board[pieceRow][pieceCol].getPlace()+", you are at edge");
		can = false;
	}
	else
	{
		
		if(Main.inBounds((pieceRow+rowAlter), (pieceCol+colAlter)) && board[pieceRow+rowAlter][pieceCol+colAlter]!= null && board[pieceRow+rowAlter][pieceCol+colAlter].getPlace().equals("X"))
		{
			can = true;
		}
		else
		{
			if(isPlayer && !board[pieceRow][pieceCol].getPlace().equals("X"))System.out.println("the left spot of "+board[pieceRow][pieceCol].getPlace()+"  is occupied");
			can = false;
		}
	
	
	}
	return can;
}






public static Piece[][]  move(String path, String Who, Piece[][] board, int pieceRow, int pieceCol)
{
	if(path.equals("moveLeft"))
	{
		System.out.println("Move Left!");
		 return moveLeft(Who, board, pieceRow, pieceCol);
	
	}
	else 
	{
		System.out.println("Move Right!");
		return moveRight(Who, board, pieceRow, pieceCol);
	
	}

}
	



public static Piece[][] moveLeft(String Who,Piece[][] board, int pieceRow, int pieceCol)
{
	int rowAlter;		// to specify spot to be used.
	int colAlter;
	
	if(Who.equals("player"))
	{
		rowAlter = -1;
		colAlter = -1;
	}
	else
	{
		rowAlter = 1;
		colAlter = -1;
	}
	
	board[pieceRow+rowAlter][pieceCol+colAlter].setPlace(board[pieceRow][pieceCol].getPlace());
	board[pieceRow][pieceCol].setPlace("X");
	return board;
}


public static Piece[][] moveRight(String Who,Piece[][] board, int pieceRow, int pieceCol)
{
	
	int rowAlter;		
	int colAlter;
	
	if(Who.equals("player"))
	{
		rowAlter = -1;
		colAlter =  1;
	}
	else
	{
		rowAlter =  1;
		colAlter =  1;
	}
	
	board[pieceRow+rowAlter][pieceCol+colAlter].setPlace(board[pieceRow][pieceCol].getPlace());
	board[pieceRow][pieceCol].setPlace("X");
	return board;

}
















	
}
