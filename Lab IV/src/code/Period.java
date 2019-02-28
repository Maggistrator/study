package code;

import java.util.Scanner;

/**
 * 12. ������ � ������� n ����� ����� � ��������� �� � ������. �� �������
 * ������� ������ ���������� ����� � = m/n, ��� ������ ���� ����� �������������
 * ����� n � m, ������������� ������.
 */
public class Period {

	private static final int ERROR_CODE = -1;

	private static int m, n;
	private static int[] ostatki;
	private static int[] period;
	private static int len;

	// �������� ��������
	static int IsInOstatki(int ost, int len) {
		// len-1 ���� �� ��������� �������, ������� �� ������� ����
		for (int i = 0; i < len - 1; i++) {
			if (ostatki[i] == ost)
				return i;
		}
		
		return 0;
	}

	public static void main(String[] args) {
		int ans = ERROR_CODE;
		int[] arr = new int[enterArrayLenght()];
		fillArrayWithScanner(arr);

		Scanner scan = new Scanner(System.in);

		System.out.println("Vvedite chislitel drobi:");
		m = scan.nextInt();
		System.out.println("nvvedite znamenatel drobi:");
		n = scan.nextInt();

		ostatki = new int[n + 1];
		period = new int[n + 1];

		int d = m, q = n;
		int r, pos;
		len = 1;
		do {
			r = d % q;
			ostatki[len] = r;
			d /= q;
			period[len] = d;

			d = 10 * r;
			len++;
		} while ((pos = IsInOstatki(r, len)) == 0);

		// ����� �����������
		System.out.print("drob= ");
		System.out.print(period[1] + ",");
		for (r = 2; r < len; r++) {
			System.out.print(period[r]);
		}

		System.out.print("\nperiod= ");
		for (r = pos + 1; r < len; r++)
			System.out.print(period[r]);

		System.out.print("\r\n");

	}

	// ----

	/**
	 * ���� ����� ������� � ��������� �� ������������ ��������
	 */
	private static int enterArrayLenght() {
		// ������ ������������ ������ �����
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
				if (arr_lenght == 0)
					throw new Exception("Array lenght should not be 0!");
				if (arr_lenght < 0)
					throw new Exception("Array lenght should be greater than 0!");
				isLenghtDefined = true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}

		return arr_lenght;
	}

	/**
	 * ���������� �������
	 * 
	 * @param arr ������, ������� ������� ���������
	 */
	private static void fillArrayWithScanner(int[] arr) {
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			// �������� �� ������������ �����
			boolean numIsCorrect = false;
			while (!numIsCorrect) {
				try {
					// ��� �� �������, ��� � ��� ����� ������� �������
					System.out.print("Num #" + (i + 1) + ": ");
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
