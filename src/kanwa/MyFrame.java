package kanwa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;


public class MyFrame extends JFrame {

    private final Random r = new Random();
    private int i=0,milkedCows=0;

    public MyFrame(String title) throws HeadlessException {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(500,300);
        setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,500,300);
        panel.setLayout(null);
        panel.setVisible(true);
        add(panel);

        JLabel label = new JLabel();
        label.setText("Press one of two buttons or milk a cow on grass");
        label.setBounds(125,20,275,20);
        label.setVisible(true);
        panel.add(label);

        JLabel garden = new JLabel();
        garden.setBounds(0,0,50,50);
        ImageIcon gardenim = new ImageIcon("garden.png");
        garden.setIcon(gardenim);
        garden.setVisible(true);
        panel.add(garden);

        JLabel counter = new JLabel();
        counter.setText("No cows milked yet");
        counter.setBounds(10,50,100,20);
        counter.setVisible(true);
        panel.add(counter);

        JButton escapeButton = new JButton();
        escapeButton.setBounds(50,200,160,30);
        escapeButton.setText("Try to click me");
        escapeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                i+=1;
                escapeButton.setLocation(50,200);
                escapeButton.setText("I was clicked: "+i+" times!");
            }
            @Override
            public void mouseEntered(MouseEvent e){
                if((escapeButton.getX()>20&&escapeButton.getX()<(500-20-escapeButton.getWidth()))
                    &&
                    (escapeButton.getY()>20&&escapeButton.getY()<(300-20-escapeButton.getHeight())))
                {
                    int nextX = r.nextInt(500-escapeButton.getWidth());
                    int nextY = r.nextInt(300-escapeButton.getWidth());
                    escapeButton.setLocation(nextX,nextY);
                }
            }
        });
        escapeButton.setVisible(true);
        panel.add(escapeButton);

        JButton kanwaButton = new JButton();
        kanwaButton.setText("Start drawing");
        kanwaButton.setBounds(300,200,125,30);
        kanwaButton.setVisible(true);
        kanwaButton.addActionListener(e->{
            KanwaFrame kf = new KanwaFrame();
            kf.setVisible(true);
            setVisible(false);
        });

        JButton cow = new JButton();
        cow.setBounds(250,150,30,30);
        ImageIcon cowim = new ImageIcon("cow.png");
        cow.setIcon(cowim);
        cow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                if(cow.getX()<21&&cow.getY()<21){
                    cow.setLocation(250,150);
                    milkedCows+=1;
                    counter.setText("Cows milked: "+milkedCows);
                }
            }
            @Override
            public void mouseEntered(MouseEvent e){
                if(cow.getX()>20||cow.getY()>20){
                    if(e.getX()<1&&(e.getY()>5&&e.getY()<25))
                        cow.setLocation(cow.getX()+10,cow.getY());
                    else if(e.getX()>25&&(e.getY()>5&&e.getY()<25))
                        cow.setLocation(cow.getX()-10,cow.getY());
                    else if(e.getY()<1&&(e.getX()>5&&e.getX()<25))
                        cow.setLocation(cow.getX(),cow.getY()+10);
                    else if(e.getY()>25&&(e.getX()>5&&e.getX()<25))
                        cow.setLocation(cow.getX(),cow.getY()-10);
                    else if((e.getX()<5&&e.getY()<5))
                        cow.setLocation(cow.getX()+5,cow.getY()+5);
                    else if((e.getX()<5&&e.getY()>25))
                        cow.setLocation(cow.getX()+5,cow.getY()-5);
                    else if((e.getX()>25&&e.getY()<5))
                        cow.setLocation(cow.getX()-5,cow.getY()+5);
                    else if((e.getX()>25&&e.getY()>25))
                        cow.setLocation(cow.getX()-5,cow.getY()-5);
                }
            }
        });
        cow.setVisible(true);
        panel.add(cow);
        panel.add(kanwaButton);
    }

}
