/**
 * the ticket object
 */

public class Ticket {
    private int checkInTime;
    private int checkOutTime;
    private String status;
    private int fee;
    private int ticketId;

    public void Ticket(){
        checkOutTime = -1;
        status = "Open";
        fee = 0;
    }

    public void setCheckInTime(int in) {
        this.checkInTime = in;
    }

    public void setCheckOutTime(int out) {
        this.checkOutTime = out;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getCheckInTime() {
        return checkInTime;
    }

    public int getCheckOutTime() {
        return checkOutTime;
    }

    public String getStatus() {
        return status;
    }

    public int getFee() {
        return fee;
    }

    public int getTicketId() {
        return ticketId;
    }
}
