package code.i18;

import java.util.ArrayList;
import java.util.Scanner;

import code.i18.GardenTree.FruitingStatus;

public class GardenDeals {

	/**
	 * Создать базовый класс Садовое дерево и производные классы Яблоня, Вишня,
	 * Груша и другие. С помощью конструктора автоматически установить номер каждого
	 * дерева. Принять решение о пересадке каждого дерева в зависимости от возраста
	 * и плодоношения.
	 **/
	public static void main(String[] args) {
		boolean inputCompleted = false;

		Scanner scan = new Scanner(System.in);
		ArrayList<GardenTree> tree_set = new ArrayList<>();

		while (!inputCompleted) {
			System.out.println("1-apple tree, 2-peer tree, 3-cherry tree");
			System.out.print("input tree type, or 0 for end input: ");
			int type = scan.nextInt();

			if (type != 0) {
				System.out.print("type tree number: ");
				int num = scan.nextInt();
				System.out.print("type tree age: ");
				float age = scan.nextFloat();
				System.out.print("type tree fruiting status (1-poor, 2-enough, 3-rich): ");
				int fr_status = scan.nextInt();
				FruitingStatus status = FruitingStatus.UNKNOWN;

				switch (fr_status) {
				case 1:
					status = FruitingStatus.POOR;
					break;
				case 2:
					status = FruitingStatus.ENOUGH;
					break;
				case 3:
					status = FruitingStatus.NICE;
					break;

				default:
					System.out.println("Unknown status");
					break;
				}

				switch (type) {

				case 1:
					tree_set.add(new AppleTree(num, age, status));
					break;

				case 2:
					tree_set.add(new PeerTree(num, age, status));
					break;

				case 3:
					tree_set.add(new CherryTree(num, age, status));
					break;

				default:
					System.out.println("Unknown command");
					break;
				}
			} else {
				System.out.println("You have got: ");
				tree_set.forEach((a) -> {
					System.out.println(a.toString());
				});
				inputCompleted = true;
			}

			System.out.println("-----");

		}
	}

}
