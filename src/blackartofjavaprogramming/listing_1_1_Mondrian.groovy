package blackartofjavaprogramming

import groovy.swing.SwingBuilder

import javax.swing.JPanel
import java.awt.Graphics
import java.awt.Color

import static javax.swing.WindowConstants.EXIT_ON_CLOSE

class Mondrian extends JPanel {
    public Mondrian() {
        preferredSize = [300, 300]
        setBackground(Color.black);
    }
    public void paint(Graphics g) {
        System.out.println(">> paint <<");
        super.paintComponent(g);
        g.setColor(Color.yellow);
        g.fillRect(0,0,90,90);
        g.fillRect(250,0,40,190);
        g.fillRect(80,110,100,20);
        g.setColor(Color.blue);
        g.fillRect(80,200,220,90);
        g.fillRect(100,10,90,80);
        g.setColor(Color.lightGray);
        g.fillRect(80,100,110,90);
        g.setColor(Color.red);
        g.fillRect(200,0,45,45);
        g.fillRect(0,100,70,200);
        g.setColor(Color.magenta);
        g.fillRect(200,55,60,135);
    }
}
new SwingBuilder().edt {
    frame(title: "Mondrian", pack: true, show: true, defaultCloseOperation: EXIT_ON_CLOSE) {
        container(new Mondrian()) {

        }
    }
}
