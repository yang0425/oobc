package demo.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
        super("the car is not exist in the parking lot!");
    }

}
