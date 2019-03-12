package view;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import model.Record;

public class MainWindow {
	
	private JFrame frame = new JFrame("������ ���������� �������");
	Stack<Record> stack = new Stack<Record>();
	
	public void createUI() {
		frame.setSize(300, 256);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane pain = new JTabbedPane();// ��� �� ��������
		pain.add("�������", new RecordRegistrationPanel(frame, stack));
		pain.add("����", new JPanel());
		pain.add("�����", new JPanel());
		
		frame.add(pain);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}
