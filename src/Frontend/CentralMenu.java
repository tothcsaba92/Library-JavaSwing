package Frontend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CentralMenu extends Menu implements ActionListener {
    private Image CentralMenubackground;
    JButton newBook;
    JButton newUser;
    JButton search;
    JButton exit;

    public CentralMenu() {

        this.exit = new JButton("Exit");
        this.newBook = new JButton("Add New Book");
        this.newUser = new JButton("Add New User");
        this.search = new JButton("Search");
        CentralMenubackground = Toolkit.getDefaultToolkit().createImage("backround4.jpg");
    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(CentralMenubackground, 0, 0, getWidth(), getHeight(), null);
    }


    public void frameWindow() {
        JFrame cm = new JFrame();
        cm.setTitle("Menu");
        cm.setSize(1100, 700);
        cm.setVisible(true);
        cm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cm.setContentPane(this);
        cm.setResizable(false);
        cm.setLocationRelativeTo(null);
        window();
    }

    public void window() {

        this.setLayout(new FlowLayout());
        JPanel gray = new JPanel();
        gray.setLayout(new FlowLayout());
        gray.setSize(new Dimension(700, 200));
        //  gray.setBackground(Color.gray);
        gray.setBackground(new Color(0.7f, 0.7f, 0.7f, 0.7f));
        gray.setBorder(new EmptyBorder(2, 10, 10, 10));
        gray.setVisible(true);
        this.add(gray);
        this.setLayout(null);
        gray.setLayout(null);


        newBook.setFont(new Font("Courier", Font.BOLD, 12));
        newBook.setBounds(10, 150, 200, 50);
        newBook.setForeground(Color.BLACK);
        gray.add(newBook);
        newBook.addActionListener(this);


        newUser.setFont(new Font("Courier", Font.BOLD, 12));
        newUser.setBounds(300, 150, 200, 50);
        newUser.setForeground(Color.BLACK);
        gray.add(newUser);
        newUser.addActionListener(this);

        search.setFont(new Font("Courier", Font.BOLD, 12));
        search.setBounds(500, 150, 200, 50);
        search.setForeground(Color.BLACK);
        gray.add(search);
        search.addActionListener(this);



        exit.setBounds(950, 600, 100, 50);
        exit.setFont(new Font("Courier", Font.BOLD, 15));
        exit.setForeground(Color.BLACK);
        this.add(exit);
        exit.addActionListener(this);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add New Book")) {
            AddNewBook newBook = new AddNewBook();
            newBook.frameWindow();

        } else if (e.getActionCommand().equals("Search")) {
            UserSearchMenu userSearchMenu = new UserSearchMenu();
            userSearchMenu.frameWindow();

        }else if (e.getActionCommand().equals("Add New User")) {
            AddNewUser addNewUser=new AddNewUser();
            addNewUser.frameWindow();

        }else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);

        }
    }
}
