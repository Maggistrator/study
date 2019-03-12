package view;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Record;

public class MainWindow {
	
	private JFrame frame = new JFrame("Реестр телефонных звонков");
	Stack<Record> stack = new Stack<Record>();
	
	public void createUI() {
		frame.setSize(300, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane pain = new JTabbedPane();// это не опечатка
		pain.add("Создать", new RecordRegistrationPanel(frame, stack));
		pain.add("Стек", new JPanel());
		pain.add("Поиск", new JPanel());
		
		frame.add(pain);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
