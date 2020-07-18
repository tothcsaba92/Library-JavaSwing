package Frontend;

import backend.BookDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddNewBook extends Menu implements ActionListener {
    JFrame cm;
    JTextField textFieldTitle;
    JTextField textFieldAuthor;
    JTextField textFieldAgeLimit;
    JTextField textFieldIsBookHard;
    JTextField textFieldYears;
    JTextField textFieldISBN;
    JTextField textFieldNumberOfCopies;
    JButton buttonSave;
    JButton buttonBack;
    BookDB bookDB;


    public AddNewBook() {
        this.textFieldTitle = new JTextField(13);
        this.textFieldAuthor = new JTextField(13);
        this.textFieldAgeLimit = new JTextField(13);
        this.textFieldIsBookHard = new JTextField(13);
        this.textFieldYears = new JTextField(13);
        this.textFieldISBN = new JTextField(13);
        this.textFieldNumberOfCopies = new JTextField(13);
        this.buttonSave = new JButton("Save");
        this.buttonBack = new JButton("Back");
        bookDB = new BookDB();
        bookDB.makeConnectionWithDatabase();

    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public void frameWindow() {
        cm = new JFrame();
        cm.setTitle("New Book");
        cm.setSize(400, 700);
        cm.setVisible(true);
        cm.setContentPane(this);
        cm.setBackground(Color.gray);
        cm.setResizable(false);
        cm.setLocationRelativeTo(null);
        window();
    }

    public void window() {

        JPanel whitePanel = new JPanel();
        whitePanel.setSize(new Dimension(400, 40));

        whitePanel.setAlignmentX(50);
        whitePanel.setBackground(Color.darkGray);
        this.add(whitePanel);
        this.setLayout(null);
        whitePanel.setLayout(null);

        JLabel newBook = new JLabel("NEW BOOK");
        newBook.setBounds(120, 10, 300, 20);
        newBook.setFont(new Font("Courier", Font.BOLD, 16));
        newBook.setForeground(Color.WHITE);
        whitePanel.add(newBook);

        textFieldTitle.setBounds(10, 60, 150, 20);
        this.add(textFieldTitle);
        JLabel title = new JLabel("Title");
        title.setBounds(180, 60, 100, 20);
        this.add(title);

        textFieldAuthor.setBounds(10, 100, 150, 20);
        this.add(textFieldAuthor);
        JLabel title2 = new JLabel("Author");
        title2.setBounds(180, 100, 100, 20);
        this.add(title2);

        textFieldAgeLimit.setBounds(10, 140, 150, 20);
        this.add(textFieldAgeLimit);
        JLabel title3 = new JLabel("Age limit");
        title3.setBounds(180, 140, 100, 20);
        this.add(title3);

        textFieldIsBookHard.setBounds(10, 180, 150, 20);
        this.add(textFieldIsBookHard);
        JLabel title4 = new JLabel("Cover type");
        title4.setBounds(180, 180, 100, 20);
        this.add(title4);

        textFieldYears.setBounds(10, 220, 150, 20);
        this.add(textFieldYears);
        JLabel title5 = new JLabel("Publication year");
        title5.setBounds(180, 220, 100, 20);
        this.add(title5);

        textFieldISBN.setBounds(10, 260, 150, 20);
        this.add(textFieldISBN);
        JLabel title6 = new JLabel("ISBN");
        title6.setBounds(180, 260, 100, 20);
        this.add(title6);

        textFieldNumberOfCopies.setBounds(10,300,150,20);
        this.add(textFieldNumberOfCopies);
        JLabel title7 = new JLabel("Number of copies");
        title7.setBounds(180,300,100,20);
        this.add(title7);

        buttonSave.setBounds(270, 600, 100, 50);
        buttonSave.setFont(new Font("Courier", Font.BOLD, 15));
        buttonSave.setForeground(Color.BLACK);
        this.add(buttonSave);
        buttonSave.addActionListener(this);

        buttonBack.setBounds(10, 600, 100, 50);
        buttonBack.setFont(new Font("Courier", Font.BOLD, 15));
        buttonBack.setForeground(Color.BLACK);
        this.add(buttonBack);
        buttonBack.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Save")) {
            try {
                bookDB.insertBook(textFieldTitle.getText(), textFieldAuthor.getText(), textFieldAgeLimit.getText(),
                        Integer.parseInt(textFieldIsBookHard.getText()), textFieldYears.getText(),
                        textFieldISBN.getText(),Integer.parseInt(textFieldNumberOfCopies.getText()));
                JOptionPane.showMessageDialog(null, "Save is successful!");
                cm.setVisible(false);
                AddNewUser addNewUser = new AddNewUser();
                addNewUser.frameWindow();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }


        }

        else if (e.getActionCommand().equals("Back")) {
            System.out.println("back");
            cm.setVisible(false);
        }


    }


}
