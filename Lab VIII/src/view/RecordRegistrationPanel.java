package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import controller.RecordRegistrator;
import controller.RecordSerialiser;
import model.Record;

public class RecordRegistrationPanel extends JPanel {
	
	private Stack<Record> stack; 
	
	File REGISTRY_FILE = new File("src/model/data/registry.xml");
	public static final String PATH = "src/model/data/";
	public static final int FIELD_WIDTH = 200;
	public static final int FIELD_HEIGHT = 25;
	
	private final int mother_bucking_gap = 25;
	private final int fields_gap = 10;
	
	private JTextField ID = new JTextField();
	private JTextField dateField;
	private JTextField phoneNumberField;
	
	public RecordRegistrationPanel(JFrame container, Stack<Record> data) {
		this.stack = data;
		setLayout(null);
		ID.setLocation((container.getWidth()-FIELD_WIDTH)/2, mother_bucking_gap);
		ID.setSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
		
		JLabel id_label = new JLabel("ID:");
		id_label.setLocation(ID.getX(), ID.getY()-FIELD_HEIGHT);
		id_label.setSize(100, 30); 
		id_label.setForeground(Color.gray);

		dateField = new JTextField();
		dateField.setSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
		dateField.setLocation((container.getWidth()-FIELD_WIDTH)/2, mother_bucking_gap+FIELD_HEIGHT*2);
		
		JLabel date_label = new JLabel("Date:");
		date_label.setLocation(dateField.getX(), dateField.getY()-FIELD_HEIGHT);
		date_label.setSize(100, 30); 
		date_label.setForeground(Color.gray);
		
		phoneNumberField = new JTextField();		
		phoneNumberField.setSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
		phoneNumberField.setLocation((container.getWidth()-FIELD_WIDTH)/2, mother_bucking_gap+FIELD_HEIGHT*4);

		JLabel phone_label = new JLabel("Phone:");
		phone_label.setLocation(phoneNumberField.getX(), phoneNumberField.getY()-FIELD_HEIGHT);
		phone_label.setSize(100, 30); 
		phone_label.setForeground(Color.gray);
		
		JCheckBox saveSwitch = new JCheckBox("Save");
		saveSwitch.setLocation(phoneNumberField.getX(), phoneNumberField.getY()+(int)(FIELD_HEIGHT*1.3f));
		saveSwitch.setSize(120, 25);
		
		JButton apply_button = new JButton("apply");
		apply_button.setSize(80, 25);
		apply_button.addActionListener(new ApplyButtonListener(saveSwitch.isSelected()));
		apply_button.setLocation(phoneNumberField.getX()+phoneNumberField.getWidth()-apply_button.getWidth(), phoneNumberField.getY()+(int)(FIELD_HEIGHT*1.3f));
		
		add(apply_button);
		add(id_label);
		add(phone_label);
		add(date_label);
		add(saveSwitch);
		add(ID, BorderLayout.CENTER);
		add(dateField, BorderLayout.CENTER);
		add(phoneNumberField, BorderLayout.CENTER);
	}
	
	private class ApplyButtonListener implements ActionListener{
		boolean isWriteNeeded;
		
		protected ApplyButtonListener(boolean isWriteNeeded) {
			this.isWriteNeeded = isWriteNeeded;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
				boolean stackPushedSuccsessfuly = false;
				boolean fileWriteSuccsessfuly = false;
			
				int id = Integer.parseInt(ID.getText());
				DateFormat formatter = new SimpleDateFormat("dd.MM.yy");
				String dateString = dateField.getText();
				Date date = null;
				
				try {
					date = formatter.parse(dateString);
				} catch (ParseException e1) {
					JOptionPane.showMessageDialog(null, "Некорректный формат даты.");
					e1.printStackTrace();
					return;
				}

				/*----- пуш в стэк -----*/
				Record rec = new Record(id, date, phoneNumberField.getText(), 12);
				stack.push(rec);
				JOptionPane.showMessageDialog(null,"Запись успешно создана");
				
				/*----- запись файла -----*/
				if (isWriteNeeded) {
					File file = null;
					try {
						file = RecordSerialiser.serialiseRecord(rec, PATH);
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "Не удалось создать запись.");
						e1.printStackTrace();
						return;
					}
					RecordRegistrator.registerRecord(REGISTRY_FILE, file, Integer.parseInt(ID.getText()));
					JOptionPane.showMessageDialog(null,"Запись успешно создана");
				}
				ID.setText("");
				dateField.setText("");
				phoneNumberField.setText("");
				/*------------------------*/
		}
	}
}
