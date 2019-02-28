package code.i17;

public abstract class Pet {

	public String name;
	public float age, weight, height;
	
	public Pet(String name, float age, float weight, float heigth) {
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = heigth;
	}
	
	public abstract void voice();
	
	@Override
	public String toString() {
		return "name: "+name+ ", age: "+age+ ", weight: "+weight+", height:"+height;
	}

}
