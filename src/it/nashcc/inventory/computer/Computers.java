package it.nashcc.inventory.computer;

/**
 * This class will construct a computer
 * 
 * @author oallan915
 *
 */
public class Computers {

	private String name;

	private String model;

	private String assetId;

	private String serialNumber;

	private String arcutecture;

	private String iTmember;

	private String room;

	/**
	 *  
	 */
	public Computers(String name, String model, String assetId, String serialNumber, String arcutecture,
			String iTmember, String room) {

		setName(name);
		setModel(model);
		setAssetId(assetId);
		setSerialNumber(serialNumber);
		setArcutecture(arcutecture);
		setiTmember(iTmember);
		setRoom(room);
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
		if (name == null || name.isEmpty()) {
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

		if (model == null || model.isEmpty()) {
			throw new IllegalArgumentException("Model Number cannot be empty");
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
		if (assetId == null || assetId.isEmpty() || assetId.isEmpty()) {
			throw new IllegalArgumentException("Asset # must be 9 numbers");
		}

		char c = ' ';
		for (int i = 0; i < assetId.length(); i++) {
			c = assetId.charAt(i);
			if (!Character.isDigit(c)) {
				throw new IllegalArgumentException("Must contain numbers Only");
			}
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

		if (serialNumber == null || serialNumber.isEmpty() || serialNumber.length() <= 3 ) {
			throw new IllegalArgumentException("Serial number cannot be empty \n or less than 3 characters");
		}


		this.serialNumber = serialNumber;
	}

	public String getArcutecture() {
		return arcutecture;
	}

	public void setArcutecture(String arcutecture) {

		this.arcutecture = arcutecture;
	}

	@Override
	public String toString() {
		return name + "," + arcutecture + "," + model + "," + assetId + "," + serialNumber + "," + iTmember + ","
				+ room;
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

	public String getiTmember() {
		return iTmember;
	}

	public void setiTmember(String iTmember) {

		this.iTmember = iTmember;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

}
