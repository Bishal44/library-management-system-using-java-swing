
//import the packages for using the classes in them into the program
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 *A public class
 */
public class JLibrary extends JFrame implements ActionListener {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the JPanel
    private JPanel searchPanel = new JPanel();
    //for creating the JToolBar for the program
    private JToolBar searchToolBar = new JToolBar();
    //for creating the label
    private JLabel searchLabel = new JLabel("Book title: ");
    //for creating the JTextField to use it on the searchToolBar
    private JTextField searchTextField = new JTextField(15);
    //for creating the JButton to use it on the searchToolBar
    private JButton goButton = new JButton("Go");
    //for creating JTabbedPane
    //private JTabbedPane tabbedPane = new JTabbedPane();
    //for creating JDeskTopPane for using JInternalFrame on the desktop
    private JDesktopPane desktop = new JDesktopPane();
    //private JDesktopPane desktop;
    //for creating JSplitPane
    private JSplitPane splitPane;
    //for creating JScrollPane for JDesktopPane
    private JScrollPane desktopScrollPane;
    private JScrollPane treeScrollPane;
    //for creating the background
    //private ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("images/Logo.JPG"));
    //for creating JLabel
    //private JLabel background = new JLabel(icon);
    /***************************************************************************
     *create objects from another classes for using them in the ActionListener *
     ***************************************************************************/
    private Menubar menu;
    private Toolbar toolbar;
    private StatusBar statusbar = new StatusBar();
    private ListBooks listBooks;
    private AddBooks addBooks;
    private ListAvailbleBooks listAvailble;
    private ListBorrowedBooks listBorrowed;
    private EditBooks editBooks;
    private RemoveBooks removeBooks;
    private BorrowBooks borrowBooks;
    private ReturnBooks returnBooks;
    //private BooksInformation booksInformation;
    private AddMembers addMembers;
    private ListMembers listMembers;
    private EditMembers editMembers;
    private RemoveMembers removeMembers;
    private MembersInformation membersInformation;
    private SearchBooksAndMembers search;


    //constructor of JLibrary
    public JLibrary() {
        //for setting the title for the frame
        super("JAVA� Library System - JLibrary");
        //for setting the size
        Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        //setSize(screenSize.width, screenSize.height - 30);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        //for setting resizable to false
        //setResizable(false);

        /**
         *for settting an icon for the program
         */
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image image = kit.getImage(ClassLoader.getSystemResource("images/Host16.gif"));
        setIconImage(image);

        menu = new Menubar();
        toolbar = new Toolbar();
        //for setting the menu bar
        setJMenuBar(menu);
        //for adding the actionListener
        menu.printBook.addActionListener(this);
        menu.exit.addActionListener(this);
        menu.addBook.addActionListener(this);
        menu.listBook.addActionListener(this);
        menu.listAvailbleBook.addActionListener(this);
        menu.listBorrowedBook.addActionListener(this);
        menu.editBook.addActionListener(this);
        menu.removeBook.addActionListener(this);
        //menu.bookInformation.addActionListener(this);
        menu.addMember.addActionListener(this);
        menu.listMember.addActionListener(this);
        menu.editMember.addActionListener(this);
        menu.removeMember.addActionListener(this);
        menu.memberInformation.addActionListener(this);
        menu.searchBooksAndMembers.addActionListener(this);
        menu.borrowBook.addActionListener(this);
        menu.returnBook.addActionListener(this);
        menu.listissuedbooks.addActionListener(this);
        menu.reserveBook.addActionListener(this);
        menu.help.addActionListener(this);
        menu.about.addActionListener(this);

        //get the graphical user interface components display the desktop
        Container cp = getContentPane();
        desktop.setBackground(Color.GRAY);
        cp.add("Center", desktop);
        //for setting the font
        searchLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        //for setting the font
        searchTextField.setFont(new Font("Tahoma", Font.PLAIN, 12));
        goButton.setFont(new Font("Tahoma", Font.BOLD, 9));
        //for adding the searchLable to the searchToolBar
        searchToolBar.add(searchLabel);
        //for adding the searchTextField to searchToolBar
        searchToolBar.add(searchTextField);
        //for adding the goButton to searchToolBar
        searchToolBar.add(goButton);
        //for adding listenerAction for the button
        goButton.addActionListener(this);
        //for setting the layout
        searchPanel.setLayout(new BorderLayout());
        //for adding the toolBar to the searchPanel
        searchPanel.add("Center", toolbar);
        //for adding the searchToolBar to the searchPanel
        //searchPanel.add("South", searchToolBar);
        //for adding the searchPanel to the Container
        cp.add("North", searchPanel);
        //for adding the statusbar to the Container
        cp.add("South", statusbar);

        for (int i = 0; i < toolbar.imageName24.length; i++) {
            //for adding the action to the button
            toolbar.button[i].addActionListener(this);
        }

        //for adding WindowListener to the program
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        //show the program
        show();
    }

