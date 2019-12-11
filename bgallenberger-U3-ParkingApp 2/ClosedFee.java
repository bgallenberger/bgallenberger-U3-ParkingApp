public class ClosedFee implements FeeStrategy {

    /**
     * sets the price of a normal ticket based on time
     */

    public static void CalculateFee(Ticket ticket){
        //calculate the hours parked to calculate ticket fee
        int hoursParked = ticket.getCheckOutTime() - ticket.getCheckInTime();

        if(hoursParked<=3){
            ticket.setFee(5);
        } else if(hoursParked > 3 && hoursParked <= 13){
            ticket.setFee((hoursParked - 3) + 5);
        }else{
            ticket.setFee(15);
        }
    };
}
