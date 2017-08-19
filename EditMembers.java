

//import the packages for using the classes in them into the program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *A public class
 */
public class EditMembers extends JInternalFrame {
	/***************************************************************************
	 ***      declaration of the private variables used in the program       ***
	 ***************************************************************************/

	//for creating the North Panel
	private JPanel northPanel = new JPanel();
	//for creaing the North Label
	private JLabel northLabel = new JLabel("MEMBER INFORMATION");

	//for creating the Center Panel
	private JPanel centerPanel = new JPanel();
	//for creating the edit Panel
	private JPanel editPanel = new JPanel();
	//for creating the edit information Panel
	private JPanel editInformationPanel = new JPanel();
	//for creating the edit label panel
	private JPanel editInformationLabelPanel = new JPanel();
	//for creating the edit textField panel
	private JPanel editInformationTextFieldPanel = new JPanel();
	//for creating the edit button panel
	private JPanel editButtonPanel = new JPanel();

	//for creating the label
	private JLabel editLabel = new JLabel("MemberID: ");
	//for creating the textField
	private JTextField editTextField = new JTextField(25);
	//for creating the button
	private JButton editButton = new JButton("Edit");

	//for creating the information Panel
	private JPanel informationPanel = new JPanel();
	//for creating an Internal Panel in the center panel
	private JPanel informationLabelPanel = new JPanel();
	//for creating an array of JLabel
	private JLabel[] informationLabel = new JLabel[7];
	//for creating an array of String
	private String[] informaionString = {" Member ID: ", " The Password: ", " Rewrite the password: ",
	                                     " The Name: ", " E-MAIL: ", " Major:", " Expired: "};
	//for creating an Internal Panel in the center panel
	private JPanel informationTextFieldPanel = new JPanel();
	//for creating an array of JTextField
	private JTextField[] informationTextField = new JTextField[5];
	//for creating an array of JPasswordField
	private JPasswordField[] informationPasswordField = new JPasswordField[2];

	//for creating an Internal Panel in the center panel
	private JPanel updateInformationButtonPanel = new JPanel();
	//for creating a button
	private JButton updateInformationButton = new JButton("Update the Information");

	//for creating the South Panel
	private JPanel southPanel = new JPanel();
	//for creating a button
	private JButton OKButton = new JButton("Exit");

	//create objects from another classes for using them in the ActionListener
	private Members member;
	//for creating an array of string to store the data
	private String[] data;

	//for checking the password
	public boolean isPasswordCorrect() {
		if (informationPasswordField[0].getText().equals(informationPasswordField[1].getText()))
			data[1] = informationPasswordField[0].getText();
		else if (!informationPasswordField[0].getText().equals(informationPasswordField[1].getText()))
			return false;

		return true;
	}

	//for checking the information from the text field
	public boolean isCorrect() {
		data = new String[6];
		for (int i = 0; i < informationLabel.length; i++) {
			if (i == 0) {
				if (!informationTextField[i].getText().equals("")) {
					data[i] = informationTextField[i].getText();
				}
				else
					return false;
			}
			if (i == 1 || i == 2) {
				if (informationPasswordField[i - 1].getText().equals(""))
					return false;
			}
			if (i == 3 || i == 4 || i == 5 || i == 6) {
				if (!informationTextField[i - 2].getText().equals("")) {
					data[i - 1] = informationTextField[i - 2].getText();
				}
				else
					return false;
			}
		}
		return true;
	}

	//for checking the information from the text field
	public boolean isEditCorrect() {
		if (editTextField.getText().equals(""))
			return false;
		return true;
	}

	//for setting the array of JTextField & JPasswordField to null
	public void clearTextField() {
		editTextField.setText(null);
		for (int i = 0; i < informationLabel.length; i++) {
			if (i == 0)
				informationTextField[i].setText(null);
			if (i == 1 || i == 2)
				informationPasswordField[i - 1].setText(null);
			if (i == 3 || i == 4 || i == 5 || i == 6)
				informationTextField[i - 2].setText(null);
		}
	}

