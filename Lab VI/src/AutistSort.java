import java.util.Arrays;
import java.util.Scanner;

/**
 * 14) ������ ������ �� 10 ������������ �����, ��������� �� ����� � ������������� � ������� �����������. 
 * */
public class AutistSort {
	public static void main(String[] args) {
		float[] arr = new float[10];
		fillArrayWithScanner(arr);
		Arrays.sort(arr);
		for(float val: arr) System.out.println("~ "+val);
	}
	
	/**
	 * ���������� �������
	 * @param arr ������, ������� ������� ���������
	 * */
	private static void fillArrayWithScanner(float[] arr) {
		Scanner scanner = new Scanner(System.in);
		
		for (int i = 0; i < arr.length; i++) {
			//�������� �� ������������ �����
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					//��� �� �������, ��� � ��� ����� ������� �������
					System.out.print("Num #"+(i+1)+": ");
					String data = scanner.nextLine();
					
					//���������� ����������, ����� �������� � int
					arr[i] = (int)Float.parseFloat(data);
					numIsCorrect = true;
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}

}
