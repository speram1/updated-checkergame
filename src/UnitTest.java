import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		//singleton design pattern
				Board board = new Board();	
				Main main = new Main();
				main.printBoard(board.getBoard());
		//command design pattern
				SimpleRemoteControl remote = new SimpleRemoteControl();
				MoveCommand m = new MoveCommand();
				HumanMove h = new HumanMove(m);
				ComputerMove c = new ComputerMove(m);
	}
}
