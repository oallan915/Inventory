/**
 * 
 */
package it.nashcc.inventory.inventoryController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import it.nashcc.inventory.IO.InventoryList;
import it.nashcc.inventory.computer.Computers;

/**
 * @author oallan915
 *
 */ 
public class InventoryController {

	private List<Computers> computer;

	/**
	 * 
	 */
	public InventoryController(String fileName) {
		// TODO Auto-generated constructor stub
		try {
			computer = InventoryList.readInventory(fileName); 

		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException();
		}
	}

	public String[][] getComputers() {
		String[][] a = new String[computer.size()][4];

		for (int i = 0; i < computer.size(); i++) {
			Computers c = computer.get(i);
			a[i][0] = c.getName();
			a[i][1] = c.getModel();
			a[i][2] = c.getAssetId();
			a[i][3] = c.getSerialNumber();

		}
		return a;
	}

	public void exportInventory(String fileName) {
		try {
			InventoryList.writeInventory(fileName, computer);
		} catch (IOException e) {
			throw new IllegalArgumentException("the file cannot be saved.");
		}
	}

	public boolean addComputer(String assetId, String serialNumber) {
		Computers c = null;

		boolean add = false;

		for (int i = 0; i < computer.size(); i++) {
			c = computer.get(i);

			if (c.getAssetId().equals(assetId) || c.getSerialNumber().equals(serialNumber)) {
				throw new IllegalArgumentException(
						c.getName() + " " + c.getAssetId() + " machine is already in the list");
			} else {

				add = true;
				computer.add(c);
			}

		}

		return add;
	}
	
	public boolean removeInventory(int idx) {
		
		boolean delete = false;
		
		for(int i = 0; i < computer.size(); i++) {
			
			Computers c = computer.get(i);
			
			if(i == idx) {
				delete = true;
				computer.remove(c);
			}
		}
		
		return delete;
	}
	
	public Computers getAssetId(String assetId) {
		Computers c = null;
		String assetTag = "";
		for (int i = 0; i < computer.size(); i++) {
			c = computer.get(i);
			
			if(c.getAssetId().equals(assetId)) {
				return c;
			}
		}
		
		
		return null;
		
	}
	

}
