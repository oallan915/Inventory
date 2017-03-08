package it.nashcc.inventory.ui;

import java.awt.EventQueue;
import java.awt.Font;

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

import java.awt.Component;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.junit.runner.Computer;

public class Inventory {

	private JFrame frame;

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

	private JList<String> textArea = new JList<String>();

	private JTable table = new JTable();

	private JTableHeader header = new JTableHeader();

	private JTable movedTable;

	private DefaultTableModel rows = new DefaultTableModel();

	private DefaultTableModel movedRows = new DefaultTableModel();

	private DefaultListModel<String> removeList = new DefaultListModel<String>();

	private JScrollPane scrollBar;

	private List<Computers> computers = new ArrayList<Computers>();

	private List<Computers> movedComputers = new ArrayList<Computers>();

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

					window.frame.setVisible(true);
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
	 * Initialize the contents of the frame.
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

			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.getContentPane().setLayout(null);

			JLabel lblComputerName = new JLabel("Machine Name");
			lblComputerName.setBounds(30, 45, 85, 14);
			frame.getContentPane().add(lblComputerName);

			JLabel lblArcutecture = new JLabel("Arcutecture");
			lblArcutecture.setBounds(30, 80, 85, 14);
			frame.getContentPane().add(lblArcutecture);

			JLabel lblModel = new JLabel("Model Number");
			lblModel.setBounds(30, 115, 98, 34);
			frame.getContentPane().add(lblModel);

			JLabel lblAsset = new JLabel("Asset Tag");
			lblAsset.setBounds(30, 150, 98, 34);
			frame.getContentPane().add(lblAsset);

			JLabel lblSerialNumber = new JLabel("Serial Number");
			lblSerialNumber.setBounds(30, 180, 85, 45);
			frame.getContentPane().add(lblSerialNumber);

			JLabel lblItMan = new JLabel("I.T.");
			lblItMan.setBounds(90, 220, 85, 45);
			frame.getContentPane().add(lblItMan);

			ImageIcon icon = new ImageIcon("testfiles/image/download.png");

			JLabel lblNash = new JLabel(icon);
			lblNash.setBounds(550, 20, 450, 300);
			frame.getContentPane().add(lblNash);

			JLabel lblRoom = new JLabel("Deploy to");
			lblRoom.setBounds(50, 270, 85, 14);
			frame.getContentPane().add(lblRoom);

			JLabel lblName = new JLabel("Name");
			lblName.setBounds(28, 335, 85, 14);
			frame.getContentPane().add(lblName);

			JLabel lblarc = new JLabel("Arc.");
			lblarc.setBounds(90, 335, 85, 14);
			frame.getContentPane().add(lblarc);

			JLabel lblModelNumber = new JLabel("Model #");
			lblModelNumber.setBounds(140, 335, 85, 14);
			frame.getContentPane().add(lblModelNumber);

			JLabel lblAssetTag = new JLabel("Asset #");
			lblAssetTag.setBounds(195, 335, 85, 14);
			frame.getContentPane().add(lblAssetTag);

			JLabel serial = new JLabel("Serial #");
			serial.setBounds(250, 335, 85, 14);
			frame.getContentPane().add(serial);

			JLabel lblDeployer = new JLabel("Staff");
			lblDeployer.setBounds(310, 335, 85, 14);
			frame.getContentPane().add(lblDeployer);

			JLabel lblRoomNumer = new JLabel("Room");
			lblRoomNumer.setBounds(370, 335, 85, 14);
			frame.getContentPane().add(lblRoomNumer);

			combo1.setBounds(160, 45, 86, 20);
			frame.getContentPane().add(combo1);

			combo1.addItem("DELL");
			combo1.addItem("HP");
			combo1.addItem("SURFACE");
			combo1.addItem("SHARP");
			combo1.addItem("LENNOVO");

			combo2.setBounds(160, 80, 86, 20);
			frame.getContentPane().add(combo2);
			combo2.addItem("DESK");
			combo2.addItem("LAP");
			combo2.addItem("SURF");
			combo2.addItem("PROJ");
			combo2.addItem("OTH");

			coName.setBounds(160, 230, 86, 20);
			frame.getContentPane().add(coName);
			coName.addItem("BRIAN");
			coName.addItem("DAVID");
			coName.addItem("FRED");
			coName.addItem("OMAR");
			coName.addItem("TIM");
			coName.addItem("TYRONE");

			txtModel.setBounds(160, 120, 86, 20);
			frame.getContentPane().add(txtModel);
			txtModel.setToolTipText("Cannot be empty.\nOnly accepts 4 characters");

			textField_2.setBounds(160, 157, 86, 20);
			frame.getContentPane().add(textField_2);
			textField_2.setToolTipText("Only accepts 9 characters");

			textField_3 = new JTextField();
			textField_3.setBounds(160, 193, 86, 20);
			frame.getContentPane().add(textField_3);

			txtRoom = new JTextField();
			txtRoom.setBounds(160, 270, 86, 20);
			frame.getContentPane().add(txtRoom);

			btnAddButton = new JButton("ADD");

