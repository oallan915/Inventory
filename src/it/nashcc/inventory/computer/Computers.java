package it.nashcc.inventory.computer;

/**
 * This class will construct a computer
 * @author oallan915
 *
 */
public class Computers {
	
	private String name;
	
	private String model;
	
	private String assetId;
	
	private String serialNumber;
	/**
	 *  
	 */
	public Computers(String name, String model, String assetId, String serialNumber) {
	
		setName(name);
		setModel(model);
		setAssetId(assetId);
		setSerialNumber(serialNumber);
	}
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		if(name == null || name.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */
	public String getModel() {
		return model;
	}
	/**
	 * 
	 * @param model
	 */
	public void setModel(String model) {
		
		if(model == null || model.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.model = model;
	}
	/**
	 * 
	 * @return
	 */
	public String getAssetId() {
		
		return assetId;
	}
	/**
	 * 
	 * @param assetId
	 */
	public void setAssetId(String assetId) {
		if(assetId == null) {
			throw new IllegalArgumentException();
		}
		if(assetId.isEmpty()) {
			throw new IllegalArgumentException();
		}
		
		if(assetId.length() != 9) {
			throw new IllegalArgumentException();
		}
		this.assetId = assetId;
	}
	/**
	 * 
	 * @return
	 */
	public String getSerialNumber() {
		return serialNumber;
	}
	/**
	 * 
	 * @param serialNumberl
	 */
	public void setSerialNumber(String serialNumber) {
		
		if(serialNumber == null) {
			throw new IllegalArgumentException();
		}
		if(serialNumber.isEmpty()) {
			throw new IllegalArgumentException();
		}
		if(serialNumber.length() <= 3) {
			throw new IllegalArgumentException();
		}
		this.serialNumber = serialNumber;
	}
	

	@Override
	public String toString() {
		return  name + "        " + model + "        " + assetId + "        "
				+ serialNumber;
	} 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assetId == null) ? 0 : assetId.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((serialNumber == null) ? 0 : serialNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Computers other = (Computers) obj;
		if (assetId == null) {
			if (other.assetId != null)
				return false;
		} else if (!assetId.equals(other.assetId))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (serialNumber == null) {
			if (other.serialNumber != null)
				return false;
		} else if (!serialNumber.equals(other.serialNumber))
			return false;
		return true;
	}

	


	


}
