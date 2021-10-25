public class Board {       
	private static Board uniqueInstance;

	public static Board getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Board();
		}
		return uniqueInstance;
	}                                                                                                                      
	private Piece p1;                                                                                                         
	private Piece p2;                                                                                                         
	private Piece p3;                                                                                                         
	private Piece p4;                                                                                                         
	private Piece p5;                                                                                                         
	private Piece p6;                                                                                                         
	private Piece p7;                                                                                                         
	private Piece p8;                                                                                                         
	private Piece p9;                                                                                                         
	private Piece p10;                                                                                                        
	private Piece p11;                                                                                                        
	private Piece p12;                                                                                                        
	private Piece p13;                                                                                                        
	private Piece p14;                                                                                                        
	private Piece p15;                                                                                                        
	private Piece p16;                                                                                                        
	private Piece p17;                                                                                                        
	private Piece p18;                                                                                                        
	private Piece[][] board = new Piece[6][6];            
	
	private boolean capture= false;
	                                                                                                                                                                                                                                                        
	public Board()                                                                                                              
	{                                                                                                                           
		                                                                                                                        
		this.p1 = new Piece("s1",3, "b1" );                                                                                   
		this.p2 = new Piece("s2", 3, "b2");                                                                                   
		this.p3 = new Piece("s3", 3, "b3");                                                                                   
		this.p4 = new Piece("s4",3, "b4");                                                                                    
		this.p5 = new Piece("s5", 2,"b5");                                                                                    
		this.p6= new Piece("s6",2, "b6");                                                                                     
		this.p7 = new Piece("s7",2, "X");                                                                                    
		this.p8 = new Piece("s8",1, "X");                                                                                    
		this.p9 = new Piece("s9",3, "X");                                                                                    
		this.p10 = new Piece("s10",3, "X");                                                                                  
		this.p11 = new Piece("s11", 1, "X");                                                                                 
		this.p12 = new Piece("s12", 2, "X");                                                                                 
		this.p13 = new Piece("s13", 2, "w4");                                                                                 
		this.p14 = new Piece("s14", 2, "w5");                                                                                 
		this.p15 = new Piece("s15", 3, "w6");                                                                                 
		this.p16 = new Piece("s16", 3, "w1");                                                                                 
		this.p17 = new Piece("s17", 3, "w2");                                                                                 
		this.p18 = new Piece("s18", 3, "w3");                                                                                 
		                                                                                                                        
		this.board[0][0] = null;                                                                                                                                                                                   
		this.board[0][1] = this.p1;                                                                                          
		this.board[0][2] = null;
		this.board[0][3] = this.p2;                                                                                                                                                                                      
		this.board[0][4] = null;                                                                                          
		this.board[0][5] = this.p3;    
		
		this.board[1][0] = this.p4;                                                                                          
		this.board[1][1] = null;                                                                                    
		this.board[1][2] = this.p5;    
		this.board[1][3] = null;                                                                                      
		this.board[1][4] = this.p6;                                                                                          
		this.board[1][5] = null;
		
		this.board[2][0] = null;                                                                           
		this.board[2][1] = this.p7;                                                                                          
		this.board[2][2] = null;
		this.board[2][3] = this.p8;                                                                                          
		this.board[2][4] = null;                                                                                   
		this.board[2][5] = this.p9; 
		
		this.board[3][0] = this.p10;                                                                                         
		this.board[3][1] = null;                                                                               
		this.board[3][2] = this.p11;     
		this.board[3][3] = null;                                                                                
		this.board[3][4] = this.p12;                                                                                         
		this.board[3][5] = null;
		
		this.board[4][0] = null;                                                                                     
		this.board[4][1] = this.p13;                                                                                         
		this.board[4][2] = null;
		this.board[4][3] = this.p14;                                                                                         
		this.board[4][4] = null;                                                                      
		this.board[4][5] = this.p15;   
		
		this.board[5][0] = this.p16;                                                                                         
		this.board[5][1] = null;                                                                           
		this.board[5][2] = this.p17;     
		this.board[5][3] = null;                                                                               
		this.board[5][4] = this.p18;                                                                                         
		this.board[5][5] = null;
                                                                                                                              
	}	                                                                                                                        
	                                                                                                                            
	public Piece[][] getBoard()                                                                                                  
	{                                                                                                                           
		return board;                                                                                                           
	}                                                                                                                           
	public void setBoard(Piece[][] board)
	{
		this.board = board;
	}

	public void setCapture(boolean capture) {
		this.capture = capture;		
	}
	
	public boolean getCapture()
	{
		return capture;
	}
                                                                                                                            
}                                                                                                                               
                                                                                                                            