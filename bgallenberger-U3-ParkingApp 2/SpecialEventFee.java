public class SpecialEventFee implements FeeStrategy {
    /**
     * sets the fee of a Special event ticket
     */

    public static void CalculateFee(Ticket ticket){
        ticket.setFee(20);
    };
}
