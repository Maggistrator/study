import java.util.Arrays;
import java.util.Scanner;

/**
 * 14) Ввести массив из 10 вещественных чисел, округлить до целых и отсортировать в порядке возрастания. 
 * */
public class AutistSort {
	public static void main(String[] args) {
		float[] arr = new float[10];
		fillArrayWithScanner(arr);
		Arrays.sort(arr);
		for(float val: arr) System.out.println("~ "+val);
	}
	
	/**
	 * Заполнение массива
	 * @param arr массив, который следует заполнить
	 * */
	private static void fillArrayWithScanner(float[] arr) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			//проверка на корректность ввода
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					//тот же принцип, что и при вводе размера массива
					System.out.print("Num #"+(i+1)+": ");
					String data = scanner.nextLine();
					
					//гениальное округление, через автопарс в int
					arr[i] = (int)Float.parseFloat(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

}
