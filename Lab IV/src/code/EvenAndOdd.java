package code;

import java.util.Scanner;

/** ������� � 1 */
public class EvenAndOdd {

	public static void main(String[] args) {
		// ������ ������������ ������ �����
		Scanner scanner = new Scanner(System.in);		
		// ������ � ��������� �������
		int arr_lenght = 0;
		int[] arr;
		
		// ���� ������� �������
		boolean isLenghtDefined = false;
		System.out.print("Enter array lenght: ");
		
		//����, ������� ��� ����� ��������� �������� �������� ������ ���-�� ������
		while (!isLenghtDefined) {
			try {
				//������� String, � ������� �� nextInt() ���������� ����������
				arr_lenght = Integer.parseInt(scanner.nextLine());

				// ����� ������� �� ����� ���� �������������, ��� �������
				if (arr_lenght == 0) throw new Exception("Array lenght should not be 0!");
				if (arr_lenght < 0) throw new Exception("Array lenght should be greater than 0!");
				
				//���� �� �������� ����������, ���� ������������
				isLenghtDefined = true;
			} catch (Exception e) {
				//����� ��������� ������ ��� ������ �����
				System.err.println(e.getMessage());
			}
		}

		//������ ���������� ������� � ���������� ��������� ��������
		int lastEvenIndex = 0, lastOddIndex = 0;
		arr = new int[arr_lenght];
		
		// ���������� ������� � ����������
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter num: ");
			arr[i] = scanner.nextInt();
			if(arr[i] % 2 == 0) lastEvenIndex = i; else lastOddIndex = i; 
		}

		//����� ���� �������� ��������
		System.out.println("---Even numbers---");
		for (int i = 0; i < arr.length; i++) {
			//������-�����������
			String comma = i != lastOddIndex ? ", " : "\n";
			//����������, �����
			if (arr[i] % 2 != 0) System.out.print(arr[i] + comma);
		}

		//����� ���� ������ ��������, �� �������� � ���������
		System.out.println("----Odd numbers---");
		for (int i = 0; i < arr.length; i++) {
			String comma = i != lastEvenIndex ? ", " : "\n ";
			//p.s. ���������� ������ �������
			if (arr[i] % 2 == 0) System.out.print(arr[i] + comma);
		}
	}

}
