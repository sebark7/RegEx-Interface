import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import javax.swing.border.Border;

public class Main {


    public static void main(String[] args) {
        JLabel label = new JLabel("Pozitia");
        JFrame f = new JFrame();
        JPanel p = new JPanel();
        JTextArea area = new JTextArea();
        JTextArea area2 = new JTextArea();
        JTextField input = new JTextField();
        JScrollPane bara = new JScrollPane(area2);
        JButton buton = new JButton("Search");
        String[] petString = {"inceput", "sfarsit", "oricare"};
//        JComboBox box = new JComboBox(petString);
        bara.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        buton.setBorder(null);

        buton.setForeground(Color.WHITE);
        buton.setBackground(Color.BLUE);
        f.getContentPane().setBackground(new java.awt.Color(138,201,38));

        buton.setBounds(330,70,120,30);
        label.setBounds(10,3,100,10);
        area.setBounds(10, 30, 300, 280);
        bara.setBounds(10, 330, 450, 100);
        input.setBounds(330, 30, 120, 30);

        f.add(label);
        f.add(area);
        f.add(bara);
        f.add(input);
        f.add(buton);

        area.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

                label.setText("Pozitia: " + (area.getCaretPosition() + 1));

            }

            @Override
            public void keyPressed(KeyEvent e) {


            }

            @Override
            public void keyReleased(KeyEvent e) {


                label.setText("Pozitia: " + (area.getCaretPosition() + 1));


            }
        });

        area.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                label.setText("Pozitia: " + (area.getCaretPosition() + 1));

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = area.getText();
                String pattern = input.getText();
                area2.setText("");
                try
                {
                    Pattern patt = Pattern.compile(pattern);
                    Matcher matcher = patt.matcher(text);
                    boolean ok = false;

                    while (matcher.find())
                    {
                        ok = true;
                        area2.append(matcher.group() + " pozitia " + matcher.start() + "\n");

                    }

                    if(!ok)
                    {
                        area2.append("");
                        area2.append("Nu s-a gasit");

                    }


                }catch(PatternSyntaxException exception)
                {
                    JOptionPane.showMessageDialog(null, "Tiparul pe care l-ai introdus este gresit!", "Eroare", JOptionPane.PLAIN_MESSAGE);

                }

            }
        });

        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 500);
        f.setLayout(null);
        f.setVisible(true);

    }


}
