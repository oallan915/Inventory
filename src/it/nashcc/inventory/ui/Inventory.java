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
	
	private JTextField textField = new JTextField();
	
	private JTextField textField_1 = new JTextField();
	
	private JTextField textField_2 = new JTextField();
	
	private JTextField textField_3;

	private JButton btnAddButton;

	private JButton btnSaveButton;

	private JButton btnRemoveButton;

	private JList<String> textArea = new JList<String>();

	private DefaultListModel<String> model = new DefaultListModel<String>();

	private JScrollPane scrollBar;

	private List<Computers> computers = new ArrayList<Computers>();

	private Computers computer;

	private JPanel panel;

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
		} catch (IllegalStateException e) {
			System.exit(1);
		}

		new InventoryPanel();

		// Create JPanel that will hold the rest of the GUI information.
		// The JPanel utilizes a CardLayout, which stacks several different
		// JPanels. User actions lead to switching which "Card" is visible.
		panel = new JPanel();
		
		
	
		

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
			frame.setBounds(100, 100, 773, 724);
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

			JLabel lblNewLabel = new JLabel("Machine Name");
			lblNewLabel.setBounds(30, 55, 85, 14);
			frame.getContentPane().add(lblNewLabel);

			JLabel lblNewLabel_1 = new JLabel("Machine Model");
			lblNewLabel_1.setBounds(30, 94, 98, 34);
			frame.getContentPane().add(lblNewLabel_1);

			JLabel lblNewLabel_2 = new JLabel("Asset Tag Number");
			lblNewLabel_2.setBounds(30, 150, 98, 34);
			frame.getContentPane().add(lblNewLabel_2);

			JLabel lblNewLabel_3 = new JLabel("Serial Number");
			lblNewLabel_3.setBounds(30, 180, 85, 45);
			frame.getContentPane().add(lblNewLabel_3);

			JLabel lblNashItInventory = new JLabel(" Nash IT Inventory");
			lblNashItInventory.setBounds(561, 71, 127, 74);
			frame.getContentPane().add(lblNashItInventory);

			JLabel lblName = new JLabel("Name");
			lblName.setBounds(20, 233, 85, 14);
			frame.getContentPane().add(lblName);

			JLabel lblModel = new JLabel("Model");
			lblModel.setBounds(70, 233, 85, 14);
			frame.getContentPane().add(lblModel);

			JLabel lblAsset = new JLabel("Asset");
			lblAsset.setBounds(145, 233, 85, 14);
			frame.getContentPane().add(lblAsset);

			JLabel lblSerial = new JLabel("Serial");
			lblSerial.setBounds(245, 233, 85, 14);
			frame.getContentPane().add(lblSerial);
			
			JLabel lblRoom = new JLabel("2218");
			lblRoom.setBounds(145, 450, 85, 14);
			frame.getContentPane().add(lblRoom);

			
			
			combo1.setBounds(160, 52, 86, 20);
			frame.getContentPane().add(combo1);
			
			combo1.addItem("DELL");//.setToolTipText("Cannot be empty.\nOnly accepts 4 characters");
			combo1.addItem("HP");
			combo1.addItem("SURFACE");
			combo1.addItem("SHARP");
			combo1.addItem("LENNOVO");

			textField_1.setBounds(160, 108, 86, 20);
			frame.getContentPane().add(textField_1);
			textField_1.setToolTipText("Cannot be empty.\nOnly accepts 4 characters");

			textField_2.setBounds(160, 157, 86, 20);
			frame.getContentPane().add(textField_2);
			textField_2.setToolTipText("Only accepts 9 characters");

			textField_3 = new JTextField();
			textField_3.setBounds(160, 193, 86, 20);
			frame.getContentPane().add(textField_3);

			btnAddButton = new JButton("ADD");

			btnAddButton.setBounds(276, 52, 86, 20);
			frame.getContentPane().add(btnAddButton);

			btnSaveButton = new JButton("SAVE");

			btnSaveButton.setBounds(276, 108, 86, 20);
			frame.getContentPane().add(btnSaveButton);

			btnRemoveButton = new JButton("Remove");

			btnRemoveButton.setBounds(276, 157, 86, 20);
			frame.getContentPane().add(btnRemoveButton);

			frame.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[] { combo1, textField_1,
					textField_2, textField_3, btnAddButton, btnSaveButton, btnRemoveButton }));
			try {

				computers = InventoryList.readInventory("testfiles/Inventory.csv");

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

			textField_2.setText("856"); 
			btnAddButton.addActionListener(this);
			btnRemoveButton.addActionListener(this);
			btnSaveButton.addActionListener(this);
		}
		/* END OF GUI BIULD */

		@Override
		public void actionPerformed(ActionEvent e) {

			int addButtonClick = 0;

			String fileName = "testfiles/Inventory.csv";
			File file = new File("testfiles/Inventory.csv");

			String name = combo1.getSelectedItem() + "";
			String modelC = textField_1.getText().toUpperCase();
			String assetId = textField_2.getText().toUpperCase();
			String serial = textField_3.getText().toUpperCase();

			try {
				name = name.substring(0, 4);
				modelC = modelC.substring(0, 4);
				assetId = assetId.substring(0, 9);
			} catch (StringIndexOutOfBoundsException e1) {

			}
			if (e.getSource() == btnAddButton) {

				addButtonClick = addButtonClick + 1;

				try {
					computer = new Computers(name, modelC, assetId, serial);

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
				textField_1.setText("");
				textField_2.setText("856");
				textField_3.setText("");
			}
			/* REMOVE BUTTON CLICK */
			if (e.getSource() == btnRemoveButton) {

				textField.setText("");
				textField_1.setText("");
				textField_2.setText("856");
				textField_3.setText("");

				int index = textArea.getSelectedIndex();

				if (index == -1) {
					JOptionPane.showMessageDialog(frame, "Must select an Asset", "Selection Error",
							JOptionPane.ERROR_MESSAGE);

				} else {

					Computers com = computers.get(index);

					computers.remove(com);
					System.out.println(computers.toString());
					System.out.println(computers.size());
					model.remove(index);

					textArea.ensureIndexIsVisible(model.size());
					textArea.setModel(model);
					textArea.setVisibleRowCount(10);

				}
			}
			/* SAVE BUTTON CLICK */
			if (e.getSource() == btnSaveButton) {

				try {
					file.delete();
					JOptionPane optionPane = new JOptionPane("Save file?", JOptionPane.QUESTION_MESSAGE,
							JOptionPane.YES_NO_OPTION);
					JDialog dialog = optionPane.createDialog(getParent(), "Manual Creation");
					dialog.setVisible(true);

					try {
						InventoryList.writeInventory(fileName, computers);
					} catch (IOException e1) {

						e1.printStackTrace();
					}
					textArea.setVisibleRowCount(10);

				} catch (NullPointerException e6) {

					textField_2.setText("856");

				}

			}

		}

	}

}
