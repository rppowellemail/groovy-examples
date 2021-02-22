package uberconf.buildingrichswingapplicationswithgroovyparti

import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE
import static java.awt.BorderLayout.*

def swing = SwingBuilder.build {
    frame( title: "File Viewer", pack: true, show: true,
            defaultCloseOperation: EXIT_ON_CLOSE, id: "frame" ) {
        borderLayout()
        panel( constraints: NORTH ) {
            borderLayout()
            textField( id: "filename", constraints: CENTER )
            button( "Load", constraints: EAST, actionPerformed: { evt ->
                fileview.text = new File(filename.text).text
            })
        }
        scrollPane( constraints: CENTER ) {
            editorPane( id: "fileview", editable: false )
        }
    }
}

swing.doLater { frame.size = [480,320] }

