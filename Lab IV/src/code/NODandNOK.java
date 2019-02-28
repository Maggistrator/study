package code;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 	������� 4
 *  ������ � ������� n ����� ����� � ��������� �� � ������. �� ������� ������� ���������� ����� �������� � ���������� ����� ������� ���� �����. 
 * */
public class NODandNOK {
	
	public static void main(String[] args) {
		long NOD = -1;
		long NOK = -1;
		
		//���������� �������
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);
		
		ArrayList<Long> nodCrutch = new ArrayList<>();
		for (int kek : arr) nodCrutch.add((long) kek);
		
		ArrayList<Long> nokCrutch = new ArrayList<>(nodCrutch);
		
		while(nodCrutch.size() > 1) {
			nodCrutch.set(0, NOD(nodCrutch.get(0), nodCrutch.get(1)));
			nodCrutch.remove(1);
			NOD = nodCrutch.get(0);
		}
		
		System.out.println("--------");
		
		while(nokCrutch.size() > 1) {
			nokCrutch.set(0, NOK(nokCrutch.get(0), nokCrutch.get(1)));
			nokCrutch.remove(1);
			NOK = nokCrutch.get(0);
		}
		
		System.out.println("NOD is: "+ NOD);
		System.out.println("NOK is: "+ NOK);
	}
	
	/**
	 * ����������� ������� �� ��������� �������
	 * <br><b>p.s.</b> �������� � ����� <a href="http://kesh.kz/blog/%D0%BD%D0%BE%D0%BA-%D0%B8-%D0%BD%D0%BE%D0%B4-lcm-%D0%B8-gcd-%D0%BD%D0%B0-java/">Naik's blog</a>
	 * @param a ������ �����
	 * @param b ������ �����
	 * @return ���������� ����� �������
	 * */
	private static long NOD(long a, long b){
		return b == 0 ? a : NOD(b,a % b);		
	}
	
	
	/**
	 * �������, ������������ ���, ��� ������ ���
	 * <br><b>p.s.</b> �������� ������ ��, ������ � {@link code.NODandNOK#NOD NOD}
	 * @param a ������ �����
	 * @param b ������ �����
	 * @return ���������� ����� �������
	 */
	private static long NOK(long a, long b){
		return a / NOD(a,b) * b;
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
