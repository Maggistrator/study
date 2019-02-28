package code;

import java.util.Scanner;

/**
 * Задание № 3
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести числа, которые делятся на 5 или на 10.
 * */
public class SameTask {
	
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		int lastMultiple5Index = 0;
		int lastMultiple10Index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 5 == 0 && arr[i] % 10 != 0) lastMultiple5Index = i;
			if(arr[i] % 10 == 0) lastMultiple10Index = i;
		}
		
		// делится на 9
		System.out.println("Кратно 10:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 10 == 0)
				if(i == lastMultiple10Index) System.out.print(arr[i]+"\n"); 
				else System.out.print(arr[i]+","); 
		}

		// делится на 3
		System.out.println("Кратно 5, но не кратно 10:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] % 10 != 0)
				if (i == lastMultiple5Index) System.out.print(arr[i] + "\n");
				else System.out.print(arr[i] + ",");
		}
	}

	/**
	 * Ввод длины массива с проверкой на недопустимые значения
	 * */
	private static int enterArrayLenght() {
		//Сканер стандартного потока ввода
		Scanner scanner = new Scanner(System.in);
		int arr_lenght = 0;
		boolean isLenghtDefined = false;
		System.out.print("Enter array lenght: ");
		// цикличная проверка на корректный ввод
		while (!isLenghtDefined) {
			try {
				// ввод размера массива
				arr_lenght = Integer.parseInt(scanner.nextLine());

				// длина массива не может быть отрицательной, или нулевой
				if (arr_lenght == 0) throw new Exception("Array lenght should not be 0!");
				if (arr_lenght < 0) throw new Exception("Array lenght should be greater than 0!");
				isLenghtDefined = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		return arr_lenght;
	}
	
	/**
	 * Заполнение массива
	 * @param arr массив, который следует заполнить
	 * */
	private static void fillArrayWithScanner(int[] arr) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			//проверка на корректность ввода
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					//тот же принцип, что и при вводе размера массива
					System.out.print("Num #"+(i+1)+": ");
					String data = scanner.nextLine();
					arr[i] = Integer.parseInt(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

}
