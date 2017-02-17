package it.nashcc.inventory.computer;

import static org.junit.Assert.*;

import org.junit.Test;

public class ComputersTest {

	public static final String NAME = "DELL";

	public static final String MODEL = "GX520";

	public static final String ASSET_NUMBER = "856107999";

	public static final String SERIAL = "E000000";

	@Test
	public void testComputers() {

		// Constructing Computer
		
		Computers c = new Computers(NAME, MODEL, ASSET_NUMBER, SERIAL);
		// testing null
		try {
			c = new Computers(null, MODEL, ASSET_NUMBER, SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, null, ASSET_NUMBER, SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, MODEL, null, SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, MODEL, ASSET_NUMBER, null);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, MODEL, "00", SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		try {
			c = new Computers("", MODEL, ASSET_NUMBER, SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, "", ASSET_NUMBER, SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, MODEL, "", SERIAL);
			fail();
		} catch (IllegalArgumentException e) {

		}

		// testing null
		try {
			c = new Computers(NAME, MODEL, ASSET_NUMBER, "");
			fail();
		} catch (IllegalArgumentException e) {

		}
		
		assertEquals(c.toString(),"DELL,GX520,856107999,E000000");

	}

	@Test
	public void testSetName() {

	}

	@Test
	public void testSetModel() {

	}

	@Test
	public void testSetAssetId() {

	}

	@Test
	public void testSetSerialNumber() {
		Computers c = new Computers(NAME, MODEL, ASSET_NUMBER, SERIAL);
		c.setSerialNumber(SERIAL);
		assertEquals(SERIAL, c.getSerialNumber());
		
		try {
			c.setSerialNumber("123");
			fail();
		} catch (IllegalArgumentException e) {
			
		}

	}

	@Test
	public void testToString() {
		
		Computers c1 = new Computers(NAME, MODEL, ASSET_NUMBER, SERIAL);
		String a = "DELL,GX520,856107999,E000000";
		assertEquals(a, c1.toString());

	}

	@Test
	public void testEqualsObject() {

	}

	@Test
	public void testHashCode() {

	}

}
