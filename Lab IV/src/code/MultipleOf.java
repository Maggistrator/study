package code;

import java.util.Scanner;

public class MultipleOf {
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		int lastMultiple3Index = 0;
		int lastMultiple9Index = 0;
		
		// делится на 3
		System.out.println("Кратно 9:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 9 == 0)
				if(i == lastMultiple9Index) System.out.println(arr[i]+"\n"); 
				else System.out.println(arr[i]+","); 
		}

		//делится на 3
		System.out.println("Кратно 3-м, но не кратно 9:");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 3 == 0) 
				if (arr[i] % 9 != 0)
					if(i == lastMultiple9Index) System.out.println(arr[i]+"\n"); 
					else System.out.println(arr[i]+",");  
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
