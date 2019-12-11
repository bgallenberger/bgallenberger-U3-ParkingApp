import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

/**
 * takes the ticketList and writes each ticket in it to a file
 */

public class WriteOutTickets {
    public static void WriteTickets(List<Ticket> ticketList, String fileName){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
            for(int i = 0;i<ticketList.size();i++){
                bw.append(ticketList.get(i).getCheckInTime()+",");
                bw.append(ticketList.get(i).getCheckOutTime()+",");
                bw.append(ticketList.get(i).getStatus()+",");
                bw.append(ticketList.get(i).getFee()+",");
                bw.append(ticketList.get(i).getTicketId()+",\n");
            }
            bw.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
