/**
 * Tower of Hanoi algorithm visualization
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TowerOfHanoi extends JFrame {
    private Stack<Disk>[] pegs = new Stack<>[3];
    private Random rand = new Random(); 
    private Canvas canvas = new Canvas();
    TowerOfHanoi(int disks) {
        pegs[0] = new Stack<>();
        pegs[1] = new Stack<>();
        pegs[2] = new Stack<>();
        for (int i = disks; i > 0; i--){
            pegs[0].add(new Disk(new Color(rand.nextInt(255), rand.nextInt(255),
                                rand.nextInt(255), i)));
        }
        add(canvas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,480);
    }
    public static void main(String[] args) {
        new TowerOfHanoi(4);
    }
    private void solver(int disk, int source, int dest, int spare) {
        if (disk == 0) moveDisk(source, dest);
        else {
            solver(disk-1, source, spare, dest);
            moveDisk(source, dest);
            solver(disk-1, spare, dest, source);
        }
    }
    private void moveDisk(int source, int dest) {
        if (pegs[source].size() != 0){
            pegs[dest].add(pegs[source].pop());
            canvas.revalidate();
            canvas.repaint();
        }
    }
    private class Disk {
        private Color color;
        private int size;
        Disk(Color color, int size) {
            this.color = color;
            this.size = size;
        }
    }
    private class Canvas extends JPanel {
        Canvas(){
            setBackground(Color.WHITE);
        }
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //paint pegs[0]
            //paint pegs[1]
            //paint pegs[2]
        }
    }
}