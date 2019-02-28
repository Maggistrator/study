import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Task1 {
	
	static ArrayList<Record> list = new ArrayList<Record>();
	
	private static class Record{
		Date date;
		String phone_number;
		int talktime;
		
		@Override
		public String toString() {
			return "Дата: "+date
					+", номер телефона: "+phone_number
					+", время разговора: "+talktime+" мин."; }
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) list.add(createRecord());
		for (Record rec: list) System.out.print(rec.toString()+"\n");
	}

	private static Record createRecord() {
		System.out.println("---Ввод записи в стек---");
		Scanner scanner = new Scanner(System.in);
		Record record = new Record();

		try {
			DateFormat formatter = new SimpleDateFormat("MM.dd.yy");
			System.out.print("Введите дату: ");
			String dateString = scanner.nextLine();
			record.date = formatter.parse(dateString);
		} catch (ParseException e) {
		  System.err.println("Ошибка парсинга даты!");
		}
		
		System.out.print("Введите номер телефона: ");
		record.phone_number = scanner.nextLine();
		
		try {			
			System.out.print("Введите время разговора (в мин.): ");
			record.talktime = Integer.parseInt(scanner.nextLine());
		} catch (Exception e) {
			System.err.println("Ошибка! Данные в неверном формате!");
		}
		
		return record;
	}
	
}
