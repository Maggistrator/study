import java.util.Scanner;

public class Matrix {
	/*
	 * 5) ������ ��������� ������� 3 �� 3 � ��������� ������������. �������� �
	 * ������������ �����. ������������ ����� - ����� ���� � ��������� ������
	 */
	public static void main(String[] args) {

		double[][] arr = new double[3][3];
		double determinant;
		// ���� ����� � ������
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				// �������� �� ������������ �����
				boolean numIsCorrect = false;
				while (!numIsCorrect) {
					try {
						// ��� �� �������, ��� � ��� ����� ������� �������
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
		// ������������ ������� 3�3 = a11�a22�a33 + a12�a23�a31 + a13�a21�a32 -
		// a13�a22�a31 - a11�a23�a32 - a12�a21�a33
		determinant = arr[0][0] * arr[1][1] * arr[2][2] + arr[0][1] * arr[1][2] * arr[2][0]
				+ arr[0][2] * arr[1][0] * arr[2][1] - arr[0][2] * arr[1][1] * arr[2][0]
				- arr[0][0] * arr[1][2] * arr[2][1] - arr[0][1] * arr[1][0] * arr[2][2];
		System.out.println("Detrminant is: " + determinant);

	}
}
