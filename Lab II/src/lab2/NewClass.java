package lab2;

//объ€вл€етс€ класс
class MyType {

	public int myData = 5; // переменна€-элемент класса
	
	//конструктор без параметров
	MyType() { 
		System.out.println("Constructor without parameters");
	}

	// конструктор с одним параметром
	MyType(int v) {

		System.out.print("Constructor with one parameter");

		System.out.println(" Setting myData=" + v);

		myData = v;

	}

	// метод класса
	public void myMethod() { 
		System.out.print("myMethod!");

		System.out.println(" myData=" + myData);
	}

}

// –еализаци€ объектов и действи€ с ними

public class NewClass { // первичный класс

	public static void main(String[] args) {

		// объект obj1 - реализаци€ класса MyType

		MyType obj1 = new MyType();

		obj1.myMethod(); // использование метода

		// доступ к открытой переменной

		System.out.println("---obj1.myData=" + obj1.myData);

		// объект obj2 - реализаци€ класса MyType

		MyType obj2 = new MyType(100);

		// доступ к открытой переменной
		System.out.println("----obj2.myData=" + obj2.myData);

	}

}