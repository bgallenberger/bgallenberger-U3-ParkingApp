import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketCheckOut {

    /**
     * user chooses to return a ticket or say that they lost it
     * then the user must input a valid ticket id
     * then runs a strategy pattern depending on the type of ticket
     * then prints the receipt of the ticket
     */


    public static void CheckOut(List<Ticket> ticketList) {
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();
        boolean isvalid = false;

        //loop until user says 1 or 2
        while (isvalid == false) {
            System.out.print("\nBest Value Parking Garage\n" +
                    "Check-Out\n" +
                    "=========================\n" +
                    "1 - Check/Out\n" +
                    "2 - Lost ticket\n" +
                    "==>");
            input = keyboard.nextLine();
            isvalid = true;
            if (!(input.equals("1") || input.equals("2"))) {
                System.out.println("invalid option");
                isvalid = false;
            }
        }

        int id = 1;
        isvalid = false;
        boolean openTicket = true;
        //loop until user enters a valid ticket id
        while (isvalid == false) {
            System.out.print("\nBest Value Parking Garage\n" +
                    "Check-Out - Ticket\n" +
                    "=========================\n" +
                    "Ticket Number ==>");

            id = keyboard.nextInt();
            for (int i = 0; i < ticketList.size(); i++) {
                if (ticketList.get(i).getTicketId() == id) {
                    if (ticketList.get(i).getStatus() == "Open") {
                        isvalid = true;
                    } else {
                        System.out.println("That ticket has already been checked out");
                        isvalid = true;
                        openTicket = false;
                    }
                }
            }

            if (!isvalid) {
                System.out.println("invalid ticket");
            }
        }

        if (openTicket) {
            switch (input) {
                case ("1"):
                    if(ticketList.get(id - 1).getStatus() == "Special"){
                    }else{
                        ticketList.get(id - 1).setStatus("Closed");
                    }
                    break;
                case ("2"):
                    //set checkout time to -1
                    ticketList.get(id - 1).setCheckOutTime(-1);
                    ticketList.get(id - 1).setStatus("Lost");
                    break;
            }
            int hoursParked = 0;
            switch (ticketList.get(id - 1).getStatus()) {
                case "Open":
                    // generate ticket check out time
                    ticketList.get(id - 1).setCheckOutTime((int) ((Math.random() * 10) + 13));
                    //feeStrategy
                    ClosedFee.CalculateFee(ticketList.get(id - 1));
                    //set ticket status to closed
                    ticketList.get(id - 1).setStatus("Closed");
                    break;
                case "Special":
                    //feeStrategy
                    SpecialEventFee.CalculateFee(ticketList.get(id - 1));
                    break;
                case "Lost":
                    //feeStrategy
                    LostFee.CalculateFee(ticketList.get(id - 1));
                    break;
            }

            if(ticketList.get(id - 1).getStatus().equals("Special")){

            }else {
                //print ticket
                System.out.print("\nBest Value Parking Garage\n" +
                        "=========================\n");
                System.out.println("Receipt for a vehicle id " + ticketList.get(id - 1).getTicketId() + "\n");
                //hours parked

                if (ticketList.get(id - 1).getStatus().equals("Closed")) {
                    System.out.print(hoursParked + " hours parked " + ticketList.get(id - 1).getCheckInTime());
                    //check for am or pm
                    if (ticketList.get(id - 1).getCheckInTime() < 12) {
                        System.out.print("am - ");
                    } else {
                        System.out.print("pm - ");
                    }
                    System.out.println((ticketList.get(id - 1).getCheckOutTime() - 12) + "pm");
                } else if (ticketList.get(id - 1).getStatus().equals("Lost")) {
                    System.out.println("Lost Ticket");
                }
                System.out.println("$" + ticketList.get(id - 1).getFee() + ".00");
            }
        }
    }
}
