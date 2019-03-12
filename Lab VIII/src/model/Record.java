package model;

import java.io.Serializable;
import java.util.Date;

public class Record implements Serializable{
	private static final long serialVersionUID = -774379918479013354L;
	
	int ID;
	Date date;
	String phone_number;
	int talktime;
	
	public Record(int ID, Date date, String phone_number, int talktime) {
		this.ID = ID; 
		this.date = date;
		this.phone_number = phone_number;
		this.talktime = talktime;
	}
		
	@Override
	public String toString() {
		return "Дата: "+date
				+", номер телефона: "+phone_number
				+", время разговора: "+talktime+" мин."; 
	}
}