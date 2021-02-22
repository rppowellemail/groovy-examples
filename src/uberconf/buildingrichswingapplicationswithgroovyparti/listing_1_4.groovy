package uberconf.buildingrichswingapplicationswithgroovyparti

import groovy.swing.SwingBuilder

import javax.swing.JComponent
import javax.swing.JPanel

import static javax.swing.JFrame.EXIT_ON_CLOSE
import static java.awt.BorderLayout.*


def swing = new SwingBuilder()
swing.registerBeanFactory("customPanel", CustomPanel )
swing.registerBeanFactory("customWidget", CustomWidget )

swing.edt {
    frame( title: "Swing Custom Component", pack: true, show: true,
            defaultCloseOperation: EXIT_ON_CLOSE ) {
        customPanel {
            borderLayout()
            label( "A Label", constraints: NORTH )
            customWidget( customProperty: "random value", constraints: CENTER )
        }
    }
}