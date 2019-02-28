package code.i18;

public class AppleTree extends GardenTree {

	public AppleTree(int num, float age, FruitingStatus status) {
		super(num, age, status);
	}

	@Override
	public boolean isTransplantNeeded() {
		if (getAge() > 1 && getAge() < 3) return true;
		else return false;
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
