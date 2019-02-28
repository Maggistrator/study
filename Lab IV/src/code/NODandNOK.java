package code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 	Задание 4
 *  Ввести с консоли n целых чисел и поместить их в массив. На консоль вывести наибольший общий делитель и наименьшее общее кратное этих чисел. 
 * */
public class NODandNOK {
	
	public static void main(String[] args) {
		long NOD = -1;
		long NOK = -1;
		
		//заполнение массива
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		ArrayList<Long> nodCrutch = new ArrayList<>();
		for (int kek : arr) nodCrutch.add((long) kek);
		
		ArrayList<Long> nokCrutch = new ArrayList<>(nodCrutch);
		
		while(nodCrutch.size() > 1) {
			nodCrutch.set(0, NOD(nodCrutch.get(0), nodCrutch.get(1)));
			nodCrutch.remove(1);
			NOD = nodCrutch.get(0);
		}
		
		System.out.println("--------");
		
		while(nokCrutch.size() > 1) {
			nokCrutch.set(0, NOK(nokCrutch.get(0), nokCrutch.get(1)));
			nokCrutch.remove(1);
			NOK = nokCrutch.get(0);
		}
		
		System.out.println("NOD is: "+ NOD);
		System.out.println("NOK is: "+ NOK);
	}
	
	/**
	 * рекурсивная функция по алгоритму Евклида
	 * <br><b>p.s.</b> украдено с сайта <a href="http://kesh.kz/blog/%D0%BD%D0%BE%D0%BA-%D0%B8-%D0%BD%D0%BE%D0%B4-lcm-%D0%B8-gcd-%D0%BD%D0%B0-java/">Naik's blog</a>
	 * @param a первое число
	 * @param b второе число
	 * @return наименьшее общее кратное
	 * */
	private static long NOD(long a, long b){
		return b == 0 ? a : NOD(b,a % b);		
	}
	
	
	/**
	 * функция, использующая НОД, для поиска НОК
	 * <br><b>p.s.</b> украдено оттуда же, откуда и {@link code.NODandNOK#NOD NOD}
	 * @param a первое число
	 * @param b второе число
	 * @return наименьшее общее кратное
	 */
	private static long NOK(long a, long b){
		return a / NOD(a,b) * b;
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
