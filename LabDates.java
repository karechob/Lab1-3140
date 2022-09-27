import java.util.Scanner;
public class LabDates {
    public static void main (String [] args) {
        Scanner sc = new Scanner(System.in);
        String[] labDates = new String[4];
        labDates[0] = "9/28";
        labDates[1] = "10/26";
        labDates[2] = "11/23";
        labDates[3] = "12/7";

        System.out.println("----- Labs Due ~ Fall Semester 2022 -----");
        System.out.println("Please input the current date (M/D):");
        String currentDate = sc.next();

        String month = currentDate.substring(0, currentDate.indexOf("/"));
        String day = currentDate.substring(currentDate.indexOf("/") + 1, currentDate.length());
        int monthNum = Integer.parseInt(month);

        int daysLabOne = CalculateDateLabOne(day, month, labDates);
        int daysLabTwo = CalculateDateLabTwo(day, month, labDates);
        int daysLabThree = CalculateDateLabThree(day, month, labDates);
        int daysLabFour = CalculateDateLabFour(day, month, labDates);

        if(monthNum == 9) {
            if (daysLabOne < 0) {
                System.out.println("Lab One was due " + Math.abs(daysLabOne) + " day(s) ago.");
            } else {
                System.out.println("Lab One due in " + daysLabOne + " day(s).");
            }
        } else if (monthNum > 9){
            System.out.println("Lab One was due " + daysLabOne + " day(s) ago.");
        }

        if(monthNum == 10) {
            if (daysLabTwo < 0) {
                System.out.println("Lab Two was due " + Math.abs(daysLabTwo) + " days ago.");
            } else {
                System.out.println("Lab Two due in " + daysLabTwo + " day(s).");
            }
        } else if (monthNum < 10) {
            System.out.println("Lab Two due in " + daysLabTwo + " day(s).");
        } else if (monthNum > 10) {
            System.out.println("Lab Two was due " + daysLabTwo + " day(s) ago.");
        }

        if(monthNum == 11) {
            if(daysLabThree < 0) {
                System.out.println("Lab Three was due " + Math.abs(daysLabThree) + " days ago.");
            } else {
                System.out.println("Lab Three due in " + daysLabThree + " day(s).");
            }
        } else if (monthNum < 11) {
            System.out.println("Lab Three due in " + daysLabThree + " day(s).");
        } else if (monthNum > 11) {
            System.out.println("Lab Three was due " + daysLabThree + " day(s) ago.");
        }

        if(monthNum == 12) {
            if(daysLabFour < 0) {
                System.out.println("Lab Four was due " + Math.abs(daysLabFour) + " days ago.");
            } else {
                System.out.println("Lab Four due in " + daysLabFour + " day(s).");
            }
        } else if (monthNum < 12) {
            System.out.println("Lab Four due in " + daysLabFour + " day(s).");
        }


        System.out.println("If a Lab was 0 days ago, then it is due today.");
        sc.close();
    }
    
    public static int CalculateDateLabOne(String day, String month, String[] labDates){
        int daysTillLabOne = 0;
        if (Integer.parseInt(month) == 9){
            daysTillLabOne =  Integer.parseInt(labDates[0].substring(labDates[0].indexOf("/") + 1, labDates[0].length())) - Integer.parseInt(day);
        } else if (Integer.parseInt(month) == 10) {
            daysTillLabOne = Integer.parseInt(day) + 2;
        } else if (Integer.parseInt(month) == 11) {
            daysTillLabOne = Integer.parseInt(day) + 33;
        } else if (Integer.parseInt(month) == 12) {
            daysTillLabOne = Integer.parseInt(day) + 63;
        }
        return daysTillLabOne;
    }
    public static int CalculateDateLabTwo(String day, String month, String[] labDates){
        int daysTillLabTwo = 0;
        if (Integer.parseInt(month) == 10){
            daysTillLabTwo =  Integer.parseInt(labDates[1].substring(labDates[1].indexOf("/") + 1, labDates[1].length())) - Integer.parseInt(day);
        } else if (Integer.parseInt(month) == 9) {
            daysTillLabTwo = (30 - Integer.parseInt(day)) + 26 ;
        } else if (Integer.parseInt(month) == 11) {
            daysTillLabTwo = Integer.parseInt(day) + 5;
        } else if (Integer.parseInt(month) == 12) {
            daysTillLabTwo = Integer.parseInt(day) + 35;
        }
        return daysTillLabTwo;
    }
    public static int CalculateDateLabThree(String day, String month, String[] labDates){ 
        int daysTillLabThree = 0;
        if (Integer.parseInt(month) == 11){
            daysTillLabThree =  Integer.parseInt(labDates[2].substring(labDates[2].indexOf("/") + 1, labDates[2].length())) - Integer.parseInt(day);
        } else if (Integer.parseInt(month) == 9) {
            daysTillLabThree = (61 - Integer.parseInt(day)) + 23 ;
        } else if (Integer.parseInt(month) == 10) {
            daysTillLabThree = Integer.parseInt(day) + 5;
        } else if (Integer.parseInt(month) == 12) {
            daysTillLabThree = Integer.parseInt(day) + 35;
        }
        return daysTillLabThree;
    }
    public static int CalculateDateLabFour(String day, String month, String[] labDates){ 
        int daysTillLabFour = 0; 
        if (Integer.parseInt(month) == 12){
            daysTillLabFour =  Integer.parseInt(labDates[3].substring(labDates[2].indexOf("/") + 1, labDates[3].length())) - Integer.parseInt(day);
        } else if (Integer.parseInt(month) == 9) {
            daysTillLabFour = (91 - Integer.parseInt(day)) + 7 ;
        } else if (Integer.parseInt(month) == 10) {
            daysTillLabFour = (61 - Integer.parseInt(day)) + 7;
        } else if (Integer.parseInt(month) == 11) {
            daysTillLabFour = (30 - Integer.parseInt(day)) + 7;
        }
        return daysTillLabFour;
    }
}