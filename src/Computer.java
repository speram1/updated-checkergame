
public class Computer extends Player {

	String skillevel;
	
	public Computer(String name, int losses, int win) {
		super(name, losses, win);
	}
	
	
	public Computer(String name, int losses, int win, String skillevel) {
		super(name, losses, win);
		this.skillevel = skillevel;
	}

	public void taketurn(){
		
	}

	public String getSkillevel() {
		return skillevel;
	}

	public void setSkillevel(String skillevel) {
		this.skillevel = skillevel;
	}
	
	
	
}