package code.i18;

public class PeerTree extends GardenTree {

	public PeerTree(int num, float age, FruitingStatus status) {
		super(num, age, status);
	}

	@Override
	public boolean isTransplantNeeded() {
		if (getAge() > 3 && getAge() < 6) return true;
		else return false;
	}

}
