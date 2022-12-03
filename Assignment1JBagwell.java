//CS140 - Assignment 1
//Judy Bagwell
//This program produces two calendars and a graphic. 
//The first calendar shows the month based on a date 
//input by a user, and the second for the month of 
//the current date.

import java.util.Scanner; //allows user data to be input
import java.util.Calendar; //allows use of Calendar object 

public class Assignment1JBagwell {

    
    public static void main (String[] args) //Main Method
    {
       //I need the current date for my ASCII dog 
       Calendar today = Calendar.getInstance();
       
       drawDog(today.get(Calendar.MONTH) + 1);
           
       //collection of user data (month and day)
       Scanner console = new Scanner (System.in);
       
       System.out.print("What date would you like to look " +
                         "at? (mm/dd)\t");
       String userDate = console.next();
       
       //Calendar from user input    
          //Displays calendar   
       drawMonth(monthFromDate(userDate));
          //Displays date info - I thought about adding this
          //directly to the drawMonth method, but I would 
          //have to add a parameter for the the day to that
          //method, and I was following the directions to use
          //the method drawMonth(int month)
       displayDate(monthFromDate(userDate), 
               dayFromDate(userDate));
       System.out.println();
       
       //Calendar for today's date:
       System.out.println("This month:");

          //Displays calendar
       drawMonth(today.get(Calendar.MONTH) + 1);
          //Displays date info
       displayDate(today.get(Calendar.MONTH) + 1, 
               today.get(Calendar.DATE));

    }
    
    public static void drawDog (int bonesPerMonth)
    {
        System.out.printf("%26s\n", " ^        ^  ");
        System.out.printf("%26s\n", "/ \\  __  / \\ ");
        System.out.printf("%26s\n", "/   \\/  \\/   \\");
        System.out.printf("%26s\n", "|            |");
        System.out.printf("%26s\n", "|   ^    ^   |");
        System.out.printf("%26s\n", "\\  *    *  / ");
        System.out.printf("%26s\n", "\\        /  ");
        System.out.printf("%26s\n", "\\  __  /   ");
        System.out.printf("%26s\n", "\\/  \\/    ");
        System.out.printf ("%26s\n", "\\__/     ");        
        
        drawBone(bonesPerMonth);//whatever month it is, that 
                                //is how many lines of bones
                                //the dog gets
    }
    
    public static void drawBone (int bonesQty)
    {
        for (int i = 1; i <= bonesQty; i++)
        {
            for (int j = 1; j <= i; j++)
            {
                System.out.print("(\\_/)");
            }
            System.out.println();
            for (int j = 1; j <= i; j++)
            {
                System.out.print("(/ \\)");
            }
            System.out.println();
        }
    }
    
    public static void drawMonth (int month)
    {
        System.out.printf("%24d\n", month);
        for (int week = 1; week <= 5; week++)
        {
            drawRow(week);
        }
        for (int stars = 1; stars <=50; stars++)
        {
        System.out.print("*");
        }
        System.out.println();
    }
    
    public static void drawRow (int row)
    {
        for (int stars = 1; stars <= 49; stars++)
        {
            System.out.print("*");
        }
        System.out.println("*");

        for (int weekday = row*7-6; weekday <= row*7; 
                weekday++)
        {
            System.out.printf("|%-6d", weekday);
        }
        System.out.println("|");
                for (int weekday = row*7-6; weekday <= row*7; 
                        weekday++)
        {
            System.out.printf("|  %-4d", weekday);
        }
        System.out.println("|");
                for (int weekday = row*7-6; weekday <= row*7; 
                        weekday++)
        {
            System.out.printf("|%6d", weekday);
        }
        System.out.println("|");
    }   
    
    public static void displayDate (int month, int day)
    //display the month and day
    {
        System.out.println("Month: " + month);
        System.out.println("Day: " + day);
    }     
    
    
    public static int monthFromDate (String userDate)
    //produces the month as an integer from whatever
    //value is input by the user
    {
        int userMonth = Integer.parseInt(userDate.substring(0,
                2));
        return (userMonth);
    }

    public static int dayFromDate (String userDate)
    //produces the day as an integer from whatever 
    //value is input by the user
    {
        int userDay = Integer.parseInt(userDate.substring(3,
                5));
        return (userDay);
    }        
}
    
    