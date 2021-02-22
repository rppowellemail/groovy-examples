package uberconf.buildingrichswingapplicationswithgroovypartii

import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE
import java.awt.Color

SwingBuilder.build {
    frame( title: "Custom Label", size: [200,80], visible: true,
            defaultCloseOperation: EXIT_ON_CLOSE ) {
        panel {
            label( new CustomLabel("This text has a red border"),
                    borderColor: Color.RED, borderWidth: 5 )
        }
    }
}
