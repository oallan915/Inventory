/**
 * 
 */
package it.nashcc.inventory.inventoryController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;




import it.nashcc.inventory.IO.InventoryList;
import it.nashcc.inventory.computer.Computers;

/**
 * @author oallan915
 *
 */ 
public class InventoryController {

	private ArrayList<Computers> computer;

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
	/**
	 * 
	 * @return
	 */
	public String[][] getComputers() {
		String[][] a = new String[computer.size()][5];

		for (int i = 0; i < computer.size(); i++) {
			Computers c = computer.get(i);
			a[i][0] = c.getName();
			a[i][1] = c.getModel();
			a[i][2] = c.getAssetId();
			a[i][3] = c.getSerialNumber();
			a[i][4] = c.getArcutecture();

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
	/**
	 * 
	 * @param assetId
	 * @param serialNumber
	 * @return
	 */
	public boolean addComputer(String name, String model, String assetId, String serialNumber, String arcutecture) {
		Computers c = new Computers(name, model, assetId, serialNumber, arcutecture);
		boolean add = false;
		for (int i = 0; i < computer.size(); i++) {
		 c = computer.get(i); 
 
			if (c.getAssetId().equals(assetId) || c.getSerialNumber().equals(serialNumber)) {
				add = true;
				computer.add(c);
			} else {
				
			}
			
			
		}

		return add;
	}
	/**
	 * 
	 * @param idx
	 * @return
	 */
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
	/**
	 * 
	 * @return
	 */
	public Computers getAssetId() {
		Computers c = null;
	
		for (int i = 0; i < computer.size(); i++) {
			c = computer.get(i);
			
			if(c.getAssetId().equals(this.getAssetId())) {
				return c;
			}
		}
		
		
		return null;
		
	}
	/**
	 * 
	 * @return 
	 */
	public Computers getSerialNumber() {
		Computers c = null;
	
		for (int i = 0; i < computer.size(); i++) {
			c = computer.get(i);
			
			if(c.getSerialNumber().equals(this.getSerialNumber())) {
				return c;
			}
		}
		
		
		return null;
		
	}
	/**
	 * 
	 * @param assetId
	 * @param serial
	 * @return
	 */
	public Computers getListComputers(String assetId, String serial) {


		for (int i = 0; i < computer.size(); i++) {
			Computers c = computer.get(i);
			if(assetId.equals(c.getAssetId()) && serial.equals(c.getSerialNumber())) {
			
				return c;

			}
		}
	return null;
	}
	

}