	//constructor of addMembers
	public EditMembers() {
		//for setting the title for the internal frame
		super("Edit Members", false, true, false, true);
		//for setting the icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Edit16.gif")));
		//for getting the graphical user interface components display area
		Container cp = getContentPane();

		//for setting the layout
		northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//for setting the font
		northLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		//for adding the label to the panel
		northPanel.add(northLabel);
		//for adding the panel to the container
		cp.add("North", northPanel);

		//for setting the layout
		centerPanel.setLayout(new BorderLayout());
		//for setting the layout
		editPanel.setLayout(new BorderLayout());
		//for setting the border to the panel
		editPanel.setBorder(BorderFactory.createTitledBorder("MemberID: "));
		//for setting the layout
		editInformationPanel.setLayout(new BorderLayout());
		//for setting the layout
		editInformationLabelPanel.setLayout(new GridLayout(1, 1, 1, 1));
		//for adding the label to the panel
		editInformationLabelPanel.add(editLabel);
		//for setting the font to the label
		editLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		//for adding the editInformationLabelPanel to the editInformationLabel
		editInformationPanel.add("West", editInformationLabelPanel);
		//for setting the layout
		editInformationTextFieldPanel.setLayout(new GridLayout(1, 1, 1, 1));
		//for adding the textField to the panel
		editInformationTextFieldPanel.add(editTextField);
		//for setting the font to the textField
		editTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//for adding the editInformationTextField to the editInformationPanel
		editInformationPanel.add("East", editInformationTextFieldPanel);
		//for adding the editInformationPanel to the editPanel
		editPanel.add("North", editInformationPanel);
		//for setting the layout
		editButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//for adding the button to the panel
		editButtonPanel.add(editButton);
		//for setting the fonr to the button
		editButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		//for adding the editInformationButtonPanel to the editPanel
		editPanel.add("Center", editButtonPanel);
		//for adding the editPanel to the centerPanel
		centerPanel.add("North", editPanel);

		//for setting the layout
		informationPanel.setLayout(new BorderLayout());
		//for setting the border to the panel
		informationPanel.setBorder(BorderFactory.createTitledBorder("Edit a member: "));
		//for setting the layout
		informationLabelPanel.setLayout(new GridLayout(7, 1, 1, 1));
		//for setting the layout
		informationTextFieldPanel.setLayout(new GridLayout(7, 1, 1, 1));
		/***********************************************************************
		 * for adding the strings to the labels, for setting the font		   *
		 * and adding these labels to the panel.							   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		for (int i = 0; i < informationLabel.length; i++) {
			informationLabelPanel.add(informationLabel[i] = new JLabel(informaionString[i]));
			informationLabel[i].setFont(new Font("Tahoma", Font.BOLD, 11));
		}
		//for adding the panel to the centerPanel
		informationPanel.add("West", informationLabelPanel);

		/***********************************************************************
		 * for adding the JTextField and JPasswordField to the panel and       *
		 * setting the font to the JTextField and JPasswordField. Finally      *
		 * adding the panel to the centerPanel                                 *
		 ***********************************************************************/
		for (int i = 0; i < informationLabel.length; i++) {
			if (i == 1 || i == 2) {
				informationTextFieldPanel.add(informationPasswordField[i - 1] = new JPasswordField(25));
				informationPasswordField[i - 1].setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			if (i == 0) {
				informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
			if (i == 3 || i == 4 || i == 5 || i == 6) {
				informationTextFieldPanel.add(informationTextField[i - 2] = new JTextField(25));
				informationTextField[i - 2].setFont(new Font("Tahoma", Font.PLAIN, 11));
			}
		}
		informationPanel.add("East", informationTextFieldPanel);

		/***********************************************************************
		 * for setting the layout for the panel,setting the font for the button*
		 * and adding the button to the panel.								   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		updateInformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		updateInformationButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		updateInformationButtonPanel.add(updateInformationButton);
		informationPanel.add("South", updateInformationButtonPanel);
		centerPanel.add("Center", informationPanel);
		cp.add("Center", centerPanel);

		/***********************************************************************
		 * for setting the layout for the panel,setting the font for the button*
		 * adding the button to the panel & setting the border.				   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		OKButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		southPanel.add(OKButton);
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		cp.add("South", southPanel);

		/***********************************************************************
		 * for adding the action listener to the button,first the text will be *
		 * taken from the JTextField[] and make the connection for database,   *
		 * after that update the table in the database with the new value      *
		 ***********************************************************************/
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//for checking if there is a missing information
				if (isEditCorrect()) {
					Thread runner = new Thread() {
						public void run() {
							member = new Members();
							//for checking if there is no same information in the database
							member.connection("SELECT * FROM Members WHERE MemberID = " + editTextField.getText());
							int ID = member.getID();
							if (ID > 0) {
								informationTextField[0].setText(member.getID() + "");
								informationTextField[1].setText(member.getName());
								informationTextField[2].setText(member.getEmail());
								informationTextField[3].setText(member.getMajor());
								informationTextField[4].setText(member.getExpired() + "");
								informationPasswordField[0].setText(member.getPassword());
								informationPasswordField[1].setText(member.getPassword());
							}
							else {
								JOptionPane.showMessageDialog(null, "Please, write a correct MemberID", "Error", JOptionPane.ERROR_MESSAGE);
								editTextField.setText(null);
								clearTextField();
							}
						}
					};
					runner.start();
				}
				else {
					JOptionPane.showMessageDialog(null, "Please, write the MemberID", "Warning", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		/***********************************************************************
		 * for adding the action listener to the button,first the text will be *
		 * taken from the JTextField[] and make the connection for database,   *
		 * after that update the table in the database with the new value      *
		 ***********************************************************************/
		updateInformationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				//for checking if there is a missing information
				if (isCorrect()) {
					if (isPasswordCorrect()) {
						Thread runner = new Thread() {
							public void run() {
								member = new Members();
								//for updting the members database
								member.update("UPDATE Members SET ID = " + data[0] + ", Password = '" + data[1] + "', Name = '" +
								        data[2] + "', EMail = '" + data[3] + "', Major = '" + data[4] + "', Expired = '" +
								        data[5] + "' WHERE MemberID = " + editTextField.getText());
								//for setting the array of JTextField to empty
								clearTextField();
							}
						};
						runner.start();
					}
					//if the password is wrong
					else
						JOptionPane.showMessageDialog(null, "the passowrd is wrong", "Error", JOptionPane.ERROR_MESSAGE);
				}
				//if there is a missing data, then display Message Dialog
				else
					JOptionPane.showMessageDialog(null, "Please, complete the information", "Warning", JOptionPane.WARNING_MESSAGE);
			}
		});
		//for adding the action listener for the button to dispose the frame
		OKButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});
		//for setting the visible to true
		setVisible(true);
		//show the internal frame
		pack();
	}
}