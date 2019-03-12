package controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.MainWindow;

/**
 * 1) ������������ ����, �������� � ������ ���������� � ����������� ���������� �������. 
 * ���������� ������ � ����, ������ �������� � ������� ���������. 
 * ���������� �������� � ����� � �������� ������������ �� ������� � �������� ������������������. 
 * �� ����, ����������, ����������� ���������, �������� � ������ �������. ����� ������ ����������, ��� ��������� �� �������. 
 * ������������� ����������� ������ ���������� �� ����� � ���� � ������ ��������� ����� �� �����, �� ������� ������������. 
 * */
public class Launcher {

	public static void main(String[] args) {
		setLaf();
		
		MainWindow window = new MainWindow();
		window.createUI();
	}

    private static void setLaf() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            JOptionPane.showMessageDialog(null, "���������� ���� ����������.. �������: \n" + ex.getMessage());
        }
    }
}
