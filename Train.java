import java.util.*;

class Train {
    public String destination;
    public String currentlocation;
    public String trainNumber;
    public String trainName;
    public int totalSeats;
    public List<Seat> AC_Seats;
    public List<Seat> Sleeper_Seats;
    public List<Seat> General_Seats;
    public int available_ac_seats;
    public int available_gen_seats;
    public int available_sleep_seats;
    List<Seat> seat=null;
    
    public Train(String currentlocation,String destination,String trainNumber, String trainName, int totalSeats) {
        this.destination=destination;
        this.currentlocation=currentlocation;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.totalSeats=totalSeats;
        this.AC_Seats=new ArrayList<Seat>();
        this.Sleeper_Seats=new ArrayList<Seat>();
        this.General_Seats=new ArrayList<Seat>();
        this.initializeSeats(totalSeats);
        this.available_ac_seats=totalSeats/3;
        this.available_gen_seats=totalSeats/3;
        this.available_sleep_seats=totalSeats/3;
    }

    public void setTrainClass(int cls){
        if(cls==1){
            seat=AC_Seats;
        }
        else if(cls==2){
            seat=Sleeper_Seats;
        }
        else{
            seat=General_Seats;
        }
    }

    private void initializeSeats(int totalSeats) {
        for (int i = 1; i <= totalSeats/3; i++) {
            AC_Seats.add(new Seat(i));
            Sleeper_Seats.add(new Seat(i));
            General_Seats.add(new Seat(i));

        }
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }
    public String getCurrentCode() {
        return currentlocation;
    }
    public String getDestinationCode() {
        return destination;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public void getAvailableSeats() {
        System.out.println("AC      : "+available_ac_seats);
        System.out.println("General : "+available_gen_seats);
        System.out.println("Sleeper : "+available_sleep_seats);
    }
    public Seat reserveSeat(int seatNumber,int cls) {
        Seat seat1 = getSeat(seatNumber);
        if (seat1 == null || seat1.isReserved()) {
            System.out.println("seat already reserved!");
            return null;
        }
        seat1.reserve();
        System.out.println("Seat " + seatNumber + " reserved successfully!");
        if(cls==1){
            available_ac_seats--;
        }
        else if(cls==2){
            available_sleep_seats--;
        }
        else{
            available_gen_seats--;
        }
        return seat1;
    }

    public void displayAvailableSeats() {
        System.out.println(this.trainName+" is going from "+this.currentlocation+" -> "+this.destination);
        System.out.println("Available seats :");
        int i=1;
        for (Seat seat1 : seat) {
            if (!seat1.isReserved()) {
                System.out.print(seat1.getSeatNumber() + "\t");
            }
            else {
                System.out.print("X\t");
            }
            if(i%4==0){
                System.out.println();
            }
            else if(i%2==0){
                System.out.print("\t");
            }
            i++;
        }
        System.out.println();
    }

    private Seat getSeat(int seatNumber) {
        for (Seat seat1 : seat) {
            if (seat1.getSeatNumber() == seatNumber) {
                return seat1;
            }
        }
        return null;
    }
}