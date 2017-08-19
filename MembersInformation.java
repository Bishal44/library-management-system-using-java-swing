

//import the packages for using the classes in them into the program

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *A public class
 */
public class MembersInformation extends JInternalFrame {
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
	private JPanel memberIDPanel = new JPanel();
	//for creating the edit information Panel
	private JPanel memberIDInformationPanel = new JPanel();
	//for creating the edit label panel
	private JPanel memberIDInformationLabelPanel = new JPanel();
	//for creating the edit textField panel
	private JPanel memberIDInformationTextFieldPanel = new JPanel();
	//for creating the edit button panel
	private JPanel memberIDButtonPanel = new JPanel();

	//for creating the label
	private JLabel memberIDLabel = new JLabel("MemberID: ");
	//for creating the textField
	private JTextField memberIDTextField = new JTextField(25);
	//for creating the button
	private JButton memberIDButton = new JButton("OK");

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
	private JPanel InformationButtonPanel = new JPanel();
	//for creating a button
	private JButton fButton = new JButton(">");

	//for creating the South Panel
	private JPanel southPanel = new JPanel();
	//for creating a button
	private JButton exitButton = new JButton("Exit");

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
		if (memberIDTextField.getText().equals(""))
			return false;
		return true;
	}

	//for setting the array of JTextField & JPasswordField to null
	public void clearTextField() {
		memberIDTextField.setText(null);
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
	public MembersInformation() {
		//for setting the title for the internal frame
		super("Members Information", false, true, false, true);
		//for setting the icon
		setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/Information16.gif")));
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
		memberIDPanel.setLayout(new BorderLayout());
		//for setting the border to the panel
		memberIDPanel.setBorder(BorderFactory.createTitledBorder("MemberID: "));
		//for setting the layout
		memberIDInformationPanel.setLayout(new BorderLayout());
		//for setting the layout
		memberIDInformationLabelPanel.setLayout(new GridLayout(1, 1, 1, 1));
		//for adding the label to the panel
		memberIDInformationLabelPanel.add(memberIDLabel);
		//for setting the font to the label
		memberIDLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		//for adding the editInformationLabelPanel to the editInformationLabel
		memberIDInformationPanel.add("West", memberIDInformationLabelPanel);
		//for setting the layout
		memberIDInformationTextFieldPanel.setLayout(new GridLayout(1, 1, 1, 1));
		//for adding the textField to the panel
		memberIDInformationTextFieldPanel.add(memberIDTextField);
		//for setting the font to the textField
		memberIDTextField.setFont(new Font("Tahoma", Font.PLAIN, 11));
		//for adding the editInformationTextField to the editInformationPanel
		memberIDInformationPanel.add("East", memberIDInformationTextFieldPanel);
		//for adding the editInformationPanel to the editPanel
		memberIDPanel.add("North", memberIDInformationPanel);
		//for setting the layout
		memberIDButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//for adding the button to the panel
		memberIDButtonPanel.add(memberIDButton);
		//for setting the fonr to the button
		memberIDButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		//for adding the editInformationButtonPanel to the editPanel
		memberIDPanel.add("Center", memberIDButtonPanel);
		//for adding the editPanel to the centerPanel
		centerPanel.add("North", memberIDPanel);

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
				informationPasswordField[i - 1].setEnabled(false);
			}
			if (i == 0) {
				informationTextFieldPanel.add(informationTextField[i] = new JTextField(25));
				informationTextField[i].setFont(new Font("Tahoma", Font.PLAIN, 11));
				informationTextField[i].setEditable(false);
			}
			if (i == 3 || i == 4 || i == 5 || i == 6) {
				informationTextFieldPanel.add(informationTextField[i - 2] = new JTextField(25));
				informationTextField[i - 2].setFont(new Font("Tahoma", Font.PLAIN, 11));
				informationTextField[i - 2].setEditable(false);
			}
		}
		informationPanel.add("East", informationTextFieldPanel);

		/***********************************************************************
		 * for setting the layout for the panel,setting the font for the button*
		 * and adding the button to the panel.								   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		InformationButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		fButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		InformationButtonPanel.add(fButton);
		informationPanel.add("South", InformationButtonPanel);
		centerPanel.add("Center", informationPanel);
		cp.add("Center", centerPanel);

		/***********************************************************************
		 * for setting the layout for the panel,setting the font for the button*
		 * adding the button to the panel & setting the border.				   *
		 * finally adding the panel to the container						   *
		 ***********************************************************************/
		southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		exitButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		southPanel.add(exitButton);
		southPanel.setBorder(BorderFactory.createEtchedBorder());
		cp.add("South", southPanel);

		//for adding the action listener for the button to dispose the frame
		exitButton.addActionListener(new ActionListener() {
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