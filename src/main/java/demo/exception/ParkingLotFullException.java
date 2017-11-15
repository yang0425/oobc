package demo.exception;

public class ParkingLotFullException extends RuntimeException {

    public ParkingLotFullException() {
        super("the parking lot is full!");
    }

}
