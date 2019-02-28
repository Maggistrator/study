package code;

import java.util.Scanner;

/*
 * ������� � 10
 * ������ � ������� n ����� ����� � ��������� �� � ������. �� ������� ������� ����� ���������: f0 = f1 = 1, f (n) = f (n-1) + f (n-2). 
 * */
public class Fibonacci {
	
	public static void main(String[] args) {
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		System.out.print("����� ��������� � ����� �������: ");
		printFibonacciNums(arr);
	}
	
	private static void printFibonacciNums(int[] arr){
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == arr[i-2] + arr[i - 1]) { 
				System.out.print(arr[i] + " ");
			}
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
