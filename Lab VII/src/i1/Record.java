package i1;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Record implements Serializable{
	private static final long serialVersionUID = -774379918479013354L;
	
	int ID;
	Date date;
	String phone_number;
	int talktime;
	
	public static Record createInstance() {
		System.out.println("---Ввод записи в стек---");
		Scanner scanner = new Scanner(System.in);
		Record record = new Record();
		
		boolean isCorrect = false;
		
		while(!isCorrect) {		
			//Ввод даты
			try {
				DateFormat formatter = new SimpleDateFormat("dd.MM.yy");
				System.out.print("Введите дату: ");
				String dateString = scanner.nextLine();
				record.date = formatter.parse(dateString);
			} catch (ParseException e) {
				System.err.println("Ошибка парсинга даты!");
				continue;
			}
			
			//Номер телефона
			System.out.print("Введите номер телефона: ");
			record.phone_number = scanner.nextLine();

			//Время разговора
			try {
				System.out.print("Введите время разговора (в мин.): ");
				record.talktime = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.err.println("Ошибка! Данные в неверном формате!");
				continue;
			}
			isCorrect = true;
		}
		
		return record;
	}
	
	@Override
	public String toString() {
		return "Дата: "+date
				+", номер телефона: "+phone_number
				+", время разговора: "+talktime+" мин."; 
	}
}