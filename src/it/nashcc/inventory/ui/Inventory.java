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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import javax.swing.DefaultListModel;

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

	private JButton btnRemoveButton;

	private JButton btnReAddButton;

	private JList<String> textArea = new JList<String>();

	private JList<String> removeArea = new JList<String>();

	private DefaultListModel<String> removeList = new DefaultListModel<String>();

	private DefaultListModel<String> model = new DefaultListModel<String>();

	private JScrollPane scrollBar;

	private List<Computers> computers = new ArrayList<Computers>();

	private List<Computers> removedComputers = new ArrayList<Computers>();

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

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public InventoryPanel() {
			super();

			frame = new JFrame();
			frame.setResizable(false);
			frame.setBounds(1000, 500, 1000, 1000);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);

			Component rigidArea = Box.createRigidArea(new Dimension(20, 20));
			rigidArea.setBounds(-10003, -10025, 767, 696);
			frame.getContentPane().add(rigidArea);

			Component verticalStrut = Box.createVerticalStrut(20);
			verticalStrut.setBounds(-10003, -10025, 767, 696);
			frame.getContentPane().add(verticalStrut);

			Component horizontalStrut_1 = Box.createHorizontalStrut(20);
			horizontalStrut_1.setBounds(-10003, -10025, 767, 696);
			frame.getContentPane().add(horizontalStrut_1);

			Component horizontalStrut = Box.createHorizontalStrut(20);
			horizontalStrut.setBounds(-10003, -10025, 767, 696);
			frame.getContentPane().add(horizontalStrut);

			Component rigidArea_1 = Box.createRigidArea(new Dimension(20, 20));
			rigidArea_1.setBounds(-10003, -10025, 767, 696);
			frame.getContentPane().add(rigidArea_1);

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

			JLabel lblNashItInventory = new JLabel(" Nash IT Inventory");
			lblNashItInventory.setBounds(561, 71, 127, 74);
			frame.getContentPane().add(lblNashItInventory);

			JLabel lblNameList = new JLabel("Name");
			lblNameList.setBounds(20, 233, 85, 14);
			frame.getContentPane().add(lblNameList);

			JLabel lblModelList = new JLabel("Model");
			lblModelList.setBounds(70, 233, 85, 14);
			frame.getContentPane().add(lblModelList);

			JLabel lblAssetList = new JLabel("Asset");
			lblAssetList.setBounds(145, 233, 85, 14);
			frame.getContentPane().add(lblAssetList);

			JLabel lblSerialList = new JLabel("Serial");
			lblSerialList.setBounds(245, 233, 85, 14);
			frame.getContentPane().add(lblSerialList);

			JLabel lblRoom = new JLabel("2218");
			lblRoom.setBounds(145, 450, 85, 14);
			frame.getContentPane().add(lblRoom);

			JLabel lblmove = new JLabel("Room");
			lblmove.setBounds(400, 220, 85, 14);
			frame.getContentPane().add(lblmove);

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

			coName.setBounds(500, 80, 86, 20);
			frame.getContentPane().add(coName);
			coName.addItem("BRYAN");;
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
			txtRoom.setBounds(450, 220, 86, 20);
			frame.getContentPane().add(txtRoom);
			

			btnAddButton = new JButton("ADD");

			btnAddButton.setBounds(276, 52, 86, 20);
			frame.getContentPane().add(btnAddButton);

			btnReAddButton = new JButton("<=MOVE");
			btnReAddButton.setBounds(330, 300, 86, 20);
			frame.getContentPane().add(btnReAddButton);

			btnSaveButton = new JButton("SAVE");

			btnSaveButton.setBounds(276, 108, 86, 20);
			frame.getContentPane().add(btnSaveButton);

			btnRemoveButton = new JButton("REMOVE");

			btnRemoveButton.setBounds(276, 157, 86, 20);
			frame.getContentPane().add(btnRemoveButton);

			frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { combo1, txtModel, textField_2,
					textField_3, btnAddButton, btnSaveButton, btnRemoveButton }));
			try {

				computers = InventoryList.readInventory("testfiles/Inventory.csv");

				removedComputers = InventoryList.readInventory("testfiles/RemovedAsset.csv");

				for (int i = 0; i < removedComputers.size(); i++) {
					computer = removedComputers.get(i);
					removeList.addElement(computer.toString());

				}
				
				for (int i = 0; i < computers.size(); i++) {
					computer = computers.get(i);
					model.addElement(computer.toString());

				}
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

			scrollBar = new JScrollPane();
			scrollBar.setViewportView(textArea);
			frame.add(scrollBar);
			textArea.setBounds(21, 251, 300, 200);
			frame.getContentPane().add(textArea);

			textArea.setModel(model);

			removeArea.setBounds(440, 251, 310, 200);
			frame.getContentPane().add(removeArea);
			removeArea.setModel(removeList);
			
			textField_2.setText("856");
			btnAddButton.addActionListener(this);
			btnReAddButton.addActionListener(this);
			btnRemoveButton.addActionListener(this);
			btnSaveButton.addActionListener(this);
		}
		/* END OF GUI BIULD */

		@Override
		public void actionPerformed(ActionEvent e) {

			int addButtonClick = 0;
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
			
			String location = txtRoom.getText().toUpperCase();

			try {

				modelC = modelC.substring(0, 4);
				assetId = assetId.substring(0, 9);

			} catch (StringIndexOutOfBoundsException e1) {

			}
			if (e.getSource() == btnAddButton) {

				addButtonClick = addButtonClick + 1;

				try {
					computer = new Computers(name, modelC, assetId, serial, arcutecture);

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
			if (e.getSource() == btnRemoveButton) {

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

					removedComputers.add(com);
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
					
					JDialog dialog = optionPane.createDialog(getParent(), "Save");

					dialog.setVisible(true);

					try {
						InventoryList.writeInventory(fileName, computers);

						InventoryList.writeInventory(removeAsset, removedComputers);

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
					Computers com = removedComputers.get(removeAreaIndex);

					removedComputers.remove(com);
					removeList.remove(removeAreaIndex);

					computers.add(com);
					model.addElement(com.toString());
					textArea.setModel(model);

					removeArea.setModel(removeList);

				} catch (ArrayIndexOutOfBoundsException e2) {

				} catch (IndexOutOfBoundsException e2) {

				}

			}

		}

	}

}
