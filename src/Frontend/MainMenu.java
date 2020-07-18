package Frontend;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Menu implements ActionListener {

    private Image menubackground;
    JTextField textFieldName;
    JPasswordField textFieldPass;
    JButton accept;
    JFrame jf;


    public MainMenu() {

        menubackground = Toolkit.getDefaultToolkit().createImage("Menu2.jpg");
        this.textFieldName = new JTextField(13);
        this.textFieldPass = new JPasswordField(13);
        this.accept = new JButton("Accept");
        window();

    }

    @Override
    public void paintComponent(Graphics g) {
        repaint();
        g.drawImage(menubackground, 0, 0, getWidth(), getHeight(), null);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Accept")) {
            CentralMenu centralMenu=new CentralMenu();
            centralMenu.frameWindow();
            jf.setVisible(false);
        }
    }
    public void frameWindow(){
        jf = new JFrame();
        jf.setTitle("Menu");
        jf.setSize(800, 600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setContentPane(this);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
    }


    public void window() {

        this.setLayout(new GridBagLayout());
        JPanel gray = new JPanel();
        gray.setLayout(new GridLayout(5, 1, 0, 4));
        gray.setSize(new Dimension(200 , 200));
        gray.setBackground(new Color(0.7f,0.7f,0.7f,0.7f));


        gray.setBorder(new EmptyBorder(2, 10, 10, 10));
        gray.setVisible(true);
        this.add(gray);


        JLabel label = new JLabel("User:");
        //label.setBounds(30, 150, 200, 50);
        label.setFont(new Font("Courier", Font.BOLD, 16));
        label.setForeground(Color.BLACK);
        gray.add(label);


        //textFieldName.setBounds(100, 400, 100, 30);

        gray.add(textFieldName);


        JLabel labe2 = new JLabel("Password:");
        //labe2.setBounds(30, 250, 100, 50);
        labe2.setFont(new Font("Courier", Font.BOLD, 16));
        labe2.setForeground(Color.BLACK);
        gray.add(labe2);


        //textFieldName.setBounds(100, 200, 100, 30);
        gray.add(textFieldPass);

        // accept.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE));
        accept.setFont(new Font("Courier", Font.BOLD, 12));
        accept.setForeground(Color.BLACK);
        gray.add(accept);
        accept.addActionListener(this);


    }

}
