
public class SimpleRemoteControl {
	CommandInterface slot;
 
	public SimpleRemoteControl() {}
 
	public void setCommand(CommandInterface command) {
		slot = command;
	}
 
	public void buttonWasPressed() {
		slot.execute();
	}
}