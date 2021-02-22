package uberconf.buildingrichswingapplicationswithgroovyparti

import groovy.swing.SwingBuilder

import javax.swing.JComponent
import javax.swing.JPanel

import static javax.swing.JFrame.EXIT_ON_CLOSE
import static java.awt.BorderLayout.*

SwingBuilder.build {
    frame( title: "Swing Custom Component", pack: true, show: true,
            defaultCloseOperation: EXIT_ON_CLOSE ) {
        container( new CustomPanel() ) {
            borderLayout()
            label( "A Label", constraints: NORTH )
            widget( new CustomWidget(), customProperty: "random value",
                    constraints: CENTER )
        }
    }
}