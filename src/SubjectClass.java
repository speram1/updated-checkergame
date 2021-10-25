import java.util.ArrayList;
import java.util.List;

public class SubjectClass implements Subject{
	private List<Observer> observers;
	private String value = "";
	
	public SubjectClass() {
		observers = new ArrayList<Observer>();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.notify(value);
		}
	}
	
	public void setValue(String value) {
		this.value = value;
		notifyObservers();
	}
}
