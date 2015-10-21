import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Stan on 14-10-2015.
 */
public class GUI extends JFrame {

    public JLabel lblSeq, lblPercentage;
    public JButton btnAnalyseer;
    public JTextArea txtArea;
    public JPanel panel;

    public GUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        lblSeq = new JLabel("Sequentie");
        add(lblSeq);
        txtArea = new JTextArea(25, 25);
        add(txtArea);
        btnAnalyseer = new JButton("Analyseer");
        //btnAnalyseer.addActionListener(this);
        add(btnAnalyseer);
        lblPercentage = new JLabel("Percentage");
        add(lblPercentage);
        panel = new JPanel();
        panel.setVisible(true);
        panel.setPreferredSize(new Dimension(500, 100));
        panel.setBackground(Color.white);
        add(panel);
        setTitle("Protein Analyser");
        setSize(750, 750);
        setVisible(true);
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
    }

    public void setButtonsActionListener(ActionListener listener) {
        btnAnalyseer.addActionListener(listener);
    }

}