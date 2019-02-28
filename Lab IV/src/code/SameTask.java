package code;

import java.util.Scanner;

/**
 * ������� � 3
 * ������ � ������� n ����� ����� � ��������� �� � ������. �� ������� ������� �����, ������� ������� �� 5 ��� �� 10.
 * */
public class SameTask {
	
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		int lastMultiple5Index = 0;
		int lastMultiple10Index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 5 == 0 && arr[i] % 10 != 0) lastMultiple5Index = i;
			if(arr[i] % 10 == 0) lastMultiple10Index = i;
		}
		
		// ������� �� 9
		System.out.println("������ 10:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 10 == 0)
				if(i == lastMultiple10Index) System.out.print(arr[i]+"\n"); 
				else System.out.print(arr[i]+","); 
		}

		// ������� �� 3
		System.out.println("������ 5, �� �� ������ 10:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 5 == 0 && arr[i] % 10 != 0)
				if (i == lastMultiple5Index) System.out.print(arr[i] + "\n");
				else System.out.print(arr[i] + ",");
		}
	}

	/**
	 * ���� ����� ������� � ��������� �� ������������ ��������
	 * */
	private static int enterArrayLenght() {
		//������ ������������ ������ �����
		Scanner scanner = new Scanner(System.in);
		int arr_lenght = 0;
		boolean isLenghtDefined = false;
		System.out.print("Enter array lenght: ");
		// ��������� �������� �� ���������� ����
		while (!isLenghtDefined) {
			try {
				// ���� ������� �������
				arr_lenght = Integer.parseInt(scanner.nextLine());

				// ����� ������� �� ����� ���� �������������, ��� �������
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
	 * ���������� �������
	 * @param arr ������, ������� ������� ���������
	 * */
	private static void fillArrayWithScanner(int[] arr) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			//�������� �� ������������ �����
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					//��� �� �������, ��� � ��� ����� ������� �������
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
