package groovyinactionsecondedition

/*
Listing 11.10
Simple password dialog with SwingBuilder
 */


import groovy.swing.SwingBuilder
swing = new SwingBuilder()
frame = swing.frame(title:'Password') {
    passwordField(columns:10, actionPerformed: { event ->
        println event.source.text
        // any further processing is called here
        System.exit(0)
    }
    )
}
frame.pack()
frame.visible = true