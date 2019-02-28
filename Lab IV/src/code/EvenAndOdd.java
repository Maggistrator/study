package code;

import java.util.Scanner;

/** Задание № 1 */
public class EvenAndOdd {

	public static void main(String[] args) {
		// Сканер стандартного потока ввода
		Scanner scanner = new Scanner(System.in);		
		// размер и экземпляр массива
		int arr_lenght = 0;
		int[] arr;
		
		// ввод размера массива
		boolean isLenghtDefined = false;
		System.out.print("Enter array lenght: ");
		
		//цикл, который при вводе неверного значения позволит ввести что-то заново
		while (!isLenghtDefined) {
			try {
				//парсинг String, в отличие от nextInt() вбрасывает исключения
				arr_lenght = Integer.parseInt(scanner.nextLine());

				// длина массива не может быть отрицательной, или нулевой
				if (arr_lenght == 0) throw new Exception("Array lenght should not be 0!");
				if (arr_lenght < 0) throw new Exception("Array lenght should be greater than 0!");
				
				//если не вброшено исключение, цикл прекращается
				isLenghtDefined = true;
			} catch (Exception e) {
				//вывод сообщения ошибки без данных стека
				System.err.println(e.getMessage());
			}
		}

		//индекс последнего чётного и последнего нечётного значения
		int lastEvenIndex = 0, lastOddIndex = 0;
		arr = new int[arr_lenght];
		
		// заполнение массива с клавиатуры
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter num: ");
			arr[i] = scanner.nextInt();
			if(arr[i] % 2 == 0) lastEvenIndex = i; else lastOddIndex = i; 
		}

		//вывод всех нечётных значений
		System.out.println("---Even numbers---");
		for (int i = 0; i < arr.length; i++) {
			//символ-разделитель
			String comma = i != lastOddIndex ? ", " : "\n";
			//собственно, вывод
			if (arr[i] % 2 != 0) System.out.print(arr[i] + comma);
		}

		//вывод всех четных значений, по аналогии с нечётными
		System.out.println("----Odd numbers---");
		for (int i = 0; i < arr.length; i++) {
			String comma = i != lastEvenIndex ? ", " : "\n ";
			//p.s. отличается только условие
			if (arr[i] % 2 == 0) System.out.print(arr[i] + comma);
		}
	}

}
