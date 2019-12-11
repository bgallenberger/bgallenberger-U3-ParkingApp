public class LostFee implements FeeStrategy {
    /**
     * sets the fee of a lost ticket
     */
    public static void CalculateFee(Ticket ticket){
            ticket.setFee(25);
    };
}