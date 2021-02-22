
// https://stackoverflow.com/questions/10734368/groovy-how-do-you-initialise-and-compare-date-time-values-from-different-timezo

@Grab( 'joda-time:joda-time:2.1' )
import org.joda.time.*
import org.joda.time.format.*

String a = "18-05-2012 09:29:41 +0800"
String b = "18-05-2012 09:29:21 +0900"

DateTimeFormatter dtf = DateTimeFormat.forPattern( "dd-MM-yyyy HH:mm:ss Z" );

def start = dtf.parseDateTime( a )
def end = dtf.parseDateTime( b )

assert 1 == Hours.hoursBetween( end, start ).hours

println start

println DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss Z" ).parseDateTime( "2021-02-13 14:12:22 -0800" );