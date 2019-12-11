import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ReadInTickets {

    /**
     * reads in the values on a file and converts them to tickets then adds them to the ticketList
     */

    public static List<Ticket> ReadTickets(String fileName) {
        //make an arraylist of ticket objects to store tickets
        List<Ticket> ticketList = new ArrayList<Ticket>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            String[] readList = new String[5];
            String line;
            while ((line = br.readLine()) != null) {
                //split line into a string array
                readList = line.split(",");

                //put string array into ticket objects
                Ticket newTicket = new Ticket();
                newTicket.setCheckInTime(Integer.parseInt(readList[0]));
                newTicket.setCheckOutTime(Integer.parseInt(readList[1]));
                newTicket.setStatus(readList[2]);
                newTicket.setFee(Integer.parseInt(readList[3]));
                newTicket.setTicketId(Integer.parseInt(readList[4]));

                //put new ticket into the ticket list
                ticketList.add(newTicket);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ticketList;
    }
}
