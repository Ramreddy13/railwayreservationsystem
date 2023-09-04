class Seat {
    public int seatNumber;
    public Passenger passenger;
    public boolean reserved;

    public Seat(int seatNumber) {
        this.seatNumber = seatNumber;
        this.reserved = false;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void reserve() {
        reserved = true;
    }
}