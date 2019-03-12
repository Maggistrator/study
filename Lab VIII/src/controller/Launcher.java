package controller;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.MainWindow;

/**
 * 1) Организовать ввод, хранение и выдачу информации о выполненных телефонных звонках. 
 * Интересуют данные о дате, номере телефона и времени разговора. 
 * Информация хранится в стеке и выдается пользователю по запросу в обратной последовательности. 
 * То есть, информация, поступившая последней, выдается в первую очередь. После чтения информации, она удаляется из системы. 
 * Предусмотреть возможность записи информации из стека в файл и чтения состояния стека из файла, по команде пользователя. 
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
            JOptionPane.showMessageDialog(null, "Оформление окна отвалилось.. Причина: \n" + ex.getMessage());
        }
    }
}
