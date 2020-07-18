package Frontend;
import backend.BookDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewUser extends Menu implements ActionListener {
    JFrame cm;
    JTextField textFieldName;
    JTextField textFieldAddres;
    JTextField textFieldEmail;
    JTextField textFieldPhoneNumber;
    JTextField textFieldIdentityCard;
    JTextField textFieldBirthDate;
    JButton buttonSave;
    JButton buttonBack;
    BookDB bookDB;


    public AddNewUser() {
        this.textFieldName = new JTextField(13);
        this.textFieldAddres = new JTextField(13);
        this.textFieldEmail = new JTextField(13);
        this.textFieldPhoneNumber = new JTextField(13);
        this.textFieldIdentityCard = new JTextField(13);
        this.textFieldBirthDate = new JTextField(13);
        this.buttonSave = new JButton("Save");
        this.buttonBack = new JButton("Back");
        bookDB = new BookDB();
        this.bookDB.makeConnectionWithDatabase();

    }

    @Override
    public void paintComponent(Graphics g) {

    }

    public void frameWindow() {
        cm = new JFrame();
        cm.setTitle("New User");
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

        JLabel newBook = new JLabel("NEW USER");
        newBook.setBounds(120, 10, 300, 20);
        newBook.setFont(new Font("Courier", Font.BOLD, 16));
        newBook.setForeground(Color.WHITE);
        whitePanel.add(newBook);

        textFieldName.setBounds(10, 60, 150, 20);
        this.add(textFieldName);
        JLabel title = new JLabel("Name");
        title.setBounds(180, 60, 100, 20);
        this.add(title);

        textFieldAddres.setBounds(10, 100, 150, 20);
        this.add(textFieldAddres);
        JLabel title2 = new JLabel("Addres");
        title2.setBounds(180, 100, 100, 20);
        this.add(title2);

        textFieldEmail.setBounds(10, 140, 150, 20);
        this.add(textFieldEmail);
        JLabel title3 = new JLabel("E-mail");
        title3.setBounds(180, 140, 100, 20);
        this.add(title3);

        textFieldPhoneNumber.setBounds(10, 180, 150, 20);
        this.add(textFieldPhoneNumber);
        JLabel title4 = new JLabel("Phone Nummber");
        title4.setBounds(180, 180, 100, 20);
        this.add(title4);

        textFieldIdentityCard.setBounds(10, 220, 150, 20);
        this.add(textFieldIdentityCard);
        JLabel title5 = new JLabel("Identity Card");
        title5.setBounds(180, 220, 100, 20);
        this.add(title5);

        textFieldBirthDate.setBounds(10, 260, 150, 20);
        this.add(textFieldBirthDate);
        JLabel title6 = new JLabel("Birth Date");
        title6.setBounds(180, 260, 100, 20);
        this.add(title6);

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
            long phone= Long.parseLong(textFieldPhoneNumber.getText());
            bookDB.insertNewUserToDatabase(textFieldName.getText(),textFieldAddres.getText(),textFieldEmail.getText(),
                    phone,textFieldIdentityCard.getText(),textFieldBirthDate.getText());
            JOptionPane.showMessageDialog(null, "Save is successful!");
            cm.setVisible(false);
            AddNewUser addNewUser = new AddNewUser();
            addNewUser.frameWindow();


        }

        else if (e.getActionCommand().equals("Back")) {
            System.out.println("back");
            cm.setVisible(false);
        }


    }


}

