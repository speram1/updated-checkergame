
public class ObservableClass implements Observer{
	private String value;
	private Subject simpleSubject;
	
	public ObservableClass(Subject simpleSubject) {
		this.simpleSubject = simpleSubject;
		simpleSubject.registerObserver(this);
	}
	
	public void display() {
		System.out.println("Value: " + value);
	}

	@Override
	public void notify(String status) {
		this.value = value;
		display();		
	}

	
}
