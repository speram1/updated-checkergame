
public class ComputerMove implements CommandInterface {
	MoveCommand move;
 
	public ComputerMove(MoveCommand m) {
		this.move = m;
	}
 
	public void execute() {
		move.computerMove();
	}
}