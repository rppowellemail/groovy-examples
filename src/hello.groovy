/*

Create groovy project

----

Got error:

Groovyc: Internal groovyc error: code 1

To Fix:

In the Project tool window, right-click the created Groovy script file (hello.groovy) and select More Run/Debug | Modify Run Configuration.

In the dialog that opens, add the following code code to the VM options field:

--add-opens=java.base/java.lang=ALL-UNNAMED --add-opens=java.base/java.lang.invoke=ALL-UNNAMED

----

Add dependencies and rerun the script

Add JAXB dependency

Press Ctrl+Alt+Shift+S to open the Project Structure dialog.

In the dialog that opens, select the Modules option from the Project Settings list.

From the option on the right, select the Dependencies tab.

Click Icons welcome create new project on the bottom of the dialog and select JARs or Directories.

In the dialog that opens, locate extras-jaxb directory that the Groovy SDK comes with and add it as a dependency.

 */

println("Hello World!")
