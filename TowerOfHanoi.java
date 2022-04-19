/**
 * Tower of Hanoi algorithm visualization
 */
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TowerOfHanoi extends JFrame {
    private Stack<Disk> pegOne = new Stack<>();
    private Stack<Disk> pegTwo = new Stack<>();
    private Stack<Disk> pegThree = new Stack<>();
    private Random rand = new Random(); 
    TowerOfHanoi(int disks) {
        for (int i = disks; i > 0; i--){
            pegOne.add(new Disk(new Color(rand.nextInt(255), rand.nextInt(255),
                                rand.nextInt(255), i)));
        }
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

    }
    private class Disk {
        private Color color;
        private int size;
        Disk(Color color, int Size) {
            this.color = color;
            this.size = size;
        }
    }
}