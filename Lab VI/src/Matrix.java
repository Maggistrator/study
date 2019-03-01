import java.util.Scanner;

public class Matrix {
	/*
	 * 5) ¬вести двумерную матрицу 3 на 3 и вычислить определитель. Ёлементы Ц
	 * вещественные числа. вещественные числа - числа типа с плавающей точкой
	 */
	public static void main(String[] args) {

		double[][] arr = new double[3][3];
		double determinant;
		// ¬вод чисел в массив
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// проверка на корректность ввода
				boolean numIsCorrect = false;
				while (!numIsCorrect) {
					try {
						// тот же принцип, что и при вводе размера массива
						System.out.print("arr [" + (i + 1) + "][" + (j + 1) + "]: ");
						String data = scanner.nextLine();
						arr[i][j] = Double.parseDouble(data);
						numIsCorrect = true;
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
			}
		}
		// ќпределитель матрицы 3х3 = a11Јa22Јa33 + a12Јa23Јa31 + a13Јa21Јa32 -
		// a13Јa22Јa31 - a11Јa23Јa32 - a12Јa21Јa33
		determinant = arr[0][0] * arr[1][1] * arr[2][2] + arr[0][1] * arr[1][2] * arr[2][0]
				+ arr[0][2] * arr[1][0] * arr[2][1] - arr[0][2] * arr[1][1] * arr[2][0]
				- arr[0][0] * arr[1][2] * arr[2][1] - arr[0][1] * arr[1][0] * arr[2][2];
		System.out.println("Detrminant is: " + determinant);

	}
}
