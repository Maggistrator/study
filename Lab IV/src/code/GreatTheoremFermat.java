package code;

import java.util.Scanner;

/**
 * Здание № 8
 * Создайте приложение, которое покажет, что для выражения a^n+b^n=c^n (теорема Ферма) нет натуральных решений от 1 до 100 и n>2. 
 * Убедитесь, что есть решения для n=2, и выведите их в консоль. 
 * */
public class GreatTheoremFermat {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Поиск решений для a^n+b^n=c^n.");
		int n;
		double c;
		int a, b;
		System.out.print("Пожалуйста, введите степень: "); n = scanner.nextInt();
		System.out.print("Теперь, потребуются числа a и b. Введите их через пробел: "); 
		
		a = scanner.nextInt(); 
		b = scanner.nextInt();
		
		System.out.println("a = "+a);
		System.out.println("b = "+b);
		
		//в задницу читабельность!
		//в задницу оптимизацию!
		//в задницу обработку исключений!
		
		if(n > 2 && a > 100 && b > 100) System.out.print("Решений не существует.");
		else {
			double pow_a = Math.pow(a, n);
			double pow_b = Math.pow(b, n);
			double cn = pow_a + pow_b;
			c = Math.pow(cn, (double)1/n);
			int control_shot = (int)Math.abs(c);
			if((double)(c - control_shot) == 0 && c > 0) System.out.println("Решения: +/- " + control_shot);
			else System.out.print("Решений не существует.");
		}
	}
	
	//Ферма - П*дор!
}
