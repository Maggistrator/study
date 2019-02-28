package code;

import java.util.Scanner;

/**
 * Задание № 7
 * Для произвольной цифры от 0 до 9 вывести на консоль ее значение прописью. Например, для цифры 9 на консоли должна быть напечатана строка «Девять».
 * */
public class NumbersInWords {
	
	//Код ошибки
	private static final byte ERROR_CODE = -1;
	//словарь строковых значений
	private static final String[] dictionary = {"ноль", "один", "два", "три", "четыре", "пять",
												"шесть", "семь", "восемь", "девять"};
	public static void main(String[] args) {
		System.out.println("Enter a number from 0 to 9, to get it's string representation;");
		Scanner scanner = new Scanner(System.in);
		//число по-умолчанию некорректно, чтобы последний рубеж поиска ошибок остановил неверное выполнение программы
		byte num = ERROR_CODE; 
		
		//блок ввода числа
		boolean numIsCorrect = false;
		while (!numIsCorrect) {
			System.out.print("Num: ");
			try {
				String data = scanner.nextLine();
				//число должно быть целым, ошибку можно определить по формату ввода
				if(data.contains(",")||data.contains(".")) throw new Exception("Input value must be integer!");
				num = Byte.parseByte(data);
				// По заданию число не может превышать 9 или быть меньше 0
				if (num > 9) throw new Exception("Input value must not exceed 9!");
				if (num < 0) throw new Exception("Input value must be greater than 0!");
				numIsCorrect = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//число подставляется как индекс массива с соответствующим строковым значением
		
		
		
		
		
		
		
		
		
		
		
		if(num != ERROR_CODE) System.out.println("Number "+num+" is '"+dictionary[num]+"'");
		else System.err.println("Моя система обработки исключений - говно.");
	}
}
