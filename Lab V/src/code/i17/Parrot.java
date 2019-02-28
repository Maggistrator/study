package code.i17;

public class Parrot extends Pet{
	
	private int wingspan;

	public Parrot(String name, float age, float weight, float heigth) {
		super(name, age, weight, heigth);
	}

	public int getWingspan() {
		return wingspan;
	}

	public void setWingspan(int wingspan) {
		this.wingspan = wingspan;
	}

	@Override
	public void voice() {
		System.out.println("Who is idiot? Who is idiot?");
	}
}
