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
import org.w3c.dom.Node;
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
public class PhoneNumberRegistry {
	
	static Stack<Record> stack = new Stack<Record>();
	
	static File registry = new File("src/data/i1/registry.xml");
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Вас приветствует реестр телефонных звонков.");
		System.out.println("Чтобы ввести запись, нажмите 1. Чтобы найти запись, нажмите 2. Чтобы завершить работу, нажмите 0.");

		while(true) {
			System.out.println("-----");
			System.out.print("Выберите действие: ");
			int ans = scan.nextInt();
			switch (ans) {
			case 1:
				Record rec = Record.createInstance();
				stack.push(rec);
				System.out.print("Хотите сохранить эту запись? y/n: ");
				if(scan.next().equalsIgnoreCase("y")) {
					File file = serialiseRecord(rec);
					System.out.print("Введите уникальный циферный номер записи, который вам будет легко вспомнить: ");
					registerRecord(file, scan.nextInt());
					System.out.println("запись сохранена");
				} else System.out.println("запись не будет сохранена");
				break;

			case 2:
				System.out.print("Получить последнюю запись стека, или попытаться найти запись по ID? (stack/id)");
				if(scan.next().equalsIgnoreCase("stack")) {
					if(!stack.isEmpty()) {
						System.out.println("После чтения, запись будет удалена. Содержимое записи:");
						System.out.println(stack.pop().toString());
					} else System.out.println("Стек пуст.");
				} else {
					System.out.print("Введите номер записи: ");
					int id = scan.nextInt();
					rec = findRecordInArchive(id);
					if(rec != null) System.out.println("Запись найдена, содержимое: "+rec.toString());
					else System.out.println("Запись не найдена.");
				}
				break;
			case 0:
				System.out.println("Программа завершает работу.");
				System.exit(0);
				break;
			default:
				System.out.println("Команда не распознана.");
				break;
			}
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
			
			Node root = document.getElementsByTagName("registry").item(0);
			
	        Element record = document.createElement("record");
	        record.setAttribute("id", ID+"");
	        record.setTextContent(file.getAbsolutePath());
	        root.appendChild(record);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static File serialiseRecord(Record rec) throws FileNotFoundException, IOException {
		File file = File.createTempFile("i1_", ".stack", new File("src/data/i1/"));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		registerRecord(file, rec.ID);
		out.writeObject(rec);
		out.close();
		return file;
	}
	
	private static Record deserialiseRecord(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Record rc1 = (Record)in.readObject();
		return rc1;
	}
}
