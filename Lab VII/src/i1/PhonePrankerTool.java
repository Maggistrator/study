package i1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.Stack;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 1) Организовать ввод, хранение и выдачу информации о выполненных телефонных звонках. 
 * Интересуют данные о дате, номере телефона и времени разговора. 
 * Информация хранится в стеке и выдается пользователю по запросу в обратной последовательности. 
 * То есть, информация, поступившая последней, выдается в первую очередь. После чтения информации, она удаляется из системы. 
 * Предусмотреть возможность записи информации из стека в файл и чтения состояния стека из файла, по команде пользователя. 
 * 
 * 
 * p.s. было бы проще пушить записи в SQLite базу, но я слишком поздно сообразил
 * */
public class PhonePrankerTool {
	
	static Stack<Record> stack = new Stack<Record>();
	
	static File registry = new File("src/data/i1/registry.xml");
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		boolean sessinComplete = false;
		while(!sessinComplete) {
			System.out.println("Вас приветствует реестр телефонных звонков.");
			System.out.println("Чтобы ввести запись, нажмите 1. Чтобы найти запись, нажмите 2.");
			
			
		}
		
	}

	private static Record findRecordInArchive(int id) throws IOException, ClassNotFoundException {
		Document document = null;	
		Record record = null;
		
		try { 
			//подготовка к генерации объекта при помощи фабрики
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//генерируем document из XML
			document = dBuilder.parse(registry);
			
			NodeList records = document.getElementsByTagName("record");
			for (int i = 0; i < records.getLength(); i++) {
				Element rec = (Element)records.item(i);
				int current_id = Integer.parseInt(rec.getAttribute("id"));
				if(current_id == id) {
					File rec_file = new File(rec.getTextContent());
					record = deserialiseRecord(rec_file);
				}
			}
			
		} catch (ParserConfigurationException | SAXException | IOException e) {
			System.err.println("реестр телефонных записей повреждён");
			e.printStackTrace();
		}
		
		return record;
	}
	
	private static void registerRecord(File file, int ID) {
		Document document = null;	
		
		try { 
			//подготовка к генерации объекта при помощи фабрики
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//генерируем document из XML
			document = dBuilder.parse(registry);
			
	        Element record = document.createElement("record");
	        record.setAttribute("id", ID+"");
	        record.setTextContent(file.getAbsolutePath());
	        document.appendChild(record);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void serialiseRecord(Record rec) throws FileNotFoundException, IOException {
		File file = File.createTempFile("i1_", "stack", new File("src/data/i1/"));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		registerRecord(file, rec.ID);
		out.writeObject(rec);
		out.close();
	}
	
	private static Record deserialiseRecord(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Record rc1 = (Record)in.readObject();
		return rc1;
	}
}
