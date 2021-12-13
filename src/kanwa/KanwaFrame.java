package kanwa;

import javax.swing.*;

public class KanwaFrame extends JFrame {

    public KanwaFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(0,0,500,300);
        setLayout(null);
        setResizable(false);
        MyKanwa mykanwa = new MyKanwa();
        mykanwa.setVisible(true);
        add(mykanwa);
        setVisible(true);

    }
}
