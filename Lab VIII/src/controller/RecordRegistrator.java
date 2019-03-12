package controller;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class RecordRegistrator {
	
	public static void registerRecord(File registry, File file, int ID) {	
		Document document = null;	
		
		try { 
			//���������� � ��������� ������� ��� ������ �������
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			//���������� document �� XML
			document = dBuilder.parse(registry);
			
			Node root = document.getElementsByTagName("registry").item(0);
			
	        Element record = document.createElement("record");
	        record.setAttribute("id", ID+"");
	        record.setTextContent(file.getAbsolutePath());
	        root.appendChild(record);
	        
	        // ��������� ��������� ������������� XML ��������� � ����             
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();             
	        DOMSource source = new DOMSource(document);             
	        StreamResult result = new StreamResult(registry);                          
	        transformer.transform(source, result);             
	        System.out.println("������ ���������!");
	        
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
