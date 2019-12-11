import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketCheckIn {

    /**
     * CheckIn asks the user if they need a normal ticket or a special ticket
     * then runs TicketFactory to make the ticket
     * then displays the ticket to the user
     */

    public static void CheckIn(List<Ticket> ticketList) {
        //generate a new ticket for the user
        TicketFactory factory = TicketFactory.getFactory();
        Scanner keyboard = new Scanner(System.in);
        String input ="";
        boolean isvalid = false;
        //loop while until the user chooses an option
        while (isvalid == false) {
            System.out.print("\nBest Value Parking Garage\n" +
                    "Check-In\n" +
                    "=========================\n" +
                    "1 - Ticket\n" +
                    "2 - Special Event\n" +
                    "==>");
            input = keyboard.nextLine();
            isvalid = true;
            //check for valid input
            if (!(input.equals("1") || input.equals("2"))){
                System.out.println("invalid option");
                isvalid = false;
            }
        }

        String type = "";
        if(input.equals("1")){
            type = "Open";
        }else{
            type = "Special";
        }

        factory.GetTicket(type, ticketList);

        //get last ticket
        int ticketId = ticketList.size();

        System.out.print("\nBest Value Parking Garage\n" +
                "=========================\n" +
                "Receipt for a vehicle id "+ ticketId);

        if(input.equals("1")) {
            String amPm = "Am";
            if(ticketList.get(ticketId - 1).getCheckInTime()  == 12){
                amPm = "Pm";
            }
            System.out.println( "\n\n" +ticketList.get(ticketId - 1).getCheckInTime()+ amPm);
        }else{
            SpecialEventFee.CalculateFee(ticketList.get(ticketId - 1));
            System.out.println( "\n\nSpecial Event\n$20.00");
        }
    }
}

