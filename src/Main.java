
import java.io.*;
import java.util.StringTokenizer;


public class Main {
	
	
	public static void main(String[]args) throws IOException
	{
		startGame();	
	}
	public static void startGame() throws IOException
	{
		//singleton design pattern
		Board board = new Board();	
		
		printBoard(board.getBoard());
		while(true)
		{
			//command design pattern
			SimpleRemoteControl remote = new SimpleRemoteControl();
			MoveCommand m = new MoveCommand();
			HumanMove h = new HumanMove(m);
			ComputerMove c = new ComputerMove(m);

			//player move 
			board = playerMove(board);
			if(board.getCapture()) 
			{
		    remote.setCommand(h);
			remote.buttonWasPressed();
			printBoard(board.getBoard());
			System.out.println("player wins !!!"+board.getCapture()); 
			endGame("player");
			}
			printBoard(board.getBoard());
			// computer move
			board = computerMove(board);
			if(board.getCapture()) 
			{
				remote.setCommand(c);
				remote.buttonWasPressed();
				printBoard(board.getBoard());
				System.out.println("computer wins !!!"+board.getCapture());
				endGame("computer");
				}
			printBoard(board.getBoard());
		
		}        
	           
	}	
	
	public static void endGame(String winner)
	{
		if(winner.equals("player"))
		{
			//Observer Design Pattern
			SubjectClass simpleSubject = new SubjectClass();			
			ObservableClass simpleObserver = new ObservableClass(simpleSubject);
			simpleSubject.setValue("You win :D");
			simpleSubject.removeObserver(simpleObserver);
			System.exit(0);
		}
		else
		{
			SubjectClass simpleSubject = new SubjectClass();			
			ObservableClass simpleObserver = new ObservableClass(simpleSubject);
			simpleSubject.setValue("You loss :(");
			simpleSubject.removeObserver(simpleObserver);	
			System.exit(0);
		} 
	}
	

	public static Board computerMove(Board aBoard) {
		
		System.out.println("\n\n Computer's turn:" );
		Tree tree = new Tree(aBoard.getBoard());
		PlayMove.getMoves("computer", aBoard.getBoard(), tree, 0);
		aBoard.setBoard(tree.getMove(true).getBoard());
		aBoard.setCapture(tree.getMove(true).isCapture());
		
		return aBoard;			
	}

	public static Board playerMove(Board board) throws IOException {
		
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Enter a command in this format:  'w1 moveRight' ");
		System.out.println("available commands: moveLeft, moveRight, captureLeft, captureRight");

		
		String command = br.readLine();
		StringTokenizer commandTokens = new StringTokenizer(command);
		if(commandTokens.countTokens() != 2) 
		 	{
			System.out.println("Please enter a valid command");
			
			}
		String piece = commandTokens.nextToken();
		String path = commandTokens.nextToken();
		
		if(!(path.equals("moveLeft") || path.equals("moveRight")|| path.equals("captureLeft") || path.equals("captureRight"))) 
		{
			System.out.println("Please enter a valid command");
			playerMove(board);
		}
		else
		{
		if(path.equals("moveLeft") || path.equals("moveRight"))
		{
		 for (int row =0; row <= 5; row++)
	      {
	         for (int column =0; column <= 5; column++)
	         {
	        	 if(board.getBoard()[row][column]!=null && board.getBoard()[row][column].getPlace().toString().equals(piece) )
		            { 
	        		 if (Move.canMove(path,"player",board.getBoard(), row, column, true ))
	        		 {
	        			Piece[][] temp = PlayMove.copyBoard(board.getBoard());
	        			Move.move(path,"player",temp, row, column );
	        			board.setBoard(temp);
	        			return board;
	        		 }
	        		 else
	        		 {
	        			 playerMove(board);
	        		 }
	       
		            }
	         }
	         
	      } 
		}
		else
		{
			 for (int row =0; row <= 5; row++)
		      {
		         for (int column =0; column <= 5; column++)
		         {
		        	 if(board.getBoard()[row][column]!= null && board.getBoard()[row][column].getPlace().equals(piece) )
			            {
		        		 if (Capture.canCapture(path,"player",board.getBoard(), row, column, true ) == true)
		        		 {
		        			 Capture.capture(path,"player",board.getBoard(), row, column, true );
		        			
		        			 board.setCapture(true);
		        			 return board;
		        		 }
		        		 else
		        		 {
		        			 System.out.println("you cannot capture");
		        			 playerMove(board);
		        		 }
			            }
		         }
		      }
		}
	}
		return board;	
	}
	static void printBoard(Piece[][] board) 
	{
		 for (int row =0; row <= 5; row++)
	      {
			 System.out.println();
	         for (int column =0; column <= 5; column++)
	         {
	            if(board!= null && board[row][column]!= null)
	            {
	            	System.out.print("["+board[row][column].getPlace()+"]");
	            } 
	            else
	            {
	            	System.out.print(" * ");
	            }
	           	            
	         }
	      }
		 System.out.println("\n==============================================");
		
	}
	
	static boolean inBounds(int row, int col)
	{
		return row<=5  && col <=5 && row>=0 && col>=0;
	}
}
