package unl.soc;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.Period;

// This is some sort of java program
// I guess, this is really bad documentation
//so Im not ReAlLy SuRe.
public class Birthday {public static void main(String args[]) {
		
String name = "Java";

int 
month = 1;
int date  = 23;
int year  = 1996;

DateTime              bday = 
		   new DateTime(year, month, date, 0, 0);
DateTime today = new DateTime();

Period age = new Period(bday, today);

int years = age.getYears();
int months = age.getMonths();
int days = age.getWeeks() * 7 + age.getDays();

DateTime next_bday = new DateTime(year + years + 1, month, date, 0, 0);
Interval days_to_next_bday_i = 
  new Interval(today, next_bday);
double days_remaining = 
  days_to_next_bday_i.toDurationMillis() / (1000 * 60 * 60 * 24) + 1;

 if (today==bday) System.out.println("Happy Birthday,"+name+"!");
      else
    	 System.out.println("Hi "+name+", your next birthday is "+next_bday+".");
		
}
}
