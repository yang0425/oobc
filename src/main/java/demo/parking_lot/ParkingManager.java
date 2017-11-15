package demo.parking_lot;

import demo.exception.ParkingLotFullException;
import demo.model.Car;

public class ParkingManager {

    private final PickHelper pickHelper;
    private ParkingAble[] parkingAbles;

    ParkingManager(ParkingAble... parkingAbles) {
        this.parkingAbles = parkingAbles;
        this.pickHelper = new PickHelper(parkingAbles);
    }

    public String park(Car car) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.isNotFull()) {
                return parkingAble.park(car);
            }
        }
        throw new ParkingLotFullException();
    }

    public Car pick(String ticket) {
        return pickHelper.pick(ticket);
    }

}
