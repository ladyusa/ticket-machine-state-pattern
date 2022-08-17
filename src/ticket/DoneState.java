package ticket;

public class DoneState implements State {

    private TicketMachine ticketMachine;

    public DoneState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void chooseStation(String toStation) {
        System.out.println("Please take a ticket first");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Please take a ticket first");
    }

    @Override
    public void retrieveTicket() {
        // activity ออกตั๋ว
        System.out.println("Giving out a ticket");

        // เปลี่ยน state มาเป็น "Ready"
        ticketMachine.setCurrentState(ticketMachine.getReady());

        // entry activity ของ state "Ready"
        System.out.println("สวัสดี คุณอยู่ที่สถานี " + ticketMachine.getCurrentStation());
    }
}