			btnAddButton.setBounds(276, 52, 86, 150);
			frame.getContentPane().add(btnAddButton);

			btnReAddButton = new JButton("<< MOVE");
			btnReAddButton.setBounds(450, 450, 86, 60);
			frame.getContentPane().add(btnReAddButton);

			btnSaveButton = new JButton("SAVE");
			btnSaveButton.setBounds(360, 52, 86, 150);
			frame.getContentPane().add(btnSaveButton);

			btnRemove = new JButton("REMOVE");
			btnRemove.setBounds(445, 52, 86, 150);
			frame.getContentPane().add(btnRemove);

			btnMoveBack = new JButton("MOVE >>");
			btnMoveBack.setBounds(450, 360, 86, 60);
			frame.getContentPane().add(btnMoveBack);

			frame.setFocusTraversalPolicy(
					new FocusTraversalOnArray(new Component[] { combo1, combo2, txtModel, textField_2, textField_3,
							coName, txtRoom, btnAddButton, btnSaveButton, btnRemove, btnMoveBack, btnReAddButton }));

			String[] columnNames = { "Name", "Arcutecture", "Model", "AssetId", "Serial", "IT", "Location" };
			try {

				computers = InventoryList.readInventory("testfiles/Inventory.csv");

				movedComputers = InventoryList.readInventory("testfiles/RemovedAsset.csv");

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

			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			scrollBar = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollBar.setBounds(420, 350, 21, 200);

			scrollBar.setEnabled(true);

			frame.getContentPane().add(scrollBar);

			scrollBar.setViewportView(table);
			rows.setColumnIdentifiers(columnNames);

			frame.getContentPane().add(header);

			table.setBounds(21, 350, 400, 200);

			table.setFont(new Font("Arial", Font.BOLD, 12));

			frame.getContentPane().add(table);

			table.setModel(rows);

			movedTable = new JTable();
			movedTable.setFont(new Font("Arial", Font.BOLD, 12));
			movedTable.setBounds(550, 350, 400, 200);
			frame.getContentPane().add(movedTable);
			movedTable.setModel(movedRows);

			
			size = computers.size();
			
			txtTotal.setText(size + "");
			
			txtTotal.setEditable(false);
			txtTotal.setBounds(195, 575, 20, 20);
			frame.getContentPane().add(txtTotal);
			
			lblTotal = new JLabel("Total items in inventory: ");
			lblTotal.setBounds(60, 550, 200, 70);
			frame.getContentPane().add(lblTotal); 

			textField_2.setText("856");
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
		}
		/* END OF GUI */

		@Override
		public void actionPerformed(ActionEvent e) {

			String fileName = "testfiles/Inventory.csv";

			File file = new File("testfiles/Inventory.csv");

			String removeAsset = "testfiles/RemovedAsset.csv";

			File removeAssets = new File("testfiles/RemovedAsset.csv");

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
						
						JOptionPane.showMessageDialog(frame,
								e1.getMessage(),
								"Text Error", JOptionPane.ERROR_MESSAGE);
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
				textField_2.setText("856");
				textField_3.setText("");
			}
			/* REMOVE BUTTON CLICK */
			if (e.getSource() == btnMoveBack) {

				int index = table.convertRowIndexToModel(table.getSelectedRow());

				if (index == -1) {
					JOptionPane.showMessageDialog(frame, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = computers.get(index);

					computers.remove(com);
					rows.removeRow(index);
					table.setModel(rows);

					String[][] rowData = new String[][] { { com.getName(), com.getArcutecture(), com.getModel(),
							com.getAssetId(), com.getSerialNumber(), com.getiTmember(), location } };

					com.setRoom(location);
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

					JDialog dialog = optionPane.createDialog(frame, "Save");

					file.delete();
					removeAssets.delete();

					dialog.setVisible(true);

					try {
						InventoryList.writeInventory(fileName, computers);

						InventoryList.writeInventory(removeAsset, movedComputers);

					} catch (IOException e1) {

						e1.printStackTrace();
					}
					textArea.setVisibleRowCount(10);

				} catch (NullPointerException e6) {

					textField_2.setText("856");

				}

			}

			/*
			 * MOVE BACK TO INVENTORY
			 **********************************************************************************/
			if (e.getSource() == btnReAddButton) {
				int moveIndex = movedTable.convertRowIndexToModel(movedTable.getSelectedRow());

				if (moveIndex == -1) {
					JOptionPane.showMessageDialog(frame, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = movedComputers.get(moveIndex);
					
					com.setRoom("2218");
					movedComputers.remove(com);
					movedRows.removeRow(moveIndex);
					movedTable.setModel(movedRows);
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
					movedTable.setModel(movedRows);

				} else if (table.getSelectedRow() > -1) {

					int i = table.convertRowIndexToModel(table.getSelectedRow());
					Computers com1 = computers.get(i);

					computers.remove(com1);
					rows.removeRow(i);
					table.setModel(rows);

				} else {

					JOptionPane.showMessageDialog(frame, "Must select an Asset to remove", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				}

			}
		}

	}

}
