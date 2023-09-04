import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();
        Scanner sc = new Scanner(System.in);
        Train train1 = new Train("Tirupati","Warangal","123","krishna Express",120);
        Train train2 = new Train("Tirupati","Warangal","124","Pandmavathi Express",120);
        Train train3 = new Train("Delhi","Hyderabad","125","Shatabdi Express",120);
        Train train4 = new Train("Delhi","Bengaluru","126","Rajdhani Express",120);
        Train train5 = new Train("Kolkata","Chennai","127","Duronto Express",120);
        reservationSystem.addTrain(train1);
        reservationSystem.addTrain(train2);
        reservationSystem.addTrain(train3);
        reservationSystem.addTrain(train4);
        reservationSystem.addTrain(train5);
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);  // Get current hour in 24-hour format
        boolean exit = false;
        
        if (hour < 8 || hour >= 20) {
            System.out.println("Portal works between 8 AM and 8 PM.");
        }
        else{
            while (!exit) {
                System.out.println("\nRailway Reservation System");
                System.out.println("1. Reserve a seat");
                System.out.println("2. Exit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the newline character

                switch (choice) {
                    case 1:
                        System.out.print("Enter the current code: ");
                        String currentCode = sc.nextLine();
                
                        System.out.print("Enter the destination code: ");
                        String destinationCode = sc.nextLine();
            
                        List<Train> availableTrains = reservationSystem.findAvailableTrains(currentCode, destinationCode);
                        System.out.print("\n");
                        if (availableTrains.isEmpty()) {
                            System.out.println("No trains available for this route.");
                        } 
                        else {
                            System.out.println("Available Trains:");
                            for (Train train : availableTrains) {
                                System.out.println("Train Number: " + train.getTrainNumber());
                                System.out.println("Train Name: " + train.getTrainName());
                                System.out.println("Total Seats: " + train.getTotalSeats());
                                System.out.println("Available Seats: ");
                                train.getAvailableSeats();
                                System.out.print("\n");
                            }
                            System.out.print("\n");
                            System.out.print("Enter the train number to reserve seats: ");
                            String selectedTrainNumber = sc.nextLine();
                            Train train = null;
                            for (Train trains : availableTrains) {
                                if (trains.getTrainNumber().equalsIgnoreCase(selectedTrainNumber)) {
                                    train = trains;
                                    break;
                                }
                            }
                            if (train == null) {
                                System.out.println("Invalid train number!");
                            } 
                            else {
                                System.out.print("\n");
                                System.out.println("Enter fare class : ");
                                System.out.println("1.AC \n2.Sleeper \n3.General");
                                int cls=sc.nextInt();
                                train.setTrainClass(cls);
                                System.out.print("\n");
                                System.out.print("Enter the number of seats to reserve: ");
                                int numSeats = sc.nextInt();
                                System.out.println();
                                if(( cls==1 && numSeats>train.available_ac_seats) || ( cls==2 && numSeats>train.available_sleep_seats) || ( cls==3 && numSeats>train.available_gen_seats) ){
                                    System.out.println("Sorry number of requested seats are not available");
                                }
                                else{
                                    ArrayList<Passenger> p=new ArrayList<Passenger>();
                                    for(int i=0;i<numSeats;i++){
                                        System.out.print("Enter passenger name: ");
                                        String passengerName = sc.nextLine();
                                        sc.nextLine();
                                        System.out.print("Enter passenger age: ");
                                        int passengerAge = sc.nextInt();
                                        Passenger passenger = new Passenger(passengerName, passengerAge);
                                        p.add(passenger);
                                    }
                                    train.displayAvailableSeats();
                                    for(int i=0;i<numSeats;){
                                        System.out.print("\n");
                                        System.out.print("Enter the seat number to reserve: ");
                                        int seatNumber = sc.nextInt();
                                        sc.nextLine(); // Consume the newline character
                                        Seat re=train.reserveSeat(seatNumber,cls);
                                        if(re!=null){
                                            re.passenger=p.get(i);
                                            i++;
                                        }
                                    }
                                }
                                System.out.println("****************** Payment Details ******************");
                                System.out.println("Mode of Payment : ");
                                System.out.println("1. Credit Card/Debit Card(10% tax)\n2. Cash");
                                System.out.print("Select Mode of Payment : ");
                                int m=sc.nextInt();
                                System.out.println();
                                Payment pay=new Payment(selectedTrainNumber,numSeats,cls);
                                pay.get_amt(m);
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Thank you for using the Railway Reservation System!");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice!");
                        break;
                }
            }
        }
    }
}