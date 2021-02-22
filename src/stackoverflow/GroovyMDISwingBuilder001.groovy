package stackoverflow

// https://stackoverflow.com/questions/49389251/how-to-use-groovy-swingbuilder-to-create-a-jdesktoppand-jinternalframe-combo

import groovy.swing.SwingBuilder
import java.awt.BorderLayout as BL

count = 0
new SwingBuilder().edt {
    frame(title: 'Frame', size: [300, 300], show: true) {
        desktopPane() {
            internalFrame(visible: true, bounds: [25, 25, 200, 100]) {
                borderLayout()
                textlabel = label(text: 'Click the button!', constraints: BL.NORTH)
                button(text:'Click Me',
                        actionPerformed: {count++; textlabel.text = "Clicked ${count} time(s)."; println "clicked"}, constraints:BL.SOUTH)
            }
        }
    }
}

