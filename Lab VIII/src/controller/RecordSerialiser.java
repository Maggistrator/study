package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.Record;

public class RecordSerialiser {
	
	public static File serialiseRecord(Record rec, String path) throws IOException  {
		File file = File.createTempFile("i1_", ".stack", new File(path));
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		out.writeObject(rec);
		out.close();
		return file;
	}
	
	public static Record deserialiseRecord(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
		Record rc1 = (Record)in.readObject();
		return rc1;
	}
}
