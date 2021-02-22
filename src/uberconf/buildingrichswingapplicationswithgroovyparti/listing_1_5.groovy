package uberconf.buildingrichswingapplicationswithgroovyparti

import groovy.swing.SwingBuilder
import static javax.swing.JFrame.EXIT_ON_CLOSE
import static java.awt.BorderLayout.*

class SpecialWidgetFactory extends AbstractFactory {
    public Object newInstance( FactoryBuilderSupport builder, Object name,
                               Object value, Map properties )
            throws InstantiationException, IllegalAccessException {
        return new SpecialWidget( properties.remove("priority") )
    }
}

def swing = new SwingBuilder()
swing.registerBeanFactory( "customPanel", CustomPanel )
swing.registerBeanFactory( "customWidget", CustomWidget )
swing.registerFactory( "specialWidget2", new SpecialWidgetFactory() )

swing.edt {
    frame( title: "Swing Custom Component", pack: true, show: true,
            defaultCloseOperation: EXIT_ON_CLOSE ) {
        customPanel {
            borderLayout()
            label( "A Label", constraints: NORTH )
            customWidget( customProperty: "random value", constraints: CENTER )
            specialWidget( priority: 3, constraints: SOUTH )
        }
    }
}

