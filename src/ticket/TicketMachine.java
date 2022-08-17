package ticket;

public class TicketMachine {
    private State ready;
    private State acceptingCoin;
    private State done;
    private State currentState;

    private String currentStation;
    private double currentTicketPrice;

    public TicketMachine(String currentStation) {
        this.currentStation = currentStation;

        this.ready = new ReadyState(this);
        this.acceptingCoin = new AcceptingCoinState(this);
        this.done = new DoneState(this);

        // entry activity ของ state "Ready"
        System.out.println("สวัสดี คุณอยู่ที่สถานี " + currentStation);
        this.currentState = ready;
    }

    public void calculatePrice(String toStation) {
        // .... calculate price ....
        // .... สำหรับโจทย์ข้อนี้ hard code ราคาไปก่อน
        currentTicketPrice = 20;
    }

    public String getCurrentStation() {
        return currentStation;
    }

    public double getCurrentTicketPrice() {
        return currentTicketPrice;
    }

    public void setCurrentState(State state) {
        this.currentState = state;
    }

    public void chooseStation(String toStation) {
        currentState.chooseStation(toStation);
    }
    public void insertCoin(double amount) {
        currentState.insertCoin(amount);
    }
    public void retrieveTicket() {
        currentState.retrieveTicket();
    }

    public State getReady() {
        return ready;
    }

    public State getAcceptingCoin() {
        return acceptingCoin;
    }

    public State getDone() {
        return done;
    }
}
