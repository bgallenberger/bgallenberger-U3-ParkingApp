import java.util.List;

/**
 * this class also represents the singleton pattern as there is only ever 1 instance of the factory pattern
 *
 * You Said that because of the design of my project(only 1 type of ticket and passing in an array list of objects)
 * that it was ok to not have a proper factory strategy
 * Makes a ticket and adds it to the ticketList
 */

public class TicketFactory {
    private static TicketFactory factory = new TicketFactory();
    private TicketFactory() {

    }
    public static TicketFactory getFactory() {
        return factory;
    }
    public void GetTicket(String type, List<Ticket> ticketList){
        //create a ticket and add it to the list

        //make new ticket
        Ticket newTicket = new Ticket();
        // add ticket to ticket list
        ticketList.add(newTicket);
        //get last ticket
        int ticketId = ticketList.size();
        //set id of the last ticket
        ticketList.get(ticketId - 1).setTicketId(ticketId);
        //set check in time
        ticketList.get(ticketId - 1).setCheckInTime((int) ((Math.random() * 5) + 7));

        switch (type){
            case "Special":
                //set checkout time to -1
                ticketList.get(ticketId -1).setCheckOutTime(-1);
                //set ticket status to Special
                ticketList.get(ticketId-1).setStatus("Special");
                break;
                default:
        }
    }
}
