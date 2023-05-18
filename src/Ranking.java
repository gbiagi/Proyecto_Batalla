import javax.swing.*;

public class Ranking extends JFrame {
    private JTextArea text = new JTextArea(5,30);

    public Ranking(){
        String ranking = BBDDConnection.ranking();
        text.setText(ranking);
        setSize(500,500);
        add(text);
        setVisible(true);
    }

}
