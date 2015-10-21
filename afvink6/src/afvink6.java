import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class afvink6 {

    public static int countPolair = 0;
    public static int countApolair = 0;
    final static String[] polair = {"R", "N", "D", "C", "Q", "E", "G", "H", "K", "S", "T", "Y"};
    final static String[] apolair = {"A", "F", "I", "L", "M", "P", "W", "V"};

    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.CEILING);
        GUI gui = new GUI();
        voegActieToe(gui, df);
    }

    public static String ReadAA(GUI gui) {
        String sequentie;
        sequentie = gui.txtArea.getText();
        return sequentie;
    }

    public static void voegActieToe(final GUI gui, final DecimalFormat df) {
        gui.setButtonsActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sequentie = ReadAA(gui);
                for (int i = 0; i < sequentie.length(); i++) {
                    String aa = sequentie.substring(i, i + 1).toUpperCase();
                    try {
                        checkAA(aa);
                    }
                    catch (NotAnAA ex) {
                        JOptionPane.showMessageDialog(gui, ex.toString());
                    }
                }
                tekenPercentage(gui, df);
            }
        });
    }

    public static void checkAA(String aa) throws NotAnAA {
        int countTest = 0;
        for (String s : polair) {
            if (s.equals(aa)) {
                countPolair++;
                countTest = 1;
            }
        }

        for (String a : apolair) {
            if (a.equals(aa)) {
                countApolair++;
                countTest = 1;
            }
        }

        if (countTest != 1) {
            throw new NotAnAA("Symbool :" + aa + " is geen aminozuur.");
        }
    }

    public static void tekenPercentage(GUI gui, DecimalFormat df) {
        double totaal = countApolair + countPolair;
        double procentPolair = (countPolair / totaal) * 100;
        double procentApolair = (countApolair / totaal) * 100;
        //NEEDS TO BE LARGER THOUGH!!!
        double guiprocentpol = procentPolair * 5;
        double guiprocentapol = procentApolair * 5;
        Graphics paper = gui.panel.getGraphics();
        paper.setColor(Color.blue);
        paper.fillRect(0, 0, (int) guiprocentpol, 50);
        paper.setColor(Color.black);
        paper.drawString("Percentage polair: " + df.format(procentPolair), 0, 40);
        paper.setColor(Color.red);
        paper.fillRect(0, 50, (int) guiprocentapol, 50);
        paper.setColor(Color.black);
        paper.drawString("Percentage apolair: " + df.format(procentApolair), 0, 80);
    }

}

class NotAnAA extends Exception {

    public NotAnAA() {
        super();
    }

    public NotAnAA(String err) {
        super(err);
    }
}