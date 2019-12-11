import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * The Driver Class
 * This class takes in user input and then runs other classes
 *
 */
public class Main {

    public static void main(String[] args) {
        //make an arraylist of ticket objects to store tickets
        List<Ticket> ticketList = ReadInTickets.ReadTickets("tickets.txt");

        //loop through the ticket check in and out until the user closes the garage
        boolean garageOpen = true;
        while (garageOpen == true) {

            Scanner keyboard = new Scanner(System.in);
            String input = "";
            boolean isvalid = false;

            //loop while until the user chooses an option
            while (isvalid == false) {
                input ="";
                System.out.print("\nBest Value Parking Garage\n" +
                        "=========================\n" +
                        "1 - Check-In\n" +
                        "2 - Check-Out\n" +
                        "3 - Close Garage\n" +
                        "==>");
                input = keyboard.nextLine();
                isvalid = true;
                //check for valid input
                if (!(input.equals("1") || input.equals("2") || input.equals("3"))){
                    System.out.println("invalid option");
                    isvalid = false;
                }
            }
            //check which option the user picked then either
            // move on to the TicketCheckIn class or the TicketCheckOut class or close the garage
            switch(input){
                case ("1"):
                    TicketCheckIn.CheckIn(ticketList);
                    break;
                case ("2"):
                    TicketCheckOut.CheckOut(ticketList);
                    break;
                case ("3"):
                    garageOpen = Garage.Close(ticketList);
                    //write to file
                    WriteOutTickets.WriteTickets(ticketList, "tickets.txt");
                    break;
            }
        }
    }
}

