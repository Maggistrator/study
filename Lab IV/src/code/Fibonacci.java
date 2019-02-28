package code;

import java.util.Scanner;

/*
 * Задание № 10
 * Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести числа Фибоначчи: f0 = f1 = 1, f (n) = f (n-1) + f (n-2). 
 * */
public class Fibonacci {
	
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		System.out.print("Числа Фибоначчи в вашем массиве: ");
		printFibonacciNums(arr);
	}
	
	private static void printFibonacciNums(int[] arr){
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == arr[i-2] + arr[i - 1]) { 
				System.out.print(arr[i] + " ");
			}
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
