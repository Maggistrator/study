package code.i18;

public class CherryTree extends GardenTree{

	public CherryTree(int num, float age, FruitingStatus status) {
		super(num, age, status);
	}

	@Override
	public boolean isTransplantNeeded() {
		return false;
	}

}
