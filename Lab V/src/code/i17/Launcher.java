package code.i17;

/**
 * 17. Создать суперкласс Домашнее животное и подклассы Собака, Кошка, Попугай. 
 * С помощью конструктора установить имя каждого животного и его характеристики. 
 * */
public class Launcher {

	public static void main(String[] args) {
		Pet pet = new Parrot("Popka", 2, 0.04f, 0.15f);
		Dog doggo = new Dog("Sharick", 8, 12.5f, 1.5f);
		Cat kitty = new Cat("Marusia", 12, 3.5f, 0.5f);
		
		System.out.println(pet);
		System.out.println(doggo);
		System.out.println(kitty);
		
		pet.voice();
		doggo.voice();
		kitty.voice();
		
		System.out.println(kitty.name+" decides, if it gonna enter: " + (kitty.decideToEnter() ? "yes!" : "no."));
	}

}
