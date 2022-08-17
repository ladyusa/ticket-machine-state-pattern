package ticket;

public interface State {
    void chooseStation(String toStation);
    void insertCoin(double amount);
    void retrieveTicket();
}
