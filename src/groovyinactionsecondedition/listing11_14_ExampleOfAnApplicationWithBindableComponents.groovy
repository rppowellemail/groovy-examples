package groovyinactionsecondedition

import groovy.beans.*
import groovy.swing.SwingBuilder
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.beans.PropertyVetoException

class Person implements ActionListener {
    @Bindable String name
    @Vetoable int age
    void actionPerformed(ActionEvent e) {
        if (e.actionCommand == name) setAge(age + 1)
    }
}
class BirthdayNotifier {
    @ListenerList List<ActionListener> listeners
    def triggerBirthday(name) {
        def event = new ActionEvent(this, 0, name)
        fireActionPerformed(event)
    }
}
data = [
        new Person(name: 'Anthony', age: 51),
        new Person(name: 'Greg', age: 42),
        new Person(name: 'Jeff', age: 60),
        new Person(name: 'Murray', age: 54)
]


swing = new SwingBuilder()
frame = swing.frame(title: 'Binding Demo') {
    table {
        tableModel(list: data, id: 'tableModel') {
            propertyColumn(header: 'Name', propertyName: 'name',
                    editable: true)
            propertyColumn(header: 'Age', propertyName: 'age',
                    type: Integer, editable: true)
        }
    }
}
frame.pack()
frame.visible = true

notifier = new BirthdayNotifier()
data.each {
    it.addPropertyChangeListener { evt ->
        println "$evt.newValue has replaced $evt.oldValue"
    }
    it.addVetoableChangeListener { evt ->
        if (evt.newValue < 0)
            throw new PropertyVetoException("Can't have -ve age", evt)
        else
            println "$evt.source.name now has age $evt.newValue"
    }
    notifier.addActionListener(it)
}
try {
    data[0].age = -99
} catch (e) {
    println "Change ignored: $e.message"
}
data[1].name = 'Sam'
data[1].age = 36
notifier.triggerBirthday(data[2].name)
swing.tableModel.fireTableDataChanged()