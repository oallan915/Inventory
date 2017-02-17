package it.nashcc.inventory.IO;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import it.nashcc.inventory.computer.Computers;

public class InventoryListTest {

	public static final String validTestFile = "testfiles/testInventory.csv";

	public static final String inalidTestFile = "";

	public static final String validComputerBuild1 = "DELL,GX520, 856999999, GXADF000";
	public static final String validComputerBuild2 = "DELL,GX520, 856999999, GXADF000";
	public static final String validComputerBuild3 = "DELL,GX520, 856999999, GXADF000";
	public static final String validComputerBuild4 = "DELL,GX520, 856999999, GXADF000";

	public static final String[] validComputerBuild = { validComputerBuild1, validComputerBuild2, validComputerBuild3,
			validComputerBuild4 };

	@Before
	public void setUp() throws Exception {
		Path sourcePath = FileSystems.getDefault().getPath("testfiles", "startInventoryTest.csv");
		Path destinatinPath = FileSystems.getDefault().getPath("testfiles", "testInventory.csv");

		try {
			Files.deleteIfExists(destinatinPath);
			Files.copy(sourcePath, destinatinPath);

		} catch (IOException e) { 
			fail("Unable to read file");
		}
	}

	@Test
	public void testWriteInventory() {
		List<Computers> computer = new ArrayList<Computers>();
		
	
		computer.add(new Computers("HP", "GX520", "856999999", "GXADF000"));
		computer.add(new Computers("DELL", "GX520", "856888888", "GXADF000"));
		computer.add(new Computers("HP", "GX755", "123546789", "adfae"));
		computer.add(new Computers("HP", "GX760", "356358999", "8538"));
		computer.add(new Computers("DELL", "3040", "24dg99999", "8364"));
		computer.add(new Computers("DELL", "GX755", "bvnmj9999", "4125"));
		

		try {
			InventoryList.writeInventory("testfiles/actualInventory.csv", computer);
		} catch (IOException e) {
			fail("Cannot write to inventory record");
		}

	}

	@Test
	public void testReadInventory() {

	}

	@Test
	public void testInventoryReader() {

	}

	private void checkFiles(String expFile, String actFile) {
		// TODO Auto-generated method stub
		try {
			Scanner expScanner = new Scanner(new File(expFile));
			Scanner actScanner = new Scanner(new File(actFile));

			while (expScanner.hasNextLine()) {
				assertEquals(expScanner.nextLine(), actScanner.nextLine());
			}
			expScanner.close();
			actScanner.close();
		} catch (IOException e) {
			
			fail("Error reading file");
		}
	}

}
