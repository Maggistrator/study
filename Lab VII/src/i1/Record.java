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
		System.out.println("---���� ������ � ����---");
		Scanner scanner = new Scanner(System.in);
		Record record = new Record();
		
		boolean isCorrect = false;
		
		while(!isCorrect) {		
			//���� ����
			try {
				DateFormat formatter = new SimpleDateFormat("dd.MM.yy");
				System.out.print("������� ����: ");
				String dateString = scanner.nextLine();
				record.date = formatter.parse(dateString);
			} catch (ParseException e) {
				System.err.println("������ �������� ����!");
				continue;
			}
			
			//����� ��������
			System.out.print("������� ����� ��������: ");
			record.phone_number = scanner.nextLine();

			//����� ���������
			try {
				System.out.print("������� ����� ��������� (� ���.): ");
				record.talktime = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				System.err.println("������! ������ � �������� �������!");
				continue;
			}
			isCorrect = true;
		}
		
		return record;
	}
	
	@Override
	public String toString() {
		return "����: "+date
				+", ����� ��������: "+phone_number
				+", ����� ���������: "+talktime+" ���."; 
	}
}