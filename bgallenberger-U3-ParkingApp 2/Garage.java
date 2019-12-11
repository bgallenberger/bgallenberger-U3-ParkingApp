import java.util.ArrayList;
import java.util.List;

public class Garage {

    /**
     * displays the totals of the different types of tickets then return a value to the main class to tell it to stop
     */

    public static boolean Close(List<Ticket> ticketList){
        int closedFee = 0;
        int numClosed = 0;
        int specialFee = 0;
        int numSpecial = 0;
        int lostFee = 0;
        int numLost = 0;
        for(int i = 0; i<ticketList.size();i++){
            if(ticketList.get(i).getStatus().equals("Closed")){
                closedFee += ticketList.get(i).getFee();
                numClosed++;
            }else if(ticketList.get(i).getStatus().equals("Lost")){
                lostFee += ticketList.get(i).getFee();
                numLost++;
            }else if(ticketList.get(i).getStatus().equals("Special")){
                specialFee += ticketList.get(i).getFee();
                numSpecial++;
            }
        }
        System.out.println("\nBest Value Parking Garage\n" +
                "=========================\n");
        System.out.println("Activity to Date\n");
        System.out.println("$"+closedFee+" was collected from "+numClosed+" Check Ins");
        System.out.println("$"+specialFee+" was collected from "+numSpecial+" Special Event Tickets");
        System.out.println("$"+lostFee+" was collected from "+numLost+" Lost Tickets\n");
        System.out.println("$"+(closedFee+lostFee+specialFee)+" was collected overall");

        //close the garage
        return false;
    }
}
