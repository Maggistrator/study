package code.i18;

public abstract class GardenTree {
	public enum FruitingStatus{
		NICE, ENOUGH, POOR, UNKNOWN
	}
	
	private int num;
	private float age;
	private FruitingStatus fruitingStatus;
	
	public GardenTree(int num, float age, FruitingStatus status){
		this.num = num;
		this.age = age;
		this.fruitingStatus = status;
	}
	
	public abstract boolean isTransplantNeeded();

	public int getSerialNumber() {
		return num;
	}

	public void setSerialNumber(int num) {
		this.num = num;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public FruitingStatus getFruitingStatus() {
		return fruitingStatus;
	}

	public void setFruitingStatus(FruitingStatus fruitingStatus) {
		this.fruitingStatus = fruitingStatus;
	}
	
	@Override
	public String toString() {
		return getClass()+", ¹"+num+", age:"+age+", fruiting: "+fruitingStatus;
	}
}
