
public class HumanMove implements CommandInterface {
	MoveCommand move;
 
	public HumanMove(MoveCommand m) {
		this.move = m;
	}
 
	public void execute() {
		move.humanMove();
	}
}