    /**
     *this method is invoked when an action occurs.
     *@param ae the action event.
     */
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == menu.addBook || ae.getSource() == toolbar.button[0]) {
            Thread runner = new Thread() {

                public void run() {
                    addBooks = new AddBooks();
                    desktop.add(addBooks);
                    try {
                        addBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listBook || ae.getSource() == toolbar.button[1]) {
            Thread runner = new Thread() {

                public void run() {
                    listBooks = new ListBooks();
                    desktop.add(listBooks);
                    try {
                        listBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listAvailbleBook || ae.getSource() == toolbar.button[2]) {
            Thread runner = new Thread() {

                public void run() {
                    listAvailble = new ListAvailbleBooks();
                    desktop.add(listAvailble);
                    try {
                        listAvailble.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listBorrowedBook || ae.getSource() == toolbar.button[3]) {
            Thread runner = new Thread() {

                public void run() {
                    listBorrowed = new ListBorrowedBooks();
                    desktop.add(listBorrowed);
                    try {
                        listBorrowed.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.editBook || ae.getSource() == toolbar.button[4]) {
            Thread runner = new Thread() {

                public void run() {
                    editBooks = new EditBooks();
                    desktop.add(editBooks);
                    try {
                        editBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.removeBook || ae.getSource() == toolbar.button[5]) {
            Thread runner = new Thread() {

                public void run() {
                    removeBooks = new RemoveBooks();
                    desktop.add(removeBooks);
                    try {
                        removeBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        /*	if (ae.getSource() == menu.bookInformation || ae.getSource() == toolbar.button[6]) {
        Thread runner = new Thread() {
        public void run() {
        booksInformation = new BooksInformation();
        desktop.add(booksInformation);
        try {
        booksInformation.setSelected(true);
        }
        catch (java.beans.PropertyVetoException e) {
        }
        }
        };
        runner.start();
        }*/
        if (ae.getSource() == menu.addMember || ae.getSource() == toolbar.button[7]) {
            Thread runner = new Thread() {

                public void run() {
                    addMembers = new AddMembers();
                    desktop.add(addMembers);
                    try {
                        addMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.listMember || ae.getSource() == toolbar.button[8]) {
            Thread runner = new Thread() {

                public void run() {
                    listMembers = new ListMembers();
                    desktop.add(listMembers);
                    try {
                        listMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.editMember || ae.getSource() == toolbar.button[9]) {
            Thread runner = new Thread() {

                public void run() {
                    editMembers = new EditMembers();
                    desktop.add(editMembers);
                    try {
                        editMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.removeMember || ae.getSource() == toolbar.button[10]) {
            Thread runner = new Thread() {

                public void run() {
                    removeMembers = new RemoveMembers();
                    desktop.add(removeMembers);
                    try {
                        removeMembers.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.memberInformation || ae.getSource() == toolbar.button[11]) {
            Thread runner = new Thread() {

                public void run() {
                    membersInformation = new MembersInformation();
                    desktop.add(membersInformation);
                    try {
                        membersInformation.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.searchBooksAndMembers || ae.getSource() == toolbar.button[12]) {
            Thread runner = new Thread() {

                public void run() {
                    search = new SearchBooksAndMembers();
                    desktop.add(search);
                    try {
                        search.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.borrowBook || ae.getSource() == toolbar.button[13]) {
            Thread runner = new Thread() {

                public void run() {
                    borrowBooks = new BorrowBooks();
                    desktop.add(borrowBooks);
                    try {
                        borrowBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.returnBook || ae.getSource() == toolbar.button[14]) {
            Thread runner = new Thread() {

                public void run() {
                    returnBooks = new ReturnBooks();
                    desktop.add(returnBooks);
                    try {
                        returnBooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }

        if (ae.getSource() == menu.reserveBook) {
            Thread runner = new Thread() {

                public void run() {
                    ReserveBook reserveBook = new ReserveBook();
                    desktop.add(reserveBook);
                    try {
                        reserveBook.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }

        if (ae.getSource() == menu.help || ae.getSource() == toolbar.button[15]) {
        //
        }
        if (ae.getSource() == menu.about || ae.getSource() == toolbar.button[16]) {
            Thread runner = new Thread() {

                public void run() {
                    JOptionPane.showMessageDialog(null, new About(), "About JLibrary", JOptionPane.PLAIN_MESSAGE);
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.printBook || ae.getSource() == toolbar.button[17]) {
            Thread runner = new Thread() {

                public void run() {
                //Print.printComponent(new JLibrary());
                }
            };
            runner.start();
        }
        if (ae.getSource() == menu.exit || ae.getSource() == toolbar.button[18]) {
            dispose();
            System.exit(0);
        }
        if(ae.getSource()==menu.listissuedbooks){
            Thread runner = new Thread() {

                public void run() {
                    ListIssuedBooks listissuedbooks=new ListIssuedBooks();
                    desktop.add(listissuedbooks);
                    try {
                        listissuedbooks.setSelected(true);
                    } catch (java.beans.PropertyVetoException e) {
                    }
                }
            };
            runner.start();
        }
    }
}
