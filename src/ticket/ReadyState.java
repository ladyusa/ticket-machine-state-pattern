package ticket;

public class ReadyState implements State {

    private TicketMachine ticketMachine;

    public ReadyState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void chooseStation(String toStation) {
        // activity การคำนวณและแสดงราคาตั๋ว
        ticketMachine.calculatePrice(toStation);
        double price = ticketMachine.getCurrentTicketPrice();
        System.out.println("คุณเลือกสถานี" + toStation + " ราคาตั๋ว " + price + " บาท");

        // เปลี่ยน state มาเป็น "จ่ายเงิน"
        ticketMachine.setCurrentState(ticketMachine.getAcceptingCoin());

        // entry activity ของ state "จ่ายเงิน"
        System.out.println("ต้องจ่ายเงินอีกจำนวน : " + price);
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("Please choose station first");
    }

    @Override
    public void retrieveTicket() {
        System.out.println("Please choose station first");
    }
}
