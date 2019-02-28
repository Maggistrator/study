package code;

import java.util.Scanner;

/**
 * ������ � 8
 * �������� ����������, ������� �������, ��� ��� ��������� a^n+b^n=c^n (������� �����) ��� ����������� ������� �� 1 �� 100 � n>2. 
 * ���������, ��� ���� ������� ��� n=2, � �������� �� � �������. 
 * */
public class GreatTheoremFermat {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("����� ������� ��� a^n+b^n=c^n.");
		int n;
		double c;
		int a, b;
		System.out.print("����������, ������� �������: "); n = scanner.nextInt();
		System.out.print("������, ����������� ����� a � b. ������� �� ����� ������: "); 
		
		a = scanner.nextInt(); 
		b = scanner.nextInt();
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		//� ������� �������������!
		//� ������� �����������!
		//� ������� ��������� ����������!
		
		if(n > 2 && a > 100 && b > 100) System.out.print("������� �� ����������.");
		else {
			double pow_a = Math.pow(a, n);
			double pow_b = Math.pow(b, n);
			double cn = pow_a + pow_b;
			c = Math.pow(cn, (double)1/n);
			int control_shot = (int)Math.abs(c);
			if((double)(c - control_shot) == 0 && c > 0) System.out.println("�������: +/- " + control_shot);
			else System.out.print("������� �� ����������.");
		}
	}
	
	//����� - �*���!
}
