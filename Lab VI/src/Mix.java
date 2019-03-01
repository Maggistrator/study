import java.util.Scanner;

public class Mix {
	/*
	 * 13) ������ ������ �� 15 ������������ �����, ����� ������������ � �����������
	 * �������� � �������� �� �������. ������������ ����� - ����� ���� � ���������
	 * ������
	 * 
	 */
	public static void main(String[] args) {

		double[] arr;
		//����� MIN ���������� ������� ������ ��� ��� ������� ��������
		double min = Double.MAX_VALUE;
		double max = 0;
		double dop = 0;
		int minIndex = 0;
		int maxIndex = 0;
		// ���� ����� � ������
		Scanner scanner = new Scanner(System.in);
		System.out.print("Type size of an array: ");
		int size = scanner.nextInt();
		arr = new double[size];
		
		for (int i = 0; i < arr.length; i++) {
			// �������� �� ������������ �����
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					// ��� �� �������, ��� � ��� ����� ������� ������� � ������ �����
					System.out.print("arr [" + (i + 1) + "]: ");
					String data = scanner.nextLine();
					arr[i] = Double.parseDouble(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
			// ��� �������� �� ���� ���������� ������� ��� ������������ � �����������
			// �������� (��� ���� ������ ��� ���������� ��� �� �� �������� �������)
			if (arr[i] < min) {
				min = arr[i];
				minIndex = i;
			}
			if (arr[i] > max) {
				max = arr[i];
				maxIndex = i;
			}
		}

		// ����� ������� ����������� � ������������ �������� � ������� ��� ����������
		dop = arr[minIndex];
		arr[minIndex] = arr[maxIndex];
		arr[maxIndex] = dop;
		System.out.println("--Resulting array--");
		for (int i = 0; i < arr.length; i++) System.out.println("arr[" + i + "]: " + arr[i]);
	}
}
