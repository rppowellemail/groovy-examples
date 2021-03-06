package groovyinactionsecondedition

import groovy.swing.SwingBuilder
import groovy.transform.Canonical
import javax.swing.JLabel
import javax.swing.JTable
import javax.swing.table.TableCellRenderer
import java.awt.Color
import java.awt.Component

import static java.awt.Color.*

@Canonical
class NamedColor {
    String name
    Color foreground, background
}

purple = new NamedColor('Purple', WHITE, new Color(127, 0, 255))
mediumBlue = new NamedColor('Blue', WHITE, new Color(64, 128, 255))
brightYellow = new NamedColor('Yellow', BLACK, YELLOW)
brightRed = new NamedColor('Red', BLACK, RED)

data = [
        [name: 'Anthony', color: mediumBlue],
        [name: 'Greg', color: brightYellow],
        [name: 'Jeff', color: purple],
        [name: 'Murray', color: brightRed]
]

swing = new SwingBuilder()
frame = swing.frame(title: 'Table Demo') {
    scrollPane {
        table(id:'table') {
            tableModel(list: data) {
                propertyColumn(header: 'Name', propertyName: 'name')
                propertyColumn(header: 'Color', propertyName: 'color', type: NamedColor)
            }
        }
    }
}
frame.pack()
swing.table.setDefaultRenderer(NamedColor, new ColorRenderer())
frame.visible = true

class ColorRenderer extends JLabel implements TableCellRenderer {
    ColorRenderer() { opaque = true }
    Component getTableCellRendererComponent(JTable table, color, boolean selected, boolean focus, int row, int col) {
        background = color.background
        foreground = color.foreground
        text = color.name
        horizontalAlignment = CENTER
        this
    }
}