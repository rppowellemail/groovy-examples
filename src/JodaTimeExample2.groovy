
// https://stackoverflow.com/questions/10734368/groovy-how-do-you-initialise-and-compare-date-time-values-from-different-timezo

//@Grab( 'joda-time:joda-time:21' )
//@Grab( 'joda-time:joda-time:latest.release' )
//@Grab( 'joda-time:joda-time' )
@Grab( 'joda-time:joda-time:+' )
import org.joda.time.*
import org.joda.time.format.*

String s = "2021-02-13 14:12:22 -08:00"
DateTimeFormatter dtf = DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss Z" )
def d = dtf.parseDateTime( s )

println d

//println DateTimeFormat.forPattern( "yyyy-MM-dd HH:mm:ss Z" ).parseDateTime( "2021-02-13 14:12:22 -0800" );
