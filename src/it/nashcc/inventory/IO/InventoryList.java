package it.nashcc.inventory.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import it.nashcc.inventory.computer.Computers;

public class InventoryList {

	public static void writeInventory(String fileName, List<Computers> computers) throws IOException {
		String docName = fileName;

		if (docName == null || docName.isEmpty()) {
			throw new IOException();
		} else {

			PrintWriter fileWriter = new PrintWriter(new FileWriter(docName, true));

			for (int i = 0; i < computers.size(); i++) {
				fileWriter.println(computers.get(i));
 
			}
			fileWriter.close();
		}

	}

	/**
	 * 
	 * @param computer
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Computers> readInventory(String fileName) throws FileNotFoundException {

		File file = new File(fileName);
		Scanner fileReader = new Scanner(file);

		ArrayList<Computers> computers = new ArrayList<Computers>();

		while (fileReader.hasNextLine()) { 

			try {

				Computers computer = inventoryReader(fileReader.nextLine());

				boolean isDuplicate = false;  

				for (int i = 0; i < computers.size(); i++) {

					Computers c = computers.get(i);

					if (computer.getAssetId().equals(c.getAssetId())
							&& computer.getSerialNumber().equals(c.getSerialNumber())) {
						isDuplicate = true;
					}
				}
				if (!isDuplicate) {
					computers.add(computer);
				}

			} catch (IllegalArgumentException e) {
				if (fileReader.hasNextLine()) {
					fileReader.nextLine();
				}
			}

		}
		
		fileReader.close();

		
		
		return computers;

	}

	public static Computers inventoryReader(String nextLine) throws FileNotFoundException {

		Scanner reader = new Scanner(nextLine);
		Computers computer = null; 

		//reader.useDelimiter(",");
		try { 
			String computerName = reader.next();
			String modelName = reader.next();
			String assetNumber = reader.next();
			String serialNumber = reader.next();
 
			computer = new Computers(computerName, modelName, assetNumber, serialNumber);

		} catch (NoSuchElementException e) {
			reader.close();
			throw new IllegalArgumentException();
		}
		reader.close();
		return computer;

	}

	@Override
	public String toString() {

		return null;

	}

}
