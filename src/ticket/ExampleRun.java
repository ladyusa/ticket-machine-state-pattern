package ticket;

public class ExampleRun {

    public static void main(String[] args) {
        // สถานีปัจจุบัน คือ สถานีเกษตรศาสตร์
        TicketMachine ticketMachine = new TicketMachine("มหาวิทยาลัยเกษตรศาสตร์");

        // ซื้อตั๋วไปสถานี รัชโยธิน ราคา 20 บาท
        ticketMachine.chooseStation("รัชโยธิน");
        ticketMachine.insertCoin(5);
        ticketMachine.insertCoin(10);
        ticketMachine.insertCoin(10);
        ticketMachine.retrieveTicket();
    }
}
