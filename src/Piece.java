
public class Piece {
	private String name;
	private int value;
	private String place;
	
	
	public Piece(String name,int value, String p)
	{
		this.value = value;
		this.place = p;
		this.name = name;
		
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getValue() {
		return value;
	}


	public void setValue(int value) {
		this.value = value;
	}


	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	
}
