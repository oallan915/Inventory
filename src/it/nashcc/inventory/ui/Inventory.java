package it.nashcc.inventory.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import it.nashcc.inventory.IO.InventoryList;
import it.nashcc.inventory.computer.Computers;
import it.nashcc.inventory.inventoryController.InventoryController;

import java.awt.GridLayout;

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

import java.awt.Color;
import java.awt.Component;

import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;

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

	private JList<String> removeArea = new JList<String>();

	private JTable table;

	private DefaultListModel<String> removeList = new DefaultListModel<String>();

	private DefaultListModel<String> model = new DefaultListModel<String>();

	private JScrollPane scrollBar;

	private List<Computers> computers = new ArrayList<Computers>();

	private List<Computers> movedComputers = new ArrayList<Computers>();

	private Computers computer;

	private InventoryController controller;

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

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InventoryPanel() {
			super();

			frame = new JFrame("Nash IT Inventory");
			frame.setResizable(false);
			frame.setBounds(1000, 500, 1000, 630);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			frame.setLocationRelativeTo(null); // *** this will center your app
												// ***
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

			/*
			 * JLabel lblNameList = new JLabel("Name");
			 * lblNameList.setBounds(20, 280, 85, 14);
			 * frame.getContentPane().add(lblNameList);
			 * 
			 * JLabel lblarc = new JLabel("Arc."); lblarc.setBounds(70, 280, 85,
			 * 14); frame.getContentPane().add(lblarc);
			 * 
			 * JLabel lblModelList = new JLabel("Model");
			 * lblModelList.setBounds(110, 280, 85, 14);
			 * frame.getContentPane().add(lblModelList);
			 * 
			 * JLabel lblAssetList = new JLabel("Asset");
			 * lblAssetList.setBounds(165, 280, 85, 14);
			 * frame.getContentPane().add(lblAssetList);
			 * 
			 * 
			 * JLabel lblSerialList = new JLabel("Serial");
			 * lblSerialList.setBounds(275, 280, 85, 14);
			 * frame.getContentPane().add(lblSerialList);
			 */

			JLabel lblRoom = new JLabel("Deploy to");
			lblRoom.setBounds(50, 270, 85, 14);
			frame.getContentPane().add(lblRoom);

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
			btnReAddButton.setBounds(435, 450, 86, 60);
			frame.getContentPane().add(btnReAddButton);

			btnSaveButton = new JButton("SAVE");
			btnSaveButton.setBounds(360, 52, 86, 150);
			frame.getContentPane().add(btnSaveButton);

			btnRemove = new JButton("REMOVE");
			btnRemove.setBounds(445, 52, 86, 150);
			frame.getContentPane().add(btnRemove);

			btnMoveBack = new JButton("MOVE >>");
			btnMoveBack.setBounds(435, 360, 86, 60);
			frame.getContentPane().add(btnMoveBack);

			frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { combo1, txtModel, textField_2,
					textField_3, btnAddButton, btnSaveButton, btnMoveBack }));
			try {

				computers = InventoryList.readInventory("testfiles/Inventory.csv");

				movedComputers = InventoryList.readInventory("testfiles/RemovedAsset.csv");

				for (int i = 0; i < movedComputers.size(); i++) {
					computer = movedComputers.get(i);
					removeList.addElement(computer.toString());

				}

				for (int i = 0; i < computers.size(); i++) {
					computer = computers.get(i);
					model.addElement(computer.toString());

				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		
			textArea.setBounds(21, 350, 400, 200);
			textArea.add(new JScrollPane(), "West");
			textArea.setLayout(new GridBagLayout());
			frame.getContentPane().add(textArea);

			textArea.setModel(model);

			removeArea.setBounds(550, 350, 400, 200);
			frame.getContentPane().add(removeArea);
			removeArea.setModel(removeList);

			textField_2.setText("856");
			btnAddButton.addActionListener(this);
			btnReAddButton.addActionListener(this);
			btnMoveBack.addActionListener(this);
			btnSaveButton.addActionListener(this);
			btnRemove.addActionListener(this);
		}
		/* END OF GUI BIULD */

		@Override
		public void actionPerformed(ActionEvent e) {

			int removeAreaIndex = removeArea.getSelectedIndex();

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
			

			
			
			try {

				modelC = modelC.substring(0, 4);
				assetId = assetId.substring(0, 9);

			} catch (StringIndexOutOfBoundsException e1) {

			}
			if (e.getSource() == btnAddButton) {

				try {
					computer = new Computers(name, modelC, assetId, serial, arcutecture, iTmember, location);
					
					String[][] rowData = { {name, arcutecture, modelC, assetId, serial, iTmember, location} };
					String[] columnNames =  {"Name", "Arcutecture", "Model", "AssetId", "Serial", "IT", "Location"};
					table = new JTable(rowData, columnNames);
					if (computers.add(computer)) {
						model.addElement(computer.toString());
						textArea.setModel(model);

					} else {
						JOptionPane.showMessageDialog(frame, "Asset is already added", " Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (IllegalArgumentException e1) {
					JOptionPane.showMessageDialog(frame, "Text field cannot be empty", "Text Error",
							JOptionPane.ERROR_MESSAGE);

				}
				textField.setText("");
				txtModel.setText("");
				textField_2.setText("856");
				textField_3.setText("");
			}
			/* REMOVE BUTTON CLICK */
			if (e.getSource() == btnMoveBack) {

				textField.setText("");
				txtModel.setText("");
				textField_2.setText("856");
				textField_3.setText("");

				int index = textArea.getSelectedIndex();

				if (index == -1) {
					JOptionPane.showMessageDialog(frame, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = computers.get(index);

					computers.remove(com);
					model.remove(index);

					movedComputers.add(com);
					removeList.addElement(com.toString());
					removeArea.setModel(removeList);

					textArea.ensureIndexIsVisible(model.size());
					textArea.setModel(model);
					textArea.setVisibleRowCount(10);

				}
			}
			/* SAVE BUTTON CLICK */
			if (e.getSource() == btnSaveButton) {

				try {

					file.delete();
					removeAssets.delete();
					JOptionPane optionPane = new JOptionPane("Save file?", JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);

					JDialog dialog = optionPane.createDialog(frame, "Save");

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
			if (e.getSource() == btnReAddButton) {

				try {
					Computers com = movedComputers.get(removeAreaIndex);

					movedComputers.remove(com);
					removeList.remove(removeAreaIndex);

					computers.add(com);
					model.addElement(com.toString());
					textArea.setModel(model);

					removeArea.setModel(removeList);

				} catch (ArrayIndexOutOfBoundsException e2) {

				} catch (IndexOutOfBoundsException e2) {

				}
			}

			if (e.getSource() == btnRemove) {

				int i = textArea.getSelectedIndex();

				int selectedIndex = removeArea.getSelectedIndex();

				if (removeArea.isSelectedIndex(selectedIndex)) {
					try {
						Computers com = movedComputers.get(selectedIndex);
						movedComputers.remove(com);
						removeList.remove(selectedIndex);

						removeArea.setModel(removeList);

					} catch (ArrayIndexOutOfBoundsException e2) {

					} catch (IndexOutOfBoundsException e2) {

					}
				} else if (textArea.isSelectedIndex(i)) {

					try {
						Computers com = computers.get(i);

						computers.remove(com);
						model.remove(i);

						textArea.setModel(model);

					} catch (ArrayIndexOutOfBoundsException e2) {

					} catch (IndexOutOfBoundsException e2) {

					}

				}

			}

		}

	}

}
