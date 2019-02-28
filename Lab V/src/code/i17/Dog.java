package code.i17;

import java.util.Random;

public class Dog extends Pet {

	public Dog(String name, float age, float weight, float heigth) {
		super(name, age, weight, heigth);
	}
	
	@Override
	public void voice() {
		System.out.println("Bark!");
	}
}
