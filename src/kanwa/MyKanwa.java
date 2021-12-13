package kanwa;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class MyKanwa extends JPanel implements MouseListener, KeyListener, MouseMotionListener {

    private int startX,startY,finishX,finishY;
    private char choice;

    public MyKanwa(){
        JLabel text = new JLabel("Wcisnij 'r' dla prostokata, 't' dla trojkata, 'o' dla kola");
        text.setBounds(150,20,200,20);

        setSize(500, 300);
        setBorder(new LineBorder(Color.BLACK, 1, false));
        setBackground(Color.WHITE);
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        setFocusable(true);
        add(text);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.WHITE);
        g2d.setColor(Color.RED);
        if(choice=='r') g2d.fillRect(startX,startY,finishX-startX,finishY-startY);

        else if (choice=='t') g2d.fill(new Polygon(new int[]{startX,startX-finishX,finishX},new int[]{startY,finishY,finishY},3));

        else if (choice =='o') g2d.fillOval(startX,startY,finishX-startX,finishY-startY);
        repaint();
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
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
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar()=='t') choice = 't';

        else if(e.getKeyChar()=='r') choice = 'r';

        else if(e.getKeyChar()=='o') choice ='o';
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        finishX=e.getX();
        finishY=e.getY();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
