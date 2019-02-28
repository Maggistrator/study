package lab2;

//����������� �����
class MyType {

	public int myData = 5; // ����������-������� ������
	
	//����������� ��� ����������
	MyType() { 
		System.out.println("Constructor without parameters");
	}

	// ����������� � ����� ����������
	MyType(int v) {

		System.out.print("Constructor with one parameter");

		System.out.println(" Setting myData=" + v);

		myData = v;

	}

	// ����� ������
	public void myMethod() { 
		System.out.print("myMethod!");

		System.out.println(" myData=" + myData);
	}

}

// ���������� �������� � �������� � ����

public class NewClass { // ��������� �����

	public static void main(String[] args) {

		// ������ obj1 - ���������� ������ MyType

		MyType obj1 = new MyType();

		obj1.myMethod(); // ������������� ������

		// ������ � �������� ����������

		System.out.println("---obj1.myData=" + obj1.myData);

		// ������ obj2 - ���������� ������ MyType

		MyType obj2 = new MyType(100);

		// ������ � �������� ����������
		System.out.println("----obj2.myData=" + obj2.myData);

	}

}