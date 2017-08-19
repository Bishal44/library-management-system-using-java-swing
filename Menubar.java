
//import the packages for using the classes in them into the program
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.management.JMException;

public class Menubar extends JMenuBar {

    /***************************************************************************
     ***      declaration of the private variables used in the program       ***
     ***************************************************************************/

    //for creating the JMenu for the program
    public JMenu fileMenu,  bookMenu,  memberMenu,  searchMenu,  loanMenu,  reserveMenu,  helpMenu;
    //for creating the JMenuItem for JMenu
    public JMenuItem printBook,  exit,  addBook,  listBook,  listAvailbleBook,  listBorrowedBook;
    public JMenuItem editBook,  removeBook,  bookInformation,  addMember,  listMember,  editMember;
    public JMenuItem  removeMember,  memberInformation,  searchBooksAndMembers,  borrowBook,  returnBook;
    public JMenuItem listissuedbooks,reserveBook,  help,  about;
    //for creating an imageIcon
    public ImageIcon[] icons;
    //for creating the name of the image file 16*16
    public String[] imageName16 = {"images/Print16.gif", "images/Exit16.gif",
        "images/Add16.gif", "images/List16.gif",
        "images/Edit16.gif", "images/Delete16.gif",
        "images/Information16.gif", "images/Find16.gif",
        "images/Export16.gif", "images/Import16.gif",
        "images/Help16.gif", "images/About16.gif"
    };

    public Menubar() {
        //for adding book, member, search, loan & help Menus to the menu bar
        this.add(fileMenu = new JMenu("File"));
        this.add(bookMenu = new JMenu("Books"));
        this.add(memberMenu = new JMenu("Members"));
        this.add(searchMenu = new JMenu("Search"));
        this.add(loanMenu = new JMenu("Loan"));
        this.add(reserveMenu = new JMenu("Reserve"));
        this.add(helpMenu = new JMenu("Help"));

        /**
         *for setting the Mnemonic
         */
        fileMenu.setMnemonic('f');
        bookMenu.setMnemonic('b');
        memberMenu.setMnemonic('m');
        searchMenu.setMnemonic('s');
        loanMenu.setMnemonic('l');
        reserveMenu.setMnemonic('r');
        helpMenu.setMnemonic('h');

        //for setting the image icons
        icons = new ImageIcon[12];
        for (int i = 0; i < imageName16.length; i++) {
            icons[i] = new ImageIcon(ClassLoader.getSystemResource(imageName16[i]));
        }

        //for adding print books & exit
        fileMenu.add(printBook = new JMenuItem("Print Books", icons[0]));
        fileMenu.add(exit = new JMenuItem("Exit", icons[1]));

        //for adding add, list, listAvailble, listBorrowed, edit & remove Books and book information to the bookMenu
        bookMenu.add(addBook = new JMenuItem("Add Book", icons[2]));
        bookMenu.add(listBook = new JMenuItem("List All Books", icons[3]));
        bookMenu.add(listAvailbleBook = new JMenuItem("List Availble Books", icons[3]));
        bookMenu.add(listBorrowedBook = new JMenuItem("List Borrowed Books", icons[3]));
        bookMenu.add(editBook = new JMenuItem("Edit Books", icons[4]));
        bookMenu.add(removeBook = new JMenuItem("Remove Book", icons[5]));
        //bookMenu.add(bookInformation = new JMenuItem("Book Information", icons[6]));

        //for adding add, list, edit & remove Members and member information to the memberMenu
        memberMenu.add(addMember = new JMenuItem("Add Member", icons[2]));
        memberMenu.add(listMember = new JMenuItem("List All Members", icons[3]));
        memberMenu.add(editMember = new JMenuItem("Edit Members", icons[4]));
        memberMenu.add(removeMember = new JMenuItem("Remove Member", icons[5]));
        memberMenu.add(memberInformation = new JMenuItem("Member Information", icons[6]));

        //for adding add, list & remove Members to the memberMenu
        searchMenu.add(searchBooksAndMembers = new JMenuItem("Search", icons[7]));

        //for adding borrow & return books to the loanMenu
        loanMenu.add(borrowBook = new JMenuItem("Borrow a Book", icons[8]));
        loanMenu.add(returnBook = new JMenuItem("Return a Book", icons[9]));
        loanMenu.add(listissuedbooks=new JMenuItem("Issued book details",icons[3]));
        //Reserve a book  
        reserveMenu.add(reserveBook = new JMenuItem("Reserve a Book", icons[10]));

        //for adding help & about to the helpMenu
        helpMenu.add(help = new JMenuItem("Help", icons[10]));
        helpMenu.add(about = new JMenuItem("About", icons[11]));

        //for setting the shortcut
        printBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        searchBooksAndMembers.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

        addBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        listBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        editBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        removeBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

        addMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        listMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        editMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        removeMember.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));

        borrowBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        returnBook.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        listissuedbooks.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK));
        help.setAccelerator(KeyStroke.getKeyStroke("F1"));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
    }
}
