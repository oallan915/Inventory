package it.nashcc.inventory.ui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import it.nashcc.inventory.IO.InventoryList;
import it.nashcc.inventory.computer.Computers;
import it.nashcc.inventory.inventoryController.InventoryController;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import javax.swing.JDialog;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.InputMap;

import java.awt.CardLayout;
import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;

public class Inventory {

	private JFrame frame;

	private JPanel mainPanel;

	private JComboBox<String> combo1 = new JComboBox<String>();

	private JComboBox<String> combo2 = new JComboBox<String>();

	private JComboBox<String> coName = new JComboBox<String>();

	private JTextField textField = new JTextField();

	private JTextField txtModel = new JTextField();

	private JTextField textField_2 = new JTextField();

	private JTextField textField_3;

	private JTextField txtRoom = new JTextField();

	private JButton btnAddButton;

	private JButton btnSaveButton;

	private JButton btnMoveBack;

	private JButton btnReAddButton;

	private JButton btnRemove;

	private JButton printButton;

	private JButton btnRemoveCard;

	private JButton btnPrintRemoved;

	private JButton btnBack;

	private JPanel card1;

	private JList<String> textArea = new JList<String>();

	private JTable table = new JTable();

	private JTableHeader header = new JTableHeader();

	private JTable movedTable;

	private JTable table2119;

	private DefaultTableModel rows2119 = new DefaultTableModel();

	private DefaultTableModel rows = new DefaultTableModel();

	private DefaultTableModel movedRows = new DefaultTableModel();

	private DefaultListModel<String> removeList = new DefaultListModel<String>();

	private JScrollPane scrollBar;

	private List<Computers> computers = new ArrayList<Computers>();

	private List<Computers> movedComputers = new ArrayList<Computers>();

	private List<Computers> offCampus = new ArrayList<Computers>();

	private JLabel lblTotal;

	private JTextField txtTotal = new JTextField();

	private int size;

	private Computers computer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventory window = new Inventory();

					window.mainPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Inventory() throws FileNotFoundException {
		super();
		// Construct the underlying model object
		try {
			new InventoryController("testfiles/Inventory.csv");
			new InventoryController("testfiles/RemovedAsset.csv");
		} catch (IllegalStateException e) {
			System.exit(1);
		}

		new InventoryPanel();

		// Create JPanel that will hold the rest of the GUI information.
		// The JPanel utilizes a CardLayout, which stacks several different
		// JPanels. User actions lead to switching which "Card" is visible.

		// Add panel to the container

		// Set the GUI visible

	}

	/**
	 * Initialize the contents of the mainPanel.
	 * 
	 * @throws FileNotFoundException
	 */
	private class InventoryPanel extends JPanel implements ActionListener {

		private static final long serialVersionUID = 1L;

