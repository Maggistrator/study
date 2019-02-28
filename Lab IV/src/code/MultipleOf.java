package code;

import java.util.Scanner;

public class MultipleOf {
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		int lastMultiple3Index = 0;
		int lastMultiple9Index = 0;
		
		// ������� �� 3
		System.out.println("������ 9:");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 9 == 0)
				if(i == lastMultiple9Index) System.out.println(arr[i]+"\n"); 
				else System.out.println(arr[i]+","); 
		}

		//������� �� 3
		System.out.println("������ 3-�, �� �� ������ 9:");
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 3 == 0) 
				if (arr[i] % 9 != 0)
					if(i == lastMultiple9Index) System.out.println(arr[i]+"\n"); 
					else System.out.println(arr[i]+",");  
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
