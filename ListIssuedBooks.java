//import the packages for using the classes in them into the program
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.SQLException;

/**
 *A public class
 */
public class ListIssuedBooks extends JInternalFrame {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the North Panel
    private JPanel northPanel = new JPanel();
    //for creating the Center Panel
    private JPanel centerPanel = new JPanel();
    //for creating the label
    private JLabel label = new JLabel("THE LIST FOR THE BORROWED BOOKS");
    //for creating the button
    private JButton printButton;
    //for creating the table
    private JTable table;
    //for creating the TableColumn
    private TableColumn column = null;
    //for creating the JScrollPane
    private JScrollPane scrollPane;

    //for creating an object for the ResultSetTableModel class
    private ResultSetTableModel tableModel;
    /***************************************************************************
     * for setting the required information for the ResultSetTableModel class. *
     ***************************************************************************/
    private static final String JDBC_DRIVER = "sun.jdbc.odbc.JdbcOdbcDriver";
    private static final String DATABASE_URL = "jdbc:odbc:JLibrary";
    private static final String DEFAULT_QUERY = "SELECT B.BookID, BK.Title, B.MemberID," +
            " B.DayOfBorrowed, B.DayOfReturn, M.ID, M.Name, M.Email" +
            " FROM Borrow AS B, Books AS BK, Members AS M " +
            "WHERE (B.BookId=BK.BookId) and (B.MemberID=M.MemberID)";


    //constructor of listBorrowedBooks
    public ListIssuedBooks() {
        //for setting the title for the internal frame
        super("Borrowed Books", false, true, false, true);
        setFrameIcon(new ImageIcon(ClassLoader.getSystemResource("images/List16.gif")));
        //for getting the graphical user interface components display area
        Container cp = getContentPane();

        //for bassing the required information to the ResultSetTableModel object
        try {
            tableModel = new ResultSetTableModel(JDBC_DRIVER, DATABASE_URL, DEFAULT_QUERY);
            //for setting the Query
            try {
                tableModel.setQuery(DEFAULT_QUERY);
            } catch (SQLException sqlEx) {
                JOptionPane.showMessageDialog(null, "Cannot retrieve data from tables," + sqlEx.getMessage());
            }
        } catch (ClassNotFoundException classNotFound) {
            JOptionPane.showMessageDialog(null, "Cannot retrieve data from tables," + classNotFound.getMessage());
        } catch (SQLException sqlException) {
            JOptionPane.showMessageDialog(null, "Cannot retrieve data from tables," + sqlException.getMessage());
        }
        //for setting the table with the information
        table = new JTable(tableModel);
        //for setting the size for the table
        table.setPreferredScrollableViewportSize(new Dimension(990, 200));
        //for setting the font
        table.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //for setting the scrollpane to the table
        scrollPane = new JScrollPane(table);

        //for setting the size for the table columns
        for (int i = 0; i < 8; i++) {
            column = table.getColumnModel().getColumn(i);
            if (i == 0) //BookID
            {
                column.setPreferredWidth(15);
            }
            if (i == 1) //Title
            {
                column.setPreferredWidth(100);
            }
            if (i == 2) //MemberID
            {
                column.setPreferredWidth(15);
            }
            if (i == 3) //DayOfBorrowed
            {
                column.setPreferredWidth(30);
            }
            if (i == 4) //DayOfReturn
            {
                column.setPreferredWidth(30);
            }
            if (i == 5) //ID
            {
                column.setPreferredWidth(10);
            }
            if (i == 6) //Name
            {
                column.setPreferredWidth(80);
            }
            if (i == 7) //Email
            {
                column.setPreferredWidth(100);
            }

        }
        //for setting the font to the label
        label.setFont(new Font("Tahoma", Font.BOLD, 14));
        //for setting the layout to the panel
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //for adding the label to the panel
        northPanel.add(label);
        //for adding the panel to the container
        cp.add("North", northPanel);

        //for setting the layout to the panel
        centerPanel.setLayout(new BorderLayout());
        //for creating an image for the button
        ImageIcon printIcon = new ImageIcon(ClassLoader.getSystemResource("images/Print16.gif"));
        //for adding the button to the panel
        printButton = new JButton("print the books", printIcon);
        //for setting the tip text
        printButton.setToolTipText("Print");
        //for setting the font to the button
        printButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        //for adding the button to the panel
        centerPanel.add(printButton, BorderLayout.NORTH);
        //for adding the scrollpane to the panel
        centerPanel.add(scrollPane, BorderLayout.CENTER);
        //for setting the border to the panel
        centerPanel.setBorder(BorderFactory.createTitledBorder("Borrowed books:"));
        //for adding the panel to the container
        cp.add("Center", centerPanel);

        //for adding the actionListener to the button
        printButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent ae) {
                Thread runner = new Thread() {

                    public void run() {
                        try {
                            PrinterJob prnJob = PrinterJob.getPrinterJob();
                            prnJob.setPrintable(new PrintingBooks(DEFAULT_QUERY));
                            if (!prnJob.printDialog()) {
                                return;
                            }
                            setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                            prnJob.print();
                            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
                        } catch (PrinterException ex) {
                            System.out.println("Printing error: " + ex.toString());
                        }
                    }
                };
                runner.start();
            }
        });
        //for setting the visible to true
        setVisible(true);
        //to show the frame
        pack();
    }

   
}//class closed

