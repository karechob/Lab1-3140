import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;
public class LabDates {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("------- Days Lab -------");
        System.out.println("\n*Some key words for dates:");
        System.out.println("\"lab1\", \"lab2\", \"lab3\", \"lab4\", \"quiz1\", \n\"quiz2\", \"quiz3\", \"quiz4\", \"quiz5\", \"finalexam\"");
        System.out.println("\nFormat for the dates can be: \"MM/DD/YYYY\" or \"MM-DD\" (last format will set year to upcoming year.)");
        System.out.println("\nEnter the two dates or keywords to calculate number of days left:");
        System.out.println("\n--------------------------------");
        while (sc.hasNext()) {
            printDays(sc.next(), sc.next());
        }
        sc.close();

    }
    public static void printDays(String firstDate, String secondDate){
        LocalDate printFirstDate = savedDate(firstDate);
        LocalDate printSecondDate = savedDate(secondDate);

        long days = ChronoUnit.DAYS.between(printFirstDate, printSecondDate);
        String daysBetString = "There's " + days + " days between the two dates.";
        System.out.println(daysBetString.contains("-") ? daysBetString.replace("-", "") : daysBetString);
        
    }
    public static LocalDate savedDate(String date){
        LocalDate quiz1Date = LocalDate.of(2022, 9, 14);
        LocalDate quiz2Date = LocalDate.of(2022, 9, 28);
        LocalDate quiz3Date = LocalDate.of(2022, 10, 26);
        LocalDate quiz4Date = LocalDate.of(2022, 11, 16);
        LocalDate quiz5Date = LocalDate.of(2022, 12, 7);
        LocalDate lab1Date = LocalDate.of(2022, 9, 28);
        LocalDate lab2Date = LocalDate.of(2022, 10, 26);
        LocalDate lab3Date = LocalDate.of(2022, 11, 23);
        LocalDate lab4Date = LocalDate.of(2022, 12, 7); 
        LocalDate finalExam = LocalDate.of(2022, 12, 19);

        if(date.equals("quiz1")) {
            return quiz1Date;
        } else if(date.equals("quiz2")) {
            return quiz2Date;
        } else if(date.equals("quiz3")) {
            return quiz3Date;
        } else if(date.equals("quiz4")) {
            return quiz4Date;
        } else if(date.equals("quiz5")) {
            return quiz5Date;
        } else if(date.equals("lab1")) {
            return lab1Date;
        } else if(date.equals("lab2")) {
            return lab2Date;
        } else if(date.equals("lab3")) {
            return lab3Date;
        } else if(date.equals("lab4")) {
            return lab4Date;
        } else if(date.equals("finalexam")) {
            return finalExam;
        }
        return dateFormatCheck(date);
    } 
    public static LocalDate dateFormatCheck(String date){ //change code here to change the format of the date 
        String regexMMDD = "(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])"; //MM-DD
        String regexMMDDYYYY = "(0[1-9]|1[012])/(0[1-9]|[12][0-9]|3[01])/((?:19|20)[0-9][0-9])"; //MM/DD/YYYY
       
        // String regexYYYYMMDD = "((?:19|20)[0-9][0-9])-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])"; //YYYY-MM-DD
        //this allows input in the format YYYY-MM-DD
        
        Pattern patternMMDD = Pattern.compile(regexMMDD);
        Pattern patternMMDDYYYY = Pattern.compile(regexMMDDYYYY);
        //Pattern patternYYYYMMDD = Pattern.compile(regexYYYYMMDD); this would compile the pattern to match strings of the format YYYY-MM-DD
        
        Matcher dateMatchMMDD = patternMMDD.matcher(date);
        Matcher dateMatchMMDDYYYY = patternMMDDYYYY.matcher(date);
       // Matcher dateMatchYYYYMMDD = patternYYYYMMDD.matcher(date); this matches the strings of the format YYYY-MM-DD

        if(dateMatchMMDD.matches() == true) {
            String dateStr[] = date.split("-");
            String fullDateMMDD = "2023" + "-" + dateStr[0] + "-" + dateStr[1];

            LocalDate finalDateMMDD = LocalDate.parse(fullDateMMDD);
            return finalDateMMDD;
        } else if (dateMatchMMDDYYYY.matches() == true) {
            String dateStr2[] = date.split("/");
            String fullDateMMDDYYYY = dateStr2[2] + "-" + dateStr2[0] + "-" + dateStr2[1];

            LocalDate finalDateMMDDYYYY = LocalDate.parse(fullDateMMDDYYYY);
            return finalDateMMDDYYYY;
        }
        
        if(dateMatchMMDD.matches() == false && dateMatchMMDDYYYY.matches() == false) {
            System.out.println("Wrong format, enter another date in either of these formats: \n\"YYYY-MM-DD\", \"MM/DD/YYYY\" or \"MM-DD\"");
        }

        LocalDate curDate = LocalDate.now();
        return curDate; 
    }
}