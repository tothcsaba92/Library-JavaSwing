package Frontend;

import backend.BookCopyInfo;
import backend.BookDB;
import backend.BookInfo;
import exceptions.InvalidUserException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserSearchMenu extends Menu implements LayoutManager, ActionListener {
    Image userSearchBackground;
    JFrame us;
    JButton back;
    JButton returnedBook;
    JButton search;
    JTextField textFieldUserName;
    JTextField textFieldBookTitle;
    JTextField textFieldAuthor;
    JTextField textFieldIsbn;
    JTextField textPublicationYear;
    BookDB bookDB;
    JTextField bookTitleInput;
    JTextField textBookGenre;

    public UserSearchMenu() {
        this.textFieldUserName = new JTextField(13);
        this.textFieldIsbn = new JTextField(13);
        this.textFieldAuthor = new JTextField(13);
        this.textFieldBookTitle = new JTextField(13);
        this.textPublicationYear = new JTextField(13);
        this.search = new JButton("Search");
        this.back = new JButton("Back");
        this.returnedBook = new JButton("Search book");
        userSearchBackground = Toolkit.getDefaultToolkit().createImage("libraryv2.jpg");
        this.textBookGenre = new JTextField();
        this.bookDB = new BookDB();
        this.bookDB.makeConnectionWithDatabase();

    }

    public void frameWindow() {
        us = new JFrame();
        us.setTitle("UserSearchMenu");
        us.setSize(850, 450);
        us.setVisible(true);
        us.setContentPane(this);
        us.setResizable(false);
        us.setLocationRelativeTo(null);
        window();
    }


    public void window() {

        JPanel inputPanel = new JPanel(new GridLayout(6, 4, 20, 5));
        inputPanel.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.7f));
        inputPanel.add(textBookGenre);
        inputPanel.add(new JLabel("Book genre"));
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        //inputPanel.add(new JTextField());
        inputPanel.add(textFieldBookTitle);
        inputPanel.add(new JLabel("Book title"));
        inputPanel.add(textFieldUserName);
        inputPanel.add(new JLabel("User name"));
        inputPanel.add(textFieldAuthor);
        inputPanel.add(new JLabel("Author"));
        Font f = returnedBook.getFont();
        returnedBook.setFont(new Font(f.getName(), f.getStyle(), 10));
        inputPanel.add(returnedBook);
        returnedBook.addActionListener(this);
        inputPanel.add(new JLabel());
        inputPanel.add(textPublicationYear);
        inputPanel.add(new JLabel("Publication year"));
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(textFieldIsbn);
        inputPanel.add(new JLabel("ISBN"));
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(search);
        search.addActionListener(this);
        inputPanel.add(new JLabel());
        inputPanel.add(new JLabel());
        inputPanel.add(back);
        back.addActionListener(this);
        add(inputPanel);
    }


    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(userSearchBackground, 0, 0, getWidth(), getHeight(), null);
    }

    @Override
    public void addLayoutComponent(String name, Component comp) {
    }

    @Override
    public void removeLayoutComponent(Component comp) {
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return null;
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return null;
    }

    @Override
    public void layoutContainer(Container parent) {
        for (int i = 0; i < parent.getComponentCount(); i++) {
            Component component = parent.getComponent(i);
            component.setBounds(i * 200 + 20, 10, 560, 100);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            us.setVisible(false);

        } else if (e.getActionCommand().equals("Search book")) {
            try {
                List<BookInfo> dataC = bookDB.listParticularUser(textFieldUserName.getText());
                String[][] data = new String[dataC.size()][5];
                for (int i = 0; i < dataC.size(); i++) {

                    data[i][0] = dataC.get(i).getUserName();
                    data[i][1] = dataC.get(i).getBookTitle();
                    data[i][2] = dataC.get(i).getBookISBN();
                    data[i][3] = dataC.get(i).getPublishYear().toString();
                    data[i][4] = String.valueOf(dataC.get(i).isBookCoverHard());

                }
                // Column Names
                String[] columnNames = {"name", "title", "ISBN", "publication_year", "is_book_cover_hard"};

                // Initializing the JTable
                JFrame f = new JFrame();
                JTable j = new JTable(data, columnNames);
                j.setBounds(30, 40, 200, 300);
                f.setSize(500, 200);
                f.setLocationRelativeTo(null);

                JScrollPane sp = new JScrollPane(j);
                f.add(sp);
                f.setVisible(true);
            } catch (InvalidUserException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (e.getActionCommand().equals("Search")) {
            JFrame f = new JFrame();
            try {
                List<BookCopyInfo> dataB =  bookDB.searchForBook(textFieldAuthor.getText(), textFieldBookTitle.getText(), textBookGenre.getText(), textPublicationYear.getText(), textFieldIsbn.getText());

                String[][] data1 = new String[dataB.size()][5];
                for (int i = 0; i < dataB.size(); i++) {
                    // data1[i] = dataB.get(i).toArray();
                    data1[i][0] = dataB.get(i).getBookAuthor();
                    data1[i][1] = dataB.get(i).getBookTitle();
                    data1[i][2] = dataB.get(i).getGenre();
                    data1[i][3] = dataB.get(i).getPublishYear().toString();
                    data1[i][4] = dataB.get(i).getBookISBN();

                }

                // Column Names
                String[] columnNames = {"Author", "Book title", "Book genre", "PublicationYear", "ISBN"};

                // Initializing the JTable
                JTable j = new JTable(data1, columnNames);
                j.setBounds(30, 40, 200, 300);
                f.setSize(500, 200);
                f.setLocationRelativeTo(null);

                JScrollPane sp = new JScrollPane(j);
                f.add(sp);
                f.setVisible(true);
            } catch (InvalidUserException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }

        }
    }
}