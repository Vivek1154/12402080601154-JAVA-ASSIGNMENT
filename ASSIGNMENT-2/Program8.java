import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Program8 extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5;
    JTextField t1, t2, t3, t4;
    JButton b1, b2;

    Program8() {
        setTitle("Investment Calculator");
        setSize(400, 300);
        setLayout(new GridLayout(6, 2, 10, 10));

        l1 = new JLabel("Principal Amount:");
        l2 = new JLabel("Rate of Interest (%):");
        l3 = new JLabel("Time (Years):");
        l4 = new JLabel("Total Amount:");
        l5 = new JLabel("");

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t4.setEditable(false);

        b1 = new JButton("Calculate");
        b2 = new JButton("Clear");

        b1.addActionListener(this);
        b2.addActionListener(this);

        add(l1);
        add(t1);
        add(l2);
        add(t2);
        add(l3);
        add(t3);
        add(l4);
        add(t4);
        add(b1);
        add(b2);
        add(l5);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            double p = Double.parseDouble(t1.getText());
            double r = Double.parseDouble(t2.getText());
            double n = Double.parseDouble(t3.getText());

            double amount = p * Math.pow((1 + r / 100), n);

            t4.setText(String.format("%.2f", amount));
        }

        if (e.getSource() == b2) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
        }
    }

    public static void main(String[] args) {
        new Program8();
    }
}
