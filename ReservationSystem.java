import java.util.*;

class ReservationSystem {
    private List<Train> trains;

    public ReservationSystem() {
        this.trains = new ArrayList<Train>();
    }

    public void addTrain(Train train) {
        trains.add(train);
    }

    public Train getTrain(String trainNumber) {
        for (Train train : trains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                return train;
            }
        }
        return null;
    }
    public List<Train> findAvailableTrains(String currentCode, String destinationCode) {
        List<Train> availableTrains = new ArrayList<Train>();
        for (Train train : trains) {
            if (train.getCurrentCode().equalsIgnoreCase(currentCode) &&
                train.getDestinationCode().equalsIgnoreCase(destinationCode)) {
                availableTrains.add(train);
            }
        }
        return availableTrains;
    }
}
