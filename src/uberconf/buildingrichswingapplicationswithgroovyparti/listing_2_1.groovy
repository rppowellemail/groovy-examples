package uberconf.buildingrichswingapplicationswithgroovyparti

import javax.swing.SwingUtilities
import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE

SwingUtilities.invokeLater {
    new SwingBuilder().frame( title: "Swing Sample", pack: true, show: true,
            defaultCloseOperation: EXIT_ON_CLOSE ) {
        gridLayout( cols: 1, rows: 3 )
        textField( id: "textField", columns: 20 )
        label( id: "label" )
        button( "Update", actionPerformed: { evt ->
            label.text = textField.text
        })
    }
}