		public InventoryPanel() {
			super();

			frame = new JFrame("Nash IT Inventory");
			frame.setResizable(false);
			frame.setBounds(1000, 500, 1000, 630);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(new CardLayout(0, 0));

			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

			mainPanel = new JPanel(null);
			mainPanel.setVisible(true);
			frame.add(mainPanel);

			mainPanel.setBounds(1000, 500, 1000, 630);

			card1 = new JPanel();
			card1.setVisible(false);
			card1.setBounds(1000, 500, 1000, 630);
			frame.getContentPane().add(card1);

			JLabel lblComputerName = new JLabel("Machine Name");
			lblComputerName.setBounds(30, 45, 85, 14);
			mainPanel.add(lblComputerName);

			JLabel lblArcutecture = new JLabel("Arcutecture");
			lblArcutecture.setBounds(30, 80, 85, 14);
			mainPanel.add(lblArcutecture);

			JLabel lblModel = new JLabel("Model Number");
			lblModel.setBounds(30, 115, 98, 34);
			mainPanel.add(lblModel);

			JLabel lblAsset = new JLabel("Asset Tag");
			lblAsset.setBounds(30, 150, 98, 34);
			mainPanel.add(lblAsset);

			JLabel lblSerialNumber = new JLabel("Serial Number");
			lblSerialNumber.setBounds(30, 180, 85, 45);
			mainPanel.add(lblSerialNumber);

			JLabel lblItMan = new JLabel("I.T.");
			lblItMan.setBounds(90, 220, 85, 45);
			mainPanel.add(lblItMan);

			ImageIcon icon = new ImageIcon("testfiles/image/download.png");

			JLabel lblNash = new JLabel(icon);
			lblNash.setBounds(550, 20, 450, 300);
			mainPanel.add(lblNash);

			JLabel lblRoom = new JLabel("Deploy to");
			lblRoom.setBounds(50, 270, 85, 14);
			mainPanel.add(lblRoom);

			JTextField lblName = new JTextField("Name");
			lblName.setEditable(false);
			lblName.setBounds(20, 335, 57, 14);
			mainPanel.add(lblName);

			JTextField lblarc = new JTextField("Arc.");
			lblarc.setEditable(false);
			lblarc.setBounds(78, 335, 56, 14);
			mainPanel.add(lblarc);

			JTextField lblModelNumber = new JTextField("Model #");
			lblModelNumber.setEditable(false);
			lblModelNumber.setBounds(135, 335, 56, 14);
			mainPanel.add(lblModelNumber);

			JTextField lblAssetTag = new JTextField("Asset #");
			lblAssetTag.setEditable(false);
			lblAssetTag.setBounds(192, 335, 56, 14);
			mainPanel.add(lblAssetTag);

			JTextField serial = new JTextField("Serial #");
			serial.setEditable(false);
			serial.setBounds(249, 335, 56, 14);
			mainPanel.add(serial);

			JTextField lblDeployer = new JTextField("Staff");
			lblDeployer.setEditable(false);
			lblDeployer.setBounds(307, 335, 56, 14);
			mainPanel.add(lblDeployer);

			JTextField lblRoomNumer = new JTextField("Room");
			lblRoomNumer.setEditable(false);
			lblRoomNumer.setBounds(364, 335, 56, 14);
			mainPanel.add(lblRoomNumer);

			JTextField lblName_2 = new JTextField("Name");
			lblName_2.setEditable(false);
			lblName_2.setBounds(549, 335, 57, 14);
			mainPanel.add(lblName_2);

			JTextField lblarc_2 = new JTextField("Arc.");
			lblarc_2.setEditable(false);
			lblarc_2.setBounds(606, 335, 57, 14);
			mainPanel.add(lblarc_2);

			JTextField lblModelNumber_2 = new JTextField("Model #");
			lblModelNumber_2.setEditable(false);
			lblModelNumber_2.setBounds(663, 335, 57, 14);
			mainPanel.add(lblModelNumber_2);

			JTextField lblAssetTag_2 = new JTextField("Asset #");
			lblAssetTag_2.setEditable(false);
			lblAssetTag_2.setBounds(700, 335, 56, 14);
			mainPanel.add(lblAssetTag_2);

			JTextField serial_2 = new JTextField("Serial #");
			serial_2.setEditable(false);
			serial_2.setBounds(750, 335, 56, 14);
			mainPanel.add(serial_2);

			JTextField lblDeployer_2 = new JTextField("Staff");
			lblDeployer_2.setEditable(false);
			lblDeployer_2.setBounds(800, 335, 56, 14);
			mainPanel.add(lblDeployer_2);

			JTextField lblRoomNumer_2 = new JTextField("Room");
			lblRoomNumer_2.setEditable(false);
			lblRoomNumer_2.setBounds(850, 335, 56, 14);
			mainPanel.add(lblRoomNumer_2);

			combo1.setBounds(160, 45, 86, 20);
			mainPanel.add(combo1);

			combo1.addItem("DELL");
			combo1.addItem("HP");
			combo1.addItem("SURFACE");
			combo1.addItem("SHARP");
			combo1.addItem("LENNOVO");

			combo2.setBounds(160, 80, 86, 20);
			mainPanel.add(combo2);
			combo2.addItem("DESK");
			combo2.addItem("LAP");
			combo2.addItem("SURF");
			combo2.addItem("PROJ");
			combo2.addItem("OTH");

			coName.setBounds(160, 230, 86, 20);
			mainPanel.add(coName);
			coName.addItem("BRIAN");
			coName.addItem("DAVID");
			coName.addItem("FRED");
			coName.addItem("OMAR");
			coName.addItem("TIM");
			coName.addItem("TYRONE");

			txtModel.setBounds(160, 120, 86, 20);
			mainPanel.add(txtModel);
			txtModel.setToolTipText("Cannot be empty.\nOnly accepts 4 characters");

			textField_2.setBounds(160, 157, 86, 20);
			mainPanel.add(textField_2);
			textField_2.setToolTipText("Only accepts 6 characters");

			textField_3 = new JTextField();
			textField_3.setBounds(160, 193, 86, 20);
			textField_3.setToolTipText("Assets serial number.");
			mainPanel.add(textField_3);

			txtRoom = new JTextField();
			txtRoom.setBounds(160, 270, 86, 20);
			txtRoom.setToolTipText(
					"The room the asset is deployed. If asset is being placed in 2119, select asset a and click remove button");
			mainPanel.add(txtRoom);

			btnAddButton = new JButton("ADD");
			btnAddButton.setBounds(276, 52, 86, 150);
			btnAddButton.setToolTipText("Adds asset in I.T. inventory");
			mainPanel.add(btnAddButton);

			btnReAddButton = new JButton("<< MOVE");
			btnReAddButton.setBounds(450, 450, 86, 60);
			btnReAddButton.setToolTipText("Moves asset back in I.T. inventory");
			mainPanel.add(btnReAddButton);

			btnSaveButton = new JButton("SAVE");
			btnSaveButton.setBounds(360, 52, 86, 150);
			btnSaveButton.setToolTipText("Saves all changes to the inventory");
			mainPanel.add(btnSaveButton);

			btnRemove = new JButton("REMOVE");
			btnRemove.setBounds(445, 52, 86, 150);
			btnRemove.setToolTipText("Removes the asset from inventory and places it to a 2119 csv file.");
			mainPanel.add(btnRemove);

			btnMoveBack = new JButton("MOVE >>");
			btnMoveBack.setBounds(450, 350, 86, 60);
			btnMoveBack.setToolTipText(
					"Moves Asset out of our inventory. Be sure to type in the room number that the asset is to be deployed.");
			mainPanel.add(btnMoveBack);

			printButton = new JButton("PRINT");
			printButton.setBounds(300, 202, 220, 60);
			printButton.setToolTipText("Select the asset in the table and click print");
			mainPanel.add(printButton);

			printButton.addActionListener(new HelloWorldPrinter());

			mainPanel.setFocusTraversalPolicy(new FocusTraversalOnArray(
					new Component[] { combo1, combo2, txtModel, textField_2, textField_3, coName, txtRoom, btnAddButton,
							btnSaveButton, btnRemove, printButton, btnMoveBack, btnReAddButton }));

			String[] columnNames = { "Name", "Arcutecture", "Model", "AssetId", "Serial", "IT", "Location" };
			try {

				computers = InventoryList.readInventory("testfiles/Inventory.csv");

				movedComputers = InventoryList.readInventory("testfiles/RemovedAsset.csv");

				offCampus = InventoryList.readInventory("testfiles/2119.csv");

				String[][] movedData = new String[movedComputers.size()][7];
				String[] movedColumnNames = { "Name", "Arcutecture", "Model", "AssetId", "Serial", "IT", "Location" };

				for (int i = 0; i < movedComputers.size(); i++) {
					computer = movedComputers.get(i);

					movedData[i][0] = computer.getName();
					movedData[i][1] = computer.getArcutecture();
					movedData[i][2] = computer.getModel();
					movedData[i][3] = computer.getAssetId();
					movedData[i][4] = computer.getSerialNumber();
					movedData[i][5] = computer.getiTmember();
					movedData[i][6] = computer.getRoom();

					removeList.addElement(computer.toString());

				}

				movedRows = new DefaultTableModel(movedData, movedColumnNames);

				String[][] rowData = new String[computers.size()][7];

				for (int i = 0; i < computers.size(); i++) {
					computer = computers.get(i);

					rowData[i][0] = computer.getName();
					rowData[i][1] = computer.getArcutecture();
					rowData[i][2] = computer.getModel();
					rowData[i][3] = computer.getAssetId();
					rowData[i][4] = computer.getSerialNumber();
					rowData[i][5] = computer.getiTmember();
					rowData[i][6] = computer.getRoom();

				}

				rows = new DefaultTableModel(rowData, columnNames);

				String[][] rowData2119 = new String[offCampus.size()][7];

				for (int i = 0; i < offCampus.size(); i++) {
					computer = offCampus.get(i);

					rowData2119[i][0] = computer.getName();
					rowData2119[i][1] = computer.getArcutecture();
					rowData2119[i][2] = computer.getModel();
					rowData2119[i][3] = computer.getAssetId();
					rowData2119[i][4] = computer.getSerialNumber();
					rowData2119[i][5] = computer.getiTmember();
					rowData2119[i][6] = computer.getRoom();

				}

				rows2119 = new DefaultTableModel(rowData2119, columnNames);

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			table2119 = new JTable();
			table2119.setFont(new Font("Arial", Font.BOLD, 12));
			table2119.setBounds(300, 550, 900, 500);
			card1.add(table2119);
			table2119.setModel(rows2119);

			btnRemoveCard = new JButton("CHECK REMOVE INVENTORY");
			btnRemoveCard.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mainPanel.setVisible(false);
					card1.setVisible(true);

					// inventory.setVisible(false);
				};
			});

