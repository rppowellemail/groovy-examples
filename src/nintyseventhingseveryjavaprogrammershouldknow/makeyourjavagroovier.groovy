package nintyseventhingseveryjavaprogrammershouldknow

// https://mvnrepository.com/artifact/com.google.code.gson/gson
@Grapes(
        @Grab(group='com.google.code.gson', module='gson', version='2.8.6')
)

@GrabConfig(systemClassLoader=true)
@Grab(group='com.h2database', module='h2', version='1.4.200')
import com.google.gson.Gson

import groovy.json.JsonSlurper
import groovy.transform.Canonical

import groovy.sql.Sql

/* Step 1 - download json */
def jsonTxt = 'http://api.open-notify.org/astros.json'.toURL().text
println jsonTxt

/* Step 2 - parse json */
def number = new JsonSlurper().parseText(jsonTxt).number
println number

/* Step 3 - import/use Gson to parse json to classes */
/*
import com.google.gson.Gson
 */
@Canonical
class Assignment { String name; String craft }
@Canonical
class Response { String message; int number; Assignment[] people }

//new Gson().fromJson(jsonTxt, Response).people.each { println it }

response = new Gson().fromJson(jsonTxt, Response)

response.people.each { println it }

/* Step 4 - using h2 */
/*
@GrabConfig(systemClassLoader=true)
@Grab(group='com.h2database', module='h2', version='1.3.176')
 */

//def jdbcConnectionString = "jdbc:h2:~/astro"
def jdbcConnectionString = "jdbc:h2:mem:testdb"

Sql sql = Sql.newInstance(url: jdbcConnectionString, driver: 'org.h2.Driver')

sql.execute '''
 CREATE TABLE IF NOT EXISTS ASTRONAUTS(
 id int auto_increment primary key,
 name varchar(50),
 craft varchar(50)
 )
'''

response.people.each {
    sql.execute "INSERT INTO ASTRONAUTS(name, craft) VALUES (${it.name}, ${it.craft})"
}

sql.eachRow("SELECT * from ASTRONAUTS") {
    row -> println "${row.name.padRight(20)} aboard ${row.craft}"
}

sql.close()