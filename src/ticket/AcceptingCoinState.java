package ticket;

public class AcceptingCoinState implements State {

    private TicketMachine ticketMachine;
    private double currentPayment;

    public AcceptingCoinState(TicketMachine ticketMachine) {
        this.ticketMachine = ticketMachine;
    }

    @Override
    public void chooseStation(String toStation) {
        System.out.println("Cannot change station");
    }

    @Override
    public void insertCoin(double amount) {
        System.out.println("คุณหยอดเหรียญ " + amount + " บาท");

        currentPayment += amount;
        double price = ticketMachine.getCurrentTicketPrice();

        // Guard: ยังจ่ายเงินไม่ครบ
        if (currentPayment < price) {
            // stay in the same state
            // entry activity ของ state "จ่ายเงิน"
            System.out.println("ต้องจ่ายเงินอีกจำนวน : " + (price - currentPayment));
        }
        // Guard: จ่ายเงินเท่ากับหรือมากกว่าราคาตั๋วแล้ว
        else {
            System.out.println("จ่ายเงินครบแล้ว");

            // ถ้าจ่ายมากกว่า จะทอนเงินให้
            if (currentPayment > price)
                // activity การทอนเงิน
                System.out.println("ทอนเงิน: " + (currentPayment - price));

            // เปลี่ยน state มาเป็น "สิ้นสุดการทำงาน" และ reset จำนวนเงินที่จ่ายแล้ว
            ticketMachine.setCurrentState(ticketMachine.getDone());
            currentPayment = 0;
        }
    }

    @Override
    public void retrieveTicket() {
        System.out.println("Please pay in full first");
    }
}
