package transport;

public class Bus extends Vehicle{


    @Override
    public void setSeatingCapacity(int seatingCapacity) {
        super.setSeatingCapacity(seatingCapacity);
    }

    @Override
    public int calculateVehicleFare(int seatingCapacity) {
        int defaultFare = super.calculateVehicleFare(seatingCapacity);
        int totalFare = (int) (defaultFare + (defaultFare * 0.1));
        return totalFare;
    }


}
