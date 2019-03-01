import java.util.Scanner;

public class Mix {
	/*
	 * 13) Ввести массив из 15 вещественных чисел, найти максимальный и минимальный
	 * элементы и поменять их местами. вещественные числа - числа типа с плавающей
	 * точкой
	 * 
	 */
	public static void main(String[] args) {

		double[] arr;
		//чтобы MIN заменилось меньшим числом даём ему большое значение
		double min = Double.MAX_VALUE;
		double max = 0;
		double dop = 0;
		int minIndex = 0;
		int maxIndex = 0;
		// Ввод чисел в массив
		Scanner scanner = new Scanner(System.in);
		System.out.print("Type size of an array: ");
		int size = scanner.nextInt();
		arr = new double[size];
		
		for (int i = 0; i < arr.length; i++) {
			// проверка на корректность ввода
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					// тот же принцип, что и при вводе размера массива в других лабах
					System.out.print("arr [" + (i + 1) + "]: ");
					String data = scanner.nextLine();
					arr[i] = Double.parseDouble(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			// Тут вычисляю по мере заполнения массива его максимальное и минимальное
			// значения (при этом создал доп переменные что бы не потерять индексы)
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}

		// Смена местами минимальное и максимальное значение с помощью доп переменной
		dop = arr[minIndex];
		arr[minIndex] = arr[maxIndex];
		arr[maxIndex] = dop;
		System.out.println("--Resulting array--");
		for (int i = 0; i < arr.length; i++) System.out.println("arr[" + i + "]: " + arr[i]);
	}
}
