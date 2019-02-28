package code.i17;

import java.util.Random;

public class Cat extends Pet {

	public Cat(String name, float age, float weight, float heigth) {
		super(name, age, weight, heigth);
	}

	private Random rand = new Random();
	public boolean decideToEnter() {
		if(rand.nextBoolean()) return true;
		else return false;
	}
	
	@Override
	public void voice() {
		System.out.println("Meou!");
	}

}
