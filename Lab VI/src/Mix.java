import java.util.Scanner;

public class Mix {
	/*
	 * 13) ������ ������ �� 15 ������������ �����, ����� ������������ � �����������
	 * �������� � �������� �� �������. ������������ ����� - ����� ���� � ���������
	 * ������
	 * 
	 */
	public static void main(String[] args) {

		double[] arr = new double[15];
		//����� MIN ���������� ������� ������ ��� ��� ������� ��������
		double min = Double.MAX_VALUE;
		double max = 0;
		double dop = 0;
		int minIndex = 0;
		int maxIndex = 0;
		// ���� ����� � ������
		Scanner scanner = new Scanner(System.in);
		
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

		System.out.println("swapping "+min+" and "+max);
		
		// ����� ������� ����������� � ������������ �������� � ������� ��� ����������
		dop = arr[minIndex];
		arr[minIndex] = arr[maxIndex];
		arr[maxIndex] = dop;
		System.out.println("--Resulting array--");
		for (int i = 0; i < arr.length; i++) System.out.println("arr[" + i + "]: " + arr[i]);
	}
}