			btnBack = new JButton("BACK");
			card1.add(btnBack);
			btnBack.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					card1.setVisible(false);
					mainPanel.setVisible(true);

				};
			});
			btnBack.setBounds(21, 52, 86, 150);

			btnPrintRemoved = new JButton("PRINT");
			btnPrintRemoved.setBounds(300, 202, 220, 60);
			btnPrintRemoved.setToolTipText("Select the asset in the table and click print");
			card1.add(btnPrintRemoved);

			btnPrintRemoved.addActionListener(new HelloWorldPrinter());

			scrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollBar.setBounds(420, 350, 21, 200);
			scrollBar.setEnabled(true);
			mainPanel.add(scrollBar);
			table.add(scrollBar);
		
			btnRemoveCard.setBounds(790, 555, 200, 45);
			btnRemoveCard.setToolTipText("Select the asset in the table and click print");
			mainPanel.add(btnRemoveCard);

			mainPanel.add(scrollBar);
			scrollBar.setViewportView(table);
			rows.setColumnIdentifiers(columnNames);

			mainPanel.add(header);
			table.setBounds(21, 350, 400, 200);
			table.setFont(new Font("Arial", Font.BOLD, 12));
			mainPanel.add(table);
			table.setModel(rows);

			movedTable = new JTable();
			movedTable.setFont(new Font("Arial", Font.BOLD, 12));
			movedTable.setBounds(550, 350, 400, 200);
			mainPanel.add(movedTable);
			movedTable.setModel(movedRows);

			size = computers.size();

			txtTotal.setText(size + "");

			txtTotal.setEditable(false);
			txtTotal.setBounds(195, 575, 20, 20);
			mainPanel.add(txtTotal);

			lblTotal = new JLabel("Total items in inventory: ");
			lblTotal.setBounds(60, 550, 200, 70);
			mainPanel.add(lblTotal);

			textField_2.setText("");
			btnAddButton.addActionListener(this);

			InputMap add = btnAddButton.getInputMap();
			add.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
			add.put(KeyStroke.getKeyStroke("released ENTER"), "released");

			btnReAddButton.addActionListener(this);

			InputMap Readd = btnReAddButton.getInputMap();
			Readd.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
			Readd.put(KeyStroke.getKeyStroke("released ENTER"), "released");

			btnMoveBack.addActionListener(this);

			InputMap moveOut = btnMoveBack.getInputMap();
			moveOut.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
			moveOut.put(KeyStroke.getKeyStroke("released ENTER"), "released");

			btnSaveButton.addActionListener(this);

			InputMap save = btnMoveBack.getInputMap();
			save.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
			save.put(KeyStroke.getKeyStroke("released ENTER"), "released");

			btnRemove.addActionListener(this);

			InputMap remove = btnMoveBack.getInputMap();
			remove.put(KeyStroke.getKeyStroke("ENTER"), "pressed");
			remove.put(KeyStroke.getKeyStroke("released ENTER"), "released");

			btnRemoveCard.addActionListener(this);

		}
		/* END OF GUI */

		@Override
		public void actionPerformed(ActionEvent e) {

			String fileName = "testfiles/Inventory.csv";

			File file = new File("testfiles/Inventory.csv");

			String removeAsset = "testfiles/RemovedAsset.csv";

			File removeAssets = new File("testfiles/RemovedAsset.csv");

			File fCampus = new File("testfiles/2119.csv");

			String removedItems = "testfiles/2119.csv";

			String name = combo1.getSelectedItem() + "";
			String arcutecture = combo2.getSelectedItem() + "";
			String modelC = txtModel.getText().toUpperCase();
			String assetId = textField_2.getText().toUpperCase();
			String serial = textField_3.getText().toUpperCase();
			String iTmember = coName.getSelectedItem() + "";
			String location = txtRoom.getText().toUpperCase();

			if (e.getSource() == btnAddButton) {

				try {

					computer = new Computers(name, modelC, assetId, serial, arcutecture, iTmember, location);
				} catch (IllegalArgumentException e1) {

					JOptionPane.showMessageDialog(mainPanel, e1.getMessage(), "Text Error", JOptionPane.ERROR_MESSAGE);
				}

				computer = new Computers(name, modelC, assetId, serial, arcutecture, iTmember, location);

				if (computers.add(computer)) {
					String[][] rowData = new String[][] {
							{ name, arcutecture, modelC, assetId, serial, iTmember, location } };

					rows.addRow(rowData[0]);
					table.setModel(rows);

					size = computers.size();
				}

				textField.setText("");
				txtModel.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
			/* REMOVE BUTTON CLICK */
			if (e.getSource() == btnMoveBack) {

				int index = table.convertRowIndexToModel(table.getSelectedRow());

				if (index == -1) {
					JOptionPane.showMessageDialog(mainPanel, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = computers.get(index);

					computers.remove(com);
					rows.removeRow(index);
					table.setModel(rows);
					com.setRoom(location);
					String[][] rowData = new String[][] { { com.getName(), com.getArcutecture(), com.getModel(),
							com.getAssetId(), com.getSerialNumber(), com.getiTmember(), com.getRoom() } };

					movedComputers.add(com);

					movedRows.addRow(rowData[0]);

					movedTable.setModel(movedRows);

				}
			}
			/* SAVE BUTTON CLICK */
			if (e.getSource() == btnSaveButton) {

				try {

					JOptionPane optionPane = new JOptionPane("Save file?", JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);

					JDialog dialog = optionPane.createDialog(mainPanel, "Save");

					file.delete();
					removeAssets.delete();
					fCampus.delete();

					dialog.setVisible(true);

					try {
						InventoryList.writeInventory(fileName, computers);

						InventoryList.writeInventory(removeAsset, movedComputers);

						InventoryList.writeInventory(removedItems, offCampus);

					} catch (IOException e1) {

						e1.printStackTrace();
					}
					textArea.setVisibleRowCount(10);

				} catch (NullPointerException e6) {

					textField_2.setText("");

				}

			}

			/*
			 * MOVE BACK TO INVENTORY
			 **********************************************************************************/
			if (e.getSource() == btnReAddButton) {
				int moveIndex = movedTable.convertRowIndexToModel(movedTable.getSelectedRow());

				if (moveIndex == -1) {
					JOptionPane.showMessageDialog(mainPanel, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = movedComputers.get(moveIndex);

					movedComputers.remove(com);
					movedRows.removeRow(moveIndex);
					movedTable.setModel(movedRows);
					com.setRoom("2218");
					com.setiTmember(iTmember);
					computers.add(com);

					String[][] rowData = new String[][] { { com.getName(), com.getArcutecture(), com.getModel(),
							com.getAssetId(), com.getSerialNumber(), com.getiTmember(), com.getRoom() } };

					rows.addRow(rowData[0]);
					table.setModel(rows);

				}

			}

			if (e.getSource() == btnRemove) {

				if (movedTable.getSelectedRow() > -1) {
					int moveIndex = movedTable.convertRowIndexToModel(movedTable.getSelectedRow());
					Computers com = movedComputers.get(moveIndex);

					movedComputers.remove(com);
					movedRows.removeRow(moveIndex);
					offCampus.add(com);
					movedTable.setModel(movedRows);

					String[][] rowData = new String[][] { { com.getName(), com.getArcutecture(), com.getModel(),
							com.getAssetId(), com.getSerialNumber(), com.getiTmember(), com.getRoom() } };

					offCampus.add(com);

					rows2119.addRow(rowData[0]);

					table2119.setModel(rows2119);

				} else if (table.getSelectedRow() > -1) {

					int i = table.getSelectedRow();
					Computers com1 = computers.get(i);

					String[][] rowData = new String[][] { { com1.getName(), com1.getArcutecture(), com1.getModel(),
							com1.getAssetId(), com1.getSerialNumber(), com1.getiTmember(), com1.getRoom() } };

					computers.remove(com1);

					rows.removeRow(i);

					table.setModel(rows);

					offCampus.add(com1);

					rows2119.addRow(rowData[0]);

					table2119.setModel(rows2119);

				} else {

					JOptionPane.showMessageDialog(mainPanel, "Must select an Asset to be removed", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}

		}

		public class HelloWorldPrinter implements Printable, ActionListener {

			public int print(Graphics g, PageFormat pf, int page) throws PrinterException {

				if (page > 0) { 
					return NO_SUCH_PAGE;
				}

				return PAGE_EXISTS;
			}

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				try {
					if (table.getSelectedRow() > -1) {
						table.print();
					} else if (movedTable.getSelectedRow() > -1) {
						movedTable.print();
					} else if (table2119.getSelectedRow() > -1) {

						table2119.print();

					} else {

						JOptionPane.showMessageDialog(mainPanel, "Must select an Asset to be printed",
								"Selection Error", JOptionPane.ERROR_MESSAGE);
					}
				} catch (PrinterException ex) {
					/* The job did not successfully complete */
				}
			}

		}

	}
}
