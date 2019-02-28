package code;

import java.util.Scanner;

/**
 * ������� � 7
 * ��� ������������ ����� �� 0 �� 9 ������� �� ������� �� �������� ��������. ��������, ��� ����� 9 �� ������� ������ ���� ���������� ������ ��������.
 * */
public class NumbersInWords {
	
	//��� ������
	private static final byte ERROR_CODE = -1;
	//������� ��������� ��������
	private static final String[] dictionary = {"����", "����", "���", "���", "������", "����",
												"�����", "����", "������", "������"};
	public static void main(String[] args) {
		System.out.println("Enter a number from 0 to 9, to get it's string representation;");
		Scanner scanner = new Scanner(System.in);
		//����� ��-��������� �����������, ����� ��������� ����� ������ ������ ��������� �������� ���������� ���������
		byte num = ERROR_CODE; 
		
		//���� ����� �����
		boolean numIsCorrect = false;
		while (!numIsCorrect) {
			System.out.print("Num: ");
			try {
				String data = scanner.nextLine();
				//����� ������ ���� �����, ������ ����� ���������� �� ������� �����
				if(data.contains(",")||data.contains(".")) throw new Exception("Input value must be integer!");
				num = Byte.parseByte(data);
				// �� ������� ����� �� ����� ��������� 9 ��� ���� ������ 0
				if (num > 9) throw new Exception("Input value must not exceed 9!");
				if (num < 0) throw new Exception("Input value must be greater than 0!");
				numIsCorrect = true;
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		//����� ������������� ��� ������ ������� � ��������������� ��������� ���������
		
		
		
		
		
		
		
		
		
		
		
		if(num != ERROR_CODE) System.out.println("Number "+num+" is '"+dictionary[num]+"'");
		else System.err.println("��� ������� ��������� ���������� - �����.");
	}
}
