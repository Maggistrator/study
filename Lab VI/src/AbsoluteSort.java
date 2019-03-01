import java.util.Scanner;

public class AbsoluteSort {
	/*
	 * 1) ¬вести массив из 10 целых чисел и отсортировать элементы по возрастанию
	 * абсолютного значени€. »спользовать класс Math.
	 * 
	 */
	public static void main(String[] args) {

		float[] arr = null;
		float dop;
		// ¬вод чисел в массив
		float absI;
		float absJ;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Type size of an array: ");
		int size = scanner.nextInt();
		arr = new float[size];
		
		for (int i = 0; i < arr.length; i++) {
			// проверка на корректность ввода
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					// тот же принцип, что и при вводе размера массива
					System.out.print("Num #" + (i + 1) + ": ");
					String data = scanner.nextLine();
					arr[i] = Float.parseFloat(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
		
		// сортировка массива
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				absI = Math.abs(arr[i]);
				absJ = Math.abs(arr[j]);
				if (absI > absJ) {
					dop = arr[i];
					arr[i] = arr[j];
					arr[j] = dop;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" | ");
		}

	}
}